package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.domain.Socio;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.util.*;

public interface IAccesoDatos {


    boolean existe () throws LecturaDatosEx;

    List<Pelicula> listar()throws LecturaDatosEx;

    boolean escribir (Pelicula pelicula, boolean anexar) throws EscrituraDatosEx;

    boolean buscar (String buscar) throws LecturaDatosEx;

    boolean crear () throws EscrituraDatosEx;

    boolean borrar (String opcion) throws EscrituraDatosEx,LecturaDatosEx;

    boolean agregarSocio(Socio socio,boolean anexar) throws EscrituraDatosEx;

    List<Socio> listarSocios()throws LecturaDatosEx;

    boolean buscarSocio (String buscar) throws LecturaDatosEx;

    boolean borrarSocio (String buscar) throws EscrituraDatosEx, LecturaDatosEx;
}
