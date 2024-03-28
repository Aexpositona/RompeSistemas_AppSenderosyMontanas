package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ControlSocios {

    // Atributos
    private Datos datos;

    /**
     * Constructor de ControlSocios.
     *
     */
    public ControlSocios(Datos datos) {
        this.datos = datos;
    }

    // Métodos




    public void addFederado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre del socio:");
        String nombre = scanner.nextLine();

        System.out.println("Introduce el número del socio:");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduce el NIF del socio:");
        String nif = scanner.nextLine();

        System.out.println("Introduce el nombre de la federación a la que pertenece el socio:");
        String nombreFederacion = scanner.nextLine();

        System.out.println("Introduce el código de la federación a la que pertenece el socio:");
        String codigoFederacion = scanner.nextLine();

        Federacion federacion = new Federacion(codigoFederacion, nombreFederacion);

        Federado nuevoSocio = new Federado(nombre, numero, nif, federacion);
        datos.addObjeto(nuevoSocio, 3);
    }

    public void addInfantil() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre del socio:");
        String nombre = scanner.nextLine();

        System.out.println("Introduce el número del socio:");
        int numero = scanner.nextInt();

        System.out.println("Introduce el número del socio del tutor:");
        int numSocioTutor = scanner.nextInt();

        Infantil nuevoSocio = new Infantil(nombre, numero, numSocioTutor);
        datos.addObjeto(nuevoSocio, 3);
    }

    public void addEstandar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre del socio:");
        String nombre = scanner.nextLine();

        System.out.println("Introduce el número del socio:");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduce el NIF del socio:");
        String nif = scanner.nextLine();

        System.out.println("Selecciona el tipo de seguro (1: Básico, 2: Completo):");
        int tipoSeguro = scanner.nextInt();

        Seguro seguroEstandar;
        switch (tipoSeguro) {
            case 1:
                seguroEstandar = Seguro.BASICO;
                break;
            case 2:
                seguroEstandar = Seguro.COMPLETO;
                break;
            default:
                System.out.println("Tipo de seguro no válido.");
                return;
        }

        Estandar nuevoSocio = new Estandar(nombre, numero, nif, seguroEstandar);
        datos.addObjeto(nuevoSocio, 3);
    }



    public void removeSocio() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de socio que desea eliminar:");
            int numeroSocio = scanner.nextInt();
        Socio socioToRemove = datos.listObjetos(3).stream()
                .filter(obj -> obj instanceof Socio)
                .map(obj -> (Socio) obj)
                .filter(socio -> socio.getNumero() == numeroSocio)
                .findFirst()
                .orElse(null);

        if (socioToRemove != null) {
            datos.removeObjeto(socioToRemove, 3);
        } else {
            System.out.println("No se encontró un socio con el número " + numeroSocio);
        }
    }

    public List<Socio> listSocios() {
        // Obtiene la lista de todos los socios directamente desde los datos
        return datos.listObjetos(3).stream()
                .filter(obj -> obj instanceof Socio)
                .map(obj -> (Socio) obj)
                .collect(Collectors.toList());
    }

    public List<Socio> listTipoSocios() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de socio que desea ver:");
        System.out.println("1. Estandar");
        System.out.println("2. Federado");
        System.out.println("3. Infantil");
        int tipoSocio = scanner.nextInt();

        // Obtiene la lista de todos los socios directamente desde los datos
        List<Socio> sociosList = datos.listObjetos(3).stream()
                .filter(obj -> obj instanceof Socio)
                .map(obj -> (Socio) obj)
                .toList();

        List<Socio> filteredSocios;
        switch (tipoSocio) {
            case 1:
                filteredSocios = sociosList.stream()
                        .filter(socio -> socio instanceof Estandar)
                        .collect(Collectors.toList());
                break;
            case 2:
                filteredSocios = sociosList.stream()
                        .filter(socio -> socio instanceof Federado)
                        .collect(Collectors.toList());
                break;
            case 3:
                filteredSocios = sociosList.stream()
                        .filter(socio -> socio instanceof Infantil)
                        .collect(Collectors.toList());
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                return Collections.emptyList();
        }

        if (filteredSocios.isEmpty()) {
            System.out.println("No hay socios que correspondan con esto.");
        } else {
            // Imprime solo los socios filtrados
            for (Socio socio : filteredSocios) {
                System.out.println(socio.toString());
            }
        }

        return filteredSocios; // Devuelve la lista de socios filtrados
    }

    public void showFacturaMensualSocios() {
    }
    public void modificarSeguro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número del socio:");
        int numeroSocio = scanner.nextInt();
        System.out.println("Introduce el tipo de seguro (1: Básico, 2: Completo):");
        int tipoSeguro = scanner.nextInt();
        Socio socio = buscarSocioPorNumero(numeroSocio);
        if (socio != null) {
            if (socio instanceof Estandar socioEstandar) {
                switch (tipoSeguro) {
                    case 1:
                        socioEstandar.setSeguro(Seguro.BASICO);
                        System.out.println("El tipo de seguro del socio " + numeroSocio + " ha sido cambiado a Básico");
                        break;
                    case 2:
                        socioEstandar.setSeguro(Seguro.COMPLETO);
                        System.out.println("El tipo de seguro del socio " + numeroSocio + " ha sido cambiado a Completo");
                        break;
                    default:
                        System.out.println("Tipo de seguro no válido.");
                        break;
                }
            } else {
                System.out.println("El socio con el número " + numeroSocio + " no es de tipo Estandar y no puede cambiar su seguro");
            }
        } else {
            System.out.println("No se encontró un socio con el número " + numeroSocio);
        }
    }

    private Socio buscarSocioPorNumero(int numeroSocio) {
        return datos.listObjetos(3).stream()
                .filter(obj -> obj instanceof Socio)
                .map(obj -> (Socio) obj)
                .filter(socio -> socio.getNumero() == numeroSocio)
                .findFirst()
                .orElse(null);
    }

}
