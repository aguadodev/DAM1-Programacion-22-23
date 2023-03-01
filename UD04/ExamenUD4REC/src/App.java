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
        String str1 = "Programar en Java mentres fas piragüismo é complicado";
        String stro1 = "Prigrimir in Jivi mintris fis pirigïismi í cimplicidi";
        char v1 = 'i';

        System.out.println(str1);
        System.out.println(cambiaVogais(str1, v1));
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


    static String cambiaVogais(String frase, char vogal){
        // Hace una copia de la frase de entrada
        String str = frase;

        String[] conversion = {
            "aeiou",
            "áéíóú",
            "äëïöü",
            "AEIOU",
            "ÁÉÍÓÚ",
            "ÄËÏÖÜ"
        };

        // Obtiene la columna de la vocal de destino
        int columnaDestino = conversion[0].indexOf(vogal);

        // Recorre todas las vocales de "conversion" y las reemplaza en la frase por  
        // la vocal correspondiente de la columna de destino
        for (int i = 0; i < conversion.length; i++){
            for (int j = 0; j < conversion[i].length(); j++)
                if (j != columnaDestino)
                    str = str.replace(conversion[i].charAt(j), conversion[i].charAt(columnaDestino));
        }

        return str;
    }



    // A continuación otra solución inicial menos optimizada y comprimida.
    static String cambiaVogais1(String frase, char vogal){
        String str = frase;

        str = str.replace('a', vogal);
        str = str.replace('e', vogal);
        str = str.replace('i', vogal);
        str = str.replace('o', vogal);
        str = str.replace('u', vogal);
        
        char vogalMaiuscula = Character.toUpperCase(vogal);
        str = str.replace('A', vogalMaiuscula);
        str = str.replace('E', vogalMaiuscula);
        str = str.replace('I', vogalMaiuscula);
        str = str.replace('O', vogalMaiuscula);
        str = str.replace('U', vogalMaiuscula);
        
        char vogalTilde = vogalTilde(vogal);
        str = str.replace('á', vogalTilde);
        str = str.replace('é', vogalTilde);
        str = str.replace('í', vogalTilde);
        str = str.replace('ó', vogalTilde);
        str = str.replace('ú', vogalTilde);
        
        char vogalTildeMaiuscula = vogalTildeMaiuscula(vogal);
        str = str.replace('Á', vogalTildeMaiuscula);
        str = str.replace('É', vogalTildeMaiuscula);
        str = str.replace('Í', vogalTildeMaiuscula);
        str = str.replace('Ó', vogalTildeMaiuscula);
        str = str.replace('Ú', vogalTildeMaiuscula);

        char vogalDierese = vogalDierese(vogal);
        str = str.replace('ü', vogalDierese);

        char vogalDiereseMaiuscula = vogalDiereseMaiuscula(vogal);
        str = str.replace('Ü', vogalDiereseMaiuscula);
        
        return str;
    }

    private static char vogalTilde(char vogal) {
        String[] conversion = {
            "aeiou",
            "áéíóú"
        };
        
        return conversion[1].charAt(conversion[0].indexOf(vogal));
    }

    private static char vogalTildeMaiuscula(char vogal) {
        String[] conversion = {
            "aeiou",
            "ÁÉÍÓÚ"
        };
        
        return conversion[1].charAt(conversion[0].indexOf(vogal));
    }

    private static char vogalDiereseMaiuscula(char vogal) {
        String[] conversion = {
            "aeiou",
            "ÄËÏÖÜ"
        };
        
        return conversion[1].charAt(conversion[0].indexOf(vogal));
    }

    private static char vogalDierese(char vogal) {
        String[] conversion = {
            "aeiou",
            "äëïöü"
        };
        
        return conversion[1].charAt(conversion[0].indexOf(vogal));
    }




    
}
