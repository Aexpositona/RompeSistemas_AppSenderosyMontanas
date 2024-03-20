package RompeSistemas.Vista;

import java.util.Date;

/**
 * Clase que representa la vista para añadir una excursión.
 * @param <D> Tipo de dato que representa la fecha de la excursión.
 */
public class VistaAñadirExcursion<D> {
    // Atributos
    private String codigo;
    private String descripcion;
    private D fecha;
    private float precio;
    private int dias;

    /**
     * Método constructor de la clase VistaAñadirExcursion que recibe por parámetros el código, la descripción, la fecha, el precio y los días de la excursión.
     * @param codigo es el código de la excursión
     * @param descripcion es la descripción de la excursión
     * @param fecha es la fecha de la excursión
     * @param precio es el precio de la excursión
     * @param dias son los días de la excursión
     */
    public VistaAñadirExcursion(String codigo, String descripcion, D fecha, float precio, int dias) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.dias = dias;
    }

    /**
     * Método para añadir un botón que nos permite añadir una excursión.
     */
    public void buttonAñadir(){

    }

    /**
     * Método para añadir un botón que nos permite cancelar la operación.
     */
    public void buttonAtras() {

    }

    /**
     * Método para mostrar la vista.
     */
    public void show() {
    }
}
