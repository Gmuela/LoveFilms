package Models.DAO;

import Beans.Film;
import Beans.User;

import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface UserDAORemote {
    void insert(User user);
    User select(Integer id);
    User selectByName(String name);
    ArrayList<Film> selectFavouriteFilms(User user);
}
