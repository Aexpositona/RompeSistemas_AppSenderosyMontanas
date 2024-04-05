package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlExcursiones;
import RompeSistemas.Controlador.ControlPeticiones;
import java.time.LocalDate;

/**
 * VistaListarExcursiones es la clase que muestra el menú de listar excursiones y solicita una opción.
 */
public class VistaListarExcursiones {
    // Atributos
    private ControlExcursiones cExcursiones;
    private ControlPeticiones cPeticiones;
    private LocalDate fechaIncial;
    private LocalDate fechaFinal;

    /**
     * Constructor de VistaListarExcursiones.
     *
     * @param vistaListarExcursiones ControlExcursiones asociado a la vista.
     * @param cDatos ControlDatos asociado a la vista.
     */
    // Constructor
    public VistaListarExcursiones(VistaListarExcursiones vistaListarExcursiones) {
        this.cExcursiones = new ControlExcursiones(cExcursiones);
        this.cPeticiones = new ControlPeticiones(vistaListarExcursiones.getControlPeticiones());
    }

    public VistaListarExcursiones(ControlExcursiones cExcursiones) {
        this.cExcursiones = new ControlExcursiones(cExcursiones);
        this.cPeticiones = new ControlPeticiones(cExcursiones.getControlPeticiones());
    }

    public VistaListarExcursiones() {
        this.cExcursiones = null;
        this.cPeticiones = null;
    }

    // Getters
    public ControlExcursiones getControlExcursiones() {
        return cExcursiones;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    // Setters

    public void setControlExcursiones(ControlExcursiones cExcursiones) {
        this.cExcursiones = cExcursiones;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    
    /**
     * Método para mostrar el menú de listar excursiones y solicitar una opción.
     */
    // Métodos
    public void show() {
        // Mostramos el menú
        System.out.println("Menu Listar Excursiones");
        System.out.println("1. Listar Excursiones");
        System.out.println("2. Listar Excursiones por Fecha");
        System.out.println("0. Atrás");
        // Pedimos la opción
        switch (cPeticiones.pedirEntero("Introduzca una opción: ",0,2)) {
            // Si la opción es 1, listamos las excursiones
            case 1:
                buttonListExcursiones();
                break;
            // Si la opción es 2, listamos las excursiones entre dos fechas
            case 2:
                buttonListExcursionesFechas();
                break;
            // Si la opción es 0, volvemos al menú de excursiones
            case 0:
                buttonAtras();
                break;
            // Si la opción no es ninguna de las anteriores, mostramos un mensaje de error
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    /**
     * Método que nos permite listar todas las excursiones
     */
    public void buttonListExcursiones() {
        // Llamamos al método de ControlExcursiones que lista las excursiones
        cExcursiones.listExcursiones();
    }

    /**
     * Método que nos permite listar las excursiones entre dos fechas
     */
    public void buttonListExcursionesFechas(){
        // Pedimos las fechas
        fechaIncial = cPeticiones.pedirFecha("Introduzca la fecha inicial: ");
        fechaFinal = cPeticiones.pedirFecha("Introduzca la fecha final: ");
        // Llamamos al método de ControlExcursiones que lista las excursiones entre dos fechas
        cExcursiones.listExcursionesFechas(fechaIncial, fechaFinal);
    }

    /**
     * Método que nos permite ir hacia atras
     */
    public void buttonAtras(){
        // Mostramos mensaje de vuelta
        System.out.println("Volviendo al menú de excursiones...");
        // Salimos del menú
        return;
    }


}