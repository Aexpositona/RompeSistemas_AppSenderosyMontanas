package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Estandar;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface EstandarDAO {
    ResultSet listarEstandares() throws SQLException;
    Estandar getEstandar(String codigo) throws SQLException;
    void modificarEstandar(Estandar estandar) throws SQLException;
    void eliminarEstandar(Estandar estandar) throws SQLException;
    void insertarEstandar(Estandar estandar) throws SQLException;
}
