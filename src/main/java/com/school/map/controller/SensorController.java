package com.school.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.map.model.SensorModel;
import com.school.map.controller.InformationService;
import java.util.HashMap;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


// @RequestMapping("/")
@RestController
public class SensorController{
	
	@Autowired
	InformationService infoService;
	
	@RequestMapping(value="/addSensor" , method=RequestMethod.POST)
	public String addSensor(SensorModel addedSensor){
		//infoService.saveSensor(addedSensor);
		System.out.println(addedSensor.getSensorName());
		// System.out.println(addedSensor.get("sensorName"));
		return "success";
	}
	
	@RequestMapping(value="/addImage", method=RequestMethod.POST)
	public String addImage(@RequestParam("file") MultipartFile file){
		if(!file.isEmpty()){
			try{
				// BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
				System.out.println(file.getOriginalFilename());
				// out.write(file.getBytes());
				// out.flush();
				// out.close();
			}catch(Exception e){
				e.printStackTrace();
				return "error";
			}
			return "success";
			
		}else{
			return "error";
		}
	}
}