package RompeSistemas.Modelo;

public class Federacion {

    private String codigo;
    private String nombre;

    //Métodos constructores

    /**
     * Método constructor de la clase Federacion que recibe por parámetros el código y el nombre de la federación
     * @param codigo Es el código de la federación
     * @param nombre Es el nombre de la federación
     */
    public Federacion(String codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
    }

    //Métodos Getters

    /**
     * Método get() de la clase Federacion que nos devuelve el código de la federación
     * @return El código de la federación
     */
    public String getCodigo(){
        return codigo;
    }

    /**
     * Método get() de la clase Federacion que nos devuelve el nombre de la federación
     * @return El nombre de la federación
     */
    public String getNombre(){
        return nombre;
    }

    //Métodos Setters
    /**
     * Método set() de la clase Federacion que nos permite definir el código de la federación
     * @param codigo Es el código de la federación
     */
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    /**
     * Método set() de la clase Federacion que nos permite definir el nombre de la federación
     * @param nombre Es el nombre de la federación
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    //Método toString

    /**
     * Método toString() de la clase Federacion que nos devuelve un String con los datos de la federación
     * @return El nombre y el código de la federación
     */
    @Override
    public String toString(){
        return "Nombre: " + nombre + "\nCódigo: " + codigo;
    }
}
