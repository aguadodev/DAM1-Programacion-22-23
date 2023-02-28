import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Examen UD4 - REC");
        System.out.println("1. sumas");
        int[] t1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] t2 = {1};
        int[] t3 = {};
        int[] t4 = null;

        System.out.println(Arrays.toString(sumas(t1)));
        System.out.println(Arrays.toString(sumas(t2)));
        System.out.println(Arrays.toString(sumas(t3)));
        System.out.println(Arrays.toString(sumas(t4)));

        System.out.println("2. diagonalesIguales");
        int[][] t21 = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3}
        };
        int[][] t22 = {{1}};
        int[][] t23 = {};
        int[][] t24 = null;   
        int[][] t25 = {
            {1, 2, 1},
            {1, 2, 3},
            {1, 2, 3}
        };
        int[][] t26 = {
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3},
            {1, 2, 3}
        };


        System.out.println(diagonalesIguales(t21));
        System.out.println(diagonalesIguales(t22));
        System.out.println(diagonalesIguales(t23));
        System.out.println(diagonalesIguales(t24));
        System.out.println(diagonalesIguales(t25));
        System.out.println(diagonalesIguales(t26));

        System.out.println("3. cambiaVogais");

    }

    static int[] sumas(int t[]){
        int[] res = null;

        if (t != null){
            int suma = 0;
            int sumaPares = 0;
            int sumaImpares = 0;
    
            for(int i = 0; i < t.length; i++){
                suma += t[i];
                if (t[i] % 2 == 0)
                    sumaPares += t[i];
                else
                    sumaImpares += t[i];
            }
    
            res = new int[3];
            res[0] = suma;
            res[1] = sumaPares;
            res[2] = sumaImpares;
        }

        return res;
    }

    static boolean diagonalesIguales(int[][] t){
        boolean diagonalesIguales = false;

        // Si la matriz no es nula y tiene al menos una fila de una columna y 
        // el número de filas es igual al número de columnas de la primera fila (=> cuadrada)
        if (t != null && t.length != 0 && t[0].length != 0 && t.length == t[0].length){
            int sumaDP = 0;
            int sumaDS = 0;

            for (int i = 0; i < t.length; i++){
                sumaDP += t[i][i];
                sumaDS += t[i][t.length - 1 - i];
            }
            
            diagonalesIguales = sumaDP == sumaDS;

        }

        return diagonalesIguales;
    }

    static String cambiaVogais(String str, char vogal){
        String strRes = "";
        //String vogais = "aeiouáéíóúü";

        for(int i = 0; i < str.length(); i++){
            if(esVocal(str.charAt(i))){
                strRes += cambiaVogal(str.charAt(i), vogal);
            } else {
                strRes += str.charAt(i);
            }
        }

        return "Prigrimir in Jivi mintris fis pirigïismi í cimplicidi";
    }

    static boolean esVocal(char letra){
        String vogais = "aeiouáéíóúü";
        return vogais.indexOf(Character.toLowerCase(letra)) != -1;
    }

    static char cambiaVogal(char letra, char vogal){
        char[][] cambios = {
            {'a', 'e', 'i', 'o', 'u'},
            {'á', 'é', 'í', 'ó', 'ú'},
            {'ä', 'ë', 'ï', 'ö', 'ü'},
        };

        
                        char res;
            

        if (Character.isUpperCase(letra))
            return Character.toLowerCase(vogal);
        else    
            return Character.toUpperCase(vogal);
    }

}
