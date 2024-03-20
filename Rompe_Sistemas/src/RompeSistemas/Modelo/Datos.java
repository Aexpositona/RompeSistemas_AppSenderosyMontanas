package RompeSistemas.Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona los datos del sistema.
 * @param <T> tipo genérico para los datos almacenados
 */
public class Datos<T> {

    private static List<Excursion> excursiones = new ArrayList<>();
    private static List<Inscripcion> inscripciones = new ArrayList<>();
    private static List<Socio> socios = new ArrayList<>();

    /**
     * Obtiene la lista de excursiones.
     * @return la lista de excursiones
     */
    public static List<Excursion> getExcursiones() {
        return excursiones;
    }

    /**
     * Agrega una excursión a la lista.
     * @param excursion la excursión a agregar
     */
    public static void agregarExcursion(Excursion excursion) {
        excursiones.add(excursion);
    }

    /**
     * Obtiene la lista de inscripciones.
     * @return la lista de inscripciones
     */
    public static List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    /**
     * Agrega una inscripción a la lista.
     * @param inscripcion la inscripción a agregar
     */
    public static void agregarInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    /**
     * Obtiene la lista de socios.
     * @return la lista de socios
     */
    public static List<Socio> getSocios() {
        return socios;
    }

    /**
     * Agrega un socio a la lista.
     * @param socio el socio a agregar
     */
    public static void agregarSocio(Socio socio) {
        socios.add(socio);
    }
}
