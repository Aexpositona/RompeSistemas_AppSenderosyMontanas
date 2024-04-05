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
    /**
     * Controlador de socios.
     */
    public ControlSocios cSocios;
    /**
     * Controlador de excursiones.
     */
    public ControlExcursiones cExcursiones;
    /**
     * Controlador de datos.
     */
    public ControlDatos cDatos;
    /**
     * Controlador de peticiones.
     */
    public ControlPeticiones cPeticiones;
    /**
     * Controlador de peticiones.
     */
    public Datos datos;
    /**
     * Vista del menú principal.
     */
    public VistaMenuPrincipal vMenuPrincipal;
    public VistaInscripciones vInscripciones;
    public VistaListarInscripciones vListarInscripciones;
    public VistaAddInscripcion vAddInscripcion;
    public VistaSocios vSocios;
    public VistaListarSocios vListarSocios;
    public VistaAddSocio vAddSocio;
    public VistaModificarSeguro vModificarSeguro;
    public VistaExcursiones vExcursiones;
    public VistaListarExcursiones vListarExcursiones;
    public VistaAddExcursion vAddExcursion;

    // Métodos

    /**
     * Método principal de la aplicación.
     * @param args Argumentos de la línea de comandos
     * @throws ParseException excepción de parseo
     * Llama al método show de la vista del menú principal.
     */
    // Clase principal
    public static void main(String[] args) throws ParseException {
        // Inicializar la aplicación
        System.out.println("Senderos de Montañas");
        APPSenderosMontanas app = new APPSenderosMontanas();
        Datos datos = new Datos();
        DataLoader dataLoader = new DataLoader(datos);
        dataLoader.load(datos);
        app.iniciar(datos);
        app.showVistaMenuPrincipal();
    }

    /**
     * Inicializa la aplicación.
     *
     * @param datos Recibe los datos de la aplicación.
     * Inicializa los controladores y las vistas de la aplicación.
     */
    public void iniciar(Datos datos) {
        // Inicializar controladores
        cInscripciones = new ControlInscripciones(this);
        cSocios = new ControlSocios(this);
        cExcursiones = new ControlExcursiones(this);
        cDatos = new ControlDatos(this);
        cPeticiones = new ControlPeticiones();
        cMenuPrincipal = new ControlMenuPrincipal(this);
        this.datos = datos;

        // Inicializar vistas
        vMenuPrincipal = new VistaMenuPrincipal(cMenuPrincipal);
        vInscripciones = new VistaInscripciones(cInscripciones);
        vListarInscripciones = new VistaListarInscripciones(cInscripciones);
        vAddInscripcion = new VistaAddInscripcion(cInscripciones);
        vSocios = new VistaSocios(cSocios);
        vListarSocios = new VistaListarSocios(cSocios);
        vAddSocio = new VistaAddSocio(cSocios);
        vModificarSeguro = new VistaModificarSeguro(cSocios);
        vExcursiones = new VistaExcursiones(cExcursiones);
        vListarExcursiones = new VistaListarExcursiones(cExcursiones);
        vAddExcursion = new VistaAddExcursion(cExcursiones);
    }

    /**
     * Muestra la vista del menú principal.
     * @throws ParseException excepción de parseo
     */
    private void showVistaMenuPrincipal() throws ParseException{
        // Mostrar la vista del menú principal desde Control Menu Principal
        cMenuPrincipal.show();
    }

    // Getters

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

    public VistaInscripciones getVistaInscripciones() {
        return vInscripciones;
    }

    public VistaListarInscripciones getVistaListarInscripciones() {
        return vListarInscripciones;
    }

    public VistaAddInscripcion getVistaAddInscripcion() {
        return vAddInscripcion;
    }

    public VistaSocios getVistaSocios() {
        return vSocios;
    }

    public VistaListarSocios getVistaListarSocios() {
        return vListarSocios;
    }

    public VistaAddSocio getVistaAddSocio() {
        return vAddSocio;
    }

    public VistaModificarSeguro getVistaModificarSeguro() {
        return vModificarSeguro;
    }

    public VistaExcursiones getVistaExcursiones() {
        return vExcursiones;
    }

    public VistaListarExcursiones getVistaListarExcursiones() {
        return vListarExcursiones;
    }

    public VistaAddExcursion getVistaAddExcursion() {
        return vAddExcursion;
    }

    
    // Setters

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