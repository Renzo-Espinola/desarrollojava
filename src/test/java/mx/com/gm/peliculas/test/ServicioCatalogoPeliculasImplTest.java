package mx.com.gm.peliculas.test;

import mx.com.gm.peliculas.config.Configuracion;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.gm.peliculas.negocio.IServicioCatalogoPeliculas;
import mx.com.gm.peliculas.negocio.ServicioCatalogoPeliculasImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ServicioCatalogoPeliculasImplTest extends ServicioCatalogoPeliculasImpl {

    File archivo = new File ("src\\main\\resources\\peliculas.txt");
    String nombreArchivo= archivo.getAbsolutePath();
    IServicioCatalogoPeliculas catalogoPeliculas;
    Pelicula peli;
    String conf = Configuracion.FILE_CAT_PELICULA;



    @BeforeEach
    public void before() throws EscrituraDatosEx{
        System.out.println("BEFORE");
        catalogoPeliculas = new ServicioCatalogoPeliculasImpl();
        peli = new Pelicula("xFiles");
        catalogoPeliculas.iniciarArchivo();

    }
    @Test
    public void testAgregarPeliculas()throws EscrituraDatosEx {
        String pelicula = "batman";
        String esperado ="Se ha agregado ";

        System.out.println("testAgregarPeliculas");
        assertEquals(esperado,catalogoPeliculas.agregarPelicula(pelicula,true));

    }
    @Test
    public void testNoAgregarPeliculas()throws EscrituraDatosEx {
        String pelicula = "startrek";
        String esperado ="Ocurrio un error al agregar ";
        System.out.println("testNoAgregarPeliculas");
        assertEquals(esperado, (catalogoPeliculas.agregarPelicula(pelicula,true)));
    }
    @Test
    public void testListarCatalogo()throws LecturaDatosEx, EscrituraDatosEx {
        String esperado = "1- batman";
        catalogoPeliculas.agregarPelicula("batman",true);
        System.out.println("testListarCatalogo");
        assertThat(catalogoPeliculas.listarPeliculas()).hasToString(esperado);
    }
    @Test
    public void testNOListarCatalogo()throws LecturaDatosEx {
        String noEsperado = "1- Batman";

        System.out.println("testListarCatalogo");
        assertThat(catalogoPeliculas.listarPeliculas()).isNotEqualTo(noEsperado);
    }

    @Test
    public void testBuscarCatalogo()throws LecturaDatosEx {
        String esperado = "El titulo se encuentra en el catalogo";
        String peliculas="batman";
        System.out.println("testBuscarCatalogo");
        assertEquals(esperado,catalogoPeliculas.buscarPelicula(esperado));
    }
    @Test
    public void testNoBuscarCatalogo()throws LecturaDatosEx {
        String esperado = "El titulo no se encuentra en el catalogo";
        String peliculas="Flash";

        System.out.println("testNoBuscarCatalogo");
        assertNotEquals(esperado,catalogoPeliculas.buscarPelicula(peliculas));
    }
    @Test
    public void testIniciarCatalogo()throws EscrituraDatosEx {
        String esperado ="Se ha creado un nuevo nuevo catalogo";
        System.out.println("testIniciarCatalogo");
        assertEquals(esperado,catalogoPeliculas.iniciarArchivo());
    }
    @Test
    public void testNoIniciarCatalogo()throws EscrituraDatosEx {
        String esperado ="Se predujo un error al crear un nuevo catalogo";
        System.out.println("testNoIniciarCatalogo");
        assertNotEquals(esperado,catalogoPeliculas.iniciarArchivo());
    }
    @Test
    public void testBorrarCatalogo() throws EscrituraDatosEx, LecturaDatosEx {
        String esperado ="Se ha borrado el catalogo de pelicula";
        System.out.println("testBorrarCatalogo");
        String opcion = "1";
        assertEquals(esperado,catalogoPeliculas.borrarPelicula(opcion));
    }
    @Test
    public void testNoBorrarCatalogo() throws EscrituraDatosEx, LecturaDatosEx {
        String esperado ="Se produjo un error en el  borrado del catalogo";
        System.out.println("testNoBorrarCatalogo");
        String opcionErronea=null;
        assertNotEquals(esperado,catalogoPeliculas.borrarPelicula(opcionErronea));
    }

}