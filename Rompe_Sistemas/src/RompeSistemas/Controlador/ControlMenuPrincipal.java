package RompeSistemas.Controlador;

import RompeSistemas.Vista.VistaMenuPrincipal;

/**
 * Controlador para la gestión del menú principal de la aplicación.
 *
 */
public class ControlMenuPrincipal {

    // Atributos
    private APPSenderosMontanas app;
    private VistaMenuPrincipal vMenuPrincipal;
    /**
     * Constructor de ControlMenuPrincipal.
     *
     * @param vMenuPrincipal instancia de VistaMenuPrincipal asociada al controlador
     */
    public ControlMenuPrincipal(APPSenderosMontanas app, VistaMenuPrincipal vMenuPrincipal) {
        this.vMenuPrincipal = vMenuPrincipal;
        this.app = app;
    }

    // Métodos
    /**
     * Maneja el evento del botón para mostrar la vista de inscripciones.
     */
    public void buttonVistaInscripciones() {
        // Lógica para mostrar la vista de inscripciones
    }

    /**
     * Maneja el evento del botón para mostrar la vista de socios.
     */
    public void buttonVistaSocios() {
        // Lógica para mostrar la vista de socios
    }

    /**
     * Maneja el evento del botón para mostrar la vista de excursiones.
     */
    public void buttonVistaExcursiones() {
        // Lógica para mostrar la vista de excursiones
    }
}
