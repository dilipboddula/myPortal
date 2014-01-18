<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
       pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  
<script type="text/javascript">
$(function(){
$(function(){
	//alert("in cp func");
	$.ajax({
		url:"NameDisplayServlet",
		data:($("#div1").serialize()),
		success:function(data,status){
			//alert("in success"+data+status);
			$(".nameContainerId").html(data);
		}
	});	
});
});
function validateAssign(){
	if(($("#descriptionId").val().length>230)){		
		alert("Description should be less than 255 charecters ! Kindly Change it!");
	document.submitAssignmentForm.description.focus();
	
}
	else {
		document.submitAssignmentForm.submit();
	}
	
}

</script>
<style type="text/css">
h5{
font-style:Andalus;
font-size: 22;
color: blue;
}
</style>
</head>
<body>
<div id="val1">
<h3>Instructions</h3><br>
<h5>1.If you are Uploading a project which is a team based Assignment,then the Participant<br>
 who have the server in their system only has to upload.Other Participants of the team need not Upload.<br>
 The system will automatically account for all Participants of the team on Successfull upload.<br>
2.If the Assignment is of Individual type,every one has to upload their Project and  dont select any Name in "Name of Your Project Member"<br>

3.Export Your Project as Zip from eclipse.<br>
4.Name of your Project Zip file should be as ProjectName_(First/Last)Name of the Uploader<br>
  eg.If name of the uploader is Dilip Boddula And project Name is BookMyCab then the <br>
  Name of the Zip file that has to be uploaded has to have Name as follows BookMyCab_dilip or BookMyCab_boddula<br>
  Ps:This is only to prevent Your file Overridden by others.<br>
5.URL of the project should be as follows<br> 
   http://[Ip of the Uploader Machine]:[port number of Apache tomcat]/[project Name in eclipse]/[Home Page] <br>
   
   eg http://10.209.60.228:8081/Sapient/index.jsp 

</h5>
<form method="post" action="UploadServlet" enctype="multipart/form-data" name="submitAssignmentForm">

<table >
<tr>
<td>
AssignmentId
</td>
<td>
${param.r1}
<c:set var="assignmentId" value="${param.r1}" scope="session"/>
</td>
<tr>
<td>
Name of ur other Team Member:
</td>
<td>
<div  id="div1" class="nameContainerId"></div><br/>
</td>
</tr>
<tr>
<td>
Project Name
</td>
<td>
<input type="text" name="projectName" id="projectId"><br/>
</td>
</tr>
<tr>
<td>
URL of Project(Refer Instructions Before you write URL)
</td>
<td>
<input type="text" name="url" id="urlId"><br/>
</td>
</tr>
<tr>
<td>
Description about ur project in brief<br>(Give details of Default User and admin Logins also::To test the functionlity)
</td>
<td>
<textarea name="description" id="descriptionId" rows="3" cols="30"></textarea><br>
</td>
</tr>
<tr>
<td>
Select file to upload:(Refer Instructions Before you write URL)
</td>
<td>
<input type="file" name="dataFile" id="fileChooser"/><br/><br/>
</td>
</tr>
</table>
<input type="button" value="Upload" onclick="validateAssign()" />
</form>
</div>
</body>
</html>