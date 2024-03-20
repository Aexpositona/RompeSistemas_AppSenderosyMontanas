package RompeSistemas.Vista;

import java.util.Date;

/**
 * Clase que representa la vista para listar inscripciones.
 * @param <N> Tipo de dato que representa el número de socio.
 * @param <F> Tipo de dato que representa la fecha.
 * @param <T> Tipo de dato que representa el listado de inscripciones.
 */
public class VistaListarInscripciones<N, F, T> {

    private N numeroSocio;
    private F fechaInicial;
    private F fechaFinal;
    private T tboxListado;

    /**
     * Método constructor de la clase VistaListarInscripciones que recibe por parámetros el número de socio, la fecha inicial, la fecha final y el listado de inscripciones.
     * @param numeroSocio es el número de socio.
     * @param fechaInicial es la fecha inicial.
     * @param fechaFinal es la fecha final.
     * @param tboxListado es el listado de inscripciones.
     */
    public VistaListarInscripciones(N numeroSocio, F fechaInicial, F fechaFinal, T tboxListado) {
        this.numeroSocio = numeroSocio;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.tboxListado = tboxListado;
    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones de un usuario.
     */
    public void buttonListInscripcionesUsuario(){

    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones por fechas.
     */
    public void buttonListInscripcionesFechas(){

    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás.
     */
    public void buttonAtras() {

    }

    /**
     * Método para mostrar la vista.
     */
    public void show() {
        // TODO
    }
}
