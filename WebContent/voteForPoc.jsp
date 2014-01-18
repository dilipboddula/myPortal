<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

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
		alert("Select Name !");
		document.myform1.name.focus();
	}else if($("#commentId").val()==""){
		alert("Enter Comment !");
		document.myform1.comment.focus();
	}else {
			//alert("in ELse");
			adding();
		}
}
function adding(){
	//alert("ready");
$(function(){
	//alert("in func");
	//n1=$("#candidateId").val();
	//n2=$("#commentId").val();
	confirm("Do you want to vote?");
		$.ajax({
			type:"Post",
			url:"VoteInsertServlet",
			data:($("form").serialize()),
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
		<div id="val">
	
	<form action="" name="myform1">
	<table border="1" bgcolor="rgb(238, 17, 203)">
	<tr>
	<td>Name</td>
	<td><div  id="div1" class="nameContainerId"></div></td>
	</tr>
	<tr>
		<td>Enter comments</td>
		<td><textarea  id="commentId" name="comment" ></textarea></td>
	</tr>
	</table>
	<input type="button" value="vote" class="submit" onclick="validateForm()">
	</form>
</div>
</body>
</html>