package mx.com.gm.peliculas.negocio;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;
import mx.com.gm.peliculas.datos.*;

import java.util.Collections;

public class CatalogoPeliculasImp implements ICatalogoPeliculas {

    public CatalogoPeliculasImp(){}

    @Override
    public  void agregarPelicula(String pelicula, String nombreArchivo) throws EscrituraDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl();
        Pelicula pelicula1 = new Pelicula(pelicula);
        catalogo.escribir(pelicula1,nombreArchivo,true);
    }

    @Override
    public void listarPeliculas(String nombreArchivo) throws LecturaDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl();
        int i = 0;
        //catalogo.listar(nombreArchivo);
        System.out.println("LISTADO DE PELICULAS");
        for (Pelicula elemento: catalogo.listar(nombreArchivo)){
            i++;
            System.out.println( i+"- " + elemento.getNombre());
        }
        System.out.println();
    }


    @Override
    public  void buscarPelicula(String nombreArchivo, String buscar) throws LecturaDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl();

        System.out.println(catalogo.buscar(nombreArchivo,buscar));


    }

    @Override
    public void iniciarArchivo(String nombreArchivo)throws EscrituraDatosEx {
    IAccesoDatos catalogo = new AccesoDatosImpl();
    catalogo.crear(nombreArchivo);


    }

    @Override
    public void borrarPelicula(String nombreArchivo) throws EscrituraDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl();
        catalogo.borrar(nombreArchivo);
    }
}
