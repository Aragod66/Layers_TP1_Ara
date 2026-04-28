package modelo;

public class GestionParticipantes {

    RegistroParticipante registroParticipante;

    public GestionParticipantes(RegistroParticipante registroParticipante){
        this.registroParticipante = registroParticipante;
    }

    public boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public boolean validarRegion(String region) {
        return region.equals("China") || region.equals("US") || region.equals("Europa");
    }

    public void guardar(String nombre, String telefono,String region) throws Exception {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un nombre");
        }
        if (telefono.isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un telefono");
        }
        if (!validarTelefono(telefono)) {
            throw new IllegalArgumentException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (!validarRegion(region)) {
            throw new IllegalArgumentException("Region desconocida. Las conocidas son: China, US, Europa");
        }

        registroParticipante.persistir(new Participante(nombre, telefono, region));

    }
}
