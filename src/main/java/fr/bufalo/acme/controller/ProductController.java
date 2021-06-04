package fr.bufalo.acme.controller;

import com.sun.xml.bind.v2.TODO;
import fr.bufalo.acme.bo.*;
import fr.bufalo.acme.service.CategoryManager;
import fr.bufalo.acme.service.ProductManager;
import fr.bufalo.acme.service.StatusManager;
import fr.bufalo.acme.service.VatManager;
import fr.bufalo.acme.utils.reference.ReferenceGeneratorInterface;
import fr.bufalo.acme.utils.reference.ReferenceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
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
	private VatManager vm;

	@Autowired
	private StatusManager sm;

	@Autowired
	private CategoryManager cm;

	@Autowired
	private ReferenceGeneratorInterface rg;

	private static final String VAT_PERCENT = "vat_percent";
	private static final String PRODUCT = "product";
	private static final String VAT = "vat";
	private static final String STATUS = "status";
	private static final String CATEGORIES = "categories";
	private static final int ARCHIVED_STATUS_ID = 3;

	private static final String MANAGE_PRODUCT = "manageProducts";
	private static final String LIST_PRODUCT = "listProducts";
	private static final String LIST_VAT = "listVats";
	private static final String LIST_STATUS = "listStatuses";
	private static final String LIST_CATEGORY = "listCategories";
	private static final String VIEW_PRODUCT = "viewProduct";
	private static final String ADD_PRODUCT = "addProduct";
	private static final String CHECK_ADD_PRODUCT = "checkAddProduct";
	private static final String MODIFY_PRODUCT = "modifyProduct";
	private static final String CHECK_MODIFY_PRODUCT = "checkModifyProduct";
	private static final String ARCHIVE_PRODUCT = "archiveProduct";

	private static final String ERROR_MESSAGE = "errorMessage";


	@RequestMapping(path = "/" + MANAGE_PRODUCT, method = RequestMethod.GET)
	public ModelAndView goToManageProducts(ModelMap modelMap) {
		// get product which are not archived
		Status statusArchived = sm.findById(ARCHIVED_STATUS_ID);
		List<Product> listProducts = pm.findByStatusNot(statusArchived);
		ModelAndView mv = new ModelAndView(MANAGE_PRODUCT);
		mv.addObject(LIST_PRODUCT, listProducts);
		return mv;
	}


	@RequestMapping(path = "/" + VIEW_PRODUCT, method = RequestMethod.GET)
	public ModelAndView goToViewProduct(ModelMap modelMap, int productId) {
		return getModelAndView(productId, VIEW_PRODUCT);
	}


	// TODO dans les formulaires distinguer les champs null des champs incorrects/erreur de saisie (ADD et VIEW)

	@RequestMapping(path = "/" + ADD_PRODUCT, method = RequestMethod.GET)
	public ModelAndView goToAddProduct(ModelMap modelMap) {

		Product product = new Product();
		product.setReference(rg.generateReference(ReferenceType.PRODUCT));

		List<Vat> listVats = vm.findAll();
//		List<Status> listStatuses = sm.findAll();
		List<Status> listStatuses = sm.findByIdNot(ARCHIVED_STATUS_ID);
		List<Category> listCategories = cm.findAll();


		ModelAndView mv = new ModelAndView(ADD_PRODUCT, PRODUCT, product);

		mv.addObject(LIST_VAT, listVats);
		mv.addObject(LIST_STATUS, listStatuses);
		mv.addObject(LIST_CATEGORY, listCategories);

		return mv;
	}


	@RequestMapping(path = "/" + CHECK_ADD_PRODUCT, method = RequestMethod.POST)
	public ModelAndView checkAddProduct(Product product) {
		/*
		 * First step consists in checking if product data are valid or not
		 */

		/*
		 * Second step consists in persisting the new product into the database. If the
		 * save fails, it returns to the addProduct page with an error message about
		 * the failure. If the save succeeds, it shows the newly added product.
		 */

		try {
			product.setStatus(sm.findById(product.getStatusId()));
			product.setVat(vm.findById(product.getVatId()));
			product.setCategories(new ArrayList<>());
			if(product.getCategoriesId() != null){
				for (int categoryId:product.getCategoriesId()) {
					product.getCategories().add(cm.findById(categoryId));
				}
			}
			Product savedProduct = pm.save(product);
			return getModelAndView(savedProduct.getId(), VIEW_PRODUCT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView(ADD_PRODUCT, PRODUCT, product);
		}
	}


	@RequestMapping(path = "/" + MODIFY_PRODUCT, method = RequestMethod.GET)
	public ModelAndView goToModifyProduct(ModelMap modelMap, int productId) {
		return getModelAndView(productId, MODIFY_PRODUCT);
	}


	@RequestMapping(path = "/" + CHECK_MODIFY_PRODUCT, method = RequestMethod.POST)
	public ModelAndView checkModifyProduct(Product product) {
		/*
		 * First step consists in checking if product data are valid or not
		 */

		/*
		 * Second step consists in persisting the product into the database. If the
		 * save fails, it returns to the modifyProduct page with an error message about
		 * the failure. If the save succeeds, it shows the newly modified product.
		 */

		try {
			product.setStatus(sm.findById(product.getStatusId()));
			product.setVat(vm.findById(product.getVatId()));
			product.setCategories(new ArrayList<>());
			for (int categoryId:product.getCategoriesId()) {
				product.getCategories().add(cm.findById(categoryId));
			}

			Product savedProduct = pm.save(product);

//			TODO si status archivé => message warning

			Status statusArchived = sm.findById(ARCHIVED_STATUS_ID);
			if(statusArchived.getId() == product.getStatus().getId()){
				return goToManageProducts(new ModelMap());
			}
			return getModelAndView(savedProduct.getId(), VIEW_PRODUCT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView(MODIFY_PRODUCT, PRODUCT, product);
		}
	}


	@RequestMapping(path = "/" + ARCHIVE_PRODUCT, method = RequestMethod.GET)
	public ModelAndView goArchiveProduct(ModelMap modelMap, int productId) {
		Product product = pm.findById(productId);
		Status statusArchived = sm.findById(ARCHIVED_STATUS_ID);
		product.setStatus(statusArchived);

		pm.save(product);

		return goToManageProducts(new ModelMap());
	}


	private ModelAndView getModelAndView(int productId, String viewProduct) {

		Product product = pm.findById(productId);
		Vat vat = product.getVat();
		String vat_percent = floatToPercentageFormat(vat.getPercentage());
		Status status = product.getStatus();
		List<Category> categories = product.getCategories();

		List<Vat> listVats = vm.findAll();
		List<Status> listStatuses = sm.findAll();
		List<Category> listCategories = cm.findAll();

		ModelAndView mv = new ModelAndView(viewProduct);

		mv.addObject(PRODUCT, product);
		mv.addObject(VAT, vat);
		mv.addObject(VAT_PERCENT, vat_percent);
		mv.addObject(STATUS, status);
		mv.addObject(CATEGORIES, categories);
		mv.addObject(LIST_VAT, listVats);
		mv.addObject(LIST_STATUS, listStatuses);
		mv.addObject(LIST_CATEGORY, listCategories);

		mv.addObject(ERROR_MESSAGE, "");

		return mv;
	}

	public String floatToPercentageFormat(float percentage){
		return String.format("%5.1f%%", percentage*100);
	}

}
