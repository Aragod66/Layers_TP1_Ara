package main;

import modelo.EmailObserver;
import modelo.GestionParticipantes;
import modelo.RegistroParticipante;
import persistencia.RegistroParticipanteFake;
import vista.AgregarParticipante;

import java.awt.EventQueue;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args)
            throws SQLException {

        EventQueue.invokeLater(() -> {

            try {

                RegistroParticipante registro =
                        new RegistroParticipanteFake();

                GestionParticipantes sistema =
                        new GestionParticipantes(registro);

                sistema.addObserver(
                        new EmailObserver());

                new AgregarParticipante(sistema);

            } catch (Exception e) {

                System.out.println(e);

            }
        });
    }
}