package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Controlador.ControlExcursiones;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Modelo.Excursion;

import java.text.ParseException;
import java.util.Scanner;

public class VistaExcursiones {

    public VistaAddExcursion vAddExcursion;
    public VistaListarExcursiones vListarExcursiones;
    private Scanner scanner;
    private String respuesta;
    private ControlDatos cDatos;
    private ControlExcursiones cExcursiones;
    private ControlPeticiones cPeticiones;
    private VistaMenuPrincipal vMenuPrincipal;

    public VistaExcursiones(ControlExcursiones cExcursiones, ControlDatos cDatos, ControlPeticiones cPeticiones) {
        this.cExcursiones = cExcursiones;
        this.cDatos = cDatos;
        this.vAddExcursion = new VistaAddExcursion(cExcursiones, cDatos, cPeticiones);
        this.vListarExcursiones = new VistaListarExcursiones(cExcursiones, cDatos, cPeticiones);
        this.scanner = new Scanner(System.in);
    }

    private void buttonAddExcursion() throws ParseException {
        System.out.println("Accediendo a la vista de añadir excursión...");
        vAddExcursion.show();
    }

    private void buttonRemoveExcursion(){
        cExcursiones.listExcursiones();
        System.out.println("Introduzca el código de la excursión a eliminar: ");
        do {
            cDatos.checkCodigoObjeto(respuesta = scanner.nextLine(), 1);
            cDatos.checkObjeto(respuesta, 1);
        }
        while (!cDatos.checkCodigoObjeto(respuesta,1));
        cExcursiones.removeExcursion(respuesta);
    }

    private void buttonListExcursiones(){
        vListarExcursiones.show();
    }

    private float precioExcursion(Excursion excursion){
        return 0.0f;
    }

    private void buttonAtras() throws ParseException {
        System.out.println("Volviendo al menú principal...");
        vMenuPrincipal.show();
    }

    public void show() throws ParseException {

        boolean running = true;
        while (running) {
            System.out.println("Menú de excursiones");
            System.out.println("1. Añadir excursión");
            System.out.println("2. Listar excursiones");
            System.out.println("3. Eliminar excursión");
            System.out.println("0. Atrás");

            switch (cPeticiones.pedirEntero("Selecciona una opción (1, 2, 3 o 0):",0,3)){
                case 1:
                    buttonAddExcursion();
                    break;
                case 2:
                    buttonListExcursiones();
                    break;
                case 3:
                    buttonRemoveExcursion();
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
}