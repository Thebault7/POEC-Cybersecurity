package fr.bufalo.acme.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.bufalo.acme.bo.Customer;
import fr.bufalo.acme.bo.Employee;
import fr.bufalo.acme.constant.ErrorConstant;
import fr.bufalo.acme.service.CustomerManager;
import fr.bufalo.acme.utils.reference.ReferenceGeneratorInterface;
import fr.bufalo.acme.utils.reference.ReferenceType;
import fr.bufalo.acme.utils.validation.StringValidationImpl;
import fr.bufalo.acme.utils.validation.StringValidationInterface;
import fr.bufalo.acme.utils.validation.ValidationType;

/**
 * @date Created 13/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Controller
public class CustomerController {

	@Autowired
	private CustomerManager cm;
	@Autowired
	private ReferenceGeneratorInterface rgi;
	
	private static final String INEXISTING_DATE_ERROR = ErrorConstant.INEXISTING_DATE.getErrorMessage();
	private static final String INVALID_CHARACTER_IN_ADDRESS_ERROR = ErrorConstant.INVALID_CHARACTER_IN_ADDRESS.getErrorMessage();
	private static final String INVALID_EMAIL_ERROR = ErrorConstant.INVALID_EMAIL.getErrorMessage();
	private static final String INVALID_CHARACTER_IN_FIRSTNAME_ERROR = ErrorConstant.INVALID_CHARACTER_IN_FIRSTNAME.getErrorMessage();
	private static final String INVALID_CHARACTER_IN_LASTNAME_ERROR = ErrorConstant.INVALID_CHARACTER_IN_LASTNAME.getErrorMessage();
	private static final String EMPTY_NAMES_ERROR = ErrorConstant.EMPTY_NAMES.getErrorMessage();
	private static final String INVALID_PHONE_NUMBER_ERROR = ErrorConstant.INVALID_PHONE_NUMBER.getErrorMessage();
	private static final String INVALID_BIRTHDATE_ERROR = ErrorConstant.INVALID_BIRTHDATE.getErrorMessage();
	private static final String BIRTHDATE_IN_FUTURE_ERROR = ErrorConstant.BIRTHDATE_IN_FUTURE.getErrorMessage();
	private static final String BIRTHDATE_TOO_FAR_IN_PAST_ERROR = ErrorConstant.BIRTHDATE_TOO_FAR_IN_PAST.getErrorMessage();
	
	private static final String SESSION_EMPLOYEE = "sessionEmployee";
	private static final String MANAGE_CUSTOMERS = "manageCustomers";
	private static final String LIST_CUSTOMERS = "listCustomers";
	private static final String ADD_CUSTOMER = "addCustomer";
	private static final String CUSTOMER = "customer";
	private static final String ERROR_MESSAGE = "errorMessage";
	private static final String EDIT_CUSTOMER = "editCustomer";
	private static final String MODIFY_CUSTOMER = "modifyCustomer";
	private static final String SEARCH_CUSTOMER = "searchCustomer";
	private static final String CHECK_ADD_CUSTOMER = "checkAddCustomer";

	@RequestMapping(path = "/" + MANAGE_CUSTOMERS, method = RequestMethod.GET)
	public ModelAndView goToManageCustomers(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute(SESSION_EMPLOYEE);
		return new ModelAndView(MANAGE_CUSTOMERS, LIST_CUSTOMERS, employee.getListCustomer());
	}

	@RequestMapping(path = "/" + ADD_CUSTOMER, method = RequestMethod.GET)
	public ModelAndView goToAddCustomers(ModelMap modelMap) {
		Customer customer = new Customer();
		customer.setReference(rgi.generateReference(ReferenceType.CUSTOMER));
		ModelAndView mav = new ModelAndView(ADD_CUSTOMER, CUSTOMER, customer);
		mav.addObject(ERROR_MESSAGE, "");
		return mav;
	}

	@RequestMapping(path = "/" + CHECK_ADD_CUSTOMER, method = RequestMethod.POST)
	public ModelAndView checkAddCustomer(Customer customer, String birthdateValue,
			RedirectAttributes redirectAttribute) {
		/*
		 * Problem of mismatch between the birthdate in the jsp and the Customer bean.
		 * To solve it, the birthdate is sent separately in the url and then rejoined
		 * with the customer hereafter:
		 */
		if (birthdateValue != null) {
			try {
				LocalDate ld = LocalDate.parse(birthdateValue);
				customer.setBirthdate(ld);
			} catch (DateTimeParseException e) {
				return new ModelAndView(ADD_CUSTOMER, ERROR_MESSAGE, INEXISTING_DATE_ERROR);
			}
		}
		String errorMessage = "";
		/*
		 * First step consists in checking if customer data are valid or not
		 */
		boolean isValid = true;
		StringValidationInterface svi = new StringValidationImpl();
		if (!svi.validationString(customer.getAddressLine1(), ValidationType.ADDRESS)) {
			isValid = false;
			errorMessage += INVALID_CHARACTER_IN_ADDRESS_ERROR;
		}
		if (!svi.validationString(customer.getEmail(), ValidationType.EMAIL)) {
			isValid = false;
			errorMessage += INVALID_EMAIL_ERROR;
		}
		if (customer.getFirstName() != null && customer.getLastName() != null) {
			if (!svi.validationString(customer.getFirstName(), ValidationType.NAME)) {
				isValid = false;
				errorMessage += INVALID_CHARACTER_IN_FIRSTNAME_ERROR;
			}
			if (!svi.validationString(customer.getLastName(), ValidationType.NAME)) {
				isValid = false;
				errorMessage += INVALID_CHARACTER_IN_LASTNAME_ERROR;
			}
		} else {
			isValid = false;
			errorMessage += EMPTY_NAMES_ERROR;
		}
		if (customer.getPhoneNumber() != null) {
			if (!svi.validationString(customer.getPhoneNumber(), ValidationType.PHONE_NUMBER)) {
				isValid = false;
				errorMessage += INVALID_PHONE_NUMBER_ERROR;
			}
		}
		if (customer.getBirthdate() != null) {
			if (!svi.validationString(customer.getBirthdate().toString(), ValidationType.DATE)) {
				isValid = false;
				errorMessage += INVALID_BIRTHDATE_ERROR;
			}
			if (customer.getBirthdate().compareTo(LocalDate.now()) >= 0) {
				isValid = false;
				errorMessage += BIRTHDATE_IN_FUTURE_ERROR;
			}
			if (customer.getBirthdate().compareTo(LocalDate.now().plusYears(-130)) <= 0) {
				isValid = false;
				errorMessage += BIRTHDATE_TOO_FAR_IN_PAST_ERROR;
			}
		}
		if (!isValid) {
			ModelAndView mav = new ModelAndView(ADD_CUSTOMER, ERROR_MESSAGE, errorMessage);
			mav.addObject(CUSTOMER, customer);
			return mav;
		}
		/*
		 * Second step consists in persisting the new customer into the database.
		 */
		// TODO
		return new ModelAndView("redirect:/" + MANAGE_CUSTOMERS);
	}

	@RequestMapping(path = "/" + SEARCH_CUSTOMER, method = RequestMethod.GET)
	public ModelAndView goToSearchCustomers(ModelMap modelMap, int customerId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(EDIT_CUSTOMER, CUSTOMER, cm.findById(customerId));
		return mav;
	}

	@RequestMapping(path = "/" + MODIFY_CUSTOMER, method = RequestMethod.GET)
	public ModelAndView goToModifyCustomer(ModelMap modelMap, int customerId) {
		Customer customer = cm.findById(customerId);
		ModelAndView mav = new ModelAndView(MODIFY_CUSTOMER, CUSTOMER, customer);
		return mav;
	}
}
