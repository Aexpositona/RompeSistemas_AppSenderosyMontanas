package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Controlador.ControlExcursiones;
import RompeSistemas.Controlador.ControlPeticiones;
import java.time.LocalDate;

/**
 * VistaListarExcursiones es la clase que muestra el menú de listar excursiones y solicita una opción.
 */
public class VistaListarExcursiones {
    // Atributos
    private ControlExcursiones cExcursiones;
    private ControlDatos cDatos;
    private ControlPeticiones cPeticiones;
    private LocalDate fechaIncial;
    private LocalDate fechaFinal;
    private String tboxListado;

    /**
     * Constructor de VistaListarExcursiones.
     *
     * @param cExcursiones ControlExcursiones asociado a la vista.
     * @param cDatos ControlDatos asociado a la vista.
     */
    // Constructor
    public VistaListarExcursiones(ControlExcursiones cExcursiones, ControlDatos cDatos, ControlPeticiones cPeticiones) {
        this.cExcursiones = cExcursiones;
        this.cDatos = cDatos;
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
            case 1:
                buttonListExcursiones();
                break;
            case 2:
                buttonListExcursionesFechas();
                break;
            case 0:
                buttonAtras();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    /**
     * Método que nos permite listar todas las excursiones
     */
    public void buttonListExcursiones() {
        cExcursiones.listExcursiones();
    }

    /**
     * Método que nos permite listar las excursiones entre dos fechas
     */
    public void buttonListExcursionesFechas(){
        fechaIncial = cPeticiones.pedirFecha();
        fechaFinal = cPeticiones.pedirFecha();
        cExcursiones.listExcursionesFechas(fechaIncial, fechaFinal);
    }

    /**
     * Método que nos permite ir hacia atras
     */
    public void buttonAtras(){
        System.out.println("Volviendo al menú de excursiones...");
        return;
    }


}