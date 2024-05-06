package RompeSistemas.Modelo;

import RompeSistemas.Datos.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLExcursionDAO implements ExcursionDAO {
    @Override
    public ResultSet getAllExcursiones() throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Excursion";
        PreparedStatement statement = conexion.prepareStatement(query);
        return statement.executeQuery();
    }

    @Override
    public Excursion getExcursion(int id) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Excursion WHERE idExcursion = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new Excursion(
                    resultSet.getString("codigoExcursion"),
                    resultSet.getString("descripcion"),
                    resultSet.getDate("fecha").toLocalDate(),
                    resultSet.getInt("duracion"),
                    resultSet.getFloat("precio")
            );
        } else {
            return null;
        }
    }

    @Override
    public void addExcursion(Excursion excursion) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "INSERT INTO Excursion (codigoExcursion, descripcion, fecha, duracion, precio) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, excursion.getCodigo());
        statement.setString(2, excursion.getDescripcion());
        statement.setDate(3, java.sql.Date.valueOf(excursion.getFecha()));
        statement.setInt(4, excursion.getDuracion());
        statement.setFloat(5, excursion.getPrecio());
        statement.executeUpdate();
    }

    @Override
    public void updateExcursion(Excursion excursion) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "UPDATE Excursion SET descripcion = ?, fecha = ?, duracion = ?, precio = ? WHERE codigoExcursion = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, excursion.getDescripcion());
        statement.setDate(2, java.sql.Date.valueOf(excursion.getFecha()));
        statement.setInt(3, excursion.getDuracion());
        statement.setFloat(4, excursion.getPrecio());
        statement.setString(5, excursion.getCodigo());
        statement.executeUpdate();
    }

    @Override
    public void deleteExcursion(int id) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "DELETE FROM Excursion WHERE idExcursion = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
}