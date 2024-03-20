package RompeSistemas.Modelo;

/**
 * Clase que representa una inscripción a una excursión por parte de un socio.
 * @param <S> el tipo de socio que se inscribe
 * @param <E> el tipo de excursión a la que se inscribe
 */
public class Inscripcion<S extends Socio, E extends Excursion> {
    private int numero;
    private S socio;
    private E excursion;

    // Métodos constructores
    /**
     * Método constructor de la clase Inscripcion que recibe por parámetros el número de inscripción, el socio y la excursión.
     * @param numero el número que identifica la inscripción
     * @param socio el socio que se inscribe
     * @param excursion la excursión a la que se inscribe
     */
    public Inscripcion(int numero, S socio, E excursion) {
        this.numero = numero;
        this.socio = socio;
        this.excursion = excursion;
    }

    /**
     * Método get() que nos devuelve el número de la inscripción.
     * @return el número de la inscripción
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método set() para definir el número de la inscripción.
     * @param numero el número de la inscripción
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método get() que nos devuelve el socio que se inscribe.
     * @return el socio que se inscribe
     */
    public S getSocio() {
        return socio;
    }

    /**
     * Método set() para definir el socio que se inscribe.
     * @param socio el socio que se inscribe
     */
    public void setSocio(S socio) {
        this.socio = socio;
    }

    /**
     * Método get() que nos devuelve la excursión a la que se inscribe.
     * @return la excursión a la que se inscribe
     */
    public E getExcursion() {
        return excursion;
    }

    /**
     * Método set() para definir la excursión a la que se inscribe.
     * @param excursion la excursión a la que se inscribe
     */
    public void setExcursion(E excursion) {
        this.excursion = excursion;
    }

    /**
     * Método toString() de la clase Inscripcion que nos devuelve los datos de la inscripción.
     * @return el número, el socio y la excursión a la que se inscribe
     */
    @Override
    public String toString() {
        return "Inscripción con número: " + numero + "\nSocio: " + socio + "\nExcursión: " + excursion;
    }
}
