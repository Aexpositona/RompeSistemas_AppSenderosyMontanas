package RompeSistemas.Modelo;

import java.time.LocalDate;

/**
 * Clase que realiza la carga de datos de ejemplo en el sistema.
 */
public class DataLoader {
    // Atributos
    private Datos datos;
    // Métodos constructores
    public DataLoader(Datos datos) {
        this.datos = datos;
    }

    // Método de carga principal
    public void load(Datos datos) {
        // Cargar datos de ejemplo mediante métodos privados
        // Cargar socios
        loadSocios();
        // Cargar excursiones
        loadExcursiones();
        // Cargar inscripciones
        loadInscripciones();

    }

    // Métodos privados de carga de datos //

    /**
     * Método que carga los socios de ejemplo en el sistema.
     */
    // Cargar socios
    private void loadSocios(){

        // Añadir usuarios estandar a la lista de socios
        datos.addObjeto(3, new Estandar("Juan", "SOC0001", "1234590A",Seguro.BASICO));
        datos.addObjeto(3, new Estandar("Luis", "SOC0002", "1234590B",Seguro.COMPLETO));
        datos.addObjeto(3, new Estandar("Ana", "SOC0003", "1234590C",Seguro.BASICO));

        datos.addObjeto(4, new Federacion("FED001", "Federación de montes"));
        datos.addObjeto(4, new Federacion("FED002", "Federación de ríos"));
        datos.addObjeto(4, new Federacion("FED003", "Federación de montañas"));

        // Añadir usuarios federados a la lista de socios
        datos.addObjeto(3, new Federado("Pedro", "SOC0004","23213312A", (Federacion) datos.getObjeto(4, datos.buscarObjeto(4, "FED001"))));
        datos.addObjeto(3, new Federado("Marc", "SOC0005","84736189B", (Federacion) datos.getObjeto(4, datos.buscarObjeto(4, "FED002"))));
        datos.addObjeto(3, new Federado("Carlos", "SOC0006","87637489V", (Federacion) datos.getObjeto(4, datos.buscarObjeto(4, "FED003"))));

        // Añadir usuarios infantiles a la lista de socios
        datos.addObjeto(3, new Infantil("Ana", "SOC0007","83736182A", "SOC0001"));
        datos.addObjeto(3, new Infantil("Luis", "SOC0008","83736182B", "SOC0002"));
        datos.addObjeto(3, new Infantil("Marcos", "SOC0009","83736182C", "SOC0003"));
    }

    /**
     * Método que carga las excursiones de ejemplo en el sistema.
     */
    // Cargar excursiones
    private void loadExcursiones() {

        // Añadir excursiones a la lista de excursiones
        datos.addObjeto(1, new Excursion("EXC0001", "Salida al monte", LocalDate.of(2024, 4, 1) , 5, (float)50));
        datos.addObjeto(1, new Excursion("EXC0002", "Salida al río", LocalDate.of(2024, 8, 30), 3, (float)60));
        datos.addObjeto(1, new Excursion("EXC0003", "Salida a la montaña", LocalDate.of(2024, 10, 3), 7, (float)70));
    }

    /**
     * Método que carga las inscripciones de ejemplo en el sistema.
     */
    // Cargar inscripciones
    private void loadInscripciones() {

        // Añadir inscripciones a la lista de inscripciones
        datos.addObjeto(2, new Inscripcion("INS0001", (Socio) datos.getObjeto(3, datos.buscarObjeto(1, "EXC0001")), (Excursion) datos.getObjeto(1, datos.buscarObjeto(1, "EXC0001"))));
        datos.addObjeto(2, new Inscripcion("INS0002", (Socio) datos.getObjeto(3, datos.buscarObjeto(1, "EXC0001")), (Excursion) datos.getObjeto(1, datos.buscarObjeto(1, "EXC0002"))));
        datos.addObjeto(2, new Inscripcion("INS0003", (Socio) datos.getObjeto(3, datos.buscarObjeto(1, "EXC0001")), (Excursion) datos.getObjeto(1, datos.buscarObjeto(1, "EXC0003"))));
    }
}