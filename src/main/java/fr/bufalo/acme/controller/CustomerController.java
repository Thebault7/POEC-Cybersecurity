package fr.bufalo.acme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.bufalo.acme.bo.Customer;
import fr.bufalo.acme.service.CustomerManager;

/**
 * @date Created 13/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Component
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerManager cm;

	@RequestMapping(path = "/manageCustomers", method = RequestMethod.GET)
	public ModelAndView goToManageCustomers(ModelMap modelMap) {
		//TODO extraire l'id de l'employé de la session
		int employeeId = 1;
		List<Customer> listCust = cm.findAllByEmployee(employeeId);
		return new ModelAndView("manageCustomers", "listCustomers", listCust);
	}
}
