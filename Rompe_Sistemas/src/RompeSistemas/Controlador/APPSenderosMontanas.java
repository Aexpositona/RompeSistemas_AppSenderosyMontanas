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
        this.cPeticiones = new ControlPeticiones();
        this.cDatos = new ControlDatos(datos, cPeticiones);


        // Inicializamos los controladores con sus vistas correspondientes
        this.cInscripciones = new ControlInscripciones(this,cDatos, cPeticiones);
        this.cSocios = new ControlSocios(this, cDatos, cPeticiones);
        this.cExcursiones = new ControlExcursiones(this, cDatos, cPeticiones);
        this.cMenuPrincipal = new ControlMenuPrincipal(this, cDatos, cPeticiones);

        // Inicializamos y configuramos las vistas para ControlMenuPrincipal
        vMenuPrincipal = new VistaMenuPrincipal(cMenuPrincipal);
        cMenuPrincipal.setVistaMenuPrincipal(vMenuPrincipal);

        // Configuramos ControlInscripciones con sus vistas
        VistaInscripciones vInscripciones = new VistaInscripciones(cInscripciones);
        VistaListarInscripciones vListarInscripciones = new VistaListarInscripciones(cInscripciones);
        VistaAddInscripcion vAddInscripcion = new VistaAddInscripcion(cInscripciones);

        cInscripciones.setVistaInscripciones(vInscripciones);
        cInscripciones.setVistaListarInscripciones(vListarInscripciones);
        cInscripciones.setVistaAddInscripcion(vAddInscripcion);

        // Configuramos ControlSocios con sus vistas
        VistaSocios vSocios = new VistaSocios(cSocios);
        VistaListarSocios vListarSocios = new VistaListarSocios(cSocios);
        VistaAddSocio vAddSocio = new VistaAddSocio(cSocios);
        VistaModificarSeguro vModificarSeguro = new VistaModificarSeguro(cSocios);

        cSocios.setVistaSocios(vSocios);
        cSocios.setVistaListarSocios(vListarSocios);
        cSocios.setVistaAddSocio(vAddSocio);
        cSocios.setVistaModificarSeguro(vModificarSeguro);

        // Configuramos ControlExcursiones con sus vistas
        VistaExcursiones vExcursiones = new VistaExcursiones(cExcursiones);
        VistaListarExcursiones vListarExcursiones = new VistaListarExcursiones(cExcursiones);
        VistaAddExcursion vAddExcursion = new VistaAddExcursion(cExcursiones);

        cExcursiones.setVistaExcursiones(vExcursiones);
        cExcursiones.setVistaListarExcursiones(vListarExcursiones);
        cExcursiones.setVistaAddExcursion(vAddExcursion);
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
