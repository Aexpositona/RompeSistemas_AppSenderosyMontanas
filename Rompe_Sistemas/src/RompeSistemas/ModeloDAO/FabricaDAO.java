package RompeSistemas.ModeloDAO;

public interface FabricaDAO {


    ExcursionDAO getExcursionDAO();
    InscripcionDAO getInscripcionDAO();
    SocioDAO getSocioDAO();
    FederacionDAO getFederacionDAO();
    SeguroDAO getSeguroDAO();

}