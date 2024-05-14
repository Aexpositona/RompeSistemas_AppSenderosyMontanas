package RompeSistemas.Modelo;

import RompeSistemas.Datos.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Clase que implementa la interfaz SocioDAO y se encarga de realizar las operaciones de la base de datos relacionadas con los socios.
public class SQLSocioDAO implements SocioDAO {

    // Método que devuelve una lista con todos los socios.
    @Override
    public List<Socio> getAllSocios() throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Socio";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se ejecuta la consulta y se obtiene el resultado.
        ResultSet resultSet = statement.executeQuery();
        // Se crea una lista de socios.
        List<Socio> socios = new ArrayList<>();
        // Mientras haya resultados, se añaden a la lista de socios.
        while (resultSet.next()) {
            socios.add(new Socio(
                    resultSet.getString("nombreSocio"),
                    resultSet.getString("codigoSocio"),
                    resultSet.getString("nifSocio")
            ));
        }
        // Se devuelve la lista de socios.
        return socios;
    }

    // Método que añade un socio a la base de datos.
    @Override
    public void insertarSocio(Socio socio) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "INSERT INTO Socio (nombreSocio, codigoSocio, nifSocio) VALUES (?, ?, ?)";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añaden los datos del socio a la consulta.
        statement.setString(1, socio.getNombre());
        statement.setString(2, socio.getNumero());
        statement.setString(3, socio.getNif());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que modifica un socio en la base de datos.
    @Override
    public void modificarSocio(Socio socio) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "UPDATE Socio SET nombreSocio = ?, nifSocio = ? WHERE codigoSocio = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añaden los datos del socio a la consulta.
        statement.setString(1, socio.getNombre());
        statement.setString(2, socio.getNif());
        statement.setString(3, socio.getNumero());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que elimina un socio de la base de datos.
    @Override
    public void eliminarSocio(Socio socio) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "DELETE FROM Socio WHERE codigoSocio = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añade el código del socio a la consulta.
        statement.setString(1, socio.getNumero());
        // Se ejecuta la consulta.
        statement.executeUpdate();
    }

    // Método que busca un socio por su código.
    @Override
    public Socio buscarSocio(int id) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Socio WHERE idSocio = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añade el código del socio a la consulta.
        statement.setInt(1, id);
        // Se ejecuta la consulta y se obtiene el resultado.
        ResultSet resultSet = statement.executeQuery();
        // Si hay resultados, se devuelve el primer socio.
        if (resultSet.next()) {
            return new Socio(
                    resultSet.getString("nombreSocio"),
                    resultSet.getString("codigoSocio"),
                    resultSet.getString("nifSocio")
            );
        } 
        // Si no hay resultados, se devuelve null.
        else {
            return null;
        }
    }

    // Método que busca un socio por su DNI.
    @Override
    public Socio buscarSocio(String dni) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Socio WHERE nifSocio = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añade el DNI del socio a la consulta.
        statement.setString(1, dni);
        // Se ejecuta la consulta y se obtiene el resultado.
        ResultSet resultSet = statement.executeQuery();
        // Si hay resultados, se devuelve el primer socio.
        if (resultSet.next()) {
            return new Socio(
                    resultSet.getString("nombreSocio"),
                    resultSet.getString("codigoSocio"),
                    resultSet.getString("nifSocio")
            );
        } 
        // Si no hay resultados, se devuelve null.
        else {
            return null;
        }
    }

    // Método que busca un socio por su nombre.
    @Override
    public ResultSet listarSocios() throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Socio";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se ejecuta la consulta y se devuelve el resultado.
        return statement.executeQuery();
    }

    // Método que devuelve un socio por su código.
    @Override
    public Socio getSocio(String codigo) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = DatabaseConnection.getConnection();
        // Se crea la consulta SQL.
        String query = "SELECT * FROM Socio WHERE codigoSocio = ?";
        // Se crea un objeto PreparedStatement con la consulta.
        PreparedStatement statement = conexion.prepareStatement(query);
        // Se añade el código del socio a la consulta.
        statement.setString(1, codigo);
        // Se ejecuta la consulta y se obtiene el resultado.
        ResultSet resultSet = statement.executeQuery();
        // Si hay resultados, se devuelve el primer socio.
        if (resultSet.next()) {
            return new Socio(
                    resultSet.getString("nombreSocio"),
                    resultSet.getString("codigoSocio"),
                    resultSet.getString("nifSocio")
            );
        } 
        // Si no hay resultados, se devuelve null.
        else {
            return null;
        }
    }
}
