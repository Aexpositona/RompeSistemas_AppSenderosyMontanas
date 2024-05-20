package RompeSistemas.Modelo;

import RompeSistemas.Datos.*;
import RompeSistemas.ModeloDAO.*;
import RompeSistemas.Datos.SQLSocioDAO;
import java.sql.*;
import java.time.LocalDate;

/**
 * Clase que representa la capa de datos de la aplicación.
 *
 */
public class Datos {
    // Atributos
    private FabricaDAO fabricaDAO;

    // Constructor
    public Datos() {
        this.fabricaDAO = new SQLFabricaDAO();
    }

    // Métodos

    /**
     * Método para obtener un Seguro de la base de datos.
     *
     * @param id El ID del Seguro que se quiere obtener.
     * @return El Seguro con el ID proporcionado.
     * @throws SQLException Si ocurre un error al obtener el Seguro de la base de datos.
     */
    public Seguro getSeguro(int id) throws SQLException {
        SeguroDAO seguroDAO = fabricaDAO.getSeguroDAO();
        return seguroDAO.getSeguro(id);
    }

    /**
     * Método para obtener un objeto de un tipo específico de la base de datos.
     *
     * @param tipoObjeto Tipo de objeto
     *                      1 - Excursión
     *                      2 - Inscripción
     *                      3 - Socio
     *                      4 - Federación
     * @return El primer objeto del tipo especificado que se encuentra en la base de datos.
     * @throws SQLException Si ocurre un error al obtener el objeto de la base de datos.
     */
    public Object getPrimerObjeto(int tipoObjeto) throws SQLException {
        Object objeto = null;
        Connection conexion = DatabaseConnection.getConnection();
        Statement statement = conexion.createStatement();
        String query = "";
        switch (tipoObjeto) {
            case 1 -> query = "SELECT * FROM Excursion LIMIT 1";
            case 2 -> query = "SELECT * FROM Inscripcion LIMIT 1";
            case 3 -> query = "SELECT * FROM Socio LIMIT 1";
            case 4 -> query = "SELECT * FROM Federacion LIMIT 1";
        }
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            switch (tipoObjeto) {
                case 1 -> objeto = new Excursion(
                        resultSet.getString("codigoExcursion"),
                        resultSet.getString("descripcion"),
                        resultSet.getDate("fecha").toLocalDate(),
                        resultSet.getInt("duracion"),
                        resultSet.getFloat("precio")
                );
                case 2 -> objeto = new Inscripcion(
                        resultSet.getString("codigoInscripcion"),
                        resultSet.getDate("fechaInscripcion").toLocalDate(),
                        resultSet.getString("idSocio"),
                        resultSet.getString("idExcursion")
                );
                case 3 -> {
                    String codigoSocio = resultSet.getString("codigoSocio");
                    String nombreSocio = resultSet.getString("nombreSocio");
                    String nifSocio = resultSet.getString("nifSocio");

                    // Instanciar los DAOs
                    SQLSocioDAO socioDAO = new SQLSocioDAO();
                    SQLSeguroDAO seguroDAO = new SQLSeguroDAO();
                    SQLFederacionDAO federacionDAO = new SQLFederacionDAO();

                    // Consulta adicional para obtener datos de Estandar
                    Statement statementEstandar = conexion.createStatement();
                    ResultSet resultSetEstandar = statementEstandar.executeQuery("SELECT * FROM Estandar WHERE idSocio = " + codigoSocio);
                    if (resultSetEstandar.next()) {
                        int idSeguro = resultSetEstandar.getInt("idSeguro");
                        Seguro seguro = seguroDAO.buscarSeguro(idSeguro); // Asume que tienes un método buscarSeguro que devuelve un objeto Seguro a partir de su ID
                        objeto = new Estandar(codigoSocio, nombreSocio, nifSocio, seguro);
                    }

                    // Consulta adicional para obtener datos de Infantil
                    Statement statementInfantil = conexion.createStatement();
                    ResultSet resultSetInfantil = statementInfantil.executeQuery("SELECT * FROM Infantil WHERE idSocio = " + codigoSocio);
                    if (resultSetInfantil.next()) {
                        int idSocioTutor = resultSetInfantil.getInt("idSocioTutor");
                        Socio socioTutor = socioDAO.buscarSocio(idSocioTutor); // Asume que tienes un método buscarSocio que devuelve un objeto Socio a partir de su ID
                        String numSocioTutor = socioTutor.getNumero(); // Asume que tienes un método getCodigoSocio que devuelve el ID del Socio como un String
                        objeto = new Infantil(codigoSocio, nombreSocio, nifSocio, numSocioTutor);
                    }

                    // Consulta adicional para obtener datos de Federado
                    Statement statementFederado = conexion.createStatement();
                    ResultSet resultSetFederado = statementFederado.executeQuery("SELECT * FROM Federado WHERE idSocio = " + codigoSocio);
                    if (resultSetFederado.next()) {
                        int idFederacion = resultSetFederado.getInt("idFederacion");
                        Federacion federacion = federacionDAO.buscarFederacion(idFederacion); // Asume que tienes un método buscarFederacion que devuelve un objeto Federacion a partir de su ID
                        objeto = new Federado(codigoSocio, nombreSocio, nifSocio, federacion);
                    }
                }
                case 4 -> objeto = new Federacion(
                        resultSet.getString("codigoFederacion"),
                        resultSet.getString("nombreFederacion")
                );            }
        }
        return objeto;
    }

    /**
     * Método para agregar un objeto a la base de datos.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param objeto El objeto que se quiere agregar.
     * @throws SQLException Si ocurre un error al agregar el objeto a la base de datos.
     */
    public void addObjeto(int tipoObjeto, Object objeto) throws SQLException {
        switch (tipoObjeto) {
            case 1 -> {
                ExcursionDAO excursionDAO = fabricaDAO.getExcursionDAO();
                excursionDAO.addExcursion((Excursion) objeto);
            }
            case 2 -> {
                InscripcionDAO inscripcionDAO = fabricaDAO.getInscripcionDAO();
                inscripcionDAO.insertarInscripcion((Inscripcion) objeto);
            }
            case 3 -> {
                SocioDAO socioDAO = fabricaDAO.getSocioDAO();
                socioDAO.insertarSocio((Socio) objeto);
            }
            case 4 -> {
                FederacionDAO federacionDAO = fabricaDAO.getFederacionDAO();
                federacionDAO.insertarFederacion((Federacion) objeto);
            }
        }
    }

    /**
     * Método para eliminar un objeto de la base de datos.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param objeto El objeto que se quiere eliminar.
     * @throws SQLException Si ocurre un error al eliminar el objeto de la base de datos.
     */
    public void removeObjeto(int tipoObjeto, Object objeto) throws SQLException {
        // Obtener el DAO correspondiente y eliminar el objeto
        switch (tipoObjeto) {
            // Si el tipo de objeto es 1, eliminar una Excursión
            case 1 -> {
                ExcursionDAO excursionDAO = fabricaDAO.getExcursionDAO();
                excursionDAO.deleteExcursion((Excursion) objeto);
            }
            // Si el tipo de objeto es 2, eliminar una Inscripción
            case 2 -> {
                InscripcionDAO inscripcionDAO = fabricaDAO.getInscripcionDAO();
                inscripcionDAO.eliminarInscripcion((Inscripcion) objeto);
            }
            // Si el tipo de objeto es 3, eliminar un Socio
            case 3 -> {
                SocioDAO socioDAO = fabricaDAO.getSocioDAO();
                socioDAO.eliminarSocio((Socio) objeto);
            }
            // Si el tipo de objeto es 4, eliminar una Federación
            case 4 -> {
                FederacionDAO federacionDAO = fabricaDAO.getFederacionDAO();
                federacionDAO.eliminarFederacion((Federacion) objeto);
            }
        }
    }

    /**
     * Método para modificar un objeto en la base de datos.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param objeto El objeto que se quiere modificar.
     * @throws SQLException Si ocurre un error al modificar el objeto en la base de datos.
     */
    public void modifyObjeto(int tipoObjeto, Object objeto) throws SQLException {
        switch (tipoObjeto) {
            case 1 -> {
                ExcursionDAO excursionDAO = fabricaDAO.getExcursionDAO();
                excursionDAO.updateExcursion((Excursion) objeto);
            }
            case 2 -> {
                InscripcionDAO inscripcionDAO = fabricaDAO.getInscripcionDAO();
                inscripcionDAO.modificarInscripcion((Inscripcion) objeto);
            }
            case 3 -> {
                SocioDAO socioDAO = fabricaDAO.getSocioDAO();
                socioDAO.modificarSocio((Socio) objeto);
            }
            case 4 -> {
                FederacionDAO federacionDAO = fabricaDAO.getFederacionDAO();
                federacionDAO.modificarFederacion((Federacion) objeto);
            }
        }
    }

    /**
     * Método para obtener un objeto de un tipo específico de la base de datos.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param id El ID del objeto que se quiere obtener.
     * @return El objeto con el ID proporcionado.
     * @throws SQLException Si ocurre un error al obtener el objeto de la base de datos.
     */
    public Object getObjeto(int tipoObjeto, int id) throws SQLException {
        Object objeto = null;
        switch (tipoObjeto) {
            case 1 -> {
                ExcursionDAO excursionDAO = fabricaDAO.getExcursionDAO();
                objeto = excursionDAO.getExcursion(String.valueOf(id));
            }
            case 2 -> {
                InscripcionDAO inscripcionDAO = fabricaDAO.getInscripcionDAO();
                objeto = inscripcionDAO.buscarInscripcion(String.valueOf(id));
            }
            case 3 -> {
                SocioDAO socioDAO = fabricaDAO.getSocioDAO();
                objeto = socioDAO.buscarSocio(id);
            }
            case 4 -> {
                FederacionDAO federacionDAO = fabricaDAO.getFederacionDAO();
                objeto = federacionDAO.buscarFederacion(id);
            }
        }
        return objeto;
    }

    /**
     * Método para buscar un objeto en la base de datos.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param codigo El código del objeto que se quiere buscar.
     * @return ID del objeto si se encuentra, -1 si no se encuentra
     * @throws SQLException Si ocurre un error al buscar el objeto en la base de datos.
     */
    public int buscarObjeto(int tipoObjeto, String codigo) throws SQLException {
        int id = -1;
        switch (tipoObjeto) {
            case 1 -> {
                ExcursionDAO excursionDAO = fabricaDAO.getExcursionDAO();
                id = excursionDAO.getExcursion(codigo).getDuracion();
            }
            case 2 -> {
                InscripcionDAO inscripcionDAO = fabricaDAO.getInscripcionDAO();
                id = inscripcionDAO.buscarInscripcion(codigo).getSocio().getTipo();
            }
            case 3 -> {
                SocioDAO socioDAO = fabricaDAO.getSocioDAO();
                id = socioDAO.buscarSocio(codigo).getTipo();
            }
            case 4 -> {
                FederacionDAO federacionDAO = fabricaDAO.getFederacionDAO();
                id = Integer.parseInt(federacionDAO.buscarFederacion(codigo).getCodigo());            }
        }
        return id;
    }

    /**
     * Método para listar los objetos de un tipo específico de la base de datos.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @return Array de objetos del tipo especificado.
     * @throws SQLException Si ocurre un error al obtener los objetos de la base de datos.
     */
    public ResultSet listObjetos(int tipoObjeto) throws SQLException {
        ResultSet objetos = null;
        switch (tipoObjeto) {
            case 1 -> {
                ExcursionDAO excursionDAO = fabricaDAO.getExcursionDAO();
                objetos = excursionDAO.getAllExcursiones();
            }
            case 2 -> {
                InscripcionDAO inscripcionDAO = fabricaDAO.getInscripcionDAO();
                objetos = inscripcionDAO.listarInscripciones();
            }
            case 3 -> {
                SocioDAO socioDAO = fabricaDAO.getSocioDAO();
                objetos = socioDAO.listarSocios();
            }
            case 4 -> {
                FederacionDAO federacionDAO = fabricaDAO.getFederacionDAO();
                objetos = federacionDAO.listarFederaciones();
            }
        }
        return objetos;
    }
    /**
     * Método para listar los objetos de la base de datos en formato String.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @return Lista de objetos en formato String
     */
    public String listToStringObjetos(int tipoObjeto) {
        StringBuilder result = new StringBuilder();
        try {
            ResultSet resultSet = null;
            switch (tipoObjeto) {
                case 1 -> {
                    ExcursionDAO excursionDAO = fabricaDAO.getExcursionDAO();
                    resultSet = excursionDAO.getAllExcursiones();
                }
                case 2 -> {
                    InscripcionDAO inscripcionDAO = fabricaDAO.getInscripcionDAO();
                    resultSet = inscripcionDAO.listarInscripciones();
                }
                case 3 -> {
                    SocioDAO socioDAO = fabricaDAO.getSocioDAO();
                    resultSet = socioDAO.listarSocios();
                }
                case 4 -> {
                    FederacionDAO federacionDAO = fabricaDAO.getFederacionDAO();
                    resultSet = federacionDAO.listarFederaciones();
                }
            }

            // Si hay resultados, convertirlos a String y añadirlos al StringBuilder
            while (resultSet != null && resultSet.next()) {
                switch (tipoObjeto) {
                    case 1 -> {
                        result.append("Excursion: ").append(resultSet.getString("codigoExcursion")).append(", ").append(resultSet.getString("descripcion")).append(", ").append(resultSet.getDate("fecha").toLocalDate()).append(", ").append(resultSet.getInt("duracion")).append(", ").append(resultSet.getFloat("precio")).append("\n");
                    }
                    case 2 -> {
                        result.append("Inscripcion: ").append(resultSet.getString("codigoInscripcion")).append(", ").append(resultSet.getDate("fechaInscripcion").toLocalDate()).append(", ").append(resultSet.getString("idSocio")).append(", ").append(resultSet.getString("idExcursion")).append("\n");
                    }
                    case 3 -> {
                        result.append("Socio: ").append(resultSet.getString("nombreSocio")).append(", ").append(resultSet.getString("codigoSocio")).append(", ").append(resultSet.getString("nifSocio")).append("\n");
                    }
                    case 4 -> {
                        result.append("Federacion: ").append(resultSet.getString("codigoFederacion")).append(", ").append(resultSet.getString("nombreFederacion")).append("\n");
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de la base de datos: " + e.getMessage());
        }
        return result.toString();
    }


    /**
     * Método para listar los objetos de la base de datos en un rango de fechas en formato String.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     * @param fechaInicial Fecha inicial
     * @param fechaFinal Fecha final
     * @return Lista de objetos en formato String
     */
    /**
     * Método para listar los objetos de la base de datos en un rango de fechas en formato String.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     * @param fechaInicial Fecha inicial
     * @param fechaFinal Fecha final
     * @return Lista de objetos en formato String
     * @throws SQLException Si ocurre un error al obtener los objetos de la base de datos.
     */
    public String listToStringObjetosFechas(int tipoObjeto, LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException {
        StringBuilder result = new StringBuilder();
        ResultSet resultSet = null;
        switch (tipoObjeto) {
            case 1 -> {
                ExcursionDAO excursionDAO = fabricaDAO.getExcursionDAO();
                resultSet = excursionDAO.getExcursionesPorFecha(fechaInicial, fechaFinal);
            }
            case 2 -> {
                InscripcionDAO inscripcionDAO = fabricaDAO.getInscripcionDAO();
                resultSet = inscripcionDAO.getInscripcionesPorFecha(fechaInicial, fechaFinal);
            }
            // Para el caso 3 (Socio), no hay un campo de fecha en la tabla Socio, por lo que no se puede filtrar por fechas.
        }

        // Si hay resultados, convertirlos a String y añadirlos al StringBuilder
        while (resultSet != null && resultSet.next()) {
            switch (tipoObjeto) {
                case 1 -> {
                    // Aquí debes reemplazar los métodos get con los nombres de los campos de tu tabla Excursion
                    result.append("Excursion: ").append(resultSet.getString("codigoExcursion")).append(", ").append(resultSet.getString("descripcion")).append(", ").append(resultSet.getDate("fecha").toLocalDate()).append(", ").append(resultSet.getInt("duracion")).append(", ").append(resultSet.getFloat("precio")).append("\n");
                }
                case 2 -> {
                    // Aquí debes reemplazar los métodos get con los nombres de los campos de tu tabla Inscripcion
                    result.append("Inscripcion: ").append(resultSet.getString("codigoInscripcion")).append(", ").append(resultSet.getDate("fechaInscripcion").toLocalDate()).append(", ").append(resultSet.getString("idSocio")).append(", ").append(resultSet.getString("idExcursion")).append("\n");
                }
            }
        }
        return result.toString();
    }
    /**
     * Método para obtener el siguiente código de un tipo de objeto.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @return Siguiente código
     */
    public String getSiguienteCodigo(int tipoObjeto) {
        String siguienteCodigo = "";
        try {
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            String query = "";
            switch (tipoObjeto) {
                case 1 -> query = "SELECT codigoExcursion FROM Excursion ORDER BY codigoExcursion DESC LIMIT 1";
                case 2 -> query = "SELECT codigoInscripcion FROM Inscripcion ORDER BY codigoInscripcion DESC LIMIT 1";
                case 3 -> query = "SELECT codigoSocio FROM Socio ORDER BY codigoSocio DESC LIMIT 1";
                case 4 -> query = "SELECT codigoFederacion FROM Federacion ORDER BY codigoFederacion DESC LIMIT 1";
            }
            ResultSet resultSet = statement.executeQuery(query);

            // Si hay resultados, obtener el último código y generar el siguiente
            if (resultSet.next()) {
                String ultimoCodigo = resultSet.getString(1);
                int numero = Integer.parseInt(ultimoCodigo.substring(3));
                numero++;
                String relleno = numero < 10 ? "000" : numero < 100 ? "00" : numero < 1000 ? "0" : "";
                siguienteCodigo = ultimoCodigo.substring(0, 3) + relleno + numero;
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el siguiente código de la base de datos: " + e.getMessage());
        }
        return siguienteCodigo;
    }

    /**
     * Método para obtener el último código de un tipo de objeto.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @return Último código
     */
    public String getUltimoCodigo(int tipoObjeto) {
        String ultimoCodigo = "";
        try {
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            String query = "";
            switch (tipoObjeto) {
                case 1 -> query = "SELECT codigoExcursion FROM Excursion ORDER BY codigoExcursion DESC LIMIT 1";
                case 2 -> query = "SELECT codigoInscripcion FROM Inscripcion ORDER BY codigoInscripcion DESC LIMIT 1";
                case 3 -> query = "SELECT codigoSocio FROM Socio ORDER BY codigoSocio DESC LIMIT 1";
                case 4 -> query = "SELECT codigoFederacion FROM Federacion ORDER BY codigoFederacion DESC LIMIT 1";
            }
            ResultSet resultSet = statement.executeQuery(query);

            // Si hay resultados, obtener el último código
            if (resultSet.next()) {
                ultimoCodigo = resultSet.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el último código de la base de datos: " + e.getMessage());
        }
        return ultimoCodigo;
    }

    /**
     * Método para obtener los objetos de la base de datos que cumplen con un parámetro específico.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param parametro El parámetro específico para filtrar los objetos
     * @return String que representa los objetos que cumplen con el parámetro
     */
    public String listParametroObjeto(int tipoObjeto, String parametro) {
        StringBuilder result = new StringBuilder();
        try {
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            String query = "";
            switch (tipoObjeto) {
                case 1 -> query = "SELECT * FROM Excursion WHERE descripcion LIKE '%" + parametro + "%'";
                case 2 -> query = "SELECT * FROM Inscripcion WHERE codigoInscripcion LIKE '%" + parametro + "%'";
                case 3 -> query = "SELECT * FROM Socio WHERE nombreSocio LIKE '%" + parametro + "%'";
                case 4 -> query = "SELECT * FROM Federacion WHERE nombreFederacion LIKE '%" + parametro + "%'";
            }
            ResultSet resultSet = statement.executeQuery(query);

            // Si hay resultados, convertirlos a String y añadirlos al StringBuilder
            while (resultSet.next()) {
                // Aquí necesitarás ajustar el código para que coincida con tu esquema de base de datos
                // y convertir cada resultado a String de la manera que prefieras
                result.append(resultSet.getString(1)).append("\n");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de la base de datos: " + e.getMessage());
        }
        return result.toString();
    }
}

