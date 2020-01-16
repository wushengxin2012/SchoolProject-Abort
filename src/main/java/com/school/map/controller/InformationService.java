package com.school.map.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.school.map.model.InfoModel;
import com.school.map.model.SensorModel;

@RestController
public class InformationService{
		
		// test data
		private List<InfoModel> list;
		private int countId = 6;
		private List<Map<String, Object>> sensorData = new ArrayList<Map<String, Object>>();
		
		public InformationService(){
			
			InfoModel point1 = new InfoModel(1, "清真餐厅监测点", "正常", 103.935977,30.760807);
            point1.setImgPath("qingzhen.png");
            InfoModel point2 = new InfoModel(2, "图书馆监测点", "正常", 103.935258,30.756513);
            point2.setImgPath("tushuguan.jpg");
            InfoModel point3 = new InfoModel(3, "家园餐厅监测点", "正常", 103.940361,30.759085);
            point3.setImgPath("jiayuan.jpg");
            InfoModel point4 = new InfoModel(4, "咖啡厅监测点", "正常", 103.931324,30.756509);
            point4.setImgPath("kafei.jpg");
            InfoModel point5 = new InfoModel(5, "活动中心监测点", "正常", 103.935456,30.761459);
            point5.setImgPath("huodong.jpg");
            list = new ArrayList<InfoModel>();
            list.add(point1);list.add(point2);list.add(point3);list.add(point4);list.add(point5);
			
			// sensor data
			Map<String, Object> data1 = new HashMap<String, Object>();
			data1.put("id", 1); 
			data1.put("data", new int[]{33,29,26,43,40,26,43,13,15,14,37,14,6,47,41,31,33,49,39,4,11,11,37,8,18,36,13,23,8,37,6,13});
			data1.put("labels", new String[]{"2019/10/1","2019/10/2","2019/10/3","2019/10/4","2019/10/5","2019/10/6","2019/10/7","2019/10/8","2019/10/9","2019/10/10","2019/10/11","2019/10/12","2019/10/13","2019/10/14","2019/10/15","2019/10/16","2019/10/17","2019/10/18","2019/10/19","2019/10/20","2019/10/21","2019/10/22","2019/10/23","2019/10/24","2019/10/25","2019/10/26","2019/10/27","2019/10/28","2019/10/29","2019/10/0","2019/10/1","2019/10/2"});
			sensorData.add(data1);
			
			Map<String, Object> data2 = new HashMap<String, Object>();
			data2.put("id", 2); 
			data2.put("data", new int[]{6,29,11,25,22,10,26,27,42,49,25,1,27,38,23,18,6,22,21,31,19,40,34,24,33,21,4,23,8,8,10,4});
			data2.put("labels", new String[]{"2019/10/1","2019/10/2","2019/10/3","2019/10/4","2019/10/5","2019/10/6","2019/10/7","2019/10/8","2019/10/9","2019/10/10","2019/10/11","2019/10/12","2019/10/13","2019/10/14","2019/10/15","2019/10/16","2019/10/17","2019/10/18","2019/10/19","2019/10/20","2019/10/21","2019/10/22","2019/10/23","2019/10/24","2019/10/25","2019/10/26","2019/10/27","2019/10/28","2019/10/29","2019/10/0","2019/10/1","2019/10/2"});
			sensorData.add(data2);
			
			Map<String, Object> data3 = new HashMap<String, Object>();
			data3.put("id", 3); 
			data3.put("data", new int[]{6,24,14,14,11,2,32,17,38,31,23,38,19,7,35,30,47,45,35,8,48,16,18,40,49,20,45,31,6,37,14,45});
			data3.put("labels", new String[]{"2019/10/1","2019/10/2","2019/10/3","2019/10/4","2019/10/5","2019/10/6","2019/10/7","2019/10/8","2019/10/9","2019/10/10","2019/10/11","2019/10/12","2019/10/13","2019/10/14","2019/10/15","2019/10/16","2019/10/17","2019/10/18","2019/10/19","2019/10/20","2019/10/21","2019/10/22","2019/10/23","2019/10/24","2019/10/25","2019/10/26","2019/10/27","2019/10/28","2019/10/29","2019/10/0","2019/10/1","2019/10/2"});
			sensorData.add(data3);
			
			Map<String, Object> data4 = new HashMap<String, Object>();
			data4.put("id", 4); 
			data4.put("data", new int[]{5,11,22,23,45,11,44,10,4,17,4,19,21,28,44,36,12,38,7,12,22,29,6,49,42,8,18,4,10,23,12,45});
			data4.put("labels", new String[]{"2019/10/1","2019/10/2","2019/10/3","2019/10/4","2019/10/5","2019/10/6","2019/10/7","2019/10/8","2019/10/9","2019/10/10","2019/10/11","2019/10/12","2019/10/13","2019/10/14","2019/10/15","2019/10/16","2019/10/17","2019/10/18","2019/10/19","2019/10/20","2019/10/21","2019/10/22","2019/10/23","2019/10/24","2019/10/25","2019/10/26","2019/10/27","2019/10/28","2019/10/29","2019/10/0","2019/10/1","2019/10/2"});
			sensorData.add(data4);
			
			Map<String, Object> data5 = new HashMap<String, Object>();
			data5.put("id", 5); 
			data5.put("data", new int[]{37,49,26,15,14,4,45,38,35,1,49,14,49,38,45,39,30,3,32,17,9,16,46,41,35,2,40,26,29,43,47,15});
			data5.put("labels", new String[]{"2019/10/1","2019/10/2","2019/10/3","2019/10/4","2019/10/5","2019/10/6","2019/10/7","2019/10/8","2019/10/9","2019/10/10","2019/10/11","2019/10/12","2019/10/13","2019/10/14","2019/10/15","2019/10/16","2019/10/17","2019/10/18","2019/10/19","2019/10/20","2019/10/21","2019/10/22","2019/10/23","2019/10/24","2019/10/25","2019/10/26","2019/10/27","2019/10/28","2019/10/29","2019/10/0","2019/10/1","2019/10/2"});
			sensorData.add(data5);
		}

        @RequestMapping(value="/informationservice/{infoId}", method = RequestMethod.GET)
        @CrossOrigin(origins = "*", allowCredentials = "true")
        public InfoModel getInformation(@PathVariable("infoId") int infoId){
			
			InfoModel requestValue = null;
			
			for(InfoModel info : list){
				if(info.getInfoId() == infoId){
					requestValue = info;
				}
			}	
			
			if(requestValue == null){
				requestValue = new InfoModel(infoId, "Test Point", "None Error", 111, 111);
			}
			
            return requestValue;
        }
		

        @RequestMapping(value="/informationservice")
        @CrossOrigin(origins = "*", allowCredentials = "true")
        public List<InfoModel> getStartPoint(){
                
            return list;
        }
		
		@RequestMapping(value="/informationservice/setmodel/{infoId}")
		public String setInfoModel(InfoModel model, @PathVariable("infoId") int infoId){
			// remove the old InfoModel
			for(InfoModel temp : list){
				if(temp.getInfoId() == infoId){
					list.remove(temp);
					break;
				}
			}
			model.setInfoId(infoId);
			list.add(model);
			return "success";
			
		}
		
		// other tools
		// other tools
		// other tools
		// other tools
		private InfoModel transferModel(SensorModel model){
			InfoModel returnModel = new InfoModel();
			returnModel.setInfoId(countId++);
			returnModel.setPointName(model.getSensorName());
			String position_x = model.getSensorPosition().split(",")[0];
			String position_y = model.getSensorPosition().split(",")[1];
			returnModel.setX(Double.parseDouble(position_x));
			returnModel.setY(Double.parseDouble(position_y));
			returnModel.setImgPath(model.getSensorImage());
			returnModel.setPointStatus(model.getSensorStatus());
			returnModel.setPointType(model.getSensorType());
			returnModel.setPointManager(model.getSensorManager());
			
			return returnModel;
		}
		
		public void saveSensor(SensorModel sensorModel){
			InfoModel newInfoModel = transferModel(sensorModel);
			list.add(newInfoModel);
		}
		
		// amend sensor 
		// amend sensor 
		// amend sensor 
		public void amendSensor(SensorModel sensorModel){
			InfoModel newInfoModel = transferModel(sensorModel);
			newInfoModel.setInfoId(sensorModel.getSensorId());
			InfoModel oldInfoModel = null;
			for(InfoModel temp : list){
				if(temp.getInfoId() == newInfoModel.getInfoId()){
					oldInfoModel = temp;
					//list.remove(temp);
					break;
				}
			}
			if(oldInfoModel == null){
				list.add(newInfoModel);
				return;
			}
			
			// making some amend
			if(newInfoModel.getPointName() != null){
				oldInfoModel.setPointName(newInfoModel.getPointName());
			}
			if(newInfoModel.getPointStatus() != null){
				oldInfoModel.setPointStatus(newInfoModel.getPointStatus());
			}
			if(newInfoModel.getImgPath() != null){
				oldInfoModel.setImgPath(newInfoModel.getImgPath());
			}
			if(newInfoModel.getX() != 0.0d){
				oldInfoModel.setX(newInfoModel.getX());
			}
			if(newInfoModel.getY() != 0.0d){
				oldInfoModel.setY(newInfoModel.getY());
			} 
			if(newInfoModel.getPointType() != null){
				oldInfoModel.setPointType(newInfoModel.getPointType());
			}
			if(newInfoModel.getPointManager() != null){
				oldInfoModel.setPointManager(newInfoModel.getPointManager());
			}
			//list.add(oldInfoModel);
		}
		
		// get sensor data
		// get sensor data
		// get sensor data
		@RequestMapping(value="/informationservice/getSensorInfo/{sensorId}")
        @CrossOrigin(origins = "*", allowCredentials = "true")
		public Map<String, Object> getSensorData(@PathVariable("sensorId") int sensorId){
			Map<String, Object> requestValue = null;
			for(Map<String, Object> tmp : sensorData){
				if((int)tmp.get("id") == sensorId){
					requestValue = tmp;
					break;
				}
			}
			if(requestValue == null){
				System.out.println("Cannot found the data of sensor with id: " + sensorId);
			}
			return requestValue;
		}
}