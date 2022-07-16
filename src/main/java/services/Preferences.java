package services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Preferences {
    private static final String PATH = "src/main/resources/Preferences.properties";
    private static final Messages message = Messages.getInstance();
    private static Properties properties= new Properties();
    private static Preferences instance = null;

    public static Preferences getInstance() {
        if (instance instanceof Preferences) {
            return instance;
        } else {
            instance = new Preferences();
        }
        return instance;
    }

    public static String getKey(String value){

        try {
            properties.load(new FileReader(PATH));
        } catch (FileNotFoundException e){
            message.showMessage("Archivo no encontrado : " + e);
        } catch (IOException e) {
            message.showMessage("IOException : " + e);
        }
        return properties.getProperty(value);
    }

}
