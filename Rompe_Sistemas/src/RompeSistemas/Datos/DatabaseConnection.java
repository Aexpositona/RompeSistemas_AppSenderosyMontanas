package RompeSistemas.Datos;

import RompeSistemas.Modelo.Socio;
import RompeSistemas.ModeloDAO.SocioDAO;
import RompeSistemas.Datos.*;
import RompeSistemas.ModeloDAO.*;
import java.sql.*;


/**
 * Clase que se encarga de establecer la conexión con la base de datos.
 *
 */
public class DatabaseConnection {
    // URL de la base de datos
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/appsenderosmontanas";
    // Usuario de la base de datos
    private static final String DATABASE_USER = "root";
    // Contraseña de la base de datos
    private static final String DATABASE_PASSWORD = "admin";

    // Establecer la conexión con la base de datos
    public static Connection getConnection() {
        // Definimos conexión a la base de datos nula
        Connection connection = null;
        // Intentamos establecer la conexión con la base de datos
        try {
            // Establecemos la conexión con la base de datos
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        }
        // En caso de error, mostramos un mensaje de error
        catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            // Mostramos la traza del error
            e.printStackTrace();
        }
        // Retornamos la conexión establecida
        return connection;
    }
}