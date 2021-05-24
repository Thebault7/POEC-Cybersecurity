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
import fr.bufalo.acme.service.CustomerManager;
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

	@RequestMapping(path = "/manageCustomers", method = RequestMethod.GET)
	public ModelAndView goToManageCustomers(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("sessionEmployee");
		return new ModelAndView("manageCustomers", "listCustomers", employee.getListCustomer());
	}

	@RequestMapping(path = "/addCustomer", method = RequestMethod.GET)
	public ModelAndView goToAddCustomers(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("addCustomer", "customer", new Customer());
		mav.addObject("errorMessage", "");
		return mav;
	}

	@RequestMapping(path = "/checkAddCustomer", method = RequestMethod.POST)
	public ModelAndView checkAddCustomer(Customer customer, String birthdateValue, RedirectAttributes redirectAttribute) {
		/*
		 * Problem of mismatch between the birthdate in the jsp and the Customer bean.
		 * To solve it, the birthdate is sent separately in the url and
		 * then rejoined with the customer hereafter:
		 */
		try {
			LocalDate ld = LocalDate.parse(birthdateValue);
			customer.setBirthdate(ld);
		} catch (DateTimeParseException e) {
			return new ModelAndView("addCustomer", "errorMessage", "- The birthdate format is invalid<br>");
		}
		String errorMessage = "";
		/*
		 * First step consists in checking if customer data are valid or not
		 */
		boolean isValid = true;
		StringValidationInterface svi = new StringValidationImpl();
		if (!svi.validationString(customer.getAddressLine1(), ValidationType.ADDRESS)) {
			isValid = false;
			errorMessage += "- The address writen contains invalid characters<br>";
		}
		if (!svi.validationString(customer.getEmail(), ValidationType.EMAIL)) {
			isValid = false;
			errorMessage += "- The email writen is not valid<br>";
		}
		if (!svi.validationString(customer.getFirstName(), ValidationType.NAME)) {
			isValid = false;
			errorMessage += "- The firstname writen contains invalid characters<br>";
		}
		if (!svi.validationString(customer.getLastName(), ValidationType.NAME)) {
			isValid = false;
			errorMessage += "- The lastname writen contains invalid characters<br>";
		}
		if (!svi.validationString(customer.getPhoneNumber(), ValidationType.PHONE_NUMBER)) {
			isValid = false;
			errorMessage += "- The phone number is not valid<br>";
		}
		if (!svi.validationString(customer.getBirthdate().toString(), ValidationType.DATE)) {
			isValid = false;
			errorMessage += "- The birthdate is not valid<br>";
		}
		if (customer.getBirthdate().compareTo(LocalDate.now()) >= 0) {
			isValid = false;
			errorMessage += "- The birthdate cannot be in the future<br>";
		}
		if (customer.getBirthdate().compareTo(LocalDate.now().plusYears(-130)) <= 0) {
			isValid = false;
			errorMessage += "- The birthdate cannot be more than 130 years in the past<br>";
		}
		if (!isValid) {
			ModelAndView mav = new ModelAndView("addCustomer", "errorMessage", errorMessage);
			mav.addObject("customer", customer);
			return mav;
		}
		return new ModelAndView("redirect:/manageCustomers");
	}

	@RequestMapping(path = "/searchCustomer", method = RequestMethod.GET)
	public ModelAndView goToSearchCustomers(ModelMap modelMap, int customerId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("editCustomer", "customer", cm.findById(customerId));
		return mav;
	}

	@RequestMapping(path = "/modifyCustomer", method = RequestMethod.GET)
	public ModelAndView goToModifyCustomer(ModelMap modelMap, int customerId) {
		Customer customer = cm.findById(customerId);
		ModelAndView mav = new ModelAndView("modifyCustomer", "customer", customer);
		return mav;
	}
}
