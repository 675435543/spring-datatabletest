<!--第三步：初始化Datatables-->
$(function(){

    $("#tableid").DataTable({
        //"ajax":"http://localhost:8080/account/findAccountInfoDatatable",
        //"ajax":"/account/findAccountInfoDatatable",
        //"ajax":"findAccountInfoDatatable",
        "ajax":"/static/resources/json/datadeferRender.json",
        "order": [[ 1, 'asc' ]],
        "deferRender": true,
        "columns":[
        	{data:"id","orderable":false},
        	{data:"name"},
            {data:"money"},
        	{data:"money"}
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

	$('#tableid tbody').on( 'click', 'td', function () {
	    alert('Clicked on: '+this.innerHTML);
	    debugger;
	    var trObj = $(this).parent();
	    var trObjData = trObj.data("DT_RowData");
	    
	});
});