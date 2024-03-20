package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Excursion;
import RompeSistemas.Modelo.Inscripcion;
import RompeSistemas.Modelo.Socio;
import RompeSistemas.Vista.VistaInscripciones;

/**
 * Controlador para la gestión de inscripciones a excursiones.
 *
 * @param <E> tipo genérico para Excursion
 * @param <I> tipo genérico para Inscripcion
 * @param <S> tipo genérico para Socio
 * @param <V> tipo genérico para VistaInscripciones
 */
public class ControlInscripciones<E extends Excursion, I extends Inscripcion, S extends Socio, V extends VistaInscripciones> {

    // Atributos
    private V vistaInscripciones;
    private Datos datos; // Agrega un campo de instancia para Datos

    /**
     * Constructor de ControlInscripciones.
     *
     * @param vistaInscripciones VistaInscripciones asociada al controlador
     */
    public ControlInscripciones(V vistaInscripciones) {
        this.vistaInscripciones = vistaInscripciones;
        this.datos = new Datos(); // Inicializa el campo de Datos
    }

    // Métodos

    /**
     * Agrega una inscripción utilizando la clase Datos.
     *
     * @param inscripcion Inscripción a agregar
     * @param socio       Socio que realiza la inscripción
     * @param excursion   Excursión a la que se inscribe el socio
     */
    public void addInscripcion(I inscripcion, S socio, E excursion) {
        datos.agregarInscripcion(inscripcion);
    }

    /**
     * Elimina una inscripción utilizando la clase Datos.
     *
     * @param inscripcion Número de inscripción a eliminar
     */
    public void removeInscripcion(I inscripcion) {
        // Lógica para eliminar inscripción
    }

    /**
     * Lista las inscripciones de un socio utilizando la clase Datos.
     *
     * @param numeroSocio Número de socio del que listar las inscripciones
     */
    public void listInscripcionesSocio(int numeroSocio) {
        // Lógica para listar inscripciones de un socio
    }

    /**
     * Muestra la vista para añadir una inscripción.
     */
    public void showVistaAñadirInscripcion() {
        vistaInscripciones.vVistaAñadirInscripcion.show();
    }

    /**
     * Muestra la vista para listar las inscripciones.
     */
    public void showVistaListarInscripciones() {
        vistaInscripciones.vVistaListarInscripciones.show();
    }

    /**
     * Muestra la vista del menú principal.
     */
    public void showVistaMenuPrincipal() {
        // Lógica para mostrar vista de menú principal
    }

    /**
     * Muestra la vista de inscripciones.
     */
    public void showVistaInscripciones() {
        vistaInscripciones.show();
    }

    /**
     * Maneja el evento del botón "Atrás".
     */
    public void buttonAtras() {
        // Lógica para manejar el botón "Atrás"
    }
}
