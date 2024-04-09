package RompeSistemas.Vista;

// Imports
import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Modelo.Datos;
import java.text.ParseException;
import java.time.LocalDate;

/**
 * Clase que representa la vista de socios.
 */
public class VistaSocios {

    // Atributos
    private VistaModificarSeguro vModificarSeguro;
    private VistaListarSocios vListarSocios;
    private VistaAddSocio vAddSocio;
    private ControlSocios cSocios;
    private ControlPeticiones cPeticiones;
    private ControlDatos cDatos;
    private Datos datos;


    /**
     * Método constructor de la clase VistaSocios que recibe por parámetros el controlador de socios
     * @param cSocios es el controlador de socios
     */
    public VistaSocios(ControlSocios cSocios) {
        this.cSocios = new ControlSocios(cSocios);
        this.vModificarSeguro = cSocios.getVistaModificarSeguro();
        this.vListarSocios =cSocios.getVistaListarSocios();
        this.vAddSocio = cSocios.getVistaAddSocio();
        this.cPeticiones = cSocios.getControlPeticiones() ;
        this.cDatos = new ControlDatos(cSocios.getControlDatos());
        this.datos = new Datos(cSocios.getDatos());
    }

    /**
     * Método constructor de copia de la clase VistaSocios
     * @param vistaSocios VistaSocios a copiar
     */
    public VistaSocios(VistaSocios vistaSocios) {
        this.cSocios = vistaSocios.getControlSocios();
        this.vModificarSeguro = vistaSocios.getVistaModificarSeguro();
        this.vListarSocios = vistaSocios.getVistaListarSocios();
        this.vAddSocio = vistaSocios.getVistaAddSocio();
        this.cPeticiones = vistaSocios.getControlPeticiones();
        this.cDatos = vistaSocios.getControlDatos();
        this.datos = vistaSocios.getDatos();
    }

    /**
     * Método constructor vacío de la clase VistaSocios
     */
    public VistaSocios() {
        this.cSocios = null;
        this.vModificarSeguro = null;
        this.vListarSocios = null;
        this.vAddSocio = null;
        this.cPeticiones = null;
        this.cDatos = null;
        this.datos = null;
    }

    // Getters

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

    // Setters

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

    /**
     * Método para añadir un botón que nos permite añadir un socio
     */
    public void buttonAddSocio() throws ParseException {
        System.out.println("Navegando a la vista de añadir socio...\n\n");
        vAddSocio.show();
    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    public void buttonRemoveSocio() {
        // Variables internas
        // Listar socios
        txtMostrarMensaje("\n");
        cSocios.listSocios();
        txtMostrarMensaje("\n");
        // Solicitar número de socio a eliminar
        String numeroSocio = cPeticiones.pedirString("Introduce el número de socio que quieres eliminar: ");
        // Llamamos al método de ControlSocios para eliminar el socio con el número introducido
        cSocios.removeSocio(numeroSocio);
    }

    /**
     * Método para añadir un botón que nos permite modificar un seguro
     */
    public void buttonModTipoSeguro() throws ParseException {
        txtMostrarMensaje("Navegando a la vista de modificar seguro...\n\n");
        vModificarSeguro.show();
    }

    /**
     * Método para añadir un botón que nos permite listar los socios
     */
    public void ButtonListSocios() throws ParseException {
        txtMostrarMensaje("Navegando a la vista de listar socios...\n\n");
        vListarSocios.show();
    }

    /**
     * Método para añadir un botón que nos permite mostrar la información de los socios
     */
    public void buttonCalcFacturaMensualSocios(){
        txtMostrarMensaje("-- Mostrando la factura mensual de los socios --\n\n");
        // Obtenemos la fecha actual y la fecha de hace un mes
        LocalDate actual = LocalDate.now(), haceUnMes = actual.minusMonths(1);
        cSocios.calcFacturaFechas("NULL",haceUnMes, actual);
    }

    /**
     * Método para añadir un botón que nos permite mostrar la información de los socios entre dos fechas
     */
    public void buttonCalcFacturaFechas(){
        txtMostrarMensaje("-- Mostrando la factura entre fechas de los socios --\n\n");
        // Solicitamos la fecha inicial y la fecha final
        LocalDate fechaInicial = cPeticiones.pedirFecha("-- Introduce la fecha inicial --", LocalDate.of(2000, 1, 1), LocalDate.now());
        LocalDate fechaFinal = cPeticiones.pedirFecha("-- Introduce la fecha final --", fechaInicial, LocalDate.now());
        // Llamamos al método de ControlSocios para calcular la factura entre las dos fechas
        cSocios.calcFacturaFechas("NULL",fechaInicial, fechaFinal);
    }

    public void buttonCalcFacturasFechasSocio() {
        txtMostrarMensaje("-- Mostrando la factura entre fechas de un socio --\n\n");
        // Listar socios
        txtMostrarMensaje("\n");
        cSocios.listSocios();
        txtMostrarMensaje("\n");
        // Solicitamos el número de socio
        String numeroSocio = cPeticiones.pedirString("Introduce el número de socio: ");
        // Solicitamos la fecha inicial y la fecha final
        LocalDate fechaInicial = cPeticiones.pedirFecha("-- Introduce la fecha inicial --", LocalDate.of(2000, 1, 1), LocalDate.now());
        LocalDate fechaFinal = cPeticiones.pedirFecha("-- Introduce la fecha final  --", fechaInicial, LocalDate.now());
        txtMostrarMensaje("\n");
        // Llamamos al método de ControlSocios para calcular la factura entre las dos fechas
        cSocios.calcFacturaFechas(numeroSocio, fechaInicial, fechaFinal);
    }

    /**
     * Método para añadir un botón que nos permite ir hacia atrás
     */
    public void buttonAtras() throws ParseException {
        txtMostrarMensaje("Volviendo al menú principal...\n\n");
    }

    /**
     * Método para mostrar un mensaje.
     *
     * @param mensaje Mensaje a mostrar.
     */
    public void txtMostrarMensaje(String mensaje){
        System.out.print(mensaje);
    }

    /**
     * Método para mostrar la vista de socios
     */
    public void show() throws ParseException {
        // Variables internas
        boolean running = true;
        // Bucle de ejecución
        while (running) {
            // Mostramos el menú de socios
            txtMostrarMensaje("************ MENÚ SOCIOS ************\n");
            txtMostrarMensaje("1. Añadir socio\n");
            txtMostrarMensaje("2. Eliminar socio\n");
            txtMostrarMensaje("3. Modificar tipo de seguro\n");
            txtMostrarMensaje("4. Listar socios\n");
            txtMostrarMensaje("5. Mostrar factura mensual de los socios\n");
            txtMostrarMensaje("6. Mostrar factura entre dos fechas\n");
            txtMostrarMensaje("7. Mostrar factura entre dos fechas de un socio\n");
            txtMostrarMensaje("0. Atrás\n");
            // Solicitamos una opción
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
                    ButtonListSocios();
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