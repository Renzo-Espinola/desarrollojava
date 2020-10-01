package mx.com.gm.peliculas.datos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.*;


public class AccesoDatosHmImp implements IAccesoDatos {
    String nombreArchivo;
    File archivohMap= new File("src\\main\\resources\\peliculasHmap.txt");
    String nombreArchivos= archivohMap.getAbsolutePath();
    private static Logger logger = LoggerFactory.getLogger(AccesoDatosImpl.class);

    public AccesoDatosHmImp(){}

    public AccesoDatosHmImp(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }


    @Override
    public boolean existe() throws LecturaDatosEx {
        return false;
    }

    @Override
    public List<Pelicula> listarFile()  {

        return null;
    }

    @Override
    public List<Pelicula>listar(){
        return null;
    }

    @Override
    public List<Pelicula> escribir(Pelicula pelicula, boolean anexar) throws EscrituraDatosEx {
        return null;
    }

    @Override
    public boolean buscar(String buscar) throws LecturaDatosEx {
        return false;
    }

    @Override
    public boolean crear() throws EscrituraDatosEx {
        return false;
    }

    @Override
    public List<Pelicula> borrar(List<Pelicula> pelicula,String opcion) throws EscrituraDatosEx {
        return null;
    }

    @Override
    public boolean existeHmap() throws LecturaDatosEx {
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
            logger.error ("Error al procesar el listado del catalogo");
            throw  new
                    LecturaDatosEx("" + ex.getMessage());

        }
        catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al procesar el listado del catalogo "+ex.getMessage());
        }

        return existeCatalogo;
    }


    @Override
    public HashMap<Integer, Pelicula> listarHmap() throws LecturaDatosEx {
        int indice =0;
        HashMap hashMapPelicula = new HashMap<>();
            try {
            var entrada = new BufferedReader(new FileReader(nombreArchivos));
            var lectura = entrada.readLine();
            while (lectura != null) {
                Pelicula peli = new Pelicula(lectura);
                hashMapPelicula.put(indice,peli);
                //System.out.println("Pelicula: " + lectura);
                lectura = entrada.readLine();
                indice++;
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
        return hashMapPelicula;
    }


    @Override
    public boolean escribirHmap(Integer indice, HashMap hashMapPeliculas, boolean anexar) throws EscrituraDatosEx {
        boolean bandera= true;

        try {
            if (nombreArchivos != "" && anexar == true) {
                try {
                        PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivos, anexar));

                        salida.println(indice +"- "+ hashMapPeliculas.get(indice));
                        salida.close();
                        bandera = true;

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bandera;
    }
    @Override
    public boolean buscarHmap(String buscar) throws LecturaDatosEx {
        return false;
    }

    @Override
    public boolean crearHmap() throws EscrituraDatosEx {

        try {
          if(nombreArchivos != ""){
              PrintWriter salida = new PrintWriter(nombreArchivos);
              salida.close();
              return true;
          }else return false;
      } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al crear el archivo de catalogo "+ ex.getMessage());
      }
    }

    @Override
    public boolean borrarHmap() throws EscrituraDatosEx {
        return false;
    }
}
