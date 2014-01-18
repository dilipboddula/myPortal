<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en-US">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Slideshow With Buttons</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	font: inherit;
}

body {
	font: 12px/18px Georgia, Serif;
}

ul.ppt {
	position: relative;
	width: 524px;
	margin: 0 auto;
}

/* THREE ON TOP */

/* ONE */

.ppt li {
	position: absolute;
	top: 0;
	left: 0;
	padding: 5px;
	padding-bottom: 1px;
	list-style-type: none;
	background-color: #f2f2f2;
	border: 1px solid #e7e7e7;
}

.ppt img {
	border: 1px solid #222;
	padding: 5px;
	background-color: #444;
}

/* UNDER THIS ALL */

.ppt p {
	color: #333;
	text-align: center;
	padding-bottom: 1px;
}

#buttons {
	width: 230px;
	margin: 0 auto;
}

button {
	padding: 2px;
	background: url(input-top.jpg) repeat-x;
	border: 1px solid #ccc;
	width: 73px;
	margin: 10px auto;
}

button:hover {
	background: url(input-hover.jpg) bottom repeat-x;
}
</style>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript">
$('.ppt li:gt(0)').hide();
$('.ppt li:last').addClass('last');
$('.ppt li:first').addClass('first');
$('#play').hide();

var cur = $('.ppt li:first');
var interval;

$('#fwd').click( function() {
	goFwd();
	showPause();
} );

$('#back').click( function() {
	goBack();
	showPause();
} );

$('#stop').click( function() {
	stop();
	showPlay();
} );

$('#play').click( function() {
	start();
	showPause();
} );

function goFwd() {
	stop();
	forward();
	start();
}

function goBack() {
	stop();
	back();
	start();
}

function back() {
	cur.fadeOut( 1000 );
	if ( cur.attr('class') == 'first' )
		cur = $('.ppt li:last');
	else
		cur = cur.prev();
	cur.fadeIn( 1000 );
}

function forward() {
	cur.fadeOut( 1000 );
	if ( cur.attr('class') == 'last' )
		cur = $('.ppt li:first');
	else
		cur = cur.next();
	cur.fadeIn( 1000 );
}

function showPause() {
	$('#play').hide();
	$('#stop').show();
}

function showPlay() {
	$('#stop').hide();
	$('#play').show();
}

function start() {
	interval = setInterval( "forward()", 3000 );
}

function stop() {
	clearInterval( interval );
}

$(function() {
	start();
} );
</script>
</head>
<body>
<div id="buttons">
<button type="button" id="back">&laquo; Back</button>
<button type="button" id="stop">Pause ||</button>
<button type="button" id="play">Play &raquo;</button>
<button type="button" id="fwd">Forward &raquo;</button>
</div>

<ul class="ppt">
	<li><img src="images/1.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/2.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/3.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/4.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/5.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/6.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/7.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/8.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/9.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/10.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/11.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/12.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/13.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/14.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/15.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/16.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/17.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/18.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/19.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/20.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/21.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/22.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/23.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/24.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/25.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/26.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/27.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/28.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
	<li><img src="images/29.jpg" alt="At Party"></img><p>@Sapient Year End Bash </p></li>
</ul>


</body>
</html>
