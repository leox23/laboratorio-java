package connection;

import services.Messages;
import services.Preferences;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;
    private static final Messages message = Messages.getInstance();
    private static final Preferences preferences = Preferences.getInstance();

    static {
        try {
            Class.forName(Preferences.getKey("DRIVER"));
        } catch (ClassNotFoundException e) {
            message.showMessage("Error en el driver: " + e);
        }
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(Preferences.getKey("URL"),
                    Preferences.getKey("USER"),
                    Preferences.getKey("PASSWORD")
            );
        } catch (SQLException e) {
            message.showMessage("Conexion fallida: " + e);
        }
        return connection;
    }
}
