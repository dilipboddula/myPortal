<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fine Portal</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#dateId" ).datepicker({ dateFormat: 'yy-mm-dd' });
  });
  </script>
<!-- <script src="jquery-1.9.1.js"></script>
<script src="jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	$("#dateId").datepicker();
});
</script> -->
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
			$("#div1").html(data);
		}
	});
});
});

</script>
<script type="text/javascript">
<!--
function validateForm(){
	if($("#nameSelectContainerId").val()=="" || $("#nameSelectContainerId").val()=="temp")
	{
		alert("Enter Name !");
		document.fineForm.name.focus();
	}else if($("#amountId").val()==""){
		alert("Enter Amount !");
		document.fineForm.amount.focus();
	}else {
			//alert("in ELse");
			adding();
		}
}
function adding(){
	//alert("ready");
$(function(){
	//alert("in func");
	n1=$("#nameSelectContainerId").val();
	n2=$("#amountId").val();
	n3=$("#dateId").val();
	n4=$("#commentId").val();
	n5=$("#fineTypeId").val();
	alert(n1+" is fined for amount " +n2+" Rs");
		$.ajax({
			type:"GET",
			url:"insert.jsp?name="+n1+"&amount="+n2+"&date="+n3+"&comment="+n4+"&fineType="+n5,
			data:($("input").serialize()),
			success:function(data,status){
				//alert("recieved");
				//alert(data+" "+status);
				$("#val").html(data);
			}});
	});

}
//-->
</script>
</head>
<body>
<%
try{
String adminName=(String)session.getAttribute("myRole");
System.out.println("an"+adminName);
if(adminName.equals("POC"))
{}
}
catch(Exception e)
{
	  response.sendRedirect("AuthAvoid.jsp");
}

%>
<fieldset>
<legend align="left">Fine Portal</legend>
<h2><i><b>Fine Portal</b></i></h2>
<form action ="" name="fineForm" class="form">
<table >
<tr>
<td>Name</td>
<td><div  id="div1" class="nameContainerId"></div></td>
</tr>
<tr>
<td>Amount</td>
<td><input type="text" name="amount" id="amountId" size="30">
</tr>
<tr>
<td>Date</td>
<td><input type="text" name="date" id="dateId" size="30">
</tr>
<tr>
<td>Fine Type</td>
<td><select name="fineType" id="fineTypeId">
<option value="Morning">Morning
<option value="Morning-Tea Break">Morning-Tea Break
<option value="Lunch Break">Lunch Break
<option value="Evening Tea Break">Evening Tea Break
<option value="FaceBooking">FaceBooking
<option value="Others">Others
</select>
</td>
</tr>
<tr>
<td>Enter comments</td>
	<td><textarea  id="commentId" name="comment" ></textarea></td>
</tr>

<tr>
<td><input type="button" value="Submit" class="submit" onclick="validateForm()"></td>
<td><input type="reset" value="clear"></td>
</tr>

</table>
</form>
<div id="val"></div>
</fieldset>
</body>
</html>