package mx.com.gm.peliculas.domain;

public class Entidad {

    private int cod;

    public Entidad(){}
    public Entidad(Integer cod){
        this.cod=cod;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Entidad{" +
                "cod=" + cod +
                '}';
    }
}