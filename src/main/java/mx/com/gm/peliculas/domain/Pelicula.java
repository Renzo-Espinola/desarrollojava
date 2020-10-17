package mx.com.gm.peliculas.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter

public class Pelicula implements IEntidadVideoClub{
    private String nombre;
    private int numero;

    public Pelicula() {
    }

    public Pelicula (String nombre){
        this.nombre=nombre;
    }

    @Override
    public String toString() {
        return "Pelicula[ " +
        "nombre= " + nombre +
                "]" ;
    }
}
