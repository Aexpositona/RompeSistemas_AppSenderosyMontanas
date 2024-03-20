package RompeSistemas.Modelo;

/**
 * Clase que representa a un socio estándar.
 *
 * @param <S> tipo genérico para Seguro
 */
public class Estandar<S extends Socio> extends Socio {

    private String nif;
    private S seguro;

    // Métodos constructores

    /**
     * Método constructor de la clase Estandar que recibe como parámetros el nombre, el número, el NIF y el seguro del socio.
     *
     * @param nombre nombre del socio
     * @param numero número del socio
     * @param nif NIF del socio
     * @param seguro seguro del socio
     */
    public Estandar(String nombre, int numero, String nif, S seguro) {
        super(nombre, numero);
        this.nif = nif;
        this.seguro = seguro;
    }

    /**
     * Método constructor por defecto para generar sobrecarga de constructores.
     */
    public Estandar() {
        super();
    }

    // Métodos Getters

    /**
     * Método get para obtener el NIF del socio.
     *
     * @return el NIF del socio
     */
    public String getNif() {
        return nif;
    }

    /**
     * Método get para obtener el seguro del socio.
     *
     * @return el seguro del socio
     */
    public S getSeguro() {
        return seguro;
    }

    // Métodos Setters

    /**
     * Método set para establecer el NIF del socio.
     *
     * @param nif el NIF del socio
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Método set para establecer el seguro del socio.
     *
     * @param seguro el seguro del socio
     */
    public void setSeguro(S seguro) {
        this.seguro = seguro;
    }

    /**
     * Método toString que devuelve una representación en String de los datos del socio.
     *
     * @return una representación en String de los datos del socio
     */
    @Override
    public String toString() {
        return super.toString() + "Tipo de socio: Estandar\n" + "NIF: " + nif + "\n" + "Seguro: " + seguro + "\n";
    }
}
