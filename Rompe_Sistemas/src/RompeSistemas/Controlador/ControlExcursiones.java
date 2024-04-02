package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Excursion;
import RompeSistemas.Vista.VistaExcursiones;

import java.time.LocalDate;

public class ControlExcursiones {
    // Atributos
    private Datos datos; // Instancia de Datos
    private ControlDatos cDatos; // Instancia de ControlDatos
    private VistaExcursiones vistaExcursiones; // Instancia de VistaExcursiones

    /**
     * Constructor de ControlExcursiones.
     *
     * @param appSenderosMontanas APPSenderosMontanas asociada al controlador
     * @param datos Datos asociados al controlador.
     * @param vExcursiones VistaExcursiones asociada al controlador.
     */
    public ControlExcursiones(APPSenderosMontanas appSenderosMontanas, Datos datos, VistaExcursiones vExcursiones) {
        this.datos = datos;
        this.vistaExcursiones = vExcursiones;
    }

    // Métodos
    /**
     * Añade una excursión utilizando la clase Datos.
     *
     * @param excursion Excursión a añadir
     */
    public void addExcursion(Excursion excursion) {
        datos.addObjeto(excursion, 1); // Accede al método en la instancia de Datos
    }

    /**
     * Elimina una excursión utilizando la clase Datos.
     *
     * @param codigo Código de la excursión a eliminar
     */
    public void removeExcursion(String codigo) {
        datos.removeObjeto(codigo, 1); // Accede al método en la instancia de Datos
    }

    /**
     * Lista las excursiones utilizando la clase Datos.
     *
     */
    public void listExcursiones() {
        datos.listObjetos(1); // Accede al método en la instancia de Datos
    }

    public void listExcursionesFechas() {
        LocalDate fechaInicial = cDatos.pedirFecha();
        LocalDate fechaFinal = cDatos.pedirFecha();
        System.out.println(datos.listObjetosFecha(1,fechaInicial,fechaFinal));
    }

}







