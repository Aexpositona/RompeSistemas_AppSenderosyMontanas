package RompeSistemas.Modelo;

public class DataLoader {
    private Datos datos;

    public DataLoader(Datos datos) {
        this.datos = datos;
    }

    public void load() {
        // Crear objetos de ejemplo
        Estandar estandar1 = new Estandar("Juan", 1, "1234590A",Seguro.BASICO);
        Estandar estandar2 = new Estandar("Luis", 2, "1234590B",Seguro.COMPLETO);
        Estandar estandar3 = new Estandar("Ana", 3, "1234590C",Seguro.BASICO);

        Federado federado1 = new Federado("Pedro", 4,"23213312A", new Federacion("123", "Federación de montes"));
        Federado federado2 = new Federado("Marc", 5,"84736189B", new Federacion("124", "Federación de ríos"));
        Federado federado3 = new Federado("Carlos", 6,"87637489V", new Federacion("125", "Federación de montañas"));

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
}