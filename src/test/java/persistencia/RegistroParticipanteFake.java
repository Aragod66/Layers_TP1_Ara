package persistencia;

import modelo.Participante;
import modelo.RegistroParticipante;

import java.util.ArrayList;
import java.util.List;

public class RegistroParticipanteFake implements RegistroParticipante {

    private List<Participante> datos = new ArrayList<>();

    @Override
    public void persistir(Participante participante) {
        datos.add(participante);
    }
}