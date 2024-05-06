package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlInscripciones;
import RompeSistemas.Controlador.ControlPeticiones;

import java.sql.SQLException;
import java.time.LocalDate;

public class VistaListarInscripciones {


    //Atributos
    private ControlInscripciones cInscripciones;
    private ControlPeticiones cPeticiones;

    //Constructores
    /**
     * Método constructor de la clase VistaListarInscripciones que recibe por parámetros la vista de control de inscripciones.
     *
     * @param cInscripciones ControlInscripciones
     */
    public VistaListarInscripciones(ControlInscripciones cInscripciones) {
        this.cInscripciones = new ControlInscripciones(cInscripciones);
        this.cPeticiones = new ControlPeticiones(cInscripciones.getControlPeticiones());
    }

    /**
     * Método constructor de copia de la clase VistaListarInscripciones.
     *
     * @param vistaListarInscripciones VistaListarInscripciones a copiar.
     */
    public VistaListarInscripciones(VistaListarInscripciones vistaListarInscripciones) {
        this.cInscripciones = vistaListarInscripciones.getControlInscripciones();
        this.cPeticiones = vistaListarInscripciones.getControlPeticiones();
    }

    /**
     * Método constructor vacío de la clase VistaListarInscripciones.
     */
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
     * Método para añadir un botón que nos permite listar todas las inscripciones
     */
    public void buttonListInscripciones() {
        cInscripciones.listInscripciones();
    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones de un usuario

     */
    public void buttonListInscripcionesSocio(){
        // Variables internas
        String idSocio;
        // Mostramos el listado de IDs de socios disponibles
        cInscripciones.listIdsSocios();
        txtMostrarMensaje("\n");
        // Pedimos el id del socio
        idSocio = cPeticiones.pedirString("Introduzca el id del socio: ");
        idSocio = idSocio.toUpperCase();
        // Llamamos al método de ControlExcursiones que lista las excursiones de un socio
        cInscripciones.listInscripcionesSocio(idSocio);
    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones por fechas
     */
    public void buttonListInscripcionesFechas() throws SQLException {
        // Pedimos las fechas
        LocalDate fechaInicial = cPeticiones.pedirFecha("\n-- Introduzca la fecha inicial -- ",LocalDate.parse("2000-01-01"), LocalDate.now().plusYears(2));
        LocalDate fechaFinal = cPeticiones.pedirFecha("\n-- Introduzca la fecha final -- ", fechaInicial, LocalDate.now().plusYears(2));
        txtMostrarMensaje("\n");
        // Llamamos al método de ControlExcursiones que lista las excursiones entre dos fechas
        cInscripciones.listInscripcionesFechas(fechaInicial, fechaFinal);
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
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

    /**
     * Método para mostrar el menú de listar inscripciones.
     */
    public void show() throws SQLException {
        // Variables internas
        boolean running = true;
        // Mientras no se seleccione la opción de volver atrás
        while (running) {
            // Mostramos el menú de listar inscripciones
            txtMostrarMensaje("************ MENÚ LISTAR INSCRIPCIONES ************\n");
            txtMostrarMensaje("1. Listar todas las inscripciones\n");
            txtMostrarMensaje("2. Listar inscripción por socio\n");
            txtMostrarMensaje("3. Listar inscripción por fechas\n");
            txtMostrarMensaje("0. Atrás\n");

            switch (cPeticiones.pedirEntero("Seleccione una opción (1, 2, 3 o 0): ", 0, 3)) {
                case 1:
                    buttonListInscripciones();
                    break;
                case 2:
                    buttonListInscripcionesSocio();
                    break;
                case 3:
                    buttonListInscripcionesFechas();
                    break;
                case 0:
                    buttonAtras();
                    running = false;
                default:
                    txtMostrarMensaje("Opción no válida. Intente de nuevo.\n");
                    break;
            }
        }
    }
}