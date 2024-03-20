package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlMenuPrincipal;

/**
 * Clase que representa la vista del menú principal.
 * @param <C> Tipo de dato que representa el controlador del menú principal.
 */
public class VistaMenuPrincipal<C> {

    private C cMenuPrincipal;

    /**
     * Método constructor de la clase VistaMenuPrincipal que recibe por parámetros el controlador del menú principal.
     * @param cMenuPrincipal es el controlador del menú principal.
     */
    public VistaMenuPrincipal(C cMenuPrincipal) {
        this.cMenuPrincipal = cMenuPrincipal;
    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de inscripciones.
     */
    public void buttonVistaInscripciones(){

    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de socios.
     */
    public void buttonVistaSocios(){

    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de excursiones.
     */
    public void buttonVistaExcursiónes(){

    }

    /**
     * Método para añadir un botón que nos permite salir de la aplicación.
     */
    public void buttonVistaSalir(){

    }

    /**
     * Método para mostrar la vista.
     */
    public void show() {
        //TODO
    }
}
