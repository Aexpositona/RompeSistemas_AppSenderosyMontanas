package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;

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


    public void addSocio(Socio socio) {
        datos.addObjeto(socio, 3);
    }


    public void addFederado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre del socio:");
        String nombre = scanner.nextLine();

        System.out.println("Introduce el número del socio:");
        int numero = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        System.out.println("Introduce la federación a la que pertenece el socio:");
        String nombreFederacion = scanner.nextLine();

        Federacion federacion = new Federacion("codigo", nombreFederacion); // Aquí necesitarás proporcionar un código para la federación

        Federado nuevoSocio = new Federado(nombre, numero, federacion);
        addSocio(nuevoSocio);
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
        addSocio(nuevoSocio);
    }

    public void addEstandar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el nombre del socio:");
        String nombre = scanner.nextLine();

        System.out.println("Introduce el número del socio:");
        int numero = scanner.nextInt();
        scanner.nextLine(); // consume the newline

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
        addSocio(nuevoSocio);
    }



    public void removeSocio(int numeroSocio) {
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

    public String listTipoSocios(String tipoSocio) {
        List<Object> sociosList = datos.listObjetos(3);
        List<Socio> filteredSocios = sociosList.stream()
                .filter(obj -> obj instanceof Socio)
                .map(obj -> (Socio) obj)
                .filter(socio -> socio.getTipo().equalsIgnoreCase(tipoSocio))
                .toList();

        if (filteredSocios.isEmpty()) {
            return "No hay socios que correspondan con esto.";
        } else {
            // Convert the list of Socios to a string and return it
            return filteredSocios.toString();
        }
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

    public List<Socio> listSocios() {
        List<Object> sociosList = datos.listObjetos(3);
        return sociosList.stream()
                .filter(obj -> obj instanceof Socio)
                .map(obj -> (Socio) obj)
                .collect(Collectors.toList());
    }
}
