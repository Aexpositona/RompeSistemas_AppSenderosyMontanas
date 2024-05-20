package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Federacion;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface FederacionDAO {

    void insertarFederacion(Federacion federacion) throws SQLException;
    void modificarFederacion(Federacion federacion) throws SQLException;
    void eliminarFederacion(Federacion federacion) throws SQLException;
    Federacion buscarFederacion(int id) throws SQLException;
    Federacion buscarFederacion(String nombre) throws SQLException;
    Federacion getFederacion(String codigo) throws SQLException;
    ResultSet listarFederaciones() throws SQLException;
}
