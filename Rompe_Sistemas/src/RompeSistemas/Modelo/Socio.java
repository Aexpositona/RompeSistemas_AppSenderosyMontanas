package RompeSistemas.Modelo;

/**
 * Clase abstracta que representa a un socio.
 *
 * @param <N> tipo genérico para el nombre del socio
 * @param <T> tipo genérico para el número de socio
 */
public abstract class Socio<N, T> {

    private N nombre;
    private T numero;

    // Constructores

    /**
     * Constructor de la clase Socio.
     *
     * @param nombre El nombre del cliente
     * @param numero El número del cliente
     */
    public Socio(N nombre, T numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    /**
     * Constructor vacío para generar sobrecarga de constructores.
     */
    public Socio() {

    }

    // Métodos Getters

    /**
     * Método get() que devuelve el nombre del cliente.
     *
     * @return El nombre del cliente
     */
    public N getNombre() {
        return nombre;
    }

    /**
     * Método get() que devuelve el número del cliente.
     *
     * @return El número del cliente
     */
    public T getNumero() {
        return numero;
    }

    // Métodos Setters

    /**
     * Método set() que permite definir el nombre del cliente.
     *
     * @param nombre El nombre del cliente
     */
    public void setNombre(N nombre) {
        this.nombre = nombre;
    }

    /**
     * Método set() que permite definir el número del cliente.
     *
     * @param numero El número del cliente
     */
    public void setNumero(T numero) {
        this.numero = numero;
    }

    /**
     * Método toString() que devuelve un String con los datos del cliente.
     *
     * @return Un String con los datos del cliente, como el nombre y el número de socio
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nNumero de socio: " + numero + "\n";
    }
}
