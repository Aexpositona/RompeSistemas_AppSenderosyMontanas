package RompeSistemas.Vista;

import RompeSistemas.Controlador.ControlSocios;
import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.Federacion;
import RompeSistemas.Modelo.Federado;
import RompeSistemas.Controlador.ControlPeticiones;
import java.text.ParseException;
import java.util.InputMismatchException;

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
                    buttonAñadir();
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

    public void buttonAñadir() {
        // Variables internas
        boolean valido = false;
        int numero = 0;
        do{
            System.out.println("Tipos de socio:");
            System.out.println("1. Estandar");
            System.out.println("2. Federado");
            System.out.println("3. Infantil");
            int tipoSocio = cPeticiones.pedirEntero("Introduzca el tipo de socio que desea añadir: ", 1, 3);
            
            if (tipoSocio == 1) {
                
                String nombre = cPeticiones.pedirString("Introduce el nombre del socio: ");

                do{
                    valido = true;
                    do{
                        valido = true;
                        try{
                            numero = Integer.parseInt(cPeticiones.pedirString("Introduce el número del socio: "));
                        }catch(NumberFormatException e){
                            System.out.println("El número de socio debe ser un número entero.");
                            valido = false;
                        }
                    }
                    while(!valido);
                    if(datos.buscarObjeto(String.valueOf(numero), 3) != -1){
                        System.out.println("Ya existe un socio con ese número.");
                        valido = false;
                    }
                    else if(numero < 0){
                        System.out.println("El número de socio no puede ser negativo.");
                        valido = false;
                    }
                    else if(numero == 0){
                        System.out.println("El número de socio no puede ser 0.");
                        valido = false;
                    }
                    else if(numero > Integer.MAX_VALUE){
                        System.out.println("El número de socio no puede ser mayor que " + Integer.MAX_VALUE + ".");
                        valido = false;
                    }
                    
                }

                String nif = cPeticiones.pedirNIF("Introduce el NIF del socio: ");

                String codigoFederacion = cPeticiones.pedirString("Introduce el código de la federación a la que pertenece el socio: ");

                Object federacion = datos.getObjeto(2, datos.buscarObjeto(codigoFederacion,2));
                
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

}
