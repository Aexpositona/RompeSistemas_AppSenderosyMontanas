package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Controlador.ControlExcursiones;
import RompeSistemas.Controlador.ControlPeticiones;
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
    private final ControlPeticiones cPeticiones; // Instancia de ControlPeticiones


    // Constructor
    /**
     * Constructor de la clase VistaAddExcursion.
     *
     * @param cExcursiones ControlExcursiones
     * @param cDatos ControlDatos
     */
    public VistaAddExcursion(ControlExcursiones cExcursiones, ControlDatos cDatos, ControlPeticiones cPeticiones){
        this.cExcursiones = cExcursiones;
        this.scanner = new Scanner(System.in);
        this.cDatos = cDatos;
        this.cPeticiones = cPeticiones;
    }

    /**
     * Método para añadir una excursión.
     *
     */
    public void buttonAddExcursion() {
        // Variables internas
        boolean resultado = false;
        String codigo, descripcion;
        LocalDate fecha;
        float precio;
        // Mientras no se introduzca un código válido o no se pueda añadir la excursión
        do {
            // Solicitamos el código de la excursión
            codigo = cPeticiones.pedirString("Introduzca el código de la excursión: ");
            // Si el código está vacío
            if (codigo.isEmpty()) {
                // Informamos al usuario
                System.out.println("El código no puede estar vacío.");
            }
            // Si el código no está vacío
            else {
                // Si el código es válido
                if (cDatos.checkCodigoObjeto(codigo,1)) {
                    // Si la excursión no existe
                    if (!cDatos.checkExistenciaObjeto(codigo,1)) {
                        // Informamos al usuario de que el código es válido
                        System.out.println("Código válido.");
                        // Cambiamos el resultado a verdadero
                        resultado = true;
                    }
                    // Si la excursión ya existe
                    else {
                        // Informamos al usuario
                        System.out.println("El código de la excursión ya existe.");
                    }
                }
                // Si el código no es válido
                else {
                    // Informamos al usuario
                    System.out.println("El código no puede estar vacío y ha de tener 5 caracteres.");
                    // Cambiamos el resultado a verdadero
                    resultado = true;
                }
            }
        }
        while (!resultado);
        // Cambiamos el resultado a falso
        resultado = false;
        // Mientras no se introduzca una descripción válida
        do {
            // Solicitamos la descripción de la excursión
            descripcion = cPeticiones.pedirString("Introduzca la descripción de la excursión: ");
            // Si la descripción no está vacía
            if (!descripcion.isEmpty()) {
                // Cambiamos el resultado a verdadero
                resultado = true;
            }
            // Si la descripción está vacía
            else {
                // Informamos al usuario
                System.out.println("La descripción no puede estar vacía.");
            }
        }
        while (!resultado);
        resultado = false;
        // Mientras no se introduzca una fecha válida
        do {
            // Solicitamos la fecha de la excursión
            fecha = cPeticiones.pedirFecha("Introduzca la fecha de la excursión: ");
        }
        while (fecha.isBefore(LocalDate.now()));
        // Mientras no se introduzca un precio válido
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
        // Variables internas
        boolean running = true;
        // Mientras se ejecute la vista
        while (running) {
            // Mostramos el menú
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Añadir excursión");
            System.out.println("0. Atrás");
            // Solicitamos la opción
            switch (cPeticiones.pedirEntero("Selecciona una opción (1 o 0):",0,1)) {
                // Si la opción es 1 añadimos una excursión
                case 1:
                    buttonAddExcursion();
                    break;
                // Si la opción es 0 volvemos al menú anterior
                case 0:
                    buttonAtras();
                    running = false;
                    break;
                // Si la opción no es válida informamos al usuario
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
