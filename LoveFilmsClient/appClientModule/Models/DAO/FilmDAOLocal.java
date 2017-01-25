package Models.DAO;

import Beans.Film;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface FilmDAOLocal {
    void insert(Film film);
    void update(Film film);
    Film select(Integer id);
    void delete(Film film);
    ArrayList<Film> searchFilmsLike(String name);
    ArrayList<Film> selectFiveBestFilms();

    ArrayList<Film> selectFiveLastFilms();
}
