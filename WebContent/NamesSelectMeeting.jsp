<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.users.SapientUsers,com.admin.Admin"%>
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
ArrayList<Admin> alist2=new ArrayList<Admin>();
alist2=(ArrayList<Admin>)request.getAttribute("myUsersList2");
%>
<table border="1" bgcolor="skyblue">	
<tr>
<td><select name="nameSelectContainer" id="nameSelectContainerId" class="nameSelectContainerClass" >
<option value="temp">Select Name
<option value="all">All Participants
<option value="supervisor">Supervisor
<%
for (Admin a : alist2) {
%>
<option value="<%=a.getAdminUserName()%>"><%=a.getAdminRole()%><%} %>
<%
for (SapientUsers v : alist) {
%>
<option value="<%=v.getUserId()%>"><%=v.getUserName()%><%} %>

</select></td>
</tr>
</table>
</body>
</html>