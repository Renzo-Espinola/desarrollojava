package mx.com.gm.peliculas.presentacion;

import com.google.gson.stream.JsonToken;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.io.IOException;
import java.util.Scanner;

public class PresSelecSeccion {
    Scanner scanner = new Scanner(System.in);
    PresSeccPeliculas seccPeliculas = new PresSeccPeliculas();
    PresSeccSocios seccSocios = new PresSeccSocios();
    PresSeccAlquiler seccAlquiler = new PresSeccAlquiler();

    public void seleccion(int opcion) throws EscrituraDatosEx, LecturaDatosEx, IOException {

        switch (opcion) {
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
                            seccPeliculas.agregarPelicula();
                            break;
                        case 2:
                            seccPeliculas.listarPeliculas();
                            System.out.println("");
                            break;
                        case 3:
                            seccPeliculas.buscarPelicula();
                            System.out.println("");
                            break;
                        case 4:
                            seccPeliculas.borrarPelicula();
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
                            System.out.println(seccSocios.agregarSocios());
                            System.out.println("");
                            break;
                        case 2:
                            System.out.println(seccSocios.listarSocio());
                            System.out.println("");
                            break;
                        case 3:
                            seccSocios.buscarSocio();
                            System.out.println("");
                            break;
                        case 4:
                            seccSocios.borrarSocio();
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
                    System.out.println("---SECCION ALQUILER---");
                    System.out.println("1.- Agregar Alquiler");
                    System.out.println("2.- Listar Alquiler");
                    System.out.println("3.- Buscar Alquiler");
                    System.out.println("4.- Borrar Alquiler");
                    System.out.println("0.- Salir ");
                    opcion = scanner.nextInt();
                    switch (opcion) {
                        case 1:
                            seccAlquiler.agregarAlquiler();
                            System.out.println("");
                            break;
                        case 2:
                            seccAlquiler.listarAlquiler();
                            System.out.println("");
                            break;
                        case 3:
                            seccAlquiler.buscarAlquiler();
                            System.out.println("");
                            break;
                        case 4:
                            seccAlquiler.borrarAlquiler();
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
    }
}

