package fr.bufalo.acme.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import fr.bufalo.acme.bo.Employee;
import fr.bufalo.acme.service.EmployeeManager;

/**
 * @date Created 12/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Component
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
	public RedirectView checkUserPassword(Employee employee, RedirectAttributes redirectAttribute) {
		/* TODO 0) vérifier les données fournies par l'utilisateur
		 * 		1) aller chercher en base de données un employé dont l'email correspond à celui fournit
		 * 		2) hasher le mot de passe combiné au sel récupéré
		 * 		3) comparer le mot de passe hashé avec celui que l'on a extrait de la base de données
		 * 		4) si le mot de passe correspond, on passe à la page suivante.
		 * sinon, on reste sur cette page avec un message d'erreur
		*/
		redirectAttribute.addFlashAttribute("Employee", employee);
		return new RedirectView("validateLogin");
	}
	
	@RequestMapping(path = "/validateLogin", method = RequestMethod.GET)
	public ModelAndView validateUserPassword(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("statPage");
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (!CollectionUtils.isEmpty(flashMap)) {
			Employee employee = (Employee) flashMap.get("Employee");
		}
		//TODO mettre l'employé dans le contexte de session
		return mav;
	}
}
