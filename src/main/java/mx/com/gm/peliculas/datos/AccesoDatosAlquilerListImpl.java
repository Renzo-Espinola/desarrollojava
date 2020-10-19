package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Alquiler;
import mx.com.gm.peliculas.domain.IEntidadVideoClub;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.util.List;


public class AccesoDatosAlquilerListImpl implements IAccesoDatosAlquiler {
private String nombre;
//private List<String> listaPelicula;
private IEntidadVideoClub alquilerPelicula;

public AccesoDatosAlquilerListImpl(){};


public AccesoDatosAlquilerListImpl(String nombre){
    this.nombre=nombre;
}

    @Override
    public List<Alquiler> listarAlquiler() throws LecturaDatosEx {
       return null;
    }

    @Override
    public boolean escribirAlquiler(IEntidadVideoClub alquiler, boolean anexar) throws EscrituraDatosEx {

            alquilerPelicula = alquiler;
            return true;

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
