import connection.DBConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection myConnection = DBConnection.getConnection();
    }
}

