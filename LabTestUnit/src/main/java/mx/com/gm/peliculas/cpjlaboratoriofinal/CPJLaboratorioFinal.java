package mx.com.gm.peliculas.cpjlaboratoriofinal;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImp;
import mx.com.gm.peliculas.negocio.ICatalogoPeliculas;

import java.util.Scanner;

public class CPJLaboratorioFinal {
    public static void main(String[] args) throws EscrituraDatosEx, LecturaDatosEx {
        int opcion;
        String nombreArchivo="peliculas.txt";
        ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImp(nombreArchivo);
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
                    catalogoPeliculas.iniciarArchivo(nombreArchivo);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la pelicula");
                    nombrePeli = scanner.next();
                    catalogoPeliculas.agregarPelicula(nombrePeli);
                    break;
                case 3:
                    catalogoPeliculas.listarPeliculas(nombreArchivo);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la pelicula");
                    nombrePeli = scanner.next();
                    catalogoPeliculas.buscarPelicula(nombrePeli);
                    break;
                case 5:
                    catalogoPeliculas.iniciarArchivo(nombreArchivo);
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