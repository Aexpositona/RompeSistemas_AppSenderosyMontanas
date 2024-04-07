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
        this.cSocios = cSocios;
        this.cPeticiones = cSocios.getControlPeticiones();
        this.datos = cSocios.getDatos();
        this.cDatos = cSocios.getControlDatos();

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






    //Métodos

    /**
     * Método para mostrar la vista de añadir socio
     */
    public void show() throws ParseException {
        boolean running = true;
        while (running) {
            System.out.println("Menú de añadir socio:");
            System.out.println("1. Añadir socio");
            System.out.println("0. Atrás");
            switch (cPeticiones.pedirEntero("Seleccione una opción: ", 0, 1)) {
                case 1:
                    buttonAdd();
                    break;
                case 0:
                    buttonAtras();
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    //* @param nombre nombre del socio
    //* @param numero número del socio
    //* @param nif NIF del socio
    //* @param seguro seguro del socio
    public void buttonAdd() {
        // Variables internas
        int numero;
        String nombre;
        Seguro seguro = null;
        System.out.println("........AÑADIR SOCIO........\n");
        System.out.println("Tipos de socio:");
        System.out.println("1. Estándar");
        System.out.println("2. Federado");
        System.out.println("3. Infantil");
        int tipoSocio = cPeticiones.pedirEntero("Introduzca el tipo de socio que desea añadir: ", 1, 3);

        // Pedir NIF del socio
        String nif = cPeticiones.pedirNIF("Introduce el NIF del socio: ");
        // Mientras el NIF introducido ya exista, pedir otro NIF
        while(cDatos.checkExistenciaNIF(nif)){
            System.out.println("El NIF introducido ya existe. Introduce otro NIF.");
            nif = cPeticiones.pedirNIF("Introduce el NIF del socio: ");
        }

        if (tipoSocio == 1) {
            // Pedir nombre del socio mediante un método
            nombre = pedirNombreSocio();
            // Obtener el número de socio mediante un método
            numero = obtenerNumeroSocio();
            // Mostramos tipos de seguro disponibles
            System.out.println("Tipos de seguro disponibles:");
            Seguro[] seguros = Seguro.values();
            for (Seguro value : seguros) {
                System.out.println(value.name());
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
                    System.out.println("Tipo de seguro no válido. Intente de nuevo.");
                    break;
            }
            // Añadir socio tipo Estandar mediante el controlador de socios
            Estandar estandar = new Estandar(nombre, numero, nif, seguro);
            cSocios.addSocio(estandar);
            // Mostramos mensaje de éxito
            System.out.println("Socio Estándar añadido con éxito.");
        }

        else if (tipoSocio == 2) {
            // Pedir nombre del socio mediante un método
            nombre = pedirNombreSocio();
            // Obtener el número de socio mediante un método
            numero = obtenerNumeroSocio();
            // Pedir código de federación
            String codigoFederacion = cPeticiones.pedirString("Introduce el código de la federación a la que pertenece el socio: ");
            // Buscar la federación en la lista de federaciones
            Federacion federacion = null;
            for (Object obj : datos.getArrayList(4)) {
                Federacion fed = (Federacion) obj;
                if (fed.getCodigo().equals(codigoFederacion)) {
                    federacion = fed;
                    break;
                }
            }
            // Si la federación existe
            if (federacion != null) {
                Federado federado = new Federado(nombre, numero, nif, federacion);
                cSocios.addSocio(federado);
                // Mostramos mensaje de éxito
                System.out.println("Socio Federado añadido con éxito.");
            }
            // Si la federación no existe
            else {
                System.out.println("El código de federación introducido no existe. Intente de nuevo.");
            }
        }
        // Si el tipo de socio es Infantil
        else if (tipoSocio == 3) {
            // Pedir nombre del socio mediante un método
            nombre = pedirNombreSocio();
            // Obtener el número de socio mediante un método
            numero = obtenerNumeroSocio();
            // Pedir número de socio del tutor
            int numSocioTutor = cPeticiones.pedirEntero("Introduce el número de socio del tutor: ", 1, datos.getArrayList(3).size());
            // Añadir socio tipo Infantil mediante el controlador de socios
            Infantil infantil = new Infantil(nombre, numero, nif, numSocioTutor);
            cSocios.addSocio(infantil);
            // Mostramos mensaje de éxito
            System.out.println("Socio Infantil añadido con éxito.");
        }
        else {
            System.out.println("Tipo de socio no válido.");
        }
    }

    public void buttonAtras() throws ParseException {
        // Informamos al usuario de que volvemos al menú de socios
        System.out.println("Volviendo al menú de socios...");
    }
    // Comprobar último número de socio y devolver el siguiente
    private int obtenerNumeroSocio() {
        // Si no hay socios, devolver 1
        if (datos.getArrayList(3).isEmpty()) {
            return 1;
        } 
        // Si hay socios, devolver el último número de socio + 1
        else {
            return datos.getArrayList(3).size() + 1;
        }           
    }

    private String pedirNombreSocio() {
        return cPeticiones.pedirString("Introduce el nombre del socio: ");
    }

    

}
