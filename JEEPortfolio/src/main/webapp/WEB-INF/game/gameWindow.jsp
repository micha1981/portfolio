
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
<link rel="stylesheet" href="css/game.css" type="text/css" >

<title>Irregular verbs game</title>
<script src="./scripts/scriptsMenu.js"></script>
<script src="./scripts/game.js"></script>
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
<section class="game-container">
<header >
<h1 class="header_main_title">English irregular verbs</h1>
</header>
<div class="score_board">
Stage: <%=playerContainer.getStageCounter() %><br>
Points: <%=playerContainer.getScoreCounter() %><br>
Lives: <%=playerContainer.getLives() %>
</div>
<div class="answeres-container">
<h2>Infinitive:</h2>
<div class="infinitive"><%=playerContainer.getCurentVerbs().getInfinitive() %></div>



<form  action="GameViewer" method="post">

<div class="input-container">
<div>Past Simple<br><input class="input" type="text" name="pastSimple"></div>
<div>Past Participle<br><input class="input" type="text" name="pastParticiple"></div>
</div>

    <input type="submit" value="Check answares" class="start-button" />

</form>
</div>

</section>

</body>
</html>