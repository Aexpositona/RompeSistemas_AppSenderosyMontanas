package RompeSistemas.Controlador;

import RompeSistemas.Modelo.*;
import RompeSistemas.Vista.VistaSocios;
import RompeSistemas.Vista.VistaModificarSeguro;
import RompeSistemas.Vista.VistaListarSocios;
import RompeSistemas.Vista.VistaAddSocio;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
        this.datos = new Datos(app.getDatos());
        this.cDatos = new ControlDatos(app.getControlDatos());
        this.vSocios = new VistaSocios(this);
        this.vModificarSeguro = new VistaModificarSeguro(this);
        this.vListarSocios = new VistaListarSocios(this);
        this.vAddSocio = new VistaAddSocio(this);
        this.cPeticiones = new ControlPeticiones(app.getControlPeticiones());

    }

    /**
     * Constructor de ControlSocios de copia.
     *
     * @param cSocios ControlSocios a copiar
     */
    public ControlSocios(ControlSocios cSocios) {
        this.app = cSocios.getApp();
        this.vSocios = cSocios.getVistaSocios();
        this.vModificarSeguro = cSocios.getVistaModificarSeguro();
        this.vListarSocios = cSocios.getVistaListarSocios();
        this.vAddSocio = cSocios.getVistaAddSocio();
        this.cPeticiones = cSocios.getControlPeticiones();
        this.cDatos = cSocios.getControlDatos();
        this.datos = cSocios.getDatos();
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


    // Métodos de la vista

    public void addSocio(Socio socio) {
        datos.addObjeto(3, socio);
    }


    public void showVistaListarSocios() throws ParseException{
        vListarSocios.show();
    }
    
    public void showVistaAddSocio() throws ParseException{
        vAddSocio.show();
    }

    public void showVistaModificarSeguro() throws ParseException{
        vModificarSeguro.show();
    }

    // Métodos gestión de socios

    public void removeSocio(int tipoObjeto, int numeroSocio) {
        Socio[] socios = datos.getArrayList(tipoObjeto).toArray(new Socio[0]);
        for (Socio socio : socios) {
            if (socio.getNumero() == numeroSocio) {
                datos.removeObjeto(tipoObjeto, socio);
                break;
            }
        }
    }
    // Métodos para listar socios
    public void listSocios(int tipoObjeto) {
        // Obtenemos un array de socios de la lista de socios
        Socio[] socios = datos.getArrayList(tipoObjeto).toArray(new Socio[0]);
        // Recorremos el array de socios y mostramos cada socio
        for (Socio socio : socios) {
            System.out.println(socio.toString());
        }
    }

    public void listTipoSocios(int tipoObjeto, int tipoSocio) {
        // Obtenemos un array de socios de la lista de socios
        List<Object> listaObjetos = datos.getArrayList(tipoObjeto);
        List<Socio> listaSocios = new ArrayList<>();
        for (Object objeto : listaObjetos) {
            if (objeto instanceof Socio) {
                listaSocios.add((Socio) objeto);
            }
        }
        Socio[] socios = listaSocios.toArray(new Socio[0]);
        // Recorremos el array de socios y mostramos los socios del tipo indicado
        for (Socio socio : socios) {
            if (socio.getTipo() == tipoSocio) {
                System.out.println(socio.toString());
            }
        }
    }

    public void showFacturaMensualSocios() {
        // Obtenemos la fecha actual
        LocalDate now = LocalDate.now();
        // Calculamos la fecha de hace un mes
        LocalDate oneMonthAgo = now.minusMonths(1);

        // Obtenemos la lista de socios
        List<Object> sociosList = datos.getArrayList(3);
        // Obtenemos la lista de inscripciones
        List<Object> inscripcionesList = datos.getArrayList(2);

        // Recorremos la lista de socios
        for (Object obj : sociosList) {
            if (obj instanceof Socio) {
                Socio socio = (Socio) obj;
                double total = 0.0;

                // Recorremos la lista de inscripciones
                for (Object objInscripcion : inscripcionesList) {
                    if (objInscripcion instanceof Inscripcion) {
                        Inscripcion inscripcion = (Inscripcion) objInscripcion;
                        // Comprobamos si el socio de la inscripción es el socio que estamos procesando
                        if (inscripcion.getSocio().equals(socio)) {
                            // Obtenemos la excursión de la inscripción
                            Excursion excursion = inscripcion.getExcursion();
                            // Comprobamos si la fecha de la excursión está dentro del último mes
                            if (!excursion.getFecha().isBefore(oneMonthAgo) && !excursion.getFecha().isAfter(now)) {
                                // Sumamos el precio de la excursión al total
                                total += excursion.getPrecio();
                            }
                        }
                    }
                }

                // Imprimimos el número de socio, el nombre y el total de las inscripciones
                System.out.println("Número de socio: " + socio.getNumero());
                System.out.println("Nombre: " + socio.getNombre());
                System.out.println("Total de inscripciones del último mes: " + total);
            }
        }
    }

    public void modificarSeguro(String numeroSocio, int tipoSeguro) {



    }

}
