package RompeSistemas.Controlador;

import RompeSistemas.Vista.VistaMenuPrincipal;
import java.text.ParseException;

/**
 * Controlador para la gestión del menú principal de la aplicación.
 *
 */
public class ControlMenuPrincipal {

    // Atributos
    private VistaMenuPrincipal vMenuPrincipal;
    private ControlInscripciones cInscripciones;
    private ControlSocios cSocios;
    private ControlExcursiones cExcursiones;
    private ControlPeticiones cPeticiones;

    /**
     * Constructor de ControlMenuPrincipal.
     *
     * @param appSenderosMontanas
     */
    public ControlMenuPrincipal(APPSenderosMontanas app) {
        this.cPeticiones = app.getControlPeticiones();
        this.vMenuPrincipal = new VistaMenuPrincipal(this);
        this.cInscripciones = app.getControlInscripciones();
        this.cSocios = app.getControlSocios();
        this.cExcursiones = app.getControlExcursiones();
    }

    /**
     * Constructor de ControlMenuPrincipal de copia.
     *
     * @param cMenuPrincipal ControlMenuPrincipal a copiar
     */
    public ControlMenuPrincipal (ControlMenuPrincipal cMenuPrincipal) {
        this.vMenuPrincipal = cMenuPrincipal.getVistaMenuPrincipal();
        this.cInscripciones = new ControlInscripciones(cMenuPrincipal.getControlInscripciones());
        this.cSocios = new ControlSocios(cMenuPrincipal.getControlSocios());
        this.cExcursiones = new ControlExcursiones (cMenuPrincipal.getCOntrolExcursiones());
        this.cPeticiones = new ControlPeticiones (cMenuPrincipal.getControlPeticiones());
    }

    // Getters

    public VistaMenuPrincipal getVistaMenuPrincipal(){
        return vMenuPrincipal;
    }

    public ControlInscripciones getControlInscripciones() {
        return cInscripciones;
    }

    public ControlSocios getControlSocios() {
        return cSocios;
    }

    public ControlExcursiones getCOntrolExcursiones() {
        return cExcursiones;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    // Setters

    public void setVistaMenuPrincipal(VistaMenuPrincipal vMenuPrincipal) {
        this.vMenuPrincipal = vMenuPrincipal;
    }

    public void setControlInscripciones(ControlInscripciones cInscripciones) {
        this.cInscripciones = cInscripciones;
    }

    public void setVistaSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
    }

    public void setControlExcursiones(ControlExcursiones cExcursiones) {
        this.cExcursiones = cExcursiones;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    } 

    // Métodos

    public void showInscripciones() {
        cInscripciones.show();
    }

    public void showVistaSocios() throws ParseException {
        cSocios.show();
    }

    public void showVistaExcursiones() throws ParseException {
        cExcursiones.show();
    }

    public void show() throws ParseException {
        vMenuPrincipal.show();
    }
}
