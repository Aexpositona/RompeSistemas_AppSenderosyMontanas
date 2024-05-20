package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Controlador.ControlExcursiones;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Modelo.Excursion;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * Clase que representa la vista de excursiones de la aplicación.
 */
public class VistaExcursiones {

    // Atributos
    private VistaAddExcursion vAddExcursion;
    private VistaListarExcursiones vListarExcursiones;
    private ControlExcursiones cExcursiones;
    private ControlPeticiones cPeticiones;
    private ControlDatos controlDatos;

    /**
     * Constructor de VistaExcursiones.
     *
     * @param cExcursiones ControlExcursiones asociado a la vista.
     */
    public VistaExcursiones(ControlExcursiones cExcursiones) {
        this.cExcursiones = cExcursiones;
        this.cPeticiones = cExcursiones.getControlPeticiones();
        this.vAddExcursion = new VistaAddExcursion(cExcursiones.getVistaAddExcursion());
        this.vListarExcursiones = new VistaListarExcursiones(cExcursiones.getVistaListarExcursiones());
    }

    // Getters

    public ControlExcursiones getControlExcursiones() {
        return cExcursiones;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    public VistaAddExcursion getVistaAddExcursion() {
        return vAddExcursion;
    }

    public VistaListarExcursiones getVistaListarExcursiones() {
        return vListarExcursiones;
    }

    // Setters

    public void setControlExcursiones(ControlExcursiones cExcursiones) {
        this.cExcursiones = cExcursiones;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    public void setVistaAddExcursion(VistaAddExcursion vAddExcursion) {
        this.vAddExcursion = vAddExcursion;
    }

    public void setVistaListarExcursiones(VistaListarExcursiones vListarExcursiones) {
        this.vListarExcursiones = vListarExcursiones;
    }

    // Métodos

    /**
     * Método para añadir una excursión.
     *
     * @throws ParseException Excepción de parseo.
     */
    private void buttonVistaAddExcursion() throws ParseException, SQLException {
        txtMostrarMensaje("Accediendo a la vista de añadir excursión...\n");
        vAddExcursion.show();
    }

    /**
     * Método para eliminar una excursión.
     */
    private void buttonRemoveExcursion() throws SQLException {
        String codigoExcursion;
        txtMostrarMensaje("\n-- Eliminando excursión --\n\n");
        cExcursiones.listExcursiones();

        while (true) {
            txtMostrarMensaje("\n-- Seleccionando Excursión a eliminar --\n");
            codigoExcursion = cPeticiones.pedirString("Introduzca el código de la excursión a eliminar: ");
            if (cExcursiones.checkExistenciaExcursion(codigoExcursion)) {
                break;
            } else {
                txtMostrarMensaje("El código de la excursión no es válido. Inténtelo de nuevo.\n");
            }
        }

        if (cPeticiones.pedirConfirmacion("¿Está seguro de que desea eliminar la excursión? (S/N): ")) {
            Excursion excursion = cExcursiones.getExcursion(codigoExcursion);
            cExcursiones.removeExcursion(excursion);
            txtMostrarMensaje("Excursión eliminada correctamente.\n");
        } else {
            txtMostrarMensaje("Operación cancelada.\n");
        }
    }

    /**
     * Método para listar las excursiones.
     * @throws SQLException Excepción SQL.
     */
    private void buttonVistaListExcursiones() throws SQLException {
        txtMostrarMensaje("Accediendo a la vista de listar excursiones...\n");
        vListarExcursiones.show();
    }

    /**
     * Método para volver al menú principal.
     */
    private void buttonAtras() {
        txtMostrarMensaje("Volviendo al menú principal...\n");
    }

    /**
     * Método para mostrar un mensaje.
     *
     * @param mensaje Mensaje a mostrar.
     */
    private void txtMostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Método para mostrar la vista.
     *
     * @throws ParseException Excepción de parseo.
     */
    public void show() throws ParseException, SQLException {
        boolean running = true;
        while (running) {
            txtMostrarMensaje("************ MENÚ EXCURSIONES ************");
            txtMostrarMensaje("1. Añadir excursión");
            txtMostrarMensaje("2. Listar excursiones");
            txtMostrarMensaje("3. Eliminar excursión");
            txtMostrarMensaje("0. Atrás");
            switch (cPeticiones.pedirEntero("Seleccione una opción (1, 2, 3 o 0):", 0, 3)) {
                case 1:
                    buttonVistaAddExcursion();
                    break;
                case 2:
                    buttonVistaListExcursiones();
                    break;
                case 3:
                    buttonRemoveExcursion();
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

    public void setControlDatos(ControlDatos controlDatos) {
        this.controlDatos = controlDatos;
    }

    public ControlDatos getControlDatos() {
        return controlDatos;
    }
}
