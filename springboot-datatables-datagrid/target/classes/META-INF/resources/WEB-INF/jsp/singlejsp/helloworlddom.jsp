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

$(document).ready( function () {
    var table = $('#table_id_example').DataTable({
         //这样配置后，即可用DT的API来访问表格数据
        columns: [
            {data: "column1"},
            {data: "column2"}
        ]
    });
    //给行绑定选中事件
     $('#table_id_example tbody').on( 'click', 'tr', function () {
    	 
        if ($(this).hasClass('selected')) {
        	debugger;
            $(this).removeClass('selected');
        }
        else {
        	debugger;
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
    //给按钮绑定点击事件
    $("#table_id_example_button").click(function () {
    	debugger;
    	var column1;
    	var column2;
    	if(table.row('.selected').data() != null){
    		column1 = table.row('.selected').data().column1;
    	}
       	if(table.row('.selected').data() != null){
       		column2 = table.row('.selected').data().column2;
    	}
        alert("第一列内容："+column1 + "；第二列内容： " + column2);
    });
});



var data1 = [
    [
        "Tiger Nixon",
        "System Architect",
        "Edinburgh",
        "5421",
        "2011/04/25",
        "$3,120"
    ],
    [
        "Garrett Winters",
        "Director",
        "Edinburgh",
        "8422",
        "2011/07/25",
        "$5,300"
    ]
];

var data2 = [
    {
        "name":       "Tiger Nixon",
        "position":   "System Architect",
        "salary":     "$3,120",
        "start_date": "2011/04/25",
        "office":     "Edinburgh",
        "extn":       "5421"
    },
    {
        "name":       "Garrett Winters",
        "position":   "Director",
        "salary":     "$5,300",
        "start_date": "2011/07/25",
        "office":     "Edinburgh",
        "extn":       "8422"
    }
];



</script>
    <button id="table_id_example_button">获取选中的行</button>
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
</body>
</html>