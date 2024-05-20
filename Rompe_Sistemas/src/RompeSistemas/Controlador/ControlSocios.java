package RompeSistemas.Controlador;

import RompeSistemas.Datos.SQLSocioDAO;
import RompeSistemas.Modelo.*;
import RompeSistemas.ModeloDAO.*;
import RompeSistemas.ModeloDAO.SQLEstandarDAO;
import RompeSistemas.ModeloDAO.SQLInfantilDAO;
import RompeSistemas.Vista.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControlSocios {

    private APPSenderosMontanas app;
    private VistaSocios vSocios;
    private VistaModificarSeguro vModificarSeguro;
    private VistaListarSocios vListarSocios;
    private VistaAddSocio vAddSocio;
    private ControlPeticiones cPeticiones;
    private ControlDatos cDatos;
    private Datos datos;
    private SocioDAO socioDAO;
    private InfantilDAO infantilDAO;
    private FederadoDAO federadoDAO;
    private EstandarDAO estandarDAO;

    public ControlSocios(APPSenderosMontanas app, Connection conn) throws SQLException {
        this.app = app;
        this.vSocios = new VistaSocios(this);
        this.vModificarSeguro = new VistaModificarSeguro();
        this.vListarSocios = new VistaListarSocios();
        this.vAddSocio = new VistaAddSocio();
        this.datos = app.getDatos();
        this.cDatos = app.getControlDatos();
        this.cPeticiones = app.getControlPeticiones();
        this.socioDAO = new SQLSocioDAO(conn);
        this.infantilDAO = new SQLInfantilDAO(conn);
        this.federadoDAO = new SQLFederadoDAO(conn);
        this.estandarDAO = new SQLEstandarDAO(conn);
    }

    public ControlSocios(ControlSocios cSocios) throws SQLException {
        this.app = cSocios.getApp();
        this.vSocios = new VistaSocios(this); // Inicializar VistaSocios con 'this'
        this.vModificarSeguro = cSocios.getVistaModificarSeguro();
        this.vListarSocios = cSocios.getVistaListarSocios();
        this.vAddSocio = cSocios.getVistaAddSocio();
        this.cPeticiones = cSocios.getControlPeticiones();
        this.cDatos = cSocios.getControlDatos();
        this.datos = cSocios.getDatos();
        this.socioDAO = cSocios.getSocioDAO();
        this.infantilDAO = cSocios.getInfantilDAO();
        this.federadoDAO = cSocios.getFederadoDAO();
        this.estandarDAO = cSocios.getEstandarDAO();
    }

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

    public SocioDAO getSocioDAO() {
        return socioDAO;
    }

    public InfantilDAO getInfantilDAO() {
        return infantilDAO;
    }

    public FederadoDAO getFederadoDAO() {
        return federadoDAO;
    }

    public EstandarDAO getEstandarDAO() {
        return estandarDAO;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public void show() throws ParseException, SQLException {
        vSocios.show();
    }

    public void addSocio(Socio socio) throws SQLException {
        socioDAO.insertarSocio(socio);
    }

    public Socio getSocio(String codigo) throws SQLException {
        return socioDAO.getSocio(codigo);
    }

    public void modificarSocio(Socio socio) throws SQLException {
        socioDAO.modificarSocio(socio);
    }

    public void eliminarSocio(Socio socio) throws SQLException {
        socioDAO.eliminarSocio(socio);
    }

    public void addInfantil(Infantil infantil) throws SQLException {
        infantilDAO.insertarInfantil(infantil);
    }

    public Infantil getInfantil(String codigo) throws SQLException {
        return infantilDAO.getInfantil(codigo);
    }

    public void modificarInfantil(Infantil infantil) throws SQLException {
        infantilDAO.modificarInfantil(infantil);
    }

    public void eliminarInfantil(Infantil infantil) throws SQLException {
        infantilDAO.eliminarInfantil(infantil);
    }

    public ResultSet listarInfantiles() throws SQLException {
        return infantilDAO.listarInfantiles();
    }

    public void addFederado(Federado federado) throws SQLException {
        federadoDAO.insertarFederado(federado);
    }

    public Federado getFederado(String codigo) throws SQLException {
        return federadoDAO.getFederado(codigo);
    }

    public void modificarFederado(Federado federado) throws SQLException {
        federadoDAO.modificarFederado(federado);
    }

    public void eliminarFederado(Federado federado) throws SQLException {
        federadoDAO.eliminarFederado(federado);
    }

    public ResultSet listarFederados() throws SQLException {
        return federadoDAO.listarFederados();
    }

    public void addEstandar(Estandar estandar) throws SQLException {
        estandarDAO.insertarEstandar(estandar);
    }

    public Estandar getEstandar(String codigo) throws SQLException {
        return estandarDAO.getEstandar(codigo);
    }

    public void modificarEstandar(Estandar estandar) throws SQLException {
        estandarDAO.modificarEstandar(estandar);
    }

    public void eliminarEstandar(Estandar estandar) throws SQLException {
        estandarDAO.eliminarEstandar(estandar);
    }

    public ResultSet listarEstandares() throws SQLException {
        return estandarDAO.listarEstandares();
    }

    public void removeSocio(String codigo) throws SQLException {
        Socio socio = getSocio(codigo);
        if (socio != null) {
            if (socio instanceof Infantil) {
                eliminarInfantil((Infantil) socio);
            } else if (socio instanceof Federado) {
                eliminarFederado((Federado) socio);
            } else if (socio instanceof Estandar) {
                eliminarEstandar((Estandar) socio);
            } else {
                eliminarSocio(socio);
            }
        } else {
            throw new SQLException("No se encontró el socio con el código: " + codigo);
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
                    if(((int) ChronoUnit.DAYS.between(fechaInicio, ahoraMenosMes) == 0) && ((int)ChronoUnit.DAYS.between(fechaFin, ahora) == 0)){
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
