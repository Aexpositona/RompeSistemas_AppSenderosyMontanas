package RompeSistemas.Modelo;

import RompeSistemas.Datos.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Clase SQLSeguroDAO que implementa la interfaz SeguroDAO
public class SQLSeguroDAO implements SeguroDAO {

    // Método que devuelve un ResultSet con todos los seguros.
    @Override
    public ResultSet getAllSeguros() throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        PreparedStatement statement = conexion.prepareStatement("SELECT * FROM seguro");
        // Se ejecuta la consulta y se devuelve el resultado.
        return statement.executeQuery();
    }

    // Método que añade un seguro a la base de datos.
    @Override
    public void insertarSeguro(Seguro seguro) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "INSERT INTO Seguro (idSeguro, nombreSeguro, precio) VALUES (?, ?, ?)";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añaden los datos del seguro a la consulta.
        statement.setInt(1, seguro.getId());
        statement.setString(2, seguro.getNombre());
        statement.setDouble(3, seguro.getPrecio());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que modifica un seguro en la base de datos.
    @Override
    public void modificarSeguro(Seguro seguro) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "UPDATE Seguro SET nombreSeguro = ?, precio = ? WHERE idSeguro = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añaden los datos del seguro a la consulta.
        statement.setString(1, seguro.getNombre());
        statement.setDouble(2, seguro.getPrecio());
        statement.setInt(3, seguro.getId());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que elimina un seguro de la base de datos.
    @Override
    public void eliminarSeguro(Seguro seguro) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "DELETE FROM Seguro WHERE idSeguro = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añaden los datos del seguro a eliminar a la consulta.
        statement.setInt(1, seguro.getId());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que busca un seguro en la base de datos por su id.
    @Override
    public Seguro buscarSeguro(int id) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Seguro WHERE idSeguro = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añade el id del seguro a la consulta.
        statement.setInt(1, id);
        // Se ejecuta la consulta.
        ResultSet resultSet = statement.executeQuery();
        // Si se encuentra un seguro con el id proporcionado, se devuelve.
        if (resultSet.next()) {
            return Seguro.getSeguro(resultSet.getInt("idSeguro"));
        } 
        // Si no se encuentra un seguro con el id proporcionado, se devuelve null
        else {
            return null;
        }
    }

    // Método que busca un seguro en la base de datos por su nombre.
    @Override
    public Seguro buscarSeguro(String nombre) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Seguro WHERE nombreSeguro = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añade el nombre del seguro a la consulta.
        statement.setString(1, nombre);
        // Se ejecuta la consulta.
        ResultSet resultSet = statement.executeQuery();
        // Si se encuentra un seguro con el nombre proporcionado, se devuelve.
        if (resultSet.next()) {
            return Seguro.getSeguro(resultSet.getInt("idSeguro"));
        } 
        // Si no se encuentra un seguro con el nombre proporcionado, se devuelve null
        else {
            return null;
        }
    }

    // Método que devuelve un ResultSet con los seguros que tienen un precio menor o igual al proporcionado.
    @Override
    public ResultSet listarSeguros() throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Seguro";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se ejecuta la consulta y se devuelve el resultado.
        return statement.executeQuery();
    }


    @Override
    public Seguro getSeguro(int id) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Seguro WHERE idSeguro = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añade el id del seguro a la consulta.
        statement.setInt(1, id);
        // Se ejecuta la consulta.
        ResultSet resultSet = statement.executeQuery();
        // Si se encuentra un seguro con el id proporcionado, se devuelve.
        if (resultSet.next()) {
            return Seguro.getSeguro(resultSet.getInt("idSeguro"));
        } 
        // Si no se encuentra un seguro con el id proporcionado, se devuelve null
        else {
            return null;
        }
    }

    @Override
    public ResultSet getCantidadSeguros() throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT COUNT(*) FROM Seguro";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se ejecuta la consulta.
        ResultSet resultSet = statement.executeQuery();
        // Se devuelve el resultado.
        return resultSet;
    }
}

