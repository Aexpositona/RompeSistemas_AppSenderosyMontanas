package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlExcursiones;

import java.util.Date;

public class VistaListarExcursiones {
    // Atributos
    private ControlExcursiones cExcursiones;
    private Date fechaIncial;
    private Date fechaFinal;
    private String tboxListado;



    /**
     * Método constructor de la clase VistaListarExcursiones que recibe por parámetros la fecha inicial, la fecha final y el listado de excursiones
     * @param fechaIncial es la fecha inicial
     * @param fechaFinal es la fecha final
     * @param tboxListado es el listado de excursiones
     */

    public VistaListarExcursiones(ControlExcursiones cExcursiones, Date fechaIncial, Date fechaFinal, String tboxListado) {
        this.cExcursiones = cExcursiones;
        this.fechaIncial = fechaIncial;
        this.fechaFinal = fechaFinal;
        this.tboxListado = tboxListado;
    }

    // Métodos
    public void show() {
        //TODO
    }


    /**
     * Método para añadir un botón que nos permite listar las excursiones por fecha
     */
    public void buttonListExcursionesFechas(){

    }

    /**
     * Método para añadir un botón que nos permite ir hacia atras
     */
    public void buttonAtras(){

    }
    /**
     * Método para añadir un botón que nos permite listar las excursiones
     */
    public void buttonListExcursiones() {

    }

}