package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Controlador.ControlSocios;
import java.text.ParseException;

public class VistaListarSocios {
    // Atributos
    private ControlSocios cSocios;
    private ControlPeticiones cPeticiones;


    public VistaListarSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
        this.cPeticiones = cSocios.getControlPeticiones();
    }

    public VistaListarSocios(VistaListarSocios vistaListarSocios) {
        this.cSocios = vistaListarSocios.getControlSocios();
        this.cPeticiones = vistaListarSocios.getControlPeticiones();
    }

    public VistaListarSocios() {
        this.cSocios = null;
        this.cPeticiones = null;
    }

    // Getters

    public ControlSocios getControlSocios() {
        return cSocios;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    // Setters

    public void setControlSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    /**
     * Método para añadir un botón que nos permite listar los tipos de socios
     */
    private void buttonListTipoSocio(){
        txtMostrarMensaje(cSocios.listTipoSocios(3, cPeticiones.pedirEntero("Introduzca el tipo de socio a listar:\n 1.Estándar\n 2.Federado\n 3.Infantil\n Selecciona una opción: (1,2 o 3)", 1, 3)));
    }

    /**
     * Método para añadir un botón que nos permite listar los socios
     */
    private void buttonListSocios(){
        cSocios.listSocios(3);
    }
    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    private void buttonAtras() throws ParseException {
        txtMostrarMensaje("Volviendo a la vista anterior...\n\n");
    }

    /**
     * Método para mostrar un mensaje.
     *
     * @param mensaje Mensaje a mostrar.
     */
    private void txtMostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public void show() throws ParseException {
        boolean running = true;
        while (running) {
            txtMostrarMensaje("************ MENú LISTAR SOCIOS ************\n");
            txtMostrarMensaje("1. Listar tipos de socios\n");
            txtMostrarMensaje("2. Listar socios\n");
            txtMostrarMensaje("0. Atrás\n");
            switch (cPeticiones.pedirEntero("Seleccione una opción: (1, 2 o 0)", 0, 2)) {
                case 1:
                    buttonListTipoSocio();
                    break;
                case 2:
                    buttonListSocios();
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