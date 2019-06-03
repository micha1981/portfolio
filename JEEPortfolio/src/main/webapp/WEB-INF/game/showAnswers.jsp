
<%@page import="org.owasp.encoder.Encode"%>
<%@page import="java.util.Map"%>
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
<%PlayerContainer playerContainer = (PlayerContainer)request.getAttribute("playerContainer");
Map<String,String>map = playerContainer.checkAnswares(playerContainer.getClientAnswers(), playerContainer.getCurentVerbs());
%>
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
<h1>English irregular verbs<br><br><br></h1>
</header>


<h2>Infinitive:</h2>
<div class="infinitive"><%=playerContainer.getCurentVerbs().getInfinitive() %></div><br><br><br>
<table class="table">
 	<thead><tr><th></th><th>Correct form</th><th>Your answers</th></tr></thead>
 	<tr><th>Past Simple</th><td><span style="color:green"><%=playerContainer.getCurentVerbs().getPastSimple() %></span></td><td><span style="color:<%=map.get("pastSimple")%>"><%=Encode.forHtml(playerContainer.getClientAnswers()[0])%></span><br></td></tr>
 	<tr><th>Past Participle</th><td><span style="color:green"><%=playerContainer.getCurentVerbs().getPastParticiple() %></span></td><td><span style="color:<%=map.get("pastParticiple")%>"><%=Encode.forHtml(playerContainer.getClientAnswers()[1]) %></span></td></tr>
 	<tfoot><tr><th>points</th><th colspan="2">+ <%=playerContainer.getStageRecordCounter() %></th></tr></tfoot>
 </table>

 <a style="text-decoration: none" href="GameViewer"><input type="submit" value="NextStage" class="start-button" /></a> 
 
 
 
 
 
</section>

</body>
</html>