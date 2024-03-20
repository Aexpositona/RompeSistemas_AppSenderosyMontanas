package RompeSistemas.Modelo;

/**
 * Clase que representa una federación.
 *
 * @param <T> tipo de dato para el código
 * @param <U> tipo de dato para el nombre
 */
public class Federacion<T, U> {

    private T codigo;
    private U nombre;

    // Métodos constructores

    /**
     * Constructor de la clase Federacion que recibe parámetros para inicializar los atributos.
     *
     * @param codigo código de la federación
     * @param nombre nombre de la federación
     */
    public Federacion(T codigo, U nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    /**
     * Constructor por defecto de la clase Federacion.
     */
    public Federacion() {
    }

    // Métodos Getters

    /**
     * Obtiene el código de la federación.
     *
     * @return el código de la federación
     */
    public T getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el nombre de la federación.
     *
     * @return el nombre de la federación
     */
    public U getNombre() {
        return nombre;
    }

    // Métodos Setters

    /**
     * Establece el código de la federación.
     *
     * @param codigo el código de la federación
     */
    public void setCodigo(T codigo) {
        this.codigo = codigo;
    }

    /**
     * Establece el nombre de la federación.
     *
     * @param nombre el nombre de la federación
     */
    public void setNombre(U nombre) {
        this.nombre = nombre;
    }

    /**
     * Método toString que devuelve una representación en cadena de los datos de la federación.
     *
     * @return una cadena con los datos de la federación
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nCódigo: " + codigo;
    }
}
