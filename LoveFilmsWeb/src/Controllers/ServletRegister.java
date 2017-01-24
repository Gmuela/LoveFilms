package Controllers;

import Beans.Usuario;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "ServletRegister", urlPatterns = "/register")
public class ServletRegister extends HttpServlet{

    @EJB
    //private UserBusinessRemote userBusiness;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String password = req.getParameter("password");
        LocalDate fechaNacimiento = LocalDate.parse(req.getParameter("fechaNacimiento"));

        Usuario usuario = new Usuario(nombre, password, fechaNacimiento, new ArrayList<>());

        /*boolean created = userBusiness.createUser(usuario);

        if(created){
            resp.sendRedirect("/index.html");
        }*/
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO
    }

}
