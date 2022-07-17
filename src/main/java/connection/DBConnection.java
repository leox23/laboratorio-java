package connection;

import services.Preferences;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Clase designada para la conexion a la base de datos.
 * */
public class DBConnection {
    private static Connection connection = null;
    public static final Logger log = Logger.getLogger(String.valueOf(DBConnection.class));

    static {
        try {
            Class.forName(Preferences.getKey("DRIVER"));
        } catch (ClassNotFoundException | IOException e) {
            log.info("Error en el driver: " + e);
        }
    }

    /**
     * Metodo para obtener conexion con la base de datos del juego.
      * @return Objeto tipo Connection (perteneciente a java)
     */
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(Preferences.getKey("URL"),
                    Preferences.getKey("USER"),
                    Preferences.getKey("PASSWORD")
            );
        } catch (SQLException | IOException e) {
            log.info("Conexion fallida: " + e);
        }
        return connection;
    }
}
