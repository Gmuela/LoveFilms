<%@ page import="Beans.Film" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>LoveFilms</title>
    <link rel="stylesheet" href="../Resources/CSS/filmDetailsStyle.css" type="text/css">
    <% Film film = (Film) session.getAttribute("filmDetails");%>
</head>
<body>
<%@include file="../Templates/menuBar.html"%>
<div class="filmDetails">
    <form action="/LoveFilmsWeb/updateFilm" method="post">
    <img src="<%=film.getImageRoute()%>"/>
    <p>Titulo: <input type="text" name="title" id="title" value="<%=film.getTitle()%>"></p>
    <p>Director: <input type="text" name="director" id="director" value="<%=film.getDirector()%>"></p>
    <p>Actores: <input type="text" name="actors" id="actors" value="<%=film.getActors().toString().replace("[","").replace("]","")%>"></p>
    <p>Fecha de estreno: <input type="date" name="releaseDate" id="releaseDate" value="<%=film.getReleaseDate()%>"></p>
    <p>Nota media: <input type="text" name="averageNote" id="averageNote" value="<%=film.getAverageNote()%>"></p>
    <p>Imagen (url): <input type="text" name="imageRoute" id="imageRoute" value="<%=film.getImageRoute()%>"></p>
    <div class="summary">
        <p class="summaryTitle">Resumen: </p>
        <p><textarea name="summary" id="summary"><%=film.getSummary()%></textarea></p>
    </div>
    <div class="buttons">
        <button type="submit" class="button">Actualizar datos</button>
    </div>
</form>
</div>
</body>
</html>