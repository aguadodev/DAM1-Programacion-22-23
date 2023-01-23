// Fabricio Raul Ferreyra Bailador

import java.util.Arrays;

/**
 *
 * @author fferrbail
 */
public class App {

    public static void main(String[] args) {
        int[] t = null;
        int[] t2 = {};
        int[] t3 = {5};
        int[] t4 = {5, 8};
        int[] t5 = {4, 6, 2, 9, 10, -2};
        System.out.println(rango(t));
        System.out.println(rango(t2));
        System.out.println(rango(t3));
        System.out.println(rango(t4));
        System.out.println(rango(t5));
        
        int[][] img = {
            {0, 1, 2, 3, 4},
            {0, 1, 2, 3, 4},
            {0, 1, 2, 3, 4},
            {0, 1, 2, 3, 4}
        };
        int[][] img2 = {
            {5, 1, 2, 3, 4},
            {5, 1, 2, 3, 4},
            {5, 1, 2, 3, 4},
            {5, 1, 2, 3, 4}
        };
        int[][] img3 = {
            {5, 1, 2, 3, 7},
            {5, 1, 2, 3, 7},
            {5, 1, 2, 3, 7},
            {5, 1, 2, 3, 7}
        };
        boolean cambios = cambiarColor(img, 0, 5);
        System.out.println("Hubo cambios? img1: "+cambios+Arrays.deepToString(img));
        cambios = cambiarColor(img, 0, 5);
        System.out.println("Hubo cambios? img2: "+cambios+Arrays.deepToString(img));
        cambios = cambiarColor(img, 4, 7);
        System.out.println("Hubo cambios? img1: "+cambios+Arrays.deepToString(img));
        
        
        String[] mapa = {
            "  X       ",
            " *        ",
            "  *  *    ",
            "          ",
            " S        "
        };
        imprimirMapa(mapa);
        char[][] mapaChar = convertirMapa(mapa);
        System.out.println("Posiciones iniciales: "+posInicial(mapaChar)[0]+","+posInicial(mapaChar)[1]);
        System.out.println((mapaChar[4][1]));
        System.out.println(caminoValido(mapa, "NNONNEE"));
        System.out.println(caminoValido(mapa, "EENNNNO"));
        System.out.println(caminoValido(mapa, "ENENENENOOO"));
        System.out.println(caminoValido(mapa, "EEEEEEEENOOOOOONNEENOOO"));
        System.out.println(caminoValido(mapa, "S"));
        System.out.println(caminoValido(mapa, "OO"));
        System.out.println(caminoValido(mapa, "NEEEEEEEEE"));
        System.out.println(caminoValido(mapa, "ONNNNNNN"));
        System.out.println(caminoValido(mapa, "NNNNE"));
        System.out.println(caminoValido(mapa, "EEEEEEEENOOOOOONNEENOOOO"));
        System.out.println(caminoValido(mapa, "EEEEEEEENOOOOOONNEENOOONNNN"));
        
        
    }


    public static int rango(int t[]) {
        int diferencia = 0;
        if (t != null && t.length >= 2) {
            int minimo = t[0];
            int maximo = t[0];
            for (int i = 0; i < t.length; i++) {
                minimo = (t[i] < minimo) ? t[i] : minimo;
                maximo = (t[i] > maximo) ? t[i] : maximo;
            }
            diferencia = Math.abs(maximo - minimo);
        }
        return diferencia;
    }
    public static boolean cambiarColor(int[][] img, int colorViejo, int colorNuevo){
        boolean huboCambios = false;
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                if (img[i][j] == colorViejo){
                    huboCambios=true;
                    img[i][j]=colorNuevo;
                }
            }          
        }
        return huboCambios;
    }
    
    public static void imprimirMapa(String [] mapa){
        char[][] mapaChar = convertirMapa(mapa);
        for (int i = 0; i < mapaChar.length; i++) {
            System.out.print("\"");
            for (int j = 0; j < mapaChar[0].length; j++) {
                System.out.print(mapaChar[i][j]);
            }
            System.out.println("\"");
            
        }
    }    
    public static char[][] convertirMapa(String[] mapa){
        char[][] mapaChar = new char[mapa.length][mapa[0].length()];
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length(); j++) {
                mapaChar[i][j]=mapa[i].charAt(j);
            }
        }
        return mapaChar;
    }
    public static int[] posInicial(char[][] mapaChar){
       int i = 0;
       int j = 0;
       boolean encontrado = false;
       while (i < mapaChar.length && !encontrado) {
           j=0;
           while (j < mapaChar[0].length && !encontrado) {
               encontrado = mapaChar[i][j]=='S';
               j++;
           }
           i++;
       }
       int[] coordenadas = {i-1,j-1};
       return coordenadas;
    }
    
    public static boolean caminoValido(String[] mapa, String camino){
        boolean caminoValido;
        char[][] mapaChar = convertirMapa(mapa);
        int iInicial = posInicial(mapaChar)[0];
        int jInicial = posInicial(mapaChar)[1];
        int posI = iInicial;
        int posJ = jInicial;
        int tamanoFilas = mapaChar.length;
        int tamanoColumnas = mapaChar[0].length;
        for (int i = 0; i < camino.length(); i++) {
            switch (camino.charAt(i)) {
                case 'E':
                    if (posJ +1 < tamanoColumnas) {
                        posJ +=1;
                        if (mapaChar[posI][posJ]=='*') {
                            return false;
                        }
                    }
                    else return false;
                    break;
                case 'O':
                    if (posJ -1 >= 0) {
                        posJ -=1;
                        if (mapaChar[posI][posJ]=='*') {
                            return false;
                        }
                    }
                    else return false;
                    break;
                case 'N':
                    if (posI -1 >= 0) {
                        posI -= 1;
                        if (mapaChar[posI][posJ]=='*') {
                            return false;
                        }
                    }
                    else return false;
                    break;
                case 'S': 
                    if (posI +1 < tamanoFilas) {
                        posI +=1;
                        if (mapaChar[posI][posJ]=='*') {
                            return false;
                        }
                    }
                    else return false;
                    break;
                default:
                    throw new AssertionError();
            }           
        }
        caminoValido=mapaChar[posI][posJ]=='X';
        return caminoValido;
    }
}