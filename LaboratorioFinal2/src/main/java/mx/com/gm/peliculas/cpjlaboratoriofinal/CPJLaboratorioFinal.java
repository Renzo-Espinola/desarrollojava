package mx.com.gm.peliculas.cpjlaboratoriofinal;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImp;
import mx.com.gm.peliculas.negocio.ICatalogoPeliculas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory.*;
import  org.slf4j.Logger.*;
import org.slf4j.ILoggerFactory.*;
import java.io.File;
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
                    System.out.println("ingrese hash o arraylist");
                    ingreso=scanner.next();
                    if (ingreso.equals("hash")){
                    catalogoPeliculas.iniciarArchivoHmap();
                } else{
                    catalogoPeliculas.iniciarArchivo();
                }
                    break;
                case 2:
                    System.out.println("desea agregar en el hashmap o el arraylist");
                    ingreso=scanner.next();
                    if (ingreso.equals("hash")) {
                        System.out.println("Ingrese el indice y el nombre de la pelicula Hsmap");
                        int indice = Integer.parseInt(scanner.next());
                        nombrePeli = scanner.next();
                        catalogoPeliculas.agregarPeliculaHmap(indice, nombrePeli, true);
                    }else {
                        System.out.println("Ingrese el nombre de la pelicula list");
                        nombrePeli = scanner.next();
                        catalogoPeliculas.agregarPelicula(nombrePeli, true);
                        catalogoPeliculas.listarPeliculas();
                    }
                    break;
                case 3:
                    System.out.println("desea listar el hashmap o el arraylist");
                    ingreso=scanner.next();
                    if (ingreso.equals("hash")) {
                        System.out.println(catalogoPeliculas.listarPeliculasHmap());
                    }else {
                        System.out.println(catalogoPeliculas.listarPeliculas());
                    }break;
                case 4:
                    System.out.println("Ingrese el nombre de la pelicula ");
                    nombrePeli = scanner.next();
                    catalogoPeliculas.buscarPelicula(nombrePeli);
                    break;
                case 5:
                    System.out.println("ingrese el numero linea a borrar ");
                    borrar = scanner.next();
                    catalogoPeliculas.borrarPelicula(borrar);
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