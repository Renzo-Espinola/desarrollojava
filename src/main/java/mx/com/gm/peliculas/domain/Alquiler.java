package mx.com.gm.peliculas.domain;

import java.util.List;

public class Alquiler implements IEntidadVideoClub{

    private String nombreSocio;
    private List<IEntidadVideoClub> peliculasAlquiladas;


    public Alquiler(){};

    public Alquiler (String nombreSocio, List<IEntidadVideoClub> peliculasAlquiladas){
        this.nombreSocio=nombreSocio;
        this.peliculasAlquiladas=peliculasAlquiladas;
    }

    public String toString() {
        return "Alquiler["+
                "nombre Socio= "+ nombreSocio +
                ", peliculasAlquiladas= " + peliculasAlquiladas +" ]";
    }
}
