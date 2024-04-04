package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Controlador.ControlPeticiones;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaAddSocio {

    //Atributos
    private ControlSocios cSocios;
    private ControlPeticiones cPeticiones;

    /**
     * Constructor de la clase VistaAddSocio que recibe por parámetros el controlador de socios
     * @param cSocios es el controlador de socios
     */
    public VistaAddSocio(ControlSocios cSocios) {
        this.cSocios = cSocios;
        this.cPeticiones = cSocios.getControlPeticiones();
    }

    /**
     * Método para mostrar la vista de añadir socio
     */
    public void show() throws ParseException {
        boolean running = true;
        while (running) {
            System.out.println("Menú de añadir socio:");
            System.out.println("1. Añadir socio");
            System.out.println("0. Atrás");
            switch (cPeticiones.pedirEntero("Seleccione una opción: ", 0, 1)) {
                case 1:
                    buttonAñadir();
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

    public void buttonAñadir() {
        // Variables internas
        boolean valido = false;
        do{
            System.out.println("Tipos de socio:");
            System.out.println("1. Estandar");
            System.out.println("2. Federado");
            System.out.println("3. Infantil");
            int tipoSocio = cPeticiones.pedirEntero("Introduzca el tipo de socio que desea añadir: ", 1, 3);
            
            if (tipoSocio == 1) {
                
            } 
            else if (tipoSocio == 2) {
                
            } 
            else if (tipoSocio == 3) {

            } 
            else {
                System.out.println("Tipo de socio no válido.");
            }
        }
        while(false);
        cSocios.addSocio();
    }

    public void buttonAtras() throws ParseException {
        System.out.println("Volviendo al menú de socios...");
        return;
    }

}
