package mx.com.gm.peliculas.negocio;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;
import mx.com.gm.peliculas.datos.*;

import java.util.Collections;

public class CatalogoPeliculasImp implements ICatalogoPeliculas {

    private String nombreArchivo;
    private IAccesoDatos catalogo;

    public CatalogoPeliculasImp() {
        catalogo= new AccesoDatosImpl();
    }

    @Override
    public String agregarPelicula(String pelicula, boolean bandera) throws EscrituraDatosEx {
        Pelicula pelicula1 = new Pelicula(pelicula);

        if (catalogo.escribir(pelicula1, bandera) == true) {
            return ("Se ha agregado ");
        } else {
            return ("Ocurrio un error al agregar ");
        }
    }


    @Override
    public String listarPeliculas() throws LecturaDatosEx {
        /*IAccesoDatos catalogo = new AccesoDatosImpl(nombreArchivo);*/
        int i = 0;
        //catalogo.listar(nombreArchivo);
        System.out.println("LISTADO DE PELICULAS");
        for (Pelicula elemento : catalogo.listar()) {
            i++;
            return  (i + "- " + elemento.getNombre());
        }
        return("");
    }


    @Override
    public String buscarPelicula(String buscar) throws LecturaDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl(nombreArchivo);
        if (catalogo.buscar(buscar) == true) {
            return ("El titulo se encuentra en el catalogo");
        } else {
            return ("El titulo no se encuentra en el catalogo");
        }
    }

    @Override
    public String iniciarArchivo() throws EscrituraDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl(nombreArchivo);
        if (catalogo.crear() == true) {
            catalogo.crear();
            return ("Se ha creado un nuevo nuevo catalogo");
        } else {
            return ("Se predujo un error al crear un nuevo catalogo");
        }
    }

    @Override
    public String borrarPelicula() throws EscrituraDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl(nombreArchivo);
        if (catalogo.borrar() == true) {
            catalogo.borrar();
            return ("Se ha borrado el catalogo de pelicula");
        }else return ("Se produjo un error en el  borrado del catalogo");
    }
}