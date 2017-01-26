<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Film" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>LoveFilms</title>
    <link rel="stylesheet" href="../Resources/CSS/mainPageStyle.css" type="text/css">
    <% ArrayList<Film> filmsSearch = (ArrayList<Film>) session.getAttribute("filmsSearch"); %>
</head>
<body>
<%@include file="../Templates/menuBar.html"%>
<div class="mainPageInfo searchFilms">
    <span class="title">Peliculas encontradas</span>
    <%if(filmsSearch.size() != 0){
        for (Film film : filmsSearch) {%>
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