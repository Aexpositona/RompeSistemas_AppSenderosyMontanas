package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;

import java.util.Scanner;

public class VistaModificarSeguro {


    private int numeroSocio;
    private int tipoSeguro;
    private VistaSocios vistaSocios;
    private ControlSocios controlSocios;
    /**
     * Método constructor de la clase VistaModificarSeguro que recibe por parámetros el número de socio y el tipo de seguro
     * @param numeroSocio es el número de socio
     * @param tipoSeguro es el tipo de seguro
     */
    public VistaModificarSeguro(int numeroSocio, int tipoSeguro) {
        this.numeroSocio = numeroSocio;
        this.tipoSeguro = tipoSeguro;
    }

    /**
     * Constructor por defecto de la clase VistaModificarSeguro
     */
    public VistaModificarSeguro() {
    }


    public void show() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Modificar seguro");
            System.out.println("0. Atrás");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    buttonVistaModificar();
                    break;
                case "0":
                    buttonAtras();
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    // En VistaModificarSeguro.java
    void buttonVistaModificar(){
        controlSocios.modificarSeguro();
    }


    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() {
        System.out.println("Volviendo a la vista anterior");
        vistaSocios.show();
    }

}
