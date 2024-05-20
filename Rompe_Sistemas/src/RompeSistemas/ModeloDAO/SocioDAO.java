package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Socio;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SocioDAO {
        ResultSet listarSocios() throws SQLException;
        Socio getSocio(String codigo) throws SQLException;
        void modificarSocio(Socio socio) throws SQLException;
        void eliminarSocio(Socio socio) throws SQLException;
        void insertarSocio(Socio socio) throws SQLException;
        Socio buscarSocio(int id) throws SQLException;
        Socio buscarSocio(String codigo) throws SQLException;
}

