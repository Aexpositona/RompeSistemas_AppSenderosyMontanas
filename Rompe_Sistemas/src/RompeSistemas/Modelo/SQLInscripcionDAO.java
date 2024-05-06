package RompeSistemas.Modelo;

import RompeSistemas.Datos.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SQLInscripcionDAO implements InscripcionDAO {
    @Override
    public List<Inscripcion> getAllInscripciones() throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Inscripcion";
        PreparedStatement statement = conexion.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        List<Inscripcion> inscripciones = new ArrayList<>();
        while (resultSet.next()) {
            inscripciones.add(new Inscripcion(
                    resultSet.getString("codigoInscripcion"),
                    resultSet.getDate("fechaInscripcion").toLocalDate(),
                    resultSet.getString("idSocio"),
                    resultSet.getString("idExcursion")
            ));
        }
        return inscripciones;
    }

    @Override
    public void insertarInscripcion(Inscripcion inscripcion) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "INSERT INTO Inscripcion (codigoInscripcion, fechaInscripcion, idSocio, idExcursion) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, inscripcion.getNumero());
        statement.setDate(2, java.sql.Date.valueOf(inscripcion.getFecha()));
        statement.setString(3, inscripcion.getSocio().getNumero());
        statement.setString(4, inscripcion.getExcursion().getCodigo());
        statement.executeUpdate();
    }

    @Override
    public void modificarInscripcion(Inscripcion inscripcion) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "UPDATE Inscripcion SET fechaInscripcion = ?, idSocio = ?, idExcursion = ? WHERE codigoInscripcion = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setDate(1, java.sql.Date.valueOf(inscripcion.getFecha()));
        statement.setString(2, inscripcion.getSocio().getNumero());
        statement.setString(3, inscripcion.getExcursion().getCodigo());
        statement.setString(4, inscripcion.getNumero());
        statement.executeUpdate();
    }

    @Override
    public void eliminarInscripcion(Inscripcion inscripcion) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "DELETE FROM Inscripcion WHERE codigoInscripcion = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, inscripcion.getNumero());
        statement.executeUpdate();
    }

    @Override
    public Inscripcion buscarInscripcion(String id) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Inscripcion WHERE idInscripcion = ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setInt(1, Integer.parseInt(id));
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new Inscripcion(
                    resultSet.getString("codigoInscripcion"),
                    resultSet.getDate("fechaInscripcion").toLocalDate(),
                    resultSet.getString("idSocio"),
                    resultSet.getString("idExcursion")
            );
        } else {
            return null;
        }
    }

    @Override
    public ResultSet listarInscripciones() throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Inscripcion";
        PreparedStatement statement = conexion.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getInscripcionesPorFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Inscripcion WHERE fechaInscripcion BETWEEN ? AND ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setDate(1, java.sql.Date.valueOf(fechaInicial));
        statement.setDate(2, java.sql.Date.valueOf(fechaFinal));
        return statement.executeQuery();

    }
}
