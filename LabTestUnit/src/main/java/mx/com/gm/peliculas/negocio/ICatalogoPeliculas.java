package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public interface ICatalogoPeliculas {

  void agregarPelicula(String pelicula)throws EscrituraDatosEx;

  void listarPeliculas(String nombreArchivo)throws LecturaDatosEx;

  void  buscarPelicula(String buscar) throws LecturaDatosEx;

  void iniciarArchivo(String nombreArchivo) throws  EscrituraDatosEx;

  void borrarPelicula(String nombreArchivo) throws  EscrituraDatosEx;

}
