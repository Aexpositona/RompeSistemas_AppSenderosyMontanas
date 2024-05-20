package RompeSistemas.Datos;

import RompeSistemas.Modelo.Inscripcion;
import RompeSistemas.ModeloDAO.InscripcionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Clase que implementa la interfaz InscripcionDAO y se encarga de realizar las operaciones de la base de datos relacionadas con las inscripciones.
public class SQLInscripcionDAO implements InscripcionDAO {
    private Connection conn;

    public SQLInscripcionDAO(Connection conn) {
        this.conn = conn;
    }

    // Método que devuelve una lista con todas las inscripciones.
    @Override
    public List<Inscripcion> getAllInscripciones() throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Inscripcion";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se ejecuta la consulta y se obtiene el resultado.
        ResultSet resultSet = statement.executeQuery();
        // Se crea una lista de inscripciones.
        List<Inscripcion> inscripciones = new ArrayList<>();
        
        // Se recorre el resultado de la consulta.
        while (resultSet.next()) {
            // Se añade una inscripción a la lista con los datos obtenidos.
            inscripciones.add(new Inscripcion(
                    resultSet.getString("codigoInscripcion"),
                    resultSet.getDate("fechaInscripcion").toLocalDate(),
                    resultSet.getString("idSocio"),
                    resultSet.getString("idExcursion")
            ));
        }
        // Se devuelve la lista de inscripciones.
        return inscripciones;
    }

    // Método que añade una inscripción a la base de datos.
    @Override
    public void insertarInscripcion(Inscripcion inscripcion) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "INSERT INTO Inscripcion (codigoInscripcion, fechaInscripcion, idSocio, idExcursion) VALUES (?, ?, ?, ?)";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añaden los datos de la inscripción a la consulta.
        statement.setString(1, inscripcion.getNumero());
        statement.setDate(2, java.sql.Date.valueOf(inscripcion.getFecha()));
        statement.setString(3, inscripcion.getSocio().getNumero());
        statement.setString(4, inscripcion.getExcursion().getCodigo());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que modifica una inscripción en la base de datos.
    @Override
    public void modificarInscripcion(Inscripcion inscripcion) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "UPDATE Inscripcion SET fechaInscripcion = ?, idSocio = ?, idExcursion = ? WHERE codigoInscripcion = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añaden los datos de la inscripción a la consulta.
        statement.setDate(1, java.sql.Date.valueOf(inscripcion.getFecha()));
        statement.setString(2, inscripcion.getSocio().getNumero());
        statement.setString(3, inscripcion.getExcursion().getCodigo());
        statement.setString(4, inscripcion.getNumero());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que elimina una inscripción de la base de datos.
    @Override
    public void eliminarInscripcion(Inscripcion inscripcion) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "DELETE FROM Inscripcion WHERE codigoInscripcion = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añade el código de la inscripción a eliminar a la consulta.
        statement.setString(1, inscripcion.getNumero());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que busca una inscripción en la base de datos por su código.
    @Override
    public Inscripcion buscarInscripcion(String id) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Inscripcion WHERE idInscripcion = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añade el código de la inscripción a la consulta.
        statement.setInt(1, Integer.parseInt(id));
        // Se ejecuta la consulta y se obtiene el resultado.
        ResultSet resultSet = statement.executeQuery();

        // Si se ha encontrado una inscripción con el código dado, se devuelve un objeto Inscripcion con los datos obtenidos.
        if (resultSet.next()) {
            return new Inscripcion(
                    resultSet.getString("codigoInscripcion"),
                    resultSet.getDate("fechaInscripcion").toLocalDate(),
                    resultSet.getString("idSocio"),
                    resultSet.getString("idExcursion")
            );
        } 
        // Si no se ha encontrado ninguna inscripción con el código dado, se devuelve null.
        else {
            return null;
        }
    }

    // Método que busca una inscripción en la base de datos por el código de un socio.
    @Override
    public ResultSet listarInscripciones() throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Inscripcion";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se ejecuta la consulta y se obtiene el resultado.
        ResultSet resultSet = statement.executeQuery();
        // Se devuelve el resultado.
        return resultSet;
    }

    // Método que busca una inscripción en la base de datos por el código de un socio.
    @Override
    public ResultSet getInscripcionesPorFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Inscripcion WHERE fechaInscripcion BETWEEN ? AND ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añaden las fechas a la consulta.
        statement.setDate(1, java.sql.Date.valueOf(fechaInicial));
        statement.setDate(2, java.sql.Date.valueOf(fechaFinal));
        // Se ejecuta la consulta y se devuelve el resultado.
        return statement.executeQuery();

    }

    // Método que devuelve la inscripción del código dado.
    @Override
    public Inscripcion getInscripcion(String codigo) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Inscripcion WHERE codigoInscripcion = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añade el código de la inscripción a la consulta.
        statement.setString(1, codigo);
        // Se ejecuta la consulta y se obtiene el resultado.
        ResultSet resultSet = statement.executeQuery();
        // Si se ha encontrado una inscripción con el código dado, se devuelve un objeto Inscripcion con los datos obtenidos.
        if (resultSet.next()) {
            return new Inscripcion(
                    resultSet.getString("codigoInscripcion"),
                    resultSet.getDate("fechaInscripcion").toLocalDate(),
                    resultSet.getString("idSocio"),
                    resultSet.getString("idExcursion")
            );
        } 
        // Si no se ha encontrado ninguna inscripción con el código dado, se devuelve null.
        else {
            return null;
        }
    }
}
