package RompeSistemas.Modelo;

import java.time.LocalDate;

/**
 * Clase que representa una excursión.
 *
 * @param <C> tipo genérico para el código de la excursión
 * @param <D> tipo genérico para la descripción de la excursión
 * @param <F> tipo genérico para la fecha de la excursión
 * @param <R> tipo genérico para la duración de la excursión
 * @param <P> tipo genérico para el precio de la excursión
 */
public class Excursion<C, D, F, R, P> {

    private C codigo;
    private D descripcion;
    private F fecha;
    private R duracion;
    private P precio;

    // Métodos constructores

    /**
     * Constructor de la clase Excursion que recibe parámetros para inicializar los atributos.
     *
     * @param codigo      código de la excursión
     * @param descripcion descripción de la excursión
     * @param fecha       fecha de la excursión
     * @param duracion    duración de la excursión
     * @param precio      precio de la excursión
     */
    public Excursion(C codigo, D descripcion, F fecha, R duracion, P precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.duracion = duracion;
        this.precio = precio;
    }

    /**
     * Constructor por defecto de la clase Excursion.
     */
    public Excursion() {
    }

    // Métodos Getters

    /**
     * Obtiene el código de la excursión.
     *
     * @return el código de la excursión
     */
    public C getCodigo() {
        return codigo;
    }

    /**
     * Obtiene la descripción de la excursión.
     *
     * @return la descripción de la excursión
     */
    public D getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la fecha de la excursión.
     *
     * @return la fecha de la excursión
     */
    public F getFecha() {
        return fecha;
    }

    /**
     * Obtiene la duración de la excursión.
     *
     * @return la duración de la excursión
     */
    public R getDuracion() {
        return duracion;
    }

    /**
     * Obtiene el precio de la excursión.
     *
     * @return el precio de la excursión
     */
    public P getPrecio() {
        return precio;
    }

    // Métodos Setters

    /**
     * Establece el código de la excursión.
     *
     * @param codigo el código de la excursión
     */
    public void setCodigo(C codigo) {
        this.codigo = codigo;
    }

    /**
     * Establece la descripción de la excursión.
     *
     * @param descripcion la descripción de la excursión
     */
    public void setDescripcion(D descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece la fecha de la excursión.
     *
     * @param fecha la fecha de la excursión
     */
    public void setFecha(F fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece la duración de la excursión.
     *
     * @param duracion la duración de la excursión
     */
    public void setDuracion(R duracion) {
        this.duracion = duracion;
    }

    /**
     * Establece el precio de la excursión.
     *
     * @param precio el precio de la excursión
     */
    public void setPrecio(P precio) {
        this.precio = precio;
    }

    /**
     * Método toString que devuelve una representación en cadena de los datos de la excursión.
     *
     * @return una cadena con los datos de la excursión
     */
    @Override
    public String toString() {
        return "Código: " + codigo + "\nDescripción: " + descripcion + "\nFecha: " + fecha + "\nDuración: " + duracion + "\nPrecio: " + precio;
    }
}
