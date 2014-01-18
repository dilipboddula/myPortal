<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="mydatabase" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/sapient"
	user="root" password="root"/>
	<sql:update dataSource="${mydatabase}" var="result">
	insert into poc(name) values(?);
            <sql:param value="${param.candidateName}" />
	</sql:update>
	
	<c:if test="${result>=1}">
    	<h3> <font size="5" color='green'> ${param.candidateName} is nominated as POC Successfully</font></h3>
	</c:if>
	<c:if test="${result<1}">
     	<font size="5" color='green'>Error in nominating ${param.candidateName} as POC</font>
	</c:if>
	
</body>
</html>