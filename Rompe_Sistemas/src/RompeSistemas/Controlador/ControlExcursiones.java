package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Excursion;
import RompeSistemas.Vista.VistaExcursiones;

public class ControlExcursiones {

    // Atributos
    private VistaExcursiones vExcursiones;
    private Datos datos; // Agrega un campo de instancia para Datos

    /**
     * Constructor de ControlExcursiones.
     *
     * @param vExcursiones VistaExcursiones asociada al controlador
     */
    public ControlExcursiones(VistaExcursiones vExcursiones) {
        this.vExcursiones = vExcursiones;
        this.datos = new Datos(); // Inicializa el campo de Datos
    }

    // Métodos

    /**
     * Añade una excursión utilizando la clase Datos.
     *
     * @param excursion Excursión a añadir
     */
    public void añadirExcursion(Excursion excursion) {
        datos.agregarExcursion(excursion); // Accede al método en la instancia de Datos
    }
}