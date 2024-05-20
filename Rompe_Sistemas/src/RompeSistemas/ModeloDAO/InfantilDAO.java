package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Infantil;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface InfantilDAO {
    ResultSet listarInfantiles() throws SQLException;
    Infantil getInfantil(String codigo) throws SQLException;
    void modificarInfantil(Infantil infantil) throws SQLException;
    void eliminarInfantil(Infantil infantil) throws SQLException;
    void insertarInfantil(Infantil infantil) throws SQLException;
}
