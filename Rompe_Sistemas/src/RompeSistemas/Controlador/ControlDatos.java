package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;

public class ControlDatos {

    // Atributos
    private final Datos datos;


    // Constructor
    public ControlDatos(APPSenderosMontanas app) {
        this.datos = app.datos;
    }

    // Constructor de copia
    public ControlDatos (ControlDatos cDatos) {
        this.datos = new Datos(cDatos.datos);
    }

    // Constructor vacío
    public ControlDatos() {
        this.datos = null;
    }

    // Métodos

    /**
     * Método para comprobar el tipo de objeto.
     * @param O Recibe el objeto.
     * @return int - Devuelve el tipo de objeto.
     *          1-Excursión
     *          2-Inscripción
     *          3-Socio
     *          4-Federación
     */
    public int checkTipoObjeto(Object O) {
        // Variables internas
        int tipoObjeto;
        // Si el objeto es un socio
        if (O instanceof Excursion){
            System.out.println("El objeto es una Excursion.");
            tipoObjeto = 1;
        }
        // Si el objeto es una inscripción
        else if(O instanceof Inscripcion) {
            System.out.println("El objeto es una Inscripcion.");
            tipoObjeto = 2;
        }
        // Si el objeto es una excursión
        else if (O instanceof Socio) {
            System.out.println("El objeto es un Socio.");
            tipoObjeto = 3;
        }
        else if (O instanceof Federacion) {
            System.out.println("El objeto es una Federacion.");
            tipoObjeto = 4;
        }
        // Si el objeto no es un socio, una excursión o una inscripción
        else {
            System.out.println("El objeto no es un socio, una excursión o una inscripción.");
            tipoObjeto = 0;
        }
        // Devolvemos el tipo de objeto
        return tipoObjeto;
    }

    /**
     * Metodo para validar la longitud del código o número de un objeto.
     * En este Metodo validamos la longitud del código o número de un objeto.
     * Si el objeto introducido no reune las condiciones de longitud, informamos al usuario y devolvemos falso.
     * @param codigo Recibe el código o número del objeto.
     * @param tipoObjeto Recibe el tipo de objeto.
     *                  1-Excursión
     *                  2-Inscripción
     *                  3-Socio
     *                  4-Federación
     * @return boolean - Devuelve verdadero si el código o número del objeto es válido.
     */
    //Metodo para validar la longitud del código o número de un objeto
    public boolean checkCodigoObjeto(int tipoObjeto, String codigo){
        // Variables internas
        String mensaje = "";
        int cantidad = -1;
        // Si el objeto es una excursión
        if (tipoObjeto == 1) {
            // Mensaje de error
            mensaje = "El código de la excursión";
            // Cantidad de caracteres
            cantidad = codigo.length();
        }
        // Si el objeto es una inscripción
        else if (tipoObjeto == 2) {
            // Mensaje de error
            mensaje = "El número de la inscripción";
            // Cantidad de caracteres
            cantidad = codigo.length();
        }
        // Si el objeto es un socio
        else if (tipoObjeto == 3) {
            // Mensaje de error
            mensaje = "El número de socio";
            // Cantidad de caracteres
            cantidad = codigo.length();
        }
        else if (tipoObjeto == 4) {
            // Mensaje de error
            mensaje = "El código de la federación";
            // Cantidad de caracteres
            cantidad = codigo.length();
        }
        // Si el objeto introducido no reune las condiciones de longitud
        if (codigo.length() != cantidad) {
            System.out.println(mensaje + " no puede estar vacío. Inténtelo de nuevo.");
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
     *                  1-Excursión
     *                  2-Inscripción
     *                  3-Socio
     *                  4-Federación 
     * @return boolean - Devuelve verdadero si el objeto existe.
     */
    // Método para comprobar si existe un objeto
    public boolean checkExistenciaObjeto(int tipoObjeto, String codigo){
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
        else if (tipoObjeto == 4) {
            // Si la federación existe
            if (datos.getArrayList(4).contains(codigo)) {
                // Informamos al usuario de que la federación existe
                System.out.println("La federación ya existe.");
                // Registramos resultado como verdadero
                resultado = true;
            }
        }
        // Devolvemos el resultado
        return resultado;
    }

    public boolean isSocioInInscripcion(int numeroSocio) {
        for (Object obj : datos.getArrayList(2)) {
            if (obj instanceof Inscripcion) {
                Inscripcion inscripcion = (Inscripcion) obj;
                if (inscripcion.getSocio().getNumero() == numeroSocio) {
                    return true;
                }
            }
        }
        return false;
    }

}