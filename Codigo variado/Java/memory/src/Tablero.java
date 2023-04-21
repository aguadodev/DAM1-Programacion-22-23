import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class Tablero {
    public final int FILAS;
    public final int COLS;

    Image[] imagenes = {
        new Image("img/tren_verde.png"),
        new Image("img/tren_de_vapor.png"),
        new Image("img/excavadora.png"),
        new Image("img/1.jpeg"),
        new Image("img/coche_azul.png"),
        new Image("img/6.jpeg"),
        new Image("img/7.jpeg"),
        new Image("img/0.jpeg") 
    };
    Image imgReverso = new Image("img/cochesReverso.png");

    Image[][] tableroOculto;

    public Tablero() throws FileNotFoundException {

        // Crea una matriz de imágenes que representa las casillas ocultas
        FILAS = 4; COLS = 4;
        tableroOculto = new Image[FILAS][COLS];
        
        // Recorre las casillas ocultas colocando las imágenes duplicadas y consecutivas
        int k = 0; // índice de la imagen a colocar
        for (int i = 0; i < tableroOculto.length; i++)
            for (int j = 0; j < tableroOculto[0].length; j++) {
                tableroOculto[i][j] = imagenes[k];
                // Incrementa el índice de la imagen a colocar
                // y al llegar a la última empieza una nueva ronda.
                k = (k + 1) % imagenes.length;
            }
            
        // Barajar tablero
        // Recorre todas las casillas intercambiando cada una por otra elegida al azar
        for (int i = 0; i < tableroOculto.length; i++)
            for (int j = 0; j < tableroOculto[0].length; j++) {
                int f = (int) (Math.random() * tableroOculto.length);
                int c = (int) (Math.random() * tableroOculto.length);
                Image aux = tableroOculto[i][j];
                tableroOculto[i][j] = tableroOculto[f][c];
                tableroOculto[f][c] = aux;
            }        
    }

    public Image[] getImagenes() {
        return imagenes;
    }

    public Image getImgReverso() {
        return imgReverso;
    }

    public Image[][] getTableroOculto() {
        return tableroOculto;
    }

    /**
     * Devuelve un array de imágenes a partir de un array de String con sus URLs
     * @param ficherosImagenes
     * @return
     * @throws FileNotFoundException
     */
    public Image[] cargarImagenes(String[] ficherosImagenes) throws FileNotFoundException {
        Image[] imagenes = new Image[ficherosImagenes.length];

        for (int i = 0; i < ficherosImagenes.length; i++) {
            imagenes[i] = new Image(new FileInputStream(ficherosImagenes[i]));
        };
        return imagenes;
    }


}
