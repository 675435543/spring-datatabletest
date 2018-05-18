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
<div id="list">
    <table>
        <tr><td>选项1<input type="checkbox" name="group" value="1"/></tr>
        <tr><td>选项2<input type="checkbox" name="group" value="2"/></tr>
        <tr><td>选项3<input type="checkbox" name="group" value="3"/></tr>
    </table>
</div>
全选<input type="checkbox" id="all"/>

<script>
$(document).ready(function () {
    //全选或全不选
    $("#all").click(function () {
        if (this.checked) {
            $("#list :checkbox").attr("checked", true);
        } else {
            $("#list :checkbox").attr("checked", false);
        }
    });
    //设置全选复选框
    $("#list :checkbox").click(function () {
        allchk();
    });
    function allchk() {
        var chknum = $("#list :checkbox").size();//选项总个数
        var chk = 0;
        $("#list :checkbox").each(function () {
            if ($(this).attr("checked")) {
                chk++;
            }
        });
        if (chknum == chk) {//全选
            $("#all").attr("checked", true);
        } else {//不全选
            $("#all").attr("checked", false);
        }
    }
    //显示时执行一次
    allchk();
});
</script>

</body>
</html>