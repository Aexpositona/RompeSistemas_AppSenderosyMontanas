package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlInscripciones;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Modelo.Inscripcion;
import RompeSistemas.Modelo.Datos;

/**
 * Vista de inscripciones de la aplicación.
 *
 */
public class VistaInscripciones {
    //Atributos
    private ControlInscripciones cInscripciones;
    private VistaListarInscripciones vListarInscripciones; 
    private VistaAddInscripcion vAddInscripcion;
    private ControlPeticiones cPeticiones;
    private Datos datos;
    private ControlDatos cDatos;

    //Constructores
    /**
     * Método constructor de la clase VistaInscripciones que recibe por parámetros la vista de añadir inscripción y la vista de listar inscripciones
     *
     * @param cInscripciones ControlInscripciones
     */
    public VistaInscripciones(ControlInscripciones cInscripciones) {
        this.cInscripciones = new ControlInscripciones(cInscripciones);
        this.vAddInscripcion = new VistaAddInscripcion(cInscripciones.getVistaAddInscripcion());
        this.vListarInscripciones = new VistaListarInscripciones(cInscripciones.getVistaListarInscripciones());
        this.cPeticiones = new ControlPeticiones(cInscripciones.getControlPeticiones());
        this.datos = new Datos(cInscripciones.getDatos());
        this.cDatos = new ControlDatos(cInscripciones.getControlDatos());
    }

    /**
     * Método constructor de copia de la clase VistaInscripciones.
     *
     * @param vistaInscripciones VistaInscripciones a copiar.
     */
    public VistaInscripciones(VistaInscripciones vistaInscripciones) {
        this.cInscripciones = vistaInscripciones.getControlInscripciones();
        this.vAddInscripcion = vistaInscripciones.getVistaAddInscripcion();
        this.vListarInscripciones = vistaInscripciones.getVistaListarInscripciones();
        this.cPeticiones = vistaInscripciones.getControlPeticiones();
        this.datos = vistaInscripciones.getDatos();
        this.cDatos = vistaInscripciones.getControlDatos();
    }

    public VistaInscripciones() {
        this.cInscripciones = null;
        this.vAddInscripcion = null;
        this.vListarInscripciones = null;
        this.cPeticiones = null;
        this.datos = null;
        this.cDatos = null;
    }

    //Getters
    public ControlInscripciones getControlInscripciones() {
        return cInscripciones;
    }

    public VistaAddInscripcion getVistaAddInscripcion() {
        return vAddInscripcion;
    }

    public VistaListarInscripciones getVistaListarInscripciones() {
        return vListarInscripciones;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    public Datos getDatos() {
        return datos;
    }

    public ControlDatos getControlDatos() {
        return cDatos;
    }

    //Setters

    public void setControlInscripciones(ControlInscripciones cInscripciones) {
        this.cInscripciones = cInscripciones;
    }

    public void setVistaAddInscripcion(VistaAddInscripcion vAddInscripcion) {
        this.vAddInscripcion = vAddInscripcion;
    }

    public void setVistaListarInscripciones(VistaListarInscripciones vListarInscripciones) {
        this.vListarInscripciones = vListarInscripciones;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }

    //Métodos

    /**
     * Método para añadir un botón que nos permite añadir una inscripción
     */
    public void buttonMenuAddInscripcion() {
        txtMostrarMensaje("Navegando a la vista de añadir inscripción...\n\n");
        vAddInscripcion.show();
    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones
     */
    public void buttonRemoveInscripcion() {
        // Variables internas
        String idInscripcion;
        Inscripcion inscripcion;
        // Mostramos mensaje de añadir inscripción
        txtMostrarMensaje("\n-- Eliminando inscripción --\n\n");
        // Hasta que no se introduzca un id de socio válido, no se sale del bucle
        do {
            // Mostramos id y nombre de los socios
            cInscripciones.listInscripciones();
            // Mostramos mensaje de seleccionar socio
            txtMostrarMensaje("\n-- Seleccionando Incripción a eliminar --\n");
            // Pedimos los datos de la inscripción
            idInscripcion = cPeticiones.pedirString("Introduzca el código de la inscripción a eliminar: ");
            // Si el id introducido no es válido, mostramos mensaje de error
            if (!cInscripciones.getControlDatos().checkExistenciaObjeto(2, idInscripcion)) {
                txtMostrarMensaje("El id introducido no es válido. Inténtelo de nuevo.\n\n");
            } 
            // Si el id introducido es válido, creamos la inscripción y salimos del bucle
            else {
                inscripcion = (Inscripcion) cInscripciones.getDatos().getObjeto(2, cInscripciones.getDatos().buscarObjeto(2, idInscripcion));
                break;
            }
        } 
        while (true);
        // Eliminamos la inscripción        
        cInscripciones.removeInscripcion(inscripcion);
        // Mostramos mensaje de inscripción eliminada
        txtMostrarMensaje("Inscripción eliminada correctamente.\n\n");
    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones
     */
    public void buttonMenuListInscripciones() {
        txtMostrarMensaje("Navegando a la vista de listar inscripciones...\n\n");
        vListarInscripciones.show();
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() {
        // Informamos al usuario de que volvemos al menú principal
        txtMostrarMensaje("Volviendo al menú principal...\n\n");
    }

    /**
     * Método para mostrar un mensaje.
     *
     * @param mensaje Mensaje a mostrar.
     */
    public void txtMostrarMensaje(String mensaje) {
        System.out.print(mensaje);
    }

    public void show() {
        // Variables internas
        boolean running = true;
        // Mientras la aplicación esté en ejecución
        while (running) {
            // Mostramos el menú
            txtMostrarMensaje("************ MENÚ INSCRIPCIONES ************\n");
            txtMostrarMensaje("1. Añadir inscripción\n");
            txtMostrarMensaje("2. Menú Listar inscripciónes\n");
            txtMostrarMensaje("3. Eliminar inscripción\n");
            txtMostrarMensaje("0. Atrás\n");
            // Solicitamos la opción
            switch (cPeticiones.pedirEntero("Seleccione una opción (1, 2, 3 o 0):",0,3)) {
                // Si la opción es 1 mostramos el menú de añadir inscripción
                case 1:
                    buttonMenuAddInscripcion();
                    break;
                // Si la opción es 2 mostramos el menú de listar inscripciones
                case 2:
                    buttonMenuListInscripciones();
                    break;
                // Si la opción es 3 solicitamos el número de inscripción a eliminar
                case 3:
                    buttonRemoveInscripcion();
                    break;
                // Si la opción es 0 salimos de la aplicación
                case 0:
                    buttonAtras();
                    running = false;
                    break;
                // Si la opción no es válida mostramos un mensaje de error
                default:
                    txtMostrarMensaje("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}