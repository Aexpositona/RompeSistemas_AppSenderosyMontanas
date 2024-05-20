package RompeSistemas.Datos;

import RompeSistemas.Modelo.Seguro;
import RompeSistemas.ModeloDAO.SeguroDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Clase SQLSeguroDAO que implementa la interfaz SeguroDAO
public class SQLSeguroDAO implements SeguroDAO {



    // Método que añade un seguro a la base de datos.
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

}

