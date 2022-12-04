// https://www.aceptaelreto.com/problem/statement.php?id=619&cat=151
import java.util.Scanner;

public class PantallasDeCarga619 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] linea = sc.nextLine().split(" ");
        int ancho = Integer.valueOf(linea[0]);
        int alto = Integer.valueOf(linea[1]);


/*
        int ancho = sc.nextInt();
        int alto = sc.nextInt();
        //sc.nextLine();
*/

        while(ancho != 0 && alto != 0){
            // Lee los píxeles de la imagen y los almacena en un array de String
            Scanner scImagen = new Scanner(System.in);
            String[] imagen = new String[alto];
            for(int i = 0; i < alto; i++)
                imagen[i] = scImagen.nextLine();

            boolean imagenOk = true;
            // Analiza los bloques de 8x8
            for(int i = 0; i < alto / 8; i++) // i = bloques de alto
                for(int j = 0; j < ancho / 8; j++){ // j = bloques de ancho
                    // Procesa el bloque (i, j)
                    char pixel1 = ' ', pixel2 = ' '; // Almacenan los valores diferentes utilizados
                    for(int pi = 0; pi < 8; pi++)
                        for(int pj = 0; pj < 8; pj++){
                            char pixel = imagen[i * 8 + pi].charAt(j * 8 + pj);
                            if (pixel == pixel1 || pixel == pixel2)
                                continue;
                            else if(pixel1 == ' ')
                                pixel1 = pixel;
                            else if (pixel2 == ' ')
                                pixel2 = pixel;
                            else
                                imagenOk = false;
                        }
                }
            
            if(imagenOk)
                System.out.println("SI");
            else
                System.out.println("NO");


            linea = sc.nextLine().split(" ");
            ancho = Integer.valueOf(linea[0]);
            alto = Integer.valueOf(linea[1]);
            /*ancho = sc.nextInt();
            alto = sc.nextInt();    */
        }
        
    }
}
