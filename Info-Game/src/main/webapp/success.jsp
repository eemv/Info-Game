<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<link href="https://fonts.googleapis.com/css?family=Fjalla+One"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<title>Mostrando resultados</title>
<style type="text/css">
body {
	background-image: url("images/fondoPagina.jpg");
	background-size: cover;
}
fieldset {
	border: 1px solid white;
	width: 45%;
	margin-right: 1%;
	float: left;
	color: black;
	background-color: white;;
}
legend {
	padding: 0.2em 0.5em;
	border: 1px solid white;
	font-size: 90%;
	text-align: right;
	color: white;
}
#banner {
	width: 100%;
	height: 5%;
	align-content: center;
}
</style>
</head>
<body>

<div id="banner">
		<img alt="logo" src="images/logoPequenyo.png"
			style="width: 50%; height: 50%; display: block; margin: auto;">
	</div>

	<div id="busqueda"
		style="width: 100%; height: 5%; align-content: center;">
		<h2
			style="font-size: 1.2em; font-weight: bold; color: #000; margin: 40px 0px 70px; text-align: center; font-family: 'Fjalla One'; letter-spacing: 2px; text-transform: uppercase;">
			Mostrando resultados para:
			<c:out value="${param.searchQuery}" />
		</h2>
	</div>

<fieldset id="spotify">
<legend style="background-color: #6FCD7A; color: black; padding-left: 20px; font-family: 'Fjalla One'; text-transform: uppercase;">
			<img src="images/spotify.png"
				style="width: 25px; height: 25px; padding-right: 5px;">SOUNDTRACKS
			PARA
			<c:out value="${param.searchQuery}" />
		</legend>
		<c:forEach items="${requestScope.playlists}" var="item">
			<span style="font-family: 'Montserrat';"><strong><em>Título:</em></strong>
				<c:out value="${item.name}" /></span>
			<br />
		</c:forEach>
</fieldset>

<fieldset id="youtube" style=" margin-bottom: 320px;">
		<legend style="background-color: red; color: black; padding-left: 20px; font-family: 'Fjalla One'; text-transform: uppercase; "><img src="images/youtube.png"
				style="width: 25px; height: 25px; padding-right: 5px;">
			Videos de Youtube de
			<c:out value="${param.searchQuery}" />
		</legend>
		<c:forEach items="${requestScope.videos}" var="video">
			<span style="font-family: 'Montserrat';">-<c:out value="${video.snippet.title}" /></span>
			<br />
		</c:forEach>
	</fieldset>


<fieldset id="twitch" style="float: left;">
		<legend style="background-color: #DB33FF; color: black; padding-left: 20px; font-family: 'Fjalla One'; text-transform: uppercase;"><img src="images/twitch.png"
				style="width: 25px; height: 25px; padding-right: 5px;">
			Contenido de Twitch de
			<c:out value="${param.searchQuery}" />
		</legend>
		<c:forEach items="${requestScope.streams}" var="stream">
			<span>Stream link: <c:out value="${stream.channel.url}" /></span>
			<br />
		</c:forEach>
	</fieldset>

<fieldset id="wikipedia" style="float:left;">
	<legend style="background-color: #FF5733; color: black; padding-left: 20px; font-family: 'Fjalla One'; text-transform: uppercase;"><img src="images/reddit.png"
				style="width: 25px; height: 25px; padding-right: 5px;">Resultado de Wikipedia para <c:out value="${param.searchQuery}"/></legend>
	
	<c:out value="${requestScope.wiki}"/>
	
</fieldset>
</body>
</html>