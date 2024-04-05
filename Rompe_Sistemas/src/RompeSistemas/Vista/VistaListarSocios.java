package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Controlador.ControlSocios;
import java.text.ParseException;

public class VistaListarSocios {
    // Atributos
    private ControlSocios cSocios;
    private ControlPeticiones cPeticiones;


    public VistaListarSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
        this.cPeticiones = cSocios.getControlPeticiones();
    }

    public VistaListarSocios(VistaListarSocios vistaListarSocios) {
        this.cSocios = vistaListarSocios.getControlSocios();
        this.cPeticiones = vistaListarSocios.getControlPeticiones();
    }

    public VistaListarSocios() {
        this.cSocios = null;
        this.cPeticiones = null;
    }

    // Getters

    public ControlSocios getControlSocios() {
        return cSocios;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    // Setters

    public void setControlSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }
    
    public void show() throws ParseException {
        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Listar tipos de socios");
            System.out.println("2. Listar socios");
            System.out.println("0. Atrás");
            switch (cPeticiones.pedirEntero("Seleccione una opción: (1, 2 o 0)", 0, 2)) {
                case 1:
                    buttonListTipoSocio();
                    break;
                case 2:
                    buttonListSocios();
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
     * Método para añadir un botón que nos permite listar los tipos de socios
     */
    private void buttonListTipoSocio(){
        cSocios.listTipoSocios(3, cPeticiones.pedirEntero("Introduzca el tipo de socio a listar: 1-Estandar, 2-Federado, 3-Infantil", 1, 3)); 
    }

    /**
     * Método para añadir un botón que nos permite listar los socios
     */
    private void buttonListSocios(){
        cSocios.listSocios(3);
    }
    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    private void buttonAtras() throws ParseException {
        System.out.println("Volviendo a la vista anterior");
        return;
    }

}