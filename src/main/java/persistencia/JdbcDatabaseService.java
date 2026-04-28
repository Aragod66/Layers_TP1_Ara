package persistencia;

import modelo.Participante;
import modelo.RegistroParticipante;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDatabaseService implements RegistroParticipante {
    private Connection dbConn;

    public JdbcDatabaseService(Connection dbConn) {
        this.dbConn = dbConn;
    }

    @Override
    public void persistir(Participante participante) throws SQLException {
        PreparedStatement st = dbConn.prepareStatement(
                "insert into participantes(nombre, telefono, region) values(?,?,?)"
        );
        try {
            st.setString(1, participante.getNombre());
            st.setString(2, participante.getTelefono());
            st.setString(3, participante.getRegion());
            st.executeUpdate();
        } finally {
            st.close();
        }
    }

}

