package mx.com.gm.peliculas.negocio;
import mx.com.gm.peliculas.datos.AccesoDatosHmImp;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;
import mx.com.gm.peliculas.datos.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.compress.compressors.zstandard.ZstdCompressorOutputStream;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class CatalogoPeliculasImp implements ICatalogoPeliculas {
    private List<Pelicula> resguardo;
    private String nombreArchivo;
    private IAccesoDatos catalogo;
    private IAccesoDatos catalogoHmap;

    private static Logger logger = LoggerFactory.getLogger(CatalogoPeliculasImp.class);

    public CatalogoPeliculasImp() {
        catalogo= new AccesoDatosImpl();
        catalogoHmap = new AccesoDatosHmImp();
    }

    @Override
    public String agregarPelicula(String pelicula, boolean bandera) throws EscrituraDatosEx {

        Pelicula pelicula1 = new Pelicula(pelicula);
        resguardo = catalogo.escribir(pelicula1,true);
        return ("Se ha agregado correctamente");
        }
    @Override
    public String agregarPeliculaHmap(Integer indice, String pelicula, boolean bandera) throws EscrituraDatosEx {

        Pelicula pelicula1 = new Pelicula(pelicula);
        HashMap agPeliHmap = new HashMap<>();
        agPeliHmap.put(indice,pelicula1.getNombre());
        if (catalogoHmap.escribirHmap(indice,agPeliHmap,bandera) == true) {
            return ( "Se ha agregado ");

        } else {
            return ("Ocurrio un error al agregar ");
        }

    }
    /*@Override
    public String listarPeliculas() throws LecturaDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl();
        int i = 0;
        int j = 1;
        //catalogo.listar(nombreArchivo);
        System.out.println("LISTADO DE PELICULAS");

        Iterator iter = catalogo.listarFile().iterator();
        while (iter.hasNext()) {

            System.out.println(j + "- " + catalogo.listarFile().get(i).getNombre());
            iter.next();
            i++;
            j++;
        }
        return("");
    }*/

    @Override
    public String listarPeliculas() {
        IAccesoDatos catalogo = new AccesoDatosImpl();
        int i = 0;
        int j = 1;
        //catalogo.listar(nombreArchivo);
        System.out.println("LISTADO DE PELICULAS");

        Iterator iter = resguardo.iterator();
        while (iter.hasNext()) {

            System.out.println(j + "- " + resguardo.get(i).getNombre());
            iter.next();
            i++;
            j++;
        }
        return("");
    }
    @Override
    public String listarPeliculasHmap() throws LecturaDatosEx {
        IAccesoDatos catalogo = new AccesoDatosHmImp();
        int i = 0;
        //catalogo.listar(nombreArchivo);
        System.out.println("LISTADO DE PELICULAS");

       Iterator iter = catalogo.listarHmap().values().iterator();
        while (iter.hasNext()) {
            System.out.println(catalogo.listarHmap().get(i).getNombre());
            iter.next();
            i++;
        }
        return("");
    }

    @Override
    public String buscarPelicula(String buscar) throws LecturaDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl(nombreArchivo);
        if (catalogo.buscar(buscar) == true) {
            return ("El titulo se encuentra en el catalogo");
        } else {
            return  ("El titulo no se encuentra en el catalogo");
        }

    }

    @Override
    public String iniciarArchivo() throws EscrituraDatosEx {
        IAccesoDatos catalogo = new AccesoDatosImpl(nombreArchivo);
        if (catalogo.crear() == true) {
            catalogo.crear();
            return  ("Se ha creado un nuevo nuevo catalogo");
        } else {
            return ("Se predujo un error al crear un nuevo catalogo");
        }

    }
    @Override
    public String iniciarArchivoHmap() throws EscrituraDatosEx {
        IAccesoDatos catalogo = new AccesoDatosHmImp(nombreArchivo);
        if (catalogo.crearHmap() == true
        ) {
            catalogo.crearHmap();
            return  ("Se ha creado un nuevo nuevo catalogo");
        } else {
            return ("Se predujo un error al crear un nuevo catalogo");
        }

    }

    @Override
    public String borrarPelicula(String opcion) throws EscrituraDatosEx, LecturaDatosEx {
        int i = 0;
        String resp= "";
        IAccesoDatos catalogo = new AccesoDatosImpl();

        if (listarPeliculas().equals(opcion))
        {resguardo=catalogo.borrar(resguardo, opcion);
        resp=("Se ha borrado el catalogo de pelicula");
            } else {

        resp = ("Se produjo un error en el  borrado del catalogo");
                }

        return resp;
    }

}