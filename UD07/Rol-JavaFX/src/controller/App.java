package controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Mapa;
import model.Personaje;

public class App extends Application {

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
    static GridPane gridMapa = new GridPane();
    static Label lblInfoPersonaje;
    static HBox hBox = new HBox();
    static Stage stage;

    public static void main(String[] args) throws Exception {
        System.out.println("Inicio de la aplicación");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Inicia la aplicación y el escenario con la Creación del Personaje
        Parent rootCreaPersonaje = FXMLLoader.load(getClass().getResource("/view/Personaje.fxml"));
        primaryStage.setTitle("Creación del Personaje");
        primaryStage.setScene(new Scene(rootCreaPersonaje));
        primaryStage.show();

        stage = primaryStage;
        stage.setResizable(false);
    }

    /**
     * Pinta la casilla en la columna y la fila indicadas con el relleno (Color, Patrón de imagen, etc)
     * 
     * @param c
     * @param f
     * @param relleno
     */
    static private void PintarCasilla(int c, int f, Paint relleno) {
        gridMapa.getChildren();
        // Busca la casilla/rectángulo entre los hijos del GridPane
        for (Node n : gridMapa.getChildren()) {
            if (GridPane.getColumnIndex(n) == c && GridPane.getRowIndex(n) == f) {
                ((Rectangle) n).setFill(relleno);
                break;
            }
        }
    }

    /**
     * 
     * @param tecla
     */
    static private void mover(String tecla) {
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


    static private void cargarMapa() {
        //static int numMapa = 0;
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
                gridMapa.add(rect, col, row);
            }
        }
    }

    /**
     * Prepara la ventana del mapa y lo muestra
     */
    public static void mostrarMapa() {
        stage.setTitle("Escapa del Laberinto!");

        // Etiqueta con la información del personaje.
        lblInfoPersonaje = new Label(p.infoMostrar());
        lblInfoPersonaje.setStyle(
                "-fx-border-color: black; -fx-border-width: 5px; -fx-border-radius: 5px; -fx-padding: 5px;");

        // Mapa en un gridPane
        cargarMapa();


        hBox.getChildren().clear();
        hBox.getChildren().addAll(lblInfoPersonaje, gridMapa);
        Scene escena01 = new Scene(hBox);
        // Captura la pulsación de teclas
        escena01.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
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

                        gridMapa = new GridPane();
                        mapa = Mapa.mapas[numMapa];
                        cargarMapa();
                        /*hBox.getChildren().clear();
                        hBox.getChildren().addAll(lblInfoPersonaje, gridMapa);*/
                        hBox.getChildren().set(1, gridMapa);
                        stage.sizeToScene();
                    }
                }
            }
        });

        stage.setScene(escena01);

        stage.show();
    }

}
