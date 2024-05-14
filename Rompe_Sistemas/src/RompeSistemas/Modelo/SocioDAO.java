package RompeSistemas.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface SocioDAO {

        List<Socio> getAllSocios() throws SQLException;
        public void insertarSocio(Socio socio) throws SQLException;
        public void modificarSocio(Socio socio) throws SQLException;
        public void eliminarSocio(Socio socio) throws SQLException;
        public Socio buscarSocio(int id) throws SQLException;
        public Socio buscarSocio(String dni) throws SQLException;
        public ResultSet listarSocios() throws SQLException;
        Socio getSocio(String codigo) throws SQLException;
}