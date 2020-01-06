package com.school.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;


// @RequestMapping("/")
@Controller
class MainController{
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String getMainPage(Model model){
		return "mainlist";
	}
		
}