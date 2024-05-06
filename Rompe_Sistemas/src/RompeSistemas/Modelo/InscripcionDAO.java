package RompeSistemas.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface InscripcionDAO {

        List<Inscripcion> getAllInscripciones() throws SQLException;
        public void insertarInscripcion(Inscripcion inscripcion) throws SQLException;
        public void modificarInscripcion(Inscripcion inscripcion) throws SQLException;
        public void eliminarInscripcion(Inscripcion inscripcion) throws SQLException;
        public Inscripcion buscarInscripcion(String id) throws SQLException;
        public ResultSet listarInscripciones() throws SQLException;

        ResultSet getInscripcionesPorFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException;
}
