<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<title>Batch Portal</title>
		<style type="text/css" media="screen">
			
			body{
				background-color: #000;
				
			}
			
			/* Center the website */
			#wrapper{
				width:920px;
				margin:0 auto;
			}
			
			/* Give the header a height and a background image */
			#header{
				height:150px; 
				background: #000 url(images/header/background.jpg) repeat-y scroll left top;
				text-align:center;
			}
			
			/* Create a Shadow Overlay */ 
			#header div{
				width:920px;
				height:300px;
				background: transparent url(images/header/overlay.png) no-repeat scroll  left top;
			}
			
			/* Vertically position header text and style it*/
			#header h1{
				padding-top:50px;
				font-family: Arial, "MS Trebuchet", sans-serif;
				color:white;
				font-size: 52px;
			}
			
			/* Give basic styles to the body and the navigation */
			#body{
				background-color:#efefef;
				 background-image:url("icons/mainLogo.png");
				background-repeat:no-repeat; 
				background-position:center;
				background-repeat:inherit;
				background-position:50%;
			    
				height:500px;
			}
			#nav{
				height:35px;
				background-color: #111;
			}
			}
		</style>
		<style type="text/css">
		#nitro{
		position: absolute;
		left:81%;
		top:20%;
		height: 60%;
		width:19%;
		
		}
		#nitroimage{
		height: 60%;
		width:96.5%;
		}
		</style>
		<!--[if lte IE 6]>
			<style type="text/css" media="screen">
				#header div{
					background-image: none;
					filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='overlay.png', sizingMethod='scale');
				}
			</style>
		<![endif]-->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js" type="text/javascript" charset="utf-8"></script>

	<script type="text/javascript" charset="utf-8">
		
			var scrollSpeed = 10; 		// Speed in milliseconds
			var step = 1; 				// How many pixels to move per step
			var current = 0;			// The current pixel row
			var imageHeight = 4300;		// Background image height
			var headerHeight = 300;		// How tall the header is.
			
			//The pixel row where to start a new loop
			var restartPosition = -(imageHeight - headerHeight);
			
			function scrollBg(){
				
				//Go to next pixel row.
				current -= step;
				
				//If at the end of the image, then go to the top.
				if (current == restartPosition){
					current = 0;
				}
				
				//Set the CSS of the header.
				$('#header').css("background-position","0 "+current+"px");
				
				
			}
			
			//Calls the scrolling function repeatedly
			var init = setInterval("scrollBg()", scrollSpeed);

			
	</script>
	<link rel="stylesheet" href="scripts/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="MyCss/IndexBody.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs({
      beforeLoad: function(event, ui ) {
        ui.jqXHR.error(function() {
          ui.panel.html(
            "" );
        });
      }
    });
  });
  function galleryOpen(){
	  location.reload();
	  window.open('slideshow.html');
  }
  </script>
  <style type="text/css">
/* #tabs-1
{

background-image:url('images/back-ground.jpg');
background-repeat:no-repeat;
padding:300px;
} */
/* #logoId{
position:absolute;
height:;
width:;
left:;
top:;
z-index: -1;
background-position: center;


} */
#myfrom1Id{
position:absolute;
height:0%;
width:100%;
left:16%;
top:170%;
background: transparent;
}
#myform2{
position:absolute;
height:0%;
width:100%;
left:16%;
top:170%;
background: transparent;
}
</style>	
	</head>
	<body>
<!-- 	<div id="nitro"> <img id="nitroimage" src="icons/nitro1.jpg" alt="Sapient Nitro" /> </div> -->
		<div id="wrapper">
			<div id="header">
				
				<!-- Div is for Shadow Overlay-->
				<div>
					<h1>Sapient Nitro &ltd:Buggers/&gt </h1>	
				</div>	
			</div>
			<div id="nav">
				<div id="tabs">
  <ul>
    <li><a href="#tabs-1">AboutUs</a></li>
    <li><a href="UserLogin2.jsp">User Login</a></li>
    <li><a href="AdminLogin.jsp">Admin Login</a></li>
    <li><a href="#" onclick="galleryOpen()">Gallery</a></li> 
  </ul>
  

 
 </div>
			</div>
			<div id="body">
			<!-- 	<img id="logoId" alt="Debugguers" src="icons/mainLogo.png"> -->
			
  <div id="tabs-1" style="">
  
  
   </div>
			</div>
		</div>
	</body>		

	

</html>