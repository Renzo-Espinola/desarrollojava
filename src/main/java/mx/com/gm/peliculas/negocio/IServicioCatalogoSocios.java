package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public interface IServicioCatalogoSocios {


    String agregarSocio (String socio) throws EscrituraDatosEx;

    String listarSocios()throws LecturaDatosEx;

    String buscarSocio(String buscar) throws LecturaDatosEx;

    String borrarSocio (String opcion) throws EscrituraDatosEx, LecturaDatosEx;
}
