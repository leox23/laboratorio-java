package services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Clase que lee las configuraciones para la conexion con la base de datos.
 */
public class Preferences {
    private static final String PATH = "src/main/resources/Preferences.properties";
    public static final Logger log = Logger.getLogger(String.valueOf(Preferences.class));
    private static final Properties properties= new Properties();

    /**
     * Metodo para solicitar valores que estan almacenados en el archivo preference.properties.
     * @param value En String, se recibe parametro de key del que queremos solicitar el valor.
     * @return El valor del key.
     */
    public static String getKey(String value) throws IOException {
        try (FileReader fl = new FileReader(PATH)){
            properties.load(fl);
        } catch (FileNotFoundException e){
            log.info("Archivo no encontrado : " + e);
        } catch (IOException e) {
            log.info("IOException : " + e);
        }
        return properties.getProperty(value);
    }

}
