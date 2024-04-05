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
        this.cMenuPrincipal = cMenuPrincipal;
        this.cPeticiones = cMenuPrincipal.getControlPeticiones();
    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de inscripciones.
     */
    public void buttonVistaInscripciones(){
        System.out.println("Navegando a la vista de inscripciones...");
        cMenuPrincipal.showInscripciones();
    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de socios.
     */
    public void buttonVistaSocios() throws ParseException {
        System.out.println("Navegando a la vista de socios...");
        cMenuPrincipal.showVistaSocios();
    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de excursiones.
     */
    public void buttonVistaExcursiones() throws ParseException {
        System.out.println("Navegando a la vista de excursiones...");
        cMenuPrincipal.showVistaExcursiones();
    }

    /**
     * Método para añadir un botón que nos permite salir de la aplicación.
     */
    public static void buttonVistaSalir(){
        System.out.println("Saliendo de la aplicación...");
        return;
    }

    /**
     * Método para mostrar la vista.
     */
    public void show() throws ParseException {
        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Inscripciones");
            System.out.println("2. Socios");
            System.out.println("3. Excursiones");
            System.out.println("0. Salir");

            switch (cPeticiones.pedirEntero("Seleccione una opción: ", 0, 3)) {
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
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
