package personal;

public class Mecanico {
    String nombre;
    String telefono;
    enum Especialidad {FRENOS, HIDRAULICA, ELECTRICIDAD, MOTOR}
    
    public Mecanico(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    };

    
}
