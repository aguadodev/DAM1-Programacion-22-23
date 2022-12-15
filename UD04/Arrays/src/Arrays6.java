import java.util.Arrays;

public class Arrays6 {
   public static void main(String[] args) {
        int[] numeros = new int[10];

        for(int i = 0; i < numeros.length; i++){
            numeros[i] = (int)(Math.random()*201) - 100;
        }

        System.out.println(Arrays.toString(numeros));

        int sumaPos = 0;
        int sumaNeg = 0;
        int numPos = 0;
        int numNeg = 0;

        for(int i = 0; i < numeros.length; i++){
            if (numeros[i] > 0){
                sumaPos += numeros[i];
                numPos++;
            } else if (numeros[i] < 0){
                sumaNeg += numeros[i];
                numNeg++;
            }
        }

        System.out.printf("La media de los números positivos es %.2f %n", (double) sumaPos / numPos);
        System.out.printf("La media de los números negativos es %.2f %n", (double) sumaNeg / numNeg);

   } 
}
