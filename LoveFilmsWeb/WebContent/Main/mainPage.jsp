<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Film" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>LoveFilms</title>
    <link rel="stylesheet" href="../Resources/CSS/mainPageStyle.css" type="text/css">
    <% ArrayList<Film> bestFilms = (ArrayList<Film>) session.getAttribute("bestFilms"); %>
    <% ArrayList<Film> lastFilms = (ArrayList<Film>) session.getAttribute("lastFilms"); %>
</head>
<body>
<%@include file="../Templates/menuBar.html"%>
<div class="mainPageInfo lastFilms">
    <span class="title">Nuevas Peliculas</span>
    <%if(lastFilms.size() != 0){
        for (Film film : lastFilms) {
        	if(!film.isRemoved()){%>
            <div class="film">
                <img src="<%=film.getImageRoute()%>"/>
                <p><a href="/LoveFilmsWeb/manageFilm?idFilm=<%=film.getIdFilm()%>"><%=film.getTitle()%></a></p>
                <p>Director: <%=film.getDirector()%></p>
                <p>Nota media: <%=film.getAverageNote()%></p>
            </div>
            <%}
        }
    }else{
        %><p>No se han encontrado peliculas</p><%
    }%>
</div>
<div class="mainPageInfo bestFilms">
    <span class="title">Peliculas mejor valoradas</span>
    <%if(lastFilms.size() != 0){
        for (Film film : bestFilms) {
        	if(!film.isRemoved()){%>
            <div class="film">
                <img src="<%=film.getImageRoute()%>"/>
                <p><a href="/LoveFilmsWeb/manageFilm?idFilm=<%=film.getIdFilm()%>"><%=film.getTitle()%></a></p>
                <p>Director: <%=film.getDirector()%></p>
                <p>Nota media: <%=film.getAverageNote()%></p>
            </div>
            <%}
        }
    }else{
        %><p>No se han encontrado peliculas</p><%
    }%>
</div>
</body>
</html>