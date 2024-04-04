package RompeSistemas.Controlador;

import RompeSistemas.Vista.VistaMenuPrincipal;
import RompeSistemas.Vista.VistaSocios;
import RompeSistemas.Vista.VistaExcursiones;
import java.text.ParseException;
import RompeSistemas.Vista.VistaInscripciones;

/**
 * Controlador para la gestión del menú principal de la aplicación.
 *
 */
public class ControlMenuPrincipal {

    // Atributos
    private APPSenderosMontanas app;
    private VistaMenuPrincipal vMenuPrincipal;
    private VistaInscripciones vInscripciones; 
    private VistaSocios vSocios;
    private VistaExcursiones vExcursiones;

    /**
     * Constructor de ControlMenuPrincipal.
     *
     * @param appSenderosMontanas
     */
    public ControlMenuPrincipal(APPSenderosMontanas app) {
        this.app = app;
        this.vMenuPrincipal = new VistaMenuPrincipal(this);
        this.vInscripciones = app.cInscripciones.getVistaInscripciones();
        this.vSocios = app.cSocios.getVistaSocios();
        this.vExcursiones = app.cExcursiones.getVistaExcursiones();
    }

    // Getters

    public VistaMenuPrincipal getVistaMenuPrincipal(){
        return vMenuPrincipal;
    }

    public VistaInscripciones getVistaInscripciones() {
        return vInscripciones;
    }

    public VistaSocios getVistaSocios() {
        return vSocios;
    }

    public VistaExcursiones getVistaExcursiones() {
        return vExcursiones;
    }

    

    // Métodos
    /**
     * Maneja el evento del botón para mostrar la vista de inscripciones.
     */
    public void buttonVistaInscripciones() {
        vInscripciones.show();
    }

    /**
     * Maneja el evento del botón para mostrar la vista de socios.
     */
    public void buttonVistaSocios() throws ParseException {
        vSocios.show();
    }

    /**
     * Maneja el evento del botón para mostrar la vista de excursiones.
     */
    public void buttonVistaExcursiones() throws ParseException {
        vExcursiones.show();
    }

    public void show() throws ParseException {
        vMenuPrincipal.show();
    }
}
