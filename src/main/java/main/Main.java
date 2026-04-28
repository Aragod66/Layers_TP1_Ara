package main;

import modelo.GestionParticipantes;
import modelo.RegistroParticipante;
import persistencia.RegistroParticipanteFake;
import vista.*;

import java.awt.EventQueue;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistroParticipante registro = new RegistroParticipanteFake();
                    new AgregarParticipante(new GestionParticipantes(registro));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}