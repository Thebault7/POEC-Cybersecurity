package fr.bufalo.acme.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.bufalo.acme.bo.Employee;
import fr.bufalo.acme.service.EmployeeManager;
import fr.bufalo.acme.utils.hashing.WordHashGenerator;
import fr.bufalo.acme.utils.hashing.WordHashGeneratorInterface;
import fr.bufalo.acme.utils.validation.StringValidationImpl;
import fr.bufalo.acme.utils.validation.StringValidationInterface;
import fr.bufalo.acme.utils.validation.ValidationType;

/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version 1.0
 * 
 */
@Controller
public class LoginController {

	@Autowired
	private EmployeeManager em;

	private static final String HASH_METHOD = "SHA-512";
	private static final String MESSAGE_INVALID_CONNECTION = "Identifier or password invalid";
	private static final String MESSAGE_INVALID_HASHING = "Error in the hashing configuration";

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView goToLoginPage(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("login", "Employee", new Employee());
		return mav;
	}

	@RequestMapping(path = "/checkLogin", method = RequestMethod.POST)
	public ModelAndView checkUserPassword(Employee employee, RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		String errorMessage = "";
		ModelAndView mav = new ModelAndView("login");
		HttpSession session = request.getSession();

		/*
		 * The reference and password given by the user are checked for validity. If one
		 * or the other fail the validation, an error message is showed.
		 */
		StringValidationInterface svi = new StringValidationImpl();
		if (!svi.validationString(employee.getReference(), ValidationType.REFERENCE)
				|| !svi.validationString(employee.getPassword(), ValidationType.PASSWORD)) {
			mav.addObject("errorMessage", MESSAGE_INVALID_CONNECTION);
			employee.setPassword(""); // password is cleared before sending back the employee.
										// The reference is still there.
			mav.addObject("Employee", employee);
			return mav;
		}

		/*
		 * Once the reference and the password look valid, they have to be compared with
		 * the database. Prior the password also needs to be salted and hashed. First,
		 * the salt is retrieved from the database.
		 */
		Employee employeeFromDB = em.findOneByReference(employee.getReference());
		String saltedPassword = employeeFromDB.getPasswordSalt() + employee.getPassword();
		WordHashGeneratorInterface whgi = new WordHashGenerator();
		try {
			String hashedPassword = whgi.generateHash(saltedPassword, HASH_METHOD);
			if (hashedPassword.equals(employeeFromDB.getPassword())) {
				session.setAttribute("sessionEmployee", employeeFromDB);
				return new ModelAndView("statPage");
			}
		} catch (NoSuchAlgorithmException e) {
			// error message if HASH_METHOD does not correspond to any hashing method
			errorMessage += MESSAGE_INVALID_HASHING;
			mav.addObject("errorMessage", errorMessage);
			employee.setPassword("");
			mav.addObject("Employee", employee);
			e.printStackTrace();
			return mav;
		}

		/*
		 * When an employee enters valid credentials, that do not match any account in
		 * the database.
		 */
		employee.setPassword("");
		mav.addObject("Employee", employee);
		errorMessage += MESSAGE_INVALID_CONNECTION;
		mav.addObject("errorMessage", errorMessage);
		return mav;
	}
}
