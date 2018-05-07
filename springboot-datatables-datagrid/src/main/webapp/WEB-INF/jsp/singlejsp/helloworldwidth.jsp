<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%-- <!--第一步：引入Javascript / CSS （CDN）-->
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
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/resources/thirdparty/bootstrap/js/bootstrap.min.js"></script>
 --%>

<style>  
    .dataTable {  
        width: 100%;  
        border: none;  
        border-collapse: collapse;  
        border-spacing: 0px !important;  
        display: table;  
        table-layout:fixed;  
    }  
  
    .dataTable th,.dataTable td {  
        padding: 0px;  
        margin: 0px;  
        border: 1px solid #BEBFD3;  
        overflow: hidden;  
        white-space: nowrap;  
        text-overflow: ellipsis;  
    }  
      
    #col1 {  
        width: 70px;  
    }  
  
    #col2 {  
        width: 220px;  
    }  
  
    #col3 {  
        width: 300px;  
    }  
  
    #col4 {  
        width: 180px;  
    }
    
    .widthTest{
        width: 800px;
    }
</style>
</head>
<body>
<script>
</script>
<div class="widthTest">
    <table class="dataTable">  
        <thead>  
            <tr>  
                <th id="col1">Header1</th>  
                <th id="col2">Header2></th>  
                <th id="col3">Header3</th>  
                <th id="col4">Header4</th>  
            </tr>  
        </thead>  
        <tbody>  
                <tr>  
                    <td>content1</td>  
                    <td>content2content2content2content2content2content2content2content2content2content2content2content2content2content2content2</td>  
                    <td>content3</td>  
                    <td>content4</td>  
                </tr>                  
                <tr>  
                    <td>content1</td>  
                    <td>content2</td>  
                    <td>content3content3content3content3content3content3content3content3content3content3content3content3content3content3content3</td>  
                    <td>content4</td>  
                </tr>  
        </tbody>  
    </table>
    </div>
</body>
</html>