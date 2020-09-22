package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.util.*;

public interface IAccesoDatos {

    boolean existe (String nombreArchivo) throws LecturaDatosEx;

    List<Pelicula> listar (String nombre) throws LecturaDatosEx;

    boolean  escribir (Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    boolean buscar (String nombreArchivo, String buscar) throws LecturaDatosEx;

    boolean crear (String nombreArchivo) throws EscrituraDatosEx;

    boolean borrar (String nombreArchivo) throws EscrituraDatosEx;



}
