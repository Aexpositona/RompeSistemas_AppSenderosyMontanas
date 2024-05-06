package RompeSistemas.Modelo;

import RompeSistemas.Datos.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLSeguroDAO implements SeguroDAO {

    @Override
    public ResultSet getAllSeguros() throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        PreparedStatement statement = conexion.prepareStatement("SELECT * FROM seguro");
        return statement.executeQuery();
    }

    @Override
    public void insertarSeguro(Seguro seguro) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "INSERT INTO Seguro (idSeguro, nombreSeguro, precio) VALUES (?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setInt(1, seguro.getId());
        statement.setString(2, seguro.getNombre());
        statement.setDouble(3, seguro.getPrecio());
        statement.executeUpdate();
    }

    @Override
    public void modificarSeguro(Seguro seguro) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "UPDATE Seguro SET nombreSeguro = ?, precio = ? WHERE idSeguro = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, seguro.getNombre());
        statement.setDouble(2, seguro.getPrecio());
        statement.setInt(3, seguro.getId());
        statement.executeUpdate();
    }

    @Override
    public void eliminarSeguro(Seguro seguro) throws SQLException {
            Connection conexion = DatabaseConnection.getConnection();
            String query = "DELETE FROM Seguro WHERE idSeguro = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, seguro.getId());
            statement.executeUpdate();
    }

    @Override
    public Seguro buscarSeguro(int id) throws SQLException {
            Connection conexion = DatabaseConnection.getConnection();
            String query = "SELECT * FROM Seguro WHERE idSeguro = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Seguro.getSeguro(resultSet.getInt("idSeguro"));
            } else {
                return null;
            }
    }

    @Override
    public Seguro buscarSeguro(String nombre) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Seguro WHERE nombreSeguro = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, nombre);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return Seguro.getSeguro(resultSet.getInt("idSeguro"));
        } else {
            return null;
        }
    }

    @Override
    public ResultSet listarSeguros() throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Seguro";
        PreparedStatement statement = conexion.prepareStatement(query);
        return statement.executeQuery();
    }

    @Override
    public Seguro getSeguro(int id) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Seguro WHERE idSeguro = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return Seguro.getSeguro(resultSet.getInt("idSeguro"));
        } else {
            return null;
        }
    }
}

