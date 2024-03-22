package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlInscripciones;

import java.util.Scanner;

public class VistaInscripciones {


    //Atributos
    //public VistaAñadirInscripcion vVistaAñadirInscripcion;

    //public VistaListarInscripciones vVistaListarInscripciones;
    VistaListarInscripciones vVistaListarInscripciones = new VistaListarInscripciones();
    VistaAñadirInscripcion vVistaAñadirInscripcion = new VistaAñadirInscripcion();
    private Scanner scan = new Scanner(System.in);


    //Constructores
    /**
     * Método constructor de la clase VistaInscripciones que recibe por parámetros la vista de añadir inscripción y la vista de listar inscripciones
     *
     * @param vVistaAñadirInscripcion   es la vista de añadir inscripción
     * @param vVistaListarInscripciones es la vista de listar inscripciones
     */
    public VistaInscripciones(VistaAñadirInscripcion vVistaAñadirInscripcion, VistaListarInscripciones vVistaListarInscripciones) {
        this.vVistaAñadirInscripcion = vVistaAñadirInscripcion;
        this.vVistaListarInscripciones = vVistaListarInscripciones;
    }

    /**
     * Constructor por defecto de la clase VistaInscripciones
     */
    public VistaInscripciones() {
    }

    //Métodos
    public VistaInscripciones(ControlInscripciones cInscripciones) {
    }


    /**
     * Método para añadir un botón que nos permite añadir una inscripción
     */
    public void buttonAddInscripcion() {

        vVistaAñadirInscripcion.show();
        System.out.println("Navegando a la vista de añadir inscripción");
    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones
     */
    public void buttonRemoveInscripcion() {

    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones
     */
    public void buttonAListInscripciones() {
        vVistaListarInscripciones.show();
        System.out.println("Navegando a la vista de listar inscripciones");

    }

    /**
     * Método para añadir un botón que nos permite mostrar la información de las inscripciones
     */
    public void showInfo() {

    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() {

    }

    public void buttonRemoveInscripciones() {

    }

    public void show() {

        boolean running = true;

        while (running) {


            System.out.println("\n........MENÚ INSCRIPCIONES........\n");
            System.out.println("Seleccione una opción: ");
            System.out.println("0. Salir");
            System.out.println("1. Añadir inscripción");
            System.out.println("2. Listar inscripción");
            System.out.println("3. Mostrar info de las inscripciones");


            switch (scan.nextLine()) {
                case "1":
                    buttonAddInscripcion();
                    break;

                case "2":
                    buttonAListInscripciones();
                    break;
                case "3":
                    showInfo();
                    break;
                case "4":
                    buttonRemoveInscripciones();
                    break;
                case "0":
                    buttonAtras();
                    running = false;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
