package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Inscripcion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface InscripcionDAO {

        List<Inscripcion> getAllInscripciones() throws SQLException;
        void insertarInscripcion(Inscripcion inscripcion) throws SQLException;
        void modificarInscripcion(Inscripcion inscripcion) throws SQLException;
        void eliminarInscripcion(Inscripcion inscripcion) throws SQLException;
        Inscripcion buscarInscripcion(String id) throws SQLException;
        ResultSet listarInscripciones() throws SQLException;
        ResultSet getInscripcionesPorFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException;
        Inscripcion getInscripcion(String id) throws SQLException;
        
}
