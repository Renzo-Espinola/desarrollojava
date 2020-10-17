package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.domain.IEntidadVideoClub;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public interface IServicioCatalogoPeliculas {

  String agregarPelicula(IEntidadVideoClub entidad, boolean bandera)throws EscrituraDatosEx;

  String listarPeliculas()throws LecturaDatosEx;

  String  buscarPelicula(String buscar) throws LecturaDatosEx;

  String iniciarArchivo() throws  EscrituraDatosEx;

  String borrarPelicula(String borrar) throws EscrituraDatosEx, LecturaDatosEx;



}
