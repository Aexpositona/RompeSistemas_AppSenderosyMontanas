package RompeSistemas.Datos;

import RompeSistemas.Modelo.Federacion;
import RompeSistemas.ModeloDAO.FederacionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLFederacionDAO implements FederacionDAO {
    private Connection conn;

    public SQLFederacionDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertarFederacion(Federacion federacion) throws SQLException {
        String query = "INSERT INTO Federacion (codigoFederacion, nombreFederacion) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, federacion.getCodigo());
        statement.setString(2, federacion.getNombre());
        statement.executeUpdate();
    }

    @Override
    public void modificarFederacion(Federacion federacion) throws SQLException {
        String query = "UPDATE Federacion SET nombreFederacion = ? WHERE codigoFederacion = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, federacion.getNombre());
        statement.setString(2, federacion.getCodigo());
        statement.executeUpdate();
    }

    @Override
    public void eliminarFederacion(Federacion federacion) throws SQLException {
        String query = "DELETE FROM Federacion WHERE codigoFederacion = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, federacion.getCodigo());
        statement.executeUpdate();
    }

    @Override
    public Federacion buscarFederacion(int id) throws SQLException {
        String query = "SELECT * FROM Federacion WHERE idFederacion = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Federacion(
                    resultSet.getString("codigoFederacion"),
                    resultSet.getString("nombreFederacion")
            );
        }
        return null;
    }

    @Override
    public Federacion buscarFederacion(String nombre) throws SQLException {
        String query = "SELECT * FROM Federacion WHERE nombreFederacion = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, nombre);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Federacion(
                    resultSet.getString("codigoFederacion"),
                    resultSet.getString("nombreFederacion")
            );
        }
        return null;
    }

    @Override
    public Federacion getFederacion(String codigo) throws SQLException {
        String query = "SELECT * FROM Federacion WHERE codigoFederacion = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, codigo);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Federacion(
                    resultSet.getString("codigoFederacion"),
                    resultSet.getString("nombreFederacion")
            );
        }
        return null;
    }

    @Override
    public ResultSet listarFederaciones() throws SQLException {
        String query = "SELECT * FROM Federacion";
        PreparedStatement statement = conn.prepareStatement(query);
        return statement.executeQuery();
    }
}
