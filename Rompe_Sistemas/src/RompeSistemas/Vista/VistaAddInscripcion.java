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

    public VistaAddInscripcion(ControlInscripciones cInscripciones) {
        this.cInscripciones = cInscripciones;
        this.cPeticiones = cInscripciones.getControlPeticiones();
        this.datos = cInscripciones.getDatos();        
    }

    //Métodos
    /**
     * Método para añadir un botón que nos permite añadir una inscripción
     */
    public void buttonAñadir(){
        cInscripciones.addInscripcion((Inscripcion) datos.getObjeto(2, datos.buscarObjeto(2, cPeticiones.pedirString("Introduzca el id del socio: "))),2);
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
            System.out.println("1. Añadir inscripción");
            System.out.println("0. Atrás");

            switch (cPeticiones.pedirEntero("Introduzca una opción: ",0,1)){
                case 1:
                    buttonAñadir();
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
