package fr.bufalo.acme.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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
@SessionAttributes("sessionEmployee")
public class LoginController {

	@Autowired
	private EmployeeManager em;

	private static final String HASH_METHOD = "SHA512";

	@ModelAttribute("sessionEmployee")
	public Employee sessionEmployee() {
		Employee emp = new Employee();
		return emp;
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView goToLoginPage(ModelMap modelMap, Model model,
			@ModelAttribute("sessionEmployee") Employee employee) {
		ModelAndView mav = new ModelAndView("login", "Employee", employee);
		return mav;
	}

	@RequestMapping(path = "/checkLogin", method = RequestMethod.POST)
	public ModelAndView checkUserPassword(Employee employee, Model model) {
		String errorMessage = "";
		ModelAndView mav = new ModelAndView("login");

		/*
		 * The reference and password given by the user are validated. If one or the
		 * other fail the validation, an error message is showed.
		 */
		boolean isNotValid = false;
		StringValidationInterface svi = new StringValidationImpl();
		if (!svi.validationString(employee.getReference(), ValidationType.REFERENCE)) {
			errorMessage += "- The reference only contains alphanumerical characters.<br>";
			isNotValid = true;
		}
		if (!svi.validationString(employee.getPassword(), ValidationType.PASSWORD)) {
			errorMessage += "- Password must be at least 8 characters long, with alphanumerical characters or punctuation";
			isNotValid = true;
		}
		if (isNotValid) {
			mav.addObject("errorMessage", errorMessage);
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
		List<Employee> listEmployees = em.findAllByReference(employee.getReference());

		for (int i = 0; i < listEmployees.size(); i++) {
			String saltedPassword = listEmployees.get(i).getPasswordSalt() + employee.getPassword();
			WordHashGeneratorInterface whgi = new WordHashGenerator();
			try {
				String hashedPassword = whgi.generateHash(saltedPassword, HASH_METHOD);
				if (hashedPassword.equals(listEmployees.get(i).getPassword())) {
					model.addAttribute("sessionEmployee", employee);
					return new ModelAndView("statPage");
				}
			} catch (NoSuchAlgorithmException e) {
				// error message if HASH_METHOD does not correspond to any hashing method
				errorMessage += "Error in the hashing configuration";
				mav.addObject("errorMessage", errorMessage);
				employee.setPassword("");
				mav.addObject("Employee", employee);
				e.printStackTrace();
				return mav;
			}
		}

		/*
		 * When an employee enters valid credentials, that do not match any account in
		 * the database.
		 */
		employee.setPassword("");
		mav.addObject("Employee", employee);
		errorMessage += "No account was found";
		mav.addObject("errorMessage", errorMessage);
		return mav;
	}
}
