import java.io.File;
import java.util.Scanner;

/**
Este proxecto l
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("CICLOS DE INFORMÁTICA");
        System.out.println("Programacións de Probas Libres\n");
        
        String sCarpAct = null; // Z:\0.DEPTO\13. Probas Libres\Programacions 22-23
        if (args == null || args.length == 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Ruta del directorio a examinar ('ENTER' para el directorio actual): ");
            sCarpAct = sc.nextLine();
            if (sCarpAct == null || sCarpAct.length() == 0)
                sCarpAct = System.getProperty("user.dir");
        }
        
        File carpeta = new File(sCarpAct);

        String[] listado = carpeta.list();
        if (listado == null || listado.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
            return;
        }
        else {
            for (int i=0; i< listado.length; i++) {
                System.out.println(listado[i]);
            }
        }
    }
}
