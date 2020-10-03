package mx.com.gm.peliculas.domain;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String nombre;
    private int numero;

    public Pelicula() {
    }

    public Pelicula (String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", numero=" + numero +
                '}';
    }
}
