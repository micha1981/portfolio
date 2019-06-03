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

<div class="container">
<section>
	<article>
		<div class="header-image-content">
			<header class="header-text-content">
				<h1>System.out.println<span style="font-size:0;"> </span>("<span style="color:#c8543b;">hello</span>");</h1>
				<h3><br><br>WELCOME TO MY PORTFOLIO</h3>
			</header>
		</div>
			<div class="about anim-left" >
				<div class="about-image" ></div>
				<h2 style="about-my-name">Michal Rudnicki</h2>
				
				
				
				<h3 class="about-descryption">Hi, my name is Michal Rudnicki. I`m beginning software developer oriented 
				 on technologies related to providing web services.</h3>
				 
			</div>
		<h1 class="center-tech anim-right">Technologies that I`m using:</h1> 
		<div class="aboutme-container " >
		
	
		<div class="aboutme-container-content anim-left gray-background">
			<div class="aboutme-container-pic"><img src="img/linux-icon.png" alt="linux" height="200" width="200"></div>
			<ul>
					<li>I`m familiar with linux console</li>
					<li>I know how to manage linux system and applications</li>
					<li>I can managing linux servers like: mysql, tomcat, wildcat etc.</li>
				</ul>
		</div>
		
	<div class="aboutme-double-container">	 
		<div class="aboutme-container-content anim-left">
			<div class="aboutme-container-pic"><img src="img/j2ee-icon.png" alt="J2EE" height="200" width="200"></div>
				<ul>
					<li>Developing JEE applications from project to deploy</li>
					<li>Implementing Java Beans </li>
					<li>Using JAX-RS to build REST applications </li>
					<li>Using Hibernate and ORM model</li>
				</ul>
		</div>
		<div class="aboutme-container-content anim-right">
			<div class="aboutme-container-pic"><img src="img/maven-icon.png" alt="J2EE" height="180" width="250"></div>
			
			<ul>
					<li>Developing applications with Maven</li>
					<li>Menaging dependencies </li>
					<li>Using Maven from creating a project to deploy on server </li>
					
				</ul>
		</div>
	</div>
	
		<div class="aboutme-container-content anim-left gray-background">
			<div class="aboutme-container-pic"><img src="img/sql.png" alt="embedded" height="150" width="300"></div>
				<ul>
					<li>Installing and configuring MySQL server</li>
					<li>Managing SQL server</li>
					<li>Creating queries to get and save server data </li>
				</ul>
		</div>
	<div class="aboutme-double-container">		
		<div class="aboutme-container-content anim-left">
			<div class="aboutme-container-pic"><img src="img/git-icon.png" alt="git" height="200" width="200"></div>
			<h2>.git</h2>
		</div>
	
		<div class="aboutme-container-content anim-right">
			<div class="aboutme-container-pic"><img src="img/web-icon.png" alt="web" height="200" width="200"></div>
				<ul>
					<li>Creating Web pages with HTML</li>
					<li>Creating and styling RWD sites with CSS</li>
					<li>Using Java Script in frontend layer</li>
				</ul>
		</div>
	</div>	
	</div>
	</article>
	
</section>
</div>	

</body>
</html>