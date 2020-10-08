package mx.com.gm.peliculas.negocio;


import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.domain.Socio;
import mx.com.gm.peliculas.excepciones.*;
import mx.com.gm.peliculas.datos.*;


import java.util.Iterator;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ServicioCatalogoPeliculasImp implements IServicioCatalogoPeliculas {

    private String nombreArchivo;
    private IAccesoDatos catalogo;
    private IAccesoDatos catalogoHmap;

    private static Logger logger = LoggerFactory.getLogger(ServicioCatalogoPeliculasImp.class);

    public ServicioCatalogoPeliculasImp() {
        //catalogo= new AccesoDatosListImp();
        //catalogo= new AccesoDatosHmImp();
        catalogo= new AccesoDatosFileImpl();
    }

    @Override
    public String agregarPelicula(String pelicula, String file, boolean bandera) throws EscrituraDatosEx {

        Pelicula pelicula1 = new Pelicula(pelicula);
        if (catalogo.escribir(pelicula1, file,  bandera) == true) {
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
        String resp= "";
        if (opcion!=""){
        catalogo.borrar(opcion);
        resp=("Se ha borrado el catalogo de pelicula");
            } else {
            resp = ("Se produjo un error en el  borrado del catalogo");
                }

        return resp;
    }

    @Override
    public String agregarSocio(String socio) throws EscrituraDatosEx {
        Socio socio1 = new Socio(socio);
        if (catalogo.agregarSocio(socio1,true) == true) {
            return ( "Se ha agregado ");

        } else {
            return ("Ocurrio un error al agregar ");
        }

    }
    @Override
    public String listarSocios() throws LecturaDatosEx {
        int i = 0;
        int j = 1;
        //catalogo.listar(nombreArchivo);
        System.out.println("LISTADO DE SOCIOS");

        Iterator iter = catalogo.listarSocios().iterator();
        while (iter.hasNext()) {

            System.out.println(j + "- " + catalogo.listarSocios().get(i).getNombre());
            iter.next();
            i++;
            j++;
        }
        return("");}

    @Override
    public String buscarSocio(String buscar) throws LecturaDatosEx {
        if (catalogo.buscarSocio(buscar) == true) {
            return ("el usuario se encuentra guardado ");
        }else{
            return ("el usuario no se encuentra guardado ");
            }
        }


    @Override
    public String borrarSocio(String opcion) throws EscrituraDatosEx,LecturaDatosEx {
        String resp= "";
        if (opcion!=""){
            catalogo.borrarSocio(opcion);
            resp=("Se ha borrado el catalogo de pelicula");
        } else {
            resp = ("Se produjo un error en el  borrado del catalogo");
        }

        return resp;
    }


}
