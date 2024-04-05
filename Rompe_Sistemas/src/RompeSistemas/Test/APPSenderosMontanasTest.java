package RompeSistemas.Test;

import RompeSistemas.Controlador.APPSenderosMontanas;
import RompeSistemas.Modelo.Datos;
import RompeSistemas.Modelo.DataLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class APPSenderosMontanasTest {

    /**
     * Prueba de ejecutar el método main de la aplicación.
     */
    @Test
    public void testMain() {

        /**
         * Crear instancia de DataLoader
         */
        DataLoader dataLoader = new DataLoader(new Datos());

        /**
         * Crear instancia de Datos
         */
        Datos datos = new Datos();

        /**
         * Crear instancia de APPSenderosMontanas
         */
        APPSenderosMontanas app = new APPSenderosMontanas();

        /**
         * Establecer los datos en la aplicación
         */
        app.setDatos(datos);

        /**
         * Cargar los datos
         */
        dataLoader.load(datos);

        /**
         * Ejecutar el método main y verificar que no se lanzan excepciones
         */
        assertDoesNotThrow(() -> app.main(new String[]{}));
    }
}