package RompeSistemas.Modelo;

import java.util.List;

public interface InscripcionDAO {

        List<Inscripcion> getAllInscripciones();
        public void insertarInscripcion(Inscripcion inscripcion);
        public void modificarInscripcion(Inscripcion inscripcion);
        public void eliminarInscripcion(Inscripcion inscripcion);
        public Inscripcion buscarInscripcion(int id);
        public Inscripcion[] listarInscripciones();
}
