package RompeSistemas.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SeguroDAO {

        ResultSet getAllSeguros() throws SQLException;
        void insertarSeguro(Seguro seguro) throws SQLException;
        void modificarSeguro(Seguro seguro) throws SQLException;
        void eliminarSeguro(Seguro seguro) throws SQLException;
        Seguro buscarSeguro(int id) throws SQLException;
        Seguro buscarSeguro(String nombre) throws SQLException;
        ResultSet listarSeguros() throws SQLException;
        Seguro getSeguro(int id) throws SQLException;
        ResultSet getCantidadSeguros() throws SQLException;
}
