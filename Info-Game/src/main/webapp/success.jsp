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
	height: 460px;
	margin-left: 2%;
	margin-top: 20px;
	float: left;
	border-radius: 15px;
}

#cajaWiki p {
	margin: 10px;
	font-family: 'Montserrat';
	text-transform: inherit;
}

#cajaWiki p::first-letter {
	margin: 10px;
	font-family: 'Montserrat';
	text-transform: uppercase;
	letter-spacing: -10px ;
}

#cajaYT {
	background-color: #fff;
	border-radius: 15px;
	width: 46%;
	height: 460px;
	margin-left: 5%;
	margin-top: 20px;
	float: left;
	
}

input[type=submit]{
  background-color: #000; 
  border: none;
  border-radius: 4px;
  color: white;
  padding: 10px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-family: 'Montserrat';
  font-size: 16px;
  cursor: pointer;
}

input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 2px solid black;
  border-radius: 4px;
  font-family: 'Montserrat';
  
  background-color: white;
  background-image: url('images/comentario.png');
  background-size: 25px 25px;
  background-position: 10px 10px; 
  background-repeat: no-repeat;
  padding-left: 40px;
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
	margin-left: -80px;
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


/*MEDIA QUERIES*/
@media ( max-width : 1500px) {
	#cajaLogo img{
	width: 100%;
	height: 100%;
	}

	#cajaWiki {
		width: 100%;
		height: 100%;
		margin-left: 0%;
	}
	
	#cajaYT{
		width:100%;
		height: 100%;
		margin-left: 0%;
	}
	
	#videosYT{
		margin-left:0px;
	}
	
	
	#cajaSpotify {
		width: 100%;
		height: 100%;
		margin-left: 0%;
	}
	
	#cajaSpotify iframe{
		margin-top: 50px;
		margin-left: 50px;
		margin-bottom: 50px;
	}
	#cajaTwitch {
		width: 100%;
		height: 800px;
		margin-left: 0%;
	}
	
	#twitch-embed {
	
	margin-left: 50px;
	
	
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
					Video de
					<c:out value="${param.searchQuery}" />
				</h3>
			</div>
			
			<div id="videosYT">
			<c:set var="count" value="0" scope="page" />
				<c:forEach items="${requestScope.videos}" var="video">
				
					<iframe style="margin-left:-120px; margin-top:20px;"  id="ytplayer"width="400" height="230"
  			src="http://www.youtube.com/embed/<c:out value="${video.id.videoId}"/>">
  					</iframe>
  					
							
							<form style="margin-left:10%;" action="YoutubePostServlet" method="POST" >
							<input style=" width: 70%; heigth: 10%; margin-top:20px; " type="text" name="comment" placeholder=" Introduce tu comentario">
							<input type="hidden" name="videoId" value=<c:out value="${video.id.videoId}"/>>
							<input type="submit" value="Comentar">
							</form>
							
							<form  style="margin-left:10%; " action="YoutubeRateServlet" method="POST" >
							<input name="likedislike" value="like" type="hidden">
							<input type="hidden" name="videoId" value=<c:out value="${video.id.videoId}"/>>
							<input style="width:35px; heigth:35px;" type="image" src="images/likeYT.png"  />
							</form>
			
							<form style="margin-left:10%;  margin-bottom:50px; margin-top:5px; float:left; " action="YoutubeRateServlet" method="POST" >
							<input type="hidden" name="videoId" value=<c:out value="${video.id.videoId}"/>>
							<input name="likedislike" value="dislike" type="hidden">
							<input style="width:35px; heigth:35px;" type="image" src="images/dislike.png"  />
							
							</form>
	
				
				<c:set var="count" value="${count + 1}" scope="page"/>	
			</c:forEach>
			<c:set var = "streams" scope = "session" value = "${requestScope.streams}"/>
			<c:if test="${count == 0}">
         		<img alt="No hay resultados" src="images/noResultadoYT.png" style="width: 350px; height: 100px; margin-left: 50px; margin-top:50px; margin-bottom:50px;  ">
     		 </c:if>
			</div>
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
         		<img alt="No hay" src="images/noResultadoSpotify.png" style="width: 150px; height: 60%;">
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
         		<img alt="No hay" src="images/noResultadoTwitch.png" style="width: 150px; height: 60%;">
     		 </c:if>
			
		</div>
		</div>
	</div>
</body>
</html>