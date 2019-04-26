<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Search results</title>
</head>
<body>


<fieldset id="spotify">
<legend>Spotify search for <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.playlists}" var="item">
	<span>Playlist title: <c:out value="${item.name}"/></span><br/>
</c:forEach>
</fieldset>

<fieldset id="twitch">
<legend>Twitch search for <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.streams}" var="stream">
<span>Stream title: <c:out value="${stream.title}"/></span><br/>
</c:forEach>
</fieldset>
<!-- 
  <img src='http://farm<c:out value="${photo.farm}"/>.staticflickr.com/<c:out value="${photo.server}"/>/
	<c:out value="${photo.id}"/>_<c:out value="${photo.secret}"/>.jpg'/>
	

-->	
<fieldset id="youtube">
<legend>Youtube search for <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.videos}" var="video">
<span>Video title: <c:out value="${video.snippet.title}"/></span><br/>
</c:forEach>
</fieldset>
<fieldset id="reddit">
	<legend>Reddit search for <c:out value="${param.searchQuery}"/></legend>
	<ul>
		<c:forEach items="${requestScope.posts}" var="post">
			<li><a href='http://www.reddit.com<c:out value="${post.permalink}"/>'><c:out value="${post.title}"/></a></li>
		</c:forEach>
	</ul>
</fieldset>

</body>
</html>