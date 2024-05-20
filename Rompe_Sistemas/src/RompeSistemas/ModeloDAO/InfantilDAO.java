package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Infantil;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface InfantilDAO {
    public ResultSet listarInfantiles() throws SQLException;
    public Infantil getInfantil(String codigo) throws SQLException;
    public void modificarInfantil(Infantil infantil) throws SQLException;
    public void eliminarInfantil(Infantil infantil) throws SQLException;
    public void insertarInfantil(Infantil infantil) throws SQLException;
}
