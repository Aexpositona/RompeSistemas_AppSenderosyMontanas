package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Federacion;
import RompeSistemas.Modelo.Federado;
import RompeSistemas.Controlador.ControlPeticiones;
import java.text.ParseException;

public class VistaAddSocio {

    //Atributos
    private ControlSocios cSocios;
    private ControlPeticiones cPeticiones;
    private Datos datos;

    /**
     * Constructor de la clase VistaAddSocio que recibe por parámetros el controlador de socios
     * @param cSocios es el controlador de socios
     */
    public VistaAddSocio(ControlSocios cSocios) {
        this.cSocios = cSocios;
        this.cPeticiones = cSocios.getControlPeticiones();
        this.datos = cSocios.getDatos();
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

    public void buttonAdd() {
        // Variables internas
        boolean valido = false;
        int numero = 0;
        String nombre = "";
        do{
            System.out.println("Tipos de socio:");
            System.out.println("1. Estandar");
            System.out.println("2. Federado");
            System.out.println("3. Infantil");
            int tipoSocio = cPeticiones.pedirEntero("Introduzca el tipo de socio que desea añadir: ", 1, 3);
            
            if (tipoSocio == 1) {
                
                nombre = pedirNombreSocio();
                numero = obtenerNumeroSocio();
                String nif = cPeticiones.pedirNIF("Introduce el NIF del socio: ");
                String codigoFederacion = cPeticiones.pedirString("Introduce el código de la federación a la que pertenece el socio: ");
                switch (2) {
                    case 1 -> datos.objeto = datos.excursiones.get(datos.buscarObjeto(codigoFederacion,2));
                    case 2 -> datos.objeto = datos.inscripciones.get(datos.buscarObjeto(codigoFederacion,2));
                    case 3 -> datos.objeto = datos.socios.get(datos.buscarObjeto(codigoFederacion,2));
                }

                Object federacion = datos;
                
                cSocios.addSocio( 3, new Federado(nombre, numero, nif, (Federacion) federacion));
            } 
            else if (tipoSocio == 2) {
                
            } 
            else if (tipoSocio == 3) {

            } 
            else {
                System.out.println("Tipo de socio no válido.");
            }
        }
        while(false);
        cSocios.addSocio();
    }

    public void buttonAtras() throws ParseException {
        System.out.println("Volviendo al menú de socios...");
        return;
    }
    // Comprobar último número de socio y devolver el siguiente
    private int obtenerNumeroSocio() {
        // Si no hay socios, devolver 1
        if (datos.getArrayList(3).size() == 0) {
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
