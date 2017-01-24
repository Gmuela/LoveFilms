package Models.Business;

import Beans.User;
import Models.DAO.UserDAOLocal;

import javax.ejb.EJB;

public class SessionBusiness implements SessionBusinessLocal, SessionBusinessRemote {

    @EJB
    private UserDAOLocal userDAO;

    @Override
    public User login(String userName, String password) {
        User user = userDAO.selectByName(userName);
        String userPassword = user.getPassword();
        return userPassword.equals(password) ? user : null;
    }

}
