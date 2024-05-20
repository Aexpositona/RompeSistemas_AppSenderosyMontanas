package RompeSistemas.ModeloDAO;

import java.sql.SQLException;

public interface FabricaDAO {
    ExcursionDAO getExcursionDAO() throws SQLException;
    InscripcionDAO getInscripcionDAO() throws SQLException;
    SocioDAO getSocioDAO() throws SQLException;
    FederacionDAO getFederacionDAO() throws SQLException;
    SeguroDAO getSeguroDAO() throws SQLException;
    InfantilDAO getInfantilDAO() throws SQLException;
    FederadoDAO getFederadoDAO() throws SQLException;
    EstandarDAO getEstandarDAO() throws SQLException;
}
