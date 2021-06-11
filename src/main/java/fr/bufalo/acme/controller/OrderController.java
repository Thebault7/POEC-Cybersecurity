package fr.bufalo.acme.controller;

import fr.bufalo.acme.bo.*;
import fr.bufalo.acme.service.*;
import fr.bufalo.acme.utils.encrypt.Encrypt;
import fr.bufalo.acme.utils.reference.ReferenceGeneratorInterface;
import fr.bufalo.acme.utils.reference.ReferenceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.*;

/**
 * @date Created 13/05/2021
 * @author Frederic Thebault / Benjamin LAMBERT / Linh Chi NGUYEN
 * @version 1.0
 *
 */
@Component
@Controller
public class OrderController {
	@Autowired
	private OrderManager om;

	@Autowired
	private CustomerManager cm;

	@Autowired
	private CityManager ctm;

	@Autowired
	private ProductManager pm;

	@Autowired
	private StatusManager sm;

	@Autowired
	private SoldProductManager spm;

	@Autowired
	private ReferenceGeneratorInterface rg;

	private static final String SESSION_EMPLOYEE = "sessionEmployee";
	private static final String LIST_CUSTOMER = "listCustomers";
	private static final String LIST_PRODUCT = "listProducts";
	private static final String SOLD_PRODUCTS = "soldProducts";
	private static final String ORDER_TOTAL_PRICE = "orderTotalPriceDisplay";
	private static final String ORDER = "order";
	private static final String CUSTOMER = "customer";
	private static final String CITY = "city";
	private static final String COUNTRY = "country";
	private static final int ARCHIVED_PRODUCT_STATUS_ID = 3;

	private static final String MANAGE_ORDERS = "manageOrders";
	private static final String LIST_ORDERS = "listOrders";
	private static final String VIEW_ORDER = "viewOrder";
	private static final String ADD_ORDER = "addOrder";
	private static final String CHECK_ADD_ORDER = "checkAddOrder";
	private static final String VALIDATE_ORDER = "validateOrder";
	private static final String GET_SOLD_PRODUCT = "getSoldProduct";


	@RequestMapping(path = "/" + MANAGE_ORDERS, method = RequestMethod.GET)
	public ModelAndView goToManageOrders(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute(SESSION_EMPLOYEE);
		List<Order> listOrders = om.findAllOrders(employee.getId());

		// decrypt Customer content in Order
		List<Order> decryptedOrders = new ArrayList<>();
		List<Customer> decryptedCustomers = new ArrayList<>();
		for (Order order:listOrders) {
			Customer customer = order.getCustomer();
			if (!decryptedCustomers.contains(customer)){
				Encrypt encrypt = new Encrypt();
				customer = encrypt.decryptCustomer(customer);
				order.setCustomer(customer);
				decryptedOrders.add(order);
				decryptedCustomers.add(customer);
			}
			else{
				decryptedOrders.add(order);
			}
		}
		listOrders.clear();
		listOrders.addAll(decryptedOrders);

		return new ModelAndView(MANAGE_ORDERS, LIST_ORDERS, listOrders);
	}

	@RequestMapping(path = "/" + VIEW_ORDER, method = RequestMethod.GET)
	public ModelAndView goToViewOrder(ModelMap modelMap, int orderId) {
		Order order = om.findById(orderId);
		List<SoldProduct> soldProducts = order.getListSoldProduct();
		double orderTotalPrice = 0;
		for (SoldProduct sp:soldProducts) {
			orderTotalPrice += sp.getTotalInclTaxes();
		}
		String orderTotalPriceDisplay = String.format("%10.2f", orderTotalPrice);

		// decrypt Customer content
		Customer customer = cm.findById(order.getCustomer().getId());
		Encrypt encrypt = new Encrypt();
		customer = encrypt.decryptCustomer(customer);

		City city = ctm.findOneById(customer.getCityId());
		CountryEnum country = city.getCountryEnum();

		ModelAndView mv = new ModelAndView(VIEW_ORDER);
		mv.addObject(ORDER, order);
		mv.addObject(SOLD_PRODUCTS, soldProducts);
		mv.addObject(ORDER_TOTAL_PRICE, orderTotalPriceDisplay);
		mv.addObject(CUSTOMER, customer);
		mv.addObject(CITY, city);
		mv.addObject(COUNTRY, country);
		return mv;
	}

	@RequestMapping(path = "/" + ADD_ORDER, method = RequestMethod.GET)
	public ModelAndView goToAddOrder(ModelMap modelMap) {

		Order order = new Order();
		order.setReference(rg.generateReference(ReferenceType.ORDER));

		// decrypt Customer content
		List<Customer> listCustomers = cm.findAll();
		List<Customer> decryptedCustomers = new ArrayList<>();
		for (Customer customer:listCustomers) {
			Encrypt encrypt = new Encrypt();
			customer = encrypt.decryptCustomer(customer);
			decryptedCustomers.add(customer);
		}
		listCustomers.clear();
		listCustomers.addAll(decryptedCustomers);

		Status statusArchived = sm.findById(ARCHIVED_PRODUCT_STATUS_ID);
		List<Product> listProducts = pm.findByStatusNot(statusArchived);

		ModelAndView mv = new ModelAndView(ADD_ORDER, ORDER, order);

		mv.addObject(LIST_CUSTOMER, listCustomers);
		mv.addObject(LIST_PRODUCT, listProducts);

		return mv;
	}

	/**
	 * check info from addOrderForm.jsp and save Order and SoldProducts
	 */
	@RequestMapping(path = "/" + CHECK_ADD_ORDER, method = RequestMethod.POST)
	public ModelAndView checkAddOrder(Order order, HttpServletRequest request) {
		try {
			// by default status is not validated
			order.setIsValidated(false);
			order.setCreationDate(LocalDate.now());

			Customer customer = cm.findById(order.getCustomerId());
			order.setCustomer(customer);

			List<SoldProduct> savedSoldProducts = new ArrayList<>();

			Enumeration<String> names = request.getParameterNames();	// list of parameters from addOrder.jsp

			Object value = request.getParameterValues("productId_0");

			// get number of rows in table
			int tableSize = 0;
			for (String key : Collections.list(names)) {
				if (key.startsWith("productId_")) {
					tableSize ++;
				}
			}

			// save one SoldProduct per row
			for (int i = 0; i < tableSize; i++) {
				SoldProduct sp = new SoldProduct();
				Product product = pm.findById(Integer.parseInt(request.getParameterValues("productId_" + i)[0]));
				sp.setProduct(product);
				sp.setQuantity(Integer.parseInt(request.getParameterValues("quantity_" + i)[0]));
				sp.setPrice(product.getPrice());
				sp.setVat(product.getVat().getPercentage());
				sp = spm.save(sp);
				savedSoldProducts.add(sp);
			}

			// set soldproducts in order
			order.setListSoldProduct(savedSoldProducts);
			Order savedOrder = om.save(order);

			// set order in soldproduct
			for (SoldProduct sp :savedSoldProducts) {
				sp.setOrder(order);
				spm.save(sp);
			}

			return goToViewOrder(new ModelMap(), savedOrder.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView(ADD_ORDER, ORDER, order);
		}
	}

	/**
	 * Change isValidated value to true and set validationDate.
	 */
	@RequestMapping(path = "/" + VALIDATE_ORDER, method = RequestMethod.GET)
	public ModelAndView validateOrder(ModelMap modelMap, int orderId) {
		Order order = om.findById(orderId);
		order.setIsValidated(true);
		order.setValidationDate(LocalDate.now());
		om.save(order);
		return goToViewOrder(modelMap, orderId);
	}

	@RequestMapping(path = "/" + GET_SOLD_PRODUCT, method = RequestMethod.GET)
	public ModelAndView getSoldProduct(ModelMap modelMap, int productId) {
		Product product = pm.findById(productId);
		Map<String, Object> result = new HashMap<>();
		product.getStatus().setProducts(null);
		product.getCategories().stream().forEach(category -> category.setProducts(null));
		product.getSoldProducts().stream().forEach(soldProduct -> {
			soldProduct.setProduct(null);
			soldProduct.setOrder(null);
		});
		product.getVat().setProducts(null);

		result.put("product", product);
		return new ModelAndView(new MappingJackson2JsonView(), result);
	}
}
