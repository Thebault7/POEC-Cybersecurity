package fr.bufalo.acme.controller;

import fr.bufalo.acme.bo.Category;
import fr.bufalo.acme.bo.Product;
import fr.bufalo.acme.bo.Status;
import fr.bufalo.acme.bo.Vat;
import fr.bufalo.acme.service.ProductManager;
import fr.bufalo.acme.utils.reference.ReferenceGeneratorInterface;
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

	@Autowired
	private ReferenceGeneratorInterface rg;

	// TODO dans les formulaires distinguer les champs null des champs incorrects/erreur de saisie
	// TODO signaler les champs required par étoile (html)

	private static final String VAT_PERCENT = "vat_percent";
	private static final String PRODUCT = "product";
	private static final String VAT = "vat";
	private static final String STATUS = "status";
	private static final String CATEGORY = "category";

	private static final String MANAGE_PRODUCT = "manageProducts";
	private static final String LIST_PRODUCT = "listProducts";
	private static final String ADD_PRODUCT = "addProduct";
	private static final String VIEW_PRODUCT = "viewProduct";
	private static final String MODIFY_PRODUCT = "modifyProduct";

	private static final String ERROR_MESSAGE = "errorMessage";


	@RequestMapping(path = "/" + MANAGE_PRODUCT, method = RequestMethod.GET)
	public ModelAndView goToManageProducts(ModelMap modelMap) {
		List<Product> listProducts = pm.findAll();
		ModelAndView mv = new ModelAndView(MANAGE_PRODUCT);
		mv.addObject(LIST_PRODUCT, listProducts);
		return mv;
	}

	@RequestMapping(path = "/" + ADD_PRODUCT, method = RequestMethod.GET)
	public ModelAndView goToAddProduct(ModelMap modelMap) {
		ModelAndView mv = new ModelAndView(ADD_PRODUCT, PRODUCT, new Product());
		mv.addObject(ERROR_MESSAGE, "");
		return mv;
	}

	@RequestMapping(path = "/" + VIEW_PRODUCT, method = RequestMethod.GET)
	public ModelAndView goToViewProduct(ModelMap modelMap, int productId) {
		Product product = pm.findById(productId);
		Vat vat = product.getVat();
		String vat_percent = floatToPercentageFormat(vat.getPercentage());
		Status status = product.getStatus();
		List<Category> categories = product.getCategories();
		ModelAndView mv = new ModelAndView(VIEW_PRODUCT);
		mv.addObject(PRODUCT, product);
		mv.addObject(VAT, vat);
		mv.addObject(VAT_PERCENT, vat_percent);
		mv.addObject(STATUS, status);
		mv.addObject(CATEGORY, categories);
		return mv;
	}

	@RequestMapping(path = "/" + MODIFY_PRODUCT, method = RequestMethod.GET)
	public ModelAndView goToModifyProduct(ModelMap modelMap, int productId) {
		Product product = pm.findById(productId);
		ModelAndView mv = new ModelAndView(MODIFY_PRODUCT);
		mv.addObject(PRODUCT, product);
		return mv;
	}

	public String floatToPercentageFormat(float percentage){
		return String.format("%5.1f%%", percentage*100);
	}

}
