package RompeSistemas.Modelo;

// Clase que implementa la interfaz FabricaDAO y se encarga de devolver los DAOs de SQL.
public class SQLFabricaDAO implements FabricaDAO {
    // Método que devuelve un objeto ExcursionDAO.
    @Override
    public ExcursionDAO getExcursionDAO() {
        return new SQLExcursionDAO();
    }
    
    // Método que devuelve un objeto InscripcionDAO.
    @Override
    public InscripcionDAO getInscripcionDAO() {
        return new SQLInscripcionDAO();
    }

    // Método que devuelve un objeto SocioDAO.
    @Override
    public SocioDAO getSocioDAO() {
        return new SQLSocioDAO();
    }

    // Método que devuelve un objeto FederacionDAO.
    @Override
    public FederacionDAO getFederacionDAO() {
        return new SQLFederacionDAO();
    }
    
    // Método que devuelve un objeto SeguroDAO.
    @Override
    public SeguroDAO getSeguroDAO() {
        return new SQLSeguroDAO();
    }
}