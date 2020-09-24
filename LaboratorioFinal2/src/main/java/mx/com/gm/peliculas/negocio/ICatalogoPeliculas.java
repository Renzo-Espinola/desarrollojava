package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public interface ICatalogoPeliculas {

  String agregarPelicula(String pelicula, boolean bandera)throws EscrituraDatosEx;

  String listarPeliculas()throws LecturaDatosEx;

  String  buscarPelicula(String buscar) throws LecturaDatosEx;

  String iniciarArchivo() throws  EscrituraDatosEx;

  String borrarPelicula() throws  EscrituraDatosEx;

}
