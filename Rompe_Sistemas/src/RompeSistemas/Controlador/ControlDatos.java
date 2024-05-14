package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
import java.sql.SQLException;

/**
 * Clase ControlDatos.
 * Esta clase se encarga de gestionar los datos de la aplicación.
 * Se encarga de comprobar el tipo de objeto, validar la longitud del código o número de un objeto,
 * comprobar la existencia de un objeto en la base de datos, verificar si un socio está en una inscripción,
 * verificar si un socio es tutor de un socio infantil y comprobar la existencia de un NIF en la base de datos.
 */
public class ControlDatos {

    // Atributos
    private final Datos datos;


    // Constructor
    public ControlDatos(APPSenderosMontanas app) {
        this.datos = app.getDatos();
    }
    // Constructor de copia
    public ControlDatos (ControlDatos cDatos) {
        this.datos = new Datos();
    }

    // Constructor vacío
    public ControlDatos() {
        this.datos = null;
    }

    // Métodos

    /**
     * Método para comprobar el tipo de objeto.
     * @param O Recibe el objeto.
     * @return int - Devuelve el tipo de objeto.
     *          1-Excursión
     *          2-Inscripción
     *          3-Socio
     *          4-Federación
     */
    public int checkTipoObjeto(Object O) {
        // Variables internas
        int tipoObjeto;
        // Si el objeto es un socio
        if (O instanceof Excursion){
            System.out.println("El objeto es una Excursion.");
            tipoObjeto = 1;
        }
        // Si el objeto es una inscripción
        else if(O instanceof Inscripcion) {
            System.out.println("El objeto es una Inscripción.");
            tipoObjeto = 2;
        }
        // Si el objeto es una excursión
        else if (O instanceof Socio) {
            System.out.println("El objeto es un Socio.");
            tipoObjeto = 3;
        }
        else if (O instanceof Federacion) {
            System.out.println("El objeto es una Federacion.");
            tipoObjeto = 4;
        }
        // Si el objeto no es un socio, una excursión o una inscripción
        else {
            System.out.println("El objeto no es un socio, una excursión o una inscripción.");
            tipoObjeto = 0;
        }
        // Devolvemos el tipo de objeto
        return tipoObjeto;
    }

    /**
     * Metodo para validar la longitud del código o número de un objeto.
     * En este Metodo validamos la longitud del código o número de un objeto.
     * Si el objeto introducido no reune las condiciones de longitud, informamos al usuario y devolvemos falso.
     * @param codigo Recibe el código o número del objeto.
     * @param tipoObjeto Recibe el tipo de objeto.
     *                  1-Excursión
     *                  2-Inscripción
     *                  3-Socio
     *                  4-Federación
     * @return boolean - Devuelve verdadero si el código o número del objeto es válido.
     */
    //Metodo para validar la longitud del código o número de un objeto
    public boolean checkCodigoObjeto(int tipoObjeto, String codigo){
        // Variables internas
        String mensaje = "";
        int cantidad = -1;
        // Si el objeto es una excursión
        if (tipoObjeto == 1) {
            // Mensaje de error
            mensaje = "El código de la excursión";
            // Cantidad de caracteres
            cantidad = 7;
        }
        // Si el objeto es una inscripción
        else if (tipoObjeto == 2) {
            // Mensaje de error
            mensaje = "El número de la inscripción";
            // Cantidad de caracteres
            cantidad = 7;
        }
        // Si el objeto es un socio
        else if (tipoObjeto == 3) {
            // Mensaje de error
            mensaje = "El número de socio";
            // Cantidad de caracteres
            cantidad = codigo.length();
        }
        else if (tipoObjeto == 4) {
            // Mensaje de error
            mensaje = "El código de la federación";
            // Cantidad de caracteres
            cantidad = 7;
        }
        // Si el objeto introducido no reune las condiciones de longitud
        if (codigo.length() != cantidad) {
            System.out.println(mensaje + " no puede estar vacío. Inténtelo de nuevo.");
            return false;
        }
        // Si el objeto introducido reune las condiciones de longitud
        else return true;
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
        
        // Variables internas
        FabricaDAO fabricaDAO = new SQLFabricaDAO();
        ExcursionDAO excursionDAO = fabricaDAO.getExcursionDAO();
        InscripcionDAO inscripcionDAO = fabricaDAO.getInscripcionDAO();
        SocioDAO socioDAO = fabricaDAO.getSocioDAO();
        FederacionDAO federacionDAO = fabricaDAO.getFederacionDAO();
        Object objeto = new Object();

        // Obtener el objeto DAO correspondiente al tipo de objeto
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

        // Si el objeto no es nulo, significa que existe en la base de datos
        if (objeto != null) {
            return true;
        } 
        // Si el objeto es nulo, significa que no existe en la base de datos
        else {
            return false;
        }
    }

    /**
     * Método para verificar si un socio está en una inscripción.
     *
     * @param idSocio ID del socio
     * @return true si el socio está en una inscripción, false en caso contrario
     */
    public boolean isSocioInInscripcion(int idSocio) throws SQLException {
        // Utilizamos el método buscarObjeto de la clase Datos para buscar una inscripción con el ID del socio
        int idInscripcion = datos.buscarObjeto(2, String.valueOf(idSocio));

        // Si el ID de la inscripción es -1, significa que no se encontró ninguna inscripción con el ID del socio
        if (idInscripcion == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Método para verificar si un socio es tutor de un socio infantil.
     *
     * @param numeroSocio El número del socio a verificar.
     * @return Verdadero si el socio es tutor de un socio infantil, falso en caso contrario.
     */
    public boolean isSocioInInfantil(String numeroSocio) {
        // Obtener la representación en cadena de todos los socios infantiles
        String infantiles = datos.listToStringObjetos(3);

        // Verificar si el número de socio aparece en la cadena
        return infantiles.contains(numeroSocio);
    }

    /**
     * Método para comprobar la existencia de un NIF en la base de datos.
     *
     * @param nif El NIF a comprobar.
     * @return true si el NIF existe, false en caso contrario.
     */
    public boolean checkExistenciaNIF(String nif) throws SQLException {
        // Inicializamos el id del socio a 1
        int idSocio = 1;
        // Obtenemos el socio con el id actual
        Socio socio = (Socio) datos.getObjeto(3, idSocio);

        // Mientras haya socios
        while (socio != null) {
            // Si el NIF del socio actual coincide con el NIF buscado, devolvemos true
            if (socio.getNif().equals(nif)) {
                return true;
            }
            // Incrementamos el id del socio y obtenemos el siguiente socio
            idSocio++;
            socio = (Socio) datos.getObjeto(3, idSocio);
        }

        // Si no hemos encontrado ningún socio con el NIF buscado, devolvemos false
        return false;
    }

}