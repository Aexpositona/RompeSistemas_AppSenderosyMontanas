package RompeSistemas.Controlador;

import RompeSistemas.Modelo.Inscripcion;
import RompeSistemas.ModeloDAO.InscripcionDAO;
import RompeSistemas.Vista.VistaInscripciones;
import RompeSistemas.Vista.VistaAddInscripcion;
import RompeSistemas.Vista.VistaListarInscripciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ControlInscripciones {
    private APPSenderosMontanas app;
    private VistaInscripciones vInscripciones;
    private VistaAddInscripcion vAddInscripcion;
    private VistaListarInscripciones vListarInscripciones;
    private ControlPeticiones cPeticiones;
    private ControlDatos cDatos;
    private InscripcionDAO inscripcionDAO;

    public ControlInscripciones(APPSenderosMontanas app, ControlPeticiones cPeticiones) throws SQLException {
        this.app = app;
        this.cPeticiones = cPeticiones;
        this.vInscripciones = new VistaInscripciones(this);
        this.vAddInscripcion = new VistaAddInscripcion(this);
        this.vListarInscripciones = new VistaListarInscripciones(this);
        this.cPeticiones = new ControlPeticiones();
        this.cDatos = new ControlDatos(app.getDatos());
        this.inscripcionDAO = app.getDatos().getFabricaDAO().getInscripcionDAO();
    }



    public void show() throws SQLException {
        vInscripciones.show();
    }

    public void addInscripcion(Inscripcion inscripcion) throws SQLException {
        inscripcionDAO.insertarInscripcion(inscripcion);
    }

    public void listInscripciones() throws SQLException {
        ResultSet rs = inscripcionDAO.getAllInscripciones();
        while (rs.next()) {
            System.out.println("Código Inscripción: " + rs.getString("codigoInscripcion") +
                    ", Fecha Inscripción: " + rs.getDate("fechaInscripcion").toLocalDate() +
                    ", Código Socio: " + rs.getString("idSocio") +
                    ", Código Excursión: " + rs.getString("idExcursion"));
        }
    }

    public void listInscripcionesSocio(String idSocio) throws SQLException {
        ResultSet rs = inscripcionDAO.getInscripcionesPorSocio(idSocio);
        while (rs.next()) {
            System.out.println("Código Inscripción: " + rs.getString("codigoInscripcion") +
                    ", Fecha Inscripción: " + rs.getDate("fechaInscripcion").toLocalDate() +
                    ", Código Socio: " + rs.getString("idSocio") +
                    ", Código Excursión: " + rs.getString("idExcursion"));
        }
    }

    public void listInscripcionesFechas(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException {
        ResultSet rs = inscripcionDAO.getInscripcionesPorFecha(fechaInicial, fechaFinal);
        while (rs.next()) {
            System.out.println("Código Inscripción: " + rs.getString("codigoInscripcion") +
                    ", Fecha Inscripción: " + rs.getDate("fechaInscripcion").toLocalDate() +
                    ", Código Socio: " + rs.getString("idSocio") +
                    ", Código Excursión: " + rs.getString("idExcursion"));
        }
    }

    public void removeInscripcion(String codigo) throws SQLException {
        Inscripcion inscripcion = inscripcionDAO.getInscripcion(codigo);
        if (inscripcion != null) {
            inscripcionDAO.eliminarInscripcion(inscripcion);
            System.out.println("Inscripción eliminada correctamente.");
        } else {
            System.out.println("Inscripción no encontrada.");
        }
    }

    public void modificarInscripcion(Inscripcion inscripcion) throws SQLException {
        inscripcionDAO.modificarInscripcion(inscripcion);
    }

    // Getters para vistas y controladores
    public VistaInscripciones getVistaInscripciones() {
        return vInscripciones;
    }

    public VistaAddInscripcion getVistaAddInscripcion() {
        return vAddInscripcion;
    }

    public VistaListarInscripciones getVistaListarInscripciones() {
        return vListarInscripciones;
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

    public void setVistaInscripciones(VistaInscripciones vInscripciones) {
        this.vInscripciones = vInscripciones;
    }

    public void setVistaListarInscripciones(VistaListarInscripciones vListarInscripciones) {
        this.vListarInscripciones = vListarInscripciones;
    }

    public void setVistaAddInscripcion(VistaAddInscripcion vAddInscripcion) {
        this.vAddInscripcion = vAddInscripcion;
    }
}
