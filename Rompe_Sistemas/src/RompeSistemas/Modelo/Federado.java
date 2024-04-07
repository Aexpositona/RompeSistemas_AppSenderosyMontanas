package RompeSistemas.Modelo;


public class Federado extends Socio {

    private Federacion federaciones;
    private final int tipo = 2;


    // Constructores
    /**
     * Metodo constructor de la clase Estandar que recibe como parámetros el nombre, el número, el NIF y la federación a la que pertenece el socio
     *
     * @param nombre       es el nombre del socio
     * @param numero       es el numero del socio
     * @param federaciones es la federación a la que pertenece el socio
     */
    public Federado(String nombre, int numero, String nif, Federacion federaciones) {
        super(nombre, numero,nif);
        this.federaciones = federaciones;
    }

    public int getTipo() {
        return 2;
    }

    // Métodos Getters

    /**
     * Método get() de la clase Estandar que nos devuelve la federación a la que pertenece el socio
     * @return La federación a la que pertenece el socio
     */
    public Federacion getFederaciones() {
        return federaciones;
    }

    // Métodos Setters
    /**
     * Método set() de la clase Estandar que nos permite definir el NIF del socio
     * @param nif Es el NIF del socio
     */


    /**
     * Método set() de la clase Estandar que nos permite definir la federación a la que pertenece el socio
     * @param federaciones Es la federación a la que pertenece el socio
     */
    public void setFederaciones(Federacion federaciones) {
        this.federaciones = federaciones;
    }

    /**
     * Metodo toString() de la clase Estandar que nos devuelve un String con los datos del socio
     * @return Un String con los datos del socio, como el nombre, el número, el tipo de socio, el NIF y la federación a la que pertenece
     */
    @Override
    public String toString() {
        return "Nombre: " + getNombre() +
                "\nNumero de socio: " + getNumero() +
                "\nTipo de socio: Federado" +
                "\nNIF: " + getNif() +
                "\nFederación: Nombre: " + federaciones.getNombre() +
                "\nCódigo: " + federaciones.getCodigo();
    }
}

