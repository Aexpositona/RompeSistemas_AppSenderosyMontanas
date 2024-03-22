package RompeSistemas.Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona los datos del sistema.
 * @param <E> tipo genérico para las excursiones
 * @param <I> tipo genérico para las inscripciones
 * @param <S> tipo genérico para los socios
 */
public class Datos<E, I, S> {

    private List<E> excursiones = new ArrayList<>();
    private List<I> inscripciones = new ArrayList<>();
    private List<S> socios = new ArrayList<>();

    /**
     * Obtiene la lista de excursiones.
     * @return la lista de excursiones
     */
    public List<E> getExcursiones() {
        return excursiones;
    }

    /**
     * Agrega una excursión a la lista.
     * @param excursion la excursión a agregar
     */
    public  void agregarExcursion(E excursion) {

        excursiones.add(excursion);
    }

    /**
     * Obtiene la lista de inscripciones.
     * @return la lista de inscripciones
     */
    public  List<I> getInscripciones() {

        return inscripciones;
    }

    /**
     * Agrega una inscripción a la lista.
     * @param inscripcion la inscripción a agregar
     */
    public  void agregarInscripcion(I inscripcion) {

        inscripciones.add(inscripcion);
    }

    /**
     * Obtiene la lista de socios.
     * @return la lista de socios
     */
    public  List<S> getSocios() {

        return socios;
    }

    /**
     * Agrega un socio a la lista.
     * @param socio el socio a agregar
     */
    public  void agregarSocio(S socio) {

        socios.add(socio);
    }
}
