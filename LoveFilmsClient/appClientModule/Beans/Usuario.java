package Beans;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@SequenceGenerator(name = "idUsuario", sequenceName = "Usuario_Sequence")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idUsuario")
    private Integer idUsuario;
    private String nombre;
    private String password;
    private LocalDate fechaNacimiento;
    private ArrayList<Pelicula> peliculasFavoritas;

    public Usuario(String nombre, String password, LocalDate fechaNacimiento, ArrayList<Pelicula> peliculasFavoritas) {
        this.nombre = nombre;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.peliculasFavoritas = peliculasFavoritas;
    }

    public Usuario() {
        //Default
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Pelicula> getPeliculasFavoritas() {
        return peliculasFavoritas;
    }

    public void setPeliculasFavoritas(ArrayList<Pelicula> peliculasFavoritas) {
        this.peliculasFavoritas = peliculasFavoritas;
    }
}
