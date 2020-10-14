package mx.com.gm.peliculas.domain;

import java.util.List;

public class Alquiler extends Entidad{
    private  int id;
    private String nombreSocio;
    private List<String> peliculasAlquiladas;


    public Alquiler(){};

    public Alquiler (int id, String nombreSocio, List<String> peliculasAlquiladas){
        super(id);
        this.nombreSocio=nombreSocio;
        this.peliculasAlquiladas=peliculasAlquiladas;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "id=" + id +
                ", nombreSocio='" + nombreSocio + '\'' +
                ", peliculasAlquiladas=" + peliculasAlquiladas +
                '}';
    }
}
