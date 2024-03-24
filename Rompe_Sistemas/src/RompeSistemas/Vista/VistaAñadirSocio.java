package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;

import java.util.Scanner;

public class VistaAñadirSocio {

    //Atributos
    private int tipoSocio;
    private int numeroSocio;
    private String nombre;
    private VistaSocios vistaSocios;
    private ControlSocios cSocios;


    /**
     * Método constructor de la clase VistaAñadirSocio que recibe por parámetros el tipo de socio, el número de socio y el nombre del socio
     * @param tipoSocio Es el tipo de socio
     * @param numeroSocio Es el número de socio
     * @param nombre Es el nombre del socio
     */
    public VistaAñadirSocio(int tipoSocio, int numeroSocio, String nombre) {
        this.tipoSocio = tipoSocio;
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
        this.vistaSocios = vistaSocios;
        this.cSocios = cSocios;

    }

    /**
     * Método para mostrar la vista de añadir socio
     */
    public void show() {
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
        int tipo = scanner.nextInt();

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
    public void buttonAtras(){
        System.out.println("Volviendo a la vista anterior...");
        vistaSocios.show();
    }

}
