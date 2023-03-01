/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package u04recafp;

import java.util.Arrays;

/**
 *
 * @author Ander Fernandez Pazos
 */
public class App {
    
    
    /**
     * Ejercicio 1
     * @param t
     * @return 
     */
    
    static int [] sumas (int t[]){
        int[] resultados =  new int[3];
        if (t == null) {
            return null;
        } else {
            for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 == 0) {
                resultados[1] += t[i];
            } else {
                resultados[2] += t[i];
            }
            resultados[0] += t[i];
        }
        }        
        return resultados;
    }
    
    /**
     * Ejercicio 2
     * @param t
     * @return 
     */
    
    static boolean diagonalesIguales(int[][] t){
        int diagonal1 = 0;
        int diagonal2 = 0;
        if (t == null || t.length == 0) {
            return false;
        } else {
            for(int i = 0; i < t.length; i++) {
            for(int j = 0; j < t[i].length; j++){
                if (t.length != t[i].length) {
                    return false;
                } else {
                    if (i == j) {
                        diagonal1 += t[i][j];
                    }
                    if (j == t[i].length - 1 - i) {
                        diagonal2 += t[i][j];
                    }
                }
            }
        }
        }
        return diagonal1 == diagonal2;
    }
    
    /**
     * Ejercicio 3
     * @param str
     * @param vogal
     * @return 
     */
    
    static String cambiaVogais(String str, char vogal){
        String fraseAux = "";
        switch (vogal) {
            case 'a':
                for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    fraseAux += vogal;
                    break;
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    fraseAux += 'A';
                    break;
                case 'É':
                case 'Í':
                case 'Ó':
                case 'Ú':
                    fraseAux += 'Á';
                    break;
                case 'é':
                case 'í':
                case 'ó':
                case 'ú':
                    fraseAux += 'á';
                    break;
                case 'ü':
                    fraseAux += 'ä';
                    break;
                case 'Ü':
                    fraseAux += 'Ä';
                    break;
                default:
                    fraseAux += str.charAt(i);
                    break;
            }
                }
                break;
            case 'e':
                for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'a':
                case 'i':
                case 'o':
                case 'u':
                    fraseAux += vogal;
                    break;
                case 'A':
                case 'I':
                case 'O':
                case 'U':
                    fraseAux += 'E';
                    break;
                case 'Á':
                case 'Í':
                case 'Ó':
                case 'Ú':
                    fraseAux += 'É';
                    break;
                case 'á':
                case 'í':
                case 'ó':
                case 'ú':
                    fraseAux += 'é';
                    break;
                case 'ü':
                    fraseAux += 'ë';
                    break;
                case 'Ü':
                    fraseAux += 'Ë';
                    break;
                default:
                    fraseAux += str.charAt(i);
                    break;
            }
                }
                break;
            case 'i':
                for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'e':
                case 'a':
                case 'o':
                case 'u':
                    fraseAux += vogal;
                    break;
                case 'E':
                case 'A':
                case 'O':
                case 'U':
                    fraseAux += 'I';
                    break;
                case 'É':
                case 'Á':
                case 'Ó':
                case 'Ú':
                    fraseAux += 'Í';
                    break;
                case 'é':
                case 'á':
                case 'ó':
                case 'ú':
                    fraseAux += 'í';
                    break;
                case 'ü':
                    fraseAux += 'ï';
                    break;
                case 'Ü':
                    fraseAux += 'Ï';
                    break;
                default:
                    fraseAux += str.charAt(i);
                    break;
            }
                }
                break;
            case 'o':
                for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'e':
                case 'i':
                case 'a':
                case 'u':
                    fraseAux += vogal;
                    break;
                case 'E':
                case 'I':
                case 'A':
                case 'U':
                    fraseAux += 'O';
                    break;
                case 'É':
                case 'Í':
                case 'Á':
                case 'Ú':
                    fraseAux += 'Ó';
                    break;
                case 'é':
                case 'í':
                case 'á':
                case 'ú':
                    fraseAux += 'ó';
                    break;
                case 'ü':
                    fraseAux += 'ö';
                    break;
                case 'Ü':
                    fraseAux += 'Ö';
                    break;
                default:
                    fraseAux += str.charAt(i);
                    break;
            }
                }
                break;
            case 'u':
                for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'e':
                case 'i':
                case 'o':
                case 'a':
                    fraseAux += vogal;
                    break;
                case 'E':
                case 'I':
                case 'O':
                case 'A':
                    fraseAux += 'U';
                    break;
                case 'É':
                case 'Í':
                case 'Ó':
                case 'Á':
                    fraseAux += 'Ú';
                    break;
                case 'é':
                case 'í':
                case 'ó':
                case 'á':
                    fraseAux += 'ú';
                    break;
                default:
                    fraseAux += str.charAt(i);
                    break;
            }
                }
                break;
        }
        return fraseAux;
    }
    
}
