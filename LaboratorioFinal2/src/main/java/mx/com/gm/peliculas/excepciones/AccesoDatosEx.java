package mx.com.gm.peliculas.excepciones;
import org.slf4j.Logger.*;
public class AccesoDatosEx extends Exception {

    public AccesoDatosEx(String mensaje){
        super (mensaje);
    }

}
