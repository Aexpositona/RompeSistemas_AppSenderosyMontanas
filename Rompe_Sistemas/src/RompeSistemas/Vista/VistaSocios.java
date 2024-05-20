package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Modelo.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

public class VistaSocios {

    private VistaModificarSeguro vModificarSeguro;
    private VistaListarSocios vListarSocios;
    private VistaAddSocio vAddSocio;
    private ControlSocios cSocios;
    private ControlPeticiones cPeticiones;

    public VistaSocios(ControlSocios cSocios) throws SQLException {
        this.cSocios = cSocios;
        this.vModificarSeguro = cSocios.getVistaModificarSeguro();
        this.vListarSocios = cSocios.getVistaListarSocios();
        this.vAddSocio = cSocios.getVistaAddSocio();
        this.cPeticiones = cSocios.getControlPeticiones();
    }

    public VistaSocios(VistaSocios vistaSocios) {
        this.cSocios = vistaSocios.getControlSocios();
        this.vModificarSeguro = vistaSocios.getVistaModificarSeguro();
        this.vListarSocios = vistaSocios.getVistaListarSocios();
        this.vAddSocio = vistaSocios.getVistaAddSocio();
        this.cPeticiones = vistaSocios.getControlPeticiones();
    }

    public VistaSocios() {
        this.cSocios = null;
        this.vModificarSeguro = null;
        this.vListarSocios = null;
        this.vAddSocio = null;
        this.cPeticiones = null;
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

    public void buttonAddSocio() throws ParseException, SQLException {
        System.out.println("Navegando a la vista de añadir socio...\n\n");
        cSocios.showVistaAddSocio();
    }

    public void buttonRemoveSocio() throws SQLException {
        System.out.println("Navegando a la vista de eliminar socio...\n\n");
        String numeroSocio = cPeticiones.pedirString("Introduce el número de socio que quieres eliminar: ");
        cSocios.removeSocio(numeroSocio);
    }

    public void buttonModTipoSeguro() throws ParseException, SQLException {
        System.out.println("Navegando a la vista de modificar seguro...\n\n");
        cSocios.showVistaModificarSeguro();
    }

    public void buttonListSocios() throws ParseException, SQLException {
        System.out.println("Navegando a la vista de listar socios...\n\n");
        cSocios.showVistaListarSocios();
    }

    public void buttonCalcFacturaMensualSocios() throws SQLException {
        System.out.println("-- Mostrando la factura mensual de los socios --\n\n");
        cSocios.calcularFacturaMensualSocios();
    }

    public void buttonCalcFacturaFechas() throws SQLException {
        System.out.println("-- Mostrando la factura entre fechas de los socios --\n\n");
        LocalDate fechaInicial = cPeticiones.pedirFecha("-- Introduce la fecha inicial --", LocalDate.of(2000, 1, 1), LocalDate.now());
        LocalDate fechaFinal = cPeticiones.pedirFecha("-- Introduce la fecha final --", fechaInicial, LocalDate.now());
        cSocios.calcularFacturaFechas(fechaInicial, fechaFinal);
    }

    public void buttonCalcFacturasFechasSocio() throws SQLException {
        System.out.println("-- Mostrando la factura entre fechas de un socio --\n\n");
        String numeroSocio = cPeticiones.pedirString("Introduce el número de socio: ");
        LocalDate fechaInicial = cPeticiones.pedirFecha("-- Introduce la fecha inicial --", LocalDate.of(2000, 1, 1), LocalDate.now());
        LocalDate fechaFinal = cPeticiones.pedirFecha("-- Introduce la fecha final --", fechaInicial, LocalDate.now());
        cSocios.calcularFacturasFechasSocio(numeroSocio, fechaInicial, fechaFinal);
    }

    public void buttonAtras() {
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
                case 1 -> buttonAddSocio();
                case 2 -> buttonRemoveSocio();
                case 3 -> buttonModTipoSeguro();
                case 4 -> buttonListSocios();
                case 5 -> buttonCalcFacturaMensualSocios();
                case 6 -> buttonCalcFacturaFechas();
                case 7 -> buttonCalcFacturasFechasSocio();
                case 0 -> {
                    buttonAtras();
                    running = false;
                }
                default -> txtMostrarMensaje("Opción no válida. Intente de nuevo.\n");
            }
        }
    }
}
