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

<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/static/resources/thirdparty/DataTables/media/js/jquery.js"></script>

<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="${pageContext.request.contextPath}/static/resources/thirdparty/DataTables/media/js/jquery.dataTables.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/resources/thirdparty/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/resources/thirdparty/bootstrap/css/bootstrap-theme.min.css">
<%-- <script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/static/resources/thirdparty/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<script>
</script>
<style>
.navbar-nav {
  float: none;
  text-align:center;
}
ul.nav.navbar-nav  li {
    float:none;
    display: inline-block;
    margin: 0em;
}
</style>
<div class="navbar-collapse collapse">
  <ul class="nav navbar-nav">
    <li class="">
        <a href="#">首页</a>
    </li>
    <li class="">
        <a href="#">加入我们</a>
    </li>
    <li class="">
        <a href="#">联系我们</a>
    </li>
  </ul>
</div>


</body>
</html>