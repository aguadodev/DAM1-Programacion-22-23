import java.util.Scanner;

public class Triangulo {
    public static void main(String[] args) {

        System.out.println("TRIÁNGULO");
        System.out.println("=========");

        int altura = leerAltura();

        int numAsteriscos = dibujarTriangulo(altura);

        System.out.println("Número de asteriscos utilizados = " + numAsteriscos);        
        
        System.out.println("FIN DEL PROGRAMA");
    }



    public static byte leerAltura() {
        int altura = 0;
        boolean entradaValida = false;
        Scanner sc = new Scanner(System.in);

        System.out.print("Altura del triángulo (1-20): ");

        do {
            try {
                altura = sc.nextInt();
                if (altura >= 1 && altura <= 20)
                    entradaValida = true;
                else
                    System.out.print("Por favor introduce un número entero entre 1 y 20: ");
            } catch (Exception e) {
                System.out.print("Por favor introduce un número entero entre 1 y 20: ");
                sc.nextLine();
            }
        } while (!entradaValida);
        return (byte) altura;
    }

    public static int dibujarTriangulo(int altura){
        int cont = 0;
        for(int i = 1; i <= altura; i++){
            for(int j = 0; j < (altura - i); j++)
                System.out.print(" ");
            for(int j = 0; j < (1 + 2 * (i - 1)); j++) {
                System.out.print("*");
                cont++;
            }
                
            System.out.println();
        }
        return cont;
    }

}
