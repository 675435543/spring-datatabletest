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
</head>
<body>
<script>
<!--第三步：初始化Datatables-->
$(document).ready( function () {
    $('#table_id_example').DataTable();
    $("#tableid").DataTable({
        //"ajax":"http://localhost:8080/account/findAccountInfoDatatable",
        //"ajax":"/account/findAccountInfoDatatable",
        "ajax":"findAccountInfoDatatable",
        "columns":[
        	{data:"id"},
        	{data:"name"},
            {data:"money"},
        	{data:"money"}
        ]
    });
} );

</script>

<!--第二步：添加如下 HTML 代码-->
<table id="table_id_example" class="display">
    <thead>
        <tr>
            <th>Column 1</th>
            <th>Column 2</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Row 1 Data 1</td>
            <td>Row 1 Data 2</td>
        </tr>
        <tr>
            <td>Row 2 Data 1</td>
            <td>Row 2 Data 2</td>
        </tr>
    </tbody>
</table>
<h>-----------------123</h>
<table id="tableid" class="display">
    <thead>
        <tr>
        	<th>全选</th>
            <th>Column 1</th>
            <th>Column 2</th>
            <th>Column 3</th>
            <th>Column 3</th>
            <th>Column 3</th>
            <th>Column 3</th>
            <th>Column 3</th>
        </tr>
    </thead>
</table>
</body>
</html>