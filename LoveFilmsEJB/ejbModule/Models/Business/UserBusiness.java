package Models.Business;

import Beans.Film;
import Beans.User;
import Models.DAO.UserDAOLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class UserBusiness implements UserBusinessLocal, UserBusinessRemote {

    @EJB
    private UserDAOLocal userDAO;

    @Override
    public boolean createNewUser(User user) {
        userDAO.insert(user);
        return true;
    }

    @Override
    public User getUserWithId(Integer id) {
        return userDAO.select(id);
    }

    @Override
    public ArrayList<Film> getFavouriteFilmsOf(User user) {
        return userDAO.selectFavouriteFilms(user);
    }
}
