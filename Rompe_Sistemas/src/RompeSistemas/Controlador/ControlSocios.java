package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
import RompeSistemas.Vista.VistaSocios;

public class ControlSocios<S extends Socio, V extends VistaSocios> {

    // Atributos
    private V vSocios;
    private Datos<S, ?, S> datos;

    /**
     * Constructor de ControlSocios.
     * @param vSocios VistaSocios asociada al controlador
     */
    public ControlSocios(V vSocios) {
        this.vSocios = vSocios;
        this.datos = new Datos<>(); // Crear una instancia de Datos con el tipo Socio
    }

    // Métodos

    /**
     * Agrega un socio a través de la clase Datos.
     * @param numeroSocio   El número de socio
     * @param nombre        El nombre del socio
     * @param tipoSocio     El tipo de socio (ESTANDAR, FEDERADO, INFANTIL)
     * @param numeroSocioTutor   El número de socio del tutor (para socios infantiles)
     * @param nif           El NIF del socio (para socios estándar)
     */
    public void addSocio(int numeroSocio, String nombre, String tipoSocio, int numeroSocioTutor, String nif) {
        Socio nuevoSocio;
        switch (tipoSocio.toUpperCase()) {
            case "ESTANDAR":
                nuevoSocio = new Estandar(nombre, numeroSocio, nif, obtenerSeguroEstandar());
                break;
            case "FEDERADO":
                nuevoSocio = new Federado(nombre, numeroSocio, obtenerFederacion());
                break;
            case "INFANTIL":
                nuevoSocio = new Infantil(nombre, numeroSocio, numeroSocioTutor);
                break;
            default:
                // Tipo de socio no reconocido
                System.out.println("Tipo de socio no válido.");
                return;
        }
        // Agregamos el nuevo socio a través de la clase Datos
        datos.agregarSocio((S) nuevoSocio);
    }


    /**
     * Método para obtener el seguro estándar.
     * @return El seguro estándar
     */
    private Seguro obtenerSeguroEstandar() {

        return null;
    }

    /**
     * Método para obtener la federación para un socio federado.
     * @return La federación del socio federado
     */
    private Federacion obtenerFederacion() {

        return null;
    }

}
