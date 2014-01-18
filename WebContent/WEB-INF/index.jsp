<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Sapient Nitro - Bangalore Portal</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <script src="myScripts.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs({
      event: "mouseover"
    });
  });
  </script>
</head>
<body>
 
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">About us</a></li>
    <li><a href="UserLogin.jsp">User Login</a></li>
    <li><a href="AdminLogin.jsp">Admin Login</a></li>
    <li><a href="#tabs-4">Gallery</a></li>
  </ul>
  <div id="tabs-1">
    <h3>page under constrution</h3>
    </div>
    </div>
 
</body>
</html>