package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.*;

import mx.com.gm.peliculas.excepciones.*;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements IAccesoDatos {

private String nombreArchivo;
File archivo = new File ("src\\main\\resources\\peliculas.txt");
    String nombreArchivos= archivo.getAbsolutePath();

    public AccesoDatosImpl(){};
    public AccesoDatosImpl(String nombreArchivo) {
        this.nombreArchivo=nombreArchivo;
    }

    @Override
    public boolean existe() throws LecturaDatosEx {
        boolean existeCatalogo = true;
                try {
            var entrada = new BufferedReader(new FileReader(nombreArchivos));
            var lectura = entrada.readLine();
            while (lectura != null) {
                if (lectura != null) {
                    existeCatalogo = true;
                } else {
                    existeCatalogo = false;
                }
            }
        }catch (FileNotFoundException ex){
                ex.printStackTrace();
                throw  new LecturaDatosEx("Error al procesar el listado del catalogo "+ex.getMessage());
            }
        catch (IOException ex) {
                ex.printStackTrace(System.out);
                throw new LecturaDatosEx("Error al procesar el listado del catalogo "+ex.getMessage());
        }

    return existeCatalogo;
    }

    @Override
    public  List <Pelicula> listar ()throws LecturaDatosEx
    {
        List<Pelicula> listaPeliculas = new ArrayList<>();

            try {
            var entrada = new BufferedReader(new FileReader(nombreArchivos));
            var lectura = entrada.readLine();
            while (lectura != null) {
                Pelicula peli = new Pelicula(lectura);
                listaPeliculas.add(peli);
                //System.out.println("Pelicula: " + lectura);
                 lectura = entrada.readLine();

            }
            entrada.close();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
            throw  new LecturaDatosEx("Error al procesar el listado del catalogo "+ex.getMessage());
        }
        catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al procesar el listado del catalogo "+ex.getMessage());
        }
        return listaPeliculas;
    }


    @Override
    public boolean escribir(Pelicula pelicula, boolean anexar) throws EscrituraDatosEx {
        try {
            if (nombreArchivos != "" && anexar != false) {
                PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivos, anexar));
                salida.println(pelicula.getNombre());
                salida.close();
                return true;}
            else return false;

        } catch(IOException ex){
                ex.printStackTrace();
                throw new EscrituraDatosEx("Error al procesar la escriura del catalogo " + ex.getMessage());
        }
    }


    @Override
    public boolean buscar(String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreArchivos);
        String buscarPeliculas = "";
        boolean resbusqueda = true;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null) {
                if (lectura.equals(buscar)) {
                    buscarPeliculas = lectura;
                    lectura = null;
                     resbusqueda = true;
                } else {
                    lectura = entrada.readLine();
                    resbusqueda= false;
                }
            }
            entrada.close();
            return resbusqueda;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al procesar la busqueda en el catalogo " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al procesar la busqueda en el catalogo " + ex.getMessage());
        }
    }

    @Override
    public boolean crear() throws EscrituraDatosEx {
        try {
            if (nombreArchivos!=""){
            PrintWriter salida = new PrintWriter(nombreArchivos);
            salida.close();
            return true;}else return false;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al crear el archivo de catalogo "+ ex.getMessage());

        }


    }

    @Override
    public boolean borrar() throws EscrituraDatosEx {
        File archivo = new File (nombreArchivos);
        try {
            if (nombreArchivos!=""){
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            return true;}
            else return false;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al crear el archivo de catalogo "+ ex.getMessage());
        }


    }
}
