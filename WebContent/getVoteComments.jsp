<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.voteForPoc.*"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#tableId{
width: 200;
height: 250;
}
</style>
</head>
<body>

<%ArrayList<Votes> alist=(ArrayList<Votes>)request.getAttribute("myVoteComments");
%>
<form name="form1"action="">

  <%System.out.println("in getvotecomments"); %>
<table border="1" id="tableId" >	
  
		<tr>
		<th>Nominee Name</th>
		<th>Nominator Nam</th>		
		<th >Comments</th>
		</tr>		
<%for (Votes v : alist) {%>
	<tr>
	<td><%out.println(v.getNomineeName()); %></td>
	<td><%out.println(v.getNominatorName()); %></td>
	<td><%out.println(v.getComment()); %></td>
<%} %>
		 </table>
		 </form>

<div id="CreaCom">
</div>
</body>
</html>