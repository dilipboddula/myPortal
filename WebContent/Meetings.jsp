<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meeting</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css">
<script src="scripts/jquery.js"></script>
<script src="scripts/jquery.datetimepicker.js"></script>
  <script>
  $(function() {
    $( "#dateId" ).datetimepicker({format:'d.m.Y H:i'});
  });
  $(function() {
	    $( ".submitDateId" ).datetimepicker({format:'d.m.Y',timepicker: false});
	  });
  $(function(){
	  $(function(){
	  	//alert("in cp func");
	  	$.ajax({
	  		url:"NameMeetingServlet",
	  		data:($("input").serialize()),
	  		success:function(data,status){
	  			//alert("in success"+data+status);
	  			$(".nameContainerId").html(data);
	  		}
	  	});
	  });
	  });

function MeetingValidateForm(){
       if($("#assignmentId").val()=="")
       {
             alert("Enter The Task !");
             document.meetingForm.assignment.focus();
       }else if($("#submitDateId").val()==""){
             alert("Select date !");
             document.meetingForm.date.focus();
       }else {
          //alert("updating assignment task");
              addingAssignment();      
             }
}
function addingAssignment(){
       $(function(){
       //alert("in cp func");
       $.ajax({
    	  type:"post",
          url:"InsertAssignmentServlet",
         data:($("form").serialize()),
         success:function(data,status){
           // alert("in success"+data+status);
            $("#val").html(data);
      }});
    });
} 


//-->
</script>
</head>
<body>
<form action ="" name="meetingForm" class="form">
<table border="2" >
<tr>
	<td>Meeting Heading</td>
       <td ><input type="text" id="meetingHeadingId" name="meetingHeading" ></td>
</tr>
<tr>
<tr>
	<td>Date Of Meeting</td>
	<td><input type="text" name="date" id="dateId" size="30">
</tr>
<tr>
	<td>Attendees</td>
     <td><input type="text" id="meetingHeadingId" name="meetingHeading" ></td>
</tr>
<tr>
		<td>Notes</td>
       <td><textarea  id="assignmentId" name="assignment" ></textarea></td>
</tr>
<tr>
		<td>+ves</td>
       <td><textarea  id="assignmentId" name="assignment" ></textarea></td>
</tr>
<tr>
		<td>Deltas</td>
       <td><textarea  id="assignmentId" name="assignment" ></textarea></td>
</tr>

<tr>
		<th>Next Steps</th>
		<th>Owner</th>
		<th>Due Date</th>
</tr>
<tr>
		<td><input type="text" id="meetingHeadingId" name="meetingHeading" ></td>
		<td><div class="nameContainerId"></div></td>
		<td><input type="text" name="date" class="submitDateId" size="30"></td>
</tr>
<tr>
		<td><input type="text" id="meetingHeadingId" name="meetingHeading" ></td>
		<td><div class="nameContainerId"></div></td>
		<td><input type="text" name="date" class="submitDateId" size="30"></td>
</tr>
<tr>
		<td><input type="text" id="meetingHeadingId" name="meetingHeading" ></td>
		<td><div class="nameContainerId"></div></td>
		<td><input type="text" name="date" class="submitDateId" size="30"></td>
</tr>
<tr>
		<td><input type="text" id="meetingHeadingId" name="meetingHeading" ></td>
		<td><div class="nameContainerId"></div></td>
		<td><input type="text" name="date" class="submitDateId" size="30"></td>
</tr>
<tr>
		<td><input type="text" id="meetingHeadingId" name="meetingHeading" ></td>
		<td><div class="nameContainerId"></div></td>
		<td><input type="text" name="date" class="submitDateId" size="30"></td>
</tr>
<tr>
		<td><input type="text" id="meetingHeadingId" name="meetingHeading" ></td>
		<td><div class="nameContainerId"></div></td>
		<td><input type="text" name="date" class="submitDateId" size="30"></td>
</tr>
<tr>
		<td><input type="text" id="meetingHeadingId" name="meetingHeading" ></td>
		<td><div class="nameContainerId"></div></td>
		<td><input type="text" name="date" class="submitDateId" size="30"></td>
</tr>
<tr>
	<td>Date Of Submit</td>
	<td><input type="text" name="date" class="submitDateId" size="30">
</tr>
<tr>
	<td><input type="button" value="Submit" class="submit" onclick="MeetingValidateForm()"></td>
	<td><input type="reset" value="clear"></td>
</tr>
</table>
</form>
<div id="val"></div>
</body>
</html>


