package com.school.map.model;

public class SensorModel{
	private String sensorName;
	private String sensorType;
	private	String sensorRange;
	private	String sensorPosition;
	private	String sensorImage;
	private	String sensorManager;
	private String sensorStatus;
	
	public String getSensorName(){
		return sensorName;
	}
	
	public void setSensorName(String value){
		this.sensorName = value;
	}
	
	public String getSensorType(){
        return sensorType;
	}

	public void setSensorType(String value){
		this.sensorType = value;
	}
	public String getSensorRange(){
		return sensorRange;
	}

	public void setSensorRange(String value){
		this.sensorRange = value;
	}
	public String getSensorPosition(){
		return sensorPosition;
	}

	public void setSensorPosition(String value){
		this.sensorPosition = value;
	}
	public String getSensorImage(){
		return sensorImage;
	}

	public void setSensorImage(String value){
		this.sensorImage = value;
	}
	public String getSensorManager(){
		return sensorManager;
	}

	public void setSensorManager(String value){
		this.sensorManager = value;
	}
	public String getSensorStatus(){
		return sensorStatus;
	}

	public void setSensorStatus(String value){
		this.sensorStatus = value;
	}
}