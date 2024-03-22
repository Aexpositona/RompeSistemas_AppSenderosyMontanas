package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Excursion;
import RompeSistemas.Modelo.Inscripcion;
import RompeSistemas.Modelo.Socio;
import RompeSistemas.Vista.VistaExcursiones;

public class ControlDatos {

    private Datos datos; // Agrega un campo de instancia para Datos

    // Constructor
    public ControlDatos() {
        this.datos = new Datos(); // Inicializa el campo de Datos
    }

    // Métodos

    /**
     * Comprueba la validez de un socio.
     *
     * @param socio Socio a comprobar
     */
    public void comprobarSocio(Socio socio) {
        // Lógica para comprobar un socio
        datos.agregarSocio(socio); // Accede al método en la instancia de Datos
    }

    /**
     * Comprueba la validez de una excursión.
     *
     * @param excursion Excursión a comprobar
     */
    public void comprobarExcursion(Excursion excursion) {
        // Lógica para comprobar una excursión
        datos.agregarExcursion(excursion); // Accede al método en la instancia de Datos
    }

    /**
     * Comprueba la validez de una inscripción.
     *
     * @param inscripcion Inscripción a comprobar
     */
    public void comprobarInscripcion(Inscripcion inscripcion) {
        // Lógica para comprobar una inscripción
        datos.agregarInscripcion(inscripcion); // Accede al método en la instancia de Datos
    }
}