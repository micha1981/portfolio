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
<title>Michal Rudnicki - PORTFOLIO</title>
<script src="./scripts/scriptsMenu.js"></script>
<script src="./scripts/game.js"></script>

</head>
<body>

<header class="header">
<div class="nav-button" id="navButton" onclick="toogleMenu()"></div>
<div class="log_in" onclick="signIn()" id="login"></div>
	<nav class="nav" id="navMenu">
	<a href="/Index" class="nav-item">HOME</a>
		<a href="/GameInitial" class="nav-item">JEE GAME</a>
		<a href="/Cars" class="nav-item">REST APP</a>
		<a href="/Contact" class="nav-item">CONTACT</a>		
		<div class="nav-item">Site designed and writen by Michal Rudnicki<br><br>northseefish@gmail.com</div>
	</nav>
</header>

<section class="log-container">
<h2 class="header_main_title">Sign in</h2>
<form  action="SignIn" method="post">

<div class="input-container">
<div>login<br><input class="input" type="text" name="login"></div>
<div>password<br><input class="input" type="password" name="password"></div>
</div>

    <input type="submit" value="create new account" class="start-button" />

</form>
<span style="color:red">fields can`t by empty</span>


</section>

</body>
</html>