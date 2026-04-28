package modelo;

public class Participante {
    private final String nombre;
    private final String telefono;
    private final String region;


    public Participante(String nombre, String telefono, String region){
        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRegion() {
        return region;
    }

    public String getTelefono(){
        return telefono;
    }


}
