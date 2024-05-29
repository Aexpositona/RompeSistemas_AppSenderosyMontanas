package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Infantil;
import java.util.List;

public interface InfantilDAO {
    List<Infantil> listarInfantiles();
    Infantil getInfantil(String codigo);
    void modificarInfantil(Infantil infantil);
    void eliminarInfantil(Infantil infantil);
    void insertarInfantil(Infantil infantil);
}

