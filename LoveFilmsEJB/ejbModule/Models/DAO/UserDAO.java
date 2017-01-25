package Models.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Beans.Film;
import Beans.User;

import java.util.ArrayList;

@Stateless
public class UserDAO implements UserDAOLocal, UserDAORemote {

    @PersistenceContext(unitName="PersistenceUnit")
    private EntityManager manager;

    @Override
    public void insert(User user) {
        manager.persist(user);
    }

    @Override
    public User select(Integer id) {
        return manager.find(User.class, id);
    }

    @Override
    public User selectByName(String name) {
        String toQuery = "SELECT user from User user where user.name = :name";
        Query query = manager.createQuery(toQuery);
        query.setParameter("name", name);
        return (User) query.getSingleResult();
    }

    @Override
    public ArrayList<Film> selectFavouriteFilms(User user) {
        User userSelected = manager.find(User.class, user);
        return userSelected.getFavouriteFilms();
    }
}
