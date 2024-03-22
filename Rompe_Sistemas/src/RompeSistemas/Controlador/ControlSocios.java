package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
import RompeSistemas.Vista.VistaSocios;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ControlSocios {

    // Atributos
    private VistaSocios vSocios;
    private Datos<Excursion, Inscripcion, Socio> datos;

    /**
     * Constructor de ControlSocios.
     * @param vSocios VistaSocios asociada al controlador
     */
    public ControlSocios(VistaSocios vSocios) {
        this.vSocios = vSocios;
        this.datos = new Datos<>();
    }

    // Métodos


    public void addSocio(Socio nuevoSocio) {
        datos.agregarSocio(nuevoSocio);
    }


    public void añadirFederado() {
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

    public void añadirInfantil() {
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

    public void añadirEstandar() {
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



    public void removeSocio() {
    }

    public List<Socio> listTipoSocios(String tipoSocio) {
        return datos.getSocios().stream()
                .filter(socio -> socio.getTipo().equalsIgnoreCase(tipoSocio))
                .collect(Collectors.toList());
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
            if (socio instanceof Estandar) {
                Estandar socioEstandar = (Estandar) socio;
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
        for (Socio socio : datos.getSocios()) {
            if (socio.getNumero() == numeroSocio) {
                return socio;
            }
        }
        return null;
    }

    public List<Socio> listSocios() {
        return datos.getSocios();
    }
}
