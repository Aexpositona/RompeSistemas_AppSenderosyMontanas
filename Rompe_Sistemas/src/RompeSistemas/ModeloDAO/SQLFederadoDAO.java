package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Federacion;
import RompeSistemas.Modelo.Federado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLFederadoDAO implements FederadoDAO {
    private Connection conn;

    public SQLFederadoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ResultSet listarFederados() throws SQLException {
        String query = "SELECT * FROM Federado";
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    @Override
    public Federado getFederado(String codigo) throws SQLException {
        String query = "SELECT f.*, s.*, fe.* FROM Federado f JOIN Socio s ON f.idSocio = s.idSocio JOIN Federacion fe ON f.idFederacion = fe.idFederacion WHERE s.codigoSocio = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, codigo);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Federacion federacion = new Federacion(rs.getString("codigoFederacion"), rs.getString("nombreFederacion"));
            Federado federado = new Federado(rs.getString("nombreSocio"), rs.getString("codigoSocio"), rs.getString("nifSocio"), federacion);
            return federado;
        }
        return null;
    }

    @Override
    public void modificarFederado(Federado federado) throws SQLException {
        String query = "UPDATE Federado SET idFederacion = (SELECT idFederacion FROM Federacion WHERE codigoFederacion = ?) WHERE idSocio = (SELECT idSocio FROM Socio WHERE codigoSocio = ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, federado.getFederacion().getCodigo());
        pstmt.setString(2, federado.getNumero());
        pstmt.executeUpdate();

        query = "UPDATE Socio SET nombreSocio = ?, nifSocio = ? WHERE codigoSocio = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, federado.getNombre());
        pstmt.setString(2, federado.getNif());
        pstmt.executeUpdate();
    }

    @Override
    public void eliminarFederado(Federado federado) throws SQLException {
        String query = "DELETE FROM Federado WHERE idSocio = (SELECT idSocio FROM Socio WHERE codigoSocio = ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, federado.getNumero());
        pstmt.executeUpdate();

        query = "DELETE FROM Socio WHERE codigoSocio = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, federado.getNumero());
        pstmt.executeUpdate();
    }

    @Override
    public void insertarFederado(Federado federado) throws SQLException {
        String query = "INSERT INTO Socio (tipo, codigoSocio, nombreSocio, nifSocio) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, federado.getTipo());
        pstmt.setString(2, federado.getNumero());
        pstmt.setString(3, federado.getNombre());
        pstmt.setString(4, federado.getNif());
        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            int idSocio = rs.getInt(1);
            query = "INSERT INTO Federado (idSocio, idFederacion) VALUES (?, (SELECT idFederacion FROM Federacion WHERE codigoFederacion = ?))";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, idSocio);
            pstmt.setString(2, federado.getFederacion().getCodigo());
            pstmt.executeUpdate();
        }
    }
}
