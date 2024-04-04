package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Excursion;
import RompeSistemas.Vista.VistaExcursiones;
import RompeSistemas.Vista.VistaAddExcursion;
import RompeSistemas.Vista.VistaListarExcursiones;
import java.text.ParseException;
import java.time.LocalDate;

public class ControlExcursiones {
    // Atributos
    private Datos datos;
    private VistaExcursiones vExcursiones;
    private VistaAddExcursion vAddExcursion;
    private VistaListarExcursiones vListarExcursiones;
    private APPSenderosMontanas app;

    /**
     * Constructor de ControlExcursiones.
     *
     * @param appSenderosMontanas APPSenderosMontanas asociada al controlador
     * @param datos Datos asociados al controlador.
     * @param vExcursiones VistaExcursiones asociada al controlador.
     */
    public ControlExcursiones(APPSenderosMontanas app) {
        this.vExcursiones = new VistaExcursiones(this);
        this.vAddExcursion = new VistaAddExcursion(this);
        this.vListarExcursiones = new VistaListarExcursiones(this);
    }

    // Getters

    
    public APPSenderosMontanas getApp() {
        return app;
    }

    public VistaExcursiones getVistaExcursiones() {
        return vExcursiones;
    }
    
    public VistaAddExcursion getVistaAddExcursion() {
        return vAddExcursion;
    }

    public VistaListarExcursiones getVistaListarExcursiones() {
        return vListarExcursiones;
    }

    // Setters

    public void setApp(APPSenderosMontanas app) {
        this.app = app;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public void setVistaExcursiones(VistaExcursiones vExcursiones) {
        this.vExcursiones = vExcursiones;
    }

    public void setVistaAddExcursion(VistaAddExcursion vAddExcursion) {
        this.vAddExcursion = vAddExcursion;
    }

    public void setVistaListarExcursiones(VistaListarExcursiones vListarExcursiones) {
        this.vListarExcursiones = vListarExcursiones;
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
        System.out.println(datos.listToStringObjetosFechas(1,fechaInicial,fechaFinal));
    }

    /**
     * Muestra la vista para listar las excursiones.
     */
    public void showVistaListarExcursiones() {
        // Mostramos la vista para listar las excursiones
        vListarExcursiones.show();
    }

    /**
     * Muestra la vista de excursiones.
     */
    public void showVistaExcursiones() throws ParseException{
        // Mostramos la vista de excursiones
        vExcursiones.show();
    }

    /**
     * Muestra la vista de añadir excursión.
     */
    public void showVistaAddExcursion() throws ParseException{
        // Mostramos la vista de añadir excursión
        vAddExcursion.show();
    }



}







