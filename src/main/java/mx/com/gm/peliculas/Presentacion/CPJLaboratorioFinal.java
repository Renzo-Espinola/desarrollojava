package mx.com.gm.peliculas.Presentacion;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.peliculas.negocio.IServicioCatalogoPeliculas;
import mx.com.gm.peliculas.negocio.IServicioCatalogoSocios;
import mx.com.gm.peliculas.negocio.ServicioCatalogoPeliculasImpl;
import mx.com.gm.peliculas.negocio.ServicioCatalogoSociosImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class CPJLaboratorioFinal {
    private final Logger logger = LoggerFactory.getLogger(CPJLaboratorioFinal.class);

    public static void main(String[] args) throws EscrituraDatosEx, LecturaDatosEx {
        Integer opcion;
        String nombrePeli = "";
        IServicioCatalogoPeliculas servicioPeliculas = new ServicioCatalogoPeliculasImpl();
        IServicioCatalogoSocios servicioSocios=new ServicioCatalogoSociosImpl();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("---MENU---");
            System.out.println("1.- Seccion Peliculas");
            System.out.println("2.- Seccion Socios");
            System.out.println("3.- Alquileres ");
            System.out.println("0.- Salir");
            opcion = scanner.nextInt();


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

            }

        } while (opcion > 1 && opcion < 4);
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


