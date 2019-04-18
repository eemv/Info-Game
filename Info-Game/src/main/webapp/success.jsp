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
<c:forEach items="${requestScope.playlists}" var="playlist">
	<span>Playlist title: <c:out value="${playlist.title}"/></span><br/>
</c:forEach>
</fieldset>
<!--  
<fieldset id="flickr">
<legend>Flickr search for <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.photos.photo}" var="photo">
	<img src='http://farm<c:out value="${photo.farm}"/>.staticflickr.com/<c:out value="${photo.server}"/>/
	<c:out value="${photo.id}"/>_<c:out value="${photo.secret}"/>.jpg'/>
</c:forEach>
</fieldset>
-->
</body>
</html>