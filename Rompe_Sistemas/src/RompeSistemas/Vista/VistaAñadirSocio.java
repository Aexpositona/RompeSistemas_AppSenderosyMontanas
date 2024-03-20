package RompeSistemas.Vista;

public class VistaAñadirSocio<T> {

    // Atributos
    private T tipoSocio;
    private int numeroSocio;
    private String nombre;


    /**
     * Constructor de la clase VistaAñadirSocio que recibe por parámetros el tipo de socio, el número de socio y el nombre del socio
     * @param tipoSocio Es el tipo de socio
     * @param numeroSocio Es el número de socio
     * @param nombre Es el nombre del socio
     */
    public VistaAñadirSocio(T tipoSocio, int numeroSocio, String nombre) {
        this.tipoSocio = tipoSocio;
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
    }

    /**
     * Método para añadir un botón que nos permite añadir un socio
     */
    public void buttonAñadir() {
    }


    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras(){

    }

    public void show() {
        // TODO: Implementar
    }

}
