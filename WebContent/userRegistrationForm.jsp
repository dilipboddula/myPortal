<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*;" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body
{
background-image:url('vt-animation-G1.gif');
background-repeat:no-repeat;

}
</style>
<script type="text/javascript">

<!--
function fun()
{

               if(document.myform1.userName.value=="")
                    {
                     alert("name cannot be null");
                     document.myform1.name.focus();
                 
                    }
               else if (document.myform1.userEmail.value=="")
               {
                alert("email cannot be null");
                document.myform1.userEmail.focus();
               }
               
               else if (document.myform1.userPassword.value=="")
                    {
                     alert("password cannot be null");
                     document.myform1.userPassword.focus();
                     
                    }
               else if (document.myform1.userConfirmPassword.value != document.myform1.userPassword.value)
                    {
                     alert("password not matching");
                     document.myform1.userConfirmPassword.focus();
                    
                    }
               else if (document.myform1.userPhone.value=="")
                   {
                    alert("phone number cannot be null");
                    document.myform1.userPhone.focus();
                
                   }
               else if (document.myform1.userGender[0].checked=="" && document.myform1.userGender[1].checked=="")
       		{
       		alert("Select userGender");
       		document.myform.userGender[0].focus();
       		}
               
               else if (document.myform1.userAddress.value=="")
               {
             	  alert("Address cannot be null");
             	  document.myform1.userAddress.focus();
             	  }
               
               else 
                   {
                    //alert("you are registered");
                    document.myform1.submit();
                
                   }
               
}
//-->
//-->

</script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

</head>
<body>
<%
    if(session.getAttribute("myError")=="error"){
%>

<div bgcolor="red">
<h2>User has already Registerd.U can't Register Again</h2>
</div>
<%} %>
<h1 style="color:blue">User Registration Form</h1>
<form name="myform1" action="UserRegisterServlet" method="post" >
<table border="1" bgcolor="rgb(238, 17, 203)">
<tr>
<td>Name</td>
<td><input type="text" name="userName" placeholder="First Name+ Last Name"> </td>
</tr>

<tr>
<td>Sapient email</td>
    <td><input type ="email" name="userSapientEmail" placeholder="Email"/></td>
</tr>
<tr>
<td>Personal email</td>
    <td><input type ="email" name="userEmail" placeholder="Email"/></td>
</tr>
<tr>
<td>Password</td>
    <td><input type ="password" name="userPassword" placeholder="Password"/></td>
</tr>
<tr>
<td>confirmPassword</td>
    <td><input type ="password" name="userConfirmPassword" placeholder="ConfirmPassword"/></td>
</tr>
<tr>
<td>Gender
		<td><input class="a" type ="radio" name="userGender" value="Male"/>Male
      <input class="a" type ="radio" name="userGender" value="Female"/>Female</td>
</tr>
<tr>
<td>phone</td>
    <td><input type ="tel" name="userPhone" placeholder="Phone"/></td>
</tr>

<tr>
<td>Address</td>
    <td><input type ="text" name="userAddress"/></td>
</tr>
</table>

<input type="button" value="Register" onclick="fun()">
</form>
</head>
<body>

</body>
</html>