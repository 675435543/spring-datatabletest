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

<jsp:include page="./header.jsp"></jsp:include>
<jsp:include page="./left.jsp"></jsp:include>
<%-- <jsp:include page="./body.jsp"></jsp:include> --%>
<%-- <%@ include file="./header.jsp" %>
<%@ include file="./left.jsp" %>
<%@ include file="./body.jsp" %> --%>
<div id="content" class="row-fluid">
<div class="col-md-8">
	<table id="tableid" class="display">
	   <thead>
	       <tr>
	       	<th>全选</th>
            <th>Column 1</th>
            <th>Column 2</th>
            <th>Column 3</th>
	       </tr>
	   </thead>
	</table>
</div>
</div>
</body>
<script src="${pageContext.request.contextPath}/static/resources/js/account/account.js?0.0.0"></script>

</html>