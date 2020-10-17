package mx.com.gm.peliculas.presentacion;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.peliculas.negocio.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.apache.velocity.tools.Scope.add;

public class CPJLaboratorioFinal {
    private final Logger logger = LoggerFactory.getLogger(CPJLaboratorioFinal.class);

    public static void main(String[] args) throws EscrituraDatosEx, LecturaDatosEx, IOException {
        Integer opcion;
        PresSelecSeccion selecSeccion = new PresSelecSeccion();

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("---MENU---");
            System.out.println("1.- Seccion Peliculas");
            System.out.println("2.- Seccion Socios");
            System.out.println("3.- Seccion Alquileres ");
            System.out.println("0.- Salir");
            opcion = scanner.nextInt();

            selecSeccion.seleccion(opcion);

        } while (opcion > 1 && opcion < 4);
    }
}

/*switch (opcion) {

        case 1:
        do {
        System.out.println("---SECCION PELICULAS---");
        System.out.println("1.- Agregar Pelicula");
        System.out.println("2.- Listar peliculas");
        System.out.println("3.- Buscar peliculas");
        System.out.println("4.- Borrar catalogo");
        System.out.println("0.- Salir ");
        opcion = scanner.nextInt();

        switch (opcion) {
        case 1:
        System.out.println("Ingrese el nombre de la pelicula");
        nombrePeli = scanner.next();
        System.out.println(servicioPeliculas.agregarPelicula(nombrePeli, true));
        System.out.println("");
        // catalogoPeliculas.listarPeliculas();
        break;
        case 2:
        servicioPeliculas.listarPeliculas();
        System.out.println("");
        break;
        case 3:
        System.out.println("Ingrese el nombre de la pelicula ");
        nombrePeli = scanner.next();
        System.out.println(servicioPeliculas.buscarPelicula(nombrePeli));
        System.out.println("");
        break;
        case 4:
        System.out.println("Ingrese el nombre de la pelicula ");
        nombrePeli = scanner.next();
        System.out.println(servicioPeliculas.borrarPelicula(nombrePeli));
        System.out.println("");
        break;
        case 0:
        System.out.println("SALIR");

default:
        System.out.println("");
        break;
        }
        } while (opcion > 0 && opcion < 5);
        break;
        case 2:
        do {
        System.out.println("---SECCION SOCIOS---");
        System.out.println("1.- Agregar Socios");
        System.out.println("2.- Listar Socios");
        System.out.println("3.- Buscar Socios");
        System.out.println("4.- Borrar Socios");
        System.out.println("0.- Salir ");
        opcion = scanner.nextInt();
        switch (opcion) {
        case 1:
        System.out.println("Ingrese el nombre del socio");
        nombrePeli = scanner.next();
        System.out.println(servicioSocios.agregarSocio(nombrePeli));
        System.out.println("");
        break;
        case 2:
        servicioSocios.listarSocios();
        System.out.println("");
        break;
        case 3:
        System.out.println("Ingrese el nombre del Socio ");
        nombrePeli = scanner.next();
        System.out.println(servicioSocios.buscarSocio(nombrePeli));
        System.out.println("");
        break;
        case 4:
        System.out.println("Ingrese el nombre del socio ");
        nombrePeli = scanner.next();
        System.out.println(servicioSocios.borrarSocio(nombrePeli));
        System.out.println("");
        break;
        case 0:
        System.out.println("SALIR");
        break;
default:
        System.out.println("");
        break;
        }

        } while (opcion > 0 && opcion < 5);

        case 3:
        do {
        System.out.println("---SECCION ALQUILERES---");
        System.out.println("1.- Agregar Alquiler");
        System.out.println("2.- Listar ALquiler");
        System.out.println("3.- Buscar Alquiler");
        System.out.println("4.- Borrar Alquiler");
        System.out.println("0.- Salir ");
        opcion = scanner.nextInt();
        switch (opcion) {
        case 1:

        List<String> listaPelicula = new ArrayList<>();
        System.out.println("Ingrese el ID del socio ");
        int i= scanner.nextInt();
        System.out.println("Ingrese el nombre del socio");
        String nombreSocio ="";
        nombreSocio = scanner.next();
        System.out.println("desea cargar 1 pelicula ");
        String resp= scanner.next();
        while (resp.equalsIgnoreCase("si")) {
        System.out.println("Ingrese la pelicula");
        nombrePeli = scanner.next();
        listaPelicula.add(nombrePeli);
        System.out.println("desea continuar ");
        resp = scanner.next();
        }
        System.out.println(servicioAlquiler.agregarAlquiler(i,nombreSocio,listaPelicula));
        System.out.println("");
        break;
        case 2:
        System.out.println(servicioAlquiler.listarAlquiler());
        System.out.println("");
        break;
        case 3:
        System.out.println("Ingrese el nombre del Socio ");
        nombrePeli = scanner.next();
        System.out.println(servicioSocios.buscarSocio(nombrePeli));
        System.out.println("");
        break;
        case 4:
        System.out.println("Ingrese el nombre del socio ");
        nombrePeli = scanner.next();
        System.out.println(servicioSocios.borrarSocio(nombrePeli));
        System.out.println("");
        break;
        case 0:
        System.out.println("SALIR");
        break;
default:
        System.out.println("");
        break;
        }
        } while (opcion > 0 && opcion < 5);

        }
        }while (opcion > 1 && opcion < 4);
        }
        }







            /*switch (opcion) {
                case 1:
                 catalogoPeliculas.iniciarArchivo();
                    break;
                case 2:
                        System.out.println("Ingrese el nombre de la pelicula");
                        nombrePeli = scanner.next();
                        catalogoPeliculas.agregarPelicula(nombrePeli, true);
                       // catalogoPeliculas.listarPeliculas();
                    break;
                case 3:
                    catalogoPeliculas.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la pelicula ");
                    nombrePeli = scanner.next();
                    System.out.println(catalogoPeliculas.buscarPelicula(nombrePeli));
                    break;
                case 5:
                    System.out.println("ingrese la pelicula a borrar ");
                    borrar = scanner.next();
                    System.out.println(catalogoPeliculas.borrarPelicula(borrar));
                    break;
                case 6:
                    System.out.println("ingrese el socio");
                    nombrePeli=scanner.next();
                    System.out.println(catalogoPeliculas.agregarSocio(nombrePeli));
                    break;
                case 7:
                    catalogoPeliculas.listarSocios();
                    break;
                case 0:
                    System.out.println("SALIR");
                    break;
                default:
                    System.out.println("INGRESO ERRONEO");
                    break;
            }*/


