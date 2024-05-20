package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Infantil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLInfantilDAO implements InfantilDAO {
    private Connection conn;

    public SQLInfantilDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ResultSet listarInfantiles() throws SQLException {
        String query = "SELECT * FROM Infantil";
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    @Override
    public Infantil getInfantil(String codigo) throws SQLException {
        String query = "SELECT i.*, s.* FROM Infantil i JOIN Socio s ON i.idSocio = s.idSocio WHERE s.codigoSocio = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, codigo);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Infantil infantil = new Infantil();
            infantil.setNumero(rs.getString("codigoSocio"));
            infantil.setNombre(rs.getString("nombreSocio"));
            infantil.setNif(rs.getString("nifSocio"));
            infantil.setNumSocioTutor(rs.getString("idSocioTutor"));
            return infantil;
        }
        return null;
    }

    @Override
    public void modificarInfantil(Infantil infantil) throws SQLException {
        String query = "UPDATE Infantil SET idSocioTutor = ? WHERE idSocio = (SELECT idSocio FROM Socio WHERE codigoSocio = ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, infantil.getNumSocioTutor());
        pstmt.setString(2, infantil.getNumero());
        pstmt.executeUpdate();

        query = "UPDATE Socio SET nombreSocio = ?, nifSocio = ? WHERE codigoSocio = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, infantil.getNombre());
        pstmt.setString(2, infantil.getNif());
        pstmt.setString(3, infantil.getNumero());
        pstmt.executeUpdate();
    }

    @Override
    public void eliminarInfantil(Infantil infantil) throws SQLException {
        String query = "DELETE FROM Infantil WHERE idSocio = (SELECT idSocio FROM Socio WHERE codigoSocio = ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, infantil.getNumero());
        pstmt.executeUpdate();

        query = "DELETE FROM Socio WHERE codigoSocio = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, infantil.getNumero());
        pstmt.executeUpdate();
    }

    @Override
    public void insertarInfantil(Infantil infantil) throws SQLException {
        String query = "INSERT INTO Socio (tipo, codigoSocio, nombreSocio, nifSocio) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, infantil.getTipo());
        pstmt.setString(2, infantil.getNumero());
        pstmt.setString(3, infantil.getNombre());
        pstmt.setString(4, infantil.getNif());
        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            int idSocio = rs.getInt(1);
            query = "INSERT INTO Infantil (idSocio, idSocioTutor) VALUES (?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idSocio);
            pstmt.setString(2, infantil.getNumSocioTutor());
            pstmt.executeUpdate();
        }
    }
}