// 设置地图高度
var windowH = $(window).height();
$("#iframe").height(windowH * 0.7);

var map = new BMap.Map("mapForSearch",{enableMapClick: false});
var point = new BMap.Point(103.923284,30.762875);
map.centerAndZoom(point, 15);
map.addControl(new BMap.NavigationControl());
map.setMapStyle({style: 'normal'});
map.enableScrollWheelZoom(true); 
map.addEventListener("click", function(e){    
    // alert(e.point.lng + ", " + e.point.lat);    
	document.getElementById("showSelected").innerHTML = "选择的位置：" + e.point.lng + ", " + e.point.lat
	document.getElementById("finallyPosition").value = e.point.lng + ", " + e.point.lat
});

var local = new BMap.LocalSearch(map, {renderOptions: {map: map}});
//local.search("电子科技大学");
function searchPosition(position){
	local.search(position);
};

function postData(){
	var sensorName = $("#sensorName").val();
	var sensorType = $("#sensorType").val();
	var sensorRange = $("#sensorRange").val();
	var sensorPosition = $("#finallyPosition").val();
	var sensorImage = $("#sensorImage").val();
	var sensorManager = $("#sensorManager").val();
	var addedSensor = {
		sensorName: sensorName,
		sensorType: sensorType,
		sensorRange: sensorRange,
		sensorPosition: sensorPosition,
		sensorImage: sensorImage,
		sensorManager: sensorManager
	};
	$.ajax({
		type: "POST",
		url: window.location.protocol + "/addSensor",
		data: addedSensor,
		success: function(data){
			alert("添加成功");
			$("#addedSensorForm")[0].reset();
			$("#closeButton").click();
			window.location.reload();
		},
		error: function(e){
			alert("添加失败：" + e);
			// console.log(window.location.protocol +  window.location.host + "/addSensor");
		}
	});
};


