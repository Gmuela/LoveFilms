package Models.Business;

import Beans.Film;

import javax.ejb.Remote;
import java.util.ArrayList;

@Remote
public interface FilmBusinessRemote {
    boolean createNewFilm(Film film);
    boolean updateFilm(Film film);
    Film getFilmById(Integer id);
    boolean removeFilm(Film film);
    ArrayList<Film> searchFilmsWithName(String name);

    ArrayList<Film> getFiveLastFilms();

    ArrayList<Film> getFiveBestFilms();
}
