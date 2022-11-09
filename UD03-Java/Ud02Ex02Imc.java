import java.util.Scanner;

public class Ud02Ex02Imc {
    public static void main(String[] args) {

        int altura = leerAltura(50, 250);

        double peso = leerPeso(20, 300);

        imprimirImc(imc(peso, altura));        
    }


    public static void imprimirImc(double imc){
        System.out.printf("El IMC es %.2f. ", imc);

        if (imc < 18.5) {
            System.out.println("Bajo Peso");
        } else if(imc < 25){
            System.out.println("Peso Normal");
        } else if(imc < 30){
            System.out.println("Sobrepeso");
        } else {
            System.out.println("Obesidad");
        }
    }

    public static double leerPeso(double minKg, double maxKg) {
        Scanner sc;
        double peso = 0;                      
    
        boolean entradaValida = false;
        while (!entradaValida){
            sc = new Scanner(System.in);
            try {
                System.out.print("Introduce el peso en kilos: ");
                peso = sc.nextDouble();
                if (peso >= minKg && peso <= maxKg)
                    entradaValida = true;
                else
                    System.out.println("El peso debe estar entre " + minKg + " y " + maxKg + " cm.");
            } catch (Exception e){
                System.out.println("Error de entrada de datos. Por favor introduce números. Usa la coma como separador decimal.");
            }            
        }
        return peso;
    }

    public static int leerAltura(int minCm, int maxCm) {
        Scanner sc;
        int altura = 0;                      

        boolean entradaValida = false;
        while (!entradaValida){
            sc = new Scanner(System.in);
            try {                
                System.out.print("Introduce la altura en cm: ");
                altura = sc.nextInt();
                if (altura >= minCm && altura <= maxCm) {
                    entradaValida = true;
                } else {
                    System.out.println("La altura debe estar entre "+ minCm +" y "+ maxCm +" cm.");
                }
            } catch (Exception e){
                System.out.println("Error de entrada de datos. Por favor introduce números enteros.");
            }
        }        
        return altura;
    }


    public static double imc(double kg, int cm) {
        return kg / Math.pow(cm / 100.0, 2);
    }   

}
