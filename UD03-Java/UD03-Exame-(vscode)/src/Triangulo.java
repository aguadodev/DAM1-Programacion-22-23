import java.util.Scanner;

public class Triangulo {
    public static void main(String[] args) {
            System.out.println("TRIÁNGULO");
            System.out.println("=========\n");
            
            int alturaTriangulo = 0;
    
            // Se asegura de que la altura cumpla las condiciones establecidas
            while (alturaTriangulo <= 0 || alturaTriangulo > 20) {
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Introduce la altura del triángulo (1-20): ");
                    alturaTriangulo = sc.nextInt();
                    System.out.println("");
                } catch (Exception e) {
                    System.out.println("");
                }
            }
    
            // Calcula el num de * usados
            int astUsados = (int) Math.pow(alturaTriangulo, 2);
    
            for (int i = 1; i <= alturaTriangulo; i++) {
                switch (i) {
                    case 1:
                        for (int j = 1; j <= alturaTriangulo * 2 - 1; j++) {
                            if (j != Math.round((alturaTriangulo * 2 - 1) / 2)) {
                                System.out.print(" ");
                            } else {
                                System.out.println("*");
                            }
                        }
                        break;
                    case 2:
                        for (int j = 1; j <= alturaTriangulo * 2 - 1; j++) {
                            if (j != Math.round((alturaTriangulo * 2 - 1) / 2)) {
                                System.out.print(" ");
                                if (j == (Math.round((alturaTriangulo * 2 - 1) / 2)) + 1);
                            } else {
                                System.out.println("*");
                            }
                        }
                
                    default:
                        break;
                } 
                
            }
    
            System.out.println("\nNúmero de asteriscos utilizados = " + astUsados);
            System.out.println("\nFIN DEL PROGRAMA");
        }
    }
    