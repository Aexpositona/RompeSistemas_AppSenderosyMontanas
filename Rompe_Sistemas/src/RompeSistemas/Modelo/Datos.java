package RompeSistemas.Modelo;

import RompeSistemas.Datos.DatabaseConnection;
import RompeSistemas.Datos.SQLFabricaDAO;
import RompeSistemas.ModeloDAO.FabricaDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Datos {
    private Connection conn;
    private FabricaDAO fabricaDAO;

    public Datos() throws SQLException {
        this.conn = DatabaseConnection.getConnection();
        this.fabricaDAO = new SQLFabricaDAO(conn);
    }

    public Datos(Connection conn) {
        this.conn = conn;
        this.fabricaDAO = new SQLFabricaDAO(conn);
    }

    public Connection getConnection() {
        return conn;
    }

    public FabricaDAO getFabricaDAO() {
        return fabricaDAO;
    }

    // Métodos para obtener objetos específicos
    public Seguro getSeguro(int id) throws SQLException {
        return fabricaDAO.getSeguroDAO().getSeguro(id);
    }

    public Socio getSocio(String codigo) throws SQLException {
        return fabricaDAO.getSocioDAO().getSocio(codigo);
    }

    public Federacion getFederacion(String codigo) throws SQLException {
        return fabricaDAO.getFederacionDAO().getFederacion(codigo);
    }

    // Método para agregar un objeto
    public void addObjeto(int tipoObjeto, Object objeto) throws SQLException {
        switch (tipoObjeto) {
            case 1 -> fabricaDAO.getExcursionDAO().addExcursion((Excursion) objeto);
            case 2 -> fabricaDAO.getInscripcionDAO().insertarInscripcion((Inscripcion) objeto);
            case 3 -> {
                if (objeto instanceof Infantil) {
                    fabricaDAO.getInfantilDAO().insertarInfantil((Infantil) objeto);
                } else if (objeto instanceof Federado) {
                    fabricaDAO.getFederadoDAO().insertarFederado((Federado) objeto);
                } else if (objeto instanceof Estandar) {
                    fabricaDAO.getEstandarDAO().insertarEstandar((Estandar) objeto);
                } else {
                    fabricaDAO.getSocioDAO().insertarSocio((Socio) objeto);
                }
            }
            case 4 -> fabricaDAO.getFederacionDAO().insertarFederacion((Federacion) objeto);
        }
    }

    // Método para eliminar un objeto
    public void removeObjeto(int tipoObjeto, Object objeto) throws SQLException {
        switch (tipoObjeto) {
            case 1 -> fabricaDAO.getExcursionDAO().deleteExcursion((Excursion) objeto);
            case 2 -> fabricaDAO.getInscripcionDAO().eliminarInscripcion((Inscripcion) objeto);
            case 3 -> {
                if (objeto instanceof Infantil) {
                    fabricaDAO.getInfantilDAO().eliminarInfantil((Infantil) objeto);
                } else if (objeto instanceof Federado) {
                    fabricaDAO.getFederadoDAO().eliminarFederado((Federado) objeto);
                } else if (objeto instanceof Estandar) {
                    fabricaDAO.getEstandarDAO().eliminarEstandar((Estandar) objeto);
                } else {
                    fabricaDAO.getSocioDAO().eliminarSocio((Socio) objeto);
                }
            }
            case 4 -> fabricaDAO.getFederacionDAO().eliminarFederacion((Federacion) objeto);
        }
    }

    // Método para modificar un objeto
    public void modifyObjeto(int tipoObjeto, Object objeto) throws SQLException {
        switch (tipoObjeto) {
            case 1 -> fabricaDAO.getExcursionDAO().updateExcursion((Excursion) objeto);
            case 2 -> fabricaDAO.getInscripcionDAO().modificarInscripcion((Inscripcion) objeto);
            case 3 -> {
                if (objeto instanceof Infantil) {
                    fabricaDAO.getInfantilDAO().modificarInfantil((Infantil) objeto);
                } else if (objeto instanceof Federado) {
                    fabricaDAO.getFederadoDAO().modificarFederado((Federado) objeto);
                } else if (objeto instanceof Estandar) {
                    fabricaDAO.getEstandarDAO().modificarEstandar((Estandar) objeto);
                } else {
                    fabricaDAO.getSocioDAO().modificarSocio((Socio) objeto);
                }
            }
            case 4 -> fabricaDAO.getFederacionDAO().modificarFederacion((Federacion) objeto);
        }
    }

    // Método para obtener el siguiente código
    public String getSiguienteCodigo(int tipoObjeto) {
        String query = switch (tipoObjeto) {
            case 1 -> "SELECT codigoExcursion FROM Excursion ORDER BY codigoExcursion DESC LIMIT 1";
            case 2 -> "SELECT codigoInscripcion FROM Inscripcion ORDER BY codigoInscripcion DESC LIMIT 1";
            case 3 -> "SELECT codigoSocio FROM Socio ORDER BY codigoSocio DESC LIMIT 1";
            case 4 -> "SELECT codigoFederacion FROM Federacion ORDER BY codigoFederacion DESC LIMIT 1";
            default -> throw new IllegalArgumentException("Tipo de objeto no válido");
        };

        return generarSiguienteCodigo(query, tipoObjeto);
    }

    private String generarSiguienteCodigo(String query, int tipoObjeto) {
        try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                String ultimoCodigo = resultSet.getString(1);
                int numero = Integer.parseInt(ultimoCodigo.substring(3));
                numero++;
                String relleno = numero < 10 ? "000" : numero < 100 ? "00" : numero < 1000 ? "0" : "";
                return ultimoCodigo.substring(0, 3) + relleno + numero;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el siguiente código de la base de datos: " + e.getMessage());
        }
        return "";
    }

    // Método para listar objetos en formato String
    public String listToStringObjetos(int tipoObjeto) {
        String query = switch (tipoObjeto) {
            case 1 -> "SELECT * FROM Excursion";
            case 2 -> "SELECT * FROM Inscripcion";
            case 3 -> "SELECT * FROM Socio";
            case 4 -> "SELECT * FROM Federacion";
            default -> throw new IllegalArgumentException("Tipo de objeto no válido");
        };

        return obtenerResultados(query, tipoObjeto);
    }

    // Método para listar objetos por fechas en formato String
    public String listToStringObjetosFechas(int tipoObjeto, LocalDate fechaInicial, LocalDate fechaFinal) throws SQLException {
        String query = switch (tipoObjeto) {
            case 1 -> "SELECT * FROM Excursion WHERE fecha BETWEEN '" + fechaInicial + "' AND '" + fechaFinal + "'";
            case 2 -> "SELECT * FROM Inscripcion WHERE fechaInscripcion BETWEEN '" + fechaInicial + "' AND '" + fechaFinal + "'";
            default -> throw new IllegalArgumentException("Tipo de objeto no válido");
        };

        return obtenerResultados(query, tipoObjeto);
    }

    private String obtenerResultados(String query, int tipoObjeto) {
        StringBuilder result = new StringBuilder();
        try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                switch (tipoObjeto) {
                    case 1 -> result.append("Excursion: ").append(resultSet.getString("codigoExcursion"))
                            .append(", ").append(resultSet.getString("descripcion"))
                            .append(", ").append(resultSet.getDate("fecha").toLocalDate())
                            .append(", ").append(resultSet.getInt("duracion"))
                            .append(", ").append(resultSet.getFloat("precio")).append("\n");
                    case 2 -> result.append("Inscripcion: ").append(resultSet.getString("codigoInscripcion"))
                            .append(", ").append(resultSet.getDate("fechaInscripcion").toLocalDate())
                            .append(", ").append(resultSet.getString("idSocio"))
                            .append(", ").append(resultSet.getString("idExcursion")).append("\n");
                    case 3 -> result.append("Socio: ").append(resultSet.getString("nombreSocio"))
                            .append(", ").append(resultSet.getString("codigoSocio"))
                            .append(", ").append(resultSet.getString("nifSocio")).append("\n");
                    case 4 -> result.append("Federacion: ").append(resultSet.getString("codigoFederacion"))
                            .append(", ").append(resultSet.getString("nombreFederacion")).append("\n");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de la base de datos: " + e.getMessage());
        }
        return result.toString();
    }
}
