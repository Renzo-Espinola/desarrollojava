package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.config.Configuracion;
import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.domain.Alquiler;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.domain.Socio;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Iterator;
import java.util.List;

import static junit.framework.Assert.assertNotNull;

public class ServicioAlquilerImpl implements IServicioAlquiler {
    IAccesoDatosAlquiler catalogo;
    private String nombre;
    Alquiler peliculaAlquilada;
    public ServicioAlquilerImpl(){
            catalogo= new AccesoDatosAlquiler(nombre);
            //catalogo= new AccesoDatosHmImp(nombre);
            //catalogo= new AccesoDatosFileImpl(Configuracion.getInstance().getProperty(Configuracion.FILE_ALQUILER));

    }
    @Override
    public String agregarAlquiler(int id, String socio,List pelicula) throws EscrituraDatosEx {
        Socio socio1 = new Socio(socio);

        if (catalogo.escribirAlquiler(id,socio1.getNombre(),pelicula, true) == true) {

            return ( "Se ha agregado ");
        } else {
            return ("Ocurrio un error al agregar ");
        }

    }

    @Override
    public String listarAlquiler() throws LecturaDatosEx {
        //catalogo.listar(nombreArchivo);
        System.out.println("LISTADO DE ALQUILERES");

       Gson gson = new Gson();
       final Alquiler alquiler2 = catalogo.listarAlquiler();
       String mostrar2 =gson.toJson(alquiler2);

       Alquiler alquiler = catalogo.listarAlquiler();
       Gson mostrarOrdenado = new GsonBuilder().setPrettyPrinting().create();
       String mostrar = mostrarOrdenado.toJson(alquiler);
        System.out.println("--FORMA 1--");
       System.out.println(mostrar);
        System.out.println("");
        System.out.println("--FORMA 2--");
       return mostrar2;

    }


    @Override
    public String buscarAlquiler(String buscar) throws LecturaDatosEx {
        return null;
    }

    @Override
    public String borrarAlquiler(String opcion) throws EscrituraDatosEx, LecturaDatosEx {
        return null;
    }
}
