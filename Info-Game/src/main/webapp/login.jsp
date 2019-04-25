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
        <h2> Tokens de OAuth </h2>
        <ul>
            <li><strong>Youtube:</strong>
                <ul>
                    <li><c:out value='${sessionScope["Youtube-token"]}' /> </li>
                </ul>
            </li>
            <li><strong>Spotify:</strong>
                <ul>
                    <li><c:out value='${sessionScope["Spotify-token"]}' /> </li>
                </ul>
            </li>
        </ul>
        <div id="searchDiv">
		<form id="searchForm" action="searchController" method="post">
			<input type="text" name="searchQuery" required/> 
			<input type="submit" name="searchBtn" title="search" value="search">
		</form>
	</div>
        
	<a href="searchbar.jsp">a</a>
</body>
</html>