package mx.com.gm.peliculas.cpjlaboratoriofinal;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImp;
import mx.com.gm.peliculas.negocio.ICatalogoPeliculas;

import java.util.Scanner;

public class CPJLaboratorioFinal {
    public static void main(String[] args) throws EscrituraDatosEx, LecturaDatosEx {
        int opcion;
        String nombreArchivo;
        ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImp();
        Scanner scanner = new Scanner(System.in);
        String retorno = "si";
        while (retorno.equals("si")) {
            System.out.println("1.- Iniciar catalogo peliculas");
            System.out.println("2.- Agregar Pelicula");
            System.out.println("3.- Listar peliculas");
            System.out.println("4.- Buscar peliculas");
            System.out.println("5.- Borrar catalogo");
            System.out.println("0.- Salir");
            opcion = scanner.nextInt();
            String nombrePeli = "";

            switch (opcion) {
                case 1:
                    catalogoPeliculas.iniciarArchivo("peliculas.txt");
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la pelicula");
                    nombrePeli = scanner.next();
                    catalogoPeliculas.agregarPelicula(nombrePeli, "peliculas.txt");
                    break;
                case 3:
                    catalogoPeliculas.listarPeliculas("peliculas.txt");
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la pelicula");
                    nombrePeli = scanner.next();
                    catalogoPeliculas.buscarPelicula("peliculas.txt", nombrePeli);
                    break;
                case 5:
                    catalogoPeliculas.iniciarArchivo("peliculas.txt");
                case 0:
                    System.out.println("SALIR");
                    break;
                default:
                    System.out.println("INGRESO ERRONEO");
            }

            System.out.println("Desea continuar? INGRESA si CON MINUSCULA O SE ROMPE");
            retorno= scanner.next();
        }
    }
}