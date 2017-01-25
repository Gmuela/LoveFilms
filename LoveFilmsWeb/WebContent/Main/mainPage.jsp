<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Film" %>
<!doctype html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
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
        for (Film film : lastFilms) {%>
            <p><%=film.getTitle()%></p><%
        }
    }else{
        %><p>Aún no se añadieron películas</p><%
    }%>
</div>
<div class="mainPageInfo bestFilms">
    <span class="title">Peliculas mejor valoradas</span>
    <%if(lastFilms.size() != 0){
        for (Film film : bestFilms) {%>
            <p><%=film.getTitle()%></p><%
        }
    }else{
        %><p>Aún no se añadieron películas</p><%
    }%>
</div>
</body>
</html>