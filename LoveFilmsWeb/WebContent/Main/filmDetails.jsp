<%@ page import="Beans.Film" %>
<%@ page import="Beans.User" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>LoveFilms</title>
    <link rel="stylesheet" href="../Resources/CSS/filmDetailsStyle.css" type="text/css">
    <%
        Film film = (Film) session.getAttribute("filmDetails");
    %>
</head>
<body>
<%@include file="../Templates/menuBar.html"%>
<div class="filmDetails">
    <img src="<%=film.getImageRoute()%>"/>
    <p><span class="titleFilm"><%=film.getTitle()%></span></p>
    <p>Director: <%=film.getDirector()%></p>
    <p>Actores: <%=film.getActors().toString().replace("[","").replace("]","")%></p>
    <p>Fecha de estreno: <%=film.getReleaseDate()%></p>
    <p>Nota media: <%=film.getAverageNote()%></p>
    <div class="buttons">
        <a href="../Forms/updateFilm.jsp" class="linkEspecial"><button class="button">Modificar</button></a>
        <a class="linkEspecial" href="/LoveFilmsWeb/addFavouriteFilm?idFavouriteFilm=<%=film.getIdFilm()%>">
            <button class="button">Inlcuir en Favoritos</button>
        </a>

        <a href="/LoveFilmsWeb/removeFilm" class="linkEspecial"><button class="button-cancel">Eliminar</button></a>
    </div>
    <div class="summary">
        <p class="summaryTitle">Resumen: </p>
        <p><%=film.getSummary()%></p>
    </div>
</div>
</body>
</html>