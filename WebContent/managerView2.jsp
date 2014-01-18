<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>my View</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
    $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
  });
  </script>
  <style>
  .ui-tabs-vertical { width: 55em; }
  .ui-tabs-vertical .ui-tabs-nav { padding: .2em .1em .2em .2em; float: left; width: 12em; }
  .ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
  .ui-tabs-vertical .ui-tabs-nav li a { display:block; }
  .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
  .ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 40em;}
  </style>
  <style type="text/css">
  #logoutDivId{
  position: absolute;
  left:92%;
  top:0%;
  }
  </style>
  <script type="text/javascript">
  function logout(){
	  $(function(){
			//alert("in func");
			
				$.ajax({
					url:"Logout",
					data:($("input").serialize()),
					success:function(data,status){
						//alert("recieved");
						//alert(data+" "+status);
						$("#main1").html(data);
					}});
			});
  }
  </script>
</head>
<body>
 <div id="main1">
<div id="tabs">
  <ul>
  <li><a href="#tabs-3">Updates</a></li>
     
      <li><a href="awardsView.jsp">All Awards Nominations</a></li>
      <li><a href="GetAllAwardsServlet">Awards Stats</a></li>      
     <li><a href="GetSubmitAssignmentServlet">Assignment Submissions</a></li>
          </ul>
  <div id="tabs-3">
    <h2>Updates</h2>
    Page Under Construction
    </div>
     <div id ="logoutDivId"><input type="button" value="logout" onclick="logout()"></div>
</div>
</div>
</body>
</html> 