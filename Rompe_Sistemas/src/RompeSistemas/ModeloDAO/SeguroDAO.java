package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Seguro;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface SeguroDAO {
        Seguro buscarSeguro(int id) throws SQLException;
        ResultSet listarSeguros() throws SQLException;
        Seguro getSeguro(int id) throws SQLException;
}

