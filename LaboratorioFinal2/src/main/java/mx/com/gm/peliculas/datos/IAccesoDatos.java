package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.util.*;

public interface IAccesoDatos {

    boolean existe () throws LecturaDatosEx;

    List<Pelicula> listar () throws LecturaDatosEx;

    boolean  escribir (Pelicula pelicula, boolean anexar) throws EscrituraDatosEx;

    boolean buscar (String buscar) throws LecturaDatosEx;

    boolean crear () throws EscrituraDatosEx;

    boolean borrar () throws EscrituraDatosEx;



}
