<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
<a href="AuthController/Spotify" >spoti</a>
<a href="AuthController/Twitch" >twitch</a>
<a href="AuthController/Youtube">yt</a>
<a href="AuthController/Reddit">reddit</a>
     
	<div id="searchDiv">
		<form id="searchForm" action="searchController" method="post">
			<input type="text" name="searchQuery" required/> 
			<input type="submit" name="searchBtn" title="search" value="search">
		</form>
	</div>
	
        <h2> Tokens de OAuth </h2>
        <ul>
            <li><strong>Youtube:</strong>
                <ul>
                    <li><c:choose>
                    <c:when test='${{sessionScope["Youtube-token"]} != null }'>
             <!--         <c:out value='${sessionScope["Spotify-token"]}' ></c:out> -->
                    Token de Youtube cargado
                     </c:when>
                      <c:otherwise>
        				Debe de logearse en Youtube <a href="AuthController/Youtube">aquí</a>
    					</c:otherwise>
    				</c:choose>
                     </li>
                     </ul>
            <li><strong>Spotify:</strong>
                <ul>
                    <li><c:choose>
                    <c:when test='${{sessionScope["Spotify-token"]} != null }'>
                    Token de Spotify cargado
                     </c:when>
                      <c:otherwise>
        				Debe de logearse en Spotify <a href="AuthController/Spotify" >aquí</a>
    					</c:otherwise>
    				</c:choose>
                     </li>
                </ul>
         <li><strong>Twitch:</strong>
                <ul>
                    <li><c:choose>
                    <c:when test='${{sessionScope["Twitch-token"]} != null }'>
             <!--         <c:out value='${sessionScope["Twitch-token"]}' ></c:out> -->
                    Token de Twitch cargado
                     </c:when>
                      <c:otherwise>
        				Debe de logearse en Twitch <a href="AuthController/Twitch">aquí</a>
    					</c:otherwise>
    				</c:choose>
                    <li><strong>Reddit:</strong>
                <ul>
                    <li><c:choose>
                    <c:when test='${{sessionScope["Reddit-token"]} != null }'>
                    Token de Reddit cargado
                     </c:when>
                      <c:otherwise>
        				Debe de logearse en Reddit <a href="AuthController/Reddit" >aquí</a>
    					</c:otherwise>
    				</c:choose>
                     </li>
                </ul>
	
</body>
</html>