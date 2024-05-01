package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Controlador.ControlDatos;
import RompeSistemas.Controlador.ControlPeticiones;
import RompeSistemas.Modelo.*;

import java.text.ParseException;

public class VistaAddSocio {

    //Atributos
    private ControlSocios cSocios;
    private ControlPeticiones cPeticiones;
    private ControlDatos cDatos;
    private Datos datos;

    /**
     * Constructor de la clase VistaAddSocio que recibe por parámetros el controlador de socios
     * @param cSocios es el controlador de socios
     */
    public VistaAddSocio(ControlSocios cSocios) {
        this.cSocios = new ControlSocios(cSocios);
        this.cPeticiones = cSocios.getControlPeticiones();
        this.cDatos = new ControlDatos(cSocios.getControlDatos());
        this.datos = new Datos();
    }

    /**
     * Constructor de copia de la clase VistaAddSocio
     * @param vistaAddSocio VistaAddSocio a copiar
     */
    public VistaAddSocio(VistaAddSocio vistaAddSocio) {
        this.cSocios = vistaAddSocio.getControlSocios();
        this.cPeticiones = vistaAddSocio.getControlPeticiones();
        this.cDatos = vistaAddSocio.getControlDatos();
        this.datos = vistaAddSocio.getDatos();
    }

    /**
     * Constructor vacío de la clase VistaAddSocio
     */
    public VistaAddSocio() {
        this.cSocios = null;
        this.cPeticiones = null;
        this.cDatos = null;
        this.datos = null;
    }

    //Getters
    public ControlSocios getControlSocios() {
        return cSocios;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    public Datos getDatos() {
        return datos;
    }

    public ControlDatos getControlDatos() {
        return cDatos;
    }
    
    //Setters

    public void setControlSocios(ControlSocios cSocios) {
        this.cSocios = cSocios;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }

    //Métodos

    /**
     * Método para añadir un socio
     */
    public void buttonAddSocio() {
        // Variables internas
        String numero, nombre, numSocioTutor, nif;
        Seguro seguro = null;
        txtMostrarMensaje("-- Procediendo a añadir un socio --\n");
        txtMostrarMensaje("Tipos de socio:\n");
        txtMostrarMensaje("1. Estándar\n");
        txtMostrarMensaje("2. Federado\n");
        txtMostrarMensaje("3. Infantil\n");
        int tipoSocio = cPeticiones.pedirEntero("Introduzca el tipo de socio que desea añadir: (1, 2 o 3)", 1, 3);

        // Mientras el NIF introducido ya exista, pedir otro NIF
        do{
            nif = cPeticiones.pedirNIF();
            if (!cDatos.checkExistenciaNIF(nif)) {
                break;
            }
            else {
                txtMostrarMensaje("El NIF introducido ya existe. Introduce otro NIF.");
            }
        }
        while(true);
        // Si el tipo de socio es Estándar
        if (tipoSocio == 1) {
            // Pedir nombre del socio mediante un método
            nombre = pedirNombreSocio();
            // Obtener el número de socio mediante un método
            numero = obtenerNumeroSocio();
            // Mostramos tipos de seguro disponibles
            txtMostrarMensaje("Tipos de seguro disponibles:\n");
            Seguro[] seguros = Seguro.values();
            // Mostramos los tipos de seguro
            for (Seguro value : seguros) {
                String seguroName = value.name().charAt(0) + value.name().substring(1).toLowerCase();
                txtMostrarMensaje(seguroName + "\n");
            }
            // Pedir tipo de seguro
            String seguroInput = cPeticiones.pedirString("Introduce el nombre del tipo de seguro del socio: ");
            switch (seguroInput.toUpperCase()) {
                case "COMPLETO":
                    seguro = Seguro.COMPLETO;
                    break;
                case "BASICO":
                    seguro = Seguro.BASICO;
                    break;
                default:
                    txtMostrarMensaje("Tipo de seguro no válido. Intente de nuevo.");
                    break;
            }
            // Añadir socio tipo Estandar mediante el controlador de socios
            Estandar estandar = new Estandar(nombre, numero, nif, seguro);
            cSocios.addSocio(estandar);
            // Mostramos mensaje de éxito
            txtMostrarMensaje("Socio Estándar añadido con éxito.\n");
        }
        // Si el tipo de socio es Federado
        else if (tipoSocio == 2) {
            // Pedir nombre del socio mediante un método
            nombre = pedirNombreSocio();
            // Obtener el número de socio mediante un método
            numero = obtenerNumeroSocio();
            // Pedir código de federación
            String codigoFederacion = cPeticiones.pedirString("Introduce el código de la federación a la que pertenece el socio: ");
            // Buscar la federación en el mapa de federaciones
            int idFederacion = datos.buscarObjeto(4, codigoFederacion);
            Federacion federacion = null;
            if (idFederacion != -1) {
                federacion = (Federacion) datos.getObjeto(4, idFederacion);
            }
            // Si la federación existe
            if (federacion != null) {
                Federado federado = new Federado(nombre, numero, nif, federacion);
                cSocios.addSocio(federado);
                // Mostramos mensaje de éxito
                txtMostrarMensaje("Socio Federado añadido con éxito.\n");
            }
            // Si la federación no existe
            else {
                txtMostrarMensaje("El código de federación introducido no existe. Intente de nuevo.");
            }
        }
        // Si el tipo de socio es Infantil
        else if (tipoSocio == 3) {
            // Pedir nombre del socio mediante un método
            nombre = pedirNombreSocio();
            // Obtener el número de socio mediante un método
            numero = obtenerNumeroSocio();
            do{
                // Pedir número de socio del tutor
                numSocioTutor = cPeticiones.pedirString("Introduce el número de socio del tutor: ");
                // Comprobar si el socio tutor existe
                if (!cDatos.checkExistenciaObjeto(3, numSocioTutor)) {
                    txtMostrarMensaje("El socio tutor no existe. Introduce un número de socio válido.");
                }
                else {
                    break;
                }
            } while (true);
            // Añadir socio tipo Infantil mediante el controlador de socios
            Infantil infantil = new Infantil(nombre, numero, nif, numSocioTutor);
            cSocios.addSocio(infantil);
            // Mostramos mensaje de éxito
            txtMostrarMensaje("Socio Infantil añadido con éxito.\n");
        }
        else {
            txtMostrarMensaje("Tipo de socio no válido.\n");
        }
    }

    public void buttonAtras() throws ParseException {
        // Informamos al usuario de que volvemos al menú de socios
        txtMostrarMensaje("Volviendo al menú de socios...\n\n");
    }

    // Comprobar último número de socio y devolver el siguiente
    private String obtenerNumeroSocio() {
        // Si no hay socios, devolver "SOC001"
        if (datos.getUltimoCodigo(3).isEmpty()) {
            return "SOC001";
        }
        // Si hay socios, devolver el siguiente número de socio
        else {
            return datos.getSiguienteCodigo(3);
        }
    }

    private String pedirNombreSocio() {
        return cPeticiones.pedirString("Introduce el nombre del socio: ");
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
     * Método para mostrar la vista de añadir socio
     */
    public void show() throws ParseException {
        // Variables internas
        boolean running = true;
        // Mientras se ejecute la vista
        while (running) {
            // Mostramos menú de añadir socio
            txtMostrarMensaje("************ MENÚ AÑADIR SOCIO ************\n");
            txtMostrarMensaje("1. Añadir socio\n");
            txtMostrarMensaje("0. Atrás\n");
            switch (cPeticiones.pedirEntero("Seleccione una opción (1 o 0): ", 0, 1)) {
                case 1:
                    buttonAddSocio();
                    break;
                case 0:
                    buttonAtras();
                    running = false;
                    break;
                default:
                    txtMostrarMensaje("Opción no válida. Intente de nuevo.");
                    break;
                    
            }
        }
    }

}