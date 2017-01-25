package Beans;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@SequenceGenerator(name = "idFilm", sequenceName = "Film_Sequence")
public class Film implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idFilm")
    private Integer idFilm;
    private String title;
    private String imageRoute;
    private String director;
    private ArrayList<String> actors;
    private LocalDate releaseDate;
    private Double averageNote;
    private String summary;

    public Film(String title, String director, ArrayList<String> actors, String imageRoute, LocalDate releaseDate, Double averageNote, String summary) {
        this.title = title;
        this.imageRoute = imageRoute;
        this.director = director;
        this.actors = actors;
        this.releaseDate = releaseDate;
        this.averageNote = averageNote;
        this.summary = summary;
    }

    public Film() {
        //Default
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getAverageNote() {
        return averageNote;
    }

    public void setAverageNote(Double averageNote) {
        this.averageNote = averageNote;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageRoute() {
        return imageRoute;
    }

    public void setImageRoute(String imageRoute) {
        this.imageRoute = imageRoute;
    }
}
