package Models.Business;

import Beans.Film;
import Beans.User;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserBusinessRemote {
    boolean createNewUser(User user);
    User getUserWithId(Integer id);
    List<Film> getFavouriteFilmsOf(User user);
}
