package RompeSistemas.Datos;

import RompeSistemas.Modelo.Excursion;
import RompeSistemas.ModeloDAO.ExcursionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

// Clase que implementa la interfaz ExcursionDAO y se encarga de realizar las operaciones de la base de datos relacionadas con las excursiones.
public class SQLExcursionDAO implements ExcursionDAO {
    
    // Método que devuelve un ResultSet con todas las excursiones.
    @Override
    public ResultSet getAllExcursiones() throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Excursion";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se ejecuta la consulta y se devuelve el resultado.
        return statement.executeQuery();
    }

    // Método que devuelve un objeto Excursion a partir de su id.
    @Override
    public Excursion getExcursion(String id) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Excursion WHERE idExcursion = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se establece el id de la excursión en la consulta.
        statement.setString(1, id);
        // Se ejecuta la consulta y se obtiene el resultado.
        ResultSet resultSet = statement.executeQuery();

        // Si hay resultados, se crea un objeto Excursion con los datos obtenidos y se devuelve.
        if (resultSet.next()) {
            // Se crea un objeto Excursion con los datos obtenidos y se devuelve.
            return new Excursion(
                    // Se obtienen los datos del objeto de la base de datos.
                    resultSet.getString("codigoExcursion"),
                    resultSet.getString("descripcion"),
                    resultSet.getDate("fecha").toLocalDate(),
                    resultSet.getInt("duracion"),
                    resultSet.getFloat("precio")
            );
        } 
        // Si no hay más resultados, se devuelve null.
        else {
            return null;
        }
    }

    // Método que añade una excursión a la base de datos.
    @Override
    public void addExcursion(Excursion excursion) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "INSERT INTO Excursion (codigoExcursion, descripcion, fecha, duracion, precio) VALUES (?, ?, ?, ?, ?)";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se establecen los datos de la excursión en la consulta.
        statement.setString(1, excursion.getCodigo());
        statement.setString(2, excursion.getDescripcion());
        statement.setDate(3, java.sql.Date.valueOf(excursion.getFecha()));
        statement.setInt(4, excursion.getDuracion());
        statement.setFloat(5, excursion.getPrecio());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    @Override
    public void updateExcursion(Excursion excursion) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "UPDATE Excursion SET descripcion = ?, fecha = ?, duracion = ?, precio = ? WHERE codigoExcursion = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se establecen los datos de la excursión en la consulta.
        statement.setString(1, excursion.getDescripcion());
        statement.setDate(2, java.sql.Date.valueOf(excursion.getFecha()));
        statement.setInt(3, excursion.getDuracion());
        statement.setFloat(4, excursion.getPrecio());
        statement.setString(5, excursion.getCodigo());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que elimina una excursión de la base de datos.
    @Override
    public void deleteExcursion(Excursion id) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "DELETE FROM Excursion WHERE idExcursion = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se establece el id de la excursión a eliminar en la consulta.
        statement.setString(1, id.getCodigo());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que devuelve un ResultSet con las excursiones que se realizan entre dos fechas.
    @Override
    public ResultSet getExcursionesPorFecha(LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Excursion WHERE fecha BETWEEN ? AND ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = ((Connection) conexion).prepareStatement(query);
        // Se establecen las fechas en la consulta.
        statement.setDate(1, java.sql.Date.valueOf(fechaInicial));
        statement.setDate(2, java.sql.Date.valueOf(fechaFinal));
        // Se ejecuta la consulta y se devuelve el resultado.
        return statement.executeQuery();
    }

    @Override
    public String getUltimoCodigo() throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT codigoExcursion FROM Excursion ORDER BY codigoExcursion DESC LIMIT 1";
        PreparedStatement statement = conexion.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString("codigoExcursion");
        } else {
            return null;
        }
    }

    @Override
    public ResultSet listarObjetosPorParametro(String parametro) throws SQLException {
        Connection conexion = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Excursion WHERE descripcion LIKE ?";
        PreparedStatement statement = conexion.prepareStatement(query);
        statement.setString(1, "%" + parametro + "%");
        return statement.executeQuery();
    }
}