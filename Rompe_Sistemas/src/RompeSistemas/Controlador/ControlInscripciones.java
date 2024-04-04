package RompeSistemas.Controlador;

import java.time.LocalDate;

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
    private Datos datos;
    private ControlPeticiones cPeticiones;

    /**
     * Constructor de ControlInscripciones.
     *
     */
    public ControlInscripciones(APPSenderosMontanas app) {
        this.vInscripciones = new VistaInscripciones(this);
        this.vAddInscripcion = new VistaAddInscripcion(this);
        this.vListarInscripciones = new VistaListarInscripciones(this);
        this.app.datos = app.getDatos();
        this.app.cPeticiones = app.cPeticiones;
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

    public Datos getDatos() {
        return datos;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    // Setters

    public void setApp(APPSenderosMontanas app) {
        this.app = app;
    }

    public void setVistaInscripciones(VistaInscripciones vInscripciones) {
        this.vInscripciones = vInscripciones;
    }

    public void setVistaAddInscripcion(VistaAddInscripcion vAddInscripcion) {
        this.vAddInscripcion = vAddInscripcion;
    }

    public void setVistaListarInscripciones(VistaListarInscripciones vListarInscripciones) {
        this.vListarInscripciones = vListarInscripciones;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }
 
    // Métodos

    /**
     * Añade una inscripción a la lista de inscripciones utilizando la clase Datos.
     * @param inscripcion Inscripción a añadir
     * @param tipoObjeto Tipo de objeto a añadir
     */
    public void addInscripcion(Inscripcion inscripcion, int tipoObjeto) {
        datos.addObjeto(inscripcion, tipoObjeto);
    }

    /**
     * Elimina una inscripción de la lista de inscripciones utilizando la clase Datos.
     *
     * @param inscripcion Inscripción a eliminar
     * @param tipoObjeto Tipo de objeto a eliminar
     */
    public void removeInscripcion(Inscripcion inscripcion, int tipoObjeto) {
        datos.removeObjeto(inscripcion, tipoObjeto);
    }

    /**
     * Lista las inscripciones de un socio.
     *
     * @param tipoObjeto Tipo de objeto a listar
     * @param numeroSocio Número de socio
     */
    public void listInscripcionesSocio(int tipoObjeto, String numeroSocio) {
        System.out.println(datos.listToStringObjetosCodigo(tipoObjeto, numeroSocio ));
    }

    /**
     * Lista las inscripciones de un socio.
     *
     * @param tipoObjeto Tipo de objeto a listar
     * @param numeroSocio Número de socio
     */
    public void listInscripcionesFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
        System.out.println(datos.listToStringObjetosFechas(2, fechaInicial, fechaFinal));
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