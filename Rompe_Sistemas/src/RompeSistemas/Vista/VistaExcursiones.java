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

    /**
     * Constructor de VistaExcursiones.
     *
     * @param cExcursiones ControlExcursiones asociado a la vista.
     */
    // Constructor
    public VistaExcursiones(ControlExcursiones cExcursiones) {
        this.cExcursiones = new ControlExcursiones(cExcursiones);
        this.cDatos = new ControlDatos (cExcursiones.getControlDatos());
        this.cPeticiones = new ControlPeticiones(cExcursiones.getControlPeticiones());
        this.vAddExcursion = new VistaAddExcursion(cExcursiones.getVistaAddExcursion());
    }
    /**
     * Constructor de VistaExcursiones de copia.
     *
     * @param vistaExcursiones VistaExcursiones a copiar
     */
    public VistaExcursiones(VistaExcursiones vistaExcursiones) {
        this.cExcursiones = vistaExcursiones.getControlExcursiones();
        this.cDatos = vistaExcursiones.getControlDatos();
        this.cPeticiones = vistaExcursiones.getControlPeticiones();
        this.vAddExcursion = vistaExcursiones.getVistaAddExcursion();
        this.vListarExcursiones = vistaExcursiones.getVistaListarExcursiones();
    }
    /**
     * Constructor de VistaExcursiones vacío.
     */
    public VistaExcursiones() {
        this.cExcursiones = null;
        this.cDatos = null;
        this.cPeticiones = null;
        this.vAddExcursion = null;
    }

    // Getters

    /**
     * Método para obtener el controlador de excursiones.
     *
     * @return ControlExcursiones
     */
    public ControlExcursiones getControlExcursiones() {
        return cExcursiones;
    }

    /**
     * Método para obtener el controlador de datos.
     *
     * @return ControlDatos
     */
    public ControlDatos getControlDatos() {
        return cDatos;
    }

    /**
     * Método para obtener el controlador de peticiones.
     *
     * @return ControlPeticiones
     */
    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    /**
     * Método para obtener la vista de añadir excursión.
     *
     * @return VistaAddExcursion
     */
    public VistaAddExcursion getVistaAddExcursion() {
        return vAddExcursion;
    }

    /**
     * Método para obtener la vista de listar excursiones.
     *
     * @return VistaListarExcursiones
     */
    public VistaListarExcursiones getVistaListarExcursiones() {
        return vListarExcursiones;
    }

    // Setters

    /**
     * Método para establecer el controlador de excursiones.
     *
     * @param cExcursiones ControlExcursiones
     */
    public void setControlExcursiones(ControlExcursiones cExcursiones) {
        this.cExcursiones = cExcursiones;
    }

    /**
     * Método para establecer el controlador de datos.
     *
     * @param cDatos ControlDatos
     */
    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }  

    /**
     * Método para establecer el controlador de peticiones.
     *
     * @param cPeticiones ControlPeticiones
     */
    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    /**
     * Método para establecer la vista de añadir excursión.
     *
     * @param vAddExcursion VistaAddExcursion
     */
    public void setVistaAddExcursion(VistaAddExcursion vAddExcursion) {
        this.vAddExcursion = vAddExcursion;
    }

    /**
     * Método para establecer la vista de listar excursiones.
     *
     * @param vListarExcursiones VistaListarExcursiones
     */
    public void setVistaListarExcursiones(VistaListarExcursiones vListarExcursiones) {
        this.vListarExcursiones = vListarExcursiones;
    }

    // Métodos
    
    /**
     * Método para añadir una excursión.
     *
     * @throws ParseException Excepción de parseo.
     */
    private void buttonVistaAddExcursion() throws ParseException {
        txtMostrarMensaje("Accediendo a la vista de añadir excursión...");
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
        txtMostrarMensaje("");
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
                    txtMostrarMensaje("El código no existe.");
                }
            }
            else {
                txtMostrarMensaje("El código no es válido.");
            }
            intentos++;
        }
        while (!resultado && intentos < 3);

        // Si el usuario está seguro de eliminar la excursión
        if (cPeticiones.pedirString("¿Está seguro de que desea eliminar la excursión? (S/N): ").equalsIgnoreCase("S")){
            // Eliminamos la excursión
            cExcursiones.removeExcursion(respuesta);
            // Informamos al usuario de que la excursión ha sido eliminada
            txtMostrarMensaje("Excursión eliminada.");
        }
        // Si el usuario no está seguro de eliminar la excursión
        else if (cPeticiones.pedirString("¿Está seguro de que desea eliminar la excursión? (S/N): ").equalsIgnoreCase("N")){
            // Informamos al usuario de que la operación no se ha realizado
            txtMostrarMensaje("Operación cancelada.");
        }
    }

    /**
     * Método para listar las excursiones.
     */
    private void buttonVistaListExcursiones(){
        // Informamos al usuario de que accedemos a la vista de listar excursiones
        txtMostrarMensaje("Accediendo a la vista de listar excursiones...");
        // Mostramos la vista de listar excursiones
        vListarExcursiones.show();
    }

    /**
     * Método para volver al menú principal.
     */
    private void buttonAtras(){
        // Informamos al usuario de que volvemos al menú principal
        txtMostrarMensaje("Volviendo al menú principal...");
    }

    private void txtMostrarMensaje(String mensaje){
        System.out.println(mensaje);
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
            txtMostrarMensaje("************ Menú de excursiones ************");
            txtMostrarMensaje("1. Añadir excursión");
            txtMostrarMensaje("2. Listar excursiones");
            txtMostrarMensaje("3. Eliminar excursión");
            txtMostrarMensaje("0. Atrás");
            // Pedimos una opción
            switch (cPeticiones.pedirEntero("Selecciona una opción (1, 2, 3 o 0):",0,3)){
                // Si la opción es 1, añadimos una excursión
                case 1:
                    buttonVistaAddExcursion();
                    break;
                // Si la opción es 2, listamos las excursiones
                case 2:
                    buttonVistaListExcursiones();
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
                    txtMostrarMensaje("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}