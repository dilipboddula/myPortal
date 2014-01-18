<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.scope.*,java.text.DateFormat,java.text.SimpleDateFormat"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript">
function updateForm(){
	if ($("input[name='r1']:checked").val()==null){
		  alert("select File Which u want to Update");
		  
	  }else{
		  //alert("hello");
	  $(function(){
		  var n1= $("input[name='r1']:checked").val();
			//alert(n1);			
				$.ajax({
					url:"UpdateFilesServlet",
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
<form method="post">
<table border="1" >	
  
		<tr>
		<th>Select</th>
		<th>Scope Id</th>
		<th>Location</th>
		<th>Batch</th>
		<th>Cycle</th>
		<th>Stage</th>
		<th>File</th>
		</tr>		
<%ArrayList<BatchDetails> al=(ArrayList<BatchDetails>)request.getAttribute("mySubmittedFiles");
 		 for (BatchDetails v : al) {	%>	
		<tr>
		<td><div ><input type="radio" name="r1" value=<%=v.getScopeId()%>></div></td>
		<td><%out.println(v.getScopeId()); %></td>				
		<td><%out.println(v.getLocation()); %></td>	
		<td><%out.println(v.getBatch()); %></td>	
		<td><%out.println(v.getCycle()); %></td>		
		<td><%out.println(v.getStage()); %></td>	
		<td><a href="excelfiles/<%=v.getFileName()%>" target="_blank">View</a></td>				
				
	   </tr>
		<%} %>
		 </table>
		 <div><input type="button" value="update"   onclick="updateForm()"></div>
		 </form>
		 <div id="val"></div>
</body>
</html>