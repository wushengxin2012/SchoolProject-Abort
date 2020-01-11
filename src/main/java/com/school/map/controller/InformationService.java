package com.school.map.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.ArrayList;

import com.school.map.model.InfoModel;
import com.school.map.model.SensorModel;

@RestController
public class InformationService{
		
		// test data
		private List<InfoModel> list;
		private int countId = 6;
		
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
}