package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Alquiler;
import mx.com.gm.peliculas.domain.IEntidadVideoClub;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.io.IOException;
import java.util.List;

public interface IAccesoDatosAlquiler {

    IEntidadVideoClub listarAlquiler() throws LecturaDatosEx, IOException;

    boolean escribirAlquiler(IEntidadVideoClub alquiler, boolean anexar) throws EscrituraDatosEx;

    boolean buscarAlquiler(String buscar) throws LecturaDatosEx;

    boolean borrarAlquiler(String opcion) throws EscrituraDatosEx, LecturaDatosEx;
}
