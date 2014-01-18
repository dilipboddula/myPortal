<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.assignment.*,java.text.DateFormat,java.text.SimpleDateFormat"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" >	
  
		<tr>
		<th>Id</th>
		<th>assignment Id</th>
		<th>Date of Submit</th>
		<th >member1 Name</th>
		<th>member2 Name</th>
		<th>project Name</th>
		<th>project Description</th>
		<th>View Live Project</th>
		<th>Download</th>		
		</tr>		
<%ArrayList<SubmitAssignment> al=(ArrayList<SubmitAssignment>)request.getAttribute("mySubmittedAssignments");
 		 for (SubmitAssignment v : al) {	%>	
		<tr>
		<td><%out.println(v.getSubmitId()); %></td>				
		<td><%out.println(v.getAssignmentId()); %></td>	
		<%DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); %>
		<td><%out.println(dateFormat.format(v.getDate())); %></td>	
		<td><%out.println(v.getMember1Name()); %></td>		
		<td><%out.println(v.getMember2Name()); %></td>
		<td><%out.println(v.getProjectName());%></td>		
		<td><%out.println(v.getProjectDescription()); %></td>	
		
		<td><a href="<%=v.getUrl() %>" target="_blank"> <input type="button" value="open"></a></td>					
		<td><a href="data/<%=v.getFileName() %>" target="_blank"> <input type="button" value="Download"></a></td>	
		</tr>
		<%} %>
		 </table>
</body>
</html>