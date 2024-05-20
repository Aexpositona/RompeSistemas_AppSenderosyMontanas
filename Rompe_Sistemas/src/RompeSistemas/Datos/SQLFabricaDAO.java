package RompeSistemas.Datos;

import RompeSistemas.ModeloDAO.*;

import java.sql.Connection;
import java.sql.SQLException;

// Clase que implementa la interfaz FabricaDAO y se encarga de devolver los DAOs de SQL.
public class SQLFabricaDAO implements FabricaDAO {
    private Connection conn;

    public SQLFabricaDAO(Connection conn) {
        this.conn = conn;
    }
    @Override
    public ExcursionDAO getExcursionDAO() {
        return new SQLExcursionDAO(conn);
    }
    
    // Método que devuelve un objeto InscripcionDAO.
    @Override
    public InscripcionDAO getInscripcionDAO() {
        return new SQLInscripcionDAO(conn);
    }

    // Método que devuelve un objeto SocioDAO.
    @Override
    public SocioDAO getSocioDAO() throws SQLException {
        return new SQLSocioDAO(conn);
    }

    // Método que devuelve un objeto FederacionDAO.
    @Override
    public FederacionDAO getFederacionDAO() {
        return new SQLFederacionDAO(conn);
    }
    
    // Método que devuelve un objeto SeguroDAO.
    @Override
    public SeguroDAO getSeguroDAO() {
        return new SQLSeguroDAO();
    }

    @Override
    public InfantilDAO getInfantilDAO() throws SQLException {
        return new SQLInfantilDAO(conn);
    }

    @Override
    public FederadoDAO getFederadoDAO() throws SQLException {
        return new SQLFederadoDAO(conn);
    }

    @Override
    public EstandarDAO getEstandarDAO() throws SQLException {
        return new SQLEstandarDAO(conn);
    }
}