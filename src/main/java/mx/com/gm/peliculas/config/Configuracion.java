package mx.com.gm.peliculas.config;

import java.io.IOException;
import  java.util.Properties;


public class Configuracion {

Properties propiedades = null;

public final static String CONFIG_FILE_NAME = "enviroment.properties";
public final static String FILE_CAT_PELICULA ="archivoPelicula";
public final static String FILE_CAT_PElIC_OUT="outputarchivoPelicula";
public final static String FILE_SOCIO="archivoSocio";
public final static String FILE_SOCIO_OUT="outputArchivoSocio";
public final static String FILE_ALQUILER ="archivoAlquiler";
public final static String FILE_ALQUILER_OUT ="outputArchivoAlquiler";

private Configuracion(){
    this.propiedades=new Properties();
    try {
        propiedades.load(Configuracion.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
        }catch (IOException ex){
        ex.printStackTrace();
    }
}
public static Configuracion getInstance(){
    return ConfiguracionHolder.INSTANCE;
}
public static class ConfiguracionHolder{
    private static final Configuracion INSTANCE = new Configuracion();
}
public String getProperty (String key) {
    return this.propiedades.getProperty(key);
}









}
