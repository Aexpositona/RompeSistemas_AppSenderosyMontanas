package RompeSistemas.Modelo;

/**
 * Clase que representa a un socio estándar.
 */
public class Estandar extends Socio {

    // Atributos
    private static final int tipo = 1;
    private final String nif;
    private Seguro seguro;

    // Métodos constructores

    /**
     * Constructor de la clase Estandar que recibe parámetros para inicializar los atributos.
     *
     * @param nombre nombre del socio
     * @param numero número del socio
     * @param nif NIF del socio
     * @param seguro seguro del socio
     */
    public Estandar(String nombre, String numero, String nif, Seguro seguro) {
        super(nombre, numero,nif);
        this.nif = nif;
        this.seguro = seguro;
        super.setTipo(tipo);
    }

    /**
     * Constructor de la clase Estandar que recibe un objeto de la misma clase para copiar los atributos.
     *
     * @param estandar objeto de la clase Estándar
     */
    public Estandar(Estandar estandar) {
        super(estandar);
        this.nif = estandar.nif;
        this.seguro = estandar.seguro;
        super.setTipo(tipo);
    }

    /**
     * Constructor vacío para generar sobrecarga de constructores.
     */
    public Estandar() {
        super();
        this.nif = "";
        this.seguro = Seguro.BASICO;
        super.setTipo(tipo);
    }

    public int getTipo() {
        return 1;
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
    public Seguro getSeguro() {
        return seguro;
    }

    // Métodos Setters


    /**
     * Método set para establecer el seguro del socio.
     *
     * @param seguro el seguro del socio
     */
    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    /**
     * Método toString que devuelve una representación en String de los datos del socio.
     *
     * @return una representación en String de los datos del socio
     */
    @Override
    public String toString() {
        return super.toString() +
                "Seguro: " + seguro + "\n";
    }
}
