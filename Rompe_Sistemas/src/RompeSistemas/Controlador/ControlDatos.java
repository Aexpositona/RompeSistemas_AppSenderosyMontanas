package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;

public class ControlDatos {

    private final Datos datos;

    // Constructor
    public ControlDatos(Datos datos) {
        this.datos = datos;
    }

    // Métodos

    /**
     * Método para comprobar el tipo de objeto.
     * @param O Recibe el objeto.
     * @return int - Devuelve el tipo de objeto.
     */
    public int checkTipoObjeto(Object O) {
        // Variables internas
        int tipoObjeto;
        // Si el objeto es un socio
        if (O instanceof Socio){
            System.out.println("El objeto es una Excursion.");
            tipoObjeto = 1;
        }
        else if(O instanceof Inscripcion) {
            System.out.println("El objeto es una Inscripcion.");
            tipoObjeto = 2;
        }
        else if (O instanceof Excursion) {
            System.out.println("El objeto es un Socio.");
            tipoObjeto = 3;
        }
        else {
            System.out.println("El objeto no es un socio, una excursión o una inscripción.");
            tipoObjeto = 0;
        }
        return tipoObjeto;
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
    public boolean checkExistenciaObjeto(String codigo, int tipoObjeto){
        // Variables internas
        boolean resultado = false;
        // Si el objeto es una excursión
        if (tipoObjeto == 1) {
            // Si la excursión existe
            if (datos.getArrayList(1).contains(codigo)) {
                // Informamos al usuario de que la excursión existe
                System.out.println("La excursión ya existe.");
                // Registramos resultado como verdadero
                resultado = true;
            }
        }
        // Si el objeto es una inscripción
        else if (tipoObjeto == 2) {
            // Si la inscripción existe
            if (datos.getArrayList(2).contains(codigo)) {
                // Informamos al usuario de que la inscripción existe
                System.out.println("La inscripción ya existe.");
                // Registramos resultado como verdadero
                resultado = true;
            }
        }
        // Si el objeto es un socio
        else if (tipoObjeto == 3) {
            // Si el socio existe
            if (datos.getArrayList(3).contains(codigo)) {
                // Informamos al usuario de que el socio existe
                System.out.println("El socio ya existe.");
                // Registramos resultado como verdadero
                resultado = true;
            }
        }
        // Devolvemos el resultado
        return resultado;
    }


}