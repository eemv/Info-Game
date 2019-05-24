<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<title>Info-Game Mashup</title>


<style>
body{

background-image: url('images/fondo.jpg');
background-size: cover;
background-position: center center;
background-repeat: no-repeat;
background-attachment: fixed;
}

input[type=submit]{
  background-color: #8EFFC8; 
  border: none;
  border-radius: 4px;
  color: #862020;
  padding: 15px 16px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-family: 'Montserrat';
  font-size: 16px;
}

#buscador {
  
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 2px solid #8EFFC8;
  border-radius: 4px;
  font-family: 'Montserrat';
 
}

@media (max-width: 750px){
	
	img{
		width:70%;
		height: 
	}
}

</style>


</head>
<body>

	

	<img alt="logo" src="images/logoPequenyo.png"
		style="width: 50%; height: 25%; margin-left: 25%; margin-right: 25%; margin-top: 10%;">
	<div id="searchDiv">
		<form id="searchForm" action="searchController" method="post">
			<input id="buscador" style="width:30%; margin-left: 35%; type="text" name="searchQuery" placeholder="Introduce el nombre del videojuego"
				required /> <br> <input
				style="margin-left: 47%; margin-top: 1%;" type="submit"
				name="searchBtn" title="Buscar" value="Buscar">
		</form>
	</div>

	<div id="autentificacion" style="margin-left: 44%; margin-top: 2%;">
		<h3 style="color: white; font-family: 'Montserrat'; margin-left: -50px;">Acepte los permisos requeridos</h3>
		<a href="AuthController/Spotify"><img alt="Spotify"
			src="images/spotifyLogo.png" style="width: 50px; height: 50px; margin-right: 2%;"></a>
		<a href="/twitchLogIn"><img alt="Twitch"
			src="images/twitchLogo.png" style="width: 50px; height: 50px; margin-right: 2%;"></a>
		<a href="AuthController/Youtube"><img alt="YouTube"
			src="images/youtubeLogo.png" style="width: 50px; height: 50px; margin-right: 2%;"></a>
	</div>
	
</body>
</html>