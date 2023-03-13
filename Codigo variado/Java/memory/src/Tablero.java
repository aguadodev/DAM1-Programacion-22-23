import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tablero {
    public final int FILAS;
    public final int COLS;
    Image[] imagenes;
    Image imgReverso;
    Image[][] tableroOculto;

    public Tablero() throws FileNotFoundException {
        imagenes = new Image[8];
        FILAS = 4; COLS = 4;

        imagenes[0] = new Image(new FileInputStream("img/tren_verde.png"));
        imagenes[1] = new Image(new FileInputStream("img/tren_de_vapor.png"));
        imagenes[2] = new Image(new FileInputStream("img/excavadora.png"));
        imagenes[3] = new Image(new FileInputStream("img/1.jpeg"));
        imagenes[4] = new Image(new FileInputStream("img/2.jpeg"));
        imagenes[5] = new Image(new FileInputStream("img/6.jpeg"));
        imagenes[6] = new Image(new FileInputStream("img/7.jpeg"));
        imagenes[7] = new Image(new FileInputStream("img/0.jpeg"));

        imgReverso = new Image(new FileInputStream("img/cochesReverso.jpeg"));       
        
        tableroOculto = new Image[FILAS][COLS];
        int indImg = 0;
        for (int i = 0; i < tableroOculto.length; i++)
            for (int j = 0; j < tableroOculto[0].length; j++) {
                tableroOculto[i][j] = imagenes[indImg % imagenes.length];
                indImg++;
            }
            
        // barajar tablero
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


    public void cargarImagenes(String[] ficherosImagenes) throws FileNotFoundException {
        imagenes = new Image[ficherosImagenes.length];

        for (int i = 0; i < ficherosImagenes.length; i++) {
            imagenes[i] = new Image(new FileInputStream(ficherosImagenes[i]));
        };   
    }


}
