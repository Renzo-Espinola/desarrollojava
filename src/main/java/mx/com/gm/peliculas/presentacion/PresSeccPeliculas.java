package mx.com.gm.peliculas.presentacion;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.Scanner;

import mx.com.gm.peliculas.domain.IEntidadVideoClub;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.peliculas.negocio.IServicioCatalogoPeliculas;
import mx.com.gm.peliculas.negocio.IServicioCatalogoSocios;
import mx.com.gm.peliculas.negocio.ServicioCatalogoPeliculasImpl;
import mx.com.gm.peliculas.negocio.ServicioCatalogoSociosImpl;

public class PresSeccPeliculas {
    IServicioCatalogoPeliculas servicioPeliculas = new ServicioCatalogoPeliculasImpl();
    Scanner scanner= new Scanner(System.in);
    String nombrePeli;
    String resp;
    IEntidadVideoClub entidadPeli;

    public void agregarPelicula() throws EscrituraDatosEx {
        System.out.println("Ingrese el nombre de la pelicula ");
        nombrePeli = scanner.next();
        if(nombrePeli!="") {
            entidadPeli = new Pelicula(nombrePeli);
            resp=servicioPeliculas.agregarPelicula(entidadPeli, true);
        }else resp="Ingreso erroneo";
        System.out.println(resp);
    }
    public String listarPeliculas() throws LecturaDatosEx {
        return (servicioPeliculas.listarPeliculas());

    }
    public void  buscarPelicula() throws LecturaDatosEx {
        System.out.println("Ingrese el nombre de la Pelicula ");
        nombrePeli = scanner.next();
        //entidadPeli= new Pelicula(nombrePeli);
        System.out.println(servicioPeliculas.buscarPelicula(nombrePeli));

    }
    public void borrarPelicula() throws LecturaDatosEx, EscrituraDatosEx {
        System.out.println("Ingrese la pelicula a borrar ");
        nombrePeli = scanner.next();
        //entidadPeli= new Pelicula(nombrePeli);
        System.out.println(servicioPeliculas.borrarPelicula(nombrePeli));
    }


}
