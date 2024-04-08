package RompeSistemas.Controlador;

import java.time.LocalDate;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Inscripcion;
import RompeSistemas.Modelo.Socio;
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
    private ControlDatos cDatos;

    /**
     * Constructor de ControlInscripciones.
     *
     */
    public ControlInscripciones(APPSenderosMontanas app) {
        this.app = app;
        this.vInscripciones = new VistaInscripciones();
        this.vAddInscripcion = new VistaAddInscripcion();
        this.vListarInscripciones = new VistaListarInscripciones();
        this.datos = app.getDatos();
        this.cPeticiones = app.getControlPeticiones();
        this.cDatos = app.getControlDatos();
    }

    /**
     * Constructor de ControlInscripciones de copia.
     *
     * @param cInscripciones ControlInscripciones a copiar
     */
    public ControlInscripciones(ControlInscripciones cInscripciones) {
        this.app = cInscripciones.getApp();
        this.vInscripciones = cInscripciones.getVistaInscripciones();
        this.vAddInscripcion = cInscripciones.getVistaAddInscripcion();
        this.vListarInscripciones = cInscripciones.getVistaListarInscripciones();
        this.datos = cInscripciones.getDatos();
        this.cPeticiones = cInscripciones.getControlPeticiones();
        this.cDatos = cInscripciones.getControlDatos();
    }

    /**
     * Constructor de ControlInscripciones vacío.
     */
    public ControlInscripciones() {
        this.vInscripciones = null;
        this.vAddInscripcion = null;
        this.vListarInscripciones = null;
        this.datos = null;
        this.cPeticiones = null;
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

    public ControlDatos getControlDatos() {
        return cDatos;
    }

    public ControlInscripciones getControlInscripciones() {
        return this;
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
    public void addInscripcion(Inscripcion inscripcion) {
        datos.addObjeto(2, inscripcion);
    }

    /**
     * Elimina una inscripción de la lista de inscripciones utilizando la clase Datos.
     *
     * @param inscripcion Inscripción a eliminar
     * @param tipoObjeto Tipo de objeto a eliminar
     */
    public void removeInscripcion(Inscripcion inscripcion, int tipoObjeto) {
        datos.removeObjeto(tipoObjeto, inscripcion);
    }

    /**
     * Lista todas las inscripciones.
     */
    public void listInscripciones() {
        vListarInscripciones.txtMostrarMensaje(datos.listToStringObjetos(2));
    }

    /**
     * Lista las inscripciones de un socio.
     *
     * @param tipoObjeto Tipo de objeto a listar
     * @param numeroSocio Número de socio
     */
    public void listInscripcionesSocio(String numeroSocio) {
        // Variables internas
        int i;
        Inscripcion inscripcion;
        Socio socio;
        // Recorremos la lista de inscripciones
        for (i = 0; i < datos.listObjetos(2).size(); i++){
            // Guardamos la inscripción
            inscripcion = (Inscripcion) datos.listObjetos(2).get(i);
            // Guardamos el socio de la inscripción
            socio = inscripcion.getSocio();
            // Si el número del socio coincide con el número del socio introducido
            if (socio.getNumero().equals(numeroSocio)) {
                // Mostramos la inscripción
                vListarInscripciones.txtMostrarMensaje("-- Inscripción " + (i+1) + " --\n" + datos.listObjetos(2).get(i).toString() + "\n");
            }
        }
    }

    /**
     * Lista las inscripciones de un socio entre fechas.
     *
     * @param fechaInicial Fecha inicial
     * @param fechaFinal Fecha final
     */
    public void listInscripcionesFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
        vListarInscripciones.txtMostrarMensaje(datos.listToStringObjetosFechas(2, fechaInicial, fechaFinal));
    }

    public void listIdsSocios() {
        vListarInscripciones.txtMostrarMensaje(datos.listParametroObjeto(3, 3));
    }

    public void listExcursiones() {
        vListarInscripciones.txtMostrarMensaje(datos.listParametroObjeto(1, 31));
    }

    /**
     * Muestra la vista para añadir una inscripción.
     */
    public void showVistaAddInscripcion() {
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