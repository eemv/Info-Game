<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	background-color: white;
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

#twitch-embed {
	padding-left: 100px;
	padding-right: 100px;
}

#cajaLogo {
	width: 100%;
	height: 100px;
}

#cajaBanner {
	width: 100%;
	height: 100px;
}

#cajaWiki {
	background-color: #fff;
	width: 46%;
	height: 350px;
	margin-left: 2%;
	margin-top: 20px;
	float: left;
	border-radius: 15px;
}

#cajaWiki p {
	margin: 10px;
	font-family: 'Montserrat';
}

#cajaYT {
	background-color: purple;
	width: 46%;
	height: 350px;
	margin-left: 5%;
	margin-top: 20px;
	float: left;
}

#cajaSpotify {
	margin-top: 20px;
	width: 100%;
	height: 200px;
	background-color: #345678;
	float: left;
}

#twitch-embed {
	margin-top: 20px;
	width: 100%;
	height: 400px;
	background-color: #987654;
	float: left;
}

@media ( max-width : 600px) {
	#cajaWiki {
		width: 100%;
		margin-left: 0%;
	}
	#cajaYT {
		width: 100%;
		margin-left: 0%;
	}
}

#encabezado {
	width: 100%;
	background-color: white;
	clear: right;
	margin-bottom: 45px;
}

#encabezado img {
	height: 30px;
	width: 30px;
	float: left;
	margin: 10px;
}

#encabezado h3 {
	text-transform: uppercase;
	text-align: center;
	float: left;
	font-family: 'Fjalla One';
	clear: right;
}

@media ( max-width : 900px) {
	#cajaWiki {
		width: 100%;
		margin-left: 0%;
	}
	#cajaYT {
		width: 100%;
		margin-left: 0%;
	}
}
</style>

</head>
<body>
	<div id="cajaGeneral">
		<div id="cajaLogo">
			<img alt="logo" src="images/logoPequenyo.png"
				style="width: 50%; height: 100%; display: block; margin: auto;">
		</div>

		<div id="cajaBanner">
			<h2
				style="font-size: 1.2em; font-weight: bold; color: #000; margin: 40px 0px 70px; text-align: center; font-family: 'Fjalla One'; letter-spacing: 2px; text-transform: uppercase;">
				Mostrando resultados para:
				<c:out value="${param.searchQuery}" />
			</h2>
		</div>

		<div id="cajaWiki">
			<div id="encabezado">
				<img src="images/wikipedia.png">
				<h3>
					Resultado de Wikipedia para
					<c:out value="${param.searchQuery}" />
				</h3>
			</div>
			<br>
			<p>
				<c:out value="${requestScope.wiki}" />
			</p>
		</div>

		<div id="cajaYT">
			<fieldset id="youtube" style="margin-bottom: 320px;">
				<legend
					style="background-color: red; color: black; padding-left: 20px; font-family: 'Fjalla One'; text-transform: uppercase;">
					<img src="images/youtube.png"
						style="width: 25px; height: 25px; padding-right: 5px;">
					Videos de Youtube de
					<c:out value="${param.searchQuery}" />
				</legend>
				<c:forEach items="${requestScope.videos}" var="video">
					<span style="font-family: 'Montserrat';">
					<iframe id="ytplayer"width="160" height="90"
  			src="http://www.youtube.com/embed/<c:out value="${video.id.videoId}"/>">
  			</iframe>
							</span>
							<form action="YoutubePostServlet" method="POST" >
							<input type="text" name="comment">
							<input type="hidden" name="videoId" value=<c:out value="${video.id.videoId}"/>>
							<input type="submit" value="enviar">
							</form>
					<br />
				</c:forEach>
			</fieldset>
		</div>

		<div id="cajaSpotify">
			
			
			<c:forEach items="${requestScope.playlists}" var="item">
			<iframe
				src="https://open.spotify.com/embed/playlist/
						<c:out value="${item.id}" />"
				width="250" height="80" frameborder="0" allowtransparency="true"
				allow="encrypted-media"></iframe>
			</c:forEach>
			
			
		</div>

		<div id="twitch-embed">
			<h1>
				Streams para
				<c:out value="${param.searchQuery}" />
			</h1>
			<c:forEach items="${requestScope.streams}" var="stream">
				<script src="https://embed.twitch.tv/embed/v1.js"></script>
				<script type="text/javascript">
					var embed = new Twitch.Embed("twitch-embed", {
						width : 400,
						height : 230,
						channel : "${stream.channel.name}",
						layout : "video",
						autoplay : false,
					});
				</script>
			</c:forEach>
		</div>

	</div>
</body>
</html>