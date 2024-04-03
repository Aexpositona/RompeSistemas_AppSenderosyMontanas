package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Excursion;
import RompeSistemas.Vista.VistaExcursiones;

import java.time.LocalDate;

public class ControlExcursiones {
    // Atributos
    private final Datos datos; // Instancia de Datos

    /**
     * Constructor de ControlExcursiones.
     *
     * @param appSenderosMontanas APPSenderosMontanas asociada al controlador
     * @param datos Datos asociados al controlador.
     * @param vExcursiones VistaExcursiones asociada al controlador.
     */
    public ControlExcursiones(APPSenderosMontanas appSenderosMontanas, Datos datos, VistaExcursiones vExcursiones) {
        this.datos = datos;
    }

    // Métodos
    /**
     * Añade una excursión utilizando la clase Datos.
     *
     * @param excursion Excursión a añadir
     */
    public void addExcursion(Excursion excursion) {
        // Añadimos la excursión
        datos.addObjeto(excursion, 1);
    }

    /**
     * Elimina una excursión utilizando la clase Datos.
     *
     * @param codigo Código de la excursión a eliminar
     */
    public void removeExcursion(String codigo) {
        // Eliminamos la excursión
        datos.removeObjeto(codigo, 1);
    }

    /**
     * Lista las excursiones utilizando la clase Datos.
     *
     */
    public void listExcursiones() {
        // Mostramos las excursiones
        System.out.println(datos.listToStringObjetos(1));
    }

    /**
     * Lista las excursiones entre dos fechas utilizando la clase Datos.
     *
     * @param fechaInicial Fecha inicial
     * @param fechaFinal Fecha final
     */
    public void listExcursionesFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
        // Mostramos las excursiones entre dos fechas
        System.out.println(datos.listToStringObjetosFecha(1,fechaInicial,fechaFinal));
    }

}







