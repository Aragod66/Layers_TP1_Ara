package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistencia.RegistroParticipanteFake;

import static org.junit.jupiter.api.Assertions.*;

class GestionParticipantesTest {

    private GestionParticipantes sistema;
    private RegistroParticipanteFake fakeRepo;

    @BeforeEach
    void setUp() {
        fakeRepo = new RegistroParticipanteFake();
        sistema = new GestionParticipantes(fakeRepo);
    }

    @Test
    void noDeberiaAceptarNombreVacio() {

        Exception ex =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> sistema.guardar(
                                "",
                                "1234-123456",
                                "China",
                                "juan@gmail.com"));

        assertEquals(
                "Debe cargar un nombre",
                ex.getMessage());
    }

    @Test
    void noDeberiaAceptarTelefonoInvalido() {

        Exception ex =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> sistema.guardar(
                                "Juan",
                                "123",
                                "China",
                                "juan@gmail.com"));

        assertTrue(
                ex.getMessage()
                        .contains("teléfono"));
    }

    @Test
    void noDeberiaAceptarRegionInvalida() {

        Exception ex =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> sistema.guardar(
                                "Juan",
                                "1234-123456",
                                "Argentina",
                                "juan@gmail.com"));

        assertTrue(
                ex.getMessage()
                        .contains("Region"));
    }
}