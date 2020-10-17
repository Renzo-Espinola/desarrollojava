package mx.com.gm.peliculas.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Socio implements  IEntidadVideoClub{
    private String nombre;
    private int nroSocio;

    public Socio() {
    }

    public Socio (String nombre){
        this.nombre=nombre;
    }

    @Override
    public String toString() {
        return "Socio [nombre" + nombre + "]";
    }
}


