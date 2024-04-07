package RompeSistemas.Modelo;

public abstract class Socio {

    private String nombre;
    private int numero;
    public String nif;
    //Constructores

    /**
     * Constructor de la clase Socio
     * @param nombre Es el nombre del socio
     * @param numero Es el número del socio
     */
    public Socio(String nombre, int numero, String nif) {
        this.nombre = nombre;
        this.numero = numero;
        this.nif = nif;
    }

    /**
     * Constructor vacío para generar sobrecarga de constructores
     */
    public Socio() {

    }

    //Métodos Getters
    /**
     * Método get() de la clase Socio que nos devuelve el nombre del socio
     * @return El nombre del socio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método get() de la clase Socio que nos devuelve el número del socio
     * @return
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Método get() de la clase Socio que nos devuelve el tipo del socio
     * @return
     */
    public int getTipo() {
        return 0;
    }

    /**
     * Método get() de la clase Socio que nos devuelve el NIF del socio
     * @return El NIF del socio
     */
    public String getNif() {
        return nif;
    }
    //Métodos Setters
    /**
     * Método set() de la clase Socio que nos permite definir el nombre del socio
     * @param nombre Es el nombre del socio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método set() de la clase Socio que nos permite definir el número del socio
     * @param numero Es el número del socio
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método set() de la clase Socio que nos permite definir el tipo del socio
     * @param tipo Es el tipo del socio
     */
    public void setTipo(String tipo) {
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Método toString() de la clase Socio que nos devuelve un String con los datos del socio
     * @return Un String con los datos del socio, como el nombre, el domicilio, el NIF y el email
     */
    @Override
    public String toString() {
        return " Nombre: " + nombre + "\n Numero de socio: " + numero +"\n NIF: " + nif + "\n Tipo: " + "\n ";
    }


}
