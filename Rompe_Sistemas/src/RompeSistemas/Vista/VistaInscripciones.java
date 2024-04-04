package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlInscripciones;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Modelo.Inscripcion;
import RompeSistemas.Modelo.Datos;
import java.util.ResourceBundle.Control;
import RompeSistemas.Controlador.ControlDatos;

public class VistaInscripciones {


    //Atributos
    private ControlInscripciones cInscripciones;
    private VistaListarInscripciones vListarInscripciones; 
    private VistaAddInscripcion vAñadirInscripcion;
    private ControlPeticiones cPeticiones;
    private Datos datos;

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
        this.cPeticiones = cInscripciones.getApp().cPeticiones;
        this.datos = cInscripciones.getApp().datos;

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


    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones
     */
    public void buttonListInscripciones() {
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

    public void buttonRemoveInscripciones() {
        // Variables internas
        String respuesta;
        // Pedir número de inscripción a eliminar
        respuesta = cPeticiones.pedirString("Introduce el número de inscripción a eliminar: ");
        // Eliminar inscripción indicada por el usuario
        cInscripciones.removeInscripcion((Inscripcion) datos.getObjeto(2, datos.buscarObjeto(respuesta, 2 )));
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
            System.out.println("2. Listar inscripción");
            System.out.println("3. Mostrar info de las inscripciones");
            System.out.println("4. Eliminar inscripción");

            switch (cPeticiones.pedirEntero("Selecciona una opción (1, 2, 3, 4 o 0):",0,4)) {
                case 1:
                    buttonAddInscripcion();
                    break;

                case 2:
                    buttonListInscripciones();
                    break;
                case 3:
                    listInscripcionesSocio();
                    break;
                case 4:
                    buttonRemoveInscripciones();
                    break;
                case 5:
                    buttonAtras();
                    running = false;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
