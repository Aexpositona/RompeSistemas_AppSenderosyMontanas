package RompeSistemas.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface FederacionDAO {

    List<Federacion> getAllFederaciones() throws SQLException;
    public void insertarFederacion(Federacion federacion) throws SQLException;
    public void modificarFederacion(Federacion federacion) throws SQLException;
    public void eliminarFederacion(Federacion federacion) throws SQLException;
    public Federacion buscarFederacion(int id) throws SQLException;
    public Federacion buscarFederacion(String nombre) throws SQLException;
    public ResultSet listarFederaciones() throws SQLException;

    String getUltimoCodigo() throws SQLException;

    ResultSet listarObjetosPorParametro(String parametro) throws SQLException;
}
