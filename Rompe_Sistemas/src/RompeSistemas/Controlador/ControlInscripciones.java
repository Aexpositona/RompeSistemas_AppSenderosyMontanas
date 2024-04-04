package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Inscripcion;
import RompeSistemas.Vista.VistaInscripciones;
import RompeSistemas.Vista.VistaListarInscripciones;
import RompeSistemas.Vista.VistaAddInscripcion;

public class ControlInscripciones {

    // Atributos
    private VistaInscripciones vInscripciones; 
    private VistaListarInscripciones vListarInscripciones;
    private VistaAddInscripcion vAddInscripcion;
    private APPSenderosMontanas app;

    /**
     * Constructor de ControlInscripciones.
     *
     * @param appSenderosMontanas
     * @param datos
     * @param vistaInscripciones  VistaInscripciones asociada al controlador
     */
    public ControlInscripciones(APPSenderosMontanas app) {
        this.app = app;
        this.vInscripciones = new VistaInscripciones(this);
        this.vAddInscripcion = new VistaAddInscripcion(this);
        this.vListarInscripciones = new VistaListarInscripciones(this);
    }

    // Getters

    public APPSenderosMontanas getApp() {
        return app;
    }

    public VistaInscripciones getVistaInscripciones() {
        return vInscripciones;
    }

    public VistaAddInscripcion getVistaAddInscripcion() {
        return vAddInscripcion;
    }

    public VistaListarInscripciones getVistaListarInscripciones() {
        return vListarInscripciones;
    }

    // Setters

    public void setApp(APPSenderosMontanas app) {
        this.app = app;
    }



    
    // Métodos

    /**
     * Agrega una inscripción utilizando la clase Datos.
     *
     * @param inscripcion Inscripción a agregar
     * @param socio       Socio que realiza la inscripción
     * @param excursion   Excursión a la que se inscribe el socio
     */
    public void addInscripcion(Inscripcion inscripcion) {
        app.getDatos().addObjeto(inscripcion, 2);
    }

    /**
     * Elimina una inscripción utilizando la clase Datos.
     *
     * @param inscripcion Número de inscripción a eliminar
     */
    public void removeInscripcion(Inscripcion inscripcion) {
        datos.removeObjeto(inscripcion, 2);
    }

    /**
     * Lista las inscripciones de un socio utilizando la clase Datos.
     *
     * @param numeroSocio Número de socio del que listar las inscripciones
     */
    public void listInscripcionesSocio(int tipoObjeto, String numeroSocio) {
        System.out.println(datos.listToStringObjetosCodigo(tipoObjeto, numeroSocio ));
    }

    /**
     * Muestra la vista para añadir una inscripción.
     */
    public void addInscripcion() {
        vAddInscripcion.show();
    }



    /**
     * Muestra la vista para listar las inscripciones.
     */
    public void showVistaListarInscripciones() {
        vListarInscripciones.show();
    }

    /**
     * Muestra la vista de inscripciones.
     */
    public void show() {
        vInscripciones.show();
    }

    /**
     * Maneja el evento del botón "Atrás".
     */
    public void buttonAtras() {
        return;
    }
}