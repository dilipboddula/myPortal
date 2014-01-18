<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Awards</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  
<script type="text/javascript">
$(function(){
$(function(){
	//alert("in cp func");
	$.ajax({
		url:"NameDisplayServlet",
		data:($("input").serialize()),
		success:function(data,status){
			//alert("in success"+data+status);
			$(".nameContainerId").html(data);
		}
	});
});
});

</script>
<script type="text/javascript">
function validateAwardForm(){
	//alert("in validate"+$("#div1 option:selected").val()+$("#div2 option:selected").val()+$("#div3 option:selected").val());
	if(($("#comCreativityId").val().length<50)){
		alert("Enter the reason for nominating ur friend for Creativity (atleast 50 charecters )");
		document.awardForm.comCreativity.focus();
		
	}  else if(($("#comLeadershipId").val().length<50)){		
		alert("Enter the reason for nominating ur friend for Leadership  (atleast 50 charecters )");
	document.awardForm.comLeadership.focus();
	
}else if(($("#comOpennessId").val().length<50)){
	alert("Enter the reason for nominating ur friend for Openness  (atleast 50 charecters )");
	document.awardForm.comOpenness.focus();
	
}else if(($("#comClientFocusedDeliveryId").val().length<50)){		
		alert("Enter the reason for nominating ur friend for ClientFocusedDelivery  (atleast 50 charecters )");
	document.awardForm.comClientFocusedDelivery.focus();
	
}else if(($("#comRelationshipId").val().length<50)){		
		alert("Enter the reason for nominating ur friend for Relationship  (atleast 50 charecters )");
	document.awardForm.comRelationship.focus();
	
}else if(($("#comPeopleGrowthId").val().length<50)){		
		alert("Enter the reason for nominating ur friend for PeopleGrowth  (atleast 50 charecters )");
	document.awardForm.comPeopleGrowth.focus();
	
}else if(($("#impactCreativityId").val().length<50)){
	alert("Enter the impact for nominating ur friend for Creativity (atleast 50 charecters )");
	document.awardForm.impactCreativity.focus();
	
}  else if(($("#impactLeadershipId").val().length<50)){		
	alert("Enter the impact for nominating ur friend for Leadership  (atleast 50 charecters )");
document.awardForm.impactLeadership.focus();

}else if(($("#impactOpennessId").val().length<50)){
alert("Enter the impact for nominating ur friend for Openness  (atleast 50 charecters )");
document.awardForm.impactOpenness.focus();

}else if(($("#impactClientFocusedDeliveryId").val().length<50)){		
	alert("Enter the impact for nominating ur friend for ClientFocusedDelivery  (atleast 50 charecters )");
document.awardForm.impactClientFocusedDelivery.focus();

}else if(($("#impactRelationshipId").val().length<50)){		
	alert("Enter the impact for nominating ur friend for Relationship  (atleast 50 charecters )");
document.awardForm.impactRelationship.focus();

}else if(($("#impactPeopleGrowthId").val().length<50)){		
	alert("Enter the impact for nominating ur friend for PeopleGrowth  (atleast 50 charecters )");
document.awardForm.impactPeopleGrowth.focus();

}else{
	//alert("no error")
	insertAwardNominations();
} 
}
function insertAwardNominations(){
//alert("in cp func");
$(function(){
	//alert("in cp func");
	$.ajax({
		type:"post",
		url:"AwardsInsertServlet",
		data:($("form").serialize()),
		success:function(data,status){
			//alert("in success");
			$("#awardFormContainerId").html(data);
		}
	});
});
} 

</script>
<style type="text/css">
.nameContainerId{

}
</style>
</head>
<body>
<%
    if(session.getAttribute("myUserId")==null)
	response.sendRedirect("SessionError.jsp");
%>
<div id="awardFormContainerId">
<form name="awardForm" action="AwardsInsertServlet">
<table border="5" bgcolor="Lavender">


<tr>

<td>Creativity</td>
<td><div  id="div1" class="nameContainerId"></div></td>
<td><textarea rows="3" cols="20" id="comCreativityId" name="comCreativity" placeholder="How it was exhibited?"></textarea></td>
<td><textarea rows="3" cols="20" id="impactCreativityId" name="impactCreativity" placeholder="Impact on self or others"></textarea></td>

</tr>
<tr>

<td>Leadership</td>
<td><div id="div2" class="nameContainerId"></div></td>
<td><textarea name="comLeadership" rows="3" cols="20" id="comLeadershipId" placeholder="How it was exhibited?"></textarea></td>
<td><textarea name="impactLeadership" rows="3" cols="20" id="impactLeadershipId" placeholder="Impact on self or others"></textarea></td>
</tr>

<tr>

<td>Openness</td>
<td><div id="div3" class="nameContainerId"></div></td>
<td><textarea name="comOpenness" rows="3" cols="20"  id="comOpennessId" placeholder="How it was exhibited?"></textarea></td>
<td><textarea name="impactOpenness" rows="3" cols="20"  id="impactOpennessId" placeholder="Impact on self or others"></textarea></td>
</tr>

<tr>

<td>ClientFocusedDelivery</td>
<td><div id="div4" class="nameContainerId"></div></td>
<td><textarea name="comClientFocusedDelivery" rows="3" cols="20" id="comClientFocusedDeliveryId" placeholder="How it was exhibited?"></textarea></td>
<td><textarea name="impactClientFocusedDelivery" rows="3" cols="20" id="impactClientFocusedDeliveryId" placeholder="Impact on self or others"></textarea></td>

</tr>

<tr>

<td>Relationship</td>
<td><div id="div5" class="nameContainerId"></div></td>
<td><textarea name="comRelationship" rows="3" cols="20"id="comRelationshipId" placeholder="How it was exhibited?"></textarea><div ></div></td>
<td><textarea name="impactRelationship" rows="3" cols="20"id="impactRelationshipId" placeholder="Impact on self or others"></textarea><div ></div></td>
</tr>

<tr>

<td>People Growth</td>
<td><div id="div6" class="nameContainerId"></div></td>
<td><textarea name="comPeopleGrowth" rows="3" cols="20" id="comPeopleGrowthId" placeholder="How it was exhibited?"></textarea><div ></div></td>
<td><textarea name="impactPeopleGrowth" rows="3" cols="20" id="impactPeopleGrowthId" placeholder="Impact on self or others"></textarea><div ></div></td>
</tr>

</table>
<div id="test"></div>
<input type="button" value="submit" onclick="validateAwardForm()">

</form>
</div> 
</body>
