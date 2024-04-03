package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Controlador.ControlExcursiones;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Modelo.Excursion;
import java.text.ParseException;
import java.util.Scanner;

public class VistaExcursiones {

    // Atributos
    public VistaAddExcursion vAddExcursion;
    public VistaListarExcursiones vListarExcursiones;
    private Scanner scanner;
    private String respuesta;
    private ControlDatos cDatos;
    private ControlExcursiones cExcursiones;
    private ControlPeticiones cPeticiones;
    private VistaMenuPrincipal vMenuPrincipal;

    /**
     * Constructor de VistaExcursiones.
     *
     * @param cExcursiones ControlExcursiones asociado a la vista.
     * @param cDatos ControlDatos asociado a la vista.
     * @param cPeticiones ControlPeticiones asociado a la vista.
     * @param vMenuPrincipal VistaMenuPrincipal asociada a la vista.
     */
    // Constructor
    public VistaExcursiones(ControlExcursiones cExcursiones, ControlDatos cDatos, ControlPeticiones cPeticiones, VistaMenuPrincipal vMenuPrincipal) {
        this.cExcursiones = cExcursiones;
        this.cDatos = cDatos;
        this.vMenuPrincipal = vMenuPrincipal;
        this.vAddExcursion = new VistaAddExcursion(cExcursiones, cDatos, cPeticiones);
        this.vListarExcursiones = new VistaListarExcursiones(cExcursiones, cDatos, cPeticiones);
        this.scanner = new Scanner(System.in);
        this.cPeticiones = cPeticiones;
    }

    /**
     * Método para añadir una excursión.
     *
     * @throws ParseException Excepción de parseo.
     */
    private void buttonAddExcursion() throws ParseException {
        System.out.println("Accediendo a la vista de añadir excursión...");
        vAddExcursion.show();
    }

    /**
     * Método para eliminar una excursión.
     */
    private void buttonRemoveExcursion(){
        // Variables internas
        boolean resultado = false;
        // Mostramos las excursiones
        cExcursiones.listExcursiones();
        // Pedimos el código de la excursión a eliminar
        System.out.println();
        do {
            respuesta = cPeticiones.pedirString("Introduzca el código de la excursión a eliminar: ");
            if (cDatos.checkCodigoObjeto(respuesta, 1)) {
                if (cDatos.checkExistenciaObjeto(respuesta, 1))
                resultado = true;
                else {
                    System.out.println("El código no existe.");
                }
            }
            else {
                System.out.println("El código no es válido.");
            }
       }
        while (!resultado);
        resultado = false;
        do{
            if (cPeticiones.pedirString("¿Está seguro de que desea eliminar la excursión? (S/N): ").equalsIgnoreCase("S")){
                cExcursiones.removeExcursion(respuesta);
                resultado = true;
            }
            else if (cPeticiones.pedirString("¿Está seguro de que desea eliminar la excursión? (S/N): ").equalsIgnoreCase("N")){
                resultado = false;
            }
            else {
                System.out.println("Opción no válida.");
            }
        }
        while (!resultado);
    }

    /**
     * Método para listar las excursiones.
     */
    private void buttonListExcursiones(){
        vListarExcursiones.show();
    }

    /**
     * Método para calcular el precio de una excursión.
     * @param excursion Excursión a calcular.
     * @return Precio de la excursión.
     */
    private float precioExcursion(Excursion excursion){
        return 0.0f;
    }

    /**
     * Método para volver al menú principal.
     *
     * @throws ParseException Excepción de parseo.
     */
    private void buttonAtras() throws ParseException {
        // Informamos al usuario de que volvemos al menú principal
        System.out.println("Volviendo al menú principal...");
        // Mostramos el menú principal
        vMenuPrincipal.show();
    }

    /**
     * Método para mostrar la vista.
     *
     * @throws ParseException Excepción de parseo.
     */
    public void show() throws ParseException {
        // Declaramos una variable para controlar el bucle
        boolean running = true;
        // Mientras el bucle esté activo
        while (running) {
            System.out.println("Menú de excursiones");
            System.out.println("1. Añadir excursión");
            System.out.println("2. Listar excursiones");
            System.out.println("3. Eliminar excursión");
            System.out.println("0. Atrás");
            // Pedimos una opción
            switch (cPeticiones.pedirEntero("Selecciona una opción (1, 2, 3 o 0):",0,3)){
                // Si la opción es 1, añadimos una excursión
                case 1:
                    buttonAddExcursion();
                    break;
                // Si la opción es 2, listamos las excursiones
                case 2:
                    buttonListExcursiones();
                    break;
                // Si la opción es 3, eliminamos una excursión
                case 3:
                    buttonRemoveExcursion();
                    break;
                // Si la opción es 0, volvemos al menú principal
                case 0:
                    buttonAtras();
                    running = false;
                    break;
                // Si la opción no es válida, informamos al usuario
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}