package com.idriving.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.idriving.service.LandingService;

@Controller
public class LandingController {

	private final Logger logger = LoggerFactory.getLogger(LandingController.class);
	private final LandingService helloWorldService;
	
	//@Autowired(required=true)
	//private Facebook facebook;
	//@Autowired(required=true)
	//private ConnectionRepository connectionRepository;

	@Autowired
	public LandingController(LandingService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		
		//if (connectionRepository==null || connectionRepository.findPrimaryConnection(Facebook.class) == null) {
        //    return "redirect:/connect/facebook";
        //}
		
		logger.debug("index() is executed!");
		model.put("title", helloWorldService.getTitle(""));
		model.put("msg", helloWorldService.getDesc());
        //model.put("fbData", this.facebook.toString());
		return "startbootstrap-freelancer/index";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");

		model.addObject("title", helloWorldService.getTitle(name));
		model.addObject("msg", helloWorldService.getDesc());

		return model;

	}

}