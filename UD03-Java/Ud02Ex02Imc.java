import java.util.Scanner;

public class Ud02Ex02Imc {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(System.in);
        System.out.print("Introduce la altura en cm:");
        int altura = sc.nextInt();
        System.out.print("Introduce el peso en kilos:");
        double peso = sc.nextDouble();

        double imc = imc(peso, altura);

        System.out.println("El IMC es" + imc);
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

    public static double imc(double kg, int cm) {
        return kg / Math.pow(cm / 100.0, 2);
    }   

}
