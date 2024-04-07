package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlMenuPrincipal;
import RompeSistemas.Controlador.ControlPeticiones;
import java.text.ParseException;

/**
 * Clase que representa la vista del menú principal.
 */
public class VistaMenuPrincipal {

    // Atributos
    private ControlPeticiones cPeticiones;
    private ControlMenuPrincipal cMenuPrincipal;

    /**
     * Constructor de la clase VistaMenuPrincipal.
     *
     * @param cMenuPrincipal ControlMenuPrincipal
     */
    public VistaMenuPrincipal(ControlMenuPrincipal cMenuPrincipal) {
        this.cMenuPrincipal = new ControlMenuPrincipal(cMenuPrincipal);
        this.cPeticiones = new ControlPeticiones(cMenuPrincipal.getControlPeticiones());
    }

    public VistaMenuPrincipal(VistaMenuPrincipal vistaMenuPrincipal) {
        this.cMenuPrincipal = new ControlMenuPrincipal(vistaMenuPrincipal.getControlMenuPrincipal());
        this.cPeticiones = new ControlPeticiones(vistaMenuPrincipal.getControlPeticiones());
    }

    public VistaMenuPrincipal() {
        this.cMenuPrincipal = null;
        this.cPeticiones = null;
    }

    // Getters

    public ControlMenuPrincipal getControlMenuPrincipal() {
        return cMenuPrincipal;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    // Setters

    public void setControlMenuPrincipal(ControlMenuPrincipal cMenuPrincipal) {
        this.cMenuPrincipal = cMenuPrincipal;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }
    
    /**
     * Método para añadir un botón que nos permite ir a la vista de inscripciones.
     */
    public void buttonVistaInscripciones(){
        txtMostrarMensaje("Navegando a la vista de inscripciones...\n");
        cMenuPrincipal.showInscripciones();
    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de socios.
     */
    public void buttonVistaSocios() throws ParseException {
        txtMostrarMensaje("Navegando a la vista de socios...\n\n");
        cMenuPrincipal.showVistaSocios();
    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de excursiones.
     */
    public void buttonVistaExcursiones() throws ParseException {
        txtMostrarMensaje("Navegando a la vista de excursiones...\n\n");
        cMenuPrincipal.showVistaExcursiones();
    }

    /**
     * Método para añadir un botón que nos permite salir de la aplicación.
     */
    public void buttonVistaSalir(){
        txtMostrarMensaje("Saliendo de la aplicación...\n\n");
    }

    /**
     * Método para mostrar un mensaje.
     *
     * @param mensaje Mensaje a mostrar.
     */
    public void txtMostrarMensaje(String mensaje) {
        System.out.print(mensaje);
    }

    /**
     * Método para mostrar la vista.
     */
    public void show() throws ParseException {
        boolean running = true;
        while (running) {
            txtMostrarMensaje("************ Menú Principal ************\n");
            txtMostrarMensaje("1. Inscripciones\n");
            txtMostrarMensaje("2. Socios\n");
            txtMostrarMensaje("3. Excursiones\n");
            txtMostrarMensaje("0. Salir\n");

            switch (cPeticiones.pedirEntero("Seleccione una opción: (1, 2, 3 o 0)", 0, 3)) {
                case 1:
                    buttonVistaInscripciones();
                    break;
                case 2:
                    buttonVistaSocios();
                    break;
                case 3:
                    buttonVistaExcursiones();
                    break;
                case 0:
                    buttonVistaSalir();
                    running = false;
                    break;
                default:
                    txtMostrarMensaje("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
