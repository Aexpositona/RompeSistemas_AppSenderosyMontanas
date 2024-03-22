package RompeSistemas.Vista;

import java.util.Date;

public class VistaListarInscripciones {


    private int numeroSocio;
    private Date FechaInicial;
    private Date FechaFinal;
    private String tboxListado;

    /**
     * Método constructor de la clase VistaListarInscripciones que recibe por parámetros el número de socio, la fecha inicial, la fecha final y el listado de inscripciones
     * @param numeroSocio es el número de socio
     * @param fechaInicial es la fecha inicial
     * @param fechaFinal es la fecha final
     * @param tboxListado es el listado de inscripciones
     */
    public VistaListarInscripciones(int numeroSocio, Date fechaInicial, Date fechaFinal, String tboxListado) {
        this.numeroSocio = numeroSocio;
        FechaInicial = fechaInicial;
        FechaFinal = fechaFinal;
        this.tboxListado = tboxListado;
    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones de un usuario

     */
    public void buttonListInscripcionesUsuario(){

    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones por fechas
     */
    public void buttonListInscripcionesFechas(){

    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() {

    }

    public void show() {
        // TODO
    }
}
