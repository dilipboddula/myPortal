<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Sapient</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="MyCss/IndexBody.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs({
      beforeLoad: function(event, ui ) {
        ui.jqXHR.error(function() {
          ui.panel.html(
            "Couldn't load this tab. We'll try to fix this as soon as possible" );
        });
      }
    });
  });
  </script>
  <style type="text/css">
#tabs-1
{

background-image:url('images/back-ground.jpg');
background-repeat:no-repeat;
padding:300px;
}
</style>
</head>
<body>
 
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">AboutUs</a></li>
    <li><a href="UserLogin2.jsp">User Login</a></li>
    <li><a href="AdminLogin.jsp">Admin Login</a></li>
    <li><a href="slideshow.html">Gallery</a></li> 
  </ul>
  

  <div id="tabs-1">
  
   </div>
 
 </div>
</body>
</html>