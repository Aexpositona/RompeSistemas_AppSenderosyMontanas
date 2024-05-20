package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Federado;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface FederadoDAO {
    public ResultSet listarFederados() throws SQLException;
    public Federado getFederado(String codigo) throws SQLException;
    public void modificarFederado(Federado federado) throws SQLException;
    public void eliminarFederado(Federado federado) throws SQLException;
    public void insertarFederado(Federado federado) throws SQLException;
}
