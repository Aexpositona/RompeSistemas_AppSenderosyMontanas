package RompeSistemas.Controlador;

// Imports
import RompeSistemas.Modelo.*;
import RompeSistemas.Vista.VistaSocios;
import RompeSistemas.Vista.VistaModificarSeguro;
import RompeSistemas.Vista.VistaListarSocios;
import RompeSistemas.Vista.VistaAddSocio;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el controlador de socios.
 */
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
     * @param numeroSocio Número de socio.
     */
    public void removeSocio(String numeroSocio) {
        int tipoObjeto = 3;
        List<Object> socios = datos.getArrayList(tipoObjeto);
        // Recorremos el array de socios
        for (Object socio : socios) {
            // Si el número de socio existe y no está inscrito en alguna excursión
            if ((!cDatos.isSocioInInscripcion(numeroSocio)) && cDatos.checkExistenciaObjeto(tipoObjeto, numeroSocio)) {
                // Eliminamos el socio
                datos.removeObjeto(tipoObjeto, socio);
                // Mostramos un mensaje de éxito
                vSocios.txtMostrarMensaje("Socio eliminado con éxito.\n\n");
                break;
            }
            // Si el socio está inscrito en alguna excursión
            else if (cDatos.isSocioInInscripcion(numeroSocio)) {
                // Mostramos un mensaje de error
                vSocios.txtMostrarMensaje("El socio está asociado a una inscripción. No se puede eliminar.\n\n");
                break;
            }
            // Si el socio está asociado a un usuario infantil
            else if (cDatos.checkExistenciaObjeto(tipoObjeto, numeroSocio) && !cDatos.isSocioInInfantil(numeroSocio)) {
                vSocios.txtMostrarMensaje("El socio está asociado a un usuario infantil. No se puede eliminar.\n\n");
                break;
            }
            // Si el socio no existe
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
        // Formateamos la lista de socios
        StringBuilder listaSociosString = new StringBuilder();
        // Recorremos la lista de socios
        for (Socio socio : listaSocios) {
            // Añadimos el socio a la lista en formato string
            listaSociosString.append(socio.toString()).append("\n");
        }
        // Devolvemos la lista de socios
        return listaSociosString.toString();
    }

    /**
     * Método para calcular la factura de los socios en un rango de fechas.
     *
     * @param fechaInicio Fecha de inicio.
     * @param fechaFin    Fecha de fin.
     */
    public void calcFacturaFechas (String numSocio, LocalDate fechaInicio, LocalDate fechaFin) {

        // Obtenemos la lista de socios y la lista de inscripciones
        List<Object> listSocios = datos.getArrayList(3), listInscripciones = datos.getArrayList(2);
        // Recorremos la lista de socios
        for (Object objSocio : listSocios) {
            if (objSocio instanceof Socio socio) {
                double total = 0.0;
                // Recorremos la lista de inscripciones
                for (Object objInscripcion : listInscripciones) {
                    // Si el objeto es una inscripción
                    if (objInscripcion instanceof Inscripcion inscripcion) {
                        // Comprobamos si el socio de la inscripción es el socio que estamos procesando y si el número de socio coincide con el número de socio que estamos buscando o si el número de socio es "NULL"
                        if (inscripcion.getSocio().equals(socio) && (socio.getNumero().equalsIgnoreCase(numSocio) || numSocio.equals("NULL"))){
                            // Obtenemos la excursión de la inscripción
                            Excursion excursion = inscripcion.getExcursion();
                            // Comprobamos si la fecha de la excursión está dentro del rango de fechas
                            if (inscripcion.getFecha().isAfter(fechaInicio) && inscripcion.getFecha().isBefore(fechaFin)){
                                // Sumamos el precio de la excursión al total
                                total += excursion.getPrecio();
                            }
                        }
                    }
                }
                // Si el número de socio es "NULL"
                if (numSocio.equals("NULL")){
                    // Imprimimos el número de socio, el nombre y el total de las inscripciones
                    vSocios.txtMostrarMensaje("Número de socio: " + socio.getNumero() + "\n");
                    vSocios.txtMostrarMensaje("Nombre: " + socio.getNombre() + "\n");
                    // Si estamos calculando el total de inscripciones del último mes descontando el tiempo de ejecución
                    LocalDate ahoraMenosMes = LocalDate.now().minusMonths(1);
                    LocalDate ahora = LocalDate.now();
                    if(((int)ChronoUnit.DAYS.between(fechaInicio, ahoraMenosMes) == 0) && ((int)ChronoUnit.DAYS.between(fechaFin, ahora) == 0)){
                        vSocios.txtMostrarMensaje("Total de las inscripciones del último mes: " + total + " Euros.\n\n");
                    }

                    // Si estamos calculando el total de inscripciones de otro rango de fechas
                    else {
                        vSocios.txtMostrarMensaje("Total de las inscripciones del rango de fechas entre " + fechaInicio + " y " + fechaFin + ": " + total + " Euros.\n\n");
                    }                
                }
                // Si el número de socio coincide con el número de socio que estamos buscando
                else if (socio.getNumero().equalsIgnoreCase(numSocio)){
                    // Imprimimos el número de socio, el nombre y el total de las inscripciones
                    vSocios.txtMostrarMensaje("Número de socio: " + socio.getNumero() + "\n");
                    vSocios.txtMostrarMensaje("Nombre: " + socio.getNombre() + "\n");
                    // Si estamos calculando el total de inscripciones del último mes descontando el tiempo de ejecución
                    LocalDate ahoraMenosMes = LocalDate.now().minusMonths(1);
                    LocalDate ahora = LocalDate.now();
                    if(((int)ChronoUnit.DAYS.between(fechaInicio, ahoraMenosMes) == 0) && ((int)ChronoUnit.DAYS.between(fechaFin, ahora) == 0)){
                        vSocios.txtMostrarMensaje("Total de las inscripciones del último mes: " + total + " Euros.\n\n");
                    }

                    // Si estamos calculando el total de inscripciones de otro rango de fechas
                    else {
                        vSocios.txtMostrarMensaje("Total de las inscripciones del rango de fechas entre " + fechaInicio + " y " + fechaFin + ": " + total + " Euros.\n\n");
                    }                
                }
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
                if (socio.getNumero().equalsIgnoreCase(numeroSocio)) {
                    // Si el socio es un usuario estándar
                    if (socio instanceof Estandar) {
                        // Modificamos el seguro del socio
                        ((Estandar) socio).setSeguro(Seguro.values()[tipoSeguro - 1]);
                        // Mostramos un mensaje de éxito
                        vModificarSeguro.txtMostrarMensaje("Seguro del usuario " + ((Estandar) socio).getNumero() + " se ha modificado con éxito al tipo de seguro " + ((Estandar) socio).getSeguro().getNombre() + ".\n\n");
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
        vModificarSeguro.txtMostrarMensaje("-- Seguro 1 -- \n" + Seguro.BASICO.toString() + "\n");
        vModificarSeguro.txtMostrarMensaje("-- Seguro 2 -- \n" + Seguro.COMPLETO.toString() + "\n");
    }
}
