package RompeSistemas.Datos;

import RompeSistemas.Modelo.Federacion;
import RompeSistemas.ModeloDAO.FederacionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Clase que implementa la interfaz FederacionDAO y se encarga de realizar las operaciones de la base de datos relacionadas con las federaciones.
public class SQLFederacionDAO implements FederacionDAO {

    // Método que devuelve una federación a partir de su id.
    @Override
    public void insertarFederacion(Federacion federacion) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "INSERT INTO Federacion (codigoFederacion, nombreFederacion) VALUES (?, ?)";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se establecen los datos de la federación en la consulta.
        statement.setString(1, federacion.getCodigo());
        statement.setString(2, federacion.getNombre());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que modifica una federación en la base de datos.
    @Override
    public void modificarFederacion(Federacion federacion) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "UPDATE Federacion SET nombreFederacion = ? WHERE codigoFederacion = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se establecen los datos de la federación en la consulta.
        statement.setString(1, federacion.getNombre());
        statement.setString(2, federacion.getCodigo());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que elimina una federación de la base de datos.
    @Override
    public void eliminarFederacion(Federacion federacion) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "DELETE FROM Federacion WHERE codigoFederacion = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se establece el código de la federación a eliminar en la consulta.
        statement.setString(1, federacion.getCodigo());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que busca una federación a partir de su id.
    @Override
    public Federacion buscarFederacion(int id) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Federacion WHERE idFederacion = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se establece el id de la federación a buscar en la consulta.
        statement.setInt(1, id);
        // Se ejecuta la consulta y se obtiene el resultado.
        ResultSet resultSet = statement.executeQuery();

        // Si hay resultados, se devuelve una federación con los datos obtenidos.
        if (resultSet.next()) {
            // Se crea un objeto Federacion con los datos obtenidos y se devuelve.
            return new Federacion(
                    resultSet.getString("codigoFederacion"),
                    resultSet.getString("nombreFederacion")
            );
        } 
        // Si no hay más resultados, se devuelve null.
        else {
            return null;
        }
    }

    // Método que busca una federación a partir de su nombre.
    @Override
    public Federacion buscarFederacion(String nombre) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Federacion WHERE nombreFederacion = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se establece el nombre de la federación a buscar en la consulta.
        statement.setString(1, nombre);
        // Se ejecuta la consulta y se obtiene el resultado.
        ResultSet resultSet = statement.executeQuery();

        // Si hay resultados, se devuelve una federación con los datos obtenidos.
        if (resultSet.next()) {
            // Se crea un objeto Federacion con los datos obtenidos y se devuelve.
            return new Federacion(
                    resultSet.getString("codigoFederacion"),
                    resultSet.getString("nombreFederacion")
            );
        } 
        // Si no hay más resultados, se devuelve null.
        else {
            return null;
        }
    }

    // Método que lista todas las federaciones.
    @Override
    public ResultSet listarFederaciones() throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Federacion";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se ejecuta la consulta y se devuelve el resultado.
        return statement.executeQuery();
    }

    // Método que devuelve una federación a partir de su código.
    @Override
    public Federacion getFederacion(String codigo) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Federacion WHERE codigoFederacion = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se establece el código de la federación a buscar en la consulta.
        statement.setString(1, codigo);
        // Se ejecuta la consulta y se obtiene el resultado.
        ResultSet resultSet = statement.executeQuery();

        // Si hay resultados, se devuelve una federación con los datos obtenidos.
        if (resultSet.next()) {
            // Se crea un objeto Federacion con los datos obtenidos y se devuelve.
            return new Federacion(
                    resultSet.getString("codigoFederacion"),
                    resultSet.getString("nombreFederacion")
            );
        } 
        // Si no hay más resultados, se devuelve null.
        else {
            return null;
        }
    }
}