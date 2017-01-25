package Controllers;

import Beans.Film;
import Beans.User;
import Models.Business.FilmBusinessLocal;
import Models.Business.SessionBusinessRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletSession", urlPatterns = "/session")
public class ServletSession extends HttpServlet {

    @EJB
    SessionBusinessRemote sessionBusiness;

    @EJB
    FilmBusinessLocal filmBusiness;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user");
        String password = req.getParameter("password");
        User user = sessionBusiness.login(userName, password);

        ArrayList<Film> lastFilms = filmBusiness.getFiveLastFilms();
        ArrayList<Film> bestFilms = filmBusiness.getFiveBestFilms();

        if(user != null){
            HttpSession session = req.getSession(true);
            session.setAttribute("user",user);
            session.setAttribute("bestFilms", bestFilms);
            session.setAttribute("lastFilms", lastFilms);
            resp.sendRedirect("/LoveFilmsWeb/Main/mainPage.jsp");
        } else{
            resp.sendRedirect("/LoveFilmsWeb/errorPage.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO
    }
}
