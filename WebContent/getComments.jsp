<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.awards.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#tableId{

}
</style>
</head>
<body>
<%ArrayList<Awards> alist=(ArrayList<Awards>)request.getAttribute("myComments");%>

<%-- <%for (Awards v:alist){%>
<%System.out.println(v.getCoreValue()); %>
  <h1> <%out.println(v.getCoreValue()); %> </h1>
	<h2><%out.println(v.getNomineeName()); %></h2>
	<%break;
} %> --%>

<form action="">
<table border="1" id="tableId" >	
  
		<tr>
		<th>Nominator Name</th>
		<th>Nominee Name</th>
		<th >Reason</th>
		<th >impact</th>
		</tr>		
<%for (Awards v:alist){
   %>	
		<tr>			
		<td><%out.println(v.getNominatorName()); %></td>
		<td><%out.println(v.getNomineeName()); %></td>			
		<td ><%out.println(v.getReason()); %></td>
		<td ><%out.println(v.getImpact()); %></td>
		</tr>
		<%} %>
		 </table>
		 </form>

</body>
</html>