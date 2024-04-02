package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
import java.time.LocalDate;
import java.util.Scanner;

public class ControlDatos {

    private Datos datos; // Agrega un campo de instancia para Datos
    private Object O; // Agrega un campo de instancia para Object
    private Socio socio;
    private Inscripcion inscripcion;
    private Excursion excursion;
    private boolean resultado;
    private LocalDate fecha;
    private Scanner scanner = new Scanner(System.in);

    // Constructor
    public ControlDatos(Datos datos) {
        this.datos = datos;
    }

    // Métodos





    /**
     * Comprueba la validez de un socio.
     *
     * @param
     */
    public boolean validarObjeto(Object O) {
        // Variables internas
        this.O = O;
        // Si el objeto es un socio
        if (O instanceof Socio){
            // Intentamos convertir el objeto a socio
            try {
                // Convertimos el objeto a socio
                socio = (Socio) O;
                // Registramos resultado como verdadero
                resultado = true;
            }
            // Si no se puede convertir el objeto a socio
            catch (ClassCastException e) {
                // Informamos al usuario del error
                System.out.println("Error al convertir el objeto a Socio.");
                // Registramos resultado como falso
                resultado = false;
            }
            // Devolvemos el resultado
            return resultado;
        }
        // Si el objeto es una excursión
        else if(O instanceof Excursion){
            // Intentamos convertir el objeto a excursión
            try {
                // Convertimos el objeto a excursión
                excursion = (Excursion) O;
                // Registramos resultado como verdadero
                resultado = true;
            }
            // Si no se puede convertir el objeto a excursión
            catch (ClassCastException e) {
                // Informamos al usuario del error
                System.out.println("Error al convertir el objeto a Excursion.");
                // Registramos resultado como falso
                resultado = false;
            }
            // Devolvemos el resultado
            return resultado;
        }
        // Si el objeto es una inscripción
        else if(O instanceof Inscripcion){
            // Intentamos convertir el objeto a inscripción
            try {
                // Convertimos el objeto a inscripción
                inscripcion = (Inscripcion) O;
                // Registramos resultado como verdadero
                resultado = true;
            }
            // Si no se puede convertir el objeto a inscripción
            catch (ClassCastException e) {
                // Informamos al usuario del error
                System.out.println("Error al convertir el objeto a Inscripcion.");
                // Registramos resultado como falso
                resultado = false;
            }
        }
        // Si no es ninguno de los objetos anteriores
        else{
            // Informamos al usuario del error
            System.out.println("El objeto no es un socio, una excursión o una inscripción.");
            // Registramos resultado como falso
            resultado = false;
        }
        return resultado;
    }

    /**
     * Metodo para validar la longitud del código o número de un objeto.
     * En este Metodo validamos la longitud del código o número de un objeto.
     * Si el objeto introducido no reune las condiciones de longitud, informamos al usuario y devolvemos falso.
     * @param codigo Recibe el código o número del objeto.
     * @param tipoObjeto Recibe el tipo de objeto.
     * @return boolean - Devuelve verdadero si el código o número del objeto es válido.
     */
    //Metodo para validar la longitud del código o número de un objeto
    public boolean checkCodigoObjeto(String codigo, int tipoObjeto){
        // Variables internas
        String mensaje = "";
        int cantidad = -1;
        // Si el objeto es una excursión
        if (tipoObjeto == 1) {
            // Mensaje de error
            mensaje = "El código de la excursión";
            // Cantidad de caracteres
            cantidad = 5;
        }
        // Si el objeto es una inscripción
        else if (tipoObjeto == 2) {
            // Mensaje de error
            mensaje = "El número de la inscripción";
            // Cantidad de caracteres
            cantidad = 5;
        }
        // Si el objeto es un socio
        else if (tipoObjeto == 3) {
            // Mensaje de error
            mensaje = "El número de socio";
            // Cantidad de caracteres
            cantidad = 5;
        }
        // Si el objeto introducido no reune las condiciones de longitud
        if (codigo.length() != cantidad) {
            System.out.println(mensaje + "no puede estar vacío y ha de tener " + cantidad + " caracteres.");
            return false;
        }
        else return true;
    }

 /**
     * Metodo para comprobar si existe un objeto.
     * En este Metodo comprobamos si existe un objeto.
     * Si el objeto existe, devolvemos verdadero.
     * @param codigo Recibe el código o número del objeto.
     * @param tipoObjeto Recibe el tipo de objeto.
     * @return boolean - Devuelve verdadero si el objeto existe.
     */
    // Método para comprobar si existe un objeto
    public boolean checkObjeto(String codigo, int tipoObjeto){
        return datos.getObjeto(datos.buscarObjeto(codigo, tipoObjeto), tipoObjeto) != null;
    }


}