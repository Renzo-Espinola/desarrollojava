package mx.com.gm.peliculas.test;

import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccesoDatosImplTest extends AccesoDatosImpl {

    IAccesoDatos accesoDatos;
    String archivo = "peliculas.txt";
    File archivorep = new File(archivo);
    String archivoreps = String.valueOf(archivorep);
    Pelicula peli;


    @BeforeEach
    public void before() {
        System.out.println("BEFORE");
        accesoDatos = new AccesoDatosImpl(archivo);
        peli = new Pelicula("xFiles");
    }

    @Test
    public void testBuscarPeliculaEncontrada() throws LecturaDatosEx {
        System.out.println("testBuscarEncontrar");
        String esperado = "batman";
        assertThat(accesoDatos.buscar(archivo, esperado))
                .isTrue();
    }

    @Test
    public void testBuscarPeliculaNoEncontrada() throws LecturaDatosEx {
        System.out.println("testBuscarNoEncontrar");
        String esperado = "HEMAN";
        assertThat(accesoDatos.buscar(archivo, esperado))
                .isFalse();
    }

    @Test
    public void testAgregarPelicula() throws EscrituraDatosEx {
        System.out.println("testAgregarPelicula");
        assertThat(accesoDatos.escribir(peli, archivo, true))
                .isTrue();
    }

    @Test
    public void testNoAgregarPelicula() throws EscrituraDatosEx {
        System.out.println("testNoAgregarPelicula");
        assertThat(accesoDatos.escribir(peli, archivo, false))
                .isFalse();
    }


    @Test
    public void testListarPelicula() throws LecturaDatosEx {
        System.out.println("testListarPelicula");
        assertThat(accesoDatos.listar(archivo))
                .isNotEmpty();
    }


    @Test
    public void testBorrarPelicula() throws EscrituraDatosEx {
        System.out.println("testListarPelicula");
        assertThat(accesoDatos.borrar(archivo))
                .isTrue();

    }
}
    /*@Test
    public void testNoListarPelicula() throws LecturaDatosEx{
        System.out.println("testListarPelicula");
        assertThat(accesoDatos.listar(archivo))
                .isEmpty();
    }*/



    /*@Test
    public void testAgregarPelicula() throws EscrituraDatosEx{
        System.out.println("testAgregarPelicula");
        assertThat(accesoDatos.crear(archivoreps))
                 .isTrue();
    }*/


