package RompeSistemas.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Clase que representa los datos de la aplicación.
 */
public class Datos {

    // Atributos

    private Object objeto; // Objeto genérico
    private Seguro seguro; // Seguro

    // Un ArrayList para cada tipo de dato
    private List<Object> excursiones, inscripciones, socios, federaciones;

    // Constructor

    /**
     * Constructor de la clase Datos.
     */
    public Datos() {
        // Inicializar los ArrayList
        excursiones = new ArrayList<>();
        inscripciones = new ArrayList<>();
        socios = new ArrayList<>();
        federaciones = new ArrayList<>();
        objeto = new Object();
    }

    // Métodos

    public Seguro getSeguro() {
        return seguro;
    }

    /**
     * Método para obtener un List de un tipo de objeto.
     *
     * @param tipoObjeto Tipo de objeto
     *                      1 - Excursión
     *                      2 - Inscripción
     *                      3 - Socio
     *                      4 - Federación
     * @return List de objetos
     */
    public List<Object> getArrayList(int tipoObjeto) {
        // Devolver el ArrayList del tipo de objeto
        return switch (tipoObjeto) {
            case 1 -> excursiones;
            case 2 -> inscripciones;
            case 3 -> socios;
            case 4 -> federaciones;
            default -> null;
        };
    }

    /**
     * Método para agregar un objeto a alguno de los ArrayList.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param objeto     Objeto a agregar
     */
    public void addObjeto(int tipoObjeto, Object objeto) {
        switch (tipoObjeto) {
            case 1 -> excursiones.add(objeto);
            case 2 -> inscripciones.add(objeto);
            case 3 -> socios.add(objeto);
            case 4 -> federaciones.add(objeto);
        }
    }

    /**
     * Método para eliminar un objeto de alguno de los ArrayList.
     * 
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param objeto     Objeto a eliminar
     */
    public void removeObjeto(int tipoObjeto, Object objeto) {
        switch (tipoObjeto) {
            case 1 -> excursiones.remove(objeto);
            case 2 -> inscripciones.remove(objeto);
            case 3 -> socios.remove(objeto);
            case 4 -> federaciones.remove(objeto);
        }
    }

    /**
     * Método para modificar un objeto de alguno de los ArrayList.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param objeto     Objeto a modificar

     */
    public void modificarObjeto(int tipoObjeto, Object objeto) {
        switch (tipoObjeto) {
            case 1 -> excursiones.set(excursiones.indexOf(objeto), objeto);
            case 2 -> inscripciones.set(inscripciones.indexOf(objeto), objeto);
            case 3 -> socios.set(socios.indexOf(objeto), objeto);
            case 4 -> federaciones.set(federaciones.indexOf(objeto), objeto);
        }
    }

    /**
     * Método para obtener un objeto de alguno de los ArrayList.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param index      Índice del objeto
     * @return Objeto
     */
    public Object getObjeto(int tipoObjeto, int index) {
        switch (tipoObjeto) {
            case 1 -> objeto = excursiones.get(index);
            case 2 -> objeto = inscripciones.get(index);
            case 3 -> objeto = socios.get(index);
            case 4 -> objeto = federaciones.get(index);
        }
        return objeto;
    }

    /**
     * Método para buscar un objeto en alguno de los ArrayList.
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param string    String a buscar
     * @return Índice del objeto
     */
    public int buscarObjeto(int tipoObjeto, String string) {

        // Si el tipo de objeto es 1 (Excursión)
        if (tipoObjeto == 1) {
            // Si el ArrayList de excursiones está vacío
            if (excursiones.isEmpty()) {
                // Devolver -1
                return -1;
            }
            // Si el ArrayList de excursiones no está vacío
            else {
                // Recorrer el ArrayList de excursiones
                for (int i = 0; i < excursiones.size(); i++) {
                    // Obtener la excursión en la posición i
                    Excursion excursion = (Excursion) excursiones.get(i);
                    // Si el código de la excursión es igual al string
                    if (excursion.getCodigo().equals(string)) {
                        // Devolver la posición i
                        return i;
                    }
                }
            }
        }
        // Si el tipo de objeto es 2 (Inscripción)
        else if (tipoObjeto == 2) {
            // Si el ArrayList de inscripciones está vacío
            if (inscripciones.isEmpty()) {
                // Devolver -1
                return -1;
            }
            // Si el ArrayList de inscripciones no está vacío
            else {
                // Recorrer el ArrayList de inscripciones
                for (int i = 0; i < inscripciones.size(); i++) {
                    // Obtener la inscripción en la posición i
                    Inscripcion inscripcion = (Inscripcion) inscripciones.get(i);
                    // Si el número de la inscripción es igual al string
                    if (inscripcion.getNumero() == Integer.parseInt(string)) {
                        // Devolver la posición i
                        return i;
                    }
                }
            }
        }
        // Si el tipo de objeto es 3 (Socio)
        else if (tipoObjeto == 3) {
            // Si el ArrayList de socios está vacío
            if (socios.isEmpty()) {
                // Devolver -1
                return -1;
            }
            // Si el ArrayList de socios no está vacío
            else {
                // Recorrer el ArrayList de socios
                for (int i = 0; i < socios.size(); i++) {
                    // Obtener el socio en la posición i
                    Socio socio = (Socio) socios.get(i);
                    // Si el nombre del socio es igual al string
                    if (socio.getNombre().equals(string)) {
                        // Devolver la posición i
                        return i;
                    }
                }
            }
        }
        else if (tipoObjeto == 4) {
            // Si el ArrayList de federaciones está vacío
            if (federaciones.isEmpty()) {
                // Devolver -1
                return -1;
            }
            // Si el ArrayList de federaciones no está vacío
            else {
                // Recorrer el ArrayList de federaciones
                for (int i = 0; i < federaciones.size(); i++) {
                    // Obtener la federación en la posición i
                    Federacion federacion = (Federacion) federaciones.get(i);
                    // Si el código de la federación es igual al string
                    if (federacion.getCodigo().equals(string)) {
                        // Devolver la posición i
                        return i;
                    }
                }
            }
        }
        // Devolver -1
        return -1;
    }

    /**
     * Método para listar los objetos de alguno de los ArrayList.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @return Lista de objetos
     */
    public List<Object> listObjetos(int tipoObjeto) {
        // Crear una lista de objetos
        List<Object> result = new ArrayList<>();
        // Si el tipo de objeto es 1 (Excursión)
        if (tipoObjeto == 1) {
            // Si el ArrayList de excursiones está vacío
            if (excursiones.isEmpty()) {
                // Mostrar mensaje
                System.out.println("No hay excursiones.");
            }
            // Si el ArrayList de excursiones no está vacío
            else {
                // Recorrer el ArrayList de excursiones
                for (Object o : excursiones) {
                    // Obtener la excursión
                    Excursion excursion = (Excursion) o;
                    // Añadir la excursión a la lista de objetos
                    result.add(excursion);
                }
            }
        }
        // Si el tipo de objeto es 2 (Inscripción)
        else if (tipoObjeto == 2) {
            // Si el ArrayList de inscripciones está vacío
            if (inscripciones.isEmpty()) {
                // Mostrar mensaje
                System.out.println("No hay inscripciones.");
            }
            // Si el ArrayList de inscripciones no está vacío
            else {
                // Recorrer el ArrayList de inscripciones
                for (Object o : inscripciones) {
                    // Obtener la inscripción
                    Inscripcion inscripcion = (Inscripcion) o;
                    // Añadir la inscripción a la lista de objetos
                    result.add(inscripcion);
                }
            }
        }
        // Si el tipo de objeto es 3 (Socio)
        else if (tipoObjeto == 3) {
            // Si el ArrayList de socios está vacío
            if (socios.isEmpty()) {
                // Mostrar mensaje
                System.out.println("No hay socios.");
            }
            // Si el ArrayList de socios no está vacío
            else {
                // Recorrer el ArrayList de socios
                for (Object o : socios) {
                    // Obtener el socio
                    Socio socio = (Socio) o;
                    // Añadir el socio a la lista de objetos
                    result.add(socio);
                }
            }
        }
        else if (tipoObjeto == 4){
            // Si el ArrayList de federaciones está vacío
            if (federaciones.isEmpty()) {
                // Mostrar mensaje
                System.out.println("No hay federaciones.");
            }
            // Si el ArrayList de federaciones no está vacío
            else {
                // Recorrer el ArrayList de federaciones
                for (Object o : federaciones) {
                    // Obtener la federación
                    Federacion federacion = (Federacion) o;
                    // Añadir la federación a la lista de objetos
                    result.add(federacion);
                }
            }
        }
        // Devolver la lista de objetos
        return result;
    }

    /**
     * Método para listar los objetos de alguno de los ArrayList en formato String.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @return Lista de objetos
     */
    public String listToStringObjetos(int tipoObjeto) {
        // Crear una lista de objetos
        List<Object> list = new ArrayList<>();
        // Si el tipo de objeto es 1 (Excursión)
        if (tipoObjeto == 1) {
            // Si el ArrayList de excursiones está vacío
            if (excursiones.isEmpty()) {
                // Mostrar mensaje
                System.out.println("No hay excursiones.");
            }
            // Si el ArrayList de excursiones no está vacío
            else {
                // Recorrer el ArrayList de excursiones
                for (Object o : excursiones) {
                    // Obtener la excursión
                    Excursion excursion = (Excursion) o;
                    // Añadir la excursión a la lista de objetos
                    list.add(excursion);
                }
            }
        }
        // Si el tipo de objeto es 2 (Inscripción)
        else if (tipoObjeto == 2) {
            // Si el ArrayList de inscripciones está vacío
            if (inscripciones.isEmpty()) {
                // Mostrar mensaje
                System.out.println("No hay inscripciones.");
            }
            // Si el ArrayList de inscripciones no está vacío
            else {
                // Recorrer el ArrayList de inscripciones
                for (Object o : inscripciones) {
                    // Obtener la inscripción
                    Inscripcion inscripcion = (Inscripcion) o;
                    // Añadir la inscripción a la lista de objetos
                    list.add(inscripcion);
                }
            }
        }
        // Si el tipo de objeto es 3 (Socio)
        else if (tipoObjeto == 3) {
            // Si el ArrayList de socios está vacío
            if (socios.isEmpty()) {
                // Mostrar mensaje
                System.out.println("No hay socios.");
            }
            // Si el ArrayList de socios no está vacío
            else {
                // Recorrer el ArrayList de socios
                for (Object o : socios) {
                    // Obtener el socio
                    Socio socio = (Socio) o;
                    // Añadir el socio a la lista de objetos
                    list.add(socio);
                }
            }
        }
        else if (tipoObjeto == 4) {
            // Si el ArrayList de federaciones está vacío
            if (federaciones.isEmpty()) {
                // Mostrar mensaje
                System.out.println("No hay federaciones.");
            }
            // Si el ArrayList de federaciones no está vacío
            else {
                // Recorrer el ArrayList de federaciones
                for (Object o : federaciones) {
                    // Obtener la federación
                    Federacion federacion = (Federacion) o;
                    // Añadir la federación a la lista de objetos
                    list.add(federacion);
                }
            }
        }
        // Devolver la lista de objetos
        return list.toString();
    }

    /**
     * Método para listar los objetos de alguno de los ArrayList con un código del tipo de objeto.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param codigo     Código
     * @return Lista de objetos
     */
    public String listToStringObjetosCodigo(int tipoObjeto, String codigo) {
        // Crear una lista de objetos
        List<Object> list = new ArrayList<>();
        // Si el tipo de objeto es 1 (Excursión)
        if (tipoObjeto == 1) {
            // Si el ArrayList de excursiones está vacío
            if (excursiones.isEmpty()) {
                // Mostrar mensaje
                System.out.println("No hay excursiones.");
            }
            // Si el ArrayList de excursiones no está vacío
            else {
                // Recorrer el ArrayList de excursiones
                for (Object o : excursiones) {
                    // Si el código de con el código
                    Excursion excursion = (Excursion) o;
                    // Añadir la excursión a la lista de objetos
                    list.add(excursion);
                }
            }
        }
        // Si el tipo de objeto es 2 (Inscripción)
        else if (tipoObjeto == 2) {
            // Si el ArrayList de inscripciones está vacío
            if (inscripciones.isEmpty()) {
                // Mostrar mensaje
                System.out.println("No hay inscripciones.");
            }
            // Si el ArrayList de inscripciones no está vacío
            else {
                // Recorrer el ArrayList de inscripciones
                for (Object o : inscripciones) {
                    // Obtener la inscripción
                    Inscripcion inscripcion = (Inscripcion) o;
                    // Añadir la inscripción a la lista de objetos
                    list.add(inscripcion);
                }
            }
        }
        // Si el tipo de objeto es 3 (Socio)
        else if (tipoObjeto == 3) {
            // Si el ArrayList de socios está vacío
            if (socios.isEmpty()) {
                // Mostrar mensaje
                System.out.println("No hay socios.");
            }
            // Si el ArrayList de socios no está vacío
            else {
                // Recorrer el ArrayList de socios
                for (Object o : socios) {
                    // Obtener el socio
                    Socio socio = (Socio) o;
                    // Añadir el socio a la lista de objetos
                    list.add(socio);
                }
            }
        }
        else if (tipoObjeto == 4) {
            // Si el ArrayList de federaciones está vacío
            if (federaciones.isEmpty()) {
                // Mostrar mensaje
                System.out.println("No hay federaciones.");
            }
            // Si el ArrayList de federaciones no está vacío
            else {
                // Recorrer el ArrayList de federaciones
                for (Object o : federaciones) {
                    // Obtener la federación
                    Federacion federacion = (Federacion) o;
                    // Añadir la federación a la lista de objetos
                    list.add(federacion);
                }
            }
        }
        // Devolver la lista de objetos
        return list.toString();
    }

    /**
     * Método para listar los objetos de alguno de los ArrayList en un rango de fechas.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     * @param fechaInicial Fecha inicial
     * @param fechaFinal Fecha final
     * @return Lista de objetos
     */
    public String listToStringObjetosFechas(int tipoObjeto, LocalDate fechaInicial, LocalDate fechaFinal){
        // Crear una lista de objetos
        List<Object> list = new ArrayList<>();
        // Si el tipo de objeto es 1 (Excursión)
        if (tipoObjeto == 1) {
            // Si el ArrayList de excursiones no está vacío
            if (!excursiones.isEmpty()) {
                // Recorrer el ArrayList de excursiones
                for (Object o : excursiones) {
                    // Obtener la excursión
                    Excursion excursion = (Excursion) o;
                    // Si la fecha de la excursión está en el rango de fechas
                    if (excursion.getFecha().isAfter(fechaInicial) && excursion.getFecha().isBefore(fechaFinal)) {
                        // Añadir la excursión a la lista de objetos
                        list.add(excursion);
                    }
                }
            }
            // Si el ArrayList de excursiones está vacío
            else {
                // Mostrar mensaje
                System.out.println("No hay excursiones en la lista.");
            }
        }
        // Devolver la lista de objetos
        return list.toString();
    }
}
