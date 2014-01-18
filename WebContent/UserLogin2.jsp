<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<script src="MyScripts/UserLogin.js"></script>
<!-- <script type="text/javascript">
function fun()
{

               if(document.myform1.userName.value=="" ||(document.myform1.userName.value=="temp")
                    {
                     alert(" Name cannot be blank");
                 
                    }
               else if (document.myform1.userPassword.value=="")
               {
                alert("Password cannot be balnk");
                document.myform1.userEmail.focus();
               }
               
               
               else 
                   {
                    //alert("you are registered");
                    document.myform1.submit();
                
                   }
               
}
</script> -->
<style type="text/css">

</style>
</head>
<body >

<form method="post" action="UserLoginCheckServlet" name="myform1" id="myfrom1Id">

<table border="1" bgcolor="skyblue">

<tr>
<td>Sapient Email</td>
<td><input type="text" name="userSapientEmail" id="userSapientEmailId"></td>
</tr>
<tr>
<tr>
<td>Password</td>
    <td><input type ="password" name="userPassword" placeholder="Password"/></td>
</tr>
<tr>
</table>
<input type="button" value="Login" onclick="fun()">
<input type="button" value="New User" onclick="window.location='userRegistrationForm.jsp'">
</form>

</body>
</html>
