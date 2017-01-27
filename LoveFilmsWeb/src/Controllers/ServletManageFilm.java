package Controllers;

import Beans.Film;
import Models.Business.FilmBusinessRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "manageFilm", urlPatterns = "/manageFilm")
public class ServletManageFilm extends HttpServlet {

    @EJB
    private FilmBusinessRemote filmBusiness;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String director = req.getParameter("director");
        String actorsParameter = req.getParameter("actors");
        String imageRoute = req.getParameter("imageRoute");
        String releaseDateParameter = req.getParameter("releaseDate");
        String averageNoteParameter = req.getParameter("averageNote");
        String summary = req.getParameter("summary");
        boolean isRemoved = false;

        String[] split = actorsParameter.split(",");
        ArrayList<String> actors = new ArrayList<String>(Arrays.asList(split));
        LocalDate releaseDate = LocalDate.parse(releaseDateParameter);
        Double averageNote = Double.parseDouble(averageNoteParameter);

        Film film = new Film(title, director, actors, imageRoute, releaseDate, averageNote,summary, isRemoved);

        boolean created = filmBusiness.createNewFilm(film);

        if(created){
            ArrayList<Film> lastFilms = filmBusiness.getFiveLastFilms();
            ArrayList<Film> bestFilms = filmBusiness.getFiveBestFilms();
            HttpSession session = req.getSession(true);
            session.removeAttribute("bestFilms");
            session.removeAttribute("lastFilms");
            session.setAttribute("bestFilms", bestFilms);
            session.setAttribute("lastFilms", lastFilms);
            resp.sendRedirect("/LoveFilmsWeb/Main/mainPage.jsp");
        } else{
            resp.sendRedirect("/LoveFilmsWeb/errorPage.html");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idFilm =  Integer.parseInt(req.getParameter("idFilm"));
        HttpSession session = req.getSession(true);
        Film filmById = filmBusiness.getFilmById(idFilm);
        session.setAttribute("filmDetails", filmById);
        resp.sendRedirect("/LoveFilmsWeb/Main/filmDetails.jsp");
    }
}
