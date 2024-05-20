package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Estandar;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface EstandarDAO {
    public ResultSet listarEstandares() throws SQLException;
    public Estandar getEstandar(String codigo) throws SQLException;
    public void modificarEstandar(Estandar estandar) throws SQLException;
    public void eliminarEstandar(Estandar estandar) throws SQLException;
    public void insertarEstandar(Estandar estandar) throws SQLException;
}
