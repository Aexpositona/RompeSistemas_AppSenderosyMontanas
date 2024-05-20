package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Vista.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

public class APPSenderosMontanas {

    // Atributos
    private ControlMenuPrincipal cMenuPrincipal;
    private ControlInscripciones cInscripciones;
    private ControlSocios cSocios;
    private ControlExcursiones cExcursiones;
    private ControlDatos cDatos;
    private ControlPeticiones cPeticiones;
    private Datos datos;
    private VistaMenuPrincipal vMenuPrincipal;
    private Connection conn;

    // Métodos

    public static void main(String[] args) throws ParseException, SQLException {
        APPSenderosMontanas app = new APPSenderosMontanas();
        Datos datos = new Datos(DriverManager.getConnection("jdbc:mysql://localhost:3306/APPSenderosMontanas", "root", "admin"));
        app.iniciar(datos);
        app.showVistaMenuPrincipal();
    }

    public void iniciar(Datos datos) throws SQLException {
        this.datos = datos;
        this.cDatos = new ControlDatos(datos);
        this.cPeticiones = new ControlPeticiones();
        this.cInscripciones = new ControlInscripciones(this);
        this.cSocios = new ControlSocios(this, datos.getConnection());
        this.cExcursiones = new ControlExcursiones(this);
        this.cMenuPrincipal = new ControlMenuPrincipal(this);
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/APPSenderosMontanas", "root", "admin");

        cDatos = new ControlDatos(this);
        cPeticiones = new ControlPeticiones();
        cInscripciones = new ControlInscripciones(this);
        cSocios = new ControlSocios(this, conn);
        cExcursiones = new ControlExcursiones(this);
        cMenuPrincipal = new ControlMenuPrincipal(this);

        cMenuPrincipal.setControlExcursiones(cExcursiones);
        cMenuPrincipal.setControlInscripciones(cInscripciones);
        cMenuPrincipal.setControlSocios(cSocios);
        cMenuPrincipal.setVistaMenuPrincipal(new VistaMenuPrincipal());
        cMenuPrincipal.getVistaMenuPrincipal().setControlMenuPrincipal(cMenuPrincipal);
        cMenuPrincipal.getVistaMenuPrincipal().setControlPeticiones(cPeticiones);

        cInscripciones.getVistaInscripciones().setControlInscripciones(cInscripciones);
        cInscripciones.getVistaInscripciones().setControlPeticiones(cPeticiones);
        cInscripciones.getVistaListarInscripciones().setControlInscripciones(cInscripciones);
        cInscripciones.getVistaListarInscripciones().setControlPeticiones(cPeticiones);
        cInscripciones.getVistaInscripciones().setVistaListarInscripciones(new VistaListarInscripciones(cInscripciones));
        cInscripciones.getVistaAddInscripcion().setControlInscripciones(cInscripciones);
        cInscripciones.getVistaAddInscripcion().setControlPeticiones(cPeticiones);
        cInscripciones.getVistaInscripciones().setVistaAddInscripcion(new VistaAddInscripcion(cInscripciones));

        cSocios.getVistaSocios().setControlSocios(cSocios);
        cSocios.getVistaSocios().setControlPeticiones(cPeticiones);
        cSocios.getVistaListarSocios().setControlSocios(cSocios);
        cSocios.getVistaListarSocios().setControlPeticiones(cPeticiones);
        cSocios.getVistaSocios().setVistaListarSocios(new VistaListarSocios(cSocios));
        cSocios.getVistaAddSocio().setControlSocios(cSocios);
        cSocios.getVistaAddSocio().setControlPeticiones(cPeticiones);
        cSocios.getVistaSocios().setVistaAddSocio(new VistaAddSocio(cSocios));
        cSocios.getVistaModificarSeguro().setControlSocios(cSocios);
        cSocios.getVistaModificarSeguro().setControlPeticiones(cPeticiones);
        cSocios.getVistaSocios().setVistaModificarSeguro(new VistaModificarSeguro(cSocios));

        cExcursiones.getVistaExcursiones().setControlExcursiones(cExcursiones);
        cExcursiones.getVistaExcursiones().setControlPeticiones(cPeticiones);
        cExcursiones.getVistaExcursiones().setControlDatos(cDatos);
        cExcursiones.getVistaListarExcursiones().setControlExcursiones(cExcursiones);
        cExcursiones.getVistaListarExcursiones().setControlPeticiones(cPeticiones);
        cExcursiones.getVistaExcursiones().setVistaListarExcursiones(new VistaListarExcursiones(cExcursiones));
        cExcursiones.getVistaAddExcursion().setControlExcursiones(cExcursiones);
        cExcursiones.getVistaAddExcursion().setControlPeticiones(cPeticiones);
        cExcursiones.getVistaAddExcursion().setControlDatos(cDatos);
        cExcursiones.getVistaExcursiones().setVistaAddExcursion(new VistaAddExcursion(cExcursiones));

        vMenuPrincipal = cMenuPrincipal.getVistaMenuPrincipal();
    }

    private void showVistaMenuPrincipal() throws ParseException, SQLException {
        cMenuPrincipal.show();
    }

    public ControlMenuPrincipal getControlMenuPrincipal() {
        return cMenuPrincipal;
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

    public ControlDatos getControlDatos() {
        return cDatos;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    public Datos getDatos() {
        return datos;
    }

    public VistaMenuPrincipal getVistaMenuPrincipal() {
        return vMenuPrincipal;
    }

    public void setControlMenuPrincipal(ControlMenuPrincipal cMenuPrincipal) {
        this.cMenuPrincipal = cMenuPrincipal;
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

    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }
}
