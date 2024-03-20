package RompeSistemas.Modelo;

/**
 * Clase que representa un socio federado.
 * @param <F> tipo genérico adicional
 */
public class Federado<F, N> extends Socio {

    private N nif;
    private F federaciones;

    // Constructores
    /**
     * Método constructor de la clase Federado que recibe como parámetros el nombre, el número, el NIF y la federación a la que pertenece el socio.
     *
     * @param nombre el nombre del socio
     * @param numero el número del socio
     * @param nif    el NIF del socio
     */
    public Federado(String nombre, int numero, N nif) {
        super(nombre, numero);
        this.nif = nif;
        this.federaciones = federaciones;
    }

    /**
     * Método constructor por defecto para generar sobrecarga de constructores.
     */
    public Federado() {
    }

    // Métodos Getters
    /**
     * Obtiene el NIF del socio.
     * @return el NIF del socio
     */
    public N getNif() {
        return nif;
    }

    /**
     * Obtiene la federación a la que pertenece el socio.
     * @return la federación a la que pertenece el socio
     */
    public F getFederaciones() {
        return federaciones;
    }

    // Métodos Setters
    /**
     * Establece el NIF del socio.
     * @param nif el NIF del socio
     */
    public void setNif(N nif) {
        this.nif = nif;
    }

    /**
     * Establece la federación a la que pertenece el socio.
     * @param federaciones la federación a la que pertenece el socio
     */
    public void setFederaciones(F federaciones) {
        this.federaciones = federaciones;
    }

    /**
     * Método toString() que devuelve un String con los datos del socio.
     * @return un String con los datos del socio, incluyendo el nombre, el número, el tipo de socio, el NIF y la federación a la que pertenece
     */
    @Override
    public String toString() {
        return super.toString() + "Tipo de socio: Standard \n"  + "NIF: " + nif + "\n" + "Federación: " + federaciones + "\n";
    }
}

