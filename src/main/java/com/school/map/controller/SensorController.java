package com.school.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;   

import com.school.map.model.SensorModel;
import com.school.map.controller.InformationService;


// @RequestMapping("/")
@RestController
public class SensorController{
	
	@Autowired
	InformationService infoService;
	
	@RequestMapping(value="/addSensor" , method=RequestMethod.POST)
	public String addSensor(SensorModel addedSensor){
		infoService.saveSensor(addedSensor);
		System.out.println(addedSensor.getSensorName());
		return "success";
	}
}