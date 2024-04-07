package RompeSistemas.Modelo;

public class Inscripcion {
    private String numero;
    private Socio socio;
    private Excursion excursion;

    //Métodos constructores
    /**
     ** Método constructor de la clase Inscripcion que recibe por parámetros el número de inscripción, los socio y las excursion.
     * @param numero es el número que identifica la inscripción
     * @param socio es el socio que se inscribe
     * @param excursion es excursión a la que se inscribe
     */
    public Inscripcion(String numero, Socio socio, Excursion excursion) {
        this.numero = numero;
        this.socio = socio;
        this.excursion = excursion;
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
     * Método set() para definir a la excursión a la que se inscribe.
     * @param excursion excursión a la que se inscribe.
     */
    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }

    /**
     * Método toString() de la clase inscripciones que nos devuelve los datos de la inscripción
     * @return el número, el socio y la excursion a la que se inscribe.
     */
    @Override
    public String toString() {
        return "Número de la inscripción: "+ numero +
                "\nSocio:" + socio +
                "\nExcursions:" + excursion + "\n";
    }
}
