package fr.bufalo.acme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
	
	@RequestMapping(path = "/addCustomer", method = RequestMethod.GET)
	public ModelAndView goToAddCustomers(ModelMap modelMap) {
		Customer customer = new Customer();
		ModelAndView mav = new ModelAndView("addCustomer", "customer", customer);
		return mav;
	}
	
	@RequestMapping(path = "/checkAddCustomer", method = RequestMethod.POST)
	public RedirectView checkAddCustomer(Customer customer, RedirectAttributes redirectAttribute) {
		// TODO vérifications sur les données fournies puis faire la sauvegarde en base de données
		redirectAttribute.addFlashAttribute("customer", customer);
		return new RedirectView("manageCustomers");
	}
	
	@RequestMapping(path = "/searchCustomer", method = RequestMethod.GET)
	public ModelAndView goToSearchCustomers(ModelMap modelMap, int customerId) {
		//TODO aller chercher en base de données le client qui correspond à customerId
		ModelAndView mav = new ModelAndView("editCustomer", "customer", cm.findById(customerId));
		System.out.println(cm.findById(customerId) + "   <-----------------------------");
		return mav;
	}
}
