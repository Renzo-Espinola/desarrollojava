package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.config.Configuracion;
import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.domain.Alquiler;
import mx.com.gm.peliculas.domain.IEntidadVideoClub;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.domain.Socio;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static junit.framework.Assert.assertNotNull;

public class ServicioAlquilerImpl implements IServicioAlquiler {
    IAccesoDatosAlquiler catalogo;
    private String nombre;
    Alquiler peliculaAlquilada;
    public ServicioAlquilerImpl(){
             catalogo= new AccesoDatosAlquilerListImpl(nombre);
            //catalogo= new AccesoDatosHmImp(nombre);
            //catalogo= new AccesoDatosAlquilerFile(Configuracion.getInstance().getProperty(Configuracion.FILE_ALQUILER));

    }
    @Override
    public String agregarAlquiler(IEntidadVideoClub alquiler) throws EscrituraDatosEx {
       // Alquiler alquiler = new Alquiler(socio,pelicula);
        if (catalogo.escribirAlquiler(alquiler, true) == true) {

            return ( "Se ha agregado ");
        } else {
            return ("Ocurrio un error al agregar ");
        }

    }

    @Override
    public void listarAlquiler() throws LecturaDatosEx, IOException {
        //catalogo.listar(nombreArchivo);
        System.out.println("LISTADO DE ALQUILERES");
        catalogo.listarAlquiler();
       Gson gson = new Gson();
       //final Alquiler alquiler2 = catalogo.listarAlquiler();
       String mostrar2 =gson.toJson(catalogo.listarAlquiler());

       //Alquiler alquiler = catalogo.listarAlquiler();
       Gson mostrarOrdenado = new GsonBuilder().setPrettyPrinting().create();
       String mostrar = mostrarOrdenado.toJson(catalogo.listarAlquiler());
        System.out.println("--FORMA 1--");
       System.out.println(mostrar);
        System.out.println("");
        System.out.println("--FORMA 2--");
       //return mostrar2;

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
