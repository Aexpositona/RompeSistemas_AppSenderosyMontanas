package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Seguro;
import java.text.ParseException;

/**
 * Clase VistaModificarSeguro que nos permite modificar un seguro
 */
public class VistaModificarSeguro {

    private ControlSocios cSocios;
    private ControlPeticiones cPeticiones;
    private ControlDatos cDatos;
    private Datos datos;
    /**
     * Método constructor de la clase VistaModificarSeguro que recibe por parámetros el número de socio y el tipo de seguro
     */
    public VistaModificarSeguro(ControlSocios cSocios) {
        this.cSocios = cSocios;
        this.cPeticiones = cSocios.getControlPeticiones();
        this.datos = cSocios.getDatos();
        this.cDatos = cSocios.getControlDatos();
    }

    public VistaModificarSeguro(VistaModificarSeguro vistaModificarSeguro) {
        this.cSocios = vistaModificarSeguro.getControlSocios();
        this.cPeticiones = vistaModificarSeguro.getControlPeticiones();
        this.datos = vistaModificarSeguro.getDatos();
        this.cDatos = vistaModificarSeguro.getControlDatos();
    }

    public VistaModificarSeguro() {
        this.cSocios = null;
        this.cPeticiones = null;
        this.datos = null;
        this.cDatos = null;
    }

    // Getters

    public ControlSocios getControlSocios() {
        return cSocios;
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

    // Setters

    public void setControlSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
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

    // Métodos

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    // En VistaModificarSeguro.java
    void buttonModificarSeguro(){
        String numeroSocio; 
        int tipoSeguro;
        boolean valido = false;
        do{
            // Mostramos los socios
            txtMostrarMensaje("\n");
            cSocios.listSocios();
            txtMostrarMensaje("\n");
            // Solicitamos el número de socio al que se le va a modificar el seguro
            numeroSocio = cPeticiones.pedirString("Introduzca el número de socio al que se le va a modificar el seguro: ");
            // Si el número de socio es válido, existe y es un usuario Estandar, se puede modificar el seguro
            if (cDatos.checkCodigoObjeto(3, numeroSocio) && cDatos.checkExistenciaObjeto(3, numeroSocio)) {
                valido = true;
            } 
            else if (!cDatos.checkCodigoObjeto(3, numeroSocio)) {
                txtMostrarMensaje("El número de socio introducido no es válido. Inténtelo de nuevo.\n");
            } 
            else if (!cDatos.checkExistenciaObjeto(3, numeroSocio)) {
                txtMostrarMensaje("El número de socio introducido no existe. Inténtelo de nuevo.\n");
            }
            else {
                txtMostrarMensaje("El número de socio introducido no es un usuario Estandar. Inténtelo de nuevo.\n");
            }
        }
        while (!valido);
        cSocios.listSeguros();
        // Solicitamos el tipo de seguro que se le va a asignar al socio
        tipoSeguro = cPeticiones.pedirEntero("Introduzca el tipo de seguro que se le va a asignar al socio: ", 1, Seguro.values().length);
        cSocios.modifySeguro(tipoSeguro, numeroSocio);
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() throws ParseException {
        txtMostrarMensaje("Volviendo a la vista anterior\n\n");
        return;
    }


    /**
     * Método para mostrar un mensaje.
     *
     * @param mensaje Mensaje a mostrar.
     */
    public void txtMostrarMensaje(String mensaje){
        System.out.print(mensaje);
    }

    /**
     * Método para mostrar la vista de modificar seguro
     */
    public void show() throws ParseException {
        boolean running = true;
        while (running) {
            txtMostrarMensaje("************ MENú MODIFICAR SEGURO ************\n");
            txtMostrarMensaje("1. Modificar seguro\n");
            txtMostrarMensaje("0. Atrás\n");
            switch (cPeticiones.pedirEntero("Seleccione una opción(1 o 0): ", 0, 1)) {
                case 1:
                    buttonModificarSeguro();
                    break;
                case 0:
                    buttonAtras();
                    running = false;
                    break;
                default:
                    txtMostrarMensaje("Opción no válida. Intente de nuevo.n");
                    break;
            }
        }
    }

}
