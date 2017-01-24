package Models.Business;

import Beans.Film;
import Beans.User;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface UserBusinessLocal {
    boolean createNewUser(User user);
    User getUserWithId(Integer id);
    ArrayList<Film> getFavouriteFilmsOf(User user);
}
