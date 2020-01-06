package com.school.map.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.ArrayList;

import com.school.map.model.InfoModel;

@RestController
public class InformationService{
		
		// test data
		private List<InfoModel> list;
		
		public InformationService(){
			
			InfoModel point1 = new InfoModel("point1", "qingzhen", "status-ok", 103.935977,30.760807);
            point1.setImgPath("qingzhen.png");
            InfoModel point2 = new InfoModel("point2", "tushuguan", "status-ok", 103.935258,30.756513);
            point2.setImgPath("tushuguan.jpg");
            InfoModel point3 = new InfoModel("point3", "jiayuan", "status-ok", 103.940361,30.759085);
            point3.setImgPath("jiayuan.jpg");
            InfoModel point4 = new InfoModel("point4", "kafei", "status-ok", 103.931324,30.756509);
            point4.setImgPath("kafei.jpg");
            InfoModel point5 = new InfoModel("point5", "huodong", "status-error", 103.935456,30.761459);
            point5.setImgPath("huodong.jpg");
			
            list = new ArrayList<InfoModel>();
			
            list.add(point1);list.add(point2);list.add(point3);list.add(point4);list.add(point5);
		}

        @RequestMapping(value="/informationservice/{infoId}", method = RequestMethod.GET)
        @CrossOrigin(origins = "*", allowCredentials = "true")
        public InfoModel getInformation(@PathVariable("infoId") String infoId){
			
			InfoModel requestValue = null;
			
			for(InfoModel info : list){
				if(info.getInfoId().equals(infoId)){
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

}