package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.util.*;

public interface IAccesoDatos {

    boolean existe (String nombreArchivo) throws LecturaDatosEx;

    List<Pelicula> listar (String nombre) throws LecturaDatosEx;

    void escribir (Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar (String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear (String nombreArchivo) throws EscrituraDatosEx;

    void borrar (String nombreArchivo) throws EscrituraDatosEx;



}
