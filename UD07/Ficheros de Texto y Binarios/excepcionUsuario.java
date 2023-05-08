import java.util.Scanner;

public class excepcionUsuario {
    public static void main(String[] args) {
        try {
            System.out.println(("Introducir edad:"));
            int edad = new Scanner(System.in).nextInt();
            if (edad < 0)
                throw new ExceptionEdadNegativa();
            else {
                System.out.println("Edad correcta: " + edad);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class ExceptionEdadNegativa extends IllegalArgumentException {
    
    public ExceptionEdadNegativa() {
        super("Edad Negativa!!");
    }

    @Override
    public String toString() {
        return "EDAD NEGATIVA!!";
    }
    
}