package modelo;

public class Participante {

    private final String nombre;
    private final String telefono;
    private final String region;
    private final String email;

    public Participante(
            String nombre,
            String telefono,
            String region,
            String email) {

        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRegion() {
        return region;
    }

    public String getEmail() {
        return email;
    }
}