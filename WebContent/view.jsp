<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View</title>
</head>
<body>
<sql:setDataSource var="mydatabase" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/training"

user="root" password="root"/>

<sql:query dataSource="${mydatabase}" var="result">

SELECT * from fines where scopeId='${myScopeId}';
</sql:query>
<form action="" name="fineForm">
	 <table border="1" id="fineTableId">		  
	<tr>
		<th >Name</th>
		<th>Amount</th>
		<th>Date(yyyy-mm-dd)</th>
		<th>Type of Fine</th>
		<!-- <th>Comments</th> -->
	</tr>	
		<c:forEach var="row" items="${result.rows}">	
	<tr>
		<td><c:out value="${row.name}"/></td>				
		<td><c:out value="${row.amount}"/></td>		
		<td><c:out value="${row.date}"/></td>		
		<td><c:out value="${row.fineType}"/></td>
		<%-- <td><c:out value="${row.comment}"/></td> --%>
	</tr>
		</c:forEach>
		 </table>
</form>
Note:*** All Data is with the concern of Fine Collector POC!
</body>
</html>