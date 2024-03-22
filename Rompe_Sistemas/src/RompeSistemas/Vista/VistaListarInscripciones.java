package RompeSistemas.Vista;

import java.util.Date;
import java.util.Scanner;

public class VistaListarInscripciones {


    //Atributos
    private int numeroSocio;
    private Date FechaInicial;
    private Date FechaFinal;
    private String tboxListado;
    private Scanner scan = new Scanner(System.in);

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
     * Constructor por defecto de la clase VistaListarInscripciones
     */
    public VistaListarInscripciones() {
    }

    //Métodos
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

        boolean running = true;

        while (running) {


            System.out.println("........MENÚ LISTAR INSCRIPCIONES........\n");
            System.out.println("Seleccione una opción: ");
            System.out.println("0. Atrás");
            System.out.println("1. Listar inscripción por usuario");
            System.out.println("2. Listar inscripción por fechas");

            switch (scan.nextLine()) {
                case "1":
                    buttonListInscripcionesUsuario();
                    break;

                case "2":
                    buttonListInscripcionesFechas();
                    break;
                case "0":
                    buttonAtras();
                    running = false;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
