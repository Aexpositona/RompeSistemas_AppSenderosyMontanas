package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlInscripciones;
import RompeSistemas.Controlador.ControlPeticiones;

import java.time.LocalDate;

public class VistaListarInscripciones {


    //Atributos
    private ControlInscripciones cInscripciones;
    private ControlPeticiones cPeticiones;

    public VistaListarInscripciones(ControlInscripciones cInscripciones) {
        this.cInscripciones = cInscripciones;
        this.cPeticiones = cInscripciones.getControlPeticiones();
    }

    public VistaListarInscripciones(VistaListarInscripciones vistaListarInscripciones) {
        this.cInscripciones = vistaListarInscripciones.getControlInscripciones();
        this.cPeticiones = vistaListarInscripciones.getControlPeticiones();
    }

    public VistaListarInscripciones() {
        this.cInscripciones = null;
        this.cPeticiones = null;
    }

    //Getters

    public ControlInscripciones getControlInscripciones() {
        return cInscripciones;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    //Setters

    public void setControlInscripciones(ControlInscripciones cInscripciones) {
        this.cInscripciones = cInscripciones;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
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
        // Pedimos las fechas
        LocalDate fechaInicial = cPeticiones.pedirFecha("\n-- Introduzca la fecha inicial -- ",LocalDate.parse("2000-01-01"), LocalDate.now().plusYears(2));
        LocalDate fechaFinal = cPeticiones.pedirFecha("\n-- Introduzca la fecha final -- ", fechaInicial, LocalDate.now().plusYears(2));
        // Llamamos al método de ControlExcursiones que lista las excursiones entre dos fechas
        cInscripciones.listInscripcionesFechas(fechaInicial, fechaFinal);
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() {
        txtMostrarMensaje("Volviendo al menú inscripciones...\n");
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
        // Mientras no se seleccione la opción de volver atrás
        while (running) {
            // Mostramos el menú de listar inscripciones
            txtMostrarMensaje("************ MENÚ LISTAR INSCRIPCIONES ************\n");
            txtMostrarMensaje("1. Listar inscripción por usuario\n");
            txtMostrarMensaje("2. Listar inscripción por fechas\n");
            txtMostrarMensaje("0. Atrás\n");

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
