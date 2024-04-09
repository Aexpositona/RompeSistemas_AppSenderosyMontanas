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
    private final List<Object> excursiones, inscripciones, socios, federaciones;

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

    public Datos(Datos datos) {
        this.excursiones = datos.excursiones;
        this.inscripciones = datos.inscripciones;
        this.socios = datos.socios;
        this.federaciones = datos.federaciones;
        this.objeto = datos.objeto;
        this.seguro = datos.seguro;
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
     *                  [1 - Excursión]
     *                  [2 - Inscripción]
     *                  [3 - Socio]
     *                  [4 - Federación]
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
    public void modifyObjeto(int tipoObjeto, Object objeto) {
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
                    if (excursion.getCodigo().equalsIgnoreCase(string)) {
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
                    if (inscripcion.getNumero().equalsIgnoreCase(string)) {
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
                    if (socio.getNumero().equalsIgnoreCase(string)) {
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
                    if (federacion.getCodigo().equalsIgnoreCase(string)) {
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
                    if (socio instanceof Estandar){
                        Estandar estandar = (Estandar) socio;
                        list.add(estandar);
                    }

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
        // Recoger la lista de objetos en formato String
        StringBuilder result = new StringBuilder();
        for (Object o : list) {
            // Añadir título numerado a la lista según el tipo de objeto
            // 1 - Excursión
            if (tipoObjeto == 1)
                result.append("-- Excursión ").append(list.indexOf(o) + 1).append(" --\n");
            // 2 - Inscripción
            else if (tipoObjeto == 2)
                result.append("-- Inscripción ").append(list.indexOf(o) + 1).append(" --\n");
            // 3 - Socio
            else if (tipoObjeto == 3)
                result.append("-- Socio ").append(list.indexOf(o) + 1).append(" --\n");
            // 4 - Federación
            else if (tipoObjeto == 4)
                result.append("-- Federación ").append(list.indexOf(o) + 1).append(" --\n");
            // Añadir objeto a la lista
            result.append(o.toString()).append("\n");
        }
        // Devolver la lista de objetos en formato String
        return result.toString();
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
                    // Obtener la excursión
                    Excursion excursion = (Excursion) o;
                    // Si el código de la excursión es igual al código
                    if (excursion.getCodigo().equalsIgnoreCase(codigo)) {
                        // Añadir la excursión a la lista de objetos
                        list.add(excursion);
                    }
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
                    // Si el número de la inscripción es igual al código
                    if (inscripcion.getNumero().equalsIgnoreCase(codigo)) {
                        // Añadir la inscripción a la lista de objetos
                        list.add(inscripcion);
                    }
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
                    // Si el número del socio es igual al código
                    if (socio.getNumero().equalsIgnoreCase(codigo)) {
                        // Añadir el socio a la lista de objetos
                        list.add(socio);
                    }
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
                    // Si el código de la federación es igual al código
                    if (federacion.getCodigo().equalsIgnoreCase(codigo)) {
                        // Añadir la federación a la lista de objetos
                        list.add(federacion);
                    }
                }
            }
        }
        // Recoger la lista de objetos en formato String
        StringBuilder result = new StringBuilder();
        for (Object o : list) {
            result.append(o.toString()).append("\n");
        }
        return result.toString();
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
        // Si el tipo de objeto es 2 (Inscripción)
        else if (tipoObjeto == 2) {
            // Si el ArrayList de inscripciones no está vacío
            if (!inscripciones.isEmpty()) {
                // Recorrer el ArrayList de inscripciones
                for (Object o : inscripciones) {
                    // Obtener la inscripción
                    Inscripcion inscripcion = (Inscripcion) o;
                    Excursion excursion = inscripcion.getExcursion();
                    // Si la fecha de la inscripción está en el rango de fechas
                    if (excursion.getFecha().isAfter(fechaInicial) && excursion.getFecha().isBefore(fechaFinal)) {
                        // Añadir la inscripción a la lista de objetos
                        list.add(inscripcion);
                    }
                }
            }
            // Si el ArrayList de inscripciones está vacío
            else {
                // Mostrar mensaje
                System.out.println("No hay inscripciones en la lista.");
            }
        }
        // Recoger la lista de objetos en formato String
        StringBuilder result = new StringBuilder();
        for (Object o : list) {
            // Añadir título numerado a la lista según el tipo de objeto
            // 1 - Excursión
            if (tipoObjeto == 1)
                result.append("-- Excursión ").append(list.indexOf(o) + 1).append(" --\n");
            // 2 - Inscripción
            else if (tipoObjeto == 2)
                result.append("-- Inscripción ").append(list.indexOf(o) + 1).append(" --\n");
            // Añadir objeto a la lista
            result.append(o.toString()).append("\n");
        }
        // Devolver la lista de objetos en formato String
        return result.toString();
    }

    /**
     * Método para obtener el siguiente código de un tipo de objeto.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @return String - Último código
     */
    public String getSiguienteCodigo(int tipoObjeto) {
        // Variables internas
        String codigo = "";
        // Si el tipo de objeto es 1 (Excursión)
        if (tipoObjeto == 1) {
            // Si el ArrayList de excursiones no está vacío
            if (!excursiones.isEmpty()) {
                // Obtener la última excursión
                Excursion excursion = (Excursion) excursiones.get(excursiones.size() - 1);
                // Obtener el código de la última excursión
                codigo = excursion.getCodigo();
            }
            // Si el ArrayList de excursiones está vacío
            else {
                // Asignar el código "EXC0001"
                codigo = "EXC0001";
            }
        }
        // Si el tipo de objeto es 2 (Inscripción)
        else if (tipoObjeto == 2) {
            // Si el ArrayList de inscripciones no está vacío
            if (!inscripciones.isEmpty()) {
                // Obtener la última inscripción
                Inscripcion inscripcion = (Inscripcion) inscripciones.get(inscripciones.size() - 1);
                // Obtener el número de la última inscripción
                codigo = inscripcion.getNumero();
            }
            // Si el ArrayList de inscripciones está vacío
            else {
                // Asignar el número "INS0001"
                codigo = "INS0001";
            }
        }
        // Si el tipo de objeto es 3 (Socio)
        else if (tipoObjeto == 3) { // Si el tipo de objeto es Socio
            if (!socios.isEmpty()) { // Si el ArrayList de socios no está vacío
                // Obtener el último socio
                Socio ultimoSocio = (Socio) socios.get(socios.size() - 1);
                // Obtener el número del último socio
                int ultimoNumero = Integer.parseInt(ultimoSocio.getNumero().substring(3));
                // Calcular el siguiente número
                int siguienteNumero = ultimoNumero + 1;
                // Formatear el siguiente número como una cadena de cuatro dígitos
                String siguienteNumeroStr = String.format("%04d", siguienteNumero);
                // Construir el código del siguiente socio
                codigo = "SOC" + siguienteNumeroStr;
            } else { // Si el ArrayList de socios está vacío
                // Asignar el número "SOC0001"
                codigo = "SOC0001";
            }

        } else if (tipoObjeto == 4) {
            // Si el ArrayList de federaciones no está vacío
            if (!federaciones.isEmpty()) {
                // Obtener la última federación
                Federacion federacion = (Federacion) federaciones.get(federaciones.size() - 1);
                // Obtener el código de la última federación
                codigo = federacion.getCodigo();
            } else {
                // Asignar el código "FED0001"
                codigo = "FED0001";
            }
        }
        // Devolver el código añadiendo 1
        if ((Integer.parseInt(codigo.substring(3)) + 1 < 10)){
            return codigo.substring(0, 3) + "000" + String.valueOf(Integer.parseInt(codigo.substring(3)) + 1);
        }
        // Si el código es menor que 100
        else if ((Integer.parseInt(codigo.substring(3)) + 1 < 100)){
            return codigo.substring(0, 3) + "00" + String.valueOf(Integer.parseInt(codigo.substring(3)) + 1);
        }
        else if ((Integer.parseInt(codigo.substring(3)) + 1 < 1000)){
            return codigo.substring(0, 3) + "0" + String.valueOf(Integer.parseInt(codigo.substring(3)) + 1);
        }
        else{
            return codigo.substring(0, 3) + String.valueOf(Integer.parseInt(codigo.substring(3)) + 1);
        }
    }

    public String getUltimoCodigo(int tipoObjeto) {
        // Variables internas
        String codigo = "";
        // Si el tipo de objeto es 1 (Excursión)
        if (tipoObjeto == 1) {
            // Si el ArrayList de excursiones no está vacío
            if (!excursiones.isEmpty()) {
                // Obtener la última excursión
                Excursion excursion = (Excursion) excursiones.get(excursiones.size() - 1);
                // Obtener el código de la última excursión
                codigo = excursion.getCodigo();
            }
            // Si el ArrayList de excursiones está vacío
            else {
                // Asignar el código "EXC0001"
                codigo = "No hay excursiones.";
            }
        }
        // Si el tipo de objeto es 2 (Inscripción)
        else if (tipoObjeto == 2) {
            // Si el ArrayList de inscripciones no está vacío
            if (!inscripciones.isEmpty()) {
                // Obtener la última inscripción
                Inscripcion inscripcion = (Inscripcion) inscripciones.get(inscripciones.size() - 1);
                // Obtener el número de la última inscripción
                codigo = inscripcion.getNumero();
            }
            // Si el ArrayList de inscripciones está vacío
            else {
                // Asignar el número "INS0001"
                codigo = "No hay inscripciones.";
            }
        }
        // Si el tipo de objeto es 3 (Socio)
        else if (tipoObjeto == 3) {
            // Si el ArrayList de socios no está vacío
            if (!socios.isEmpty()) {
                // Obtener el último socio
                Socio socio = (Socio) socios.get(socios.size() - 1);
                // Obtener el código del último socio
                codigo = String.valueOf(socio.getNumero());
            }
            // Si el ArrayList de socios está vacío
            else {
                // Asignar el código "SOC0001"
                codigo = "No hay socios.";
            }
        }
        else if (tipoObjeto == 4) {
            // Si el ArrayList de federaciones no está vacío
            if (!federaciones.isEmpty()) {
                // Obtener la última federación
                Federacion federacion = (Federacion) federaciones.get(federaciones.size() - 1);
                // Obtener el código de la última federación
                codigo = federacion.getCodigo();
            }
            else {
                // Asignar el código "FED0001"
                codigo = "No hay federaciones.";
            }
        }
        // Devolver el código añadiendo 1
        return codigo;
    }

    /**
     * Método para obtener un objeto de alguno de los ArrayList.
     *
     * @param tipoObjeto Tipo de objeto
     *                  1 - Excursión
     *                  2 - Inscripción
     *                  3 - Socio
     *                  4 - Federación
     * @param parametro     Parámetro
     *                  [1 - Excursión
     *                      1 - Código
     *                      2 - Descrición
     *                      3 - Código - Descripción
     *                      4 - Fecha
     *                      5 - Código - Fecha
     *                      6 - Descripción - Fecha
     *                      7 - Código - Descripción - Fecha
     *                      8 - Duración
     *                      9 - Código - Duración
     *                      10 - Descripción - Duración
     *                      11 - Código - Descripción - Duración
     *                      12 - Fecha - Duración
     *                      13 - Código - Fecha - Duración
     *                      14 - Descripción - Fecha - Duración
     *                      15 - Código - Descripción - Fecha - Duración
     *                      16 - Precio
     *                      17 - Código - Precio
     *                      18 - Descripción - Precio
     *                      19 - Código - Descripción - Precio
     *                      20 - Fecha - Precio
     *                      21 - Código - Fecha - Precio
     *                      22 - Descripción - Fecha - Precio
     *                      23 - Código - Descripción - Fecha - Precio
     *                      24 - Duración - Precio
     *                      25 - Código - Duración - Precio
     *                      26 - Descripción - Duración - Precio
     *                      27 - Código - Descripción - Duración - Precio
     *                      28 - Fecha - Duración - Precio
     *                      29 - Código - Fecha - Duración - Precio
     *                      30 - Descripción - Fecha - Duración - Precio
     *                      31 - Código - Descripción - Fecha - Duración - Precio]
     *                  [2 - Inscripción
     *                      1 - Número
     *                      2 - Socio
     *                      3 - Número - Socio
     *                      4 - Excursión
     *                      5 - Número - Excursión
     *                      6 - Socio - Excursión
     *                      7 - Número - Socio - Excursión]
     *                  [3 - Socio
     *                      1 - Número
     *                      2 - Nombre
     *                      3 - Número - Nombre
     *                      4 - DNI
     *                      5 - Número - DNI
     *                      6 - Nombre - DNI
     *                      7 - Número - Nombre - DNI]
     *                  [4 - Federación
     *                      1 - Código
     *                      2 - Nombre
     *                      4 - Código - Nombre]
     * @return Listado de parámetros de los objetos
     */
    // Método para listar alguno de los parámetros de los objetos
    public String listParametroObjeto (int tipoObjeto, int parametro) {
        List<String> list = new ArrayList<>();
        // Si el tipo de objeto es 1 (Excursión)
        if (tipoObjeto == 1) {
            // Si el ArrayList de excursiones no está vacío
            if (!excursiones.isEmpty()) {
                // Recorrer el ArrayList de excursiones
                for (Object o : excursiones) {
                    // Obtener la excursión
                    Excursion excursion = (Excursion) o;
                    // Mostrar el parámetro de la excursión
                    switch (parametro) {
                        // Código
                        case 1 -> list.add(excursion.getCodigo());
                        // Descripción
                        case 2 -> list.add(excursion.getDescripcion());
                        // Código - Descripción
                        case 3 -> list.add(excursion.getCodigo() + " - " + excursion.getDescripcion());
                        // Fecha
                        case 4 -> list.add(String.valueOf(excursion.getFecha()));
                        // Código - Fecha
                        case 5 -> list.add(excursion.getCodigo() + " - " + String.valueOf(excursion.getFecha()));
                        // Descripción - Fecha
                        case 6 -> list.add(excursion.getDescripcion() + " - " + String.valueOf(excursion.getFecha()));
                        // Código - Descripción - Fecha
                        case 7 -> list.add(excursion.getCodigo() + " - " + excursion.getDescripcion() + " - " + String.valueOf(excursion.getFecha()));
                        // Duración
                        case 8 -> list.add(String.valueOf(excursion.getDuracion()));
                        // Código - Duración
                        case 9 -> list.add(excursion.getCodigo() + " - " + String.valueOf(excursion.getDuracion()));
                        // Descripción - Duración
                        case 10 -> list.add(excursion.getDescripcion() + " - " + String.valueOf(excursion.getDuracion()));
                        // Código - Descripción - Duración
                        case 11 -> list.add(excursion.getCodigo() + " - " + excursion.getDescripcion() + " - " + String.valueOf(excursion.getDuracion()));
                        // Fecha - Duración
                        case 12 -> list.add(String.valueOf(excursion.getFecha()) + " - " + String.valueOf(excursion.getDuracion()));
                        // Código - Fecha - Duración
                        case 13 -> list.add(excursion.getCodigo() + " - " + String.valueOf(excursion.getFecha()) + " - " + String.valueOf(excursion.getDuracion()));
                        // Descripción - Fecha - Duración
                        case 14 -> list.add(excursion.getDescripcion() + " - " + String.valueOf(excursion.getFecha()) + " - " + String.valueOf(excursion.getDuracion()));
                        // Código - Descripción - Fecha - Duración
                        case 15 -> list.add(excursion.getCodigo() + " - " + excursion.getDescripcion() + " - " + String.valueOf(excursion.getFecha()) + " - " + String.valueOf(excursion.getDuracion()));
                        // Precio
                        case 16 -> list.add(String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Código - Precio
                        case 17 -> list.add(excursion.getCodigo() + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Descripción - Precio
                        case 18 -> list.add(excursion.getDescripcion() + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Código - Descripción - Precio
                        case 19 -> list.add(excursion.getCodigo() + " - " + excursion.getDescripcion() + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Fecha - Precio
                        case 20 -> list.add(String.valueOf(excursion.getFecha()) + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Código - Fecha - Precio
                        case 21 -> list.add(excursion.getCodigo() + " - " + String.valueOf(excursion.getFecha()) + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Descripción - Fecha - Precio
                        case 22 -> list.add(excursion.getDescripcion() + " - " + String.valueOf(excursion.getFecha()) + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Código - Descripción - Fecha - Precio
                        case 23 -> list.add(excursion.getCodigo() + " - " + excursion.getDescripcion() + " - " + String.valueOf(excursion.getFecha()) + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Duración - Precio
                        case 24 -> list.add(String.valueOf(excursion.getDuracion()) + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Código - Duración - Precio
                        case 25 -> list.add(excursion.getCodigo() + " - " + String.valueOf(excursion.getDuracion()) + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Descripción - Duración - Precio
                        case 26 -> list.add(excursion.getDescripcion() + " - " + String.valueOf(excursion.getDuracion()) + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Código - Descripción - Duración - Precio
                        case 27 -> list.add(excursion.getCodigo() + " - " + excursion.getDescripcion() + " - " + String.valueOf(excursion.getDuracion()) + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Fecha - Duración - Precio
                        case 28 -> list.add(String.valueOf(excursion.getFecha()) + " - " + String.valueOf(excursion.getDuracion()) + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Código - Fecha - Duración - Precio
                        case 29 -> list.add(excursion.getCodigo() + " - " + String.valueOf(excursion.getFecha()) + " - " + String.valueOf(excursion.getDuracion()) + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Descripción - Fecha - Duración - Precio
                        case 30 -> list.add(excursion.getDescripcion() + " - " + String.valueOf(excursion.getFecha()) + " - " + String.valueOf(excursion.getDuracion()) + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                        // Código - Descripción - Fecha - Duración - Precio
                        case 31 -> list.add(excursion.getCodigo() + " - " + excursion.getDescripcion() + " - " + String.valueOf(excursion.getFecha()) + " - " + String.valueOf(excursion.getDuracion()) + " - " + String.valueOf(excursion.getPrecio()) +" Euros.");
                    }
                }
            }
            // Si el ArrayList de excursiones está vacío
            else {
                // Mostrar mensaje
                System.out.println("No hay excursiones.");
            }
        }
        // Si el tipo de objeto es 2 (Inscripción)
        else if (tipoObjeto == 2) {
            // Si el ArrayList de inscripciones no está vacío
            if (!inscripciones.isEmpty()) {
                // Recorrer el ArrayList de inscripciones
                for (Object o : inscripciones) {
                    // Obtener la inscripción
                    Inscripcion inscripcion = (Inscripcion) o;
                    // Mostrar el parámetro de la inscripción
                    switch (parametro) {
                        // Número
                        case 1 -> list.add(inscripcion.getNumero());
                        // Socio
                        case 2 -> list.add(String.valueOf(inscripcion.getSocio()));
                        // Excursión
                        case 4 -> list.add(String.valueOf(inscripcion.getExcursion()));
                        // Número - Socio
                        case 3 -> list.add(inscripcion.getNumero() + " - " + String.valueOf(inscripcion.getSocio()));
                        // Número - Excursión
                        case 5 -> list.add(inscripcion.getNumero() + " - " + String.valueOf(inscripcion.getExcursion()));
                        // Socio - Excursión
                        case 6 -> list.add(String.valueOf(inscripcion.getSocio()) + " - " + String.valueOf(inscripcion.getExcursion()));
                        // Número - Socio - Excursión
                        case 7 -> list.add(inscripcion.getNumero() + " - " + String.valueOf(inscripcion.getSocio()) + " - " + String.valueOf(inscripcion.getExcursion()));
                    }
                }
            }
            // Si el ArrayList de inscripciones está vacío
            else {
                // Mostrar mensaje
                System.out.println("No hay inscripciones.");
            }
        }
        // Si el tipo de objeto es 3 (Socio)
        else if (tipoObjeto == 3) {
            // Si el ArrayList de socios no está vacío
            if (!socios.isEmpty()) {
                // Recorrer el ArrayList de socios
                for (Object o : socios) {
                    // Obtener el socio
                    Socio socio = (Socio) o;
                    // Mostrar el parámetro del socio
                    switch (parametro) {
                        // Número
                        case 1 -> list.add(socio.getNumero());
                        // Nombre
                        case 2 -> list.add(socio.getNombre());
                        // NIF
                        case 4 -> list.add(socio.getNif());
                        // Número - Nombre
                        case 3 -> list.add(socio.getNumero() + " - " + socio.getNombre());
                        // Número - NIF
                        case 5 -> list.add(socio.getNumero() + " - " + socio.getNif());
                        // Nombre - NIF
                        case 6 -> list.add(socio.getNombre() + " - " + socio.getNif());
                        // Número - Nombre - NIF
                        case 7 -> list.add(socio.getNumero() + " - " + socio.getNombre() + " - " + socio.getNif());                        
                    }
                }
            }
            // Si el ArrayList de socios está vacío
            else {
                // Mostrar mensaje
                System.out.println("No hay socios.");
            }
        }
        else if (tipoObjeto == 4) {
            // Si el ArrayList de federaciones no está vacío
            if (!federaciones.isEmpty()) {
                // Recorrer el ArrayList de federaciones
                for (Object o : federaciones) {
                    // Obtener la federación
                    Federacion federacion = (Federacion) o;
                    // Mostrar el parámetro de la federación
                    switch (parametro) {
                        // Código
                        case 1 -> list.add(federacion.getCodigo());
                        // Nombre
                        case 2 -> list.add(federacion.getNombre());
                        // Código - Nombre
                        case 3 -> list.add(federacion.getCodigo() + " - " + federacion.getNombre());
                    }
                }
            }
            // Si el ArrayList de federaciones está vacío
            else {
                // Mostrar mensaje
                System.out.println("No hay federaciones.");
            }
        }
        // Convertir la lista de parámetros a String a formato deseado
        StringBuilder listaFormateada = new StringBuilder();
        for (String s : list) {
            listaFormateada.append(s).append("\n");
        }
        // Devolver la lista de parámetros
        return listaFormateada.toString();
    }    
}

