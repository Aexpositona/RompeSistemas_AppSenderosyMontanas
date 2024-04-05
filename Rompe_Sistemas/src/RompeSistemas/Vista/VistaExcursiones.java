package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Controlador.ControlExcursiones;
import RompeSistemas.Controlador.ControlPeticiones;
import java.text.ParseException;

public class VistaExcursiones {

    // Atributos
    private VistaAddExcursion vAddExcursion;
    private VistaListarExcursiones vListarExcursiones;
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
    public VistaExcursiones(ControlExcursiones cExcursiones) {
        this.cExcursiones = cExcursiones;
        this.cDatos = cExcursiones.getApp().cDatos;
        this.cPeticiones = cExcursiones.getApp().cPeticiones;
        this.vAddExcursion = cExcursiones.getVistaAddExcursion();
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
        int intentos = 0;
        // Mostramos las excursiones
        cExcursiones.listExcursiones();
        // Pedimos el código de la excursión a eliminar
        System.out.println();
        // Mientras no se introduzca un código válido o no se pueda eliminar la excursión
        String respuesta;
        do {
            // Solicitamos el código de la excursión
            respuesta = cPeticiones.pedirString("Introduzca el código de la excursión a eliminar: ");
            // Si el código es válido
            if (cDatos.checkCodigoObjeto(1,respuesta)) {
                // Si el código existe
                if (cDatos.checkExistenciaObjeto(1, respuesta))
                    // Cambiamos el resultado a verdadero
                    resultado = true;
                else {
                    System.out.println("El código no existe.");
                }
            }
            else {
                System.out.println("El código no es válido.");
            }
            intentos++;
        }
        while (!resultado && intentos < 3);
        // Reinicamos el resultado
        resultado = false;
        // Reiniciamos los intentos si no se han superado anteriormente
        if (intentos < 3) intentos = 0;
        // Mientras no se haya confirmado o abortado la operación y no se hayan realizado más de 3 intentos
        do{
            // Si el usuario está seguro de eliminar la excursión
            if (cPeticiones.pedirString("¿Está seguro de que desea eliminar la excursión? (S/N): ").equalsIgnoreCase("S")){
                // Eliminamos la excursión
                cExcursiones.removeExcursion(respuesta);
                // Informamos al usuario de que la excursión ha sido eliminada
                System.out.println("Excursión eliminada.");
                // Cambiamos el resultado a verdadero
                resultado = true;
            }
            // Si el usuario no está seguro de eliminar la excursión
            else if (cPeticiones.pedirString("¿Está seguro de que desea eliminar la excursión? (S/N): ").equalsIgnoreCase("N")){
                // Informamos al usuario de que la operación no se ha realizado
                System.out.println("Operación cancelada.");
                // Cambiamos el resultado a verdadero
                resultado = true;
            }
            // Si la respuesta no es válida
            else {
                // Informamos al usuario
                System.out.println("Opción no válida.");
                // Incrementamos los intentos
                intentos++;
            }
        }
        while (!resultado && intentos < 3);

        // Si se han realizado demasiados intentos
        if (intentos == 3){
            // Informamos al usuario y volvemos al menú excursiones
            System.out.println("Demasiados intentos. Volviendo al menú excursiones...");
        }
    }

    /**
     * Método para listar las excursiones.
     */
    private void buttonListExcursiones(){
        // Informamos al usuario de que accedemos a la vista de listar excursiones
        System.out.println("Accediendo a la vista de listar excursiones...");
        // Mostramos la vista de listar excursiones
        vListarExcursiones.show();
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