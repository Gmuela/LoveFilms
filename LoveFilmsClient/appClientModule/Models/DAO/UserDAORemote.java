package Models.DAO;

import Beans.Film;
import Beans.User;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserDAORemote {
    void insert(User user);
    User select(Integer id);
    User selectByName(String name);
    List<Film> selectFavouriteFilms(User user);
}
