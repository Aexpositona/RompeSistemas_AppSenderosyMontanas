package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Modelo.Socio;

import java.text.ParseException;
import java.util.Scanner;
import java.util.List;

public class VistaListarSocios {
    // Atributos
    private ControlSocios cSocios;


    public VistaListarSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
    }


    /**
     * Método para mostrar la vista de listar socios
     */
    public void show() throws ParseException {
        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Listar tipos de socios");
            System.out.println("2. Listar socios");
            System.out.println("0. Atrás");
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
        socios = cSocios.listTipoSocios(); // Actualiza la variable socios con la lista de socios filtrados
    }

    /**
     * Método para añadir un botón que nos permite listar los socios
     */
    public void buttonListSocios(){
        socios = cSocios.listSocios();
        System.out.println("Listando los socios...");
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