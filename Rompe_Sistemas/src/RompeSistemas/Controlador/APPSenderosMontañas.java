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


    // Métodos

    /**
     * Inicia la aplicación.
     */
    public void iniciar() {
        // Inicializar controladores y vistas aquí
    }



    // Clase principal
    public static void main(String[] args) {
        System.out.println("Senderos de Montañas");
        APPSenderosMontañas app = new APPSenderosMontañas();
        app.iniciar();
        app.showVistaMenuPrincipal();
    }

    public void showVistaMenuPrincipal() {
        vMenuPrincipal.show();
    }
}