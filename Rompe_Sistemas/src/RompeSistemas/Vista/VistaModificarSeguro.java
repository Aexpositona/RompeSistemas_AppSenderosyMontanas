package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;

import java.text.ParseException;
import java.util.Scanner;

public class VistaModificarSeguro {


    private VistaSocios vistaSocios;
    private ControlSocios controlSocios;
    /**
     * Método constructor de la clase VistaModificarSeguro que recibe por parámetros el número de socio y el tipo de seguro
     */
    public VistaModificarSeguro(ControlSocios controlSocios, VistaSocios vistaSocios) {
        this.controlSocios = controlSocios;
        this.vistaSocios = vistaSocios;
    }



    public void show() throws ParseException {
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
    public void buttonAtras() throws ParseException {
        System.out.println("Volviendo a la vista anterior");
        vistaSocios.show();
    }

}
