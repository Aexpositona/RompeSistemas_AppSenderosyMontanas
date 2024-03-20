package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;

public class VistaListarSocios {
    // Atributos
    private ControlSocios cSocios;
    private int tipoSocio;
    private String tboxListado;

    /**
     * Método constructor de la clase VistaListarSocios que recibe por parámetros el tipo de socio y el listado de socios
     * @param tipoSocio es el tipo de socio
     * @param tboxListado es el listado de socios
     */
    public VistaListarSocios(int tipoSocio, String tboxListado) {
        tipoSocio = tipoSocio;
        this.tboxListado = tboxListado;
    }

    /**
     * Método para añadir un botón que nos permite listar los tipos de socios
     */
    public void buttonListTipoSocio(){

    }

    /**
     * Método para añadir un botón que nos permite listar los socios
     */
    public void buttonListSocios(){

    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() {

    }

    public void show() {
        //TODO
    }


}
