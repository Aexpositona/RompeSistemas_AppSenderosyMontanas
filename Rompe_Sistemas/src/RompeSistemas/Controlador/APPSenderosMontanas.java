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
        APPSenderosMontanas app = new APPSenderosMontanas();
        // Inicializar los datos
        Datos datos = new Datos();
        DataLoader dataLoader = new DataLoader(datos);
        dataLoader.load(datos);
        // Iniciar la aplicación
        app.iniciar(datos);
        // Mostrar la vista del menú principal
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
        this.datos = datos;
        cDatos = new ControlDatos(this);
        cPeticiones = new ControlPeticiones();
        cInscripciones = new ControlInscripciones(this);
        cSocios = new ControlSocios(this);
        cExcursiones = new ControlExcursiones(this);
        cMenuPrincipal = new ControlMenuPrincipal(this);

        // Inicializar vistas y controladores de menú principal
        cMenuPrincipal.setControlExcursiones(cExcursiones);
        cMenuPrincipal.setControlInscripciones(cInscripciones);
        cMenuPrincipal.setControlSocios(cSocios);
        cMenuPrincipal.setVistaMenuPrincipal(new VistaMenuPrincipal());
        cMenuPrincipal.getVistaMenuPrincipal().setControlMenuPrincipal(cMenuPrincipal);
        cMenuPrincipal.getVistaMenuPrincipal().setControlPeticiones(cPeticiones);
        
        // Inicializar controladores y vistas de inscripciones
        cInscripciones.getVistaInscripciones().setControlInscripciones(cInscripciones);
        cInscripciones.getVistaInscripciones().setControlPeticiones(cPeticiones);
        cInscripciones.getVistaListarInscripciones().setControlInscripciones(cInscripciones);
        cInscripciones.getVistaListarInscripciones().setControlPeticiones(cPeticiones);
        cInscripciones.getVistaInscripciones().setVistaListarInscripciones(new VistaListarInscripciones(cInscripciones));
        cInscripciones.getVistaAddInscripcion().setControlInscripciones(cInscripciones);
        cInscripciones.getVistaAddInscripcion().setControlPeticiones(cPeticiones);
        cInscripciones.getVistaInscripciones().setVistaAddInscripcion(new VistaAddInscripcion(cInscripciones));

        // Inicializar controladores y vistas de socios
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

        // Inicializar controladores y vistas de excursiones
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

        // Inicializar vista menu principal
        vMenuPrincipal = cMenuPrincipal.getVistaMenuPrincipal();
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

    /**
     * Devuelve el controlador del menú principal.
     * @return ControlMenuPrincipal
     */
    public ControlMenuPrincipal getControlMenuPrincipal() {
        return cMenuPrincipal;
    }

    /**
     * Devuelve el controlador de inscripciones.
     * @return ControlInscripciones
     */
    public ControlInscripciones getControlInscripciones() {
        return cInscripciones;
    }

    /**
     * Devuelve el controlador de socios.
     * @return ControlSocios
     */
    public ControlSocios getControlSocios() {
        return cSocios;
    }

    /**
     * Devuelve el controlador de excursiones.
     * @return ControlExcursiones
     */
    public ControlExcursiones getControlExcursiones() {
        return cExcursiones;
    }

    /**
     * Devuelve el controlador de datos.
     * @return ControlDatos
     */
    public ControlDatos getControlDatos() {
        return cDatos;
    }

    /**
     * Devuelve el controlador de peticiones.
     * @return ControlPeticiones
     */
    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    /**
     * Devuelve los datos de la aplicación.
     * @return Datos
     */
    public Datos getDatos() {
        return datos;
    }

    /**
     * Devuelve la vista del menú principal.
     * @return VistaMenuPrincipal
     */
    public VistaMenuPrincipal getVistaMenuPrincipal() {
        return vMenuPrincipal;
    }

    // Setters

    /**
     * Establece el controlador del menú principal.
     * @param cMenuPrincipal ControlMenuPrincipal
     */
    public void setControlMenuPrincipal(ControlMenuPrincipal cMenuPrincipal) {
        this.cMenuPrincipal = cMenuPrincipal;
    }

    /**
     * Establece el controlador de inscripciones.
     * @param cInscripciones ControlInscripciones
     */
    public void setControlInscripciones(ControlInscripciones cInscripciones) {
        this.cInscripciones = cInscripciones;
    }

    /**
     * Establece el controlador de socios.
     * @param cSocios ControlSocios
     */
    public void setControlSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
    }

    /**
     * Establece el controlador de excursiones.
     * @param cExcursiones ControlExcursiones
     */
    public void setControlExcursiones(ControlExcursiones cExcursiones) {
        this.cExcursiones = cExcursiones;
    }

    /**
     * Establece el controlador de datos.
     * @param cDatos ControlDatos
     */
    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }

    /**
     * Establece el controlador de peticiones.
     * @param cPeticiones ControlPeticiones
     */
    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }   

    /**
     * Establece los datos de la aplicación.
     * @param datos Datos
     */
    public void setDatos(Datos datos) {
        this.datos = datos;
    }
}