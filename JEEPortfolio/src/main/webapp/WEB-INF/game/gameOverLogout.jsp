<%@page import="pl.northseefish.portfolio.game.beans.ScoreContainer"%>
<%@page import="pl.northseefish.portfolio.game.beans.PlayerContainer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<%PlayerContainer playerContainer = (PlayerContainer)request.getAttribute("playerContainer"); 
ScoreContainer scoreContainer = (ScoreContainer)request.getAttribute("scoreContainer");%>
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
<h1 class="header_main_title">Game Over<br><br><br></h1>
</header>
Your score: <%=playerContainer.getScoreCounter() %>

<br><br><span style="color:red">Only logged users can save their scores</span><br><br><a href="Login">Log in</a>
<form action="GameInitial" >
    <input type="submit" value="Try Again" class="start-button" />
</form>
 
</section>
 <section class="score-table-container">
<h2>Score Table</h2>
<table class="score_table">

<tr><th>pl</th><th>Nick</th><th>Score</th></tr>
<tr><td>1</td><td><%=scoreContainer.getScoresList().get(0).getNick() %></td><td><%=scoreContainer.getScoresList().get(0).getScore() %></td></tr>
<tr><td>2</td><td><%=scoreContainer.getScoresList().get(1).getNick() %></td><td><%=scoreContainer.getScoresList().get(1).getScore() %></td></tr>
<tr><td>3</td><td><%=scoreContainer.getScoresList().get(2).getNick() %></td><td><%=scoreContainer.getScoresList().get(2).getScore() %></td></tr>
<tr><td>4</td><td><%=scoreContainer.getScoresList().get(3).getNick() %></td><td><%=scoreContainer.getScoresList().get(3).getScore() %></td></tr>
<tr><td>5</td><td><%=scoreContainer.getScoresList().get(4).getNick() %></td><td><%=scoreContainer.getScoresList().get(4).getScore() %></td></tr>
</table>
 </section>
</body>
</html>