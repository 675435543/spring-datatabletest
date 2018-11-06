<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

</head>
<body>
<script>
</script>

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
<%-- ${mydiv} --%>
	<div id="mydiv" name="mydiv" value="123445">我是div</div>
	<div class="datatableSide">
	<table id="tableid" class="display">
	<!-- 表格格式设置 -->
	<!--    <thead>
	       <tr>
	       	<th>全选232</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>年龄</th>
	       	<th>全选232</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>年龄</th>
            <th>全选232</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>年龄</th>
	       	<th>全选232</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>姓名</th>
            <th>年龄</th>
	       </tr>
	   </thead>
        <tfoot>
           <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Position</th>
            <th>Position</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Position</th>
            <th>Position</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Position</th>
            <th>Position</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Position</th>
            <th>Last name</th>
            <th>Position</th>
           </tr>
       </tfoot> -->
	</table>
	</div>
</div>
</div>
</body>
<script src="${pageContext.request.contextPath}/static/resources/js/account/accountOptions.js?0.0.16"></script>
<script src="${pageContext.request.contextPath}/static/resources/js/test/test.js?0.0.0"></script>
</html>