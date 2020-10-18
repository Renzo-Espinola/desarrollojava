package mx.com.gm.peliculas.negocio;


import mx.com.gm.peliculas.config.Configuracion;
import mx.com.gm.peliculas.domain.IEntidadVideoClub;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;
import mx.com.gm.peliculas.datos.*;


import java.util.Iterator;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ServicioCatalogoPeliculasImpl implements IServicioCatalogoPeliculas {

    private String nombreArchivo;
    private IAccesoDatos catalogoPelicula;
    private IAccesoDatos catalogoHmap;
    private IAccesoDatos catalogo;
    private String nombre;

    private static Logger logger = LoggerFactory.getLogger(ServicioCatalogoPeliculasImpl.class);

    public ServicioCatalogoPeliculasImpl() {
         catalogoPelicula = new AccesoDatosListImp(nombre);
        //catalogoPelicula = new AccesoDatosHmImp(nombre);
        //catalogoPelicula = new AccesoDatosFileImpl(Configuracion.getInstance().getProperty(Configuracion.FILE_CAT_PELICULA));

    }

    @Override
    public String agregarPelicula(IEntidadVideoClub entidad, boolean bandera) throws EscrituraDatosEx {

       /* Pelicula pelicula1 = new Pelicula(pelicula);
        String peli = pelicula1.getNombre();*/
        if (catalogoPelicula.escribir(entidad, bandera) == true) {
            return ( "Se ha agregado ");

        } else {
            return ("Ocurrio un error al agregar ");
        }

    }

    @Override
    public String listarPeliculas() throws LecturaDatosEx {
        int i = 0;
        int j = 1;

        System.out.println("LISTADO DE PELICULAS");

        Iterator iter = catalogoPelicula.listar().iterator();
        while (iter.hasNext()) {

            System.out.println(j + "- " + catalogoPelicula.listar().get(i));
            iter.next();
            i++;
            j++;
        }
        return("");}

    @Override
    public String buscarPelicula(String buscar) throws LecturaDatosEx {

        if (catalogoPelicula.buscar(buscar) == true) {
            return ("El titulo se encuentra en el catalogo");
        } else {
            return  ("El titulo no se encuentra en el catalogo");
        }

    }

    @Override
    public String iniciarArchivo() throws EscrituraDatosEx {

        if (catalogoPelicula.crear() == true) {
            catalogoPelicula.crear();
            return  ("Se ha creado un nuevo nuevo catalogo");
        } else {
            return ("Se predujo un error al crear un nuevo catalogo");
        }

    }


    @Override
    public String borrarPelicula(String borrar) throws EscrituraDatosEx, LecturaDatosEx {
        String resp= "";
        if (borrar!=null){
        catalogoPelicula.borrar(borrar);
        resp=("Se ha borrado el catalogo de pelicula");
            } else {
            resp = ("Se produjo un error en el  borrado del catalogo");
                }

        return resp;
    }




}
