package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.*;

import mx.com.gm.peliculas.excepciones.*;

import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import mx.com.gm.peliculas.config.*;

public class AccesoDatosFileImpl implements IAccesoDatos {


    private static Logger logger = LoggerFactory.getLogger(AccesoDatosFileImpl.class);
    private String nombreArchivo;
    private IEntidadVideoClub pelicula;
    String fileoutPelicula = Configuracion.getInstance().getProperty(Configuracion.FILE_CAT_PElIC_OUT);
    String fileOutSocio = Configuracion.getInstance().getProperty((Configuracion.FILE_SOCIO_OUT));


    public AccesoDatosFileImpl() {
    }

    ;

    public AccesoDatosFileImpl(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }


    @Override
    public boolean existe() throws LecturaDatosEx {
        boolean existeCatalogo = true;
        try {
            var entrada = new BufferedReader(new FileReader(nombreArchivo));
            var lectura = entrada.readLine();
            while (lectura != null) {
                if (lectura != null) {
                    existeCatalogo = true;
                } else {
                    existeCatalogo = false;
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            logger.error("Error al procesar el listado del catalogo");
            throw new
                    LecturaDatosEx("" + ex.getMessage());

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al procesar el listado del catalogo " + ex.getMessage());
        }

        return existeCatalogo;
    }

    @Override
    public List<IEntidadVideoClub> listar() throws LecturaDatosEx {
        List<IEntidadVideoClub> listaPeliculas = new ArrayList<>();

        try {
            var entrada = new BufferedReader(new FileReader(nombreArchivo));
            var lectura = entrada.readLine();
            while (lectura != null) {
                String peli = lectura;
                pelicula=new Pelicula(peli);
                lectura = entrada.readLine();
                listaPeliculas.add(pelicula);
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al procesar el listado del catalogo " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al procesar el listado del catalogo " + ex.getMessage());
        }
        return listaPeliculas;
    }


    @Override
    public boolean escribir(IEntidadVideoClub entidad, boolean anexar) throws EscrituraDatosEx {

        try {
            if (nombreArchivo != "" && anexar != false) {
                PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, anexar));
                //listaPelicula.add(pelicula);
                salida.println(entidad);
                salida.close();
                return true;
            } else return false;

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Error al procesar la escriura del catalogo " + ex.getMessage());
        }
    }


    @Override
    public boolean buscar(String buscar) throws LecturaDatosEx {
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
                    resbusqueda = false;
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
            if (nombreArchivo != "") {
                PrintWriter salida = new PrintWriter(nombreArchivo);
                salida.close();
                return true;
            } else return false;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al crear el archivo de catalogo " + ex.getMessage());

        }

    }

    @Override
    public boolean borrar(String opcion) throws EscrituraDatosEx, LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        boolean bandera = true;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileoutPelicula));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if ((currentLine.trim().equals(opcion))) {
                    bandera = true;
                    continue;
                } else bandera = false;
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al crear el archivo de catalogo " + ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream in = new FileInputStream(fileoutPelicula);
            FileOutputStream out = new FileOutputStream(nombreArchivo);
            int c;
            while ((c = in.read()) != -1)
                out.write(c);
            in.close();
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al crear el archivo de catalogo " + ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bandera;
    }

     /*@Override
    public boolean escribir(Pelicula pelicula, boolean anexar) throws EscrituraDatosEx {

        try {
            if (nombreArchivo != "" && anexar != false) {
                PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, anexar));
                listaPelicula.add(pelicula);
                salida.println(pelicula.getNombre());
                salida.close();
                return true;
            } else return false;

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Error al procesar la escriura del catalogo " + ex.getMessage());
        }
    }*/


   /* @Override
    public boolean agregarSocio(Socio socio, boolean anexar) throws EscrituraDatosEx {
        int i = 0;
        try {
            if (nombreArchivo != "" && anexar != false) {
                PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, anexar));
                listaSocio.add(socio);
                salida.println(socio.getNombre());
                salida.close();
                return true;
            } else return false;

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Error al procesar la escriura del catalogo " + ex.getMessage());
        }
    }*/


   /* public List<Socio> listarSocios() throws LecturaDatosEx {
        List<Socio> listaSocio = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(nombreArchivo));
            var lectura = entrada.readLine();
            while (lectura != null) {
                Socio socio = new Socio(lectura);
                lectura = entrada.readLine();
                listaSocio.add(socio);
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al procesar el listado del catalogo " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Error al procesar el listado del catalogo " + ex.getMessage());
        }
        return listaSocio;
    }

    @Override
    public boolean buscarSocio(String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        String buscarSocio = "";
        boolean resbusqueda = true;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null) {
                if (lectura.equals(buscar)) {
                    buscarSocio = lectura;
                    lectura = null;
                    resbusqueda = true;
                } else {
                    lectura = entrada.readLine();
                    resbusqueda = false;
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
    public boolean borrarSocio(String buscar) throws EscrituraDatosEx, LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        boolean bandera = true;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutSocio));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if ((currentLine.trim().equals(buscar))) {
                    bandera = true;
                    continue;
                } else bandera = false;
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al crear el archivo de catalogo " + ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream in = new FileInputStream(fileOutSocio);
            FileOutputStream out = new FileOutputStream(nombreArchivo);

            int c;
            while ((c = in.read()) != -1)
                out.write(c);
            in.close();
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Error al crear el archivo de catalogo " + ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bandera;
    }*/
}







    /*@Override
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
                logger.error ("Error al procesar el listado del catalogo");
                throw  new
                        LecturaDatosEx("" + ex.getMessage());

            }
        catch (IOException ex) {
                ex.printStackTrace(System.out);
                throw new LecturaDatosEx("Error al procesar el listado del catalogo "+ex.getMessage());
        }

    return existeCatalogo;
    }*/
