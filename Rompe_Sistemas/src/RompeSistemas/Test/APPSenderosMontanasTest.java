package RompeSistemas.Test;

import RompeSistemas.Controlador.APPSenderosMontanas;
import RompeSistemas.Modelo.Datos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class APPSenderosMontanasTest {

    private APPSenderosMontanas app;
    private Datos datos;

    @BeforeEach
    public void setup() {
        app = new APPSenderosMontanas();
        datos = new Datos();
    }

    @Test
    public void testIniciar() {
        app.iniciar(datos);

        // Check if the controllers and views are initialized
        assertNotNull(app.getControlMenuPrincipal());
        assertNotNull(app.getControlInscripciones());
        assertNotNull(app.getControlSocios());
        assertNotNull(app.getControlExcursiones());
        assertNotNull(app.getControlDatos());
        assertNotNull(app.getControlPeticiones());
        assertNotNull(app.getDatos());
        assertNotNull(app.getVistaMenuPrincipal());

        // Check if the correct data object is used
        assertEquals(datos, app.getDatos());
    }
}