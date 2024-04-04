package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
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