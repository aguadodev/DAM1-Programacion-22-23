package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app2.App;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Mapa;
import model.Personaje;

public class MapaController implements Initializable{
    @FXML
    Label lblPersonaje;

    @FXML
    GridPane gridPane;


    static int numMapa = 0;
    static public int[][] mapa = Mapa.mapas[numMapa];
    static int FILAS = mapa.length;
    static int COLUMNAS = mapa[0].length;

    static public Personaje p; // Personaje
    static private int f, c; // Posición del personaje

    // Imágenes
    static Image imgMuro = new Image("img/muro01.png"); // Muros del mapa
    static Image imgFuente = new Image("img/fuente01.png"); // Fuente de la Vida
    static Image imgPersonaje = new Image("img/guerrero01.jpeg"); // Imagen del personaje

    // GUI: Stage, contenedores y controles
    static Stage stage;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblPersonaje.setText(App.p.infoMostrar());

        cargarMapa();

        // Captura la pulsación de teclas
        App.scene.setOnKeyPressed(e -> manejarTeclaPulsada(e));
    }
    


    private void cargarMapa() {
        // Carga en la variable mapa el mapa que corresponde según el índice numMapa
        mapa = Mapa.mapas[numMapa];
        FILAS = mapa.length;
        COLUMNAS = mapa[0].length;

        // Carga el mapa en un GridPane de rectángulos a partir de los datos de mapa
        for (int row = 0; row < mapa.length; row++) {
            for (int col = 0; col < mapa[row].length; col++) {
                int value = mapa[row][col];
                Rectangle rect = new Rectangle(40, 40);

                switch (value) {
                    case 0:
                        // Espacio libre
                        rect.setFill(Color.WHITE);
                        break;
                    case 1:
                        // Muro
                        rect.setFill(Color.BLACK);
                        rect.setFill(new ImagePattern(imgMuro));
                        break;
                    case 6:
                        // Posición inicial del personaje
                        c = col;
                        f = row;
                        rect.setFill(Color.GREEN);
                        rect.setFill(new ImagePattern(imgPersonaje));
                        break;
                    case 8:
                        // Fuente para recuperar vida
                        rect.setFill(Color.BLUE);
                        rect.setFill(new ImagePattern(imgFuente));
                        break;
                    case 9:
                        // Casilla de salida/fin del mapa
                        rect.setFill(Color.RED);
                        break;
                }
                gridPane.add(rect, col, row);
            }
        }
        gridPane.autosize();
        Parent pa = App.scene.getRoot();
        pa.autosize();
    }

        /**
     * Pinta la casilla en la columna y la fila indicadas con el relleno (Color, Patrón de imagen, etc)
     * 
     * @param c
     * @param f
     * @param relleno
     */
    private void PintarCasilla(int c, int f, Paint relleno) {
        gridPane.getChildren();
        // Busca la casilla/rectángulo entre los hijos del GridPane
        for (Node n : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(n) == c && GridPane.getRowIndex(n) == f) {
                ((Rectangle) n).setFill(relleno);
                break;
            }
        }
    }







    private void manejarTeclaPulsada(KeyEvent event)
    {
        System.out.println(event.getCode());
        // Si son AWSD...
        mover(event.getCode().getChar());
        // ...
        if (mapa[f][c] == 9) {
            numMapa++;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Enhorabuena!!!!");
            if (numMapa == Mapa.mapas.length) {
                // Si no hay más mapas => Termina el programa
                alert.setContentText(
                        "Enhorabuena has escapado del laberinto!! El juego ha terminado, pulsa el botón para cerrar.");
                alert.showAndWait();
                stage.close();
            } else {
                // Si hay más mapas => Carga el siguiente Mapa
                alert.setContentText(
                        "Enhorabuena has escapado del laberinto!! Continúa en el siguiente mapa...");
                alert.showAndWait();

                gridPane = new GridPane();
                mapa = Mapa.mapas[numMapa];
                cargarMapa();
            }
        }
    }

    /**
     * 
     * @param tecla
     */
    private void mover(String tecla) {
        System.out.println("(" + f + "," + c + ")" + mapa[f][c]);
        switch (tecla) {
            case "A":
                if (c > 0 && mapa[f][c - 1] != 1) {
                    PintarCasilla(c, f, Color.WHITE);
                    c--;
                    PintarCasilla(c, f, new ImagePattern(imgPersonaje));
                }
                break;
            case "D":
                if (c < COLUMNAS - 1 && mapa[f][c + 1] != 1) {
                    PintarCasilla(c, f, Color.WHITE);
                    c++;
                    PintarCasilla(c, f, new ImagePattern(imgPersonaje));
                }
                break;
            case "W":
                if (f > 0 && mapa[f - 1][c] != 1) {
                    PintarCasilla(c, f, Color.WHITE);
                    f--;
                    PintarCasilla(c, f, new ImagePattern(imgPersonaje));
                }
                break;
            case "S":
                if (f < FILAS - 1 && mapa[f + 1][c] != 1) {
                    PintarCasilla(c, f, Color.WHITE);
                    f++;
                    PintarCasilla(c, f, new ImagePattern(imgPersonaje));
                }
                break;
        }
    }


}
