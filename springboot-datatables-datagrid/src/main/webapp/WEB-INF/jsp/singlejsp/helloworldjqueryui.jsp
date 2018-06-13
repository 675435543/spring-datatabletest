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

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/resources/thirdparty/jquery-ui-1.12.1.custom/jquery-ui.min.css">
<script src="${pageContext.request.contextPath}/static/resources/thirdparty/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>


<style>  
 
</style>
</head>

<body>
<input type="text" name="date" id="date" />
<div class="ui-widget">
  <label for="tags">标签：</label>
  <input id="tags">
</div>

<label><i>*</i>域账号:</label>
<input id="addAdminUser"
name="AdminUsers" placeholder="请输入域账号"
onfocus="this.placeholder=''" onblur="this.placeholder='请输入域账号'" style='width:800px'>
<div id="adminUsersDiv" style="display: none;"></div>

<script>

function split(val)
{
	return val.split(/,\s*/);
}
$(function() {

    var availableTags = [
      "ActionScript",
      "AppleScript",
      "Asp",
      "BASIC",
      "C",
      "C++",
      "Clojure",
      "COBOL",
      "ColdFusion",
      "Erlang",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme"
    ];
    $( "#tags" ).autocomplete({
      source: availableTags
    });
    
    $("#addAdminUser").autocomplete({
    	source: function(request, response) {
    		var strs = $("#addAdminUser").val().split(",");
    		$.ajax({
    			type: "GET",
    			url: "/account/helloworldjqueryui",
     			data: {
    				"userId": strs[strs.length - 1]
/*     				"access_token": accessToken */
    			},
    			dataType: "json",
    			success: function(data) {
    				response($.map(data.userInfoList, function(item) {
    					$("#ui-id-1").appendTo($("#adminUsersDiv"));
    					$("#adminUsersDiv").css("display", "block");
    					$("#ui-id-1").css("z-index", "1050");
    					return {
    						domainAccount: item.name,
    						label: item.name + " " + item.departName
    					};
    				}));
    			}
    		});
    	},
    	focus: function(event, ui) {
    		return false;
    	},
    	select: function(event, ui) {
    		var terms = split(ui.item.domainAccount);
    		var currentInput = "";
    		if ($("#addAdminUser").val().lastIndexOf(',') >= 0) {
    			currentInput = $("#addAdminUser").val().substring(0, $("#addAdminUser").val().lastIndexOf(','));
    		}
    		// 移除当前输入
    		terms.pop();
    		// 添加被选项
    		terms.push(ui.item.value);
    		// 添加占位符，在结尾添加逗号+空格
    		terms.push("");
    		if (currentInput != "") {
    			this.value = currentInput + "," + terms.join(", ");
    		} else {
    			this.value = terms.join(", ");
    		}
    		return false;
    	},
    	minLength: 3,
    	autoFocus: false,
    	delay: 200
    });
    

  });
</script>

</body>
</html>