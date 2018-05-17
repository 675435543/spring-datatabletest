<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!--第一步：引入Javascript / CSS （CDN）-->
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/resources/thirdparty/DataTables/media/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/resources/thirdparty/DataTables/extensions/Buttons/css/buttons.dataTables.min.css">

<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/static/resources/thirdparty/DataTables/media/js/jquery.js"></script>

<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/static/resources/thirdparty/DataTables/media/js/jquery.dataTables.js"></script>

<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/static/resources/thirdparty/DataTables/extensions/Buttons/js/dataTables.buttons.min.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/resources/thirdparty/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/resources/thirdparty/bootstrap/css/bootstrap-theme.min.css">
<%-- <script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/static/resources/thirdparty/bootstrap/js/bootstrap.min.js"></script>


<style>  
 
</style>
</head>

<body>
<button class="btn btn-primary" type="button" onclick="helloworld1()">helloworld1</button>
<button class="btn btn-primary" type="button" onclick="helloworld2()">helloworld2</button>

<script>

function helloworld1(){
	window.location.href = "/loantask/p2ploadXls";
}
function helloworld2(){
	window.location.href = "/loantask/p2ploadXlsx";
}
</script>

</body>
</html>