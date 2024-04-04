package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlInscripciones;
import RompeSistemas.Controlador.ControlPeticiones;

public class VistaAddInscripcion {

    // Atributos
    private ControlPeticiones cPeticiones;


    //Constructores

    public VistaAddInscripcion(ControlInscripciones cInscripciones) {
        this.cPeticiones = cInscripciones.getApp().cPeticiones;
        
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
        System.out.println("Volviendo al menú inscripciones...");
        return;
    }

    public void show() {

        boolean running = true;

        while (running) {


            System.out.println("........MENÚ AÑADIR INSCRIPCIÓN........\n");
            System.out.println("Seleccione una opción: ");
            System.out.println("0. Atrás");
            System.out.println("1. Añadir inscripción");
            System.out.println("2. Cancelar inscripción");

            switch (cPeticiones.pedirEntero("Introduzca una opción: ",0,2)){
                case 1:
                    buttonAñadir();
                    break;
                case 2:
                    buttonCancelar();
                    break;
                case 3:
                    buttonAtras();
                    running = false;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
