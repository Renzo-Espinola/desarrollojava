package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public interface ICatalogoPeliculas {

  String agregarPelicula(String pelicula, boolean bandera)throws EscrituraDatosEx;

  String agregarPeliculaHmap(Integer valor, String pelicula, boolean bandera) throws EscrituraDatosEx;

  String listarPeliculas()throws LecturaDatosEx;

  String listarPeliculasHmap() throws LecturaDatosEx;

  String  buscarPelicula(String buscar) throws LecturaDatosEx;

  String iniciarArchivo() throws  EscrituraDatosEx;

  String iniciarArchivoHmap() throws EscrituraDatosEx;

  String borrarPelicula(String opcion) throws EscrituraDatosEx, LecturaDatosEx;
}
