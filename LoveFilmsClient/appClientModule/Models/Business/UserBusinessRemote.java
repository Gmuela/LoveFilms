package Models.Business;

import Beans.Film;
import Beans.User;

import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface UserBusinessRemote {
    boolean createNewUser(User user);
    User getUserWithId(Integer id);
    ArrayList<Film> getFavouriteFilmsOf(User user);
}
