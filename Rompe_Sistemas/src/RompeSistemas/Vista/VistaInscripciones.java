package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlInscripciones;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Modelo.Inscripcion;
import RompeSistemas.Modelo.Datos;

/**
 * Vista de inscripciones de la aplicación.
 *
 */
public class VistaInscripciones {
    //Atributos
    private ControlInscripciones cInscripciones;
    private VistaListarInscripciones vListarInscripciones; 
    private VistaAddInscripcion vAddInscripcion;
    private ControlPeticiones cPeticiones;
    private Datos datos;

    //Constructores
    /**
     * Método constructor de la clase VistaInscripciones que recibe por parámetros la vista de añadir inscripción y la vista de listar inscripciones
     *
     * @param vAddInscripcion   es la vista de añadir inscripción
     * @param vListarInscripciones es la vista de listar inscripciones
     */
    public VistaInscripciones(ControlInscripciones cInscripciones) {
        this.cInscripciones = cInscripciones;
        this.vAddInscripcion = cInscripciones.getVistaAddInscripcion();
        this.vListarInscripciones = cInscripciones.getVistaListarInscripciones();
        this.cPeticiones = cInscripciones.getControlPeticiones();
        this.datos = cInscripciones.getDatos();
    }

    public VistaInscripciones(VistaInscripciones vistaInscripciones) {
        this.cInscripciones = vistaInscripciones.getControlInscripciones();
        this.vAddInscripcion = vistaInscripciones.getVistaAddInscripcion();
        this.vListarInscripciones = vistaInscripciones.getVistaListarInscripciones();
        this.cPeticiones = vistaInscripciones.getControlPeticiones();
        this.datos = vistaInscripciones.getDatos();
    }

    public VistaInscripciones() {
        this.cInscripciones = null;
        this.vAddInscripcion = null;
        this.vListarInscripciones = null;
        this.cPeticiones = null;
        this.datos = null;
    }

    //Getters
    public ControlInscripciones getControlInscripciones() {
        return cInscripciones;
    }

    public VistaAddInscripcion getVistaAddInscripcion() {
        return vAddInscripcion;
    }

    public VistaListarInscripciones getVistaListarInscripciones() {
        return vListarInscripciones;
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

    public void setVistaAddInscripcion(VistaAddInscripcion vAñadirInscripcion) {
        this.vAddInscripcion = vAñadirInscripcion;
    }

    public void setVistaListarInscripciones(VistaListarInscripciones vListarInscripciones) {
        this.vListarInscripciones = vListarInscripciones;
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
    public void buttonAddInscripcion() {
        System.out.println("Navegando a la vista de añadir inscripción");
        vAddInscripcion.show();
    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones
     */
    public void buttonRemoveInscripcion() {
        cInscripciones.removeInscripcion((Inscripcion) datos.getObjeto(2, datos.buscarObjeto(2, cPeticiones.pedirString("Introduce el número de inscripción a eliminar: "))), 2);

    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones
     */
    public void buttonMenuListInscripciones() {
        System.out.println("Navegando a la vista de listar inscripciones");
        vListarInscripciones.show();
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() {
        System.out.println("Volviendo al menú principal");
        return;
    }

    public void show() {
        // Variables internas
        boolean running = true;
        // Mientras la aplicación esté en ejecución
        while (running) {
            System.out.println("\n........MENÚ INSCRIPCIONES........\n");
            System.out.println("Seleccione una opción: ");
            System.out.println("0. Salir");
            System.out.println("1. Añadir inscripción");
            System.out.println("2. Menú Listar inscripciónes");
            System.out.println("3. Eliminar inscripción");

            switch (cPeticiones.pedirEntero("Selecciona una opción (1, 2, 3 o 0):",0,3)) {
                case 1:
                    buttonAddInscripcion();
                    break;

                case 2:
                    buttonMenuListInscripciones();
                    break;
                case 3:
                    buttonRemoveInscripcion();
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
