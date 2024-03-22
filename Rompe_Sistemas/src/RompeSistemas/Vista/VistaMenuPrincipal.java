package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlMenuPrincipal;

import java.util.Scanner;

/**
 * Clase que representa la vista del menú principal.
 */
public class VistaMenuPrincipal {

    private ControlMenuPrincipal cMenuPrincipal;
    private Scanner scanner = new Scanner(System.in);
    private VistaSocios vistaSocios;
    private VistaExcursiones vistaExcursiones;
   // private VistaInscripciones vistaInscripciones;

    VistaInscripciones vistaInscripciones = new VistaInscripciones();


    /**
     * Método constructor de la clase VistaMenuPrincipal que recibe por parámetros el controlador del menú principal.
     * @param cMenuPrincipal es el controlador del menú principal.
     * @param vistaSocios es la vista de socios.
     * @param vistaExcursiones es la vista de excursiones.
     * @param vistaInscripciones es la vista de inscripciones.
     */
    public VistaMenuPrincipal(ControlMenuPrincipal cMenuPrincipal, VistaSocios vistaSocios, VistaExcursiones vistaExcursiones, VistaInscripciones vistaInscripciones) {
        this.cMenuPrincipal = cMenuPrincipal;
        this.vistaSocios = vistaSocios;
        this.vistaExcursiones = vistaExcursiones;
        this.vistaInscripciones = vistaInscripciones;
    }

    public VistaMenuPrincipal() {
    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de inscripciones.
     */
    public void buttonVistaInscripciones(){
        System.out.println("Navegando a la vista de inscripciones");
        vistaInscripciones.show();
    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de socios.
     */
    public void buttonVistaSocios(){
        System.out.println("Navegando a la vista de socios");
        vistaSocios.show();
    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de excursiones.
     */
    public void buttonVistaExcursiones(){
        System.out.println("Navegando a la vista de excursiones");
        vistaExcursiones.show();
    }

    /**
     * Método para añadir un botón que nos permite salir de la aplicación.
     */
    public void buttonVistaSalir(){
        System.out.println("Saliendo de la aplicación...");
        System.exit(0);
    }

    /**
     * Método para mostrar la vista.
     */
    public void show() {
        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción: ");
            System.out.println("0. Salir");
            System.out.println("1. Inscripciones");
            System.out.println("2. Socios");
            System.out.println("3. Excursiones");

            switch (scanner.nextLine()) {
                case "1":
                    buttonVistaInscripciones();
                    break;
                case "2":
                    buttonVistaSocios();
                    break;
                case "3":
                    buttonVistaExcursiones();
                    break;
                case "0":
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
