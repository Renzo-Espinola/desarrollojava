package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Alquiler;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public interface IAccesoDatosAlquiler {

    Alquiler listarAlquiler() throws LecturaDatosEx;

    boolean escribirAlquiler(int i, String nombre,List<String> pelicula, boolean anexar) throws EscrituraDatosEx;

    boolean buscarAlquiler(String buscar) throws LecturaDatosEx;

    boolean borrarAlquiler(String opcion) throws EscrituraDatosEx, LecturaDatosEx;
}
