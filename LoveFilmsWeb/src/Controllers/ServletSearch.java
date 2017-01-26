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

@WebServlet(name = "deleteFilm", urlPatterns = "/searchFilm")
public class ServletSearch extends HttpServlet {

    @EJB
    private FilmBusinessRemote filmBusiness;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String filmToSearch = req.getParameter("filmToSearch");
        ArrayList<Film> filmsSearch = filmBusiness.searchFilmsWithName(filmToSearch);
        session.setAttribute("filmsSearch", filmsSearch);
        resp.sendRedirect("/LoveFilmsWeb/Main/searchFilms.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Do nothing
    }
}
