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
	background-color: #fff;
	border-radius: 15px;
	width: 46%;
	height: 350px;
	margin-left: 5%;
	margin-top: 20px;
	float: left;
	
}

#cajaYT iframe{

	
}


#cajaSpotify {
	background-color: #fff;
	margin-top: 20px;
	width: 100%;
	height: 200px;
	border-radius: 15px;
	float: left;
}

#cajaSpotify iframe{
	margin-left: 30px;
	margin-right: 30px;
}


#cajaTwitch {
	margin-top: 20px;
	width: 100%;
	height: 400px;
	background-color: #fff;
	border-radius: 15px;
	float: left;
	margin-bottom: 100px;
}

#twitch-embed {
	margin-top: 50px;
	margin-left: 20px;
	margin-right: 20px;
	float:left;
	
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


@media ( max-width : 400px) {
	#cajaLogo img{
	width: 100%;
	height: 100%;
	}

	#cajaWiki {
		width: 100%;
		height: 1000px;
		margin-left: 0%;
	}
	#cajaYT {
		width: 100%;
		height: 700px;
		margin-left: 0%;
	}
	#cajaSpotify {
		width: 100%;
		height: 700px;
		margin-left: 0%;
	}
	
	#cajaSpotify iframe{
		margin-top: 50px;
		margin-left: 20%;
	}
	#cajaTwitch {
		width: 100%;
		height: 800px;
		margin-left: 0%;
	}
}


@media ( max-width : 900px) {
	#cajaLogo img{
	width: 100%;
	height: 100%;
	}

	#cajaWiki {
		width: 100%;
		height: 450px;
		margin-left: 0%;
	}
	#cajaYT {
		width: 100%;
		height: 450px;
		margin-left: 0%;
	}
	#cajaSpotify {
		width: 100%;
		height: 650px;
		margin-left: 0%;
	}
	
	#cajaSpotify iframe{
		margin-top: 20px;
		margin-left: 30%;
		margin-right: 100px;
	}
	#cajaTwitch {
		width: 100%;
		height: 800px;
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
					Sinopsis de 
					<c:out value="${param.searchQuery}" />
				</h3>
			</div>
			<br>
			<p>
				<c:out value="${requestScope.wiki}" />
			</p>
		</div>

		<div id="cajaYT">
		<div id="encabezado">
				<img src="images/youtube.png">
				<h3>
					Videos para
					<c:out value="${param.searchQuery}" />
				</h3>
			</div>
			
				<c:forEach items="${requestScope.videos}" var="video">
				<div id="cajitas" style="width:25%; float:left; margin: 0px 180px 0px -150px;">
					<iframe style="margin-left: -100px;"  id="ytplayer"width="300" height="180"
  			src="http://www.youtube.com/embed/<c:out value="${video.id.videoId}"/>">
  					</iframe>
							
							<form action="YoutubePostServlet" method="POST" >
							<input type="text" name="comment">
							<input type="hidden" name="videoId" value=<c:out value="${video.id.videoId}"/>>
							<input type="submit" value="enviar">
							</form>
	
				</div>	
				</c:forEach>
			
		</div>

		<div id="cajaSpotify">
			<div id="encabezado">
				<img src="images/spotify.png">
				<h3>
					Soundtracks para
					<c:out value="${param.searchQuery}" />
				</h3>
			</div>
			<br>
			<c:set var="count" value="0" scope="page" />
			<c:forEach items="${requestScope.playlists}" var="item">
			<iframe
				src="https://open.spotify.com/embed/playlist/
						<c:out value="${item.id}" />"
				width="300" height="100" frameborder="0" allowtransparency="true"
				allow="encrypted-media"></iframe>
			<c:set var="count" value="${count + 1}" scope="page"/>
			</c:forEach>
			<c:set var = "playlist" scope = "session" value = "${requestScope.playlists}"/>
			<c:if test="${count == 0}">
         		<img alt="No hay" src="images/nocanciones.png" style="width: 150px; height: 60%;">TOI TRIZTE
     		 </c:if>
			
		</div>
		<div id="cajaTwitch">
			<div id="encabezado">
				<img src="images/twitch.png">
				<h3>
					Streams para 
					<c:out value="${param.searchQuery}" />
				</h3>
			</div>
			<div id="twitch-embed" >
			<c:set var="count" value="0" scope="page" />
			<c:forEach items="${requestScope.streams}" var="stream">
				<script src="https://embed.twitch.tv/embed/v1.js"></script>
				<script type="text/javascript">
					var embed = new Twitch.Embed("twitch-embed", {
						width : 350,
						height : 200,
						channel : "${stream.channel.name}",
						layout : "video",
						autoplay : false,
					});
				</script>
			<c:set var="count" value="${count + 1}" scope="page"/>	
			</c:forEach>
			<c:set var = "streams" scope = "session" value = "${requestScope.streams}"/>
			<c:if test="${count == 0}">
         		<img alt="No hay" src="images/twitchtriste.jpg" style="width: 150px; height: 60%;">TOI TAMVIEN TRIZTE
     		 </c:if>
			
		</div>
		</div>
	</div>
</body>
</html>