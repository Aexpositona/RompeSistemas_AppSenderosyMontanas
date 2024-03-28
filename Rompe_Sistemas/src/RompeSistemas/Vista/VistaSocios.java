package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlMenuPrincipal;
import RompeSistemas.Controlador.ControlSocios;

import java.text.ParseException;
import java.util.Scanner;

public class VistaSocios {


    private VistaMenuPrincipal vistaMenuPrincipal;
    private VistaModificarSeguro vVistaModificarSeguro;
    private VistaListarSocios vVistaListarSocios;
    private VistaAñadirSocio vAñadirSocio;
    private ControlSocios cSocios;
    private ControlMenuPrincipal cMenuPrincipal;
    private VistaExcursiones vExcursiones;
    private VistaInscripciones vInscripciones;


    /**
     * Método constructor de la clase VistaSocios que recibe por parámetros el controlador de socios
     * @param cSocios es el controlador de socios
     */
    public VistaSocios(ControlSocios cSocios, ControlMenuPrincipal cMenuPrincipal, VistaExcursiones vExcursiones, VistaInscripciones vInscripciones) {
        this.cSocios = cSocios;
        this.cMenuPrincipal = cMenuPrincipal;
        this.vExcursiones = vExcursiones;
        this.vInscripciones = vInscripciones;
        this.vAñadirSocio = new VistaAñadirSocio(cSocios, this);
        this.vVistaModificarSeguro = new VistaModificarSeguro(cSocios, this);
        this.vVistaListarSocios = new VistaListarSocios(cSocios, this);
        this.vistaMenuPrincipal = new VistaMenuPrincipal(cMenuPrincipal, this, vExcursiones, vInscripciones);
    }

    /**
     * Método para mostrar la vista de socios
     */
    public void show() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Añadir socio");
            System.out.println("2. Eliminar socio");
            System.out.println("3. Modificar tipo de seguro");
            System.out.println("4. Listar socios");
            System.out.println("5. Mostrar factura mensual de los socios");
            System.out.println("0. Atrás");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    buttonAddSocio();
                    break;
                case "2":
                    buttonRemoveSocio();
                    break;
                case "3":
                    buttonModTipoSeguro();
                    break;
                case "4":
                    ButtonListSocios();
                    break;
                case "5":
                    buttonShowFacturaMensualSocios();
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
    public void buttonAddSocio() throws ParseException {
        System.out.println("Navegando a la vista de añadir socio");
        vAñadirSocio.show();
    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    public void buttonRemoveSocio() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número del socio que quieres eliminar:");
        int numeroSocio = scanner.nextInt();
        cSocios.removeSocio(numeroSocio);
    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    public void buttonModTipoSeguro() throws ParseException {
        System.out.println("Navegando a la vista de modificar seguro");
        vVistaModificarSeguro.show();
    }

    /**
     * Método para añadir un botón que nos permite listar los socios
     */
    public void ButtonListSocios() throws ParseException {
        System.out.println("Navegando a la vista de listar socios");
        vVistaListarSocios.show();
    }



    /**
     * Método para añadir un botón que nos permite mostrar la información de los socios
     */
    public void buttonShowFacturaMensualSocios(){
        System.out.println("Mostrando la factura mensual de los socios");
        cSocios.showFacturaMensualSocios();
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() throws ParseException {
        System.out.println("Volviendo a la vista anterior");
        vistaMenuPrincipal.show();
    }

}
