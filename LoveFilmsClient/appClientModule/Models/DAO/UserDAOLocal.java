package Models.DAO;

import Beans.Film;
import Beans.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserDAOLocal {
    void insert(User user);
    User select(Integer id);
    User selectByName(String name);
    List<Film> selectFavouriteFilms(User user);

    boolean insertFavouriteFilmTo(User user);
}
