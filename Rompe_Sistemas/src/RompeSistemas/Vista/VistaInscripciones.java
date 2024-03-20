package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlInscripciones;

public class VistaInscripciones<A extends VistaAñadirInscripcion, L extends VistaListarInscripciones> {

    public A vVistaAñadirInscripcion;
    public L vVistaListarInscripciones;

    /**
     * Constructor de la clase VistaInscripciones que recibe por parámetros la vista de añadir inscripción y la vista de listar inscripciones
     * @param vVistaAñadirInscripcion es la vista de añadir inscripción
     * @param vVistaListarInscripciones es la vista de listar inscripciones
     */
    public VistaInscripciones(A vVistaAñadirInscripcion, L vVistaListarInscripciones) {
        this.vVistaAñadirInscripcion = vVistaAñadirInscripcion;
        this.vVistaListarInscripciones = vVistaListarInscripciones;
    }

    public VistaInscripciones(ControlInscripciones cInscripciones) {
    }

    /**
     * Método para añadir un botón que nos permite añadir una inscripción
     */
    public void buttonAddInscripcion(){

    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones
     */
    public void buttonRemoveInscripcion(){

    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones
     */
    public void buttonAListInscripcionSocio(){

    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones
     */
    public void buttonListInscripcionesFecha(){

    }

    /**
     * Método para añadir un botón que nos permite mostrar la información de las inscripciones
     */
    public void showInfo(){

    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras(){

    }

    public void show() {
        //TODO
    }
}
