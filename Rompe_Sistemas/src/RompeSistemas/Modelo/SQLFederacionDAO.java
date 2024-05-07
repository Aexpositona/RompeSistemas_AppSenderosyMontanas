package RompeSistemas.Modelo;

import RompeSistemas.Datos.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLFederacionDAO implements FederacionDAO {
    @Override
    public List<Federacion> getAllFederaciones() throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Federacion";
        PreparedStatement statement = conexion.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        List<Federacion> federaciones = new ArrayList<>();
        while (resultSet.next()) {
            federaciones.add(new Federacion(
                    resultSet.getString("codigoFederacion"),
                    resultSet.getString("nombreFederacion")
            ));
        }
        return federaciones;
    }

    @Override
    public void insertarFederacion(Federacion federacion) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "INSERT INTO Federacion (codigoFederacion, nombreFederacion) VALUES (?, ?)";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, federacion.getCodigo());
        statement.setString(2, federacion.getNombre());
        statement.executeUpdate();
    }

    @Override
    public void modificarFederacion(Federacion federacion) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "UPDATE Federacion SET nombreFederacion = ? WHERE codigoFederacion = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, federacion.getNombre());
        statement.setString(2, federacion.getCodigo());
        statement.executeUpdate();
    }

    @Override
    public void eliminarFederacion(Federacion federacion) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "DELETE FROM Federacion WHERE codigoFederacion = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, federacion.getCodigo());
        statement.executeUpdate();
    }

    @Override
    public Federacion buscarFederacion(int id) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Federacion WHERE idFederacion = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new Federacion(
                    resultSet.getString("codigoFederacion"),
                    resultSet.getString("nombreFederacion")
            );
        } else {
            return null;
        }
    }

    @Override
    public Federacion buscarFederacion(String nombre) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Federacion WHERE nombreFederacion = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, nombre);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new Federacion(
                    resultSet.getString("codigoFederacion"),
                    resultSet.getString("nombreFederacion")
            );
        } else {
            return null;
        }
    }

    @Override
    public ResultSet listarFederaciones() throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Federacion";
        PreparedStatement statement = conexion.prepareStatement(query);
        return statement.executeQuery();
    }
    @Override
    public String getUltimoCodigo() throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT MAX(codigoFederacion) AS codigoFederacion FROM Federacion";
        PreparedStatement statement = conexion.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString("codigoFederacion");
        } else {
            return null;
        }
    }

    @Override
    public ResultSet listarObjetosPorParametro(String parametro) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Federacion WHERE nombreFederacion LIKE ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, "%" + parametro + "%");
        return statement.executeQuery();
    }
}