package RompeSistemas.Modelo;


public class Federado extends Socio {

    // Atributos
    private Federacion federacion;
    private static final int tipo = 2;

    // Constructores
    /**
     * Metodo constructor de la clase Estandar que recibe como parámetros el nombre, el número, el NIF y la federación a la que pertenece el socio
     *
     * @param nombre        es el nombre del socio
     * @param numero        es el numero del socio
     * @param federacion    es la federación a la que pertenece el socio
     */
    public Federado(String nombre, String numero, String nif, Federacion federacion) {
        super(nombre, numero, nif);
        this.federacion = federacion;
        super.setTipo(tipo);
    }

    /**
     * Metodo constructor de copia de la clase Federado
     *
     * @param federado es el socio que se va a copiar
     */
    public Federado(Federado federado) {
        super(federado);
        this.federacion = federado.federacion;
        super.setTipo(tipo);
    }

    // Métodos Getters

    /**
     * Método get() de la clase Federado que nos devuelve el tipo de socio
     *
     * @return El tipo de socio
     */
    public Federacion getFederacion() {
        return federacion;
    }

    // Métodos Setters

    /**
     * Método set() de la clase Federado que nos permite definir la federación a la que pertenece el socio
     *
     * @param federacion es la federación a la que pertenece el socio
     */
    public void setFederacion(Federacion federacion) {
        this.federacion = federacion;
    }

    @Override
    public String toString() {
        super.setTipo(tipo);
        return super.toString() +
                "Federación: " + federacion.getNombre() + "\n";
    }
}

