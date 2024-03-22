package RompeSistemas.Controlador;

import RompeSistemas.Vista.*;

/**
 * Clase principal de la aplicación Senderos de Montañas.
 */
public class APPSenderosMontañas {

    // Atributos
    public ControlMenuPrincipal cMenuPrincipal;
    public ControlInscripciones cInscripciones;
    public ControlSocios cSocios;
    public ControlExcursiones cExcursiones;
    public VistaMenuPrincipal vMenuPrincipal;
    public VistaInscripciones vInscripciones;
    public VistaSocios vSocios;
    public VistaExcursiones vExcursiones;

    // Constructor
    public APPSenderosMontañas() {
        // Inicializar controladores y vistas aquí
    }

    // Métodos

    /**
     * Inicia la aplicación.
     */
    public void iniciar() {
        // Lógica de inicio
    }

    /**
     * Muestra la vista de inscripciones.
     */
    public void showVistaInscripciones() {
        // Mostrar vista de inscripciones
    }

    /**
     * Muestra la vista de socios.
     */
    public void showVistaSocios() {
        // Mostrar vista de socios
    }

    /**
     * Muestra la vista de excursiones.
     */
    public void showVistaExcursiones() {
        // Mostrar vista de excursiones
    }

    /**
     * Muestra la vista del menú principal.
     */
    public void showVistaMenuPrincipal() {
        // Mostrar vista de menú principal
    }

    // Clase principal
    public static void main(String[] args) {
        System.out.println("Senderos de Montañas");
        APPSenderosMontañas app = new APPSenderosMontañas();
        app.iniciar();
        app.showVistaMenuPrincipal();
    }
}