<%@page import="org.owasp.encoder.Encode"%>
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
<link rel="stylesheet" href="css/userAccount.css" type="text/css" >

<title>Michal Rudnicki - PORTFOLIO</title>
<script src="./scripts/scriptsMenu.js"></script>
<script src="./scripts/user.js"></script>
<script src="./scripts/jquery.js"></script>
</head>
<body>

<%PlayerContainer playerContainer = (PlayerContainer)request.getAttribute("playerContainer"); %>
<header class="header">
<div class="nav-button" id="navButton" onclick="toogleMenu()"></div>

<div class="log_in" onclick="signIn()" id="login"><%=playerContainer.printUserSignStatus() %></div>
<button class="logout_button" onclick="logOut();">Logout</button>
	<nav class="nav" id="navMenu">
		<a href="/Index" class="nav-item">HOME</a>
		<a href="/GameInitial" class="nav-item">JEE GAME</a>	
		<a href="/Cars" class="nav-item">REST APP</a>
		<a href="/Contact" class="nav-item">CONTACT</a>	
		<div class="nav-item">Site designed and writen by Michal Rudnicki<br><br>northseefish@gmail.com</div>
	</nav>
</header>

<main class="user_account_container">
<article>
<h1> Hello <%=Encode.forHtml(playerContainer.getClientEntity().getLogin())%></h1>

<section class="user_data_item"><h2>Your user name:<span style="color:#ff5a00;"> <%=Encode.forHtml(playerContainer.getClientEntity().getLogin()) %></span></h2><div class="user_account_form"><input class="user_account_input input_unvisible" type="text" id="1"><input class="button" type="submit" value="change" onclick="changeData('1')"></div></section>
<section class="user_data_item"><h2 >Your e-mail:<span style="color:#ff5a00;"><%=Encode.forHtml(playerContainer.getClientEntity().getEmail())%></span></h2><div class="user_account_form"><input class="user_account_input input_unvisible" type="text" id="2"><input class="button" type="submit" value="change" onclick="changeData('2')"></div></section>
<section class="user_data_item"><div class="user_account_form"><input class="user_account_input input_unvisible" type="password" id="3"><input class="button" type="submit" value="change password" onclick="changeData('3')"></div></section>
<section class="user_data_item"><button class="button" type="button" onclick="deleteAccount();">delete account</button></section>
</article>
</main>	
</body>
</html>
