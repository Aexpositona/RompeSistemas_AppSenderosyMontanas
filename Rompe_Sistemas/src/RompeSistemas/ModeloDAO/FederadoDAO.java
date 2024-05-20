package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Federado;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface FederadoDAO {
    ResultSet listarFederados() throws SQLException;
    Federado getFederado(String codigo) throws SQLException;
    void modificarFederado(Federado federado) throws SQLException;
    void eliminarFederado(Federado federado) throws SQLException;
    void insertarFederado(Federado federado) throws SQLException;
}
