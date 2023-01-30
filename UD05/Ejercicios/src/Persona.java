public class Persona {
    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected String correoE;
    
    
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona() {
    }


    public Persona(String nombre, String apellidos, String telefono, String correoE) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correoE = correoE;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreoE() {
        return correoE;
    }
    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

}
