package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Modelo.Datos;

import java.util.Scanner;
import java.text.ParseException;

public class VistaSocios {

    private VistaModificarSeguro vModificarSeguro;
    private VistaListarSocios vListarSocios;
    private VistaAddSocio vAñadirSocio;
    private ControlSocios cSocios;
    private ControlPeticiones cPeticiones;
    private ControlDatos cDatos;
    private Datos datos;


    /**
     * Método constructor de la clase VistaSocios que recibe por parámetros el controlador de socios
     * @param cSocios es el controlador de socios
     */
    public VistaSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
        this.vModificarSeguro = cSocios.getVistaModificarSeguro();
        this.vListarSocios = cSocios.getVistaListarSocios();
        this.vAñadirSocio = cSocios.getVistaAddSocio();
        this.cPeticiones = cSocios.getControlPeticiones();
        this.cDatos = cSocios.getControlDatos();
        this.datos = cSocios.getDatos();
    }

    public VistaSocios(VistaSocios vistaSocios) {
        this.cSocios = vistaSocios.getControlSocios();
        this.vModificarSeguro = vistaSocios.getVistaModificarSeguro();
        this.vListarSocios = vistaSocios.getVistaListarSocios();
        this.vAñadirSocio = vistaSocios.getVistaAddSocio();
        this.cPeticiones = vistaSocios.getControlPeticiones();
        this.cDatos = vistaSocios.getControlDatos();
        this.datos = vistaSocios.getDatos();
    }

    public VistaSocios() {
        this.cSocios = null;
        this.vModificarSeguro = null;
        this.vListarSocios = null;
        this.vAñadirSocio = null;
        this.cPeticiones = null;
        this.cDatos = null;
        this.datos = null;
    }

    // Getters

    public ControlSocios getControlSocios() {
        return cSocios;
    }

    public VistaModificarSeguro getVistaModificarSeguro() {
        return vModificarSeguro;
    }

    public VistaListarSocios getVistaListarSocios() {
        return vListarSocios;
    }

    public VistaAddSocio getVistaAddSocio() {
        return vAñadirSocio;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    public ControlDatos getControlDatos() {
        return cDatos;
    }

    public Datos getDatos() {
        return datos;
    }

    // Setters

    public void setControlSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
    }

    public void setVistaModificarSeguro(VistaModificarSeguro vModificarSeguro) {
        this.vModificarSeguro = vModificarSeguro;
    }

    public void setVistaListarSocios(VistaListarSocios vListarSocios) {
        this.vListarSocios = vListarSocios;
    }

    public void setVistaAddSocio(VistaAddSocio vAñadirSocio) {
        this.vAñadirSocio = vAñadirSocio;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    /**
     * Método para mostrar la vista de socios
     */
    public void show() throws ParseException {
        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Añadir socio");
            System.out.println("2. Eliminar socio");
            System.out.println("3. Modificar tipo de seguro");
            System.out.println("4. Listar socios");
            System.out.println("5. Mostrar factura mensual de los socios");
            System.out.println("0. Atrás");
            switch (cPeticiones.pedirEntero("Seleccione una opción: (1, 2, 3, 4, 5 o 0): ", 0, 5)) {
                case 1:
                    buttonAddSocio();
                    break;
                case 2:
                    buttonRemoveSocio();
                    break;
                case 3:
                    buttonModTipoSeguro();
                    break;
                case 4:
                    ButtonListSocios();
                    break;
                case 5:
                    buttonShowFacturaMensualSocios();
                    break;
                case 0:
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
        System.out.println("Introduce el número de socio que quieres eliminar: ");
        String numeroSocioStr = scanner.nextLine();
        try {
            int numeroSocio = Integer.parseInt(numeroSocioStr);
            if (!cDatos.isSocioInInscripcion(numeroSocio)) {
                cSocios.removeSocio(3, numeroSocio);
            } else {
                System.out.println("El socio está asociado a una inscripción. No se puede eliminar.");
            }
        } catch (NumberFormatException e) {
            System.out.println("El número de socio debe ser un número entero. Inténtelo de nuevo.");
        }
    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    public void buttonModTipoSeguro() throws ParseException {
        System.out.println("Navegando a la vista de modificar seguro");
        vModificarSeguro.show();
    }

    /**
     * Método para añadir un botón que nos permite listar los socios
     */
    public void ButtonListSocios() throws ParseException {
        System.out.println("Navegando a la vista de listar socios");
        vListarSocios.show();
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
        return;
    }

}
