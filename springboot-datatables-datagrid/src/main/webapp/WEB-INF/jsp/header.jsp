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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/resources/css/common/common.css">


</head>
<body>
<script>
</script>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">菜鸟教程</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">iOS</a></li>
            <li><a href="#">SVN</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    Java
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">jmeter</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                    <li class="divider"></li>
                    <li><a href="#">另一个分离的链接</a></li>
                </ul>
            </li>
            <li><a href="#">系列教程</a></li>
            <li><a href="#">名师介绍</a></li>
            <li><a href="#">成功案例</a></li>
            <li><a href="#">关于我们</a></li>
        </ul>
    </div>
    </div>
</nav>

</body>
</html>