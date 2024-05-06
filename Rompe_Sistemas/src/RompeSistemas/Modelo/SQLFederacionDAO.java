package RompeSistemas.Modelo;

import java.util.List;

public class SQLFederacionDAO implements FederacionDAO {
    @Override
    public List<Federacion> getAllFederaciones() {
        return List.of();
    }

    @Override
    public void insertarFederacion(Federacion federacion) {

    }

    @Override
    public void modificarFederacion(Federacion federacion) {

    }

    @Override
    public void eliminarFederacion(Federacion federacion) {

    }

    @Override
    public Federacion buscarFederacion(int id) {
        return null;
    }

    @Override
    public Federacion buscarFederacion(String nombre) {
        return null;
    }

    @Override
    public Federacion[] listarFederaciones() {
        return new Federacion[0];
    }
}
