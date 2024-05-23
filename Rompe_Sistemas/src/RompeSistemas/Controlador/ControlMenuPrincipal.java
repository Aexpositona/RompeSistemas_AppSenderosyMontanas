package RompeSistemas.Controlador;

import RompeSistemas.Vista.VistaMenuPrincipal;

import java.sql.SQLException;
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
     * @param app APPSenderosMontanas
     */
    public ControlMenuPrincipal(APPSenderosMontanas app, ControlDatos cDatos, ControlPeticiones cPeticiones) throws SQLException {
        this.vMenuPrincipal = new VistaMenuPrincipal(this);
        this.cInscripciones = new ControlInscripciones(app, cDatos, cPeticiones);
        this.cSocios = new ControlSocios(app, cDatos, cPeticiones);
        this.cExcursiones = new ControlExcursiones(app, cDatos, cPeticiones);
        this.cPeticiones = cPeticiones;

    }

    /**
     * Constructor de ControlMenuPrincipal de copia.
     *
     * @param cMenuPrincipal ControlMenuPrincipal a copiar
     */
    public ControlMenuPrincipal(ControlMenuPrincipal cMenuPrincipal) throws SQLException {
        this.vMenuPrincipal = new VistaMenuPrincipal(cMenuPrincipal.getVistaMenuPrincipal().getControlMenuPrincipal());
        this.cInscripciones = new ControlInscripciones(cMenuPrincipal.getControlInscripciones().getApp(), cMenuPrincipal.getControlInscripciones().getControlDatos(), cMenuPrincipal.getControlInscripciones().getControlPeticiones());
        this.cSocios = new ControlSocios(cMenuPrincipal.getControlSocios().getApp(), cMenuPrincipal.getControlSocios().getControlDatos(), cMenuPrincipal.getControlSocios().getControlPeticiones());
        this.cExcursiones = new ControlExcursiones(cMenuPrincipal.getControlExcursiones().getApp(), cMenuPrincipal.getControlExcursiones().getControlDatos(), cMenuPrincipal.getControlExcursiones().getControlPeticiones());
        this.cPeticiones = new ControlPeticiones(cMenuPrincipal.getControlPeticiones());
    }

    /**
     * Constructor de ControlMenuPrincipal vacío.
     */
    public ControlMenuPrincipal() {
        this.vMenuPrincipal = null;
        this.cInscripciones = null;
        this.cSocios = null;
        this.cExcursiones = null;
        this.cPeticiones = null;
    }

    // Getters

    public VistaMenuPrincipal getVistaMenuPrincipal() {
        return vMenuPrincipal;
    }

    public ControlInscripciones getControlInscripciones() {
        return cInscripciones;
    }

    public ControlSocios getControlSocios() {
        return cSocios;
    }

    public ControlExcursiones getControlExcursiones() {
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

    public void setControlSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
    }

    public void setControlExcursiones(ControlExcursiones cExcursiones) {
        this.cExcursiones = cExcursiones;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    // Métodos

    public void showInscripciones() throws SQLException, ParseException {
        cInscripciones.show();
    }

    public void showVistaSocios() throws ParseException, SQLException {
        cSocios.show();
    }

    public void showVistaExcursiones() throws ParseException, SQLException {
        cExcursiones.show();
    }

    public void show() throws ParseException, SQLException {
        vMenuPrincipal.show();
    }
}
