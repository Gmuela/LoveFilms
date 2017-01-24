package Beans;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@SequenceGenerator(name = "idUser", sequenceName = "User_Sequence")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idUser")
    private Integer idUser;
    private String name;
    private String password;
    private LocalDate birthday;
    private ArrayList<Film> favouriteFilms;

    public User(String name, String password, LocalDate birthday) {
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.favouriteFilms = new ArrayList<Film>();
    }

    public User() {
        //Default
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public ArrayList<Film> getFavouriteFilms() {
        return favouriteFilms;
    }

    public void setFavouriteFilms(ArrayList<Film> favouriteFilms) {
        this.favouriteFilms = favouriteFilms;
    }
}
