<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.scope.BatchDetails"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script type="text/javascript">
function valManager(){
	//alert("hello");
	if(document.batchForm.batchDetails.value=="" || document.batchForm.batchDetails.value=="temp")
    {
     alert("Batch cannot be null");
     document.batchForm.batchDetails.focus(); 
    } else if(document.batchForm.adminRole.value=="" || document.batchForm.adminRole.value=="temp")
    {
        alert("Admin Role cannot be null");
        document.batchForm.adminRole.focus(); 
       }
	else {
		$(function(){
			//alert("in cp func");
			$.ajax({
				type:"POST",
				url:"CreateAdminServlet",
				data:($("form").serialize()),
				success:function(data,status){
					//alert("in success"+data+status);
					$("#val234").html(data);
				}
			});	
		});
	}
}
</script>
</head>
<body>
<%
ArrayList<BatchDetails> alist=new ArrayList<BatchDetails>();
alist=(ArrayList<BatchDetails>)request.getAttribute("myBatchDetails");
%>
<div id="nameContainerId">
<form action="" name="batchForm">
<table border="1" bgcolor="skyblue">	
<tr>
<td>Select Batch </td>
<td><select name="batchDetails" id="batchDetailsId" class="batchDetailsClass"  >
<option value="temp" >Select Name
<%
for (BatchDetails v : alist) {
%>
<option value=<%=v.getScopeId()%>><%=v%><%} %>

</select>
</td>
</tr>
<tr>
	<td>Select Role</td>
	<td><select name="adminRole" id="adminRoleId">
	<option value="temp">Select Role
	<option value="Manager">Manager
</select>
</td>
</tr>
<tr>
	<td>Email</td>
	<td><input type="email" name="adminUserName" placeholder="Email of his/her for logging in"></td>
</tr>
</table>
<input type="hidden" name="manDiffer" value="abc">

</form>
<input type="button" value="create Manager" onclick="valManager()">
</div>
<div id="val234"></div>
</body>
</html>