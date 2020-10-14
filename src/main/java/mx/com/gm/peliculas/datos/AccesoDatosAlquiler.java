package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Alquiler;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.util.List;


public class AccesoDatosAlquiler implements IAccesoDatosAlquiler {
private String nombre;
private List<String> listaPelicula;
private Alquiler alquilerPelicula;

public AccesoDatosAlquiler(){};


public AccesoDatosAlquiler (String nombre){
    this.nombre=nombre;
}

    @Override
    public Alquiler listarAlquiler() throws LecturaDatosEx {
       return alquilerPelicula;
    }

    @Override
    public boolean escribirAlquiler(int i, String nombre,List<String> pelicula, boolean anexar) throws EscrituraDatosEx {
        if (nombre != "" && pelicula!= null && anexar != false) {
            alquilerPelicula = new Alquiler(i,nombre,pelicula);
            return true;
        } else
            return false;


    }

    @Override
    public boolean buscarAlquiler(String buscar) throws LecturaDatosEx {
        return false;
    }

    @Override
    public boolean borrarAlquiler(String opcion) throws EscrituraDatosEx, LecturaDatosEx {
        return false;
    }
}
