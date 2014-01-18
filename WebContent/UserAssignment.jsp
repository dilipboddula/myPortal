<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  
<script type="text/javascript">
$(function(){
$(function(){
	//alert("in cp func");
	$.ajax({
		url:"NameDisplayServlet",
		data:($("input").serialize()),
		success:function(data,status){
			//alert("in success"+data+status);
			$(".nameContainerId").html(data);
		}
	});
});
});
</script>
</head>
<body>
<form method="post" action="UploadServlet">
<table >
<tr>
<td>Name of ur Project Member</td>
<td><div  id="div1" class="nameContainerId"></div></td>
</tr>
<tr>
<td>
Select file to upload:</td>
<td><input type="file" name="dataFile" id="fileChooser"/><td></tr>
<tr>
<td>Project Name</td>
<td><input type="text" name="projectName" id="projectId"></td>
</tr>
<tr>
<td>Description about ur project in breif</td>
<td><textarea name="description" id="descriptionId" rows="3" cols="30"></textarea></td>
</tr>
</table>
<input type="submit" value="Upload" />
</form>
</body>
</html>