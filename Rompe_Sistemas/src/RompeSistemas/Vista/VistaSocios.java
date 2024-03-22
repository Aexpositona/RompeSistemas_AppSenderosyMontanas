package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;

import java.util.Scanner;

public class VistaSocios {

    //Atributos
    private VistaAñadirSocio vAñadirSocio;
    private VistaModificarSeguro vVistaModificarSeguro;
    private  VistaListarSocios vVistaListarSocios;
    private VistaMenuPrincipal vistaMenuPrincipal;

    private ControlSocios cSocios;

    /**
     * Método constructor de la clase VistaSocios que recibe por parámetros las vistas de añadir socio, modificar seguro y listar socios
     * @param vAñadirSocio es la vista de añadir socio
     * @param vVistaModificarSeguro es la vista de modificar seguro
     * @param vVistaListarSocios es la vista de listar socios
     */
    public VistaSocios(VistaAñadirSocio vAñadirSocio, VistaModificarSeguro vVistaModificarSeguro, VistaListarSocios vVistaListarSocios) {
        this.vAñadirSocio = vAñadirSocio;
        this.vVistaModificarSeguro = vVistaModificarSeguro;
        this.vVistaListarSocios = vVistaListarSocios;


    }

    public VistaSocios(ControlSocios cSocios) {
    }

    /**
     * Método para mostrar la vista de socios
     */
    public void show() {
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
    public void buttonAddSocio(){
        System.out.println("Navegando a la vista de añadir socio");
        vAñadirSocio.show();
    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    public void buttonRemoveSocio(){
        System.out.println("Selecciona el socio que quieres eliminar:");
        cSocios.removeSocio();
    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    public void buttonModTipoSeguro(){
        System.out.println("Navegando a la vista de modificar seguro");
        vVistaModificarSeguro.show();
    }

    /**
     * Método para añadir un botón que nos permite listar los socios
     */
    public void ButtonListSocios(){
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
    public void buttonAtras() {
        System.out.println("Volviendo a la vista anterior");
        vistaMenuPrincipal.show();
    }

}
