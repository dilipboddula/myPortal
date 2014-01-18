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
	if(($("#locationId").val()=="temp" || $("#locationId").val()=="" )){		
		alert("Select Location");
	document.batchUploadForm.location.focus();
	}else if(($("#batchId").val()==""  )){		
		alert("Enter batch");
		document.batchUploadForm.batch.focus();
	}else if(($("#cycleId").val()==""  )){		
			alert("Enter cycle");
			document.batchUploadForm.cycle.focus();
	}else if(($("#stageId").val()==""  )){		
			alert("Enter stage");
			document.batchUploadForm.stage.focus();
	}else {
		addBatch();
	}
	
}
function addBatch(){
	$(function(){
		//alert("in func");			
			$.ajax({
				type:"Post",
				url:"CreateBatchServlet",
				data:($("form").serialize()),
				success:function(data,status){
					//alert("recieved");
					//alert(data+" "+status);
					//$("#CreaCom").html(data);
					//alert(data);
					 //$("#thedialog").html(data);
					$("#val").html(data);
				}});
		});
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
<form name="batchUploadForm">

<table >
<tr>
<td>
Location
</td>
<td>
<select name="location" id="locationId">
	<option value="temp">Select Location
	<option value="Bangalore">Bangalore
	<option value="Gurgaon">Gurgaon
	<option value="Noida">Noida
</select>
</td>
<tr>
<td>
Batch
</td>
<td>
<input type="text" name="batch" id="batchId">
</td>
</tr>
<tr>
<td>
Cycle
</td>
<td>
<input type="text" name="cycle" id="cycleId"><br/>
</td>
</tr>
<tr>
<td>
Stage
</td>
<td>
<input type="text" name="stage" id="stageId"><br/>
</td>
</tr>

</table>
<input type="button" value="Create Batch" onclick="validateBatchForm()" />
</form>
</div>
<div id="val"></div>
</body>
</html>