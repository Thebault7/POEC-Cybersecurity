package fr.bufalo.acme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
		@RequestMapping(method = RequestMethod.GET, path = {"/index"})
		public void goToIndexPage(ModelMap modelMap) {
		}
}
