<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My View</title>
</head>
<body>
<sql:setDataSource var="mydatabase" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/sapient"

user="root" password="root"/>

<sql:query dataSource="${mydatabase}" var="result">
SELECT * from sapientusers;

</sql:query>

<form action="" name="fineForm">
	 <table border="1" id="fineTableId">		  
	
		<c:forEach var="row" items="${result.rows}">	
	<tr>
	
	    <td><c:out value="${row.userSapientEMail}"/></td>		
		<td><c:out value="${row.userName}"/></td>					
		<%-- <td><c:out value="${row.comment}"/></td> --%>
	</tr>
		</c:forEach>
		 </table>
</form>
</body>
</html>