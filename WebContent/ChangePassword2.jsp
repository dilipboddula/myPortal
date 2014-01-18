<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  
<script type="text/javascript">

function validateForm(){
	//alert("in validate"+$("#curPasswordId").val());
	if(($("#curPasswordId").val()==""))
		{
			alert("Please enter current Password");
			document.cpForm.curPassword.focus();
			
		} else if(($("#newPasswordId").val()=="")){		
		alert("Please enter New Password");
		document.cpForm.newPassword.focus();
		
	}else if(($("#repNewPasswordId").val()=="")){
		alert("Please enter repeat New Password");
		document.cpForm.repNewPassword.focus();
		
	}else if(($("#newPasswordId").val()!=$("#repNewPasswordId").val())){
		alert("New Password doesnt match with repeated password");
		document.cpForm.newPassword.focus();
	}
	else{
		changingPassword();
	} 
}
 function changingPassword(){
$(function(){
	//alert("in cp func");
	$.ajax({
		type:"post",
		url:"ChangePasswordServlet",
		data:($("input").serialize()),
		success:function(data,status){
			//alert("in success");
			$("#cpformContainerId").html(data);
		}
	});
});
} 

</script>
</head>
<body>
<div id="cpformContainerId">
<form  name="cpForm" action="ChangePasswordServlet">
<table id="cpTableId" >
	<tr>
		<td>Current password</td>
		<td><input type="password" name="curPassword" id="curPasswordId"></td>
	</tr>
	<tr>
		<td>New Password</td>
		<td><input type="password" name="newPassword" id="newPasswordId"></td>
	</tr>
	<tr>
		<td>Repeat new Password</td>
		<td><input type="password" name="repNewPassword" id="repNewPasswordId"></td>
	</tr>
</table>
<input type="hidden" value="def" name="differentiator">
<input type="button" value="change Password" onclick="validateForm()">
</form>
</div>
</body>
</html>