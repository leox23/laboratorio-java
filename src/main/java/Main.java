import connection.DBConnection;

import java.io.IOException;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws IOException {
        GameCommanlineInt game = new GameCommanlineInt();
        game.gameInit();
        Connection myConnection = DBConnection.getConnection();
    }


}

