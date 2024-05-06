package RompeSistemas.Modelo;

public class SQLFabricaDAO implements FabricaDAO {
    @Override
    public ExcursionDAO getExcursionDAO() {
        return new SQLExcursionDAO();
    }

    @Override
    public InscripcionDAO getInscripcionDAO() {
        return new SQLInscripcionDAO();
    }

    @Override
    public SocioDAO getSocioDAO() {
        return new SQLSocioDAO();
    }

    @Override
    public FederacionDAO getFederacionDAO() {
        return new SQLFederacionDAO();
    }

    @Override
    public SeguroDAO getSeguroDAO() {
        return new SQLSeguroDAO();
    }
}