package com.school.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.school.map.model.SensorModel;


// @RequestMapping("/")
@RestController
public class SensorController{
	
	@RequestMapping(value="/addSensor" , method=RequestMethod.POST)
	public String addSensor(SensorModel addedSensor){
		System.out.println(addedSensor.getSensorName());
		return "success";
	}
}