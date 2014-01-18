<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.assignment.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript">
  function fun(){
	  if ($("input[name='r1']:checked").val()==null){
		  alert("select Project Which u want to Upload");
		  
	  }else{
		  //alert("hello");
	  $(function(){
		  //var n1= $("input[name='r1']:checked").val();
			//alert(n1);			
				$.ajax({
					url:"upload.jsp",
					data:($("form").serialize()),
					success:function(data,status){
						//alert("recieved");
						//alert(data+" "+status);
						$("#val").html(data);
					}});
			});
  }
}
  </script>
</head>
<body>
<div id="val">
<form action="">
<table border="1" >	
  
		<tr>
		<th>Select</th>
		<th>Id</th>
		<th >Assignment</th>
		<th>Date of submit</th>	
		</tr>		
<%ArrayList<Assignment> al=(ArrayList<Assignment>)request.getAttribute("myAssignments");
 		 for (Assignment v : al) {	%>	
		<tr>
		<td><input type="radio" name="r1" value=<%=v.getAssignmentId()%>></td>				
		<td><%out.println(v.getAssignmentId()); %></td>		
		<td><%out.println(v.getAssignment()); %></td>		
		<td><%out.println(v.getDate()); %></td>
		</tr>
		<%} %>
		 </table>
		 <input type="button" Value="I have completed my Project and want to upload it" onclick="fun()">
		 </form>
</div>
</body>
</html>