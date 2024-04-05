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
    private ControlDatos cDatos;
    private ControlPeticiones cPeticiones;
    private Datos datos;
    private VistaExcursiones vExcursiones;
    private VistaAddExcursion vAddExcursion;
    private VistaListarExcursiones vListarExcursiones;

    /**
     * Constructor de ControlExcursiones.
     *
     * @param appSenderosMontanas APPSenderosMontanas asociada al controlador
     * @param datos Datos asociados al controlador.
     * @param vExcursiones VistaExcursiones asociada al controlador.
     */
    public ControlExcursiones(APPSenderosMontanas app) {
        this.vExcursiones = new VistaExcursiones();
        this.vAddExcursion = new VistaAddExcursion();
        this.vListarExcursiones = new VistaListarExcursiones();
        this.datos = app.getDatos();
        this.cDatos = app.getControlDatos();
        this.cPeticiones = app.getControlPeticiones();
    }

    /**
     * Constructor de ControlExcursiones de copia.
     *
     * @param cExcursiones ControlExcursiones a copiar
     */
    public ControlExcursiones(ControlExcursiones cExcursiones) {
        this.vExcursiones = new VistaExcursiones (cExcursiones.getVistaExcursiones());
        this.vAddExcursion = cExcursiones.getVistaAddExcursion();
        this.vListarExcursiones = cExcursiones.getVistaListarExcursiones();
        this.datos = cExcursiones.getDatos();
        this.cDatos = cExcursiones.getControlDatos();
        this.cPeticiones = cExcursiones.getControlPeticiones();
    }

    /**
     * Constructor de ControlExcursiones vacío.
     */

    public ControlExcursiones() {
        this.vExcursiones = null;
        this.vAddExcursion = null;
        this.vListarExcursiones = null;
        this.datos = null;
        this.cDatos = null;
        this.cPeticiones = null;
    }

    // Getters

    public VistaExcursiones getVistaExcursiones() {
        return vExcursiones;
    }
    
    public VistaAddExcursion getVistaAddExcursion() {
        return vAddExcursion;
    }

    public VistaListarExcursiones getVistaListarExcursiones() {
        return vListarExcursiones;
    }

    public Datos getDatos() {
        return datos;
    }

    public ControlDatos getControlDatos() {
        return cDatos;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    public ControlExcursiones getControlExcursiones() {
        return this;
    }

    // Setters

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

    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    // Métodos
    /**
     * Añade una excursión utilizando la clase Datos.
     *
     * @param excursion Excursión a añadir
     */
    public void addExcursion(Excursion excursion) {
        // Añadimos la excursión
        datos.addObjeto(1, excursion);
    }

    /**
     * Elimina una excursión utilizando la clase Datos.
     *
     * @param codigo Código de la excursión a eliminar
     */
    public void removeExcursion(String codigo) {
        // Eliminamos la excursión
        datos.removeObjeto(1, codigo);
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
    public void show() throws ParseException{
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







