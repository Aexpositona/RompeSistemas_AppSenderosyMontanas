package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
import RompeSistemas.ModeloDAO.*;
import RompeSistemas.Vista.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

public class ControlSocios {
    private APPSenderosMontanas app;
    private VistaSocios vSocios;
    private VistaModificarSeguro vModificarSeguro;
    private VistaListarSocios vListarSocios;
    private VistaAddSocio vAddSocio;
    private ControlPeticiones cPeticiones;
    private ControlDatos cDatos;
    private SocioDAO socioDAO;
    private InfantilDAO infantilDAO;
    private FederadoDAO federadoDAO;
    private EstandarDAO estandarDAO;
    private SeguroDAO seguroDAO;
    private ExcursionDAO excursionDAO;
    private InscripcionDAO inscripcionDAO;

    public ControlSocios(APPSenderosMontanas app, ControlDatos cDatos, ControlPeticiones cPeticiones) throws SQLException {
        this.app = app;
        this.cPeticiones = new ControlPeticiones();
        this.cDatos = new ControlDatos(app.getDatos(), cPeticiones);
        this.vSocios = new VistaSocios(this);
        this.vModificarSeguro = new VistaModificarSeguro(this);
        this.vListarSocios = new VistaListarSocios(this);
        this.vAddSocio = new VistaAddSocio(this);
        this.socioDAO = app.getDatos().getFabricaDAO().getSocioDAO();
        this.infantilDAO = app.getDatos().getFabricaDAO().getInfantilDAO();
        this.federadoDAO = app.getDatos().getFabricaDAO().getFederadoDAO();
        this.estandarDAO = app.getDatos().getFabricaDAO().getEstandarDAO();
        this.seguroDAO = app.getDatos().getFabricaDAO().getSeguroDAO();
        this.excursionDAO = app.getDatos().getFabricaDAO().getExcursionDAO();
        this.inscripcionDAO = app.getDatos().getFabricaDAO().getInscripcionDAO();
    }



    public void show() throws ParseException, SQLException {
        vSocios.show();
    }

    public void addSocio(Socio socio) throws SQLException {
        if (socio instanceof Infantil) {
            infantilDAO.insertarInfantil((Infantil) socio);
        } else if (socio instanceof Federado) {
            federadoDAO.insertarFederado((Federado) socio);
        } else if (socio instanceof Estandar) {
            estandarDAO.insertarEstandar((Estandar) socio);
        } else {
            socioDAO.insertarSocio(socio);
        }
    }

    public void listTipoSocios(int tipo) throws SQLException {
        ResultSet rs;
        switch (tipo) {
            case 1:
                rs = estandarDAO.listarEstandares();
                break;
            case 2:
                rs = federadoDAO.listarFederados();
                break;
            case 3:
                rs = infantilDAO.listarInfantiles();
                break;
            default:
                throw new IllegalArgumentException("Tipo de socio no válido");
        }
        while (rs.next()) {
            System.out.println("Nombre: " + rs.getString("nombreSocio") + ", Código: " + rs.getString("codigoSocio") + ", NIF: " + rs.getString("nifSocio"));
        }
    }
    public void listSocios() throws SQLException {
        ResultSet rs = socioDAO.listarSocios();
        while (rs.next()) {
            System.out.println("Nombre: " + rs.getString("nombreSocio") + ", Código: " + rs.getString("codigoSocio") + ", NIF: " + rs.getString("nifSocio"));
        }
    }

    public void removeSocio(String codigo) throws SQLException {
        Socio socio = socioDAO.getSocio(codigo);
        if (socio != null) {
            if (socio instanceof Infantil) {
                infantilDAO.eliminarInfantil((Infantil) socio);
            } else if (socio instanceof Federado) {
                federadoDAO.eliminarFederado((Federado) socio);
            } else if (socio instanceof Estandar) {
                estandarDAO.eliminarEstandar((Estandar) socio);
            } else {
                socioDAO.eliminarSocio(socio);
            }
            System.out.println("Socio eliminado correctamente.");
        } else {
            System.out.println("Socio no encontrado.");
        }
    }

    public void modificarSocio(Socio socio) throws SQLException {
        if (socio instanceof Infantil) {
            infantilDAO.modificarInfantil((Infantil) socio);
        } else if (socio instanceof Federado) {
            federadoDAO.modificarFederado((Federado) socio);
        } else if (socio instanceof Estandar) {
            estandarDAO.modificarEstandar((Estandar) socio);
        } else {
            socioDAO.modificarSocio(socio);
        }
    }

    public Seguro buscarSeguro(int id) throws SQLException {
        return seguroDAO.buscarSeguro(id);
    }

    public ResultSet listarSeguros() throws SQLException {
        return seguroDAO.listarSeguros();
    }

    public void showVistaAddSocio() throws SQLException, ParseException {
        vAddSocio.show();
    }

    public void showVistaListarSocios() throws SQLException, ParseException {
        vListarSocios.show();
    }

    public void showVistaModificarSeguro() throws SQLException, ParseException {
        vModificarSeguro.show();
    }

    // Métodos de cálculo de facturas

    public void calcularFacturaMensualSocios() throws SQLException {
        LocalDate fechaFinal = LocalDate.now();
        LocalDate fechaInicial = fechaFinal.minusMonths(1);
        ResultSet rs = inscripcionDAO.getInscripcionesPorFecha(fechaInicial, fechaFinal);
        float totalFactura = 0;

        while (rs.next()) {
            String codigoExcursion = rs.getString("idExcursion");
            Excursion excursion = excursionDAO.getExcursion(codigoExcursion);
            totalFactura += excursion.getPrecio();
        }

        System.out.println("Total factura mensual de los socios: " + totalFactura + " euros.");
    }

    public void calcularFacturaFechas(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException {
        ResultSet rs = inscripcionDAO.getInscripcionesPorFecha(fechaInicial, fechaFinal);
        float totalFactura = 0;

        while (rs.next()) {
            String codigoExcursion = rs.getString("idExcursion");
            Excursion excursion = excursionDAO.getExcursion(codigoExcursion);
            totalFactura += excursion.getPrecio();
        }

        System.out.println("Total factura entre fechas de los socios: " + totalFactura + " euros.");
    }

    public void calcularFacturasFechasSocio(String numeroSocio, LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException {
        ResultSet rs = inscripcionDAO.getInscripcionesPorFecha(fechaInicial, fechaFinal);
        float totalFactura = 0;

        while (rs.next()) {
            String codigoSocio = rs.getString("idSocio");
            if (codigoSocio.equals(numeroSocio)) {
                String codigoExcursion = rs.getString("idExcursion");
                Excursion excursion = excursionDAO.getExcursion(codigoExcursion);
                totalFactura += excursion.getPrecio();
            }
        }

        System.out.println("Total factura entre fechas para el socio " + numeroSocio + ": " + totalFactura + " euros.");
    }

    // Getters

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

    public APPSenderosMontanas getApp() {
        return app;
    }

    public void setVistaSocios(VistaSocios vSocios) {
        this.vSocios = vSocios;
    }

    public void setVistaListarSocios(VistaListarSocios vListarSocios) {
        this.vListarSocios = vListarSocios;
    }

    public void setVistaAddSocio(VistaAddSocio vAddSocio) {
        this.vAddSocio = vAddSocio;
    }

    public void setVistaModificarSeguro(VistaModificarSeguro vModificarSeguro) {
        this.vModificarSeguro = vModificarSeguro;
    }
}
