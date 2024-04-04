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
        cSocios.listTipoSocios(); 
    }

    /**
     * Método para añadir un botón que nos permite listar los socios
     */
    private void buttonListSocios(){
        cSocios.listSocios();
    }
    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    private void buttonAtras() throws ParseException {
        System.out.println("Volviendo a la vista anterior");
        return;
    }

}