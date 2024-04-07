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
        this.datos = new Datos(app.getDatos());
        this.cDatos = new ControlDatos(app.getControlDatos());
        this.vSocios = new VistaSocios(this);
        this.vModificarSeguro = new VistaModificarSeguro(this);
        this.vListarSocios = new VistaListarSocios(this);
        this.vAddSocio = new VistaAddSocio(this);
        this.cPeticiones = new ControlPeticiones(app.getControlPeticiones());

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
    public void removeSocio(int tipoObjeto, String numeroSocio) {
        // Obtenemos un array de socios de la lista de socios
        Socio[] socios = datos.getArrayList(tipoObjeto).toArray(new Socio[0]);
        // Recorremos el array de socios
        for (Socio socio : socios) {
            // Si el número de socio existe y no está inscrito en alguna excursión
            if ((!cDatos.isSocioInInscripcion(numeroSocio)) && cDatos.checkExistenciaObjeto(tipoObjeto, numeroSocio)) {
                datos.removeObjeto(tipoObjeto, socio);
                System.out.println("Socio eliminado con éxito.");
                break;
            } else if (cDatos.isSocioInInscripcion(numeroSocio)) {
                System.out.println("El socio está asociado a una inscripción. No se puede eliminar.");
            } else {
                System.out.println("El socio no existe.");
            }
        }
    }


    /**
     * Método listar todos los socios.
     */
    // Métodos para listar socios
    public void listSocios(int tipoObjeto) {
        vListarSocios.txtMostrarMensaje(datos.listToStringObjetos(tipoObjeto));
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
        // Devolvemos la lista de socios
        return listaSocios.toString();
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
                System.out.println("Número de socio: " + socio.getNumero());
                System.out.println("Nombre: " + socio.getNombre());
                System.out.println("Total de inscripciones del último mes: " + total);
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
        // Obtenemos la lista de socios
        List<Object> sociosList = datos.getArrayList(3);
        // Recorremos la lista de socios
        for (Object obj : sociosList) {
            if (obj instanceof Estandar socio) {
                // Comprobamos si el número de socio del socio es el mismo que el número de socio que queremos modificar
                if (socio.getNumero().equals(numeroSocio)) {
                    // Modificamos el seguro del socio
                    socio.setSeguro(Seguro.values()[tipoSeguro - 1]);
                    break;
                } else {
                    System.out.println("El número de socio introducido no es de un socio estándar.");
                }
            }
        }
    }
}

