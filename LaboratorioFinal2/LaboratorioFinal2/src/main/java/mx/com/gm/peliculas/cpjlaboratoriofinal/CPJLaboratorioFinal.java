package mx.com.gm.peliculas.cpjlaboratoriofinal;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImp;
import mx.com.gm.peliculas.negocio.ICatalogoPeliculas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class CPJLaboratorioFinal {
    private final  Logger logger =  LoggerFactory.getLogger(CPJLaboratorioFinal.class);

    public static void main(String[] args) throws EscrituraDatosEx, LecturaDatosEx {
        Integer opcion;
        String borrar;
        String ingreso="";

        ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImp();
        Scanner scanner = new Scanner(System.in);
        String retorno = "si";
        while (retorno.equalsIgnoreCase("si")) {
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
                case 0:
                    System.out.println("SALIR");
                    break;
                default:
                    System.out.println("INGRESO ERRONEO");
                    break;
            }

            System.out.println("Desea continuar?");
            retorno= scanner.next();
        }
    }
}