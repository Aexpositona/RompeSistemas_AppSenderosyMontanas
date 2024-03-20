package RompeSistemas.Vista;

import java.util.Date;

public class VistaAñadirInscripcion {

    // Atributos
    private String codigo;
    private String descripcion;
    private Date fecha;
    private float precio;
    private int dias;

    /**
     * Constructor de la clase VistaAñadirInscripcion que recibe por parámetros el código, la descripción, la fecha, el precio y los días de la inscripción
     * @param codigo es el código de la inscripción
     * @param descripcion es la descripción de la inscripción
     * @param fecha es la fecha de la inscripción
     * @param precio es el precio de la inscripción
     * @param dias es la duración de la inscripción
     */
    public VistaAñadirInscripcion(String codigo, String descripcion, Date fecha, float precio, int dias) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.precio = precio;
        this.dias = dias;
    }

    /**
     * Método para añadir un botón que nos permite añadir una inscripción
     */
    public void buttonAñadir(){

    }

    /**
     * Método para añadir un botón que nos permite cancelar la operación
     */
    public void buttonCancelar() {

    }

    public void show() {
    }
}
