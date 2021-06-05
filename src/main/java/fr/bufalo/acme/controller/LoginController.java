package fr.bufalo.acme.controller;

import java.security.NoSuchAlgorithmException;

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
import fr.bufalo.acme.constant.ErrorConstant;
import fr.bufalo.acme.constant.ParameterConstant;
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
	@Autowired
	private StatisticController sc;

	private static final String MESSAGE_INVALID_CONNECTION_ERROR = ErrorConstant.INVALID_CONNECTION.getErrorMessage();
	private static final String MESSAGE_INVALID_HASHING_ERROR = ErrorConstant.INVALID_HASHING.getErrorMessage();

	private static final String HASH_METHOD = "SHA-512";
	private static final String LOGIN = "login";
	private static final String CHECK_LOGIN = "checkLogin";
	private static final String EMPLOYEE = ParameterConstant.EMPLOYEE.getParameterName();
	private static final String ERROR_MESSAGE = ParameterConstant.ERROR_MESSAGE.getParameterName();
	private static final String SESSION_EMPLOYEE = ParameterConstant.SESSION_EMPLOYEE.getParameterName();
	private static final String STAT_PAGE = ParameterConstant.STAT_PAGE.getParameterName();

	@RequestMapping(path = "/" + LOGIN, method = RequestMethod.GET)
	public ModelAndView goToLoginPage(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView(LOGIN, EMPLOYEE, new Employee());
		return mav;
	}

	@RequestMapping(path = "/" + CHECK_LOGIN, method = RequestMethod.POST)
	public ModelAndView checkUserPassword(Employee employee, HttpServletRequest request) {
		/*
		 * The reference and password given by the user are checked for validity. If one
		 * or the other fail the validation, an error message is showed.
		 */
		ModelAndView mav = new ModelAndView(LOGIN);
		StringValidationInterface svi = new StringValidationImpl();
		if (!svi.validationString(employee.getReference(), ValidationType.REFERENCE)
				|| !svi.validationString(employee.getPassword(), ValidationType.PASSWORD)) {
			mav.addObject(ERROR_MESSAGE, MESSAGE_INVALID_CONNECTION_ERROR);
			employee.setPassword(""); // password is cleared before sending back the employee.
										// The reference is still there.
			mav.addObject(EMPLOYEE, employee);
			return mav;
		}

		/*
		 * Once the reference and the password look valid, they have to be compared with
		 * the database. Prior the password also needs to be salted and hashed. First,
		 * the salt is retrieved from the database.
		 */
		Employee employeeFromDB = em.findOneByReference(employee.getReference());
		String saltedPassword = employeeFromDB.getPasswordSalt() + employee.getPassword();
		String errorMessage = "";
		WordHashGeneratorInterface whgi = new WordHashGenerator();
		try {
			String hashedPassword = whgi.generateHash(saltedPassword, HASH_METHOD);
			if (hashedPassword.equals(employeeFromDB.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute(SESSION_EMPLOYEE, employeeFromDB);
				return sc.goToStatPage(new ModelMap(),request);
			}
		} catch (NoSuchAlgorithmException e) {
			// error message if HASH_METHOD does not correspond to any hashing method
			errorMessage += MESSAGE_INVALID_HASHING_ERROR;
			mav.addObject(ERROR_MESSAGE, errorMessage);
			employee.setPassword("");
			mav.addObject(EMPLOYEE, employee);
			e.printStackTrace();
			return mav;
		}

		/*
		 * When an employee enters valid credentials, that do not match any account in
		 * the database.
		 */
		employee.setPassword("");
		mav.addObject(EMPLOYEE, employee);
		errorMessage += MESSAGE_INVALID_CONNECTION_ERROR;
		mav.addObject(ERROR_MESSAGE, errorMessage);
		return mav;
	}
}
