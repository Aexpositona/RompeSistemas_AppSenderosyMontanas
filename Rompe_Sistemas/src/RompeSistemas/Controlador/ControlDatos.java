package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Excursion;
import RompeSistemas.Modelo.Inscripcion;
import RompeSistemas.Modelo.Socio;
import RompeSistemas.Vista.VistaExcursiones;

/**
 * Controlador para verificar datos relacionados con socios, excursiones e inscripciones.
 *
 * @param <E> tipo genérico para Excursion
 * @param <I> tipo genérico para Inscripcion
 * @param <S> tipo genérico para Socio
 * @param <V> tipo genérico para VistaExcursiones
 */
public class ControlDatos<E extends Excursion, I extends Inscripcion, S extends Socio, V extends VistaExcursiones> {

    // Constructor
    public ControlDatos() {
    }

    // Métodos

    /**
     * Comprueba la validez de un socio.
     *
     * @param socio Socio a comprobar
     */
    public void comprobarSocio(S socio) {
        // Lógica para comprobar un socio
        Datos.agregarSocio(socio); // Ejemplo de uso de Datos para agregar un socio
    }

    /**
     * Comprueba la validez de una excursión.
     *
     * @param excursion Excursión a comprobar
     */
    public void comprobarExcursion(E excursion) {
        // Lógica para comprobar una excursión
        Datos.agregarExcursion(excursion); // Ejemplo de uso de Datos para agregar una excursión
    }

    /**
     * Comprueba la validez de una inscripción.
     *
     * @param inscripcion Inscripción a comprobar
     */
    public void comprobarInscripcion(I inscripcion) {
        // Lógica para comprobar una inscripción
        Datos.agregarInscripcion(inscripcion); // Ejemplo de uso de Datos para agregar una inscripción
    }
}
