package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
import RompeSistemas.Vista.VistaSocios;
import RompeSistemas.Vista.VistaModificarSeguro;
import RompeSistemas.Vista.VistaListarSocios;
import RompeSistemas.Vista.VistaAddSocio;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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

        this.vSocios = new VistaSocios();
        this.vModificarSeguro = new VistaModificarSeguro();
        this.vListarSocios = new VistaListarSocios();
        this.vAddSocio = new VistaAddSocio();
        this.datos = app.getDatos();
        this.cDatos = app.getControlDatos();
        this.cPeticiones = app.getControlPeticiones();

    }

    /**
     * Constructor de ControlSocios de copia.
     *
     * @param cSocios ControlSocios a copiar
     */
    public ControlSocios(ControlSocios cSocios) {
        this.app = cSocios.getApp();
        this.vSocios = cSocios.getVistaSocios();
        this.vModificarSeguro = cSocios.getVistaModificarSeguro();
        this.vListarSocios = cSocios.getVistaListarSocios();
        this.vAddSocio = cSocios.getVistaAddSocio();
        this.cPeticiones = cSocios.getControlPeticiones();
        this.cDatos = cSocios.getControlDatos();
        this.datos = cSocios.getDatos();
    }

    /**
     * Constructor de ControlSocios vacío.
     */
    public ControlSocios() {
        this.app = null;
        this.vSocios = null;
        this.vModificarSeguro = null;
        this.vListarSocios = null;
        this.vAddSocio = null;
        this.cPeticiones = null;
        this.cDatos = null;
        this.datos = null;
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

    public void show() throws ParseException {
        vSocios.show();
    }


    // Métodos de la vista

    /**
     * Método para añadir un socio.
     *
     * @param socio Socio a añadir.
     */
    public void addSocio(Socio socio) {
        datos.addObjeto(3, socio);
    }

    /**
     * Método para modificar un socio.
     *
     * @param socio Socio a modificar.
     */
    public void modifySocio(Socio socio) {
        datos.modifyObjeto(3, socio);
    }

    /**
     * Método para mostrar la vista de modificar seguro.
     */
    public void showVistaListarSocios() throws ParseException {
        vListarSocios.show();
    }

    /**
     * Método para mostrar la vista de añadir socio.
     */
    public void showVistaAddSocio() throws ParseException {
        vAddSocio.show();
    }

    /**
     * Método para mostrar la vista de modificar seguro.
     */
    public void showVistaModificarSeguro() throws ParseException {
        vModificarSeguro.show();
    }


    /**
     * Método para eliminar un socio.
     *
     * @param tipoObjeto  Tipo de objeto.
     * @param numeroSocio Número de socio.
     */
    public void removeSocio(String numeroSocio) {
        int tipoObjeto = 3;
        List<Object> socios = datos.getArrayList(tipoObjeto);
        // Recorremos el array de socios
        for (Object socio : socios) {
            // Si el número de socio existe y no está inscrito en alguna excursión
            if ((!cDatos.isSocioInInscripcion(numeroSocio)) && cDatos.checkExistenciaObjeto(tipoObjeto, numeroSocio)) {
                datos.removeObjeto(tipoObjeto, socio);
                vSocios.txtMostrarMensaje("Socio eliminado con éxito.\n\n");
                break;
            } 
            else if (cDatos.isSocioInInscripcion(numeroSocio)) {
                vSocios.txtMostrarMensaje("El socio está asociado a una inscripción. No se puede eliminar.\n\n");
                break;
            } 
            else if (cDatos.checkExistenciaObjeto(tipoObjeto, numeroSocio) && !cDatos.isSocioInInfantil(numeroSocio)) {
                vSocios.txtMostrarMensaje("El socio está asociado a un usuario infantil. No se puede eliminar.\n\n");
                break;
            }
            else {
                vSocios.txtMostrarMensaje("El socio no existe.\n\n");
                break;
            }
        }
    }


    /**
     * Método listar todos los socios.
     */
    // Métodos para listar socios
    public void listSocios() {
        vListarSocios.txtMostrarMensaje(datos.listToStringObjetos(3));
    }

    /**
     * Método para listar los socios de un tipo concreto.
     *
     * @param tipoObjeto Tipo de objeto.
     * @param tipoSocio  Tipo de socio.
     */
    public String listTipoSocios(int tipoObjeto, int tipoSocio) {
        // Según el tipo de socio, mostramos un mensaje
        ArrayList<Socio> listaSocios = new ArrayList<>();
        vListarSocios.txtMostrarMensaje("\n");
        switch (tipoSocio) {
            case 1:
                System.out.println("Listado de socios estándar:");
                break;
            case 2:
                System.out.println("Listado de socios federados:");
                break;
            case 3:
                System.out.println("Listado de socios infantiles:");
                break;
            default:
                System.out.println("Tipo de socio no válido.");
                break;
        }
        // Recorremos la lista de objetos
        for (Object objeto : datos.getArrayList(tipoObjeto)) {
            // Si el objeto es un socio del tipo que queremos listar
            if (objeto instanceof Socio) {
                if (objeto instanceof Estandar && tipoSocio == 1 || objeto instanceof Federado && tipoSocio == 2 || objeto instanceof Infantil && tipoSocio == 3) {
                    listaSocios.add((Socio) objeto);
                }
            }
        }
        // Formatemaos la lista de socios
        StringBuilder listaSociosString = new StringBuilder();
        for (Socio socio : listaSocios) {
            listaSociosString.append(socio.toString()).append("\n");
        }
        // Devolvemos la lista de socios
        return listaSociosString.toString();
    }

    /**
     * Método para mostrar la factura mensual de los socios.
     */
    public void showFacturaMensualSocios () {
        // Obtenemos la fecha actual y la fecha de hace un mes
        LocalDate now = LocalDate.now(), oneMonthAgo = now.minusMonths(1);
        // Obtenemos la lista de socios y la lista de inscripciones
        List<Object> sociosList = datos.getArrayList(3), inscripcionesList = datos.getArrayList(2);
        // Recorremos la lista de socios
        for (Object obj : sociosList) {
            if (obj instanceof Socio socio) {
                double total = 0.0;
                // Recorremos la lista de inscripciones
                for (Object objInscripcion : inscripcionesList) {
                    // Si el objeto es una inscripción
                    if (objInscripcion instanceof Inscripcion inscripcion) {
                        // Comprobamos si el socio de la inscripción es el socio que estamos procesando
                        if (inscripcion.getSocio().equals(socio)) {
                            // Obtenemos la excursión de la inscripción
                            Excursion excursion = inscripcion.getExcursion();
                            // Comprobamos si la fecha de la excursión está dentro del último mes
                            if (!excursion.getFecha().isBefore(oneMonthAgo) && !excursion.getFecha().isAfter(now)) {
                                // Sumamos el precio de la excursión al total
                                total += excursion.getPrecio();
                            }
                        }
                    }
                }
                // Imprimimos el número de socio, el nombre y el total de las inscripciones
                vSocios.txtMostrarMensaje("Número de socio: " + socio.getNumero() + " - ");
                vSocios.txtMostrarMensaje("Nombre: " + socio.getNombre()+ " - ");
                vSocios.txtMostrarMensaje("Total de inscripciones del último mes: " + total +  "€\n");
            }
        }
    }

    /**
     * Método para modificar el seguro de un socio.
     *
     * @param tipoSeguro Tipo de seguro.
     * @param numeroSocio Número de socio.
     */
    public void modifySeguro (int tipoSeguro, String numeroSocio){

        // Recorremos la lista de socios
        for (Object obj : datos.getArrayList(3)) {
            // Si el objeto es un socio
            if (obj instanceof Socio socio) {
                // Si el número de socio coincide con el número de socio del socio
                if (socio.getNumero().equals(numeroSocio)) {
                    // Si el socio es un usuario estándar
                    if (socio instanceof Estandar) {
                        // Modificamos el seguro del socio
                        ((Estandar) socio).setSeguro(Seguro.values()[tipoSeguro - 1]);
                        // Mostramos un mensaje de éxito
                        vModificarSeguro.txtMostrarMensaje("Seguro modificado con éxito.\n\n");
                        break;
                    }
                }
            }
        }
    }

    /**
     * Método para listar los seguros de los socios.
     */
    public void listSeguros() {
        // Obtenemos la lista de socios
        vModificarSeguro.txtMostrarMensaje("-- Seguro 1 -- " + Seguro.BASICO.toString() + "\n");
        vModificarSeguro.txtMostrarMensaje("-- Seguro 2 -- " + Seguro.COMPLETO.toString() + "\n");
    }
}

