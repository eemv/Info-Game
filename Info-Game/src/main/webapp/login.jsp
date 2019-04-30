<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url('images/fondo.jpg'); background-size: cover;">
>
	

	<img alt="logo" src="images/logoPequenyo.png"
		style="width: 50%; height: 25%; margin-left: 25%; margin-right: 25%; margin-top: 10%;">
	<div id="searchDiv">
		<form id="searchForm" action="searchController" method="post">
			<input style="width:30%; margin-left: 35%; type="text" name="searchQuery" placeholder="Introduce el nombre del videojuego"
				required /> <br> <input
				style="margin-left: 49%; margin-top: 1%; border: none; background-color: #ff00ff; color: #ffff00;
				 " type="submit"
				name="searchBtn" title="search" value="Buscar">
		</form>
	</div>

	<div id="autentificacion" style="margin-left: 44%; margin-top: 2%;">
		<h3 style="color: white;">Acepte los permisos requeridos</h3>
		<a href="AuthController/Spotify"><img alt="Spotify"
			src="images/spotifyLogo.png" style="width: 50px; height: 50px; margin-right: 2%;"></a>
		<a href="AuthController/Twitch"><img alt="Twitch"
		<a href="/twitchLogIn"><img alt="Twitch"
			src="images/twitchLogo.png" style="width: 50px; height: 50px; margin-right: 2%;"></a>
		<a href="AuthController/Youtube"><img alt="YouTube"
			src="images/youtubeLogo.png" style="width: 50px; height: 50px; margin-right: 2%;"></a>
		<a href="AuthController/Reddit"><img alt="YouTube"
			src="images/redditLogo.png" style="width: 50px; height: 50px; margin-right: 2%;"></a>
	</div>
	
</body>
</html>