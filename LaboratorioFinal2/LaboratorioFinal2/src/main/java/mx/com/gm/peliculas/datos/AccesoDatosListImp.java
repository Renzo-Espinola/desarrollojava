package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AccesoDatosListImp implements IAccesoDatos{
    private boolean bandera= true;
    private List<Pelicula> resguardoPelicula = new ArrayList<>();
    private List<Pelicula> listaPelicula = new ArrayList<>();
    private static Logger logger = LoggerFactory.getLogger(AccesoDatosFileImpl.class);


    @Override
    public boolean existe() throws LecturaDatosEx {
        return false;
    }

    @Override
    public List<Pelicula> listar() throws LecturaDatosEx {
        
        for (int i =0;i<listaPelicula.size();i++){
            resguardoPelicula=listaPelicula;
        }
        return resguardoPelicula;
    }

    @Override
    public boolean escribir(Pelicula pelicula, boolean anexar) throws EscrituraDatosEx {

             if (pelicula != null && anexar != false) {
             listaPelicula.add(pelicula);
             return true;}
            else
                return false;


        }


    @Override
    public boolean buscar(String buscar) throws LecturaDatosEx {

        for (int i =0;i<listaPelicula.size();i++){
            if (listaPelicula.get(i).getNombre().equalsIgnoreCase(buscar)){
                bandera=true;
               break;
            }else bandera=false;
        }
        return  bandera;
    }

    @Override
    public boolean crear() throws EscrituraDatosEx {
        return false;
    }

    @Override
    public boolean borrar(String opcion) throws EscrituraDatosEx, LecturaDatosEx {
        for (int i =0;i<listaPelicula.size();i++){
            if (listaPelicula.get(i).getNombre().equalsIgnoreCase(opcion)){
                listaPelicula.remove(i);
                bandera=true;
                break;
            }else bandera=false;
        }
        return  bandera;
    }

}
