package modelo;

import modelo.GestionParticipantes;
import modelo.RegistroParticipante;
import modelo.Participante;
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
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            sistema.guardar("", "1234-123456", "China");
        });

        assertEquals("Debe cargar un nombre", ex.getMessage());
    }

    @Test
    void noDeberiaAceptarTelefonoInvalido() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            sistema.guardar("Juan", "123", "China");
        });

        assertTrue(ex.getMessage().contains("teléfono"));
    }

    @Test
    void noDeberiaAceptarRegionInvalida() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            sistema.guardar("Juan", "1234-123456", "Argentina");
        });

        assertTrue(ex.getMessage().contains("Region"));
    }
}