<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>
<%-- <jsp:include page="./body.jsp"></jsp:include> --%>
<%-- <%@ include file="./header.jsp" %>
<%@ include file="./left.jsp" %>
<%@ include file="./body.jsp" %> --%>

<!-- <input type="text" id="content1"/>&nbsp;&nbsp;<input type="button" id="actionButton1" value="获取内容" />
<input type="text" id="content2"/>&nbsp;&nbsp;<input type="button" id="actionButton2" value="获取内容" /> -->
<div id="content" class="row-fluid">
<div class="col-md-8">
<button id="btn1">把数据添加到 div 元素</button><br />
<button id="btn2">获取已添加到 div 元素的数据</button>
<div></div>

	<table id="tableid" class="display">
<!-- 	   <thead>
	       <tr>
	       	<th>全选232</th>
            <th>姓名</th>
            <th>年龄</th>
	       </tr>
	   </thead> -->
	</table>
</div>
</div>


<script>

$(document).ready(function(){
	  $("#btn1").click(function(){
	    $("div").data("greeting", "Hello World");
	  });
	  $("#btn2").click(function(){
	    alert($("div").data("greeting"));
	  });
	});
</script>
</body>
<script src="${pageContext.request.contextPath}/static/resources/js/account/accountDTRowData.js?0.0.2"></script>
<script src="${pageContext.request.contextPath}/static/resources/js/test/test.js?0.0.0"></script>
</html>