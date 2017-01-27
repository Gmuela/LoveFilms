<%@ page import="Beans.Film" %>
<%@ page import="Beans.User" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>LoveFilms</title>
    <link rel="stylesheet" href="../Resources/CSS/mainPageStyle.css" type="text/css">
    <% User me = (User) session.getAttribute("user");%>
</head>
<body>
<%@include file="../Templates/menuBar.html"%>
<div class="mainPageInfo searchFilms">
    <span class="title">Peliculas favoritas</span>
    <%if(me.getFavouriteFilms().size() != 0){
        for (Film film : me.getFavouriteFilms()) {%>
    <div class="film">
        <img src="<%=film.getImageRoute()%>"/>
        <p><a href="/LoveFilmsWeb/manageFilm?idFilm=<%=film.getIdFilm()%>"><%=film.getTitle()%></a></p>
        <p>Director: <%=film.getDirector()%></p>
        <p>Nota media: <%=film.getAverageNote()%></p>
    </div><%
    }
}else{
%><p>No se han encontrado peliculas con ese nombre</p><%
    }%>
</div>
</body>
</html>