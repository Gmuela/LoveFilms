package Models.Business;

import Beans.Film;
import Beans.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserBusinessLocal {
    boolean createNewUser(User user);
    User getUserWithId(Integer id);
    List<Film> getFavouriteFilmsOf(User user);

    boolean addFavouriteFilm(User user);
}
