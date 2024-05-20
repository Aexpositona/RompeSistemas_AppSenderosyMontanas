package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlInscripciones;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Modelo.Inscripcion;

import java.sql.SQLException;
import java.text.ParseException;

public class VistaInscripciones {
    //Atributos
    private ControlInscripciones cInscripciones;
    private VistaListarInscripciones vListarInscripciones;
    private VistaAddInscripcion vAddInscripcion;
    private ControlPeticiones cPeticiones;

    //Constructores
    public VistaInscripciones(ControlInscripciones cInscripciones) {
        this.cInscripciones = cInscripciones;
        this.vAddInscripcion = cInscripciones.getVistaAddInscripcion();
        this.vListarInscripciones = cInscripciones.getVistaListarInscripciones();
        this.cPeticiones = cInscripciones.getControlPeticiones();
    }

    public VistaInscripciones(VistaInscripciones vistaInscripciones) {
        this.cInscripciones = vistaInscripciones.getControlInscripciones();
        this.vAddInscripcion = vistaInscripciones.getVistaAddInscripcion();
        this.vListarInscripciones = vistaInscripciones.getVistaListarInscripciones();
        this.cPeticiones = vistaInscripciones.getControlPeticiones();
    }

    public VistaInscripciones() {
        this.cInscripciones = null;
        this.vAddInscripcion = null;
        this.vListarInscripciones = null;
        this.cPeticiones = null;
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

    //Métodos

    /**
     * Método para añadir un botón que nos permite añadir una inscripción
     */
    public void buttonMenuAddInscripcion() throws SQLException {
        txtMostrarMensaje("Navegando a la vista de añadir inscripción...\n\n");
        vAddInscripcion.show();
    }

    /**
     * Método para añadir un botón que nos permite eliminar una inscripción
     */
    public void buttonRemoveInscripcion() throws SQLException {
        txtMostrarMensaje("\n-- Eliminando inscripción --\n\n");
        cInscripciones.listInscripciones();
        String idInscripcion = cPeticiones.pedirString("Introduzca el código de la inscripción a eliminar: ");
        if (cInscripciones.getControlDatos().checkExistenciaObjeto(2, idInscripcion)) {
            if (cPeticiones.pedirString("¿Está seguro de que desea eliminar la inscripción? (S/N): ").equalsIgnoreCase("S")) {
                cInscripciones.removeInscripcion(idInscripcion);
                txtMostrarMensaje("Inscripción eliminada correctamente.\n\n");
            } else {
                txtMostrarMensaje("Operación cancelada.\n");
            }
        } else {
            txtMostrarMensaje("El id introducido no es válido. Inténtelo de nuevo.\n\n");
        }
    }

    /**
     * Método para añadir un botón que nos permite listar las inscripciones
     */
    public void buttonMenuListInscripciones() throws SQLException {
        txtMostrarMensaje("Navegando a la vista de listar inscripciones...\n\n");
        vListarInscripciones.show();
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() {
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

    public void show() throws SQLException {
        boolean running = true;
        while (running) {
            txtMostrarMensaje("************ MENÚ INSCRIPCIONES ************\n");
            txtMostrarMensaje("1. Añadir inscripción\n");
            txtMostrarMensaje("2. Menú Listar inscripciones\n");
            txtMostrarMensaje("3. Eliminar inscripción\n");
            txtMostrarMensaje("0. Atrás\n");
            switch (cPeticiones.pedirEntero("Seleccione una opción (1, 2, 3 o 0):", 0, 3)) {
                case 1:
                    buttonMenuAddInscripcion();
                    break;
                case 2:
                    buttonMenuListInscripciones();
                    break;
                case 3:
                    buttonRemoveInscripcion();
                    break;
                case 0:
                    buttonAtras();
                    running = false;
                    break;
                default:
                    txtMostrarMensaje("Opción no válida. Intente de nuevo.\n");
                    break;
            }
        }
    }
}
