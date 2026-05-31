package modelo;

public class EmailObserver implements Observer {

    @Override
    public void update(Participante participante) {

        System.out.println(
                "Enviando email a "
                        + participante.getEmail());
    }
}