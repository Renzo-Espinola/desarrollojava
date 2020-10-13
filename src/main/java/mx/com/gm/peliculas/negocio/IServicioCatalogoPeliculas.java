package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public interface IServicioCatalogoPeliculas {

  String agregarPelicula(String pelicula, boolean bandera)throws EscrituraDatosEx;

  String listarPeliculas()throws LecturaDatosEx;

  String  buscarPelicula(String buscar) throws LecturaDatosEx;

  String iniciarArchivo() throws  EscrituraDatosEx;

  String borrarPelicula(String opcion) throws EscrituraDatosEx, LecturaDatosEx;



}
