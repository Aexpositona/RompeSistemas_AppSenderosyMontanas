package RompeSistemas.Test;

import RompeSistemas.Controlador.APPSenderosMontanas;
import RompeSistemas.Modelo.Datos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

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
    public void testIniciar() throws SQLException {
        app.iniciar(datos);

        // Comprobar que controladores y vistas están inicializados
        assertNotNull(app.getControlMenuPrincipal());
        assertNotNull(app.getControlInscripciones());
        assertNotNull(app.getControlSocios());
        assertNotNull(app.getControlExcursiones());
        assertNotNull(app.getControlDatos());
        assertNotNull(app.getControlPeticiones());
        assertNotNull(app.getDatos());
        assertNotNull(app.getVistaMenuPrincipal());

        // Comprobar que se está usando el objeto de datos pasado como parámetro
        assertEquals(datos, app.getDatos());
    }
}