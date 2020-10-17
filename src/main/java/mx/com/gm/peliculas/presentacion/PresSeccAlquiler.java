package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;

import mx.com.gm.peliculas.datos.AccesoDatosAlquilerFile;
import mx.com.gm.peliculas.datos.AccesoDatosAlquilerListImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.datos.IAccesoDatosAlquiler;
import mx.com.gm.peliculas.domain.Alquiler;
import mx.com.gm.peliculas.domain.IEntidadVideoClub;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.peliculas.negocio.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PresSeccAlquiler {
    IServicioAlquiler servicioAlquiler = new ServicioAlquilerImpl();
    IServicioCatalogoSocios servicioCatalogoSocios = new ServicioCatalogoSociosImpl();
    IServicioCatalogoPeliculas servicioCatalogoPeliculas= new ServicioCatalogoPeliculasImpl();

    Scanner scanner= new Scanner(System.in);
    List<IEntidadVideoClub> listaPelicula = new ArrayList<>();
    IEntidadVideoClub alquilerNuevo;
    String nombreAlquiler;

    public void agregarAlquiler() throws EscrituraDatosEx, LecturaDatosEx, IOException {

        System.out.println("Ingrese el nombre del socio");
        System.out.println("");
        servicioCatalogoSocios.listarSocios();
        System.out.println("-------");
        String nombreSocio = "";
        nombreSocio = scanner.next();
        if (nombreSocio != "") {
            System.out.println("desea cargar 1 pelicula ");
            System.out.println(" ");
            String resp = scanner.next();
            servicioCatalogoPeliculas.listarPeliculas();
            System.out.println(" ");
            while (resp.equalsIgnoreCase("si")) {
                System.out.println("Ingrese la pelicula");
                nombreAlquiler = scanner.next();
                 listaPelicula.add(new Pelicula(nombreAlquiler));
                System.out.println(servicioAlquiler.agregarAlquiler (new Alquiler(nombreSocio,listaPelicula)));
                System.out.println(" ");
                System.out.println("desea continuar ");
                resp = scanner.next();
            }

        }
    }
    public void listarAlquiler() throws LecturaDatosEx, IOException {
        servicioAlquiler.listarAlquiler();
    }
    public String  buscarAlquiler() throws LecturaDatosEx {
        System.out.println("Ingrese el nombre de la Pelicula ");
        nombreAlquiler = scanner.next();
        return (servicioAlquiler.buscarAlquiler(nombreAlquiler));

    }
    public void borrarAlquiler() throws LecturaDatosEx, EscrituraDatosEx {
        System.out.println("Ingrese la pelicula a borrar ");
        nombreAlquiler = scanner.next();
        System.out.println(servicioAlquiler.borrarAlquiler(nombreAlquiler));
    }


}