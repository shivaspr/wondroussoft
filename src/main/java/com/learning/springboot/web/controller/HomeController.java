package com.learning.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		model.put("firstName", "Shivaprakash");
		model.put("lastName", "K");
		return "home";
	}
}
