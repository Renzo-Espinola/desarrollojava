package mx.com.gm.peliculas.datos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import mx.com.gm.peliculas.domain.Alquiler;
import mx.com.gm.peliculas.domain.IEntidadVideoClub;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

import java.io.*;
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
    public Alquiler listarAlquiler() throws LecturaDatosEx, IOException {
       Gson gson = new GsonBuilder().create();
       JsonReader reader= new JsonReader(new FileReader(nombreArchivo));
       Alquiler alquileres =gson.fromJson(reader,Alquiler.class);

       return alquileres;


       /*Scanner input = new Scanner(new File(nombreArchivo));
        input.useDelimiter("-|\n");
        Alquiler[] alquileres = new Alquiler[0];
        while (input.hasNext()) {
        String nombre = input.next();
        List<IEntidadVideoClub> pelicula =null;
        pelicula.add();
        alquiler=new Alquiler(nombre,pelicula);
        }*/

    }

    @Override
    public boolean escribirAlquiler(IEntidadVideoClub alquiler, boolean anexar) throws EscrituraDatosEx {
        try {
            if (nombreArchivo != "" && anexar != false) {
                Gson gson = new Gson();
                PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, anexar));
                gson.toJson(alquiler,salida);
                salida.println();
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
