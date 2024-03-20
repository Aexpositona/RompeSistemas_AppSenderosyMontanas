package RompeSistemas.Modelo;

/**
 * Clase que representa un socio infantil.
 *
 * @param <S> el tipo de socio que se inscribe
 * @param <N> el tipo de dato que representa el número de socio del tutor
 */
public class Infantil<S extends Socio, N> extends Socio {

    private N numSocioTutor;

    // Métodos constructores

    /**
     * Método constructor de la clase Infantil que recibe por parámetros el nombre, el número y el número de socio del tutor.
     *
     * @param nombre         el nombre del socio
     * @param numero         el número del socio
     * @param numSocioTutor el número de socio del tutor
     */
    public Infantil(String nombre, int numero, N numSocioTutor) {
        super(nombre, numero);
        this.numSocioTutor = numSocioTutor;
    }

    /**
     * Método constructor por defecto para generar sobrecarga de constructores.
     */
    public Infantil() {

    }

    // Métodos Getters

    /**
     * Obtiene el número de socio del tutor.
     *
     * @return el número de socio del tutor
     */
    public N getNumSocioTutor() {
        return numSocioTutor;
    }

    // Métodos Setters

    /**
     * Establece el número de socio del tutor.
     *
     * @param numSocioTutor el número de socio del tutor
     */
    public void setNumSocioTutor(N numSocioTutor) {
        this.numSocioTutor = numSocioTutor;
    }

    /**
     * Método toString() que devuelve un String con los datos del socio.
     *
     * @return un String con los datos del socio, incluyendo el nombre, el número del socio, el tipo de socio y el número de socio del tutor
     */
    @Override
    public String toString() {
        return super.toString() + "Tipo de socio: Infantil\n" + "NIF del padre: " + numSocioTutor + "}";
    }
}
