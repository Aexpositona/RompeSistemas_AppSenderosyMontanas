package RompeSistemas.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface FederacionDAO {

    List<Federacion> getAllFederaciones() throws SQLException;
    void insertarFederacion(Federacion federacion) throws SQLException;
    void modificarFederacion(Federacion federacion) throws SQLException;
    void eliminarFederacion(Federacion federacion) throws SQLException;
    Federacion buscarFederacion(int id) throws SQLException;
    Federacion buscarFederacion(String nombre) throws SQLException;
    Federacion getFederacion(String codigo) throws SQLException;
    ResultSet listarFederaciones() throws SQLException;
}
