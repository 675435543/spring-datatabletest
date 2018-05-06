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

$(document).ready(function(){
 	$('#example').dataTable({
 	    "data": data2,
	    "columns": [
	        { "data": "name" },
	        { "data": "position" },
	        { "data": "office" },
	        { "data": "extn" },
	        { "data": "start_date" },
	        { "data": "salary" }
	    ]
	});
	
    $('#example2').DataTable( {
        data: [
            new Employee( "Tiger Nixon", "System Architect", "$3,120", "Edinburgh" ),
            new Employee( "Garrett Winters", "Director", "$5,300", "Edinburgh" )
        ],
        columns: [
            { data: 'name' },
            { data: 'salary' },
            { data: 'office()' },
            { data: 'position' }
        ]
    });
    
/* 	$('#example').dataTable({
 	    "data": data3,
 	    "columns": [
 	        { data: 0 },
 	        { data: 1 },
 	        { data: 2 },
 	        { data: 3 },
 	        { data: 4 },
 	        { data: 5 }
 	    ]
	}); */
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

/* var data3 = [
    [
        "Tiger Nixon",
        "System Architect",
        "$320,800",
        "2011/04/25",
        "Edinburgh",
        "5421"
    ]
];
 */
function Employee ( name, position, salary, office ) {
    this.name = name;
    this.position = position;
    this.salary = salary;
    this._office = office;

    this.office = function () {
        return this._office;
    }
};

</script>
<button class="default" id="button1" >点一下喽</button>
	<table id="example" class="display"></table>
	<table id="example2" class="display"></table>
	<table id="example3" class="display"></table>
</body>
</html>