package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public interface IServicioAlquiler {
    String agregarAlquiler (int i, String socio, List<String> pelicula) throws EscrituraDatosEx;

    String listarAlquiler()throws LecturaDatosEx;

    String buscarAlquiler(String buscar) throws LecturaDatosEx;

    String borrarAlquiler (String opcion) throws EscrituraDatosEx, LecturaDatosEx;
}
