<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="MyCss/UserLogin.css">
<script src="MyScripts/UserLogin.js"></script>
</head>
<body>
<form id="login" method="post" action="UserLoginCheckServlet" name="myform1">
    <h1 id="ff-proof" class="ribbon">Login &nbsp;&nbsp;</h1>
    <div class="apple">
    	<div class="top"><span></span></div>
    	<div class="butt"><span></span></div>
    	<div class="bite"></div>
	</div>
    <fieldset id="inputs">
    	
        <input name="userSapientEmail" id="userSapientEmailId" type="text" onblur="if(this.value=='')this.value='Sapient Email';" onfocus="if(this.value=='Sapient Email')this.value='';" value="Sapient Email" />
        <input id="password" name="userPassword" type="text" onblur="if(this.value=='')this.value='Password';" onfocus="if(this.value=='Password')this.value='';" value="Password" />
    </fieldset>
    <fieldset id="actions">
        <input type="button" id="submit1" value="Login" onclick="fun()"/>
       <!-- <p class="option"><a href="#">Mot de pass oubli&eacute;</a>&nbsp;&nbsp;|<a href="#">Inscription</a></p> -->
        <input type="button" id="submit1" value="SignUp" onclick="window.location='userRegistrationForm.jsp'">
        
    </fieldset>
</form>
</body>
</html>