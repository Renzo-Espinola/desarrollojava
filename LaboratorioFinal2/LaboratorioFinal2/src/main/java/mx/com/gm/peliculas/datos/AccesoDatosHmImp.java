package mx.com.gm.peliculas.datos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.Set;
import java.util.LinkedHashMap;


public class AccesoDatosHmImp implements IAccesoDatos {
    private Pelicula nombrePeli = new Pelicula();
    private  Map<Integer,Pelicula> mapPelis = new HashMap<>();
    private Integer i=0;
    private boolean bandera = true;



    private static Logger logger = LoggerFactory.getLogger(AccesoDatosFileImpl.class);

    public AccesoDatosHmImp(){}



    @Override
    public boolean existe() throws LecturaDatosEx {
        for (int i =0;i<mapPelis.size();i++){
            if (mapPelis.size()>0){
                bandera=true;
                break;
            }else bandera=false;
        }
        return  bandera;
    }


    @Override
    public  List<Pelicula> listar ()throws LecturaDatosEx {


        List<Pelicula> resguardoPelicula = new ArrayList<Pelicula>(mapPelis.values());

        for (int j = 0; j < mapPelis.size(); j++) {
            if (resguardoPelicula != null) {
                return resguardoPelicula;

            }

        }
        return resguardoPelicula;
    }

    @Override
    public boolean escribir(Pelicula pelicula, boolean anexar) throws EscrituraDatosEx {
         if(pelicula!=null &&anexar!=false){

             mapPelis.put(i,pelicula);
           i++;
           return true;
       }else return false;

    }

    @Override
    public boolean buscar(String buscar) throws LecturaDatosEx {
        for (int i =0;i<mapPelis.size();i++){
            if (mapPelis.get(i).getNombre().equalsIgnoreCase(buscar)){
                bandera=true;
                break;
            }else bandera=false;
        }
        return  bandera;
    }

    @Override
    public boolean crear () throws EscrituraDatosEx {
            if (mapPelis.size()==0){
                return true;
            }else bandera=false;
        return  bandera;
    }

    @Override
    public boolean borrar(String opcion) throws EscrituraDatosEx, LecturaDatosEx {
        for (int i =0;i<mapPelis.size();i++){
            if (mapPelis.get(i).getNombre().equalsIgnoreCase(opcion)){
                mapPelis.remove(i);
                bandera=true;
                break;
            }else bandera=false;
        }
        return  bandera;
    }

}
