package RompeSistemas.Vista;

public class VistaModificarSeguro<S, T> {

    private S numeroSocio;
    private T tipoSeguro;

    /**
     * Método constructor de la clase VistaModificarSeguro que recibe por parámetros el número de socio y el tipo de seguro
     * @param numeroSocio es el número de socio
     * @param tipoSeguro es el tipo de seguro
     */
    public VistaModificarSeguro(S numeroSocio, T tipoSeguro) {
        this.numeroSocio = numeroSocio;
        this.tipoSeguro = tipoSeguro;
    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    void buttonVistaModificar(){

    }

    /**
     * Método para añadir un botón que nos permite seleccionar el tipo de seguro
     */
    void selectTipoSeguro(){

    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras(){

    }

}
