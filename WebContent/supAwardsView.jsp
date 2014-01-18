<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.scope.BatchDetails"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script type="text/javascript">
function stastics(){
	//alert("hello");
	if(document.batchForm.batchDetails.value=="" || document.batchForm.batchDetails.value=="temp")
    {
     alert("Batch cannot be null");
     document.batchForm.batchDetails.focus(); 
    }
	else {
		$(function(){
			//alert("in cp func");
			<%session.setAttribute("myScopeId",0);%>
			var n1=$("#batchDetailsId").val();
			//alert (n1);
			$.ajax({
				type:"POST",
				url:"GetAllAwardsServlet",
				data:($("form").serialize()),
				success:function(data,status){
					//alert("in success"+data+status);
					$("#nameContainerId").html(data);
				}
			});	
		});
	}
}
</script>
</head>
<body>
<%
ArrayList<BatchDetails> alist=new ArrayList<BatchDetails>();
alist=(ArrayList<BatchDetails>)request.getAttribute("myBatchDetails");
%>
<div id="nameContainerId">
<form action="" name="batchForm">
<table border="1" bgcolor="rgb(238, 17, 203)">	
<tr>
<td>Select Batch </td>
<td><select name="batchDetails" id="batchDetailsId" class="batchDetailsClass" >
<option value="temp" >Select Name
<%
for (BatchDetails v : alist) {
%>
<option value=<%=v.getScopeId()%> ><%=v%><%} %>

</select></td>
</tr>
</table>
<input type="button" value="click" onclick="stastics()">
</form>
</div>
<div id="valSupStat"></div>
</body>
</html>