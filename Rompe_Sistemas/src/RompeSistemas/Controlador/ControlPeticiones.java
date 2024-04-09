package RompeSistemas.Controlador;

import java.time.LocalDate;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlPeticiones {
    // Atributos    
    private Scanner scanner;

    // Constructores
    public ControlPeticiones() {
        this.scanner = new Scanner(System.in);
    }
    
    public ControlPeticiones(ControlPeticiones cPeticiones) {
        this.scanner = cPeticiones.getScanner();
    }

    // Getters
    public Scanner getScanner() {
        return scanner;
    }

    // Setters
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
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
     * Si no se introduce un valor numérico, capturamos la excepción y solicitamos de nuevo el valor.
     * Si no se introduce un valor entre el rango establecido, informamos al usuario y solicitamos de nuevo el valor.
     * @param peticion Recibe la petición de introducción de número entero.
     * @param min Recibe el valor mínimo del rango.
     * @param max Recibe el valor máximo del rango.
     * @return int - Devuelve el número entero introducido por el usuario.
     */

    // Metodo para solicitar y registrar número entero introducido por usuario
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
        //Devolvemos valor registrado
        return i;
    }

    /**
     * Solicita y registra una fecha introducida por el usuario.
     *
     * @return LocalDate - Devuelve la fecha introducida por el usuario.
     */
    public LocalDate pedirFecha(String peticion, LocalDate minFecha, LocalDate maxFecha){
        // Variables internas
        int dia, mes, ano, minAno, maxAno;
        boolean resultado = false;
        minAno = minFecha.getYear();
        maxAno = maxFecha.getYear();

        // Mostramos petición
        System.out.println(peticion);
        // Solicitamos y registramos el año introducido por el usuario entre el año actual y dos años más
        ano = pedirEntero("Introduzca el año (aaaa): ", minAno, maxAno);

        // Mientras no se introduzca un día válido repetimos solicitud
        do {
            // Solicitamos y registramos el mes introducido por el usuario
            mes = pedirEntero("Introduzca el mes (mm): ", 1, 12);
            // Solicitamos el día y registramos el valor introducido por el usuario
            dia = pedirEntero("Introduzca el día (dd): ", 1, 31);
            // El mes es febrero no puede tener más de 28 días si no es bisiesto
            if (dia > 28 && mes == 2 && !Year.isLeap(ano)) {
                System.out.println("Febrero no puede tener más de 28 días al no ser bisiesto.");
            }
            // El mes es febrero no puede tener más de 29 días si es bisiesto
            else if (dia > 29 && mes == 2 && Year.isLeap(ano)) {
                System.out.println("Febrero no puede tener más de 29 días al ser bisiesto.");
            }
            // Los meses con 30 días no pueden tener más de 30 días
            else if (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
                System.out.println("El mes seleccionado no puede tener más de 30 días.");
            }
            else if (LocalDate.of(ano, mes, dia).isBefore(minFecha) || LocalDate.of(ano, mes, dia).isAfter(maxFecha)) {
                System.out.println("La fecha no puede ser anterior a " + minFecha + " ni posterior a " + maxFecha + ".");
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
        float f = 0;
        boolean resultado;
        // Solicitamos el valor hasta obtener un valor válido
        do {
            // Intentamos registrar el valor introducido
            try {
                // Pedimos la introducción de las opciones concretas
                System.out.println(peticion);
                // Limpiamos el buffer
                scanner.nextLine();
                // Registramos el valor introducido
                try{
                    f = Float.parseFloat(scanner.nextLine());
                }
                catch (NumberFormatException nfe){
                    System.out.println("Solo puedes insertar números.");
                    f = 0.0f;
                }
                // Si el valor es menor o igual a 0
                if (f < min || f > max) {
                    // Informamos al usuario del error
                    System.out.println("El valor no puede ser menor que " + min + " " + "ni mayor que " + max + ".");
                    resultado = false;
                }
                // Si el valor es válido
                else {
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

    public String pedirNIF (){
        String nif;
        boolean resultado = false;
        // Pedimos la introducción de las opciones concretas
        System.out.print("Introduce el NIF del socio: ");
        do {
            // Registramos el valor introducido
            nif = scanner.nextLine();
            // Si el valor introducido tiene 9 caracteres
            if (!nif.isEmpty() && nif.length() != 9) {
                // Informamos al usuario del error
                System.out.println("El NIF debe tener 9 caracteres.");
            } else if (!nif.isEmpty()) {
                // Comprobamos que los 8 primeros caracteres sean numéricos
                for (int i = 0; i < 8; i++) {
                    // Si el caracter no es numérico
                    if (!Character.isDigit(nif.charAt(i))) {
                        // Informamos al usuario del error
                        System.out.println("Los 8 primeros caracteres del NIF deben ser numéricos.");
                        resultado = false;
                        break;
                    }
                    // Si el caracter es numérico
                    else {
                        resultado = true;
                    }
                }
                // Si los 8 primeros caracteres son numéricos
                if (resultado) {
                    // Comprobamos que el último caracter sea una letra
                    if (!Character.isLetter(nif.charAt(8))) {
                        // Informamos al usuario del error
                        System.out.println("El último caracter del NIF debe ser una letra.");
                        resultado = false;
                    }
                }
            }
        }
        while (!resultado);
        // Devolvemos el valor registrado
        return nif;
    }
}
