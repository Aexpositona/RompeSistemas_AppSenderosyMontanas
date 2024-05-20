package RompeSistemas.Datos;

import RompeSistemas.ModeloDAO.*;
import java.sql.Connection;
import java.sql.SQLException;

public class SQLFabricaDAO implements FabricaDAO {
    private Connection conn;
    private SocioDAO socioDAO;
    private InfantilDAO infantilDAO;
    private FederadoDAO federadoDAO;
    private EstandarDAO estandarDAO;
    private ExcursionDAO excursionDAO;
    private InscripcionDAO inscripcionDAO;
    private FederacionDAO federacionDAO;


    public SQLFabricaDAO(Connection conn) {
        this.conn = conn;
        this.socioDAO = new SQLSocioDAO(conn);
        this.infantilDAO = new SQLInfantilDAO(conn);
        this.federadoDAO = new SQLFederadoDAO(conn);
        this.estandarDAO = new SQLEstandarDAO(conn);
        this.excursionDAO = new SQLExcursionDAO(conn);
        this.inscripcionDAO = new SQLInscripcionDAO(conn);
        this.federacionDAO = new SQLFederacionDAO(conn);
    }

    @Override
    public SocioDAO getSocioDAO() {
        return socioDAO;
    }

    @Override
    public InfantilDAO getInfantilDAO() {
        return infantilDAO;
    }

    @Override
    public FederadoDAO getFederadoDAO() {
        return federadoDAO;
    }

    @Override
    public EstandarDAO getEstandarDAO() {
        return estandarDAO;
    }

    @Override
    public ExcursionDAO getExcursionDAO() {
        return excursionDAO;
    }

    @Override
    public InscripcionDAO getInscripcionDAO() {
        return inscripcionDAO;
    }

    @Override
    public FederacionDAO getFederacionDAO() {
        return federacionDAO;
    }

    @Override
    public SeguroDAO getSeguroDAO() throws SQLException {
        return null;
    }
}
