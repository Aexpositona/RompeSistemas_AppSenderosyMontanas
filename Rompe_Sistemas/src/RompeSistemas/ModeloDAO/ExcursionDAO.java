package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Excursion;
import java.time.LocalDate;
import java.util.List;

public interface ExcursionDAO {
    List<Excursion> getAllExcursiones();
    Excursion getExcursion(String codigo);
    void addExcursion(Excursion excursion);
    void updateExcursion(Excursion excursion);
    void deleteExcursion(Excursion excursion);
    List<Excursion> getExcursionesPorFecha(LocalDate fechaInicial, LocalDate fechaFinal);
    String getUltimoCodigo();
    List<Excursion> listarObjetosPorParametro(String parametro);
    Excursion getExcursionPorCodigo(String codigoExcursion);
}
