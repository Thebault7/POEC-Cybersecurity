package fr.bufalo.acme.controller;

import fr.bufalo.acme.bo.Customer;
import fr.bufalo.acme.bo.Employee;
import fr.bufalo.acme.bo.Order;
import fr.bufalo.acme.constant.ErrorConstant;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @date Created 13/05/2021
 * @author Frederic Thebault / Benjamin LAMBERT
 * @version 1.0
 *
 */
@Component
@Controller
public class OrderController {

	@Autowired
	private OrderManager om;

	@Autowired
	private ReferenceGeneratorInterface rgi;


	private static final String INEXISTING_DATE_ERROR = ErrorConstant.INEXISTING_DATE.getErrorMessage();


	private static final String SESSION_EMPLOYEE = "sessionEmployee";
	private static final String MANAGE_ORDERS = "manageOrders";
	private static final String LIST_ORDERS = "listOrders";
	private static final String ADD_ORDER = "addOrder";
	private static final String ORDER = "order";
	private static final String ERROR_MESSAGE = "errorMessage";
	private static final String EDIT_ORDER = "editOrder";
	private static final String MODIFY_ORDER = "modifyOrder";
	private static final String SEARCH_ORDER = "searchOrder";
	private static final String VIEW_ORDER = "viewOrder";
	private static final String CHECK_ADD_ORDER = "checkAddOrder";


	@RequestMapping(path = "/" + MANAGE_ORDERS, method = RequestMethod.GET)
	public ModelAndView goToManageOrders(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute(SESSION_EMPLOYEE);
		List<Customer> listCustomers = employee.getListCustomer();
		List<Order> listOrders = new ArrayList<>();
		for (Customer customer : listCustomers){
			for (Order order : customer.getListOrders()) {
				listOrders.add(order);
			}
		}
		return new ModelAndView(MANAGE_ORDERS, LIST_ORDERS, listOrders);
	}

	@RequestMapping(path = "/" + VIEW_ORDER, method = RequestMethod.GET)
	public ModelAndView goToViewOrder(ModelMap modelMap, int orderId) {
		ModelAndView mav = new ModelAndView(VIEW_ORDER, ORDER, om.findById(orderId));
		return mav;
	}

	@RequestMapping(path = "/" + ADD_ORDER, method = RequestMethod.GET)
	public ModelAndView goToAddOrder(ModelMap modelMap) {
		Order order = new Order();
		order.setReference(rgi.generateReference(ReferenceType.ORDER));
		ModelAndView mav = new ModelAndView(ADD_ORDER, ORDER, order);
		mav.addObject(ERROR_MESSAGE, "");
		return mav;
	}

	@RequestMapping(path = "/" + CHECK_ADD_ORDER, method = RequestMethod.POST)
	public RedirectView checkAddOrder(Order order, RedirectAttributes redirectAttribute) {
		redirectAttribute.addFlashAttribute(ORDER, order);
		return new RedirectView(MANAGE_ORDERS);
	}

	@RequestMapping(path = "/" + SEARCH_ORDER, method = RequestMethod.GET)
	public ModelAndView goToSearchOrder(ModelMap modelMap, int orderId) {
		ModelAndView mav = new ModelAndView(EDIT_ORDER, ORDER, om.findById(orderId));
		return mav;
	}

	@RequestMapping(path = "/" + MODIFY_ORDER, method = RequestMethod.GET)
	public ModelAndView goToModifyOrder(ModelMap modelMap, int orderId) {
		Order order = om.findById(orderId);
		ModelAndView mav = new ModelAndView(MODIFY_ORDER, ORDER, order);
		return mav;
	}
}
