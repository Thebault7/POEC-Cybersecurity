package fr.bufalo.acme.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.bufalo.acme.bo.Customer;
import fr.bufalo.acme.bo.Employee;
import fr.bufalo.acme.constant.ParameterConstant;
import fr.bufalo.acme.utils.charts.ChartFormatting;

/**
 * @date Created 13/05/2021
 * @author Frederic Thebault
 * @version 1.0
 *
 */
@Controller
public class StatisticController {
	
	private static final String STAT_PAGE = "statPage";
	private static final String SESSION_EMPLOYEE = ParameterConstant.SESSION_EMPLOYEE.getParameterName();
	private static final String PIE_CHART_STRING = ParameterConstant.PIE_CHART_STRING.getParameterName();
	private static final String HISTOGRAM_CHART_STRING = ParameterConstant.HISTOGRAM_CHART_STRING.getParameterName();

	@RequestMapping(path = "/" + STAT_PAGE, method = RequestMethod.GET)
	public ModelAndView goToStatPage(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute(SESSION_EMPLOYEE);
		Iterator<Customer> it = employee.getListCustomer().iterator();
		while (it.hasNext()) {
			Customer customer = it.next();
			if (!customer.isActive()) {
				it.remove();
			}
		}
		ModelAndView mav = new ModelAndView(STAT_PAGE, PIE_CHART_STRING, ChartFormatting.pieChartFormatting(employee.getListCustomer()));
		mav.addObject(HISTOGRAM_CHART_STRING, ChartFormatting.histogramChartFormatting(employee.getListCustomer()));
		return mav;
	}
}
