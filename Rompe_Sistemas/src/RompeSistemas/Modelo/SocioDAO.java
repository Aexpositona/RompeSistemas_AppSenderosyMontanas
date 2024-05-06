package RompeSistemas.Modelo;

import java.sql.SQLException;
import java.util.List;

public interface SocioDAO {

        List<Socio> getAllSocios() throws SQLException;
        public void insertarSocio(Socio socio) throws SQLException;
        public void modificarSocio(Socio socio) throws SQLException;
        public void eliminarSocio(Socio socio) throws SQLException;
        public Socio buscarSocio(int id) throws SQLException;
        public Socio buscarSocio(String dni) throws SQLException;
        public Socio[] listarSocios() throws SQLException;
}
