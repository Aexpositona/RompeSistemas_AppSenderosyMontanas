package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Excursion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface ExcursionDAO {
    ResultSet getAllExcursiones() throws SQLException;
    Excursion getExcursion(String codigo) throws SQLException;
    void addExcursion(Excursion excursion) throws SQLException;
    void updateExcursion(Excursion excursion) throws SQLException;
    void deleteExcursion(Excursion excursion) throws SQLException;
    ResultSet getExcursionesPorFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException;
    String getUltimoCodigo() throws SQLException;
    ResultSet listarObjetosPorParametro(String parametro) throws SQLException;
}
