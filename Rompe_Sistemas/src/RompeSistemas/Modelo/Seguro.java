package RompeSistemas.Modelo;

public enum Seguro {

    /**
     * Tipo de Seguro Básico
     */
    BASICO(1, "Básico", 100.0f),
    COMPLETO(2, "Completo", 200.0f);

    //Atributos
    private int id;
    private  float precio;
    private  String nombre;


    //Métodos constructores
    /**
     * Método constructor de la clase Seguro que recibe por parámetros el precio y el nombre del seguro
     * @param id es el código identificador del seguro
     * @param nombre es el nombre del seguro
     * @param precio es el precio del seguro
     */
    Seguro(int id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
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

    public static Seguro getSeguro(int id) {
        for (Seguro seguro : Seguro.values()) {
            if (seguro.id == id) {
                return seguro;
            }
        }
        return null;
    }

    public int getCantidadSeguros() {
        return Seguro.values().length;
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

    //Método toString
    @Override
    public String toString() {
        for (Seguro seguro : Seguro.values()) {
            if (seguro.id == id) {
                return id + " - " + seguro.nombre + " - " + seguro.precio + " Euros";
            }
        }
        return null;
    }

}