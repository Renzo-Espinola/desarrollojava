package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.util.*;

public interface IAccesoDatos {


    boolean existe () throws LecturaDatosEx;

    List<Pelicula> listarFile () throws LecturaDatosEx;

    List<Pelicula>listar();

    List<Pelicula> escribir (Pelicula pelicula, boolean anexar) throws EscrituraDatosEx;

    boolean buscar (String buscar) throws LecturaDatosEx;

    boolean crear () throws EscrituraDatosEx;

    List<Pelicula> borrar (List<Pelicula> peliculas,String opcion) throws EscrituraDatosEx,LecturaDatosEx;


    boolean existeHmap() throws LecturaDatosEx;

    HashMap<Integer, Pelicula> listarHmap() throws LecturaDatosEx;

    boolean escribirHmap(Integer indice, HashMap hashMapPeliculas, boolean anexar) throws EscrituraDatosEx;

    boolean buscarHmap(String buscar) throws LecturaDatosEx;

    boolean crearHmap() throws EscrituraDatosEx;

    boolean borrarHmap() throws EscrituraDatosEx;
}
