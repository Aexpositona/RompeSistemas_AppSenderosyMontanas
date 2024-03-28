package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Controlador.ControlExcursiones;

import java.time.LocalDate;

public class VistaListarExcursiones {
    // Atributos
    private ControlExcursiones cExcursiones;
    private ControlDatos cDatos;
    private LocalDate fechaIncial;
    private LocalDate fechaFinal;
    private String tboxListado;

    public VistaListarExcursiones(ControlExcursiones cExcursiones, ControlDatos cDatos) {
        this.cExcursiones = cExcursiones;
        this.cDatos = cDatos;
    }

    // Métodos
    public void show() {
        System.out.println("Menu Listar Excursiones");
        System.out.println("1. Listar Excursiones");
        System.out.println("2. Listar Excursiones por Fecha");
        System.out.println("0. Atras");
        System.out.println("Introduzca una opción: ");
        switch (tboxListado) {
            case "1":
                buttonListExcursiones();
                break;
            case "2":
                buttonListExcursionesFechas();
                break;
            case "0":
                buttonAtras();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

    }

    /**
     * Método para añadir un botón que nos permite listar las excursiones
     */
    public void buttonListExcursiones() {
        cExcursiones.listExcursiones();
    }
    /**
     * Método para añadir un botón que nos permite listar las excursiones por fecha
     */
    public void buttonListExcursionesFechas(){
        cExcursiones.listExcursionesFechas();
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atras
     */
    public void buttonAtras(){
        return;
    }


}