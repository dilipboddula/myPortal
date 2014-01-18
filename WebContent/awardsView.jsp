<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.awards.Awards"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Awards View All</title>
</head>
<body>

<form action="" name="awardsViewForm">
	 <table border="1" id="fineTableId">		  
	<tr>
		<th >Award ID</th>
		<th>Nominator</th>
		<th>Nominee</th>
		<th>Core Value</th>
		<th>How it was exhibited?</th>
		<th>Impact on self or others</th>
	</tr>	
		<c:forEach var="row" items="${myAllAwards}">	
	<tr>
		<td><c:out value="${row.awardId}"/></td>				
		<td><c:out value="${row.nominatorName}"/></td>		
		<td><c:out value="${row.nomineeName}"/></td>		
		<td><c:out value="${row.coreValue}"/></td>
		<td><c:out value="${row.reason}"/></td>
		<td><c:out value="${row.impact}"/></td>
	</tr>
		</c:forEach>
		 </table>
</form>

</body>
</html>