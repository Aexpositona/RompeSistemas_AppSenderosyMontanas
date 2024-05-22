package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Excursion;
import RompeSistemas.ModeloDAO.ExcursionDAO;
import RompeSistemas.Vista.VistaExcursiones;
import RompeSistemas.Vista.VistaAddExcursion;
import RompeSistemas.Vista.VistaListarExcursiones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

public class ControlExcursiones {
    private ControlDatos cDatos;
    private ControlPeticiones cPeticiones;
    private Datos datos;
    private VistaExcursiones vExcursiones;
    private VistaAddExcursion vAddExcursion;
    private VistaListarExcursiones vListarExcursiones;
    private ExcursionDAO excursionDAO;

    public ControlExcursiones(APPSenderosMontanas app, ControlPeticiones cPeticiones) throws SQLException {
        this.vExcursiones = new VistaExcursiones(this);
        this.vAddExcursion = new VistaAddExcursion();
        this.vListarExcursiones = new VistaListarExcursiones();
        this.datos = app.getDatos();
        this.cDatos = app.getControlDatos();
        this.cPeticiones = app.getControlPeticiones();
        this.excursionDAO = datos.getFabricaDAO().getExcursionDAO();
    }

    public ControlExcursiones(ControlExcursiones cExcursiones) {
        this.vExcursiones = cExcursiones.getVistaExcursiones();
        this.vAddExcursion = cExcursiones.getVistaAddExcursion();
        this.vListarExcursiones = cExcursiones.getVistaListarExcursiones();
        this.datos = cExcursiones.getDatos();
        this.cDatos = cExcursiones.getControlDatos();
        this.cPeticiones = cExcursiones.getControlPeticiones();
        this.excursionDAO = cExcursiones.getExcursionDAO();
    }

    public ControlExcursiones() {
        this.vExcursiones = null;
        this.vAddExcursion = null;
        this.vListarExcursiones = null;
        this.datos = null;
        this.cDatos = null;
        this.cPeticiones = null;
        this.excursionDAO = null;
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

    public Datos getDatos() {
        return datos;
    }

    public ControlDatos getControlDatos() {
        return cDatos;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    public ExcursionDAO getExcursionDAO() {
        return excursionDAO;
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

    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    public void addExcursion(Excursion excursion) throws SQLException {
        excursionDAO.addExcursion(excursion);
    }

    public void removeExcursion(Excursion excursion) throws SQLException {
        excursionDAO.deleteExcursion(excursion);
    }

    public void listExcursiones() throws SQLException {
        ResultSet rs = excursionDAO.getAllExcursiones();
        while (rs.next()) {
            System.out.println("Código: " + rs.getString("codigoExcursion"));
            System.out.println("Descripción: " + rs.getString("descripcion"));
            System.out.println("Fecha: " + rs.getDate("fecha").toLocalDate());
            System.out.println("Duración: " + rs.getInt("duracion"));
            System.out.println("Precio: " + rs.getFloat("precio"));
            System.out.println();
        }
    }

    public void listExcursionesFechas(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException {
        ResultSet rs = excursionDAO.getExcursionesPorFecha(fechaInicial, fechaFinal);
        while (rs.next()) {
            System.out.println("Código: " + rs.getString("codigoExcursion"));
            System.out.println("Descripción: " + rs.getString("descripcion"));
            System.out.println("Fecha: " + rs.getDate("fecha").toLocalDate());
            System.out.println("Duración: " + rs.getInt("duracion"));
            System.out.println("Precio: " + rs.getFloat("precio"));
            System.out.println();
        }
    }

    public void showVistaListarExcursiones() throws SQLException {
        vListarExcursiones.show();
    }

    public void show() throws ParseException, SQLException {
        vExcursiones.show();
    }

    public void showVistaAddExcursion() throws ParseException, SQLException {
        vAddExcursion.show();
    }

    public String getUltimoCodigo() throws SQLException {
        return excursionDAO.getUltimoCodigo();
    }

    public String getSiguienteCodigo() throws SQLException {
        String ultimoCodigo = getUltimoCodigo();
        if (ultimoCodigo == null) {
            return "EXC0001";
        } else {
            int numero = Integer.parseInt(ultimoCodigo.substring(3)) + 1;
            return String.format("EXC%04d", numero);
        }
    }

    public boolean checkExistenciaExcursion(String codigoExcursion) throws SQLException {
        Excursion excursion = excursionDAO.getExcursion(codigoExcursion);
        return excursion != null;
    }

    public Excursion getExcursion(String codigoExcursion) throws SQLException {
        return excursionDAO.getExcursion(codigoExcursion);
    }
}
