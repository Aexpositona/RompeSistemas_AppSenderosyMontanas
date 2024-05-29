package RompeSistemas.ModeloDAO;

import RompeSistemas.Modelo.Federacion;
import java.util.List;

public interface FederacionDAO {
    void insertarFederacion(Federacion federacion);
    void modificarFederacion(Federacion federacion);
    void eliminarFederacion(Federacion federacion);
    Federacion buscarFederacion(int id);
    Federacion buscarFederacion(String nombre);
    Federacion getFederacion(String codigo);
    List<Federacion> listarFederaciones();
}

