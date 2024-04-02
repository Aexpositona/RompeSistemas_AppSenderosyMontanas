package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;

import java.time.LocalDate;
import java.time.Year;
import java.util.InputMismatchException;
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
     * Metodo para solicitar y registrar cadena introducida por usuario.
     * En este Metodo solicitamos y registramos la cadena introducida por el usuario.
     * Si no se introduce ninguna cadena, registramos espacio.
     * El registro siempre se realizará en mayúsculas.
     * @param peticion Recibe la petición de introducción de cadena.
     * @return String - Devuelve la cadena introducida por el usuario.
     */

    //Metodo para solicitar y registrar cadena introducida por usuario
    public String pedirString(String peticion) {
        //Declaramos variables internas
        String resp;            //Cadena introducida
        //Pedimos la introducción de las opciones concretas
        System.out.print(peticion);
        //Registramos la opción elegida
        resp = scanner.next();
        //Convertimos a mayúsculas
        resp = resp.toUpperCase();
        //Si no se introduce ninguna
        if (resp.isEmpty()) {
            //Registramos espacio
            resp = " ";
        }
        System.out.println();
        //Metodo devuelve cadena registrada
        return resp;
    }

    /**
     * Metodo para solicitar y registrar número entero introducido por usuario.
     * En este Metodo solicitamos y registramos el número entero introducido por el usuario.
     * Si se introduce un tipo de dato diferente a un número, generando una excepción, informamos al usuario y registramos el valor inválido -1 para forzar reintento.
     * Si se supera el número de intentos después de excepción permitidos, informamos al usuario y salimos del programa.
     * @param peticion Recibe la petición de introducción de número entero.
     * @param min Recibe el valor mínimo permitido.
     * @param max Recibe el valor máximo permitido.
     * @return int - Devuelve el número entero introducido por el usuario.
     */

    //Metodo para solicitar y registrar número entero introducido por usuario
    public int pedirEntero(String peticion, int min, int max) {
        //Declaramos variables internas
        int i = 0;              //Valor introducido
        int intento = 0;        //Intentos realizados
        int intentos = 3;       //Intentos máximos permitidos

        //Solicitamos valor hasta obtener valor válido
        do{
            //Intentamos registrar valor introducido
            try {
                //Pedimos la introducción de las opciones concretas
                System.out.print(peticion);
                //Registramos valor introducido
                i = scanner.nextInt();
                //Si no se introduce valor entre rango establecido
                if (i < min || i > max) {
                    //Informamos al usuario de los rangos permitidos
                    System.out.println("El valor no es válido. Debe ser un número entre " + min + " y " + max + ".\n");
                }
                //Si no se introduce valor numérico capturamos excepción
            } catch (InputMismatchException ime) {
                //Informamos al usuario del error
                System.out.println("** ERRROR ** -> Solo puedes insertar números." + "\n");
                //Vaciamos buffer
                scanner.nextLine();
                //Asignamos valor no válido
                i = (min-1);
            }
        }
        //Mientras no se introduzca valor válido repetimos solicitud
        while (i < min || i > max);
        //Añadimos salto de línea
        System.out.println();
        //Devolvemos valor registrado
        return i;
    }

    /**
     * Comprueba la validez de un socio.
     *
     * @param
     */
    public boolean validarObjeto(Object O) {
        // Variables internas
        resultado = false;
        this.O = O;
        // Lógica para comprobar un Objeto
        if (O instanceof Socio){
            try {
                socio = (Socio) O;
                resultado = true;
            } catch (ClassCastException e) {
                System.out.println("Error al convertir el objeto a Socio.");
                resultado = false;
            }
            return resultado;
        }
        else if(O instanceof Excursion){
            try {
                excursion = (Excursion) O;
                resultado = true;
            } catch (ClassCastException e) {
                System.out.println("Error al convertir el objeto a Excursion.");
                resultado = false;
            }
            return resultado;
        }
        else if(O instanceof Inscripcion){
            try {
                inscripcion = (Inscripcion) O;
                resultado = true;
            } catch (ClassCastException e) {
                System.out.println("Error al convertir el objeto a Inscripcion.");
                resultado = false;
            }
            return resultado;
        }
        else{
            System.out.println("Error al convertir el objeto.");
            return false;
        }
    }
    //Metodo para validar el código o número de un objeto
    public boolean validarCodigoObjeto(String codigo, int tipoObjeto){
        String mensaje = "";
        int cantidad = -1;
        if (tipoObjeto == 1) {
            mensaje = "El código de la excursión";
            cantidad = 5;
        }
        else if (tipoObjeto == 2) {
            mensaje = "El número de la inscripción";
            cantidad = 5;
        }
        else if (tipoObjeto == 3) {
            mensaje = "El número de socio";
            cantidad = 5;
        }
        if (codigo.length() != cantidad) {
            System.out.println(mensaje + "no puede estar vacío y ha de tener " + cantidad + " caracteres.");
            return false;
        }
        else return true;
    }
    //Metodo para validar el número de socio
    public boolean validarNumeroInscripcion(String numero){
        if (numero.length() != 5) {
            System.out.println("El código de la inscripción no puede estar vacío y ha de tener 5 caracteres.");
            return false;
        }
        else return true;
    }
    //Metodo para validar el código de una excursión
    public boolean validarCodigoExcursion(String codigo){
        if (codigo.length() != 5) {
            System.out.println("El código de la excursión no puede estar vacío y ha de tener 5 caracteres.");
            return false;
        }
        else return true;
    }

    //Metodo para comprobar si existe un socio
    public boolean checkSocio(String numeroSocio){
        return datos.getObjeto(datos.buscarObjeto(numeroSocio, 3), 3) != null;
    }

    //Metodo para comprobar si existe una inscripción
    public boolean checkInscripcion(String numero){
        return datos.getObjeto(datos.buscarObjeto(numero, 2), 2) != null;
    }
    //Metodo para comprobar si existe una excursión
    public boolean checkExcursion(String codigo){
        return datos.getObjeto(datos.buscarObjeto(codigo, 1), 1) != null;
    }

    /**
     * Solicita y registra una fecha introducida por el usuario.
     *
     * @return LocalDate - Devuelve la fecha introducida por el usuario.
     */
    public LocalDate pedirFecha(){
        int dia, mes, ano;
        boolean resultado = false, bisiesto;
        do {
            System.out.println("Introduzca el año: ");
            ano = Integer.parseInt(scanner.nextLine());
            if (ano < LocalDate.now().getYear()) {
                System.out.println("El año no puede ser menor que el actual.");
            }
            else resultado = true;
        }
        while (!resultado);
        do {
            System.out.println("Introduzca el mes: ");
            mes = Integer.parseInt(scanner.nextLine());
            if (mes <= 0 || mes > 12) {
                System.out.println("El mes no puede ser menor que 1 ni mayor que 12.");
                resultado = false;
            }
        }
        while (!resultado);
        do {
            System.out.println("Introduzca el día: ");
            dia = Integer.parseInt(scanner.nextLine());
            if (dia <= 0 || dia > 31) {
                System.out.println("El día no puede ser menor que 1 ni mayor que 31.");
                resultado = false;
            }
            // El mes es febrero no puede tener más de 28 días si no es bisiesto
            else if (dia > 28 && mes == 2 && !Year.isLeap(ano)) {
                System.out.println("Febrero no puede tener más de 28 días al no ser bisiesto.");
                resultado = false;
                // El mes es febrero no puede tener más de 29 días si es bisiesto
            } else if (dia > 29 && mes == 2 && Year.isLeap(ano)) {
                System.out.println("Febrero no puede tener más de 29 días al ser bisiesto.");
                resultado = false;
            } else if (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
                System.out.println("El mes seleccionado no puede tener más de 30 días.");
                resultado = false;
            } else {
                resultado = true;
            }
        }
        while (!resultado);
        // Devuelve la fecha introducida
        return fecha = LocalDate.of(ano, mes, dia);
    }
}