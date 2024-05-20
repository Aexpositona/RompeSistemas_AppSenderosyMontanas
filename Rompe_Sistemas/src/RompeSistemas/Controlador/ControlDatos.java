package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
import RompeSistemas.ModeloDAO.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase ControlDatos.
 * Esta clase se encarga de gestionar los datos de la aplicación.
 * Se encarga de comprobar el tipo de objeto, validar la longitud del código o número de un objeto,
 * comprobar la existencia de un objeto en la base de datos, verificar si un socio está en una inscripción,
 * verificar si un socio es tutor de un socio infantil y comprobar la existencia de un NIF en la base de datos.
 */
public class ControlDatos {
    private Datos datos;
    private SocioDAO socioDAO;
    private InfantilDAO infantilDAO;
    private FederadoDAO federadoDAO;
    private EstandarDAO estandarDAO;
    private ExcursionDAO excursionDAO;
    private InscripcionDAO inscripcionDAO;
    private FederacionDAO federacionDAO;

    public ControlDatos(Datos datos) throws SQLException {
        this.datos = datos;
        FabricaDAO fabricaDAO = datos.getFabricaDAO();
        this.socioDAO = fabricaDAO.getSocioDAO();
        this.infantilDAO = fabricaDAO.getInfantilDAO();
        this.federadoDAO = fabricaDAO.getFederadoDAO();
        this.estandarDAO = fabricaDAO.getEstandarDAO();
        this.excursionDAO = fabricaDAO.getExcursionDAO();
        this.inscripcionDAO = fabricaDAO.getInscripcionDAO();
        this.federacionDAO = fabricaDAO.getFederacionDAO();
    }

    // Constructor vacío
    public ControlDatos() throws SQLException {
        this(new Datos());
    }

    // Métodos
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

    public Socio getSocio(String codigo) throws SQLException {
        return socioDAO.getSocio(codigo);
    }

    public Federacion getFederacion(String codigo) throws SQLException {
        return federacionDAO.getFederacion(codigo);
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

    public void eliminarSocio(Socio socio) throws SQLException {
        if (socio instanceof Infantil) {
            infantilDAO.eliminarInfantil((Infantil) socio);
        } else if (socio instanceof Federado) {
            federadoDAO.eliminarFederado((Federado) socio);
        } else if (socio instanceof Estandar) {
            estandarDAO.eliminarEstandar((Estandar) socio);
        } else {
            socioDAO.eliminarSocio(socio);
        }
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

    /**
     * Método para comprobar la existencia de un objeto en la base de datos.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param codigo     Código del objeto
     * @return true si el objeto existe, false en caso contrario
     */
    public boolean checkExistenciaObjeto(int tipoObjeto, String codigo) throws SQLException {
        Object objeto = null;

        switch (tipoObjeto) {
            case 1:
                objeto = excursionDAO.getExcursion(codigo);
                break;
            case 2:
                objeto = inscripcionDAO.getInscripcion(codigo);
                break;
            case 3:
                objeto = socioDAO.getSocio(codigo);
                break;
            case 4:
                objeto = federacionDAO.getFederacion(codigo);
                break;
            default:
                throw new IllegalArgumentException("Tipo de objeto no válido");
        }

        return objeto != null;
    }

    /**
     * Método para verificar si un socio está en una inscripción.
     *
     * @param idSocio ID del socio
     * @return true si el socio está en una inscripción, false en caso contrario
     */
    public boolean isSocioInInscripcion(int idSocio) throws SQLException {
        ResultSet inscripciones = inscripcionDAO.listarInscripciones();
        while (inscripciones.next()) {
            if (inscripciones.getString("idSocio").equals(idSocio)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para verificar si un socio es tutor de un socio infantil.
     *
     * @param numeroSocio El número del socio a verificar.
     * @return Verdadero si el socio es tutor de un socio infantil, falso en caso contrario.
     */
    public boolean isSocioInInfantil(String numeroSocio) throws SQLException {
        ResultSet infantiles = infantilDAO.listarInfantiles();
        while (infantiles.next()) {
            if (infantiles.getString("codigoSocioTutor").equals(numeroSocio)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para comprobar la existencia de un NIF en la base de datos.
     *
     * @param nif El NIF a comprobar.
     * @return true si el NIF existe, false en caso contrario.
     */
    public boolean checkExistenciaNIF(String nif) throws SQLException {
        ResultSet socios = socioDAO.listarSocios();
        while (socios.next()) {
            if (socios.getString("nifSocio").equals(nif)) {
                return true;
            }
        }
        return false;
    }
}
