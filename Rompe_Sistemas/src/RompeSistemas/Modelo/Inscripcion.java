package RompeSistemas.Modelo;

import java.time.LocalDate;

/**
 * Clase Inscripción que contiene los datos de la inscripción de un socio a una excursión.
 */
public class Inscripcion {
    private String numero;
    private Socio socio;
    private Excursion excursion;
    private LocalDate fechaInscripcion;

    //Métodos constructores
    /**
     ** Método constructor de la clase Inscripcion que recibe por parámetros el número de inscripción, los socio y las excursion.
     * @param numero es el número que identifica la inscripción
     * @param socio es el socio que se inscribe
     * @param excursion es excursión a la que se inscribe
     */
    public Inscripcion(String numero, Socio socio, Excursion excursion) {

        if (excursion == null) {
            throw new IllegalArgumentException("La excursión no puede ser nula");
        }

        this.numero = numero;
        this.socio = socio;
        this.excursion = excursion;
        this.fechaInscripcion = LocalDate.now();
    }

    public Inscripcion(String codigoInscripcion, LocalDate fechaInscripcion, String idSocio, String idExcursion) {
        this.numero = codigoInscripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.socio = new Socio();
        this.excursion = new Excursion();
    }

    /**
     * Método constructor de la clase Inscripcion que recibe un objeto de la misma clase para copiar los atributos.
     * @param inscripcion objeto de la clase Inscripcion
     */
    public Inscripcion(Inscripcion inscripcion) {
        this.numero = inscripcion.numero;
        this.socio = inscripcion.socio;
        this.excursion = inscripcion.excursion;
        this.fechaInscripcion = inscripcion.fechaInscripcion;
    }

    /**
     * Constructor vacío para generar sobrecarga de constructores.
     */
    public Inscripcion() {
        this.numero = "";
        this.socio = new Socio();
        this.excursion = new Excursion();
        this.fechaInscripcion = LocalDate.now();
    }

    /**
     * Método get() que nos devuelve el número de la inscripción.
     * @return número de la inscripción.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Método set() para definir el número de la inscripción
     * @param numero número de la inscripción.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Método get() nos devuelve el socio que se inscribe.
     * @return socio que se inscribe.
     */
    public Socio getSocio() {
        return socio;
    }

    /**
     * Método set() para definir el socio que se inscribe.
     * @param socio socio que se inscribe.
     */
    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    /**
     * Método get() nos devuelve la excursión a la que se inscribe.
     * @return excursion a la que se inscribe.
     */
    public Excursion getExcursion() {
        return excursion;
    }

    /**
     * Método get() nos devuelve la fecha de inscripción.
     * @return fecha de inscripción.
     */
    public LocalDate getFecha() {
        return fechaInscripcion;
    }

    /**
     * Método set() para definir a la excursión a la que se inscribe.
     * @param excursion excursión a la que se inscribe.
     */
    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }

    /**
     * Método set() para definir la fecha de inscripción.
     * @param fechaInscripcion fecha de inscripción.
     */
    public void setFecha(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    /**
     * Método toString() de la clase inscripciones que nos devuelve los datos de la inscripción
     * @return el número, el socio y la excursion a la que se inscribe.
     */
    @Override
    public String toString() {
        return "Número de la inscripción: "+ numero +
                "\nSocio:" + socio +
                "\n-- Excursion --\n" + excursion +
                "\nFecha de inscripción: " + fechaInscripcion + "\n";

    }
}