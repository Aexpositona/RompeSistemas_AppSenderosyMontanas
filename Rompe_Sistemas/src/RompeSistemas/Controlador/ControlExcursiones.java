package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Excursion;
import RompeSistemas.Vista.VistaExcursiones;

/**
 * Controlador para la gestión de excursiones.
 *
 * @param <E> tipo genérico para Excursion
 * @param <V> tipo genérico para VistaExcursiones
 */
public class ControlExcursiones<E extends Excursion, V extends VistaExcursiones> {

    // Atributos
    private V vExcursiones;

    /**
     * Constructor de ControlExcursiones.
     *
     * @param vExcursiones VistaExcursiones asociada al controlador
     */
    public ControlExcursiones(V vExcursiones) {
        this.vExcursiones = vExcursiones;
    }

    // Métodos

    /**
     * Añade una excursión utilizando la clase Datos.
     *
     * @param excursion Excursión a añadir
     */
    public void añadirExcursion(E excursion) {
        Datos.agregarExcursion(excursion);
    }
}
