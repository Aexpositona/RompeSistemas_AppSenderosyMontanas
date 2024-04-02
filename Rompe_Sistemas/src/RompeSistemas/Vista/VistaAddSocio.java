package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaAddSocio {

    //Atributos
    private VistaSocios vistaSocios;
    private ControlSocios cSocios;


    /**
     * Método constructor de la clase VistaAddSocio que recibe por parámetros el tipo de socio, el número de socio y el nombre del socio
     */
    public VistaAddSocio(ControlSocios cSocios, VistaSocios vistaSocios) {
        this.cSocios = cSocios;
        this.vistaSocios = vistaSocios;
    }


    /**
     * Método para mostrar la vista de añadir socio
     */
    public void show() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Añadir socio");
            System.out.println("0. Atrás");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    buttonAñadir();
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
     * Método para añadir un botón que nos permite añadir un socio
     */

    public void buttonAñadir() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué tipo de socio quieres crear? (1: Federado, 2: Infantil, 3: Estandar)");
        int tipo;
        while (true) {
            try {
                tipo = scanner.nextInt();
                break; // will only reach here if input was an int, so break out of loop
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduzca un número válido.");
                scanner.next(); // discard non-int input
            }
        }
        switch (tipo) {
            case 1:
                cSocios.addFederado();
                break;
            case 2:
                cSocios.addInfantil();
                break;
            case 3:
                cSocios.addEstandar();
                break;
            default:
                System.out.println("Tipo de socio no válido.");
        }
    }


    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() throws ParseException {
        System.out.println("Volviendo a la vista anterior...");
        vistaSocios.show();
    }

}
