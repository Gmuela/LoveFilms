package Controllers;

import Beans.User;
import Models.Business.UserBusinessRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ServletRegister", urlPatterns = "/register")
public class ServletRegister extends HttpServlet{

    @EJB
    private UserBusinessRemote userBusiness;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));

        User user = new User(name, password, birthday);

        boolean created = userBusiness.createNewUser(user);

        if(created){
            response.sendRedirect("/LoveFilmsWeb/");
        } else{
            response.sendRedirect("/LoveFilmsWeb/errorPage.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO
    }

}
