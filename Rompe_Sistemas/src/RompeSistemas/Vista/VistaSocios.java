package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Socio;
import RompeSistemas.Modelo.Infantil;
import RompeSistemas.Modelo.Federado;
import RompeSistemas.Modelo.Estandar;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

public class VistaSocios {

    private VistaModificarSeguro vModificarSeguro;
    private VistaListarSocios vListarSocios;
    private VistaAddSocio vAddSocio;
    private ControlSocios cSocios;
    private ControlPeticiones cPeticiones;
    private ControlDatos cDatos;
    private Datos datos;

    public VistaSocios(ControlSocios cSocios) throws SQLException {
        this.cSocios = cSocios;
        this.vModificarSeguro = cSocios.getVistaModificarSeguro();
        this.vListarSocios = cSocios.getVistaListarSocios();
        this.vAddSocio = cSocios.getVistaAddSocio();
        this.cPeticiones = cSocios.getControlPeticiones();
        this.cDatos = cSocios.getControlDatos();
        this.datos = cSocios.getDatos();
    }

    public VistaSocios(VistaSocios vistaSocios) {
        this.cSocios = vistaSocios.getControlSocios();
        this.vModificarSeguro = vistaSocios.getVistaModificarSeguro();
        this.vListarSocios = vistaSocios.getVistaListarSocios();
        this.vAddSocio = vistaSocios.getVistaAddSocio();
        this.cPeticiones = vistaSocios.getControlPeticiones();
        this.cDatos = vistaSocios.getControlDatos();
        this.datos = vistaSocios.getDatos();
    }

    public VistaSocios() {
        this.cSocios = null;
        this.vModificarSeguro = null;
        this.vListarSocios = null;
        this.vAddSocio = null;
        this.cPeticiones = null;
        this.cDatos = null;
        this.datos = null;
    }

    public ControlSocios getControlSocios() {
        return cSocios;
    }

    public VistaModificarSeguro getVistaModificarSeguro() {
        return vModificarSeguro;
    }

    public VistaListarSocios getVistaListarSocios() {
        return vListarSocios;
    }

    public VistaAddSocio getVistaAddSocio() {
        return vAddSocio;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    public ControlDatos getControlDatos() {
        return cDatos;
    }

    public Datos getDatos() {
        return datos;
    }

    public void setControlSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
    }

    public void setVistaModificarSeguro(VistaModificarSeguro vModificarSeguro) {
        this.vModificarSeguro = vModificarSeguro;
    }

    public void setVistaListarSocios(VistaListarSocios vListarSocios) {
        this.vListarSocios = vListarSocios;
    }

    public void setVistaAddSocio(VistaAddSocio vAddSocio) {
        this.vAddSocio = vAddSocio;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public void buttonAddSocio() throws ParseException, SQLException {
        System.out.println("Navegando a la vista de añadir socio...\n\n");
        vAddSocio.show();
    }

    public void buttonRemoveSocio() throws SQLException {
        System.out.println("Navegando a la vista de eliminar socio...\n\n");
        String numeroSocio = cPeticiones.pedirString("Introduce el número de socio que quieres eliminar: ");
        Socio socio = cSocios.getSocio(numeroSocio);
        if (socio != null) {
            if (socio instanceof Infantil) {
                cSocios.eliminarInfantil((Infantil) socio);
            } else if (socio instanceof Federado) {
                cSocios.eliminarFederado((Federado) socio);
            } else if (socio instanceof Estandar) {
                cSocios.eliminarEstandar((Estandar) socio);
            } else {
                cSocios.eliminarSocio(socio);
            }
            System.out.println("Socio eliminado correctamente.");
        } else {
            System.out.println("No se encontró el socio con el número: " + numeroSocio);
        }
    }

    public void buttonModTipoSeguro() throws ParseException, SQLException {
        System.out.println("Navegando a la vista de modificar seguro...\n\n");
        vModificarSeguro.show();
    }

    public void buttonListSocios() throws ParseException, SQLException {
        System.out.println("Navegando a la vista de listar socios...\n\n");
        vListarSocios.show();
    }

    public void buttonCalcFacturaMensualSocios() throws SQLException {
        System.out.println("-- Mostrando la factura mensual de los socios --\n\n");
        LocalDate actual = LocalDate.now(), haceUnMes = actual.minusMonths(1);
        cSocios.calcFacturaFechas("NULL", haceUnMes, actual);
    }

    public void buttonCalcFacturaFechas() throws SQLException {
        System.out.println("-- Mostrando la factura entre fechas de los socios --\n\n");
        LocalDate fechaInicial = cPeticiones.pedirFecha("-- Introduce la fecha inicial --", LocalDate.of(2000, 1, 1), LocalDate.now());
        LocalDate fechaFinal = cPeticiones.pedirFecha("-- Introduce la fecha final --", fechaInicial, LocalDate.now());
        cSocios.calcFacturaFechas("NULL", fechaInicial, fechaFinal);
    }

    public void buttonCalcFacturasFechasSocio() throws SQLException {
        System.out.println("-- Mostrando la factura entre fechas de un socio --\n\n");
        String numeroSocio = cPeticiones.pedirString("Introduce el número de socio: ");
        LocalDate fechaInicial = cPeticiones.pedirFecha("-- Introduce la fecha inicial --", LocalDate.of(2000, 1, 1), LocalDate.now());
        LocalDate fechaFinal = cPeticiones.pedirFecha("-- Introduce la fecha final --", fechaInicial, LocalDate.now());
        cSocios.calcFacturaFechas(numeroSocio, fechaInicial, fechaFinal);
    }

    public void buttonAtras() throws ParseException {
        System.out.println("Volviendo al menú principal...\n\n");
    }

    public void txtMostrarMensaje(String mensaje) {
        System.out.print(mensaje);
    }

    public void show() throws ParseException, SQLException {
        boolean running = true;
        while (running) {
            txtMostrarMensaje("************ MENÚ SOCIOS ************\n");
            txtMostrarMensaje("1. Añadir socio\n");
            txtMostrarMensaje("2. Eliminar socio\n");
            txtMostrarMensaje("3. Modificar tipo de seguro\n");
            txtMostrarMensaje("4. Listar socios\n");
            txtMostrarMensaje("5. Mostrar factura mensual de los socios\n");
            txtMostrarMensaje("6. Mostrar factura entre dos fechas\n");
            txtMostrarMensaje("7. Mostrar factura entre dos fechas de un socio\n");
            txtMostrarMensaje("0. Atrás\n");
            switch (cPeticiones.pedirEntero("Seleccione una opción (1, 2, 3, 4, 5, 6, 7 o 0): ", 0, 7)) {
                case 1:
                    buttonAddSocio();
                    break;
                case 2:
                    buttonRemoveSocio();
                    break;
                case 3:
                    buttonModTipoSeguro();
                    break;
                case 4:
                    buttonListSocios();
                    break;
                case 5:
                    buttonCalcFacturaMensualSocios();
                    break;
                case 6:
                    buttonCalcFacturaFechas();
                    break;
                case 7:
                    buttonCalcFacturasFechasSocio();
                    break;
                case 0:
                    buttonAtras();
                    running = false;
                    break;
                default:
                    txtMostrarMensaje("Opción no válida. Intente de nuevo.\n");
                    break;
            }
        }
    }
}
