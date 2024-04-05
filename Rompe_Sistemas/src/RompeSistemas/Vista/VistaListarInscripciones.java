package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlInscripciones;
import RompeSistemas.Controlador.ControlPeticiones;

public class VistaListarInscripciones {


    //Atributos
    private ControlInscripciones cInscripciones;
    private ControlPeticiones cPeticiones;

    public VistaListarInscripciones(ControlInscripciones cInscripciones) {
        this.cInscripciones = cInscripciones;
        this.cPeticiones = cInscripciones.getControlPeticiones();
    }

    //Métodos
    /**
     * Método para añadir un botón que nos permite listar las inscripciones de un usuario

     */
    public void buttonListInscripcionesSocio(){
        cInscripciones.listInscripcionesSocio(3, cPeticiones.pedirString("Introduzca el id del socio: "));
    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones por fechas
     */
    public void buttonListInscripcionesFechas(){
        cInscripciones.listInscripcionesFechas(cPeticiones.pedirFecha("Introduzca la fecha inicial: "), cPeticiones.pedirFecha("Introduzca la fecha final: "));
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() {
        System.out.println("Volviendo al menú inscripciones...");
        return;
    }

    public void show() {

        // Variables internas
        boolean running = true;
        // Mientras no se seleccione la opción de volver atrás
        while (running) {
            // Mostramos el menú de listar inscripciones
            System.out.println("........MENÚ LISTAR INSCRIPCIONES........\n");
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Listar inscripción por usuario");
            System.out.println("2. Listar inscripción por fechas");
            System.out.println("0. Atrás");

            switch (cPeticiones.pedirEntero("Seleccione una opción: ", 0, 2)) {
                case 1:
                    buttonListInscripcionesSocio();
                    break;
                case 2:
                    buttonListInscripcionesFechas();
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
