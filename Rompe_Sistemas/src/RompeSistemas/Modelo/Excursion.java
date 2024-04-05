package RompeSistemas.Modelo;

import java.time.LocalDate;

/**
 * Clase que representa una excursión.
 */
public class Excursion {

    private String codigo, descripcion;
    private LocalDate fecha;
    private int duracion;
    private float precio;

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
    public Excursion(String codigo, String descripcion, LocalDate fecha, int duracion, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.duracion = duracion;
        this.precio = precio;
    }
    /**
     * Constructor de la clase Excursion que recibe un objeto de la misma clase para copiar los atributos.
     *
     * @param excursion objeto de la clase Excursion
     */
    public Excursion(Excursion excursion) {
        this.codigo = excursion.codigo;
        this.descripcion = excursion.descripcion;
        this.fecha = excursion.fecha;
        this.duracion = excursion.duracion;
        this.precio = excursion.precio;
    }

    // Métodos Getters

    /**
     * Obtiene el código de la excursión.
     *
     * @return el código de la excursión
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene la descripción de la excursión.
     *
     * @return la descripción de la excursión
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la fecha de la excursión.
     *
     * @return la fecha de la excursión
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Obtiene la duración de la excursión.
     *
     * @return la duración de la excursión
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Obtiene el precio de la excursión.
     *
     * @return el precio de la excursión
     */
    public double getPrecio() {
        return precio;
    }

    // Métodos Setters

    /**
     * Establece el código de la excursión.
     *
     * @param codigo el código de la excursión
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Establece la descripción de la excursión.
     *
     * @param descripcion la descripción de la excursión
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece la fecha de la excursión.
     *
     * @param fecha la fecha de la excursión
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece la duración de la excursión.
     *
     * @param duracion la duración de la excursión
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Establece el precio de la excursión.
     *
     * @param precio el precio de la excursión
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Método toString que devuelve una representación en cadena de los datos de la excursión.
     *
     * @return una cadena con los datos de la excursión
     */
    @Override
    public String toString() {
        return "Código: " + codigo +
               "\nDescripción: " + descripcion +
               "\nFecha: " + fecha +
               "\nDuración: " + duracion +
               "\nPrecio: " + precio;
    }
}
