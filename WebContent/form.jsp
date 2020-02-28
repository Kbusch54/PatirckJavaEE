<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
	<%@ page errorPage="errorpage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
{
*
 
box-sizing
:
 
border-box
;


}
.column {
	float: left;
	padding: 10px;
	height: 300px;
}

.left {
	width: 65%;
}

.right {
	width: 30%;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>
<meta charset="ISO-8859-1">


<title>My proud jsp demo</title>
</head>
<body bgcolor='#ffc0cb'>
	<h1>${welcomes }</h1>
	<h1><% out.print("byebye"); %></h1>
	<div class="row">
		<div class="column left" style="background-color: #603F83FF;">
			<h1 style="color: #E0C568FF">Is this Patrick?</h1>
			<iframe src="https://giphy.com/embed/EFP6lI49J5Ure" width="300"
				height="200" frameBorder="0" class="giphy-embed" allowFullScreen></iframe>
			<p>
				<a href="https://giphy.com/gifs/EFP6lI49J5Ure">via GIPHY</a>
			</p>
			<p>
				<a
					href="https://giphy.com/gifs/spongebob-squarepants-patrick-bSa7cOkZ2pG2A"></a>
			</p>
		</div>
	
		<div class="column right" style="background-color: #E0C568FF;">
			</br>
			<form action='MyFirstServlet' method='get'>
				<H1 style="color: #603F83FF">Enter your name if you dare</H1>
				<text style="color:#ffc0cb">First name:</text>
				<br> <input type="text" name="firstname" value="Patrick">
				<br>
				<text style="color:#ffc0cb">Last name:</text>
				<br> <input type="text" name="lastname" value="Star"> <br>
				<br> <input type="submit" value="Submit">
				<text style="color:#E0C568FF">Yippie!!!!!</text>
				</form>
		</div>
	</div>
	
</body>
</html>