<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.users.SapientUsers"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<SapientUsers> alist=new ArrayList<SapientUsers>();
alist=(ArrayList<SapientUsers>)request.getAttribute("myUsersList");
%>
<table border="1" bgcolor="rgb(238, 17, 203)">	
<tr>
<td><select name="nameSelectContainer" id="nameSelectContainerId" class="nameSelectContainerClass" >
<option value="temp">Select Name
<%
for (SapientUsers v : alist) {
%>
<option value="<%=v.getUserId()%>"><%=v.getUserName()%><%} %>

</select></td>
</tr>
</table>
</body>
</html>