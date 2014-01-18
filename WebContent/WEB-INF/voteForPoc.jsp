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
<!--
function validateForm(){
	if($("#candidateId").val()=="" || $("#candidateId").val()=="temp")
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
	n1=$("#candidateId").val();
	n2=$("#commentId").val();
	alert("you are voting for "+n1);
		$.ajax({
			type:"GET",
			url:"voteinsert.jsp?candidateName="+n1+"&comment="+n2,
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
<sql:setDataSource var="mydatabase" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/sapient"

user="root" password="root"/>

<sql:query dataSource="${mydatabase}" var="result">
SELECT * from Sapientvotes where name='${myUserName}';

</sql:query>
<c:forEach var="row" items="${result.rows}">	
	<c:choose>
		<c:when test="${row.name eq myUserName}">
		<font size="5" color='green'>You have already voted</font>
		</c:when>
		</c:choose>
</c:forEach>
		<c:when test="${result<1}">
		<div id="val">
	
	<form action="" name="myform1">
	<table border="1" bgcolor="rgb(238, 17, 203)">
	<tr>
	<td>Name</td>
	<td><select name="candidateName" id="candidateId">
	<option value="temp">Select Name
	<option value="Anil Kumar">Anil Kumar
	<option value="Anuj Sachdev>">Anuj Sachdev
	<option value="Argheesh Bhanot">Argheesh Bhanot
	<option value="Ashutosh Sharma">Ashutosh Sharma
	<option value="Deepak Kumar">Deepak Kumar
	<option value="Dilip Boddula">Dilip Boddula
	<option value="Girjesh Bajpai">Girjesh Bajpai
	<option value="Ishani Dhiman">Ishani Dhiman
	<option value="Killu Satyanarayana">Killu Satyanarayana
	<option value="Mallikarjun Pasunkili">Mallikarjun Pasunkili
	<option value="Parmpreet Singh">Parmpreet Singh 
	<option value="Pinki Biswas">Pinki Biswas
	<option value="Pranab Ghosha">Pranab Ghoshal
	<option value="Prateek Ojha">Prateek Ojha
	<option value="Ranjithraja Subramaniam Mathialagan">Ranjithraja Subramaniam Mathialagan
	<option value="Ravindra Singh">Ravindra Singh
	<option value="Sachin Shetty">Sachin Shetty
	<option value="Saurabh Verma">Saurabh Verma
	<option value="Shruthi Hullatti">Shruthi Hullatti
	<option value="Shubhangi Raj Agrawal">Shubhangi Raj Agrawal
	<option value="Siddhant Kumar">Siddhant Kumar
	<option value="Subramanya Datta">Subramanya Datta
	<option value="Vikash Kumar">Vikash Kumar
	<option value="Vishal Taraiya">Vishal Taraiya
	<option value="Yousuf Hussain">Yousuf Hussain
     </select></td>
	</tr>
	<tr>
		<td>Enter comments</td>
		<td><textarea  id="commentId" name="comment" ></textarea></td>
	</tr>
	</table>
	<input type="button" value="vote" class="submit" onclick="validateForm()">
	</form>
</div>
		</c:when>
	


</body>
</html>