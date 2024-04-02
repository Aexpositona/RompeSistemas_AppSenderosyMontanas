package RompeSistemas.Modelo;

import java.time.LocalDate;

public class DataLoader {
    private final Datos datos;

    public DataLoader(Datos datos) {
        this.datos = datos;
    }

    public void load() {

        loadSocios();
        loadExcursiones();
        loadInscripciones();

    }

    private void loadSocios(){
        // Crear objetos de ejemplo
        Estandar estandar1 = new Estandar("Juan", 1, "1234590A",Seguro.BASICO);
        Estandar estandar2 = new Estandar("Luis", 2, "1234590B",Seguro.COMPLETO);
        Estandar estandar3 = new Estandar("Ana", 3, "1234590C",Seguro.BASICO);

        Federado federado1 = new Federado("Pedro", 4,"23213312A", new Federacion("12345", "Federación de montes"));
        Federado federado2 = new Federado("Marc", 5,"84736189B", new Federacion("124566", "Federación de ríos"));
        Federado federado3 = new Federado("Carlos", 6,"87637489V", new Federacion("12512", "Federación de montañas"));

        Infantil infantil1 = new Infantil("Ana", 7, 1);
        Infantil infantil2 = new Infantil("Luis", 8, 2);

        // Añadir objetos a las listas
        datos.addObjeto(estandar1, 3);
        datos.addObjeto(estandar2, 3);
        datos.addObjeto(estandar3, 3);

        datos.addObjeto(federado1, 3);
        datos.addObjeto(federado2, 3);
        datos.addObjeto(federado3, 3);

        datos.addObjeto(infantil1, 3);
        datos.addObjeto(infantil2, 3);
    }

    private void loadExcursiones() {

        // Crear objetos de ejemplo
        Excursion excursion1 = new Excursion("00001", "Salida al monte", LocalDate.of(2024, 5, 15) , 5, (float)50);
        Excursion excursion2 = new Excursion("00002", "Salida al río", LocalDate.of(2024, 8, 30), 3, (float)60);
        Excursion excursion3 = new Excursion("00003", "Salida a la montaña", LocalDate.of(2024, 10, 3), 7, (float)70);

        // Añadir objetos a las listas
        datos.addObjeto(excursion1, 1);
        datos.addObjeto(excursion2, 1);
        datos.addObjeto(excursion3, 1);
    }

    private void loadInscripciones() {

        // Crear objetos de ejemplo
        Inscripcion inscripcion1 = new Inscripcion(1, (Socio) datos.getObjeto(1, 1), (Excursion) datos.getObjeto(1, 3));
        Inscripcion inscripcion2 = new Inscripcion(2, (Socio) datos.getObjeto(2, 1), (Excursion) datos.getObjeto(2, 3));
        Inscripcion inscripcion3 = new Inscripcion(3, (Socio) datos.getObjeto(3, 1), (Excursion) datos.getObjeto(3, 3));

        // Añadir objetos a las listas
        datos.addObjeto(inscripcion1, 2);
        datos.addObjeto(inscripcion2, 2);
        datos.addObjeto(inscripcion3, 2);
    }
}