package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;


public class ControlSocios {

    // Atributos
    private APPSenderosMontanas app;
    /**
     * Constructor de ControlSocios.
     *
     */
    public ControlSocios(APPSenderosMontanas app) {
        this.app = app;
    }

    // Getters

    public APPSenderosMontanas getApp() {
        return app;
    }

    // Setters

    public void setApp(APPSenderosMontanas app) {
        this.app = app;
    }

    // Métodos


    public void addFederado() {


        String nombre = app.cPeticiones.pedirString("Introduce el nombre del socio: ");

        int numero = app.cPeticiones.pedirEntero("Introduce el número del socio: ", 0, Integer.MAX_VALUE);

        String nif = app.cPeticiones.pedirNIF("Introduce el NIF del socio: ");

        String codigoFederacion = app.cPeticiones.pedirString("Introduce el código de la federación a la que pertenece el socio: ");

        Object federacion = app.datos.getObjeto(2, app.datos.buscarObjeto(codigoFederacion,2));
        
        Federado nuevoSocio = new Federado(nombre, numero, nif, (Federacion) federacion);

        app.datos.addObjeto(nuevoSocio, 3);
    }

    public void addInfantil() {

        String nombre = app.cPeticiones.pedirString("Introduce el nombre del socio: ");

        int numero = app.cPeticiones.pedirEntero("Introduce el número del socio: ", 0, Integer.MAX_VALUE);

        int numSocioTutor = app.cPeticiones.pedirEntero("Introduce el número del socio del tutor: ", 0, Integer.MAX_VALUE);

        Infantil nuevoSocio = new Infantil(nombre, numero, numSocioTutor);
        app.datos.addObjeto(nuevoSocio, 3);
    }

    public void addEstandar() {

        String nombre = app.cPeticiones.pedirString("Introduce el nombre del socio: ");

        int numero = app.cPeticiones.pedirEntero("Introduce el número del socio: ", 0, Integer.MAX_VALUE);

        String nif = app.cPeticiones.pedirNIF("Introduce el NIF del socio: ");

        int tipoSeguro = app.cPeticiones.pedirEntero("Introduce el tipo de seguro: ", 1, 2);

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
        app.datos.addObjeto(nuevoSocio, 3);
    }



    public void removeSocio() {
        int numeroSocio = app.cPeticiones.pedirEntero("Introduce el número del socio: ", 0, Integer.MAX_VALUE);
        Socio socioToRemove = app.datos.listObjetos(3).stream()
                .filter(obj -> obj instanceof Socio)
                .map(obj -> (Socio) obj)
                .filter(socio -> socio.getNumero() == numeroSocio)
                .findFirst()
                .orElse(null);

        if (socioToRemove != null) {
            app.datos.removeObjeto(socioToRemove, 3);
        } else {
            System.out.println("No se encontró un socio con el número " + numeroSocio);
        }
    }

    public List<Socio> listSocios() {
        // Obtiene la lista de todos los socios directamente desde los datos
        return app.datos.listObjetos(3).stream()
                .filter(obj -> obj instanceof Socio)
                .map(obj -> (Socio) obj)
                .collect(Collectors.toList());
    }

    public List<Socio> listTipoSocios() {
        System.out.println("Seleccione el tipo de socio que desea ver:");
        System.out.println("1. Estandar");
        System.out.println("2. Federado");
        System.out.println("3. Infantil");
        int tipoSocio = app.cPeticiones.pedirEntero("Introduzca una opción: ", 1, 3);

        // Obtiene la lista de todos los socios directamente desde los datos
        List<Socio> sociosList = app.datos.listObjetos(3).stream()
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
        int numeroSocio = app.cPeticiones.pedirEntero("Introduce el número del socio: ", 0, Integer.MAX_VALUE);
        int tipoSeguro = app.cPeticiones.pedirEntero("Introduce el tipo de seguro: ", 1, 2);
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
        return app.datos.listObjetos(3).stream()
                .filter(obj -> obj instanceof Socio)
                .map(obj -> (Socio) obj)
                .filter(socio -> socio.getNumero() == numeroSocio)
                .findFirst()
                .orElse(null);
    }

}
