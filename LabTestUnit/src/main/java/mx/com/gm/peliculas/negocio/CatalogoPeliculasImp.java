package mx.com.gm.peliculas.negocio;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;
import mx.com.gm.peliculas.datos.*;

import java.util.Collections;

public class CatalogoPeliculasImp implements ICatalogoPeliculas {

    private String nombreArchivo;
    private IAccesoDatos catalogo;

    public CatalogoPeliculasImp(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        catalogo = new AccesoDatosImpl(this.nombreArchivo);
    }

    @Override
    public void agregarPelicula(String pelicula) throws EscrituraDatosEx {
        Pelicula pelicula1 = new Pelicula(pelicula);

        if (catalogo.escribir(pelicula1, nombreArchivo, true) == true) {
            System.out.println("Se ha agregado una nueva  pelicula al catalogo");
        } else {
            System.out.println("Ocurrio un error al agregar una nueva  pelicula al catalogo");
        }
    }


    @Override
    public void listarPeliculas(String nombreArchivo) throws LecturaDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl(nombreArchivo);
        int i = 0;
        //catalogo.listar(nombreArchivo);
        System.out.println("LISTADO DE PELICULAS");
        for (Pelicula elemento : catalogo.listar(nombreArchivo)) {
            i++;
            System.out.println(i + "- " + elemento.getNombre());
        }
        System.out.println();
    }


    @Override
    public void buscarPelicula(String buscar) throws LecturaDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl(nombreArchivo);
        if (catalogo.buscar(nombreArchivo, buscar) == true) {
            System.out.println("El titulo se encuentra en el catalogo");
        } else {
            System.out.println("El titulo no se encuentra en el catalogo");
        }
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) throws EscrituraDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl(nombreArchivo);
        if (catalogo.crear(nombreArchivo) == true) {
            catalogo.crear(nombreArchivo);
            System.out.println("Se ha creado un nuevo nuevo catalogo");
        } else {
            System.out.println("Se predujo un error al crear un nuevo catalogo");
        }
    }

    @Override
    public void borrarPelicula(String nombreArchivo) throws EscrituraDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl(nombreArchivo);
        if (catalogo.borrar(nombreArchivo) == true) {
            catalogo.borrar(nombreArchivo);
            System.out.println("Se ha borrado el catalogo de pelicula");
        } else {
            System.out.println("Se produjo un error en el  borrado del catalogo de pelicula");
        }
    }
}