package RompeSistemas.Modelo;

public class SQLFabricaDAO implements FabricaDAO {

    private static SQLFabricaDAO instance;

    public SQLFabricaDAO() {
        // Constructor privado para prevenir la instanciación directa
    }

    public static SQLFabricaDAO getFabricaDAO() {
        if (instance == null) {
            instance = new SQLFabricaDAO();
        }
        return instance;
    }

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