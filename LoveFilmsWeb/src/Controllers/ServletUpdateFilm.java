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

@WebServlet(name = "updateFilm", urlPatterns = "/updateFilm")
public class ServletUpdateFilm extends HttpServlet {

    @EJB
    private FilmBusinessRemote filmBusiness;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        String title = req.getParameter("title");
        String director = req.getParameter("director");
        String actorsParameter = req.getParameter("actors");
        String imageRoute = req.getParameter("imageRoute");
        String releaseDateParameter = req.getParameter("releaseDate");
        String averageNoteParameter = req.getParameter("averageNote");
        String summary = req.getParameter("summary");

        String[] split = actorsParameter.split(",");
        ArrayList<String> actors = new ArrayList<String>(Arrays.asList(split));
        LocalDate releaseDate = LocalDate.parse(releaseDateParameter);
        Double averageNote = Double.parseDouble(averageNoteParameter);

        Film filmToUpdate = (Film) session.getAttribute("filmDetails");

        filmToUpdate.setTitle(title);
        filmToUpdate.setDirector(director);
        filmToUpdate.setActors(actors);
        filmToUpdate.setImageRoute(imageRoute);
        filmToUpdate.setSummary(summary);
        filmToUpdate.setReleaseDate(releaseDate);
        filmToUpdate.setAverageNote(averageNote);

        boolean updated = filmBusiness.updateFilm(filmToUpdate);

        if(updated){
            ArrayList<Film> lastFilms = filmBusiness.getFiveLastFilms();
            ArrayList<Film> bestFilms = filmBusiness.getFiveBestFilms();
            session.removeAttribute("bestFilms");
            session.removeAttribute("lastFilms");
            session.removeAttribute("filmDetails");
            session.setAttribute("bestFilms", bestFilms);
            session.setAttribute("lastFilms", lastFilms);
            session.setAttribute("filmDetails", filmToUpdate);
            resp.sendRedirect("/LoveFilmsWeb/Main/filmDetails.jsp");
        } else{
            resp.sendRedirect("/LoveFilmsWeb/errorPage.html");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doNothing
    }
}
