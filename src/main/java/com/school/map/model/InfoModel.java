package com.school.map.model;

public class InfoModel{
        private int infoId;
        private String pointName;
        private String pointStatus;
        private String imgPath = "Test parameter 1";
		
        private String parameter2 = "Test parameter 2";
        private String parameter3 = "Test parameter 3";
        private String parameter4 = "Test parameter 4";
		
        private double x;
        private double y;
		
		// new added parameter
		private String pointType;
		private String pointManager;

        public InfoModel(){

        }

        public InfoModel(int value1, String value2, String value3, double value4, double value5){
                infoId = value1;
                pointName = value2;
                pointStatus = value3;
                x = value4;
                y = value5;
        }

        // getter and setter
        public int getInfoId(){
                        return infoId;
        }

        public void setInfoId(int value){
                        this.infoId = value;
        }
        public String getPointName(){
                        return pointName;
        }

        public void setPointName(String value){
                        this.pointName = value;
        }
        public String getPointStatus(){
                        return pointStatus;
        }

        public void setPointStatus(String value){
                        this.pointStatus = value;
        }

        public String getImgPath(){
                        return imgPath;
        }

        public void setImgPath(String value){
                        this.imgPath = value;
        }


        public String getParameter2(){
                        return parameter2;
        }

        public void setParameter2(String value){
                        this.parameter2 = value;
        }
        public String getParameter3(){
                        return parameter3;
        }

        public void setParameter3(String value){
                        this.parameter3 = value;
        }
        public String getParameter4(){
                        return parameter4;
        }

        public void setParameter4(String value){
                        this.parameter4 = value;
        }

        public double getX(){
                        return x;
        }

        public void setX(double value){
                        this.x = value;
        }
        public double getY(){
                        return y;
        }

        public void setY(double value){
                        this.y = value;
        }
		
		// new added parameter's getter and setter
		public String getPointType(){
			return pointType;
		}

		public void setPointType(String value){
			this.pointType = value;
		}
		
		public String getPointManager(){
			return pointManager;
		}

		public void setPointManager(String value){
			this.pointManager = value;
		}

}