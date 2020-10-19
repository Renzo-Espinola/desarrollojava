package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.config.Configuracion;
import mx.com.gm.peliculas.datos.AccesoDatosFileImpl;
import mx.com.gm.peliculas.datos.AccesoDatosHmImp;
import mx.com.gm.peliculas.datos.AccesoDatosListImp;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Socio;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class ServicioCatalogoSociosImpl implements  IServicioCatalogoSocios{
    private  String nombre;
    private String nombreArchivo;
    private IAccesoDatos catalogo;
    private IAccesoDatos catalogoHmap;

    private static Logger logger = LoggerFactory.getLogger(ServicioCatalogoPeliculasImpl.class);

    public ServicioCatalogoSociosImpl() {
        //catalogo= new AccesoDatosListImp(nombre);
       // catalogo= new AccesoDatosHmImp(nombre);
        catalogo= new AccesoDatosFileImpl(Configuracion.getInstance().getProperty(Configuracion.FILE_SOCIO));
    }

    @Override
    public String agregarSocio(String socio) throws EscrituraDatosEx {
        Socio socio1 = new Socio(socio);
        //String socio2=socio1.getNombre();
        if (catalogo.escribir(socio1,true) == true) {
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

        Iterator iter = catalogo.listar().iterator();
        while (iter.hasNext()) {

            System.out.println(j + "- " + catalogo.listar().get(i));
            iter.next();
            i++;
            j++;
        }
        return("");}

    @Override
    public String buscarSocio(String buscar) throws LecturaDatosEx {

        if (catalogo.buscar(buscar) == true) {
            return ("el usuario se encuentra guardado ");
        }else{
            return ("el usuario no se encuentra guardado ");
        }
    }


    @Override
    public String borrarSocio(String opcion) throws EscrituraDatosEx,LecturaDatosEx {
        String resp= "";
        Socio socio = new Socio(opcion);
        if (opcion!=""){
            catalogo.borrar(socio.getNombre());
            resp=("Se ha borrado el catalogo de pelicula");
        } else {
            resp = ("Se produjo un error en el  borrado del catalogo");
        }

        return resp;
    }
}
