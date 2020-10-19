package mx.com.gm.peliculas.datos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import mx.com.gm.peliculas.domain.Alquiler;
import mx.com.gm.peliculas.domain.IEntidadVideoClub;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static jdk.xml.internal.SecuritySupport.getClassLoader;

public class AccesoDatosAlquilerFile implements IAccesoDatosAlquiler {
    private String nombreArchivo;
    private List <IEntidadVideoClub> alquilerPelicula;
    IEntidadVideoClub alquiler;


    public AccesoDatosAlquilerFile(){}
    public  AccesoDatosAlquilerFile(String nombreArchivo){
        this.nombreArchivo=nombreArchivo;
    }


    @Override
    public List<Alquiler> listarAlquiler() throws LecturaDatosEx, IOException {
        Type tipoAlquiler = new TypeToken<List<Alquiler>>(){}.getType();

        Gson gson = new Gson();
       JsonReader reader = new JsonReader(new FileReader(nombreArchivo));
        List<Alquiler> listaAlquileres = new Gson().fromJson(reader,tipoAlquiler);
          return listaAlquileres;
    }

    @Override
    public boolean escribirAlquiler(IEntidadVideoClub alquiler, boolean anexar) throws EscrituraDatosEx {
       //Type tipoDeDatos = new TypeToken<List<IEntidadVideoClub>>(){}.getType();
        Gson gson = new GsonBuilder().create();
        //String json = gson.toJson(alquiler,);
       try {
            if (nombreArchivo != "" && anexar != false) {

                FileWriter salida = new FileWriter(nombreArchivo, anexar);
                //salida.append((CharSequence) alquiler);
                Alquiler alquilerLocal= (Alquiler) alquiler;
                gson.toJson(alquilerLocal,salida);
                salida.flush();
                salida.close();
                return true;
            } else return false;

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Error al procesar la escriura del catalogo " + ex.getMessage());
        }
    }

    @Override
    public boolean buscarAlquiler(String buscar) throws LecturaDatosEx {
        return false;
    }

    @Override
    public boolean borrarAlquiler(String opcion) throws EscrituraDatosEx, LecturaDatosEx {
        return false;
    }




}
