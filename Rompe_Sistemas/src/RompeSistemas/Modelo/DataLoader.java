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
        datos.addObjeto(3, new Estandar("Juan", 1, "1234590A",Seguro.BASICO));
        datos.addObjeto(3, new Estandar("Luis", 2, "1234590B",Seguro.COMPLETO));
        datos.addObjeto(3, new Estandar("Ana", 3, "1234590C",Seguro.BASICO));

        datos.addObjeto(4, new Federacion("12345", "Federación de montes"));
        datos.addObjeto(4, new Federacion("12456", "Federación de ríos"));
        datos.addObjeto(4, new Federacion("12512", "Federación de montañas"));

        // Añadir usuarios federados a la lista de socios
        datos.addObjeto(3, new Federado("Pedro", 4,"23213312A", (Federacion) datos.getObjeto(4, datos.buscarObjeto(4, "12345"))));
        datos.addObjeto(3, new Federado("Marc", 5,"84736189B", (Federacion) datos.getObjeto(4, datos.buscarObjeto(4, "12456"))));
        datos.addObjeto(3, new Federado("Carlos", 6,"87637489V", (Federacion) datos.getObjeto(4, datos.buscarObjeto(4, "12512"))));

        // Añadir usuarios infantiles a la lista de socios
        datos.addObjeto(3, new Infantil("Ana", 7,"83736182A", 1));
        datos.addObjeto(3, new Infantil("Luis", 8,"83736182B", 2));
        datos.addObjeto(3, new Infantil("Marcos", 9,"83736182C", 3));
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
        datos.addObjeto(2, new Inscripcion(1, (Socio) datos.getObjeto(3, datos.buscarObjeto(1, "EXC0001")), (Excursion) datos.getObjeto(1, datos.buscarObjeto(1, "EXC0001"))));
        datos.addObjeto(2, new Inscripcion(2, (Socio) datos.getObjeto(3, datos.buscarObjeto(1, "EXC0001")), (Excursion) datos.getObjeto(1, datos.buscarObjeto(1, "EXC0002"))));
        datos.addObjeto(2, new Inscripcion(3, (Socio) datos.getObjeto(3, datos.buscarObjeto(1, "EXC0001")), (Excursion) datos.getObjeto(1, datos.buscarObjeto(1, "EXC0003"))));
    }
}