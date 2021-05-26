package fr.bufalo.acme.controller;

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
@Controller
public class StatisticController {
	
	private static final String STAT_PAGE = "statPage";

	@RequestMapping(path = "/" + STAT_PAGE, method = RequestMethod.GET)
	public void goToStatPage(ModelMap modelMap) {
	}
}
