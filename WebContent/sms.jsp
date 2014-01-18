<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
 
<script type="text/javascript">
function messaging()
{
    
    var num=9620565079;
    var textmes="HI Shruthi.Ur Payment for Fine on 21-11-13 has been recieved.Kinldy Make a note of it";
    /* $(function(){
        $("#div1").load("http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=dilipboddula.nitw@gmail.com:12345678&senderID=WEBSMS&receipientno="+num+"2&dcs=0&msgtxt=This is Test message&state=4");
      }); */
     window.location = "http://api.mVaayoo.com/mvaayooapi/MessageCompose?user=dilipboddula.nitw@gmail.com:12345678&senderID=WEBSMS&receipientno="+num+"&dcs=0&msgtxt="+textmes+"&state=4";
 }
</script>
</head>
<body>
<input type="button" value="smsMe" onclick="messaging()">
<div id="div1"></div>
</body>
</html>