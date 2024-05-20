package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
import RompeSistemas.ModeloDAO.*;
import RompeSistemas.Vista.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

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

    public ControlSocios(APPSenderosMontanas app) throws SQLException {
        this.app = app;
        this.vSocios = new VistaSocios(this);
        this.vModificarSeguro = new VistaModificarSeguro(this);
        this.vListarSocios = new VistaListarSocios(this);
        this.vAddSocio = new VistaAddSocio(this);
        this.cPeticiones = new ControlPeticiones();
        this.cDatos = new ControlDatos(app.getDatos());
        this.socioDAO = app.getDatos().getFabricaDAO().getSocioDAO();
        this.infantilDAO = app.getDatos().getFabricaDAO().getInfantilDAO();
        this.federadoDAO = app.getDatos().getFabricaDAO().getFederadoDAO();
        this.estandarDAO = app.getDatos().getFabricaDAO().getEstandarDAO();
        this.seguroDAO = app.getDatos().getFabricaDAO().getSeguroDAO();
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
}
