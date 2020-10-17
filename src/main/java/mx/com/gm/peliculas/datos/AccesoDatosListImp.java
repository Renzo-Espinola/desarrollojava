package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.IEntidadVideoClub;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.domain.Socio;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AccesoDatosListImp implements IAccesoDatos {
    private String nombre;
    private boolean bandera = true;
    private List<IEntidadVideoClub> listaEntidades = new ArrayList<>();

    private static Logger logger = LoggerFactory.getLogger(AccesoDatosFileImpl.class);

    public AccesoDatosListImp(String nombre){
   this.nombre=nombre;
    }

    @Override
    public boolean existe() throws LecturaDatosEx {
        return false;
    }

    @Override
    public List<IEntidadVideoClub> listar() throws LecturaDatosEx {

        return listaEntidades;
    }

    @Override
    public boolean escribir(IEntidadVideoClub entidad, boolean anexar) throws EscrituraDatosEx {

        if (nombre != "" && anexar != false) {
            listaEntidades.add(entidad);
            return true;
        } else
            return false;


    }


    @Override
    public boolean buscar(String buscar) throws LecturaDatosEx {

        for (int i = 0; i < listaEntidades.size(); i++) {
            if ((listaEntidades.get(i).equals(buscar))){
                bandera = true;
                break;
            } else bandera = false;
        }
        return bandera;
    }

    @Override
    public boolean crear() throws EscrituraDatosEx {
        return false;
    }

    @Override
    public boolean borrar(String opcion) throws EscrituraDatosEx, LecturaDatosEx {
        for (int i = 0; i < listaEntidades.size(); i++) {
            if (listaEntidades.get(i).equals(opcion)) {
                listaEntidades.remove(i);
                bandera = true;
                break;
            } else bandera = false;
        }
        return bandera;
    }

    /*@Override
    public boolean agregarSocio(String socio, boolean anexar) throws EscrituraDatosEx {
        if (socio != null && anexar == true) {
            listaSocio.add(socio);
            return true;
        } else return false;
    }

   /* @Override
    public List<Socio> listarSocios() throws LecturaDatosEx {
        return listaSocio;
    }

    @Override
    public boolean buscarSocio(String buscar) throws LecturaDatosEx {
        for (int i = 0; i < listaSocio.size(); i++) {
            if (listaSocio.get(i).getNombre().equalsIgnoreCase(buscar)) {
                bandera = true;
                break;
            } else bandera = false;
        }
        return bandera;

    }

    @Override
    public boolean borrarSocio(String buscar) throws EscrituraDatosEx, LecturaDatosEx {
        for (int i = 0; i<listaSocio.size(); i++){
            if (listaSocio.get(i).getNombre().equalsIgnoreCase(buscar)){
                listaSocio.remove(i);
                bandera= true;
            }else bandera= false;
        }
        return bandera;
    }*/
}