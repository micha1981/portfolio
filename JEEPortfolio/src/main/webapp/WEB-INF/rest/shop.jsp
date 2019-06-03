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
<link rel="stylesheet" href="css/rest.css" type="text/css" >

<title>Michal Rudnicki - PORTFOLIO</title>
<script src="./scripts/scriptsMenu.js"></script>
<script src="./scripts/rest.js"></script>
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

<div class="rest_container">
<section>
<header class="header_bar">
<a href="/Cars"><div class="logo">portfolio</div> </a>
 <div class="search_input_container" >
  <input class="input_field" type="text" value="" name="search" id="searchForm">
  <div class="input_button" onclick="getCarsListByString()"></div>
</div> 
</header>
<article class="filters_container">	
<form class="filter_frame" action="">
	<select class="select" name="filter" id="filter" onchange="getFilter()">
		<option selected class="option" value="price">Price  -  highest</option>
		<option class="option"value="year">Year - newest</option>
		
	</select>
</form>
</article>
<article class="offers_container" id="offers">	</article>



</section>
</div>	
<script src="./scripts/rest.js"></script>
<script>getCarsFromEndpoint('/api/car');</script>
</body>
</html>
