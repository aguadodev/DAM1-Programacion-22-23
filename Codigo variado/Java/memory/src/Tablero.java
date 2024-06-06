import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;

public class Tablero {
    enum TipoMapa {
        VEHICULOS, MAR, DINOS
    }
    public final int FILAS;
    public final int COLS;
    Image[] imagenes;
    Image imgReverso;
    Image[][] tableroOculto;

    public Tablero(String tipo) {
        FILAS = 4;
        COLS = 4;
        if (tipo.equals("vehiculos")) {
            Image[] imgVehiculos = {
                    new Image("img/vehiculos/tren_verde.png"),
                    new Image("img/vehiculos/tren_de_vapor.png"),
                    new Image("img/vehiculos/excavadora.png"),
                    new Image("img/vehiculos/coche_blanco.jpeg"),
                    new Image("img/vehiculos/coche_azul.png"),
                    new Image("img/vehiculos/coche_rojo.jpeg"),
                    new Image("img/vehiculos/coche_negro.jpeg"),
                    new Image("img/vehiculos/tractor.jpeg")
            };
            imagenes = imgVehiculos;
            imgReverso = new Image("img/vehiculos/cochesReverso.png");
        } else if (tipo.equals("mar")) {
            Image[] imgMar = {
                    new Image("img/mar/calamar.jpg"),
                    new Image("img/mar/delfin.jpg"),
                    new Image("img/mar/foca.jpg"),
                    new Image("img/mar/leon_marino.jpg"),
                    new Image("img/mar/orca.jpg"),
                    new Image("img/mar/pinguino.jpg"),
                    new Image("img/mar/pulpo.jpg"),
                    new Image("img/mar/tiburon.jpg"),
            };
            imagenes = imgMar;
            imgReverso = new Image("img/mar/mar.jpg");
        } else if (tipo.equals("dinos")) {
            Image[] imgDinos = {
                    new Image("img/dinos/estegosaurio.png"),
                    new Image("img/dinos/ictiosaurio.png"),
                    new Image("img/dinos/pliosaurio.png"),
                    new Image("img/dinos/plesiosaurio.png"),
                    new Image("img/dinos/pterodactilo.png"),
                    new Image("img/dinos/tiranosaurio.jpg"),
                    new Image("img/dinos/triceratops.png"),
                    new Image("img/dinos/velociraptor.jpg"),
            };
            imagenes = imgDinos;
            imgReverso = new Image("img/dinos/paisaje.jpg");
        } else if (tipo.equals("cars")) {
            Image[] imgDinos = {
                    new Image("img/cars/Daniel Swervez.jpg"),
                    new Image("img/cars/Jackson Storm.jpg"),
                    new Image("img/cars/El Rey.jpg"),
                    new Image("img/cars/Francesco Bernoulli.jpg"),
                    new Image("img/cars/Cruz Ramírez.jpg"),
                    new Image("img/cars/Brick Yardley.jpg"),
                    new Image("img/cars/Rayo McQueen.jpg"),
                    new Image("img/cars/Mate.jpg"),
            };
            imagenes = imgDinos;
            imgReverso = new Image("img/cars/Reverso.png");
        }

        crearTableroOculto();
        barajarImagenes();
    }

    public Tablero() {

        this("mar");
    }

    void crearTableroOculto() {
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
    }

    void barajarImagenes() {
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
     * 
     * @param ficherosImagenes
     * @return
     * @throws FileNotFoundException
     */
    public Image[] cargarImagenes(String[] ficherosImagenes) throws FileNotFoundException {
        Image[] imagenes = new Image[ficherosImagenes.length];

        for (int i = 0; i < ficherosImagenes.length; i++) {
            imagenes[i] = new Image(new FileInputStream(ficherosImagenes[i]));
        }
        ;
        return imagenes;
    }

}
