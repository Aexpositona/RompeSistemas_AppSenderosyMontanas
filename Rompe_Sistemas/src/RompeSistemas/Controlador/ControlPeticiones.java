package RompeSistemas.Controlador;

import java.time.LocalDate;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlPeticiones {
    private final Scanner scanner = new Scanner(System.in);

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
        // //Convertimos a mayúsculas
        // resp = resp.toUpperCase();
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
        int i;              //Valor introducido

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
                System.out.println("** ERRROR ** -> Solo puedes insertar números.\n");
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
     * Solicita y registra una fecha introducida por el usuario.
     *
     * @return LocalDate - Devuelve la fecha introducida por el usuario.
     */
    public LocalDate pedirFecha(String peticion){
        // Variables internas
        int dia, mes, ano;
        boolean resultado;
        // Mostramos petición
        System.out.println(peticion);
        // Mientras no se introduzca un año válido repetimos solicitud
        do {
            // Solicitamos el año
            System.out.println("Introduzca el año: ");
            // Registramos el año introducido por el usuario
            ano = Integer.parseInt(scanner.nextLine());
            // Si el año es menor que el actual
            if (ano < LocalDate.now().getYear()) {
                // Informamos al usuario del error
                System.out.println("El año no puede ser menor que el actual.");
                // Registramos resultado como falso
                resultado = false;
            }
            // Si el año es mayor que el actual el año es válido
            else resultado = true;
        }
        while (!resultado);
        // Mientras no se introduzca un mes válido repetimos solicitud
        do {
            // Solicitamos el mes
            System.out.println("Introduzca el mes: ");
            // Registramos el mes introducido por el usuario
            mes = Integer.parseInt(scanner.nextLine());
            // Si el mes es menor que 1 o mayor que 12
            if (mes <= 0 || mes > 12) {
                // Informamos al usuario del error
                System.out.println("El mes no puede ser menor que 1 ni mayor que 12.");
                // Registramos resultado como falso
                resultado = false;
            }
        }
        while (!resultado);
        // Mientras no se introduzca un día válido repetimos solicitud
        do {
            // Solicitamos el día
            System.out.println("Introduzca el día: ");
            // Registramos el día introducido por el usuario
            dia = Integer.parseInt(scanner.nextLine());
            // Si el día es menor que 1 o mayor que 31
            if (dia <= 0 || dia > 31) {
                // Informamos al usuario del error
                System.out.println("El día no puede ser menor que 1 ni mayor que 31.");
                // Registramos resultado como falso
                resultado = false;
            }
            // El mes es febrero no puede tener más de 28 días si no es bisiesto
            else if (dia > 28 && mes == 2 && !Year.isLeap(ano)) {
                System.out.println("Febrero no puede tener más de 28 días al no ser bisiesto.");
                resultado = false;
            }
            // El mes es febrero no puede tener más de 29 días si es bisiesto
            else if (dia > 29 && mes == 2 && Year.isLeap(ano)) {
                System.out.println("Febrero no puede tener más de 29 días al ser bisiesto.");
                resultado = false;
            }
            // Los meses con 30 días no pueden tener más de 30 días
            else if (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
                System.out.println("El mes seleccionado no puede tener más de 30 días.");
                resultado = false;
            }
            // En el resto de casos el día es válido
            else {
                resultado = true;
            }
        }
        while (!resultado);
        // Devuelve la fecha introducida
        return LocalDate.of(ano, mes, dia);
    }

    public float pedirFloat (String peticion, float min, float max){
        // Variables internas
        float f = 0.0f;
        boolean resultado;
        // Solicitamos el valor hasta obtener un valor válido
        do {
            // Intentamos registrar el valor introducido
            try {
                // Pedimos la introducción de las opciones concretas
                System.out.println(peticion);
                // Registramos el valor introducido
                f = Float.parseFloat(scanner.nextLine());
                // Si el valor es menor o igual a 0
                if (f < min) {
                    // Informamos al usuario del error
                    System.out.println("El valor no puede ser menor que " + min + " .");
                    resultado = false;
                }
                // Si el valor es mayor que 0
                else if (f > max) {
                    // Informamos al usuario del error
                    System.out.println("El valor no puede ser mayor que " + max + " .");
                    resultado = false;
                }
                // Si el valor es válido
                else {
                    // Informamos al usuario del valor introducido
                    System.out.println("El valor introducido " + f + " es válido.");
                    resultado = true;
                }
            }
            // Si no se introduce un valor numérico
            catch (NumberFormatException nfe) {
                // Informamos al usuario del error
                System.out.println("Solo puedes insertar números.");
                resultado = false;
            }
        }
        while (!resultado);
        // Devolvemos el valor registrado
        return f;
    }
}
