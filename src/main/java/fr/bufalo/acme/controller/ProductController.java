package fr.bufalo.acme.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @date Created 13/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Component
@Controller
public class ProductController {

	@RequestMapping(path = "/manageProducts", method = RequestMethod.GET)
	public void goToManageProducts(ModelMap modelMap) {
	}
}
