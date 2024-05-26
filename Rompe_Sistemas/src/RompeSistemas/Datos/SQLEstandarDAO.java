package RompeSistemas.Datos;

import RompeSistemas.Modelo.Estandar;
import RompeSistemas.Modelo.Seguro;
import RompeSistemas.ModeloDAO.EstandarDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLEstandarDAO implements EstandarDAO {
    private Connection conn;

    public SQLEstandarDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ResultSet listarEstandares() throws SQLException {
        String query = "SELECT s.codigoSocio, s.nombreSocio, s.nifSocio, sg.nombreSeguro " +
                "FROM Estandar e " +
                "JOIN Socio s ON e.idSocio = s.idSocio " +
                "JOIN Seguro sg ON e.idSeguro = sg.idSeguro";
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    @Override
    public Estandar getEstandar(String codigo) throws SQLException {
        String query = "SELECT e.*, s.*, sg.nombreSeguro FROM Estandar e JOIN Socio s ON e.idSocio = s.idSocio JOIN Seguro sg ON e.idSeguro = sg.idSeguro WHERE s.codigoSocio = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, codigo);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Estandar estandar = new Estandar();
            estandar.setNumero(rs.getString("codigoSocio"));
            estandar.setNombre(rs.getString("nombreSocio"));
            estandar.setNif(rs.getString("nifSocio"));
            estandar.setSeguro(Seguro.valueOf(rs.getString("nombreSeguro")));
            return estandar;
        }
        return null;
    }

    @Override
    public void modificarEstandar(Estandar estandar) throws SQLException {
        String query = "UPDATE Estandar SET idSeguro = ? WHERE idSocio = (SELECT idSocio FROM Socio WHERE codigoSocio = ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, estandar.getSeguro().getId());
        pstmt.setString(2, estandar.getNumero());
        pstmt.executeUpdate();

        query = "UPDATE Socio SET nombreSocio = ?, nifSocio = ? WHERE codigoSocio = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, estandar.getNombre());
        pstmt.setString(2, estandar.getNif());
        pstmt.executeUpdate();
    }

    @Override
    public void eliminarEstandar(Estandar estandar) throws SQLException {
        String query = "DELETE FROM Estandar WHERE idSocio = (SELECT idSocio FROM Socio WHERE codigoSocio = ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, estandar.getNumero());
        pstmt.executeUpdate();

        query = "DELETE FROM Socio WHERE codigoSocio = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, estandar.getNumero());
        pstmt.executeUpdate();
    }

    @Override
    public void insertarEstandar(Estandar estandar) throws SQLException {
        String query = "INSERT INTO Socio (tipo, nombreSocio, nifSocio, codigoSocio) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, estandar.getTipo());
        pstmt.setString(2, estandar.getNombre());
        pstmt.setString(3, estandar.getNif());
        pstmt.setString(4, estandar.getNumero()); // Aquí insertamos el código del socio
        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            int idSocio = rs.getInt(1);
            query = "INSERT INTO Estandar (idSocio, idSeguro) VALUES (?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idSocio);
            pstmt.setInt(2, estandar.getSeguro().getId());
            pstmt.executeUpdate();
        }
    }
}
