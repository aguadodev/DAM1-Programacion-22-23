package Examen;

/**
 * SopaDeLetras
 */
public class SopaDeLetras {

    public static void main(String[] args) {
        char[][] t = {
            {' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' '},
            {' ','C','A','S','A',' '},
            {' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' '}
    };
    System.out.println(buscar(t, "CASA"));

    }

    static boolean buscar(char[][] t, String p){
        boolean encontrado = false;
       
        for(int i = 0; i < t.length; i++){
            for(int j = 0; j < t[0].length; j++){
                int k = 0;
                while (p.charAt(k) == t[i][j]){
                    if(i == 1)



                }
            }
        }
        return encontrado;
    }
}