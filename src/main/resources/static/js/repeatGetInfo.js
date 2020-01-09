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
	
	if($("#finallyPosition").val() == '' ){
		alert("位置不能为空");
		return;
	}
	
	if($("#sensorName").val() == '' ){
		alert("名字不能为空");
		return;
	}
		
	if($("#sensorImage").val() == ''){
		alert("图片不能为空");
		return;
	}
	
	var sensorName = $("#sensorName").val();
	var sensorType = $("#sensorType").val();
	var sensorRange = $("#sensorRange").val();
	var sensorPosition = $("#finallyPosition").val();
	// var sensorImage = $("#sensorImage").val();
	var sensorImage = new Date().getTime() + "." + ($("#sensorImage")[0].files[0].type).split('/')[1];
	var sensorManager = $("#sensorManager").val();
	var addedSensor = {
		sensorName: sensorName,
		sensorType: sensorType,
		sensorRange: sensorRange,
		sensorPosition: sensorPosition,
		sensorImage: sensorImage,
		sensorManager: sensorManager
	};

	var firstPostStatus = false;
	$.ajax({
		type: "POST",
		url: window.location.protocol + "/addSensor",
		data: addedSensor,
		// contentType: false,
		// processData: false,
		success: function(data){
			firstPostStatus = true;
			// alert("添加成功");
			// $("#addedSensorForm")[0].reset();
			// $("#closeButton").click();
			// window.location.reload();
		},
		error: function(e){
			alert("添加失败：" + e);
			// console.log(window.location.protocol +  window.location.host + "/addSensor");
		}
	});
	
	var imageData = new FormData();
	//imageData.append("file", $("#sensorImage")[0].files[0]);
	var newFile = new File([$("#sensorImage")[0].files[0]], addedSensor.sensorImage, {type:$("#sensorImage")[0].files[0].type});
	// console.log($("#sensorImage")[0].files[0]);
	// console.log(newFile);
	imageData.append("file", newFile);
	
	$.ajax({
		type: "POST",
		url: window.location.protocol + "/addImage",
		data: imageData,
		contentType: false,
		processData: false,
		success: function(data){
			
			if(firstPostStatus == true){
				alert("添加成功");
				$("#addedSensorForm")[0].reset();
				$("#closeButton").click();
				window.location.reload();
				firstPostStatus = false;
				
			}else{
				alert("数据上传失败");
				
			}
			
		},
		error: function(data){
			alert("图片上传失败");
			
		}
		
	});
};


// 创建TableStatus
$("#tableStatus").bootstrapTable('destroy');
var dataFromServer;
getDataFromServerAndDrawTheTable();
// console.log(dataFromServer);
function getDataFromServerAndDrawTheTable(){
	$.get("http://localhost:8000/informationservice", function(data, status){
		dataFromServer = [];
		for(var i=0; i < data.length; i++){
			dataFromServer.push({
				id: data[i].infoId,
				name: data[i].pointName,
				type: data[i].pointType,
				status: data[i].pointStatus,
				position: data[i].x + " , " + data[i].y,
				manager: data[i].pointManager,
			});
		}
		$("#tableStatus").bootstrapTable({
			//url: '/data/data.json',
			pageNumber: 1,
			pagination: true,
			sidePagination: 'client',
			pageSize: 5,
			pageList: [5, 10, 20],
			// showRefresh: true,
			columns:[
				{field: 'id', title: '监测点ID'},
				{field: 'name', title: '监测点名称'},
				{field: 'type', title: '传感器类型'},
				{field: 'status', title: '传感器状态'},
				{field: 'position', title: '传感器位置'},
				{field: 'manager', title: '管理人员'},
				{field: "id", title: "操作", align: "center", valign:'middle', formatter: actionFormatter},
			],
			data: dataFromServer,
			
		});
		//console.log(dataFromServer);
	});
}

function testFunc(){
	//插入数据刷新表格
	//dataFromServer.push({"id":19, "name":"N19", "type":"T19", "status":"S19", "position":"P19", "manager":"M19"});
	//$("#tableStatus").bootstrapTable("refreshOptions", dataFromServer);
	
	// 更新列
	// dataFromServer[1].name = "amendName";
	// $("#tableStatus").bootstrapTable('updateRow', {field: 'id', value: 2});
	
	return "done";
}


function actionFormatter(value, row, index){
	var id = value;
	var result = "";
	result += "<a href='javascript:;' class='btn btn-xs btn-primary' style='margin:1px' onclick='getInfoById("+id+")' title='查看数据'><span class='glyphicon glyphicon-stats'></span></a>";
	result += "<a href='javascript:;' class='btn btn-xs btn-info' style='margin:1px' onclick='editById("+id+")' title='编辑数据'><span class='glyphicon glyphicon-pencil'></span></a>";
	result += "<a href='javascript:;' class='btn btn-xs btn-danger' style='margin:1px' onclick='deleteById("+id+")' title='删除节点'><span class='glyphicon glyphicon-remove'></span></a>";
	
	return result;
};

function getInfoById(id){
	alert("this is getInfoById, paramater is : " + id);
};

function editById(id){
	alert("this is editById, paramater is :" + id);
};

function deleteById(id){
	alert("this is deleteById, parameter is :" + id);
};



// 创建tableError
$("#tableError").bootstrapTable("destroy");
$("#tableError").bootstrapTable({
	pageNumber: 1,
	pagination: true,
	sidePagination: 'client',
	pageSize: 5,
	columns:[
		{field: "id", title: "故障点ID"},
		{field: "data", title: "当前数据"},
	],
	data:[
		{"id":1, "name":"N1", "type":"T1", "status":"S1", "position":"P1", "manager":"M1", "data":1},
		{"id":5, "name":"N2", "type":"T2", "status":"S2", "position":"P2", "manager":"M2", "data":12},
		{"id":13, "name":"N3", "type":"T3", "status":"S3", "position":"P3", "manager":"M3", "data":0},]
});


