package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlMenuPrincipal;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Clase que representa la vista del menú principal.
 */
public class VistaMenuPrincipal {

    private ControlMenuPrincipal cMenuPrincipal;
    private Scanner scanner = new Scanner(System.in);
    private VistaSocios vSocios;
    private VistaExcursiones vExcursiones;
    private VistaInscripciones vInscripciones;

    public VistaMenuPrincipal(ControlMenuPrincipal cMenuPrincipal, VistaSocios vSocios, VistaExcursiones vExcursiones, VistaInscripciones vInscripciones) {
        this.cMenuPrincipal = cMenuPrincipal;
        this.vSocios = vSocios;
        this.vExcursiones = vExcursiones;
        this.vInscripciones = vInscripciones;
    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de inscripciones.
     */
    public void buttonVistaInscripciones(){
        System.out.println("Navegando a la vista de inscripciones...");
        vInscripciones.show();
    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de socios.
     */
    public void buttonVistaSocios(){
        System.out.println("Navegando a la vista de socios...");
        vSocios.show();
    }

    /**
     * Método para añadir un botón que nos permite ir a la vista de excursiones.
     */
    public void buttonVistaExcursiones() throws ParseException {
        System.out.println("Navegando a la vista de excursiones...");
        vExcursiones.show();
    }

    /**
     * Método para añadir un botón que nos permite salir de la aplicación.
     */
    public static void buttonVistaSalir(){
        System.out.println("Saliendo de la aplicación...");
        System.exit(0);
    }

    /**
     * Método para mostrar la vista.
     */
    public void show() throws ParseException {
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
