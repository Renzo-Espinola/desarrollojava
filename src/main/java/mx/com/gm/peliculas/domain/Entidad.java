package mx.com.gm.peliculas.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Entidad {

    private int cod;

    public Entidad(){}
    public Entidad(int cod){
        this.cod=cod;
    }


    @Override
    public String toString() {
        return "Entidad{" +
                "cod=" + cod +
                '}';
    }
}