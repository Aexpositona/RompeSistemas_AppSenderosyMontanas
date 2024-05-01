package RompeSistemas.Modelo;

import java.sql.*;

public class ClienteDAO{

    public void insertarObjeto() {
        try {
            // Crear conexión
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/appsenderosmontanas", "root", "admin");

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            ResultSet resultSet = statement.executeQuery("SELECT * FROM socios");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
