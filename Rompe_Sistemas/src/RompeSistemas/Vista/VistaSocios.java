package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;

public class VistaSocios<A, M, L> {

    // Atributos
    private A vAñadirSocio;
    private M vVistaModificarSeguro;
    private L vVistaListarSocios;

    /**
     * Método constructor de la clase VistaSocios que recibe por parámetros las vistas de añadir socio, modificar seguro y listar socios
     * @param vAñadirSocio es la vista de añadir socio
     * @param vVistaModificarSeguro es la vista de modificar seguro
     * @param vVistaListarSocios es la vista de listar socios
     */
    public VistaSocios(A vAñadirSocio, M vVistaModificarSeguro, L vVistaListarSocios) {
        this.vAñadirSocio = vAñadirSocio;
        this.vVistaModificarSeguro = vVistaModificarSeguro;
        this.vVistaListarSocios = vVistaListarSocios;
    }

    public VistaSocios(ControlSocios cSocios) {
    }

    /**
     * Método para añadir un botón que nos permite añadir un socio
     */
    public void buttonAddSocio(){

    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    public void buttonRemoveSocio(){

    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    public void buttonModTipoSeguro(){

    }

    /**
     * Método para añadir un botón que nos permite listar los socios
     */
    public void ButtonListSocios(){

    }

    /**
     * Método para añadir un botón que nos permite listar los tipos de socios
     */
    public void buttonListTipoSocios(){

    }

    /**
     * Método para añadir un botón que nos permite mostrar la información de los socios
     */
    public void buttonShowFacturaMensualSocios(){

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
