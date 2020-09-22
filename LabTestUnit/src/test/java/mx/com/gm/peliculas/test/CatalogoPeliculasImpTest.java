package mx.com.gm.peliculas.test;

import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CatalogoPeliculasImpTest extends AccesoDatosImpl {
    IAccesoDatos catalogoPelicula;
    String archivo ="peliculas.txt";


    public void setUp(){
        System.out.println("Set up");
        archivo= "peliculas.txt" ;

    }

    @BeforeEach
    public void before() {
        System.out.println("BEFORE");
        catalogoPelicula = new AccesoDatosImpl(archivo);
    }

    @Test
    public void testBuscarPeliculaEncontrada() throws LecturaDatosEx {
        System.out.println("testBuscar");
        String esperado = "batman";
        assertThat(catalogoPelicula.buscar(archivo, esperado)).isEqualTo(true);
        /*assertEquals(catalogoPelicula.buscar(archivo,esperado),esperado);*/

    }
}