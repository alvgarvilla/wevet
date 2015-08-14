package com.webberis.vet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OwnerController {

	/**
	 * Request mapping for user
	 */
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public ModelAndView getUsersView() {
		ModelAndView mv = new ModelAndView("breedTest");
		mv.addObject("breedTestModel", "Pruebas");
		return mv;
	}
}
