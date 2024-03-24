package RompeSistemas.Controlador;
import RompeSistemas.Modelo.*;
import RompeSistemas.Vista.*;

import java.text.ParseException;

/**
 * Clase principal de la aplicación Senderos de Montañas.
 */
public class APPSenderosMontanas {

    // Atributos
    /**
     * Controladores y vistas de la aplicación.
     */
    public ControlMenuPrincipal cMenuPrincipal;
    /**
     * Controlador de inscripciones.
     */
    public ControlInscripciones cInscripciones;
    public ControlSocios cSocios;
    public ControlExcursiones cExcursiones;
    public ControlDatos cDatos;
    public VistaMenuPrincipal vMenuPrincipal;
    public VistaInscripciones vInscripciones;
    public VistaSocios vSocios;
    public VistaExcursiones vExcursiones;
    public Datos datos;



    // Métodos

    /**
     * Inicializa la aplicación.
     *
     * @param datos Recibe los datos de la aplicación.
     * Inicializa los controladores y las vistas de la aplicación.
     */
    public void iniciar(Datos datos) {
        // Inicializar controladores y vistas aquí
        cMenuPrincipal = new ControlMenuPrincipal(this, vMenuPrincipal);
        cInscripciones = new ControlInscripciones(this, datos, vInscripciones);
        cSocios = new ControlSocios(this, datos, vSocios);
        cExcursiones = new ControlExcursiones(this, datos, vExcursiones);
        vMenuPrincipal = new VistaMenuPrincipal(cMenuPrincipal, vSocios, vExcursiones, vInscripciones);
        vInscripciones = new VistaInscripciones(cInscripciones);
        vSocios = new VistaSocios(cSocios);
        vExcursiones = new VistaExcursiones(cExcursiones, cDatos);

    }

    /**
     * Método principal de la aplicación.
     * @param args Argumentos de la línea de comandos
     * @throws ParseException excepción de parseo
     * Llama al método show de la vista del menú principal.
     */

    // Clase principal
    public static void main(String[] args) throws ParseException {
        System.out.println("Senderos de Montañas");
        APPSenderosMontanas app = new APPSenderosMontanas();
        Datos datos = new Datos();
        app.iniciar(datos);
        app.showVistaMenuPrincipal();
    }

    /**
     * Muestra la vista del menú principal.
     * @throws ParseException excepción de parseo
     */
    public void showVistaMenuPrincipal() throws ParseException {
        vMenuPrincipal.show();

    }
}