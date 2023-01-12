import java.util.Scanner;

public class Paraninfo613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pega el código fuente: ");
        String codigo = sc.nextLine();

        String codigoSinComentarios = eliminarComentarios(codigo);

        System.out.println(codigoSinComentarios);
    }   
    
    static String eliminarComentarios(String codigo){
        String aux = new String(codigo);

        int posInicioComentario = aux.indexOf("/*");
        while (posInicioComentario != -1){
            // Eliminar el primer comentario de la cadena
            int posfinalComentario = aux.indexOf("*/");

            aux = aux.substring(0,posInicioComentario) +
            aux.substring(posfinalComentario + 2);

            posInicioComentario = aux.indexOf("/*");
        }

        return aux;
    }
}
