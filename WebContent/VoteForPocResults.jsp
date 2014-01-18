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
 --><script type="text/javascript">
function voteComments(){
	 //var n1=document.form1.r1.value;
	// var n1=document.getElementsByName("r1");
	//var n1= $("input[name='r1']:checked").val();
	//alert(n1);
	// n2=0;
	//alert(n2);
		  $(function(){
				//alert("in func");			
					$.ajax({
						type:"Post",
						url:"GetVoteCommentsServlet",
						data:($("form").serialize()),
						success:function(data,status){
							//alert("recieved");
							//alert(data+" "+status);
							//$("#CreaCom").html(data);
							//alert(data);
							 //$("#thedialog").html(data);
							$("#somediv").html(data);
							$("#somediv").dialog({
					            width: 400,
					            height: 400,
					            modal: true,
					            close: function () {
					            	 $("#thedialog").attr('src', "about:blank");
					            }
					        });
						}});
				});
	  }

function nominate(){
	//var n1= $("input[name='r1']:checked").val();
     confirm("Do u want to Nominate him/her as POC");
		$.ajax({
			type:"Post",
			url:"NominatePocServlet",
			data:($("form").serialize()),
			success:function(data,status){
				//alert("recieved");
				//alert(data+" "+status);
				$("#val").html(data);
			}});
	
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
</head>
<body>
<div id ="VotesId" class="VotesstasticsImage">

<img alt="VoteForPoC" src="graphs/VoteForPocPic${myScopeId}.jpg">

</div>

<%List alist=(List)request.getAttribute("myVotesForPoc");
%>
<form name="form1"action="">
<div id="somediv" >
    <iframe id="thedialog" width="350" height="350"></iframe>
    </div>
<table border="1" >	
  
		<tr>
		<th>Select</th>
		<th>Candidate Name</th>
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
		 <input type="button" id="creaBut" Value="Get Comments" onclick="voteComments()">
		 <input type="button" id="nominateId" Value="Nominate Him/her as Poc" onclick="nominate()">
		 </form>

<div id="val">
</div>
</body>
</html>