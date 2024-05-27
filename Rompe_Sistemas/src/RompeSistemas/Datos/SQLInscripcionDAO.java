package RompeSistemas.Datos;

import RompeSistemas.Modelo.Inscripcion;
import RompeSistemas.ModeloDAO.InscripcionDAO;

import java.sql.*;
import java.time.LocalDate;

public class SQLInscripcionDAO implements InscripcionDAO {
    private Connection conn;

    public SQLInscripcionDAO(Connection conn) {

        this.conn = conn;
    }

    @Override
    public void insertarInscripcion(Inscripcion inscripcion) throws SQLException {
        // Obtener idSocio a partir del codigoSocio
        String querySocio = "SELECT idSocio FROM Socio WHERE codigoSocio = ?";
        PreparedStatement stmtSocio = conn.prepareStatement(querySocio);
        stmtSocio.setString(1, inscripcion.getSocio().getNumero());
        ResultSet rsSocio = stmtSocio.executeQuery();

        if (!rsSocio.next()) {
            throw new SQLException("No se encontró el socio con código: " + inscripcion.getSocio().getNumero());
        }
        int idSocio = rsSocio.getInt("idSocio");

        // Obtener idExcursion a partir del codigoExcursion
        String queryExcursion = "SELECT idExcursion FROM Excursion WHERE codigoExcursion = ?";
        PreparedStatement stmtExcursion = conn.prepareStatement(queryExcursion);
        stmtExcursion.setString(1, inscripcion.getExcursion().getCodigo());
        ResultSet rsExcursion = stmtExcursion.executeQuery();

        if (!rsExcursion.next()) {
            throw new SQLException("No se encontró la excursión con código: " + inscripcion.getExcursion().getCodigo());
        }
        int idExcursion = rsExcursion.getInt("idExcursion");

        // Insertar la inscripción utilizando los IDs obtenidos
        String query = "INSERT INTO Inscripcion (codigoInscripcion, fechaInscripcion, idSocio, idExcursion) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, inscripcion.getNumero());
        statement.setDate(2, java.sql.Date.valueOf(inscripcion.getFecha()));
        statement.setInt(3, idSocio);
        statement.setInt(4, idExcursion);
        statement.executeUpdate();
    }
    public ResultSet getAllInscripciones() throws SQLException {
        String query = "SELECT * FROM Inscripcion";
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }

    @Override
    public void modificarInscripcion(Inscripcion inscripcion) throws SQLException {
        String query = "UPDATE Inscripcion SET fechaInscripcion = ?, idSocio = ?, idExcursion = ? WHERE codigoInscripcion = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setDate(1, java.sql.Date.valueOf(inscripcion.getFecha()));
        statement.setString(2, inscripcion.getSocio().getNumero());
        statement.setString(3, inscripcion.getExcursion().getCodigo());
        statement.setString(4, inscripcion.getNumero());
        statement.executeUpdate();
    }

    @Override
    public void eliminarInscripcion(Inscripcion inscripcion) throws SQLException {
        String query = "DELETE FROM Inscripcion WHERE codigoInscripcion = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, inscripcion.getNumero());
        statement.executeUpdate();
    }

    @Override
    public Inscripcion buscarInscripcion(String id) throws SQLException {
        String query = "SELECT * FROM Inscripcion WHERE idInscripcion = ?";
        PreparedStatement statement = conn.prepareStatement(query);
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
        String query = "SELECT * FROM Inscripcion";
        PreparedStatement statement = conn.prepareStatement(query);
        return statement.executeQuery();
    }

    @Override
    public ResultSet getInscripcionesPorSocio(String idSocio) throws SQLException {
        String query = "SELECT * FROM Inscripcion WHERE idSocio = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, idSocio);
        return stmt.executeQuery();
    }

    @Override
    public ResultSet getInscripcionesPorFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException {
        String query = "SELECT i.codigoInscripcion, i.fechaInscripcion, i.idSocio, i.idExcursion, ex.codigoExcursion " +
                "FROM Inscripcion i " +
                "JOIN Excursion ex ON i.idExcursion = ex.idExcursion " +
                "WHERE i.fechaInscripcion BETWEEN ? AND ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setDate(1, Date.valueOf(fechaInicial));
        pstmt.setDate(2, Date.valueOf(fechaFinal));
        return pstmt.executeQuery();
    }


    @Override
    public Inscripcion getInscripcion(String codigo) throws SQLException {
        String query = "SELECT * FROM Inscripcion WHERE codigoInscripcion = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, codigo);
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

}
