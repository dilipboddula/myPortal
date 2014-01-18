<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!doctype html>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>my View</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
    $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
  });
  </script>
  <style>
  .ui-tabs-vertical { width: 70em; }
  .ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 14em; }
  .ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
  .ui-tabs-vertical .ui-tabs-nav li a { display:block; }
  .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
  .ui-tabs-vertical .ui-tabs-panel { padding: 20px; float: left	; width: 40em;}
   </style>
  <style type="text/css">
  #logoutDivId{
  position: absolute;
  left:92%;
  top:0%;
  }
  </style>
  <script type="text/javascript">
  function logout(){
	  $(function(){
			//alert("in func");
			
				$.ajax({
					url:"Logout",
					data:($("input").serialize()),
					success:function(data,status){
						//alert("recieved");
						//alert(data+" "+status);
						$("#main1").html(data);
					}});
			});
  }
  </script>
  <style type="text/css">
  #NewYearID{
  position: absolute;
  height:30%;
  width:20%;
  left:70%;
  top:25%;
  float: right;
  }
  </style>
</head>
<body>
<sql:setDataSource var="mydatabase" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/training"

user="root" password="root"/>

<sql:query dataSource="${mydatabase}" var="result">

SELECT * from notification where scopeId=${myScopeId};
</sql:query>
<c:forEach var="row" items="${result.rows}">				
		<c:set var="itemName" value="${row.itemName}" scope="request"/>
		<c:set var="defaultTemplate" value="${row.defaultTemplate}" scope="request"/> 
		<c:set var="date" value="${row.date}" scope="request"/>  
</c:forEach>
 <div id="main1">
<div id="tabs">
  <ul>
  <li><a href="#tabs-3">Updates</a></li>   
    <li><a href="GetSubmittedFilesServlet">Update Files</a></li>
      
          </ul>
  <div id="tabs-3">
 	<h1>Admin's View</h1>
    </div>
     <div id ="logoutDivId"><input type="button" value="logout" onclick="logout()"></div>
</div>
</div>
</body>
</html> 