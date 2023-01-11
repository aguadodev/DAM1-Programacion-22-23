import java.util.Scanner;

public class Paraninfo616 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe una palabra o una frase: ");
        String frase = sc.nextLine();

        System.out.println(
            frase + "\n" + 
            codificar(frase) + "\n" + 
            codificar2(frase) + "\n" + 
            codificar3(frase)
        );
    }

    public static String codificar3(String frase){
        String[] conversion = {
            "aeios",
            "@€105"
        };
        String fraseAux = "";

        for(int i = 0; i < frase.length(); i++){
            char letra = frase.charAt(i);
            int pos = conversion[0].indexOf(letra);

            if (pos == -1){
                fraseAux += letra;
            } else {
                fraseAux += conversion[1].charAt(pos);
            }

        }
        return fraseAux;      

    }

    public static String codificar2(String frase){
        char[][] conversion = {
            {'a', '@'},
            {'e', '€'},
            {'i', '1'},
            {'o', '0'},
            {'s', '5'},
        };
        String fraseAux = new String(frase);

        for(int i = 0; i < conversion.length; i++){
            fraseAux = fraseAux.replace(conversion[i][0], conversion[i][1]);
        }

        return fraseAux;        
    }


    public static String codificar(String frase){
        String fraseAux = "";

        // 'a' > '@', 'e' > '€', 'i' > '1'
        for(int i = 0; i < frase.length(); i++){
            char letra = frase.charAt(i);

            switch (letra) {
                case 'a': fraseAux += '@'; break;
                case 'e': fraseAux += '€'; break;
                case 'i': fraseAux += '1'; break;
                default:  fraseAux += letra;
            }
        }
        return fraseAux;        
    }

}
