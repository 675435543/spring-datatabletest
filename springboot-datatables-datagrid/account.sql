-- create table `account`
# DROP TABLE `account` IF EXISTS
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
INSERT INTO `account` VALUES ('1', 'aaa', '1000');
INSERT INTO `account` VALUES ('2', 'bbb', '1000');
INSERT INTO `account` VALUES ('3', 'ccc', '1000');
});
<label><i>*</i>域账号:</label>
<input id="addAdminUser"
name="AdminUsers" placeholder="请输入域账号"
onfocus="this.placeholder=''" onblur="this.placeholder='请输入域账号'" style='width:800px'>
<div id="adminUsersDiv" style="display: none;"></div>

$("#addAdminUser" ).autocomplete({
source:function(request,response){
var strs = $("#addAdminUser").val().split(",");
$.ajax({
type: "GET",
url:basePath + "/questmanage/problem/fillUserInfo",
data: { 
"userId":strs[strs.length-1],
"access_token":accessToken 
},
dataType: "json",
success:function(data){
response($.map(data.userInfoList, function(item){
$("#ui-id-1").appendTo($("#adminUsersDiv"));
$("#adminUsersDiv").css("display","block");
$("#ui-id-1").css("z-index","1050");
return {
domainAccount:item.name1,
label:item.name1 +" "+ item.departName
};
}));
}
});
}, 
focus: function( event, ui ) { 
return false; 
}, 
select: function( event, ui ) {
var terms = split( ui.item.domainAccount );
var currentInput = "";
if($("#addAdminUser").val().lastIndexOf(',') >= 0)
{
currentInput = $("#addAdminUser").val().substring(0, $("#addAdminUser").val().lastIndexOf(','));
}
// 移除当前输入
terms.pop();
// 添加被选项
terms.push( ui.item.value );
// 添加占位符，在结尾添加逗号+空格
terms.push( "" );
if(currentInput != "")
{
this.value = currentInput+","+terms.join( ", " );
}
else
{
this.value = terms.join( ", " );
}
return false;
},
minLength: 3,
autoFocus: false, 
delay: 200
});
