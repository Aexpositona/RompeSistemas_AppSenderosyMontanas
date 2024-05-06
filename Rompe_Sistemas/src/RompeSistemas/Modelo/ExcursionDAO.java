package RompeSistemas.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ExcursionDAO {
    ResultSet getAllExcursiones() throws SQLException;
    Excursion getExcursion(int id) throws SQLException;
    void addExcursion(Excursion excursion) throws SQLException;
    void updateExcursion(Excursion excursion) throws SQLException;
    void deleteExcursion(int id) throws SQLException;
}
