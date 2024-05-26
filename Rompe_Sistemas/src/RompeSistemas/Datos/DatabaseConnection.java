package RompeSistemas.Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/appsenderosmontanas";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection conn = null;

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new SQLException("MySQL JDBC Driver not found.", e);
            }
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conn;
    }
}


