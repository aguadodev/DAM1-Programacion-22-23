public class Empleado extends Persona{

    double salario;

    public Empleado(String nombre, String apellidos, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;
    }    

    public Empleado(String nombre, String apellidos, String telefono, String correoE, double salario) {
        super(nombre, apellidos, telefono, correoE);         
        this.salario = salario;               
    }



    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + "; salario=" + salario + "]";
    }

    
    
    
}
