package RompeSistemas.Datos;

import RompeSistemas.Modelo.*;
import RompeSistemas.ModeloDAO.SocioDAO;

import java.sql.*;

import static RompeSistemas.Datos.DatabaseConnection.getConnection;


// Clase que implementa la interfaz SocioDAO y se encarga de realizar las operaciones de la base de datos relacionadas con los socios.
public class SQLSocioDAO implements SocioDAO {
    private Connection conn;

    public SQLSocioDAO(Connection conn) {
        this.conn = conn;
    }
    // Método que añade un socio a la base de datos.
    @Override
    public void insertarSocio(Socio socio) throws SQLException {
        // Insertar en la tabla Socio
        String query = "INSERT INTO Socio (tipo, codigoSocio, nombreSocio, nifSocio) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, socio.getTipo());
        pstmt.setString(2, socio.getNumero());
        pstmt.setString(3, socio.getNombre());
        pstmt.setString(4, socio.getNif());
        pstmt.executeUpdate();

        // Obtener el ID generado para el nuevo socio
        ResultSet rs = pstmt.getGeneratedKeys();
        rs.next();
        int idSocio = rs.getInt(1);

        // Dependiendo del tipo de socio, insertar en la tabla correspondiente
        if (socio instanceof Estandar) {
            insertarEstandar((Estandar) socio, idSocio);
        } else if (socio instanceof Federado) {
            insertarFederado((Federado) socio, idSocio);
        } else if (socio instanceof Infantil) {
            insertarInfantil((Infantil) socio, idSocio);
        }
    }

    private void insertarEstandar(Estandar estandar, int idSocio) throws SQLException {
        int idSeguro = estandar.getSeguro().getId();
        String query = "INSERT INTO Estandar (idSocio, idSeguro) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, idSocio);
        pstmt.setInt(2, idSeguro);
        pstmt.executeUpdate();
    }

    private void insertarFederado(Federado federado, int idSocio) throws SQLException {
        String query = "INSERT INTO Federado (idSocio, idFederacion) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, idSocio);
        pstmt.setString(2, federado.getFederacion().getCodigo());
        pstmt.executeUpdate();
    }


    private void insertarInfantil(Infantil infantil, int idSocio) throws SQLException {
        String query = "INSERT INTO Infantil (idSocio, idSocioTutor) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, idSocio);
        pstmt.setInt(2, obtenerIdSocioTutor(infantil.getNumSocioTutor()));
        pstmt.executeUpdate();
    }

    private int obtenerIdSocioTutor(String numSocioTutor) throws SQLException {
        String query = "SELECT idSocio FROM Socio WHERE codigoSocio = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, numSocioTutor);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("idSocio");
        } else {
            throw new SQLException("No se encontró el socio tutor con el número: " + numSocioTutor);
        }
    }

    // Método que modifica un socio en la base de datos.
    @Override
    public void modificarSocio(Socio socio) throws SQLException {
        // Se obtiene la conexión a la base de datos.
        Connection conexion = getConnection();
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
        Connection conexion = getConnection();
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
        Connection conexion = getConnection();
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
        Connection conexion = getConnection();
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
        Connection conexion = getConnection();
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
        String query = "SELECT * FROM Socio WHERE codigoSocio = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, codigo);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return new Socio(rs.getString("nombreSocio"), rs.getString("codigoSocio"), rs.getString("nifSocio"));
        }
        return null;
    }

}