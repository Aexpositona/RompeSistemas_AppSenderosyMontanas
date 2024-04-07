package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Controlador.ControlExcursiones;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Modelo.Excursion;

import java.text.ParseException;
import java.time.LocalDate;

/**
 * Clase que representa la vista para añadir una excursión.
 *
 */
public class VistaAddExcursion {

    // Atributos
    private ControlExcursiones cExcursiones; // Instancia de ControlExcursiones
    private ControlDatos cDatos; // Instancia de ControlDatos
    private ControlPeticiones cPeticiones; // Instancia de ControlPeticiones


    // Constructor
    /**
     * Constructor de la clase VistaAddExcursion.
     *
     * @param cExcursiones ControlExcursiones
     */
    public VistaAddExcursion(ControlExcursiones cExcursiones) {
        this.cExcursiones = new ControlExcursiones(cExcursiones);
        this.cDatos = new ControlDatos(cExcursiones.getControlDatos());
        this.cPeticiones = new ControlPeticiones(cExcursiones.getControlPeticiones());
    }

    public VistaAddExcursion(VistaAddExcursion vistaAddExcursion) {
        this.cExcursiones = vistaAddExcursion.getControlExcursiones();
        this.cDatos = vistaAddExcursion.getControlDatos();
        this.cPeticiones = vistaAddExcursion.getControlPeticiones();
    }

    public VistaAddExcursion() {
        this.cExcursiones = null;
        this.cDatos = null;
        this.cPeticiones = null;
    }

    // Getters

    public ControlExcursiones getControlExcursiones() {
        return cExcursiones;
    }

    public ControlDatos getControlDatos() {
        return cDatos;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    public VistaAddExcursion getVistaAddExcursion() {
        return this;
    }

    // Setters

    public void setControlExcursiones(ControlExcursiones cExcursiones) {
        this.cExcursiones = cExcursiones;
    }

    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    
    /**
     * Método para añadir una excursión.
     *
     */
    public void buttonAddExcursion() {
        // Variables internas
        boolean resultado;
        String codigo, descripcion;
        LocalDate fecha;
        float precio;
        int dias;

        // Obtener el último código de excursión y sumarle 1
        codigo = cExcursiones.getUltimoCodigo();
        // Cambiamos el resultado a falso
        resultado = false;
        // Mientras no se introduzca una descripción válida
        do {
            // Solicitamos la descripción de la excursión
            descripcion = cPeticiones.pedirString("Introduzca la descripción de la excursión: ");
            // Si la descripción está vacía
            if (descripcion.length() < 5) {
                // Informamos al usuario de que la descripción no puede estar vacía
                System.out.println("Descripción inválida. La descripción no puede estar vacía y ha de tener al menos 5 caracteres.\n");
            }
            // Si la descripción no está vacía y tiene al menos 5 caracteres
            else {
                // Informamos al usuario
                System.out.println("Descripción guardada.\n");
                // Cambiamos el resultado a verdadero
                resultado = true;
            }
        }
        while (!resultado);
        // Mientras no se introduzca una fecha válida
        do {
            // Solicitamos la fecha de la excursión
            fecha = cPeticiones.pedirFecha("-- Introduzca a continuación la fecha de la excursión --");
            // Si la fecha es anterior a la actual
            if (fecha.isBefore(LocalDate.now())) {
                // Informamos al usuario
                System.out.println("La fecha no puede ser anterior a la actual.");
            }
        }
        while (fecha.isBefore(LocalDate.now()));
        // Mientras no se introduzca un precio válido
        precio = cPeticiones.pedirFloat("Introduzca el precio de la excursión: ", 0, Float.MAX_VALUE);
        // Mientras no se introduzca un número de días válido
        dias = cPeticiones.pedirEntero("Introduzca los días de la excursión: ", 1, 100);
        // Añadimos la excursión
        cExcursiones.addExcursion(new Excursion(codigo, descripcion, fecha, dias, precio));
        // Informamos al usuario
        System.out.println("Excursión añadida correctamente.\n");
    }

    /**
     * Método para añadir un botón que nos permite cancelar la operación.
     */
    public void buttonAtras() throws ParseException{
        // Informamos al usuario de que volvemos al menú de excursiones
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
            System.out.println("........MENÚ AÑADIR EXCURSIÓN........\n");
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
