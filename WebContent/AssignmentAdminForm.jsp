<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fine Portal</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#submitDateId" ).datepicker({ dateFormat: 'yy-mm-dd' });
  });
  

function assignmentValidateForm(){
       if($("#assignmentId").val()=="")
       {
             alert("Enter The Task !");
             document.assignmentForm.assignment.focus();
       }else if($("#submitDateId").val()==""){
             alert("Select date !");
             document.assignmentForm.date.focus();
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
<form action ="" name="assignmentForm" class="form">
<table border="2" >
<tr>
<td>Enter Assignment</td>
       <td><textarea  id="assignmentId" name="assignment" ></textarea></td>
</tr>
<tr>
<td>Date Of Submit</td>
<td><input type="text" name="date" id="submitDateId" size="30">
</tr>
<tr>
<td><input type="button" value="Submit" class="submit" onclick="assignmentValidateForm()"></td>
<td><input type="reset" value="clear"></td>
</tr>
</table>
</form>
<div id="val"></div>
</body>
</html>


