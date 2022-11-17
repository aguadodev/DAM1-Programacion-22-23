
package personas;

import java.util.Scanner;

/**
 *
 * @author oaguado
 */
public class EjemploMainPersonas {

    public static void main(String[] args) {
        System.out.println("PRIMER EJEMPLO DE POO CON NETBEANS");
        
        // Declarar variable

        Persona persona1, persona2, persona3, personaElegida = null;
        
        // Crear objetos
        persona1 = new Persona("Pepe");
        persona2 = new Persona("Marta", "Cobas");
        persona3 = new Persona("Sonia", "Martínez", 65, 165, (byte)25, "764548999Z");      
                
        persona1.setApellidos("García");
        persona1.setPeso(80);
        persona1.setEstatura(180);
        
        persona2.setPeso(60);
        persona2.setEstatura(170);       
        
        System.out.println("MENU");                
        System.out.println("1. " + persona1.getNombre() + " " + persona1.getApellidos());
        System.out.println("2. " + persona2.getNombre() + " " + persona2.getApellidos());
        System.out.println("3. " + persona3.getNombre() + " " + persona3.getApellidos());
        System.out.print("Elige una persona (1-3:");
        
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        
        switch (opcion){
            case 1: personaElegida = persona1; break;
            case 2: personaElegida = persona2; break;
            case 3: personaElegida = persona3; break;
        }
        
        personaElegida.mostrar();
        System.out.printf("IMC: %.2f", personaElegida.imc());       
    }
    
}
