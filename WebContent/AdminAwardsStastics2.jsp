<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript">
function creativity(){
	 //var n1=document.form1.r1.value;
	// var n1=document.getElementsByName("r1");
	var n1= $("input[name='r1']:checked").val();
	alert(n1);
	 n2=0;
	alert(n2);
		  $(function(){
				alert("in func");			
					$.ajax({
						type:"GET",
						url:"GetComments?nomineeId="+n1+"&coreValueId="+n2,
						data:($("form").serialize()),
						success:function(data,status){
							//alert("recieved");
							//alert(data+" "+status);
							$("#CreaCom").html(data);
						}});
				});
	  }
</script>
</head>
<body>
<div id ="CreativityImageId" class="stasticsImage">
<img alt="Creativity" src="graphs/creativity.jpg">
</div>

<%List alist=(List)request.getAttribute("myCreativityList");
%>
<form name="form1"action="">
<table border="1" >	
  
		<tr>
		<th>Select</th>
		<th>Nominee Name</th>
		<th >No.of nominations</th>
		</tr>		
<%for (Object obj : alist) {
    Object[] fields = (Object[]) obj;
   %>	
		<tr>
		<td><input type="radio" name="r1" id="r1" value= <%=fields[2]%> ></td>				
		<td><%out.println(fields[0]); %></td>		
		<td><%out.println(fields[1]); %></td>
		</tr>
		<%} %>
		 </table>
		 <input type="button" id="creaBut" Value="Get Comments" onclick="creativity()">
		 </form>

<div id="CreaCom">
</div>
</body>
</html>