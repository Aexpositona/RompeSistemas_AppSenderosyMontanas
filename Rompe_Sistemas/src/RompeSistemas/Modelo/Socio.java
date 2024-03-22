package RompeSistemas.Modelo;

public abstract class Socio {

    private String nombre;
    private int numero;

    //Constructores

    /**
     * Constructor de la clase Socio
     * @param nombre Es el nombre del cliente
     * @param numero Es el número del cliente
     */
    public Socio(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    /**
     * Constructor vacío para generar sobrecarga de constructores
     */
    public Socio() {

    }

    //Métodos Getters
    /**
     * Método get() de la clase Socio que nos devuelve el nombre del cliente
     * @return El nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método get() de la clase Socio que nos devuelve el número del cliente
     * @return
     */
    public int getNumero() {
        return numero;
    }


    //Métodos Setters
    /**
     * Método set() de la clase Socio que nos permite definir el nombre del cliente
     * @param nombre Es el nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método set() de la clase Socio que nos permite definir el número del cliente
     * @param numero Es el número del cliente
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Método toString() de la clase Socio que nos devuelve un String con los datos del cliente
     * @return Un String con los datos del cliente, como el nombre, el domicilio, el NIF y el email
     */
    @Override
    public String toString() {
        return " Nombre: " + nombre + "\n Numero de socio: " + numero + "\n ";
    }
}
