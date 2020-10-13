package mx.com.gm.peliculas.datos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.domain.Socio;
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
    private  Map<Integer,String> mapPelis = new HashMap<>();
    private  Map<Integer,Socio> mapSocios = new HashMap<>();
    private Integer i=0;
    private boolean bandera = true;
    private String nombre;


    private static Logger logger = LoggerFactory.getLogger(AccesoDatosFileImpl.class);

    public AccesoDatosHmImp(String nombre){
    this.nombre=nombre;
    }



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
    public  List<String> listar ()throws LecturaDatosEx {

        List<String> resguardoPelicula = new ArrayList<>(mapPelis.values());

                return resguardoPelicula;

    }

    @Override
    public boolean escribir(String nombre , boolean anexar) throws EscrituraDatosEx {
         if(nombre!="" &&anexar!=false){

             mapPelis.put(i,nombre);
           i++;
           return true;
       }else return false;

    }

    @Override
    public boolean buscar(String buscar) throws LecturaDatosEx {
        for (int i =0;i<mapPelis.size();i++){
            if (mapPelis.get(i).equalsIgnoreCase(buscar)){
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
            if (mapPelis.get(i).equalsIgnoreCase(opcion)){
                mapPelis.remove(i);
                bandera=true;
                break;
            }else bandera=false;
        }
        return  bandera;
    }

   /* @Override
    public boolean agregarSocio(Socio socio, boolean anexar) throws EscrituraDatosEx {
        if (socio!=null&&anexar==true){
            mapSocios.put(i,socio);
            i++;
            return true;
        }else return false;

    }

    /*@Override
    public List<Socio> listarSocios() throws LecturaDatosEx {
        List<Socio>listSocio=new ArrayList<>(mapSocios.values());
        return listSocio;
    }

    @Override
    public boolean buscarSocio(String buscar) throws LecturaDatosEx {
        for (int i =0;i<mapSocios.size();i++){
            if (mapSocios.get(i).getNombre().equalsIgnoreCase(buscar)){
                bandera=true;
                break;
            }else bandera=false;
        }
        return  bandera;
    }

    @Override
    public boolean borrarSocio(String buscar) throws EscrituraDatosEx, LecturaDatosEx {
        for ( int i = 0 ; i< mapSocios.size();i++){
            if ( mapSocios.get(i).getNombre().equalsIgnoreCase(buscar)){
                mapSocios.remove(i);
                bandera=true;
            }else bandera=false;
        }return bandera;
    }*/
}

