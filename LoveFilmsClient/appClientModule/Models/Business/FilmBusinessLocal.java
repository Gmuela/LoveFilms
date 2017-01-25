package Models.Business;

import Beans.Film;

import javax.ejb.Local;
import java.util.ArrayList;

@Local
public interface FilmBusinessLocal {
    boolean createNewFilm(Film film);
    boolean updateFilm(Film film);
    Film getFilmById(Integer id);
    boolean removeFilm(Film film);
    ArrayList<Film> searchFilmsWithName(String name);

    ArrayList<Film> getFiveLastFilms();

    ArrayList<Film> getFiveBestFilms();
}
