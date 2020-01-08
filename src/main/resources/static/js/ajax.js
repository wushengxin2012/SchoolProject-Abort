// var dataFormService = new Vue({
	// el: 'datafromservice1',
	// data: {
		// infoId : '',
		// pointName : '',
		// pointStatus : '',
		// parameter1 : '',
		// parameter2 : '',
		// parameter3 : '',
		// parameter4 : '',
		// show images
		// title : 'test title',
		// imgName : 'zhulou',
		// imgPath : 'zhulou.jpg',
		// showContent : '<p>This is the content to be show, for more infomation. this to</p>',
	// }
// });

var title = "zhulou";
var infoId = 1;
var pointStatus = "ok";
var pointPosition = "123,123";
var pointType = "jinggaichuanganqi";
var imgPath = "zhulou.jpg";
var pointManager = "None";
// var showContent = "<p>This is the content to be show, for more infomation. this to</p>";

var showWindow = function (e){
	//<!-- 显示窗口基本信息 -->
	// var sContent = '<div style="margin:0;line-height:20px;padding:2px;">' +
				   // '<img src=' + imgPath + ' alt="" style="float:right;zoom:1;overflow:hidden;width:100px;height:100px;margin-left:3px;"/>' +
                    // showContent +
                   // '</div>';
	var sContent = 	"<div class='panel panel-default' >" +
						"<div class='panel-body' style='margin:0; padding:0'>" + 
							"<img class='card-img' style='float:left; width:133px; height:133px;' " +
								  "src=" + imgPath + "/>" +
							"<div style='overflow:hidden'>" +
								'<ul class="list-group" style="margin-top:20px; margin:0px; border:0px">' +
									'<li class="list-group-item" style="padding:0; border:0px">' +
										'<div class="input-group input-group-sm input-group-md">'+
											'<span class="input-group-addon">传感器ID</span>'+
											'<input type="text" class="form-control" value="' + infoId + '" >'+
											'<!-- <span class="input-group-addon">cm</span> -->'+
										'</div>'+
									'</li>'+
									'<li class="list-group-item" style="padding:0; border:0px">' +
										'<div class="input-group input-group-sm input-group-md">'+
											'<span class="input-group-addon">传感器状态</span>'+
											'<input type="button" class="form-control btn btn-primary" value="' + pointStatus + '" >'+
											'<!-- <span class="input-group-addon">cm</span> -->'+
										'</div>'+
									'</li>'+
									'<li class="list-group-item" style="padding:0; border:0px">' +
										'<div class="input-group input-group-sm input-group-md">'+
											'<span class="input-group-addon">传感器类型</span>'+
											'<input type="text" class="form-control" value="' + pointType + '" >'+
											'<!-- <span class="input-group-addon">cm</span> -->'+
										'</div>'+
									'</li>'+
									'<li class="list-group-item" style="padding:0; border:0px">' +
										'<div class="input-group input-group-sm input-group-md">'+
											'<span class="input-group-addon">传感器位置</span>'+
											'<input type="text" class="form-control" value="' + pointPosition + '" >'+
											'<!-- <span class="input-group-addon">cm</span> -->'+
										'</div>'+
									'</li>'+
									
								'</ul>'+
							"</div>" +
						"</div>" +
						"<div class='panel-footer' style='padding:0'>" +
							"<small class='text-muted'>Manager: " + pointManager + "</small>" +
						"</div>" +
					"</div>";
					
					
	var opts = {
		title : title,
		width : 380,
		height: 180,
		enableAutoPan : true,
	}
	
	var infoWindow = new BMap.InfoWindow(sContent, opts); // 窗口实例

	map.openInfoWindow(infoWindow, e.point)

}

var reserverMPs = [];
var doAjax = function (e){
	var point = "node1";
	// 获取对应的点
	for(i=0; i<reserverMPs.length; i++){
		if(reserverMPs[i].point.x == e.target.point.lng && reserverMPs[i].point.y == e.target.point.lat){
			point = reserverMPs[i].point;
			break;
		}
	}
	
	$.get("http://localhost:8000/informationservice/" + point.infoId, function(data, status){
		
		title = data.pointName;
		imgPath = "../" + "imgs/" + point.imgPath;
		
		infoId = data.infoId;
		pointStatus = data.pointStatus;
		pointPosition = data.x + ' , ' + data.y;
		pointType = data.pointType;
		pointManager = data.pointManager;
		
		showWindow(e);
	
	});
	
}

// 从服务器获取点，并显示
var points;
var displayInitPoint = function(){
	
	$.get("http://localhost:8000/informationservice", function(data, status){
		
		var points = data;
		for(i=0; i < points.length; i++){
			var point = new BMap.Point(points[i].x, points[i].y);
			var marker = new BMap.Marker(point);
			marker.addEventListener("click", function (e) {
														  doAjax(e);
														  });
			
			map.addOverlay(marker);
			
			reserverMPs.push({marker:marker, point:points[i]});
		}
	});
}

// 画上从服务器获取的标点
displayInitPoint();

