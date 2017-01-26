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
import java.util.ArrayList;

@WebServlet(name = "deleteFilm", urlPatterns = "/deleteFilm")
public class ServletDeleteFilm extends HttpServlet {

    @EJB
    private FilmBusinessRemote filmBusiness;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Do nothing
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        Film filmToDelete = (Film) session.getAttribute("filmDetails");

        boolean removed = filmBusiness.removeFilm(filmToDelete);

        if (removed) {
            ArrayList<Film> lastFilms = filmBusiness.getFiveLastFilms();
            ArrayList<Film> bestFilms = filmBusiness.getFiveBestFilms();
            session.removeAttribute("bestFilms");
            session.removeAttribute("lastFilms");
            session.removeAttribute("filmDetails");
            session.setAttribute("bestFilms", bestFilms);
            session.setAttribute("lastFilms", lastFilms);
            resp.sendRedirect("/LoveFilmsWeb/Main/mainPage.jsp");
        } else {
            resp.sendRedirect("/LoveFilmsWeb/errorPage.html");
        }
    }
}