package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            //Dang ky MySQL Driver voi DriverManager
            // Cac thong so
            String url = "jdbc:mySQL://localhost:3306/demo";
            String username = "root";
            String password = "Dquan#1904";

            //Tao ket nooi
            connection = DriverManager.getConnection(url, username, password);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection c) {
        if(c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
