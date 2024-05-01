package RompeSistemas.Modelo;

import RompeSistemas.Datos.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Clase que representa los datos de la aplicación.
 */
public class Datos {
    public Datos() {
    }


    // Métodos

    public Seguro getSeguro() {
        Seguro seguro = null;
        try {
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Seguro");

            // Si hay resultados, obtener el nombre del seguro y convertirlo a un valor de la Enum Seguro
            if (resultSet.next()) {
                String nombreSeguro = resultSet.getString("nombreSeguro");
                seguro = Seguro.valueOf(nombreSeguro.toUpperCase());
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el seguro de la base de datos: " + e.getMessage());
        }
        return seguro;
    }
    /**
     * Método para obtener un List de un tipo de objeto.
     *
     * @param tipoObjeto Tipo de objeto
     *                      1 - Excursión
     *                      2 - Inscripción
     *                      3 - Socio
     *                      4 - Federación
     * @return List de objetos
     */
    public void ListaTipoObjeto(int tipoObjeto) {
        try {
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            String query = "";
            switch (tipoObjeto) {
                case 1 -> query = "SELECT * FROM Excursion";
                case 2 -> query = "SELECT * FROM Inscripcion";
                case 3 -> query = "SELECT * FROM Socio";
                case 4 -> query = "SELECT * FROM Federacion";
            }
            ResultSet resultSet = statement.executeQuery(query);

            // Si hay resultados, imprimirlos directamente
            while (resultSet.next()) {
                switch (tipoObjeto) {
                    case 1 -> {
                        System.out.println("Excursion: " + resultSet.getString("codigoExcursion") + ", " +
                                resultSet.getString("descripcion") + ", " +
                                resultSet.getDate("fecha") + ", " +
                                resultSet.getInt("duracion") + ", " +
                                resultSet.getFloat("precio"));
                    }
                    case 2 -> {
                        System.out.println("Inscripcion: " + resultSet.getString("codigoInscripcion") + ", " +
                                resultSet.getDate("fechaInscripcion") + ", " +
                                resultSet.getString("idSocio") + ", " +
                                resultSet.getString("idExcursion"));
                    }
                    case 3 -> {
                        System.out.println("Socio: " + resultSet.getString("codigoSocio") + ", " +
                                resultSet.getString("nombreSocio") + ", " +
                                resultSet.getString("nifSocio"));
                    }
                    case 4 -> {
                        System.out.println("Federacion: " + resultSet.getString("codigoFederacion") + ", " +
                                resultSet.getString("nombreFederacion"));
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de la base de datos: " + e.getMessage());
        }
    }


    public void addObjeto(int tipoObjeto, Object objeto) {
        try {
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            String query = "";
            switch (tipoObjeto) {
                case 1 -> {
                    Excursion excursion = (Excursion) objeto;
                    query = "INSERT INTO Excursion (codigoExcursion, descripcion, fecha, duracion, precio) VALUES ('"
                            + excursion.getCodigo() + "', '"
                            + excursion.getDescripcion() + "', '"
                            + excursion.getFecha() + "', "
                            + excursion.getDuracion() + ", "
                            + excursion.getPrecio() + ")";
                }
                case 2 -> {
                    Inscripcion inscripcion = (Inscripcion) objeto;
                    query = "INSERT INTO Inscripcion (codigoInscripcion, fechaInscripcion, idSocio, idExcursion) VALUES ('"
                            + inscripcion.getNumero() + "', '"
                            + inscripcion.getFecha() + "', '"
                            + inscripcion.getSocio().getNumero() + "', '"
                            + inscripcion.getExcursion().getCodigo() + "')";
                }
                case 3 -> {
                    Socio socio = (Socio) objeto;
                    query = "INSERT INTO Socio (codigoSocio, nombreSocio, nifSocio) VALUES ('"
                            + socio.getNumero() + "', '"
                            + socio.getNombre() + "', '"
                            + socio.getNif() + "')";
                }
                case 4 -> {
                    Federacion federacion = (Federacion) objeto;
                    query = "INSERT INTO Federacion (codigoFederacion, nombreFederacion) VALUES ('"
                            + federacion.getCodigo() + "', '"
                            + federacion.getNombre() + "')";
                }
            }
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error al agregar el objeto a la base de datos: " + e.getMessage());
        }
    }

    /**
     * Método para eliminar un objeto de alguno de los ArrayList.
     * 
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param objeto     Objeto a eliminar
     */
    public void removeObjeto(int tipoObjeto, Object objeto) {
        try {
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            String query = "";
            switch (tipoObjeto) {
                case 1 -> {
                    Excursion excursion = (Excursion) objeto;
                    query = "DELETE FROM Excursion WHERE codigoExcursion = '" + excursion.getCodigo() + "'";
                }
                case 2 -> {
                    Inscripcion inscripcion = (Inscripcion) objeto;
                    query = "DELETE FROM Inscripcion WHERE codigoInscripcion = '" + inscripcion.getNumero() + "'";
                }
                case 3 -> {
                    Socio socio = (Socio) objeto;
                    query = "DELETE FROM Socio WHERE codigoSocio = '" + socio.getNumero() + "'";
                }
                case 4 -> {
                    Federacion federacion = (Federacion) objeto;
                    query = "DELETE FROM Federacion WHERE codigoFederacion = '" + federacion.getCodigo() + "'";
                }
            }
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error al eliminar el objeto de la base de datos: " + e.getMessage());
        }
    }

    /**
     * Método para modificar un objeto de alguno de los ArrayList.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param objeto     Objeto a modificar

     */
    public void modifyObjeto(int tipoObjeto, Object objeto) {
        try {
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            String query = "";
            switch (tipoObjeto) {
                case 1 -> {
                    Excursion excursion = (Excursion) objeto;
                    query = "UPDATE Excursion SET descripcion = '" + excursion.getDescripcion()
                            + "', fecha = '" + excursion.getFecha()
                            + "', duracion = " + excursion.getDuracion()
                            + ", precio = " + excursion.getPrecio()
                            + " WHERE codigoExcursion = '" + excursion.getCodigo() + "'";
                }
                case 2 -> {
                    Inscripcion inscripcion = (Inscripcion) objeto;
                    query = "UPDATE Inscripcion SET fechaInscripcion = '" + inscripcion.getFecha()
                            + "', idSocio = '" + inscripcion.getSocio().getNumero()
                            + "', idExcursion = '" + inscripcion.getExcursion().getCodigo()
                            + "' WHERE codigoInscripcion = '" + inscripcion.getNumero() + "'";
                }
                case 3 -> {
                    Socio socio = (Socio) objeto;
                    query = "UPDATE Socio SET nombreSocio = '" + socio.getNombre()
                            + "', nifSocio = '" + socio.getNif()
                            + "' WHERE codigoSocio = '" + socio.getNumero() + "'";
                }
                case 4 -> {
                    Federacion federacion = (Federacion) objeto;
                    query = "UPDATE Federacion SET nombreFederacion = '" + federacion.getNombre()
                            + "' WHERE codigoFederacion = '" + federacion.getCodigo() + "'";
                }
            }
            statement.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("Error al modificar el objeto en la base de datos: " + e.getMessage());
        }
    }

    /**
     * Método para obtener un objeto de la base de datos.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param id         ID del objeto
     * @return Objeto
     */
    public Object getObjeto(int tipoObjeto, int id) {
        Object objeto = null;
        try {
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            String query = "";
            switch (tipoObjeto) {
                case 1 -> query = "SELECT * FROM Excursion WHERE idExcursion = " + id;
                case 2 -> query = "SELECT * FROM Inscripcion WHERE idInscripcion = " + id;
                case 3 -> query = "SELECT * FROM Socio WHERE idSocio = " + id;
                case 4 -> query = "SELECT * FROM Federacion WHERE idFederacion = " + id;
            }
            ResultSet resultSet = statement.executeQuery(query);

            // Si hay resultados, obtener los datos y crear el objeto correspondiente
            if (resultSet.next()) {
                switch (tipoObjeto) {
                    case 1 -> {
                        // Convertir java.sql.Date a java.time.LocalDate
                        LocalDate fecha = resultSet.getDate("fecha").toLocalDate();
                        objeto = new Excursion(resultSet.getString("codigoExcursion"), resultSet.getString("descripcion"), fecha, resultSet.getInt("duracion"), resultSet.getFloat("precio"));
                    }
                    case 2 -> {
                        objeto = new Inscripcion(resultSet.getString("codigoInscripcion"), resultSet.getDate("fechaInscripcion").toLocalDate(), resultSet.getString("idSocio"), resultSet.getString("idExcursion"));
                    }
                    case 3 -> {
                        objeto = new Socio(resultSet.getString("nombreSocio"), resultSet.getString("codigoSocio"), resultSet.getString("nifSocio"));
                    }
                    case 4 -> {
                        objeto = new Federacion(resultSet.getString("codigoFederacion"), resultSet.getString("nombreFederacion"));
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el objeto de la base de datos: " + e.getMessage());
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
     * @param string     String de búsqueda
     * @return ID del objeto si se encuentra, -1 si no se encuentra
     */
    public int buscarObjeto(int tipoObjeto, String string) {
        int id = -1;
        try {
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            String query = "";
            switch (tipoObjeto) {
                case 1 -> query = "SELECT idExcursion FROM Excursion WHERE codigoExcursion = '" + string + "'";
                case 2 -> query = "SELECT idInscripcion FROM Inscripcion WHERE codigoInscripcion = '" + string + "'";
                case 3 -> query = "SELECT idSocio FROM Socio WHERE codigoSocio = '" + string + "'";
                case 4 -> query = "SELECT idFederacion FROM Federacion WHERE codigoFederacion = '" + string + "'";
            }
            ResultSet resultSet = statement.executeQuery(query);

            // Si hay resultados, obtener el ID del objeto
            if (resultSet.next()) {
                switch (tipoObjeto) {
                    case 1 -> id = resultSet.getInt("idExcursion");
                    case 2 -> id = resultSet.getInt("idInscripcion");
                    case 3 -> id = resultSet.getInt("idSocio");
                    case 4 -> id = resultSet.getInt("idFederacion");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar el objeto en la base de datos: " + e.getMessage());
        }
        return id;
    }

    /**
     * Método para obtener los objetos de la base de datos.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     */
    public void listObjetos(int tipoObjeto) {
        try {
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            String query = "";
            switch (tipoObjeto) {
                case 1 -> query = "SELECT * FROM Excursion";
                case 2 -> query = "SELECT * FROM Inscripcion";
                case 3 -> query = "SELECT * FROM Socio";
                case 4 -> query = "SELECT * FROM Federacion";
            }
            ResultSet resultSet = statement.executeQuery(query);

            // Si hay resultados, imprimirlos directamente
            while (resultSet.next()) {
                switch (tipoObjeto) {
                    case 1 -> {
                        System.out.println("Excursion: " + resultSet.getString("codigoExcursion") + ", " + resultSet.getString("descripcion") + ", " + resultSet.getDate("fecha").toLocalDate() + ", " + resultSet.getInt("duracion") + ", " + resultSet.getFloat("precio"));
                    }
                    case 2 -> {
                        System.out.println("Inscripcion: " + resultSet.getString("codigoInscripcion") + ", " + resultSet.getDate("fechaInscripcion").toLocalDate() + ", " + resultSet.getString("idSocio") + ", " + resultSet.getString("idExcursion"));
                    }
                    case 3 -> {
                        System.out.println("Socio: " + resultSet.getString("nombreSocio") + ", " + resultSet.getString("codigoSocio") + ", " + resultSet.getString("nifSocio"));
                    }
                    case 4 -> {
                        System.out.println("Federacion: " + resultSet.getString("codigoFederacion") + ", " + resultSet.getString("nombreFederacion"));
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de la base de datos: " + e.getMessage());
        }
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
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            String query = "";
            switch (tipoObjeto) {
                case 1 -> query = "SELECT * FROM Excursion";
                case 2 -> query = "SELECT * FROM Inscripcion";
                case 3 -> query = "SELECT * FROM Socio";
                case 4 -> query = "SELECT * FROM Federacion";
            }
            ResultSet resultSet = statement.executeQuery(query);

            // Si hay resultados, convertirlos a String y añadirlos al StringBuilder
            while (resultSet.next()) {
                switch (tipoObjeto) {
                    case 1 -> {
                        // Aquí debes reemplazar los métodos get con los nombres de los campos de tu tabla Excursion
                        result.append("Excursion: ").append(resultSet.getString("codigoExcursion")).append(", ").append(resultSet.getString("descripcion")).append(", ").append(resultSet.getDate("fecha").toLocalDate()).append(", ").append(resultSet.getInt("duracion")).append(", ").append(resultSet.getFloat("precio")).append("\n");
                    }
                    case 2 -> {
                        // Aquí debes reemplazar los métodos get con los nombres de los campos de tu tabla Inscripcion
                        result.append("Inscripcion: ").append(resultSet.getString("codigoInscripcion")).append(", ").append(resultSet.getDate("fechaInscripcion").toLocalDate()).append(", ").append(resultSet.getString("idSocio")).append(", ").append(resultSet.getString("idExcursion")).append("\n");
                    }
                    case 3 -> {
                        // Aquí debes reemplazar los métodos get con los nombres de los campos de tu tabla Socio
                        result.append("Socio: ").append(resultSet.getString("nombreSocio")).append(", ").append(resultSet.getString("codigoSocio")).append(", ").append(resultSet.getString("nifSocio")).append("\n");
                    }
                    case 4 -> {
                        // Aquí debes reemplazar los métodos get con los nombres de los campos de tu tabla Federacion
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
     * Método para listar los objetos de alguno de los ArrayList en un rango de fechas.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     * @param fechaInicial Fecha inicial
     * @param fechaFinal Fecha final
     * @return Lista de objetos
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
     */
    public String listToStringObjetosFechas(int tipoObjeto, LocalDate fechaInicial, LocalDate fechaFinal) {
        StringBuilder result = new StringBuilder();
        try {
            // Obtener conexión utilizando DatabaseConnection
            Connection conexion = DatabaseConnection.getConnection();

            // Crear objeto statement
            Statement statement = conexion.createStatement();

            // Ejecutar sentencia SQL
            String query = "";
            switch (tipoObjeto) {
                case 1 -> query = "SELECT * FROM Excursion WHERE fecha BETWEEN '" + fechaInicial + "' AND '" + fechaFinal + "'";
                case 2 -> query = "SELECT * FROM Inscripcion WHERE fechaInscripcion BETWEEN '" + fechaInicial + "' AND '" + fechaFinal + "'";
                // Para el caso 3 (Socio), no hay un campo de fecha en la tabla Socio, por lo que no se puede filtrar por fechas.
            }
            ResultSet resultSet = statement.executeQuery(query);

            // Si hay resultados, convertirlos a String y añadirlos al StringBuilder
            while (resultSet.next()) {
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

        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de la base de datos: " + e.getMessage());
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

