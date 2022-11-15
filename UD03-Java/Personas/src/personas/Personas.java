



package personas;

/**
 *
 * @author oaguado
 */
public class Personas {

    public static void main(String[] args) {
        System.out.println("PRIMER EJEMPLO DE POO CON NETBEANS");
        
        // Declarar variable
        Persona p1;
        
        // Crear objeto
        p1 = new Persona();
        
        p1.setNombre("Pepe");
        p1.setApellidos("García");
        p1.setPeso(80);
        p1.setEstatura(180);
        
        System.out.println("La primera persona se llama " + p1.getNombre() + " " + p1.getApellidos());
        System.out.println("Tiene un peso de " + p1.getPeso() + " kilos y una estatura de " + p1.getEstatura() + "cm.");
        System.out.println("Su IMC es igual a " + p1.imc());
        
    }
    
}
