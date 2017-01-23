package Beans;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@SequenceGenerator(name = "idPelicula", sequenceName = "Pelicula_Sequence")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idPelicula")
    private Integer idPelicula;
    private String titulo;
    private String director;
    private ArrayList<String> actores;
    private LocalDate fechaEstreno;
    private Double notaMedia;
    private String resumen;

    public Pelicula(String titulo, String director, ArrayList<String> actores, LocalDate fechaEstreno, Double notaMedia, String resumen) {
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
        this.fechaEstreno = fechaEstreno;
        this.notaMedia = notaMedia;
        this.resumen = resumen;
    }

    public Pelicula() {
        //Default
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getActores() {
        return actores;
    }

    public void setActores(ArrayList<String> actores) {
        this.actores = actores;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public Double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(Double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
}
