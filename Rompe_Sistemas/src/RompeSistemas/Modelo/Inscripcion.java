package RompeSistemas.Modelo;

public class Inscripcion {
    private int numero;
    private Socio socios;
    private Excursion excursiones;

    //Métodos constructores
    /**
     ** Método constructor de la clase Inscripcion que recibe por parámetros el número de inscripción, los socios y las excursiones.
     * @param numero es el número que identifica la inscripción
     * @param socios es el socio que se inscribe
     * @param excursiones es excursión a la que se inscribe
     */
    public Inscripcion(int numero, Socio socios, Excursion excursiones) {
        this.numero = numero;
        this.socios = socios;
        this.excursiones = excursiones;
    }

    /**
     * Método get() que nos devuelve el número de la inscripción.
     * @return número de la inscripción.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método set() para definir el número de la inscripción
     * @param numero número de la inscripción.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método get() nos devuelve el socio que se inscribe.
     * @return socio que se inscribe.
     */
    public Socio getSocios() {
        return socios;
    }

    /**
     * Método set() para definir el socio que se inscribe.
     * @param socios socio que se inscribe.
     */
    public void setSocios(Socio socios) {
        this.socios = socios;
    }

    /**
     * Método get() nos devuelve la excursión a la que se inscribe.
     * @return excursion a la que se inscribe.
     */
    public Excursion getExcursiones() {
        return excursiones;
    }

    /**
     * Método set() para definir a la excursión a la que se inscribe.
     * @param excursiones excursión a la que se inscribe.
     */
    public void setExcursiones(Excursion excursiones) {
        this.excursiones = excursiones;
    }

    /**
     * Método toString() de la clase inscripciones que nos devuelve los datos de la inscripción
     * @return el número, el socio y la excursion a la que se inscribe.
     */
    @Override
    public String toString() {
        return "Inscripción con número: "+ numero + "\nSocio:" + socios + "\nExcursions:" + excursiones;
    }
}
