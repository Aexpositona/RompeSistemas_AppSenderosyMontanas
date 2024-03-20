package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Socio;
import RompeSistemas.Vista.VistaSocios;

/**
 * Controlador para la gestión de socios.
 *
 * @param <S> tipo de objeto Socio
 * @param <V> tipo de objeto VistaSocios
 */
public class ControlSocios<S extends Socio, V extends VistaSocios> {

    // Atributos
    private V vSocios;

    /**
     * Constructor de ControlSocios.
     *
     * @param vSocios VistaSocios asociada al controlador
     */
    public ControlSocios(V vSocios) {
        this.vSocios = vSocios;
    }

    // Métodos

    /**
     * Agrega un socio a través de la clase Datos.
     *
     * @param socio Socio a agregar
     */
    public void addSocio(S socio) {
        Datos.agregarSocio(socio);
    }

    /**
     * Elimina un socio a través de la clase Datos.
     *
     * @param numero Número de socio a eliminar
     */
    public void removeSocio(int numero) {
        // Lógica para eliminar un socio a través de Datos
    }

    /**
     * Lista todos los socios a través de la clase Datos.
     */
    public void listSocios() {
        // Lógica para listar socios a través de Datos
    }

    /**
     * Lista los socios por tipo a través de la clase Datos.
     */
    public void listSociosTipo() {
        // Lógica para listar socios por tipo a través de Datos
    }

    /**
     * Genera la factura mensual para los socios a través de la clase Datos.
     */
    public void facturaMensualSocios() {
        // Lógica para generar factura mensual para los socios a través de Datos
    }

    /**
     * Muestra la vista para añadir un socio.
     */
    public void showVistaAñadirSocio() {
        // Lógica para mostrar vista de añadir socio
    }

    /**
     * Muestra la vista para listar socios.
     */
    public void showVistaListarSocios() {
        // Lógica para mostrar vista de listar socios
    }

    /**
     * Muestra la vista del menú principal.
     */
    public void showVistaMenuPrincipal() {
        // Lógica para mostrar vista del menú principal
    }

    /**
     * Muestra la vista de socios.
     */
    public void showVistaSocios() {
        // Lógica para mostrar vista de socios
    }

    /**
     * Maneja el botón "Atrás".
     */
    public void buttonAtras() {
        // Lógica para manejar el botón "Atrás"
    }
}
