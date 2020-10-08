package mx.com.gm.peliculas.test;
import mx.com.gm.peliculas.config.Configuracion;
import mx.com.gm.peliculas.datos.AccesoDatosFileImpl;
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

class AccesoDatosImplTest extends AccesoDatosFileImpl {
    File archivo = new File ("src\\main\\resources\\peliculas.txt");
    String nombreArchivo= archivo.getAbsolutePath();
    IAccesoDatos accesoDatos;
    String peli;
    String conf = Configuracion.FILE_CAT_PELICULA;

    @BeforeEach
    public void before() {
        System.out.println("BEFORE");
        accesoDatos = new AccesoDatosFileImpl(nombreArchivo);
        peli = "xFiles";

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
                .isTrue();
    }

    @Test
    public void testNoEscribirPelicula() throws EscrituraDatosEx {
        System.out.println("testNoAgregarPelicula");
        assertThat(accesoDatos.escribir(peli, false))
                .isFalse();
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
        assertThat(accesoDatos.borrar(opcion))
                .isTrue();

    }
    @Test
    public void testNoBorrarPelicula() throws EscrituraDatosEx,LecturaDatosEx {
        System.out.println("testNoBorrarPelicula");
        List<Pelicula> pelicula= new ArrayList<>();
        pelicula.add(new Pelicula("batman"));
        String opcion = "batman";
        assertThat(accesoDatos.borrar(opcion))
                .isFalse();

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







