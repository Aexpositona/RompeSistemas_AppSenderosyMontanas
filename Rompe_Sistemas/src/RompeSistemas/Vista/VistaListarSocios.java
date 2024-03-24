package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Modelo.Socio;

import java.util.Scanner;
import java.util.List;

public class VistaListarSocios {
    // Atributos
    private ControlSocios cSocios;
    private int tipoSocio;
    private String tboxListado;
    private VistaSocios vistaSocios;

    /**
     * Método constructor de la clase VistaListarSocios que recibe por parámetros el tipo de socio y el listado de socios
     * @param tipoSocio es el tipo de socio
     * @param tboxListado es el listado de socios
     */
    public VistaListarSocios(int tipoSocio, String tboxListado) {
        this.tipoSocio = tipoSocio;
        this.tboxListado = tboxListado;
    }

    /**
     * Constructor por defecto de la clase VistaListarSocios
     */
    public VistaListarSocios() {
    }

    /**
     * Método para mostrar la vista de listar socios
     */
    public void show() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Listar tipos de socios");
            System.out.println("2. Listar socios");
            System.out.println("0. Atrás");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    buttonListTipoSocio();
                    break;
                case "2":
                    buttonListSocios();
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
     * Método para añadir un botón que nos permite listar los tipos de socios
     */
    public void buttonListTipoSocio(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el tipo de socio que desea ver (Federado, Infantil, Estandard):");
        String tipoSocio = scanner.nextLine();
        System.out.println("Listando los socios de tipo " + tipoSocio + "...");
        List<Socio> socios = cSocios.listTipoSocios(tipoSocio);
        for (Socio socio : socios) {
            System.out.println(socio.toString());
        }
    }

    /**
     * Método para añadir un botón que nos permite listar los socios
     */
    public void buttonListSocios(){
        System.out.println("Listando los socios...");
        List<Socio> socios = cSocios.listSocios();
        for (Socio socio : socios) {
            System.out.println(socio.toString());
        }
    }
    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() {
        System.out.println("Volviendo a la vista anterior");
        vistaSocios.show();
    }

}