package RompeSistemas.Controlador;

// Imports
import RompeSistemas.Modelo.*;
import RompeSistemas.Vista.VistaSocios;
import RompeSistemas.Vista.VistaModificarSeguro;
import RompeSistemas.Vista.VistaListarSocios;
import RompeSistemas.Vista.VistaAddSocio;

import java.sql.SQLException;
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

    public void show() throws ParseException, SQLException {
        vSocios.show();
    }


    // Métodos de la vista

    /**
     * Método para añadir un socio.
     *
     * @param socio Socio a añadir.
     */
    public void addSocio(Socio socio) throws SQLException {
        datos.addObjeto(3, socio);
    }

    /**
     * Método para modificar un socio.
     *
     * @param socio Socio a modificar.
     */
    public void modifySocio(Socio socio) throws SQLException {
        datos.modifyObjeto(3, socio);
    }

    /**
     * Método para mostrar la vista de modificar seguro.
     */
    public void showVistaListarSocios() throws ParseException, SQLException {
        vListarSocios.show();
    }

    /**
     * Método para mostrar la vista de añadir socio.
     */
    public void showVistaAddSocio() throws ParseException, SQLException {
        vAddSocio.show();
    }

    /**
     * Método para mostrar la vista de modificar seguro.
     */
    public void showVistaModificarSeguro() throws ParseException, SQLException {
        vModificarSeguro.show();
    }


    /**
     * Método para eliminar un socio.
     *
     * @param numeroSocio El número del socio a eliminar.
     * @return Verdadero si el socio se ha eliminado correctamente, falso en caso contrario.
     */
    public boolean removeSocio(String numeroSocio) throws SQLException {
        // Convertir el número de socio a un ID numérico
        int idSocio = Integer.parseInt(numeroSocio.substring(3));

        // Comprobar si el socio existe en la base de datos
        if (datos.getObjeto(3, idSocio) != null) {
            // Comprobar si el socio no está en una inscripción y no es tutor de un socio infantil
            if ((!cDatos.isSocioInInscripcion(idSocio)) && (!cDatos.isSocioInInfantil(numeroSocio))) {
                // Utilizar el método removeObjeto de la clase Datos para eliminar el socio
                datos.removeObjeto(3, datos.getObjeto(3, idSocio));
                return true;
            } else {
                System.out.println("El socio no se puede eliminar porque está en una inscripción o es tutor de un socio infantil.");
                return false;
            }
        } else {
            System.out.println("El socio no existe.");
            return false;
        }
    }


    /**
     * Método listar todos los socios.
     */
    // Métodos para listar socios
    public void listSocios() throws SQLException {
        datos.listObjetos(3);
    }
    /**
     * Método para listar los socios de un tipo concreto.
     *
     * @param tipoObjeto Tipo de objeto.
     * @param tipoSocio  Tipo de socio.
     */
    public String listTipoSocios(int tipoObjeto, int tipoSocio) {
        // Según el tipo de socio, mostramos un mensaje
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
        // Utilizamos el método listToStringObjetos de la clase Datos para obtener la lista de socios en formato String
        String listaSociosString = datos.listToStringObjetos(tipoObjeto);
        // Devolvemos la lista de socios
        return listaSociosString;
    }

    /**
     * Método para calcular la factura de los socios en un rango de fechas.
     *
     * @param numSocio El número del socio.
     * @param fechaInicio Fecha de inicio.
     * @param fechaFin Fecha de fin.
     */
    public void calcFacturaFechas (String numSocio, LocalDate fechaInicio, LocalDate fechaFin) throws SQLException {

        // Recorremos la lista de socios
        int i = 1;
        Object objSocio = datos.getObjeto(3, i);
        while (objSocio != null) {
            if (objSocio instanceof Socio socio) {
                double total = 0.0;
                // Recorremos la lista de inscripciones
                int j = 1;
                Object objInscripcion = datos.getObjeto(2, j);
                while (objInscripcion != null) {
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
                    j++;
                    objInscripcion = datos.getObjeto(2, j);
                }
                // Si el número de socio es "NULL"
                if (numSocio.equals("NULL")|| socio.getNumero().equalsIgnoreCase(numSocio)){
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
            i++;
            objSocio = datos.getObjeto(3, i);
        }
    }

    /**
     * Método para modificar el seguro de un socio.
     *
     * @param tipoSeguro El tipo de seguro a asignar.
     * @param numeroSocio El número del socio al que se le va a modificar el seguro.
     */
    public void modifySeguro(int tipoSeguro, String numeroSocio) throws SQLException {
        // Convertir el número de socio a un ID numérico
        int idSocio = Integer.parseInt(numeroSocio.substring(3));

        // Utilizar el método getObjeto de la clase Datos para obtener el socio
        Socio socio = (Socio) datos.getObjeto(3, idSocio);

        // Si el socio existe y es un usuario estándar
        if (socio != null && socio instanceof Estandar) {
            // Modificamos el seguro del socio
            ((Estandar) socio).setSeguro(Seguro.values()[tipoSeguro - 1]);

            // Mostramos un mensaje de éxito
            vModificarSeguro.txtMostrarMensaje("Seguro del usuario " + socio.getNumero() + " se ha modificado con éxito al tipo de seguro " + ((Estandar) socio).getSeguro().getNombre() + ".\n\n");
        }
    }

    /**
     * Método para listar los seguros de los socios.
     */
    public void listSeguros() {
        // Obtenemos la lista de socios
        vModificarSeguro.txtMostrarMensaje("-- Seguro 1 -- \n" + Seguro.BASICO + "\n");
        vModificarSeguro.txtMostrarMensaje("-- Seguro 2 -- \n" + Seguro.COMPLETO + "\n");
    }
}
