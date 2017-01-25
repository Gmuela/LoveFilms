package Models.DAO;
import Beans.Film;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;

@Stateless
public class FilmDAO implements FilmDAOLocal,FilmDAORemote {

    @PersistenceContext(unitName="PersistenceUnit")
    private EntityManager manager;

    @Override
    public void insert(Film film) {
        manager.persist(film);
    }

    @Override
    public void update(Film film) {
        manager.persist(film);
        manager.merge(film);
    }

    @Override
    public Film select(Integer id) {
        return manager.find(Film.class, id);
    }

    @Override
    public void delete(Film film) {
        manager.remove(film);
    }

    @Override
    public ArrayList<Film> searchFilmsLike(String name) {
        String toQuery = "SELECT films from Film films where films.title like :name";
        Query query = manager.createQuery(toQuery);
        name = "%"+name+"%";
        query.setParameter("name", name);
        return (ArrayList<Film>) query.getResultList();
    }

    @Override
    public ArrayList<Film> selectFiveBestFilms(){
        String toQuery = "SELECT films from Film films order by films.averageNote desc";
        Query query = manager.createQuery(toQuery);
        query.setMaxResults(5);
        return (ArrayList<Film>) query.getResultList();
    }

    @Override
    public ArrayList<Film> selectFiveLastFilms(){
        String toQuery = "SELECT films from Film films order by films.idFilm desc";
        Query query = manager.createQuery(toQuery);
        query.setMaxResults(5);
        return (ArrayList<Film>) query.getResultList();
    }

}
