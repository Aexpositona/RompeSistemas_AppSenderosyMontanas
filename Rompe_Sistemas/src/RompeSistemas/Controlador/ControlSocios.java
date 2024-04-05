package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
import RompeSistemas.Vista.VistaSocios;
import RompeSistemas.Vista.VistaModificarSeguro;
import RompeSistemas.Vista.VistaListarSocios;
import RompeSistemas.Vista.VistaAddSocio;
import java.text.ParseException;


public class ControlSocios {

    // Atributos
    private APPSenderosMontanas app;
    private VistaSocios vSocios;
    private VistaModificarSeguro vModificarSeguro;
    private VistaListarSocios vListarSocios;
    private VistaAddSocio vAddSocio;
    private ControlPeticiones cPeticiones;
    private ControlDatos cDatos;
    private Datos datos;

    /**
     * Constructor de ControlSocios.
     * 
     * @param app APPSenderosMontanas asociada al controlador.
     */
    public ControlSocios(APPSenderosMontanas app) {
        this.app = app;
        this.vSocios = new VistaSocios(this);
        this.vModificarSeguro = new VistaModificarSeguro(this);
        this.vListarSocios = new VistaListarSocios(this);
        this.vAddSocio = new VistaAddSocio(this);
        this.cPeticiones = app.cPeticiones;
        this.datos = app.datos;
        this.cDatos = app.cDatos;
    }

    // Getters

    public APPSenderosMontanas getApp() {
        return app;
    }

    public VistaSocios getVistaSocios() {
        return vSocios;
    }

    public VistaModificarSeguro getVistaModificarSeguro() {
        return vModificarSeguro;
    }

    public VistaListarSocios getVistaListarSocios() {
        return vListarSocios;
    }

    public VistaAddSocio getVistaAddSocio() {
        return vAddSocio;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    public ControlDatos getControlDatos() {
        return cDatos;
    }

    public Datos getDatos() {
        return datos;
    }

    // Setters
    public void setApp(APPSenderosMontanas app) {
        this.app = app;
    }

    public void setVistaSocios(VistaSocios vSocios) {
        this.vSocios = vSocios;
    }

    public void setVistaModificarSeguro(VistaModificarSeguro vModificarSeguro) {
        this.vModificarSeguro = vModificarSeguro;
    }

    public void setVistaListarSocios(VistaListarSocios vListarSocios) {
        this.vListarSocios = vListarSocios;
    }

    public void setVistaAddSocio(VistaAddSocio vAddSocio) {
        this.vAddSocio = vAddSocio;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    // Métodos

    public void show() throws ParseException{
        vSocios.show();
    }


    // Métodos de la vista

    public void addSocio(int tipoObjeto, Object socio) {
        datos.addObjeto(tipoObjeto, socio);
    }



    public void showVistaListarSocios() throws ParseException{
        vListarSocios.show();
    }
    
    public void showVistaAddSocio() throws ParseException{
        vAddSocio.show();
    }

    public void showVistaModificarSeguro() throws ParseException{
        vModificarSeguro.show();
    }

    // Métodos gestión de socios

    public void removeSocio(int tipoObjeto, Object socio) {
        datos.removeObjeto(tipoObjeto, socio);
    }

    // Métodos para listar socios
    public void listSocios(int tipoObjeto) {
        datos.listToStringObjetos(tipoObjeto);
    }

    /**
     * Método para listar los socios por tipo
     * @param tipoObjeto 3-Socio
     * @param tipoSocio 1-Estandar, 2-Federado, 3-Infantil
     */
    // Método para listar socios por tipo
    public void listTipoSocios(int tipoObjeto, int tipoSocio) {

        // Obtenemos un array de socios de la lista de socios
        Socio[] socios = datos.getArrayList(tipoObjeto).toArray(new Socio[0]);
        // Recorremos el array de socios y mostramos los socios del tipo indicado
        for (Socio socio : socios) {
            if (socio.getTipo() == tipoSocio) {
                System.out.println(socio.toString());
            }
        }
    }

    public void showFacturaMensualSocios() {

    }

    public void modificarSeguro(String numeroSocio, int tipoSeguro) {



    }

}
