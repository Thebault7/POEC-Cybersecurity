package fr.bufalo.acme.controller;

import fr.bufalo.acme.bo.Customer;
import fr.bufalo.acme.bo.Employee;
import fr.bufalo.acme.bo.Order;
import fr.bufalo.acme.service.OrderManager;
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


	@RequestMapping(path = "/manageOrders", method = RequestMethod.GET)
	public ModelAndView goToManageOrders(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute("sessionEmployee");
		List<Customer> listCustomers = employee.getListCustomer();
		List<Order> listOrders = new ArrayList<>();
		for (Customer customer : listCustomers){
			listOrders.add((Order) customer.getListOrders());
		}
		return new ModelAndView("manageOrders", "listOrders", listOrders);
	}

	@RequestMapping(path = "/addOrder", method = RequestMethod.GET)
	public ModelAndView goToAddOrders(ModelMap modelMap) {
		Order order = new Order();
		ModelAndView mav = new ModelAndView("addOrder", "order", order);
		return mav;
	}

	@RequestMapping(path = "/checkAddOrder", method = RequestMethod.POST)
	public RedirectView checkAddOrder(Order order, RedirectAttributes redirectAttribute) {
		redirectAttribute.addFlashAttribute("order", order);
		return new RedirectView("manageOrders");
	}

	@RequestMapping(path = "/searchOrder", method = RequestMethod.GET)
	public ModelAndView goToSearchOrders(ModelMap modelMap, int customerId) {
//		ModelAndView mav = new ModelAndView("editOrder", "order", om.findById(orderId));
		ModelAndView mav = new ModelAndView("editOrder", "order", new Order());
		return mav;
	}

	@RequestMapping(path = "/modifyOrder", method = RequestMethod.GET)
	public ModelAndView goToModifyOrder(ModelMap modelMap, int orderId) {
		Order order = om.findById(orderId);
//		clearedOrder.setPostalCode(nli.nullifyPostalCodeListWithinEachCity(clearedOrder.getPostalCode()));
//		clearedOrder.setPostalCode(nli.nullifyPostalCodeListWithinEachCustomer(clearedOrder.getPostalCode()));
//		ModelAndView mav = new ModelAndView("modifyOrder", "order", clearedOrder);
		ModelAndView mav = new ModelAndView("modifyOrder", "order", new Order());
		return mav;
	}
}
