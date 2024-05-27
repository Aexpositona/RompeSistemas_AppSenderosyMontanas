package RompeSistemas.Datos;

import RompeSistemas.Modelo.Socio;
import RompeSistemas.ModeloDAO.SocioDAO;

import java.sql.*;

public class SQLSocioDAO implements SocioDAO {
    private Connection conn;

    public SQLSocioDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public ResultSet listarSocios() throws SQLException {
        String query = "SELECT * FROM socio";
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    @Override
    public Socio getSocio(String codigo) throws SQLException {
        String query = "SELECT * FROM Socio WHERE codigoSocio = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, codigo);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new Socio(
                    rs.getString("nombreSocio"),
                    rs.getString("codigoSocio"),
                    rs.getString("nifSocio")
            );
        }
        return null;
    }

    @Override
    public void modificarSocio(Socio socio) throws SQLException {
        String query = "UPDATE Socio SET nombreSocio = ?, nifSocio = ? WHERE codigoSocio = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, socio.getNombre());
        pstmt.setString(2, socio.getNif());
        pstmt.setString(3, socio.getNumero());
        pstmt.executeUpdate();
    }

    @Override
    public void eliminarSocio(Socio socio) throws SQLException {
        // Obtener el idSocio basado en el objeto Socio
        String getIdQuery = "SELECT idSocio FROM Socio WHERE codigoSocio = ?";
        PreparedStatement pstmt = conn.prepareStatement(getIdQuery);
        pstmt.setString(1, socio.getNumero());
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            int idSocio = rs.getInt("idSocio");

            // Eliminar en las tablas dependientes
            String deleteEstandarQuery = "DELETE FROM Estandar WHERE idSocio = ?";
            PreparedStatement deleteEstandarStmt = conn.prepareStatement(deleteEstandarQuery);
            deleteEstandarStmt.setInt(1, idSocio);
            deleteEstandarStmt.executeUpdate();

            String deleteInfantilQuery = "DELETE FROM Infantil WHERE idSocio = ?";
            PreparedStatement deleteInfantilStmt = conn.prepareStatement(deleteInfantilQuery);
            deleteInfantilStmt.setInt(1, idSocio);
            deleteInfantilStmt.executeUpdate();

            String deleteFederadoQuery = "DELETE FROM Federado WHERE idSocio = ?";
            PreparedStatement deleteFederadoStmt = conn.prepareStatement(deleteFederadoQuery);
            deleteFederadoStmt.setInt(1, idSocio);
            deleteFederadoStmt.executeUpdate();

            // Eliminar en la tabla Socio
            String deleteSocioQuery = "DELETE FROM Socio WHERE idSocio = ?";
            PreparedStatement deleteSocioStmt = conn.prepareStatement(deleteSocioQuery);
            deleteSocioStmt.setInt(1, idSocio);
            deleteSocioStmt.executeUpdate();

            System.out.println("Socio eliminado correctamente.");
        } else {
            System.out.println("Socio no encontrado.");
        }
    }


    @Override
    public void insertarSocio(Socio socio) throws SQLException {
        String query = "INSERT INTO Socio (nombreSocio, codigoSocio, nifSocio) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, socio.getNombre());
        pstmt.setString(2, socio.getNumero());
        pstmt.setString(3, socio.getNif());
        pstmt.executeUpdate();
    }

    @Override
    public Socio buscarSocio(int id) throws SQLException {
        String query = "SELECT * FROM Socio WHERE idSocio = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new Socio(
                    rs.getString("nombreSocio"),
                    rs.getString("codigoSocio"),
                    rs.getString("nifSocio")
            );
        }
        return null;
    }

    @Override
    public Socio buscarSocio(String codigo) throws SQLException {
        return getSocio(codigo);
    }
}
