package mx.com.gm.peliculas.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Socio {
    private String nombre;
    private int nroSocio;

    public Socio() {
    }

    public Socio (String nombre){
        this.nombre=nombre;
    }

    /*public String getNombre() {
        return nombre;
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNroSocio(Integer nroSocio) {
        this.nroSocio = nroSocio;
    }*/

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", numero=" + nroSocio +
                '}';
    }
}


