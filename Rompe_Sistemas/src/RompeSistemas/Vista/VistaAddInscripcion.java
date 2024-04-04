package RompeSistemas.Vista;

import java.util.Date;

import RompeSistemas.Controlador.ControlPeticiones;

public class VistaAddInscripcion {

    // Atributos
    private ControlPeticiones cPeticiones;


    //Constructores
    /**
     * Constructor de la clase VistaAñadirInscripcion que recibe por parámetros el código, la descripción, la fecha, el precio y los días de la inscripción
     * @param codigo es el código de la inscripción
     * @param descripcion es la descripción de la inscripción
     * @param fecha es la fecha de la inscripción
     * @param precio es el precio de la inscripción
     * @param dias es la duración de la inscripción
     */
    public VistaAddInscripcion() {

    }

    /**
     * Constructor por defecto de la clase VistaAñadirInscripcion
     */
    public VistaAddInscripcion() {
    }

    //Métodos
    /**
     * Método para añadir un botón que nos permite añadir una inscripción
     */
    public void buttonAñadir(){

    }

    /**
     * Método para añadir un botón que nos permite cancelar la operación
     */
    public void buttonCancelar() {

    }

    public void buttonAtras() {

    }

    public void show() {

        boolean running = true;

        while (running) {


            System.out.println("........MENÚ AÑADIR INSCRIPCIÓN........\n");
            System.out.println("Seleccione una opción: ");
            System.out.println("0. Atrás");
            System.out.println("1. Añadir inscripción");
            System.out.println("2. Cancelar inscripción");

            switch () {
                case "1":
                    buttonAñadir();
                    break;

                case "2":
                    buttonCancelar();
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
