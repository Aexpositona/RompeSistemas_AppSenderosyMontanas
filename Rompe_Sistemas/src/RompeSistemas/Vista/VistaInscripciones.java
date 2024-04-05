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
    private ControlInscripciones cInscripciones = new ControlInscripciones(null);
    private VistaListarInscripciones vListarInscripciones = new VistaListarInscripciones(cInscripciones); 
    private VistaAddInscripcion vAñadirInscripcion = new VistaAddInscripcion(cInscripciones);
    private ControlPeticiones cPeticiones = new ControlPeticiones();
    private Datos datos = new Datos();

    //Constructores
    /**
     * Método constructor de la clase VistaInscripciones que recibe por parámetros la vista de añadir inscripción y la vista de listar inscripciones
     *
     * @param vAñadirInscripcion   es la vista de añadir inscripción
     * @param vListarInscripciones es la vista de listar inscripciones
     */
    public VistaInscripciones(ControlInscripciones cInscripciones) {
        this.cInscripciones = cInscripciones;
        this.vAñadirInscripcion = cInscripciones.getVistaAddInscripcion();
        this.vListarInscripciones = cInscripciones.getVistaListarInscripciones();
        this.cPeticiones = cInscripciones.getControlPeticiones();
        this.datos = cInscripciones.getDatos();
    }

    //Métodos

    /**
     * Método para añadir un botón que nos permite añadir una inscripción
     */
    public void buttonAddInscripcion() {
        System.out.println("Navegando a la vista de añadir inscripción");
        vAñadirInscripcion.show();
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
