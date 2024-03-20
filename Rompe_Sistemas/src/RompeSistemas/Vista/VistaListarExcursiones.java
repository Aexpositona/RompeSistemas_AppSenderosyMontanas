package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlExcursiones;

import java.util.Date;

/**
 * Clase que representa la vista para listar excursiones.
 * @param <C> Tipo de dato que representa el controlador de excursiones.
 * @param <F> Tipo de dato que representa la fecha.
 * @param <T> Tipo de dato que representa el listado de excursiones.
 */
public class VistaListarExcursiones<C, F, T> {
    // Atributos
    private C cExcursiones;
    private F fechaInicial;
    private F fechaFinal;
    private T tboxListado;

    /**
     * Método constructor de la clase VistaListarExcursiones que recibe por parámetros el controlador de excursiones, la fecha inicial, la fecha final y el listado de excursiones.
     * @param cExcursiones es el controlador de excursiones.
     * @param fechaInicial es la fecha inicial.
     * @param fechaFinal es la fecha final.
     * @param tboxListado es el listado de excursiones.
     */
    public VistaListarExcursiones(C cExcursiones, F fechaInicial, F fechaFinal, T tboxListado) {
        this.cExcursiones = cExcursiones;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.tboxListado = tboxListado;
    }

    /**
     * Método para mostrar la vista.
     */
    public void show() {
        // TODO
    }

    /**
     * Método para añadir un botón que nos permite listar las excursiones por fecha.
     */
    public void buttonListExcursionesFechas() {
        // TODO
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás.
     */
    public void buttonAtras() {
        // TODO
    }

    /**
     * Método para añadir un botón que nos permite listar las excursiones.
     */
    public void buttonListExcursiones() {
        // TODO
    }
}
