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

    // Un ArrayList para cada tipo de dato
    private final ArrayList<Object> excursiones;
    private final ArrayList<Object> inscripciones;
    private final ArrayList<Object> socios;


    // Constructor

    /**
     * Constructor de la clase Datos.
     */
    public Datos() {
        excursiones = new ArrayList<>();
        inscripciones = new ArrayList<>();
        socios = new ArrayList<>();
        objeto = null;
    }

    /**
     * Método para obtener un ArrayList de un tipo de objeto.
     *
     * @param tipoObjeto Tipo de objeto
     * @return ArrayList de objetos
     */
    public ArrayList<Object> getArrayList(int tipoObjeto) {
        {
            return switch (tipoObjeto) {
                case 1 -> excursiones;
                case 2 -> inscripciones;
                case 3 -> socios;
                default -> null;
            };
        }
    }

    /**
     * Método para agregar un objeto a alguno de los ArrayList.
     *
     * @param objeto     Objeto a agregar
     * @param tipoObjeto Tipo de objeto
     *                   1 - Excursión
     *                   2 - Inscripción
     *
     */
    public void addObjeto(Object objeto, int tipoObjeto) {
        switch (tipoObjeto) {
            case 1 -> excursiones.add(objeto);
            case 2 -> inscripciones.add(objeto);
            case 3 -> socios.add(objeto);
        }
    }

    /**
     * Método para eliminar un objeto de alguno de los ArrayList.
     *
     * @param objeto     Objeto a eliminar
     * @param tipoObjeto Tipo de objeto
     */
    public void removeObjeto(Object objeto, int tipoObjeto) {
        switch (tipoObjeto) {
            case 1 -> excursiones.remove(objeto);
            case 2 -> inscripciones.remove(objeto);
            case 3 -> socios.remove(objeto);
        }
    }

    /**
     * Método para modificar un objeto de alguno de los ArrayList.
     *
     * @param objeto     Objeto a modificar
     * @param tipoObjeto Tipo de objeto
     */
    public void modificarObjeto(Object objeto, int tipoObjeto) {
        switch (tipoObjeto) {
            case 1 -> excursiones.set(excursiones.indexOf(objeto), objeto);
            case 2 -> inscripciones.set(inscripciones.indexOf(objeto), objeto);
            case 3 -> socios.set(socios.indexOf(objeto), objeto);
        }
    }

    /**
     * Método para obtener un objeto de alguno de los ArrayList.
     *
     * @param tipoObjeto Tipo de objeto
     * @param index      Índice del objeto
     * @return Objeto
     */
    public Object getObjeto(int tipoObjeto, int index) {
        switch (tipoObjeto) {
            case 1 -> objeto = excursiones.get(index);
            case 2 -> objeto = inscripciones.get(index);
            case 3 -> objeto = socios.get(index);
        }
        return objeto;
    }

    /**
     * Método para buscar un objeto en alguno de los ArrayList.
     *
     * @param string     String a buscar
     * @param tipoObjeto Tipo de objeto
     * @return Índice del objeto
     */
    public int buscarObjeto(String string, int tipoObjeto) {
        if (tipoObjeto == 1) {
            if (excursiones.isEmpty()) {
                return -1;
            } else {
                for (int i = 0; i < excursiones.size(); i++) {
                    Excursion excursion = (Excursion) excursiones.get(i);
                    if (excursion.getCodigo().equals(string)) {
                        return i;
                    }
                }
            }
        } else if (tipoObjeto == 2) {
            if (inscripciones.isEmpty()) {
                return -1;
            } else {
                for (int i = 0; i < inscripciones.size(); i++) {
                    Inscripcion inscripcion = (Inscripcion) inscripciones.get(i);
                    if (inscripcion.getNumero() == Integer.parseInt(string)) {
                        return i;
                    }
                }
            }
        } else if (tipoObjeto == 3) {
            if (socios.isEmpty()) {
                return -1;
            } else {
                for (int i = 0; i < socios.size(); i++) {
                    Socio socio = (Socio) socios.get(i);
                    if (socio.getNombre().equals(string)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Método para listar los objetos de alguno de los ArrayList.
     *
     * @param tipoObjeto Tipo de objeto
     * @return
     */
    public List<Object> listObjetos(int tipoObjeto) {
        List<Object> result = new ArrayList<>();
        if (tipoObjeto == 1) {
            if (!excursiones.isEmpty()) {
                for (Object o : excursiones) {
                    Excursion excursion = (Excursion) o;
                    result.add(excursion);
                }
            }
        } else if (tipoObjeto == 2) {
            if (!inscripciones.isEmpty()) {
                for (Object o : inscripciones) {
                    Inscripcion inscripcion = (Inscripcion) o;
                    result.add(inscripcion);
                }
            }
        } else if (tipoObjeto == 3) {
            if (!socios.isEmpty()) {
                for (Object o : socios) {
                    if (o instanceof Socio) {
                        Socio socio = (Socio) o;
                        result.add(socio);
                    }
                }
            }
        }
        return result;
    }

    public List<Object> listObjetosFecha(int tipoObjeto, LocalDate fechaInicial, LocalDate fechaFinal){
        List<Object> result = new ArrayList<>();
        if (tipoObjeto == 1) {
            if (!excursiones.isEmpty()) {
                for (Object o : excursiones) {
                    Excursion excursion = (Excursion) o;
                    if (excursion.getFecha().isAfter(fechaInicial) && excursion.getFecha().isBefore(fechaFinal)) {
                        result.add(excursion);
                    }
                }
            }
            else {
                System.out.println("No hay excursiones en la lista.");
            }
        }
        return result;

    }
}
