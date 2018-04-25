$(function(){
	$("#actionButton1").click(function(){
		sendajax1();
	});
	$("#actionButton2").click(function(){
		sendajax2();
	});
});

function sendajax1(){
	$.ajax({
		url:"test1",
		type:"get",
		dataType:"json",
		success:function(data){
			console.log("调用成功!"+data.name);
			$("#content1").val(data.name);
		},
		error:function(data){
			console.log("调用失败!");
		}
	});
}

function sendajax2(){
	$.ajax({
		url:"test2",
		type:"get",
		dataType:"json",
		success:function(data){
			console.log("调用成功!"+data.name);
			$("#content2").val(data.name);
		},
		error:function(data){
			console.log("调用失败!");
		}
	});
}

