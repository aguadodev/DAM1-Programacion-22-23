import java.util.Arrays;

public class ClaseArrays {
    public static void main(String[] args) {
        final int MAX = 10;
        int[] t = new int[MAX];

        Arrays.fill(t, 5);
        Arrays.fill(t, 5, 8, 10);
        for(int i = 0; i < t.length; i++)
            t[i] = (int) (1 + Math.random() * 100);

        System.out.println(Arrays.toString(t));
        
        System.out.println("Valor máximo del array: " + maximo(t));

        // Ordenar
        Arrays.sort(t);

        System.out.println(Arrays.toString(t));
    
        int clave = 77;
        int indice = Arrays.binarySearch(t, clave);
        if (indice < 0)
            System.out.println("El valor " + clave + " no se encuentra en al array.");
        else 
            System.out.println("El valor " + clave + " se encuentra en la posición " + indice);


        System.out.println("Fin del programa");
    }

    static int maximo(int t[]) {
        int maximo = t[0]; // Contiene el maximo valor encontrado hasta el momento
    
        for (int i = 1; i < t.length; i++) {
            if (t[i] > maximo) {
                maximo = t[i];
            }
        }
    
        return maximo;
    }
      
}
