package RompeSistemas.Modelo;

/**
 * Enumeración que representa los diferentes tipos de seguros.
 */
public enum Seguro {

    /**
     * Tipo de Seguro Básico
     */
    BASICO(1, "Básico", 100.0f),
    /**
     * Tipo de Seguro Completo
     */
    COMPLETO(2, "Completo", 200.0f);

    // Atributos
    private int id;
    private String nombre;
    private float precio;

    // Métodos constructores
    /**
     * Método constructor de la clase Seguro que recibe por parámetros el código identificador, el nombre y el precio del seguro.
     * @param id el código identificador del seguro
     * @param nombre el nombre del seguro
     * @param precio el precio del seguro
     */
    Seguro(int id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Métodos Getters
    /**
     * Método get() de la clase Seguro que nos devuelve el código identificador del seguro.
     * @return El código identificador del seguro
     */
    public int getId() {
        return id;
    }

    /**
     * Método get() de la clase Seguro que nos devuelve el precio del seguro.
     * @return El precio del seguro
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Método get() de la clase Seguro que nos devuelve el nombre del seguro.
     * @return El nombre del seguro
     */
    public String getNombre() {
        return nombre;
    }

    // Métodos Setters
    /**
     * Método set() de la clase Seguro que nos permite definir el código identificador del seguro.
     * @param id El código identificador del seguro
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método set() de la clase Seguro que nos permite definir el precio del seguro.
     * @param precio El precio del seguro
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Método set() de la clase Seguro que nos permite definir el nombre del seguro.
     * @param nombre El nombre del seguro
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
