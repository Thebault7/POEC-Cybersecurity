package fr.bufalo.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.bufalo.acme.bo.Employee;
import fr.bufalo.acme.service.EmployeeManager;

/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Controller
public class LoginController {

	@Autowired(required = false)
	private EmployeeManager em;
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView goToLoginPage(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("login", "Employee", new Employee());
		return mav;
	}

	@RequestMapping(path = "/checkLogin", method = RequestMethod.POST)
	public ModelAndView checkUserPassword(Employee employee) {
		employee = em.addEmployee(employee);
		ModelAndView mav = new ModelAndView("login", "SavedEmployee", employee);
		mav.addObject("Employee", new Employee());
		return mav;
	}
}
