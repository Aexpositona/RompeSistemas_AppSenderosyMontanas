package RompeSistemas.Datos;

import RompeSistemas.Modelo.Seguro;
import RompeSistemas.ModeloDAO.SeguroDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLSeguroDAO implements SeguroDAO {
    private Connection conn;

    public SQLSeguroDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Seguro buscarSeguro(int id) throws SQLException {
        String query = "SELECT * FROM Seguro WHERE idSeguro = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return Seguro.getSeguro(resultSet.getInt("idSeguro"));
        } else {
            return null;
        }
    }

    @Override
    public ResultSet listarSeguros() throws SQLException {
        String query = "SELECT * FROM Seguro";
        PreparedStatement statement = conn.prepareStatement(query);
        return statement.executeQuery();
    }

    @Override
    public Seguro getSeguro(int id) throws SQLException {
        String query = "SELECT * FROM Seguro WHERE idSeguro = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return Seguro.getSeguro(resultSet.getInt("idSeguro"));
        } else {
            return null;
        }
    }
}
