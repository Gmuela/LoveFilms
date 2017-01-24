package Models.DAO;

import Beans.Film;
import Beans.User;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface UserDAOLocal {
    void insert(User user);
    User select(Integer id);
    User selectByName(String name);
    ArrayList<Film> selectFavouriteFilms(User user);
}
