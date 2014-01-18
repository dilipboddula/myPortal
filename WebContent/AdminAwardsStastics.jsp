<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
 <!--  <script type="text/javascript" src="jquery-lightbox/scripts/jquery.lightbox.min.js"></script>
  -->
<script type="text/javascript">
function creativity(){
	 //var n1=document.form1.r1.value;
	// var n1=document.getElementsByName("r1");
	var n1= $("input[name='r1']:checked").val();
	//alert(n1);
	 n2=0;
	//alert(n2);
		  $(function(){
				//alert("in func");			
					$.ajax({
						type:"GET",
						url:"GetCommentsServlet?nomineeId="+n1+"&coreValueId="+n2,
						data:($("form").serialize()),
						success:function(data,status){
							//alert("recieved");
							//alert(data+" "+status);
							//$("#CreaCom").html(data);
							//alert(data);
							 //$("#thedialog").html(data);
							$("#somediv").html(data);
							$("#somediv").dialog({
					            width: 600,
					            height: 400,
					            modal: true,
					            close: function () {
					            	 $("#thedialog").attr('src', "about:blank");
					            }
					        });
						}});
				});
	  }
</script>
<style type="text/css">
#somediv{
width: 400;
height: 450;
background-color: white;
background-image:url("images/getcomments.jpg");
color: black;
display: none;
position: centre;
}
#tableDiv{
position: absolute;
left: 65%;
top:14%;
}

#CreativityImageId{

}

</style>
<script type="text/javascript">$(function(){
				$.Lightbox.construct({
					"show_linkback":	true
				});
			});</script>
</head>
<body>
<div id ="CreativityImageId" class="stasticsImage">
<a rel="lightbox" href="graphs/creativity.jpg">
<img alt="Creativity" src="graphs/creativity${myScopeId}.jpg">
</a>
</div>

<%List alist=(List)request.getAttribute("myCreativityList");
%>
<div id="tableDiv">
<form name="form1"action="" id="form1">
<div id="somediv" >
    <iframe id="thedialog" width="350" height="350"></iframe>
    </div>
<table border="1" id="tableid1">	
  
		<tr>
		<th>Select</th>
		<th>Nominee Name</th>
		<th >No.of nominations</th>
		</tr>		
<%int i=0;for (Object obj : alist) {
    Object[] fields = (Object[]) obj;
   if(i<5){%>	
		<tr>
		<td><input type="radio" name="r1" id="r1" value= <%=fields[2]%> ></td>				
		<td><%out.println(fields[0]); %></td>		
		<td><%out.println(fields[1]); %></td>
		</tr>
		<%}
   else break;
   i++;
		} %>
		<%if (i>=5){ %>
		<tr>
		<td><input type="radio" name="r1" id="r1" value= "0"> </td>				
		<td>others</td>	
		<td></td>
		</tr>
		 <%} %>
		 </table>
		 <input type="button" id="creaBut" Value="Get Comments" onclick="creativity()">
		 </form>
</div>
<div id="CreaCom"></div>

</body>
</html>