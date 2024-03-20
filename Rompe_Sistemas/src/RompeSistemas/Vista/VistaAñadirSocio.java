package RompeSistemas.Vista;

public class VistaAñadirSocio<T> {

    // Atributos
    private T tipoSocio;
    private int numeroSocio;
    private String nombre;
    private int numeroSocioTutor;
    private String nif;

    /**
     * Constructor de la clase VistaAñadirSocio que recibe por parámetros el tipo de socio, el número de socio, el nombre del socio, el número de socio del tutor y el NIF.
     * @param tipoSocio     El tipo de socio
     * @param numeroSocio   El número de socio
     * @param nombre        El nombre del socio
     * @param numeroSocioTutor   El número de socio del tutor
     * @param nif           El NIF del socio
     */
    public VistaAñadirSocio(T tipoSocio, int numeroSocio, String nombre, int numeroSocioTutor, String nif) {
        this.tipoSocio = tipoSocio;
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
        this.numeroSocioTutor = numeroSocioTutor;
        this.nif = nif;
    }

    /**
     * Método para añadir un botón que nos permite añadir un socio
     */
    public void buttonAñadir() {
        // Lógica para el botón "Añadir"
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() {
        // Lógica para el botón "Atrás"
    }

    public void show() {
        // Método para mostrar la vista
    }

}

