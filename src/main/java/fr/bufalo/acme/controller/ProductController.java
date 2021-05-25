package fr.bufalo.acme.controller;

import fr.bufalo.acme.bo.Product;
import fr.bufalo.acme.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @date Created 13/05/2021
 * @author Frederic Thebault / Linh Chi Nguyen
 * @version 1.0
 *
 */

@Controller
public class ProductController {

	@Autowired
	private ProductManager pm;

//	@RequestMapping(path = "/manageProducts", method = RequestMethod.GET)
//	public void goToManageProducts(ModelMap modelMap) {
//	}

	@RequestMapping(path = "/manageProducts", method = RequestMethod.GET)
	public ModelAndView goToManageProducts(ModelMap modelMap) {
		List<Product> listProducts = pm.findAll();
		ModelAndView mv = new ModelAndView("manageProducts");
		mv.addObject("listProducts", listProducts);
		return mv;
	}

	@RequestMapping(path = "/addProduct", method = RequestMethod.GET)
	public ModelAndView goToAddProduct(ModelMap modelMap) {
		ModelAndView mv = new ModelAndView("addProduct", "product", new Product());
		mv.addObject("errorMessage", "");
		return mv;
	}

	@RequestMapping(path = "/viewProduct", method = RequestMethod.GET)
	public ModelAndView goToViewProduct(ModelMap modelMap, int productId) {
		Product product = pm.findById(productId);
		ModelAndView mv = new ModelAndView("viewProduct");
		mv.addObject("product", product);
		return mv;
	}

	@RequestMapping(path = "/modifyProduct", method = RequestMethod.GET)
	public ModelAndView goToModifyProduct(ModelMap modelMap, int productId) {
		Product product = pm.findById(productId);
		ModelAndView mv = new ModelAndView("modifyProduct");
		mv.addObject("product", product);
		return mv;
	}

}
