package personas;

/**
 *
 * @author oaguado
 */
public class EjemploMainStatic {

    public static void main(String[] args) {
        System.out.println(Persona.hoy);
        if (Persona.dniValido("764548999Z")) {
            System.out.println("DNI válido");
        } else {
            System.out.println("DNI NO válido");
        }

        if (Persona.dniValido("28355206R")) {
            System.out.println("DNI válido");
        } else {
            System.out.println("DNI NO válido");
        }
    }
}
