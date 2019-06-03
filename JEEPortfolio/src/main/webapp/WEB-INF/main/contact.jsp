<%@page import="pl.northseefish.portfolio.game.beans.PlayerContainer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css" type="text/css" >
<link rel="stylesheet" href="css/contact.css" type="text/css" >
<title>Michal Rudnicki - PORTFOLIO</title>
<script src="./scripts/scriptsMenu.js"></script>

</head>
<body>
<%PlayerContainer playerContainer = (PlayerContainer)request.getAttribute("playerContainer"); %>
<header class="header">
<div class="nav-button" id="navButton" onclick="toogleMenu()"></div>
<div class="log_in" onclick="signIn()" id="login"><%=playerContainer.printUserSignStatus() %></div>
	<nav class="nav" id="navMenu">
		<a href="/Index" class="nav-item">HOME</a>
		<a href="/GameInitial" class="nav-item">JEE GAME</a>
		<a href="/Cars" class="nav-item">REST APP</a>
		<a href="/Contact" class="nav-item">CONTACT</a>		
		<div class="nav-item">Site designed and writen by Michal Rudnicki<br><br>northseefish@gmail.com</div>
	</nav>
</header>


<section class="contact_container">
	<a class="email" href="mailto:northseefish@gmail.com">
		<img alt="" src="../img/email.jpg">
		<div>michal@rudnicki.org.pl</div>
	</a> 
	<a class="tel" href="tel:+48798536331">
		<img alt="" src="../img/phone.png">
		<div>+ 48 798 536 331</div>
	</a> 
	</section>
	<section class="contact_container">
	<a class="linked" href="https://www.linkedin.com/in/northseefish">
		<img alt="" src="../img/linked.png">
		<div>https://www.linkedin.com/in/northseefish/</div>
	</a> 
	<a class="github" href="https://github.com/micha1981">
		<img alt="" src="../img/github.jpg">
		<div>https://github.com/micha1981</div>
	</a> 
	
	
</section>


</body>
</html>
