<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.net.Authenticator,java.net.PasswordAuthentication,java.io.BufferedReader,java.net.*,java.io.*"%>
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
$(document).ready(function(){
	// alert("in ready");
	 var uphone = document.getElementById("phoneId").value;
	 var uname = document.getElementById("nameId").value;
	 var uamount = document.getElementById("amountId").value;
	 var udate = document.getElementById("dateId").value;
	 var ufineType = document.getElementById("fineTypeId").value;
	 var message="Hi"+uname+".\nYour Payment of Rs."+uamount+" is recieved.Type of fine:"+ufineType+" on "+udate+":-From Fine Collector POC";
	//window.location = "http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=dilipboddula.nitw@gmail.com:123456789&senderID=WEBSMS&receipientno="+uphone+"&dcs=0&msgtxt="+message+"&state=4"; 
	 /* $("#div1").load("http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=dilipboddula.nitw@gmail.com:123456789&senderID=WEBSMS&receipientno="+uphone+"&dcs=0&msgtxt="+message+"&state=4");
}); */
var url="http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=dilipboddula.nitw@gmail.com:123456789&senderID=WEBSMS&receipientno="+uphone+"&dcs=0&msgtxt="+message+"&state=4";
$("#frame").attr("src", url);
 // alert("phone"+uphone);
  //alert("url "+url);
	});
</script>

</head>
<body >
<sql:setDataSource var="mydatabase" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/training"
user="root" password="root"/>
<sql:query dataSource="${mydatabase}" var="result1">
SELECT * from SapientUsers where userId='${param.name}';
</sql:query>
<c:forEach var="row1" items="${result1.rows}">
	
	
	<c:set var="phone" value="${row1.userPhone}" scope="request"/> 
	<c:set var="userName" value="${row1.userName}" scope="request"/>
	<c:set var="email" value="${row1.userEmail}" scope="request"/>
	<c:set var="SapientEmail" value="${row1.userSapientEmail}" scope="request"/> 
	<input TYPE="hidden"  id="phoneId" value="${row1.userPhone}">
</c:forEach>
<sql:update dataSource="${mydatabase}" var="result">
insert into fines(userId,name,amount,date,comment,fineType,scopeId) values(?,?,?,?,?,?,?);
 			<sql:param value="${param.name}" />
 			<sql:param value="${userName}" />
            <sql:param value="${param.amount}" />
             <sql:param value="${param.date}" />
            <sql:param value="${param.comment}" />
            <sql:param value="${param.fineType}" />
            <sql:param value="${myScopeId}" />
</sql:update>
<c:if test="${result>=1}">
    <h3> <font size="5" color='green'> Congratulations ${userName} is fined for ${param.amount}.reason is${param.fineType}.  Data inserted
            successfully.Insert another!</font>
     </h3>
</c:if>
<c:if test="${result<1}">
     <font size="5" color='green'> Error in insertion.</font>
</c:if>
<input TYPE="hidden"  id="nameId" value="${name}">
<input TYPE="hidden"  id="amountId" value="${param.amount}">
<input TYPE="hidden"  id="dateId" value="${param.date}">
<input TYPE="hidden"  id="fineTypeId" value="${param.fineType}">

 <font size="5" color='green'>
Message sent to : ${row1.userPhone} 
Message: Hi ${param.name}
Your Payment of Rs.${param.amount} is recieved.
Type of fine:${param.fineType} on ${param.date}
-From Fine Collector POC
</font>
<div id="divMessage">
URL
<div id="mydiv"><iframe id="frame" src="" width="100%" height="300">
   </iframe></div>
</div>

</body>
</html>