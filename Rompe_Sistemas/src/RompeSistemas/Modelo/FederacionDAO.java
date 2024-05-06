package RompeSistemas.Modelo;

import java.util.List;

public interface FederacionDAO {

    List<Federacion> getAllFederaciones();
    public void insertarFederacion(Federacion federacion);
    public void modificarFederacion(Federacion federacion);
    public void eliminarFederacion(Federacion federacion);
    public Federacion buscarFederacion(int id);
    public Federacion buscarFederacion(String nombre);
    public Federacion[] listarFederaciones();
}
