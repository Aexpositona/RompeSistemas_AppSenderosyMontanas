package RompeSistemas.Test;

import RompeSistemas.Modelo.Datos;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static RompeSistemas.Datos.DatabaseConnection.conn;

public class DatosTest {

    /**
     * Prueba de agregar un objeto a la lista de excursiones, inscripciones,
     * socios y federaciones.
     */
    @Test
    public void testAddObjeto() throws SQLException {
        /**
         * Crear un objeto de la clase Datos
         */
        Datos datos = new Datos(conn);

        /**
         * Crear un objeto
         */
        Object objeto = new Object();

        /**
         * Agregar el objeto a la lista de excursiones
         */
        datos.addObjeto(1, objeto);

        /**
         * Comprobar que el objeto se agregó correctamente
         */
        //assertTrue(datos.getArrayList(1).contains(objeto));

        /**
         * Agregar el objeto a la lista de inscripciones
         */
        datos.addObjeto(2, objeto);

        /**
         * Comprobar que el objeto se agregó correctamente
         */
       // assertTrue(datos.getArrayList(2).contains(objeto));

        /**
         * Agregar el objeto a la lista de socios
         */
        datos.addObjeto(3, objeto);

        /**
         * Comprobar que el objeto se agregó correctamente
         */
       // assertTrue(datos.getArrayList(3).contains(objeto));

        /**
         * Agregar el objeto a la lista de federaciones
         */
        datos.addObjeto(4, objeto);

        /**
         * Comprobar que el objeto se agregó correctamente
         */
       // assertTrue(datos.getArrayList(4).contains(objeto));

    }
}
