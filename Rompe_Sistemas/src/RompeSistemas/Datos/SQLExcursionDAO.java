package RompeSistemas.Datos;

import RompeSistemas.Modelo.Excursion;
import RompeSistemas.ModeloDAO.ExcursionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SQLExcursionDAO implements ExcursionDAO {
    private Connection conn;

    public SQLExcursionDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ResultSet getAllExcursiones() throws SQLException {
        String query = "SELECT * FROM Excursion";
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    @Override
    public Excursion getExcursion(String codigo) throws SQLException {
        String query = "SELECT * FROM Excursion WHERE codigoExcursion = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, codigo);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new Excursion(
                    rs.getString("codigoExcursion"),
                    rs.getString("descripcion"),
                    rs.getDate("fecha").toLocalDate(),
                    rs.getInt("duracion"),
                    rs.getFloat("precio")
            );
        }
        return null;
    }

    @Override
    public void addExcursion(Excursion excursion) throws SQLException {
        String query = "INSERT INTO Excursion (codigoExcursion, descripcion, fecha, duracion, precio) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, excursion.getCodigo());
        pstmt.setString(2, excursion.getDescripcion());
        pstmt.setDate(3, java.sql.Date.valueOf(excursion.getFecha()));
        pstmt.setInt(4, excursion.getDuracion());
        pstmt.setFloat(5, excursion.getPrecio());
        pstmt.executeUpdate();
    }

    @Override
    public void updateExcursion(Excursion excursion) throws SQLException {
        String query = "UPDATE Excursion SET descripcion = ?, fecha = ?, duracion = ?, precio = ? WHERE codigoExcursion = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, excursion.getDescripcion());
        pstmt.setDate(2, java.sql.Date.valueOf(excursion.getFecha()));
        pstmt.setInt(3, excursion.getDuracion());
        pstmt.setFloat(4, excursion.getPrecio());
        pstmt.setString(5, excursion.getCodigo());
        pstmt.executeUpdate();
    }

    @Override
    public void deleteExcursion(Excursion excursion) throws SQLException {
        String query = "DELETE FROM Excursion WHERE codigoExcursion = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, excursion.getCodigo());
        pstmt.executeUpdate();
    }

    @Override
    public ResultSet getExcursionesPorFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException {
        String query = "SELECT * FROM Excursion WHERE fecha BETWEEN ? AND ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setDate(1, java.sql.Date.valueOf(fechaInicial));
        pstmt.setDate(2, java.sql.Date.valueOf(fechaFinal));
        return pstmt.executeQuery();
    }

    @Override
    public String getUltimoCodigo() throws SQLException {
        String query = "SELECT codigoExcursion FROM Excursion ORDER BY codigoExcursion DESC LIMIT 1";
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString("codigoExcursion");
        }
        return null;
    }

    @Override
    public ResultSet listarObjetosPorParametro(String parametro) throws SQLException {
        String query = "SELECT * FROM Excursion WHERE descripcion LIKE ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "%" + parametro + "%");
        return pstmt.executeQuery();
    }
}
