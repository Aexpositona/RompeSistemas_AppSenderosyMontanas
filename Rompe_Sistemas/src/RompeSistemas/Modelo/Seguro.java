package RompeSistemas.Modelo;

public enum Seguro {

    /**
     * Tipo de Seguro Básico
     */
    BASICO(1, "Básico"),
    /**
     * Tipos de Seguro Completo
     */
    COMPLETO(2, "Completo");

    //Atributos
    private int id;
    private  float precio;
    private  String nombre;


    //Métodos constructores
    /**
     * Método constructor de la clase Seguro que recibe por parámetros el precio y el nombre del seguro
     * @param id es el código identificador del seguro
     * @param básico es el nombre del seguro
     */
    Seguro(int id, String básico) {
    }

    //Métodos Getters

    /**
     * Método get() de la clase Seguro que nos devuelve el código identificador del seguro
     * @return El código identificador del seguro
     */
    public int getId() {
        return id;
    }

    /**
     * Método get() de la clase Seguro que nos devuelve el precio del seguro
     * @return El precio del seguro
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Método get() de la clase Seguro que nos devuelve el nombre del seguro
     * @return El nombre del seguro
     */
    public String getNombre() {
        return nombre;
    }

    //Métodos Setters

    /**
     * Método set() de la clase Seguro que nos permite definir el código identificador del seguro
     * @param id Es el código identificador del seguro
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método set() de la clase Seguro que nos permite definir el precio del seguro
     * @param precio Es el precio del seguro
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Método set() de la clase Seguro que nos permite definir el nombre del seguro
     * @param nombre Es el nombre del seguro
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
