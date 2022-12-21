package UD04.Cadenas;

import java.util.Arrays;

public class ParaninfoAR61 {
    public static void main(String[] args) {
        char c; // = '\u0061';
        System.out.println("\u2661");
        for(int codigo = 300; codigo <= 600; codigo++){
            c = (char)codigo;
            System.out.print("(" + codigo + ") ");
            System.out.println(c);
        }
    }
}
