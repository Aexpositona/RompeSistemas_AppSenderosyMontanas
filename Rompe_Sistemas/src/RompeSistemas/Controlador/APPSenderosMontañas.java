package RompeSistemas.Controlador;

import RompeSistemas.Vista.*;

/**
 * Clase principal de la aplicación Senderos de Montañas.
 *
 * @param <C> tipo genérico para los controladores
 * @param <V> tipo genérico para las vistas
 */
public class APPSenderosMontañas<C, V> {

    // Clase principal
    public static void main(String[] args) {
        System.out.println("Senderos de Montañas");
        APPSenderosMontañas<ControlMenuPrincipal, VistaMenuPrincipal> app = new APPSenderosMontañas<>();
        app.iniciar();
        app.showVistaMenuPrincipal();
    }

    // Atributos
    public C cMenuPrincipal;
    public C cInscripciones;
    public C cSocios;
    public C cExcursiones;
    public V vMenuPrincipal;
    public V vInscripciones;
    public V vSocios;
    public V vExcursiones;

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
}

