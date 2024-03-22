package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlExcursiones;

public class VistaExcursiones {

    public VistaAñadirExcursion vVistaAñadirExcursion;
    public VistaListarExcursiones vVistaListarExcursiones;

    /**
     * Método constructor de la clase VistaExcursiones que recibe por parámetros la vista de añadir excursión y la vista de listar excursiones
     * @param vVistaAñadirExcursion es la vista de añadir excursión
     * @param vVistaListarExcursiones es la vista de listar excursiones
     */
    public VistaExcursiones(VistaAñadirExcursion vVistaAñadirExcursion, VistaListarExcursiones vVistaListarExcursiones) {
        this.vVistaAñadirExcursion = vVistaAñadirExcursion;
        this.vVistaListarExcursiones = vVistaListarExcursiones;
    }

    public VistaExcursiones(ControlExcursiones cExcursiones) {
    }

    /**
     * Método para añadir un botón que nos permite añadir una excursión
     */
    void buttonAddExcursion(){

    }

    /**
     * Método para añadir un botón que nos permite listar las excursiones
     */
    void buttonRemoveExcursion(){

    }

    /**
     * Método para añadir un botón que nos permite listar las excursiones
     */
    void buttonListExcursionesFechas(){

    }

    /**
     * Método para añadir un botón que nos permite listar las excursiones
     */
    void precioExcursion(){

    }

    /**
     * Método para añadir un botón que nos permite listar las excursiones
     */
    void buttonAtras(){

    }

    public void show() {
        //TODO
    }


}