package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.*;

import mx.com.gm.peliculas.excepciones.*;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements IAccesoDatos {
private String nombreArchivo;

    public AccesoDatosImpl(){};
    public AccesoDatosImpl(String nombreArchivo) {
        this.nombreArchivo=nombreArchivo;
    }

    @Override
    public boolean existe(String nombreArchivo) throws LecturaDatosEx {
        boolean existeCatalogo = true;
        var archivo = new File (nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
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
    public  List <Pelicula> listar (String nombre)throws LecturaDatosEx
    {
        List<Pelicula> listaPeliculas = new ArrayList<>();

        var archivo = new File(nombre);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
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
    public boolean escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            if (pelicula != null && nombreArchivo != "" && anexar != false) {
                PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, anexar));
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
    public boolean buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
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
    public boolean crear(String nombreArchivo) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);

        try {
            if (nombreArchivo!=""){
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            return true;}else return false;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al crear el archivo de catalogo "+ ex.getMessage());

        }


    }

    @Override
    public boolean borrar(String nombreArchivo) throws EscrituraDatosEx {
        File archivo = new File (nombreArchivo);
        try {
            if (nombreArchivo!=""){
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
