package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.domain.IEntidadVideoClub;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.io.IOException;
import java.util.List;

public interface IServicioAlquiler {
    String agregarAlquiler (IEntidadVideoClub alquiler) throws EscrituraDatosEx;

    void listarAlquiler() throws LecturaDatosEx, IOException;

    String buscarAlquiler(String buscar) throws LecturaDatosEx;

    String borrarAlquiler (String opcion) throws EscrituraDatosEx, LecturaDatosEx;
}
