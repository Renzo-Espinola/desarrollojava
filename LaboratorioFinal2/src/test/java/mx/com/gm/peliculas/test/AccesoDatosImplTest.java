package mx.com.gm.peliculas.test;
import java.util.ArrayList.*;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccesoDatosImplTest extends AccesoDatosImpl {
    File archivo = new File ("src\\main\\resources\\peliculas.txt");
    String nombreArchivo= archivo.getAbsolutePath();
    IAccesoDatos accesoDatos;
    Pelicula peli;


    @BeforeEach
    public void before() {
        System.out.println("BEFORE");
        accesoDatos = new AccesoDatosImpl(nombreArchivo);
        peli = new Pelicula("xFiles");

    }

    @Test
    public void testBuscarPeliculaEncontrada() throws LecturaDatosEx {
        System.out.println("testBuscarEncontrar");
        String esperado = "batman";
        assertThat(accesoDatos.buscar(esperado))
                .isTrue();
    }

    @Test
    public void testBuscarPeliculaNoEncontrada() throws LecturaDatosEx {
        System.out.println("testBuscarPeliculaNoEncontrada");
        String esperado = "HEMAN";
        assertThat(accesoDatos.buscar(esperado))
                .isTrue();
    }

    @Test
    public void testEscribirPelicula() throws EscrituraDatosEx {
        System.out.println("testAgregarPelicula");
        assertThat(accesoDatos.escribir(peli,true))
                .isEmpty();
    }

    @Test
    public void testNoEscribirPelicula() throws EscrituraDatosEx {
        System.out.println("testNoAgregarPelicula");
        assertThat(accesoDatos.escribir(peli, false))
                .isEmpty();
    }


    @Test
    public void testListarPelicula() throws LecturaDatosEx {
        System.out.println("testListarPelicula");
         Pelicula pelicula = new Pelicula("batman");
        assertThat(accesoDatos.listar()).isNotEmpty();

    }

    @Test
    public void testBorrarPelicula() throws EscrituraDatosEx,LecturaDatosEx {
        System.out.println("testBorrarPelicula");
        List<Pelicula> pelicula= new ArrayList<>();
        pelicula.add(new Pelicula("batman"));
        String opcion = "batman";
        assertThat(accesoDatos.borrar(pelicula,opcion))
                .isEmpty();

    }
    @Test
    public void testNoBorrarPelicula() throws EscrituraDatosEx,LecturaDatosEx {
        System.out.println("testNoBorrarPelicula");
        List<Pelicula> pelicula= new ArrayList<>();
        pelicula.add(new Pelicula("batman"));
        String opcion = "batman";
        assertThat(accesoDatos.borrar(pelicula,opcion))
                .isNotEmpty();

    }
    @Test
    public void testNoListarPelicula() throws LecturaDatosEx {
        System.out.println("testNoListarPelicula");
        Pelicula pelicula = new Pelicula();
        assertThat(accesoDatos.listar())
                .isEmpty();
    }

    @Test
    public void testCrearCatalogo() throws EscrituraDatosEx{
        System.out.println("testCrearCatalogo");
        assertThat(accesoDatos.crear())
                 .isTrue();
    }
    @Test
    public void testNoCrearCatalogo() throws EscrituraDatosEx{
        System.out.println("testNoCrarCatalogo");
        assertThat(accesoDatos.crear())
                .isNotNull();
    }
}







