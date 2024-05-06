package RompeSistemas.Modelo;

import RompeSistemas.Datos.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLSocioDAO implements SocioDAO {
    @Override
    public List<Socio> getAllSocios() throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Socio";
        PreparedStatement statement = conexion.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        List<Socio> socios = new ArrayList<>();
        while (resultSet.next()) {
            socios.add(new Socio(
                    resultSet.getString("nombreSocio"),
                    resultSet.getString("codigoSocio"),
                    resultSet.getString("nifSocio")
            ));
        }
        return socios;
    }

    @Override
    public void insertarSocio(Socio socio) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "INSERT INTO Socio (nombreSocio, codigoSocio, nifSocio) VALUES (?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, socio.getNombre());
        statement.setString(2, socio.getNumero());
        statement.setString(3, socio.getNif());
        statement.executeUpdate();
    }

    @Override
    public void modificarSocio(Socio socio) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "UPDATE Socio SET nombreSocio = ?, nifSocio = ? WHERE codigoSocio = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, socio.getNombre());
        statement.setString(2, socio.getNif());
        statement.setString(3, socio.getNumero());
        statement.executeUpdate();
    }

    @Override
    public void eliminarSocio(Socio socio) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "DELETE FROM Socio WHERE codigoSocio = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, socio.getNumero());
        statement.executeUpdate();
    }

    @Override
    public Socio buscarSocio(int id) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Socio WHERE idSocio = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new Socio(
                    resultSet.getString("nombreSocio"),
                    resultSet.getString("codigoSocio"),
                    resultSet.getString("nifSocio")
            );
        } else {
            return null;
        }
    }

    @Override
    public Socio buscarSocio(String dni) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Socio WHERE nifSocio = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, dni);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new Socio(
                    resultSet.getString("nombreSocio"),
                    resultSet.getString("codigoSocio"),
                    resultSet.getString("nifSocio")
            );
        } else {
            return null;
        }
    }

    @Override
    public ResultSet listarSocios() throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Socio";
        PreparedStatement statement = conexion.prepareStatement(query);
        return statement.executeQuery();
    }
}
