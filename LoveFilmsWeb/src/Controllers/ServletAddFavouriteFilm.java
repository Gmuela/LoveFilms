package Controllers;

import Beans.Film;
import Beans.User;
import Models.Business.FilmBusinessRemote;
import Models.Business.UserBusinessRemote;

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
import java.util.List;

@WebServlet(name = "addFavouriteFilm", urlPatterns = "/addFavouriteFilm")
public class ServletAddFavouriteFilm extends HttpServlet {

    @EJB
    private FilmBusinessRemote filmBusiness;

    @EJB
    private UserBusinessRemote userBusiness;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Do nothing
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        User user = (User) session.getAttribute("user");
        Integer idFavouriteFilm = Integer.parseInt(req.getParameter("idFavouriteFilm"));
        Film favouriteFilm = filmBusiness.getFilmById(idFavouriteFilm);
        List<Film> favouriteFilms = user.getFavouriteFilms();
        favouriteFilms.add(favouriteFilm);
        boolean added = userBusiness.addFavouriteFilm(user);
        if(added){
            resp.sendRedirect("/LoveFilmsWeb/Main/filmDetails.jsp");
        }
    }
}
