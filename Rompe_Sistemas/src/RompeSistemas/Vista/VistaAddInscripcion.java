package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlInscripciones;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Excursion;
import RompeSistemas.Modelo.Inscripcion;
import RompeSistemas.Modelo.Socio;

/**
 * Vista de añadir inscripción de la aplicación.
 *
 */
public class VistaAddInscripcion {

    // Atributos
    private ControlInscripciones cInscripciones;
    private ControlPeticiones cPeticiones;
    private Datos datos;
    private ControlDatos cDatos;

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
        this.cDatos = new ControlDatos(cInscripciones.getControlDatos());
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
        this.cDatos = vistaAddInscripcion.getControlDatos();
    }

    /**
     * Método constructor vacío de la clase VistaAddInscripcion.
     */
    public VistaAddInscripcion() {
        this.cInscripciones = null;
        this.cPeticiones = null;
        this.datos = null;
        this.cDatos = null;
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
    public ControlDatos getControlDatos() {
        return cDatos;
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
    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }
        
    //Métodos
    /**
     * Método para añadir un botón que nos permite añadir una inscripción
     */
    public void buttonAddInscripcion(){
        String idSocio, idExcursion;
        Socio socio;
        Excursion excursion;
        // Mostramos mensaje de añadir inscripción
        txtMostrarMensaje("\n-- Añadiendo inscripción --\n");
        // Hasta que no se introduzca un id de socio válido, no se sale del bucle
        do {
            // Mostramos id y nombre de los socios
            cInscripciones.listIdsSocios();
            // Mostramos mensaje de seleccionar socio
            txtMostrarMensaje("\n-- Seleccionando socio --\n");
            // Pedimos los datos de la inscripción
            idSocio = cPeticiones.pedirString("Introduzca el código del socio: ");
            // Si el id introducido no es válido, mostramos mensaje de error
            if (!cDatos.checkExistenciaObjeto(3, idSocio)) {
                txtMostrarMensaje("El id introducido no es válido. Inténtelo de nuevo.\n");
            } 
            // Si el id introducido es válido, creamos el socio y salimos del bucle
            else {
                socio = (Socio) datos.getObjeto(3, datos.buscarObjeto(3, idSocio));
                break;
            }
        } 
        while (true);
        // Hasta que no se introduzca un id de excursión válido, no se sale del bucle
        do {
            // Mostramos mensaje de seleccionar excursión
            txtMostrarMensaje("\n-- Seleccionando excursión --\n");
            // Pedimos los datos de la inscripción
            cInscripciones.listExcursiones();
            idExcursion = cPeticiones.pedirString("Introduzca el código de la excursión: ");
            // Si el id introducido no es válido, mostramos mensaje de error
            if (!cDatos.checkExistenciaObjeto(1, idExcursion)) {
                txtMostrarMensaje("El id introducido no es válido. Inténtelo de nuevo.\n");
            }
            // Si el id introducido es válido, creamos la excursión y salimos del bucle 
            else {
                // Si el id es válido registramos la inscripción
                excursion = (Excursion) datos.getObjeto(1, datos.buscarObjeto(1, idExcursion));
                break;
            }
        }
        while (true);
        // Creamos y añadimos la inscripción
        cInscripciones.addInscripcion(new Inscripcion(datos.getSiguienteCodigo(2), socio, excursion));
        txtMostrarMensaje("Inscripción añadida correctamente.\n\n");
    }

    // Método para añadir un botón que nos permite volver al menú de inscripciones
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
        // Variables internas
        boolean running = true;
        // Mientras se ejecute la vista
        while (running) {
            // Mostramos el menú
            txtMostrarMensaje("************ MENÚ AÑADIR INSCRIPCIÓN ************\n");
            txtMostrarMensaje("1. Añadir inscripción\n");
            txtMostrarMensaje("0. Atrás\n");
            // Solicitamos la opción
            switch (cPeticiones.pedirEntero("Seleccione una opción (1 o 0): ",0,1)){
                case 1:
                    buttonAddInscripcion();
                    break;
                case 0:
                    buttonAtras();
                    running = false;
                default:
                    txtMostrarMensaje("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}