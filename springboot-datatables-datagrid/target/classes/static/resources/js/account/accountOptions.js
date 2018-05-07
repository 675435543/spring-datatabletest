$(function(){
    $.extend( $.fn.dataTable.defaults, {
        searching: false,
        ordering:  false,
    });
    
    $("#tableid").DataTable({
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
        "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
        
        /*scrollXInner: "300px",*/
        "columns":[
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
        ],
/*        "columns":[
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
            {"data":"name",width:"30px",title:"姓名"},
            {"data":"content",width:"30px",title:"描述"},
            {"data":"name",width:"30px",title:"姓名"},
            {"data":"content",width:"30px",title:"描述"},
            {"data":"name",width:"30px",title:"姓名"},
            {"data":"content",width:"30px",title:"描述"}
        ],*/
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
        }
    });
    

});

function show(name,content){
    //用alert模拟弹框的效果
    alert(name+" "+content);
}

