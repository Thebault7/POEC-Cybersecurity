package fr.bufalo.acme.controller;

import fr.bufalo.acme.bo.*;
import fr.bufalo.acme.constant.ErrorConstant;
import fr.bufalo.acme.service.CityManager;
import fr.bufalo.acme.service.CustomerManager;
import fr.bufalo.acme.service.OrderManager;
import fr.bufalo.acme.utils.reference.ReferenceGeneratorInterface;
import fr.bufalo.acme.utils.reference.ReferenceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	private ReferenceGeneratorInterface rgi;


	private static final String INEXISTING_DATE_ERROR = ErrorConstant.INEXISTING_DATE.getErrorMessage();


	private static final String SESSION_EMPLOYEE = "sessionEmployee";
	private static final String LIST_PRODUCTS = "listProducts";
	private static final String SOLD_PRODUCTS = "soldProducts";
	private static final String ORDER_TOTAL_PRICE = "orderTotalPriceDisplay";
	private static final String ORDER = "order";
	private static final String CUSTOMER = "customer";
	private static final String CITY = "city";
	private static final String COUNTRY = "country";


	private static final String MANAGE_ORDERS = "manageOrders";
	private static final String LIST_ORDERS = "listOrders";
	private static final String VIEW_ORDER = "viewOrder";
	private static final String ADD_ORDER = "addOrder";
	private static final String CHECK_ADD_ORDER = "checkAddOrder";
	private static final String VALIDATE_ORDER = "validateOrder";
	private static final String CHECK_MODIFY_ORDER = "checkModifyOrder";
	private static final String ARCHIVE_ORDER = "archiveOrder";

	private static final String SEARCH_ORDER = "searchOrder";
	private static final String ERROR_MESSAGE = "errorMessage";


	@RequestMapping(path = "/" + MANAGE_ORDERS, method = RequestMethod.GET)
	public ModelAndView goToManageOrders(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute(SESSION_EMPLOYEE);
		List<Order> listOrders = om.findAllOrders(employee.getId());
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

		Customer customer = cm.findById(order.getCustomer().getId());
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
		order.setReference(rgi.generateReference(ReferenceType.ORDER));
		ModelAndView mv = new ModelAndView(ADD_ORDER, ORDER, order);
		mv.addObject(ERROR_MESSAGE, "");
		return mv;
	}

	@RequestMapping(path = "/" + CHECK_ADD_ORDER, method = RequestMethod.POST)
	public RedirectView checkAddOrder(Order order, RedirectAttributes redirectAttribute) {
		redirectAttribute.addFlashAttribute(ORDER, order);
		return new RedirectView(MANAGE_ORDERS);
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
}
