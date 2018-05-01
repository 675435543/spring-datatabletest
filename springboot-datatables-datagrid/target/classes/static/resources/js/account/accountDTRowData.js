$(function(){
    $("#tableid").DataTable({
        "ajax":"/static/resources/json/dataDTRowData.json",
        "columns":[
            {"data":"name",title:"姓名"},
            {"data":"content",title:"描述"},
            {"data":null,title:"操作"}
        ],
        "columnDefs":[
            {
                "targets":2,
                "defaultContent":'<a href="javascript:void(0)" class="view-detail">查看详情</a>'
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
    
    $('#tableid').on('click', 'a', function () {
        //如果有多个按钮，根据class名称区分

        if($(this).hasClass("view-detail")){
            // a标签在td，td 在tr

            // 这里要获取tr的对象，所以是 a标签的父级的父级

            var trObjData = $(this).parent().parent().data("DT_RowData");
            var id = trObjData.id;
            var name = trObjData.name;
            var content = trObjData.content;
            show(name,content);
        }
    });
});


function show(name,content){
    //用alert模拟弹框的效果
    alert(name+" "+content);
}

