<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.net.Authenticator,java.net.PasswordAuthentication,java.io.BufferedReader,java.net.*,java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page errorPage="DupVotepage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Vote</title>
</head>
<body>
<%try{ %>
	<sql:setDataSource var="mydatabase" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/sapient"
	user="root" password="root"/>
	<sql:update dataSource="${mydatabase}" var="result">
	insert into SapientVotes(name,candidateName,comment) values(?,?,?);
 			<sql:param value="${myUserName}" />
            <sql:param value="${param.candidateName}" />
             <sql:param value="${param.comment}" />
	</sql:update>
<%}catch (Exception e) {
	System.out.println("error in insertion");
	%>
		<h3><font size="5" color='green'>You have already voted</font></h3>
<%}%>
	<c:if test="${result>=1}">
    	<h3> <font size="5" color='green'> Congratulations ur vote has been casted!</font></h3>
	</c:if>
	<c:if test="${result<1}">
     	<font size="5" color='green'>You have already voted</font>
	</c:if>


</body>
</html>