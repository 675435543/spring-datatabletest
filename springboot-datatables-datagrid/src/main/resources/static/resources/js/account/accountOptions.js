$(function(){
    $.extend( $.fn.dataTable.defaults, {
        searching: false,
        ordering:  false,
    });
/*    var columns = "[
            {"data":"name",width:"5%",title:"姓名"},
            {"data":"content",width:"5%",title:"描述"},
            {"data":null,width:"5%",title:"操作"},
            {"data":null,width:"5%",title:"操作2"},
            {"data":"id",width:"5%",title:"描述"},
            {"data":"name",width:"5%",title:"姓名"},
            {"data":"content",width:"5%",title:"描述"},
            {"data":"name",width:"5%",title:"姓名"},
            {"data":"content",width:"5%",title:"描述"},
            {"data":"name",width:"5%",title:"姓名"},
            {"data":"content",width:"5%",title:"描述"},
            {"data":"name",width:"5%",title:"姓名"},
            {"data":"content",width:"5%",title:"描述"},
            {"data":"name",width:"5%",title:"姓名"},
            {"data":"content",width:"5%",title:"描述"},
            {"data":"name",width:"5%",title:"姓名"},
            {"data":"content",width:"5%",title:"描述"}
        ]";
*/    $("#tableid").DataTable({
        //"ajax":"http://localhost:8080/account/findAccountInfoDatatable",
        //"ajax":"/account/findAccountInfoDatatable",
        //"ajax":"findAccountInfoDatatable",
        "ajax":"/static/resources/json/dataOptions.json",
        dom: 'Bfrtlip',
        /*buttons: [ 'copy', 'csv', 'excel' ],*/
        buttons:[
	        	{
	           		"text":"按钮1",
	        		"action":function(){
	        			console.log("我是按钮1");
	        		}
	        	},
	        	{
	           		"text":"按钮2",
	        		"action":function(){
	        			console.log("我是按钮2");
	        		}
	        	}
        	],
        autowidth:false,
        searching: true,
        /*scrollY: "400px",*/
        "scrollCollapse": true,
        "lengthMenu": [[2, 10, 25, 50, 100, -1], [2, 10, 25, 50, 100, "All"]],
        "pageLength": 2,
        /*scrollXInner: "300px",*/
        /*"columns":columns,*/
        "columns":[
            {"data":"name",width:"30px",title:"姓名"},
            {"data":"content",width:"30px",title:"描述"},
            {"data":null,width:"30px",title:"操作"},
            {"data":null,width:"30px",title:"操作2"},
            {"data":"id",width:"30px",title:"描述"},
            {"data":"name",width:"30px",title:"姓名"},
            {"data":"content",width:"30px",title:"描述"},
            {"data":"name",width:"30px",title:"姓名"},
            {"data":"content",width:"30px",title:"描述"},
            {"data":"name",width:"30px",title:"姓名"},
            {"data":"content",width:"30px",title:"描述"},
            {"data":"name",width:"30px",title:"姓名123345"},
            {"data":"content",width:"30px",title:"描述123678"},
            {"data":"name",width:"30px",class:"hiddenCol",title:"姓名"},
            {"data":"content",width:"30px",class:"hiddenCol",title:"描述"},
            {"data":"name",width:"30px",class:"hiddenCol",title:"姓名"},
            {"data":"content",width:"30px",class:"hiddenCol",title:"描述"},
            {"data":"id",width:"30px",title:"描述"}
        ],
        "columnDefs":[
            {
                "targets":2,
                "render":function(data,type,row,meta){
/*                    return '<a href="javascript:void(0)" '+
                        'onclick="show("'+row.name+'","'+row.content+'")" >查看详情</a>';*/
                	/*return "<a href='javascript:void(0);' onclick='show("+row.name+","+row.content+")'>查看详情</a>";*/
                	/*return '<a href="javascript:void(0);" onclick="show("'+row.name+'","'+row.name+'")" >查看详情</a>';*/
                	return '<a href="javascript:void(0);" onclick=show("'+row.name+'","'+row.content+'") >查看详情</a>';
                }
            },{
                "targets":3,
                "visible":false,
                "render":function(data,type,row,meta){
                	return '<a href="javascript:void(0);" onclick=show("'+row.name+'","'+row.content+'") >查看详情</a>';
                }
            },{
                "targets":1,
                "render":function(data,type,row,meta){
                    return data.length > 10 ? data.substr(0,10)+"..." : data;
                }
            },{
                "targets":17,
                "render":function(data,type,row,meta){
                	var operate = "<a href='javascript:void(0);' onclick=\"show('"+row.id+"')\">查看id</a>";
                	var operate2 = '<a href="javascript:void(0);" onclick=show("'+row.id+'")>查看id</a>';
                	return operate;
                }
            }
        ],
        language: {
            "sProcessing": "处理中...",
            "sLengthMenu": "显示 _MENU_ 项结果",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
            "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
            "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
            "sInfoPostFix": "",
            "sSearch": "搜索:",
            "sUrl": "",
            "sEmptyTable": "表中数据为空",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }
        },
        "initComplete": function( settings, json ) {
        	$(".hiddenCol").css("display","none");
            console.log("initComplete");
        }
    });
    

});

function show(id){
    //用alert模拟弹框的效果
    alert("id="+id);
    $("#mydiv").val("id"+id);
/*    debugger;
    window.location.href="/account/helloworld";*/
}

