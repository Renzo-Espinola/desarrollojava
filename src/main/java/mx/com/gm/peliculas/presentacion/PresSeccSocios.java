package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;

import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.peliculas.negocio.IServicioCatalogoSocios;
import mx.com.gm.peliculas.negocio.ServicioCatalogoSociosImpl;

public class PresSeccSocios {
    IServicioCatalogoSocios servicioSocios = new ServicioCatalogoSociosImpl();
    Scanner scanner = new Scanner(System.in);
    private String nombreSocio;

public String agregarSocios() throws EscrituraDatosEx {
    System.out.println("Ingrese el nombre del socio");
    nombreSocio = scanner.next();
    return (servicioSocios.agregarSocio(nombreSocio));
}
public String listarSocio() throws LecturaDatosEx {
   return servicioSocios.listarSocios();

}
public String buscarSocio() throws LecturaDatosEx {
    System.out.println("Ingrese el nombre del Socio ");
    nombreSocio = scanner.next();
    return (servicioSocios.buscarSocio(nombreSocio));
}
public String borrarSocio() throws LecturaDatosEx, EscrituraDatosEx {
    return (servicioSocios.borrarSocio(nombreSocio));

}

}
