package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlInscripciones;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Inscripcion;

/**
 * Vista de añadir inscripción de la aplicación.
 *
 */
public class VistaAddInscripcion {

    // Atributos
    private ControlInscripciones cInscripciones;
    private ControlPeticiones cPeticiones;
    private Datos datos;

    //Constructores

    /**
     * Método constructor de la clase VistaAddInscripcion que recibe por parámetros la vista de control de inscripciones.
     *
     * @param cInscripciones ControlInscripciones
     */
    public VistaAddInscripcion(ControlInscripciones cInscripciones) {
        this.cInscripciones = new ControlInscripciones(cInscripciones);
        this.cPeticiones = new ControlPeticiones(cInscripciones.getControlPeticiones());
        this.datos = new Datos(cInscripciones.getDatos());
    }

    /**
     * Método constructor de copia de la clase VistaAddInscripcion.
     *
     * @param vistaAddInscripcion VistaAddInscripcion a copiar.
     */
    public VistaAddInscripcion(VistaAddInscripcion vistaAddInscripcion) {
        this.cInscripciones = vistaAddInscripcion.getControlInscripciones();
        this.cPeticiones = vistaAddInscripcion.getControlPeticiones();
        this.datos = vistaAddInscripcion.getDatos();
    }

    /**
     * Método constructor vacío de la clase VistaAddInscripcion.
     */
    public VistaAddInscripcion() {
        this.cInscripciones = null;
        this.cPeticiones = null;
        this.datos = null;
    }

    //Getters

    public ControlInscripciones getControlInscripciones() {
        return cInscripciones;
    }
    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }
    public Datos getDatos() {
        return datos;
    }

    //Setters

    public void setControlInscripciones(ControlInscripciones cInscripciones) {
        this.cInscripciones = cInscripciones;
    }
    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }
    public void setDatos(Datos datos) {
        this.datos = datos;
    }
        
    //Métodos
    /**
     * Método para añadir un botón que nos permite añadir una inscripción
     */
    public void buttonAddInscripcion(){

        txtMostrarMensaje("\n-- Añadiendo inscripción --\n");
        txtMostrarMensaje("- Listado de socios:\n" + datos.listToStringObjetos(3));
        cInscripciones.addInscripcion((Inscripcion) datos.getObjeto(2, datos.buscarObjeto(2, cPeticiones.pedirString("Introduzca el id del socio: "))),2);
    }

    public void buttonAtras() {
        txtMostrarMensaje("Volviendo al menú inscripciones...\n\n");
    }

    /**
     * Método para mostrar un mensaje.
     *
     * @param mensaje Mensaje a mostrar.
     */
    public void txtMostrarMensaje(String mensaje) {
        System.out.print(mensaje);
    }

    public void show() {

        boolean running = true;

        while (running) {
            // Mostramos el menú
            txtMostrarMensaje("************ MENÚ AÑADIR INSCRIPCIÓN ************\n");
            txtMostrarMensaje("1. Añadir inscripción\n");
            txtMostrarMensaje("0. Atrás\n");
            // Solicitamos la opción
            switch (cPeticiones.pedirEntero("Introduzca una opción: ",0,1)){
                case 1:
                    buttonAddInscripcion();
                    break;
                case 0:
                    buttonAtras();
                    running = false;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
