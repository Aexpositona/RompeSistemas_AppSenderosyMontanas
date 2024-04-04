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
        datos.addObjeto(new Estandar("Juan", 1, "1234590A",Seguro.BASICO), 3);
        datos.addObjeto(new Estandar("Luis", 2, "1234590B",Seguro.COMPLETO), 3);
        datos.addObjeto(new Estandar("Ana", 3, "1234590C",Seguro.BASICO), 3);

        // Añadir usuarios federados a la lista de socios
        datos.addObjeto(new Federado("Pedro", 4,"23213312A", new Federacion("12345", "Federación de montes")), 3);
        datos.addObjeto(new Federado("Marc", 5,"84736189B", new Federacion("124566", "Federación de ríos")), 3);
        datos.addObjeto(new Federado("Carlos", 6,"87637489V", new Federacion("12512", "Federación de montañas")), 3);

        // Añadir usuarios infantiles a la lista de socios
        datos.addObjeto(new Infantil("Ana", 7, 1), 3);
        datos.addObjeto(new Infantil("Luis", 8, 2), 3);
    }

    /**
     * Método que carga las excursiones de ejemplo en el sistema.
     */
    // Cargar excursiones
    private void loadExcursiones() {

        // Añadir excursiones a la lista de excursiones
        datos.addObjeto(new Excursion("00001", "Salida al monte", LocalDate.of(2024, 5, 15) , 5, (float)50), 1);
        datos.addObjeto(new Excursion("00002", "Salida al río", LocalDate.of(2024, 8, 30), 3, (float)60), 1);
        datos.addObjeto(new Excursion("00003", "Salida a la montaña", LocalDate.of(2024, 10, 3), 7, (float)70), 1);
    }

    /**
     * Método que carga las inscripciones de ejemplo en el sistema.
     */
    // Cargar inscripciones
    private void loadInscripciones() {

        // Añadir inscripciones a la lista de inscripciones
        datos.addObjeto(new Inscripcion(1, (Socio) datos.getObjeto(1, 1), (Excursion) datos.getObjeto(1, 3)), 2);
        datos.addObjeto(new Inscripcion(2, (Socio) datos.getObjeto(2, 1), (Excursion) datos.getObjeto(2, 3)), 2);
        datos.addObjeto(new Inscripcion(3, (Socio) datos.getObjeto(3, 1), (Excursion) datos.getObjeto(3, 3)), 2);
    }
}