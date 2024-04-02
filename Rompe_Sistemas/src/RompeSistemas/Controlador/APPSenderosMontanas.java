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
     * Vista del menú principal.
     */
    public VistaMenuPrincipal vMenuPrincipal;
    /**
     * Vista de inscripciones.
     */
    public VistaInscripciones vInscripciones;
    /**
     * Vista de socios.
     */
    public VistaSocios vSocios;
    /**
     * Vista de excursiones.
     */
    public VistaExcursiones vExcursiones;
    /**
     * Vista de añadir socio.
     */
    public VistaAddSocio vAddSocio;
    /**
     * Vista de modificar seguro.
     */
    public VistaModificarSeguro vVistaModificarSeguro;
    /**
     * Vista de listar socios.
     */
    public VistaListarSocios vVistaListarSocios;

    // Métodos

    /**
     * Inicializa la aplicación.
     *
     * @param datos Recibe los datos de la aplicación.
     * Inicializa los controladores y las vistas de la aplicación.
     */
    public void iniciar(Datos datos) {
        // Inicializar controladores y vistas aquí
        cInscripciones = new ControlInscripciones(this, datos, vInscripciones);
        cSocios = new ControlSocios(datos);
        cExcursiones = new ControlExcursiones(this, datos, vExcursiones);

        vInscripciones = new VistaInscripciones(cInscripciones);
        vSocios = new VistaSocios(cSocios, cMenuPrincipal, vExcursiones, vInscripciones);
        vExcursiones = new VistaExcursiones(cExcursiones, cDatos, cPeticiones);

        vAddSocio = new VistaAddSocio(cSocios, vSocios);
        vVistaModificarSeguro = new VistaModificarSeguro(cSocios, vSocios);
        vVistaListarSocios = new VistaListarSocios(cSocios, vSocios);
        cMenuPrincipal = new ControlMenuPrincipal(this, vMenuPrincipal);
        vMenuPrincipal = new VistaMenuPrincipal(cMenuPrincipal, vSocios, vExcursiones, vInscripciones);

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
        DataLoader dataLoader = new DataLoader(datos);
        dataLoader.load();
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