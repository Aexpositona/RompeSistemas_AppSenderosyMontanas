package RompeSistemas.Vista;

public class VistaListarSocios<C, L> {

    // Atributos
    private C controlador;
    private String tipoSocio;
    private L listaSocios;

    /**
     * Método constructor de la clase VistaListarSocios que recibe por parámetros el controlador, el tipo de socio y el listado de socios.
     * @param controlador el controlador asociado a la vista
     * @param tipoSocio el tipo de socio
     * @param listaSocios el listado de socios
     */
    public VistaListarSocios(C controlador, String tipoSocio, L listaSocios) {
        this.controlador = controlador;
        this.tipoSocio = tipoSocio;
        this.listaSocios = listaSocios;
    }

    /**
     * Método para añadir un botón que nos permite listar los tipos de socios.
     */
    public void buttonListarTiposSocio(){

    }

    /**
     * Método para añadir un botón que nos permite listar los socios.
     */
    public void buttonListarSocios(){

    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás.
     */
    public void buttonAtras() {

    }

    public void show() {
        //TODO
    }
}
