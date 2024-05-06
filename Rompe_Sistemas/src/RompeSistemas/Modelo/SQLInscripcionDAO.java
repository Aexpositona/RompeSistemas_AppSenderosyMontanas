package RompeSistemas.Modelo;

import java.util.List;

public class SQLInscripcionDAO implements InscripcionDAO {
    @Override
    public List<Inscripcion> getAllInscripciones() {
        return List.of();
    }

    @Override
    public void insertarInscripcion(Inscripcion inscripcion) {

    }

    @Override
    public void modificarInscripcion(Inscripcion inscripcion) {

    }

    @Override
    public void eliminarInscripcion(Inscripcion inscripcion) {

    }

    @Override
    public Inscripcion buscarInscripcion(int id) {
        return null;
    }

    @Override
    public Inscripcion[] listarInscripciones() {
        return new Inscripcion[0];
    }
}
