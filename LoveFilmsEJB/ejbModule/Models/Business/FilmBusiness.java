package Models.Business;

import Beans.Film;
import Models.DAO.FilmDAOLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class FilmBusiness implements FilmBusinessLocal, FilmBusinessRemote {

    @EJB
    private FilmDAOLocal filmDAO;

    @Override
    public boolean createNewFilm(Film film) {
        filmDAO.insert(film);
        return true;
    }

    @Override
    public boolean updateFilm(Film film) {
        filmDAO.update(film);
        return true;
    }

    @Override
    public Film getFilmById(Integer id) {
        return filmDAO.select(id);
    }

    @Override
    public boolean removeFilm(Film film) {
        filmDAO.delete(film);
        return true;
    }

    @Override
    public ArrayList<Film> searchFilmsWithName(String name) {
        return filmDAO.searchFilmsLike(name);
    }

    @Override
    public ArrayList<Film> getFiveLastFilms() {
        return filmDAO.selectFiveLastFilms();
    }

    @Override
    public ArrayList<Film> getFiveBestFilms() {
        return filmDAO.selectFiveBestFilms();
    }

    @Override
    public ArrayList<Film> getAllFilms() {
        return filmDAO.selectAllFilms();
    }
}
