package mx.com.gm.peliculas.negocio;


import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;
import mx.com.gm.peliculas.datos.*;


import java.util.Iterator;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class CatalogoPeliculasImp implements ICatalogoPeliculas {

    private String nombreArchivo;
    private IAccesoDatos catalogo;
    private IAccesoDatos catalogoHmap;

    private static Logger logger = LoggerFactory.getLogger(CatalogoPeliculasImp.class);

    public CatalogoPeliculasImp() {
        catalogo= new AccesoDatosFileImpl();
    }

    @Override
    public String agregarPelicula(String pelicula, boolean bandera) throws EscrituraDatosEx {

        Pelicula pelicula1 = new Pelicula(pelicula);
        if (catalogo.escribir(pelicula1, bandera) == true) {
            return ( "Se ha agregado ");

        } else {
            return ("Ocurrio un error al agregar ");
        }

    }

    @Override
    public String listarPeliculas() throws LecturaDatosEx {
        int i = 0;
        int j = 1;
        //catalogo.listar(nombreArchivo);
        System.out.println("LISTADO DE PELICULAS");

        Iterator iter = catalogo.listar().iterator();
        while (iter.hasNext()) {

            System.out.println(j + "- " + catalogo.listar().get(i).getNombre());
            iter.next();
            i++;
            j++;
        }
        return("");}

    @Override
    public String buscarPelicula(String buscar) throws LecturaDatosEx {

        if (catalogo.buscar(buscar) == true) {
            return ("El titulo se encuentra en el catalogo");
        } else {
            return  ("El titulo no se encuentra en el catalogo");
        }

    }

    @Override
    public String iniciarArchivo() throws EscrituraDatosEx {

        if (catalogo.crear() == true) {
            catalogo.crear();
            return  ("Se ha creado un nuevo nuevo catalogo");
        } else {
            return ("Se predujo un error al crear un nuevo catalogo");
        }

    }


    @Override
    public String borrarPelicula(String opcion) throws EscrituraDatosEx, LecturaDatosEx {
        int i = 0;
        String resp= "";
        if (opcion!=""){
        catalogo.borrar(opcion);
        resp=("Se ha borrado el catalogo de pelicula");
            } else {
            resp = ("Se produjo un error en el  borrado del catalogo");
                }

        return resp;
    }

}
