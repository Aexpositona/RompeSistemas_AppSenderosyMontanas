package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Modelo.Socio;

import java.text.ParseException;
import java.util.Scanner;
import java.util.List;

public class VistaListarSocios {
    // Atributos
    private ControlSocios cSocios;

    private VistaSocios vistaSocios;

    /**
     * Método constructor de la clase VistaListarSocios que recibe por parámetros el tipo de socio y el listado de socios
     */
    public VistaListarSocios(ControlSocios cSocios, VistaSocios vistaSocios) {
        this.cSocios = cSocios;

        this.vistaSocios = vistaSocios;
    }


    /**
     * Método para mostrar la vista de listar socios
     */
    public void show() throws ParseException {
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
        String socios = cSocios.listTipoSocios(tipoSocio);
        System.out.println(socios);
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
    public void buttonAtras() throws ParseException {
        System.out.println("Volviendo a la vista anterior");
        vistaSocios.show();
    }

}