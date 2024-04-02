package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Controlador.ControlExcursiones;
import RompeSistemas.Modelo.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Clase que representa la vista para añadir una excursión.
 *
 */
public class VistaAddExcursion {

    // Atributos
    private final Scanner scanner; // Scanner para leer la entrada del usuario
    private final ControlExcursiones cExcursiones; // Instancia de ControlExcursiones
    private final ControlDatos cDatos; // Instancia de ControlDatos


    // Constructor
    /**
     * Constructor de la clase VistaAddExcursion.
     *
     * @param cExcursiones ControlExcursiones
     * @param cDatos ControlDatos
     */
    public VistaAddExcursion(ControlExcursiones cExcursiones, ControlDatos cDatos){
        this.cExcursiones = cExcursiones;
        this.scanner = new Scanner(System.in);
        this.cDatos = cDatos;
    }

    /**
     * Método para añadir una excursión.
     *
     */
    public void buttonAddExcursion() {
        boolean resultado;
        String codigo, descripcion;
        LocalDate fecha;
        do {
            System.out.println("Introduzca el código de la excursión: ");
            codigo = scanner.nextLine();
            resultado = cDatos.validarCodigoExcursion(codigo);
        }
        while (!resultado);
        do {
            System.out.println("Introduzca la descripción de la excursión: ");
            descripcion = scanner.nextLine();
            if (!descripcion.isEmpty()) {
                resultado = true;
            } else {
                System.out.println("La descripción no puede estar vacía.");
                resultado = false;
            }
        }
        while (!resultado);
        do {
            System.out.println("Introduzca la fecha de la excursión: ");
            fecha = cDatos.pedirFecha();
        }
        while (fecha.isBefore(LocalDate.now()));
        float precio;
        do {
            System.out.println("Introduzca el precio de la excursión: ");
            precio = Float.parseFloat(scanner.nextLine());
        }
        while (precio <= 0);
        int dias;
        do {
            System.out.println("Introduzca los días de la excursión: ");
            dias = Integer.parseInt(scanner.nextLine());
        }
        while (dias <= 0);
        cExcursiones.addExcursion(new Excursion(codigo, descripcion, fecha, dias, precio));
    }

    /**
     * Método para añadir un botón que nos permite cancelar la operación.
     */
    public void buttonAtras() {
        System.out.println("Volviendo al menú de excursiones...");
    }

    /**
     * Método para mostrar la vista.
     */
    public void show() throws ParseException {

        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Añadir excursión");
            System.out.println("0. Atrás");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    buttonAddExcursion();
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
}
