package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
import RompeSistemas.Vista.VistaSocios;
import RompeSistemas.Vista.VistaModificarSeguro;
import RompeSistemas.Vista.VistaListarSocios;
import RompeSistemas.Vista.VistaAddSocio;
import java.util.List;
import java.util.stream.Collectors;
import java.text.ParseException;
import java.util.Collections;


public class ControlSocios {

    // Atributos
    private APPSenderosMontanas app;
    private VistaSocios vSocios;
    private VistaModificarSeguro vModificarSeguro;
    private VistaListarSocios vListarSocios;
    private VistaAddSocio vAddSocio;
    private ControlPeticiones cPeticiones;
    private ControlDatos cDatos;
    private Datos datos;

    /**
     * Constructor de ControlSocios.
     * 
     * @param app APPSenderosMontanas asociada al controlador.
     */
    public ControlSocios(APPSenderosMontanas app) {
        this.app = app;
        this.vSocios = new VistaSocios(this);
        this.vModificarSeguro = new VistaModificarSeguro(this);
        this.vListarSocios = new VistaListarSocios(this);
        this.vAddSocio = new VistaAddSocio(this);
        this.cPeticiones = app.cPeticiones;
        this.datos = app.datos;
        this.cDatos = app.cDatos;
    }

    // Getters

    public APPSenderosMontanas getApp() {
        return app;
    }

    public VistaSocios getVistaSocios() {
        return vSocios;
    }

    public VistaModificarSeguro getVistaModificarSeguro() {
        return vModificarSeguro;
    }

    public VistaListarSocios getVistaListarSocios() {
        return vListarSocios;
    }

    public VistaAddSocio getVistaAddSocio() {
        return vAddSocio;
    }

    public ControlPeticiones getControlPeticiones() {
        return cPeticiones;
    }

    public ControlDatos getControlDatos() {
        return cDatos;
    }

    public Datos getDatos() {
        return datos;
    }

    // Setters
    public void setApp(APPSenderosMontanas app) {
        this.app = app;
    }

    public void setVistaSocios(VistaSocios vSocios) {
        this.vSocios = vSocios;
    }

    public void setVistaModificarSeguro(VistaModificarSeguro vModificarSeguro) {
        this.vModificarSeguro = vModificarSeguro;
    }

    public void setVistaListarSocios(VistaListarSocios vListarSocios) {
        this.vListarSocios = vListarSocios;
    }

    public void setVistaAddSocio(VistaAddSocio vAddSocio) {
        this.vAddSocio = vAddSocio;
    }

    public void setControlPeticiones(ControlPeticiones cPeticiones) {
        this.cPeticiones = cPeticiones;
    }

    public void setControlDatos(ControlDatos cDatos) {
        this.cDatos = cDatos;
    }

    public void setDatos(Datos datos) {
        this.datos = datos;
    }

    // Métodos

    public void show() throws ParseException{
        vSocios.show();
    }


    public void addSocio(int tipoObjeto, Object socio) {
        datos.addObjeto(tipoObjeto, socio);
    }

    public void addFederado() {

    }

    public void addInfantil() {

        String nombre = cPeticiones.pedirString("Introduce el nombre del socio: ");

        int numero = cPeticiones.pedirEntero("Introduce el número del socio: ", 0, Integer.MAX_VALUE);

        int numSocioTutor = cPeticiones.pedirEntero("Introduce el número del socio del tutor: ", 0, Integer.MAX_VALUE);

        Infantil nuevoSocio = new Infantil(nombre, numero, numSocioTutor);
        app.datos.addObjeto(3, nuevoSocio);
    }

    public void addEstandar() {

        String nombre = cPeticiones.pedirString("Introduce el nombre del socio: ");

        int numero = cPeticiones.pedirEntero("Introduce el número del socio: ", 0, Integer.MAX_VALUE);

        String nif = cPeticiones.pedirNIF("Introduce el NIF del socio: ");

        int tipoSeguro = cPeticiones.pedirEntero("Introduce el tipo de seguro: ", 1, 2);

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
        app.datos.addObjeto(3, nuevoSocio);
    }



    public void removeSocio() {
        int numeroSocio = cPeticiones.pedirEntero("Introduce el número del socio: ", 0, Integer.MAX_VALUE);
        Socio socioToRemove = app.datos.listObjetos(3).stream()
                .filter(obj -> obj instanceof Socio)
                .map(obj -> (Socio) obj)
                .filter(socio -> socio.getNumero() == numeroSocio)
                .findFirst()
                .orElse(null);

        if (socioToRemove != null) {
            app.datos.removeObjeto(3, socioToRemove);
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
        int tipoSocio = cPeticiones.pedirEntero("Introduzca una opción: ", 1, 3);

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
        int numeroSocio = cPeticiones.pedirEntero("Introduce el número del socio: ", 0, Integer.MAX_VALUE);
        int tipoSeguro = cPeticiones.pedirEntero("Introduce el tipo de seguro: ", 1, 2);
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
