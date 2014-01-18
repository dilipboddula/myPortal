<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
       pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Batch File Upload</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  
<script type="text/javascript">
function validateBatchForm(){
	 if(($("#fileChooser").val()==""  )){		
			alert("Select File");
			document.batchUploadForm.dataFile.focus();
	}else {
		document.batchUploadForm.submit();
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
<h5>
1.Download sample form and upload the data in the same format <a href="excelfiles/Book1.xls" target="_blank" style="color:red">Downlaod Sample</a> <br>
</h5>
<form method="post" action="batchUploadServlet" enctype="multipart/form-data" name="batchUploadForm">

<table >
<tr>
<td>
Select file to upload:(Refer Instructions Before you Upload)
</td>
<td>
<input type="file" name="dataFile" id="fileChooser"/><br/><br/>
</td>
</tr>
</table>
<input type="button" value="Upload" onclick="validateBatchForm()" />
</form>
</div>
</body>
</html>