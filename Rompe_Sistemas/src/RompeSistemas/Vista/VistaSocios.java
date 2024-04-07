package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Modelo.Datos;

import java.text.ParseException;

public class VistaSocios {

    private VistaModificarSeguro vModificarSeguro;
    private VistaListarSocios vListarSocios;
    private VistaAddSocio vAddSocio;
    private ControlSocios cSocios;
    private ControlPeticiones cPeticiones;
    private ControlDatos cDatos;
    private Datos datos;


    /**
     * Método constructor de la clase VistaSocios que recibe por parámetros el controlador de socios
     * @param cSocios es el controlador de socios
     */
    public VistaSocios(ControlSocios cSocios) {
        this.cSocios = new ControlSocios(cSocios);
        this.vModificarSeguro = cSocios.getVistaModificarSeguro();
        this.vListarSocios =cSocios.getVistaListarSocios();
        this.vAddSocio = cSocios.getVistaAddSocio();
        this.cPeticiones = cSocios.getControlPeticiones() ;
        this.cDatos = new ControlDatos(cSocios.getControlDatos());
        this.datos = new Datos(cSocios.getDatos());
    }

    public VistaSocios(VistaSocios vistaSocios) {
        this.cSocios = vistaSocios.getControlSocios();
        this.vModificarSeguro = vistaSocios.getVistaModificarSeguro();
        this.vListarSocios = vistaSocios.getVistaListarSocios();
        this.vAddSocio = vistaSocios.getVistaAddSocio();
        this.cPeticiones = vistaSocios.getControlPeticiones();
        this.cDatos = vistaSocios.getControlDatos();
        this.datos = vistaSocios.getDatos();
    }

    public VistaSocios() {
        this.cSocios = null;
        this.vModificarSeguro = null;
        this.vListarSocios = null;
        this.vAddSocio = null;
        this.cPeticiones = null;
        this.cDatos = null;
        this.datos = null;
    }

    // Getters

    public ControlSocios getControlSocios() {
        return cSocios;
    }

    public VistaModificarSeguro getVistaModificarSeguro() {
        return vModificarSeguro;
    }

    public VistaListarSocios getVistaListarSocios() {
        return vListarSocios;
    }

    public VistaAddSocio getVistaAddSocio() {
        return vAddSocio;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    public ControlDatos getControlDatos() {
        return cDatos;
    }

    public Datos getDatos() {
        return datos;
    }

    // Setters

    public void setControlSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
    }

    public void setVistaModificarSeguro(VistaModificarSeguro vModificarSeguro) {
        this.vModificarSeguro = vModificarSeguro;
    }

    public void setVistaListarSocios(VistaListarSocios vListarSocios) {
        this.vListarSocios = vListarSocios;
    }

    public void setVistaAddSocio(VistaAddSocio vAddSocio) {
        this.vAddSocio = vAddSocio;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    /**
     * Método para añadir un botón que nos permite añadir un socio
     */
    public void buttonAddSocio() throws ParseException {
        System.out.println("Navegando a la vista de añadir socio");
        vAddSocio.show();
    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */

    public void buttonRemoveSocio() {
        String numeroSocio = cPeticiones.pedirString("Introduce el número de socio que quieres eliminar: ");
        try {
            if (!cDatos.checkExistenciaObjeto(2, numeroSocio)) {
                cSocios.removeSocio(3, numeroSocio);
            } else {
                txtMostrarMensaje("El socio está asociado a una inscripción. No se puede eliminar.");
            }
        } catch (NumberFormatException e) {
            txtMostrarMensaje("El número de socio debe ser un número entero. Inténtelo de nuevo.");
        }
    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    public void buttonModTipoSeguro() throws ParseException {
        txtMostrarMensaje("Navegando a la vista de modificar seguro");
        vModificarSeguro.show();
    }

    /**
     * Método para añadir un botón que nos permite listar los socios
     */
    public void ButtonListSocios() throws ParseException {
        txtMostrarMensaje("Navegando a la vista de listar socios...\n\n");
        vListarSocios.show();
    }

    /**
     * Método para añadir un botón que nos permite mostrar la información de los socios
     */
    public void buttonShowFacturaMensualSocios(){
        txtMostrarMensaje("-- Mostrando la factura mensual de los socios --\n\n");
        cSocios.showFacturaMensualSocios();
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() throws ParseException {
        txtMostrarMensaje("Volviendo a la vista anterior\n\n");
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
     * Método para mostrar la vista de socios
     */
    public void show() throws ParseException {
        boolean running = true;
        while (running) {
            txtMostrarMensaje("************ MENú SOCIOS ************\n");
            txtMostrarMensaje("1. Añadir socio\n");
            txtMostrarMensaje("2. Eliminar socio\n");
            txtMostrarMensaje("3. Modificar tipo de seguro\n");
            txtMostrarMensaje("4. Listar socios\n");
            txtMostrarMensaje("5. Mostrar factura mensual de los socios\n");
            txtMostrarMensaje("0. Atrás\n");
            switch (cPeticiones.pedirEntero("Seleccione una opción: (1, 2, 3, 4, 5 o 0): ", 0, 5)) {
                case 1:
                    buttonAddSocio();
                    break;
                case 2:
                    buttonRemoveSocio();
                    break;
                case 3:
                    buttonModTipoSeguro();
                    break;
                case 4:
                    ButtonListSocios();
                    break;
                case 5:
                    buttonShowFacturaMensualSocios();
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
