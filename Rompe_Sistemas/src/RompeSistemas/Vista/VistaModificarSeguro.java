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

    /**
     * Método para mostrar la vista de modificar seguro
     */
    public void show() throws ParseException {
        boolean running = true;
        while (running) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Modificar seguro");
            System.out.println("0. Atrás");
            switch (cPeticiones.pedirEntero("Seleccione una opción: (1 o 0)", 0, 1)) {
                case 1:
                    buttonVistaModificar();
                    break;
                case 0:
                    buttonAtras();
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    // En VistaModificarSeguro.java
    void buttonVistaModificar(){
        int numeroSocio, tipoSeguro;
        boolean valido = false;
        do{
            // Solicitamos el número de socio al que se le va a modificar el seguro
            numeroSocio = cPeticiones.pedirEntero("Introduzca el número de socio al que se le va a modificar el seguro: ", 1, datos.getArrayList(3).size());
            if (cDatos.checkCodigoObjeto(3, String.valueOf(numeroSocio)) && cDatos.checkExistenciaObjeto(3, String.valueOf(numeroSocio))) {
                valido = true;
            } else {
                System.out.println("El número de socio introducido no es válido. Inténtelo de nuevo.");
            }
        }
        while (!valido);
        // Solicitamos el tipo de seguro que se le va a asignar al socio
        tipoSeguro = cPeticiones.pedirEntero("Introduzca el tipo de seguro que se le va a asignar al socio:\n" + datos.getSeguro().toString(), 1, Seguro.values().length);
        cSocios.modificarSeguro(String.valueOf(numeroSocio), tipoSeguro);
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() throws ParseException {
        System.out.println("Volviendo a la vista anterior");
        return;
    }

}
