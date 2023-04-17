import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class mapa extends Application {
    final int CASILLA_SIZE = 50;

    int[][] laberinto2 = {
        {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 3}
    };  
    
    int[][] laberinto = {
        {2, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
        {0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0},
        {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1},
        {0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1},
        {0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0},
        {1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1},
        {0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 3},
        {1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1}
    };    

    int[][][] laberintos = {
        laberinto,
        laberinto2
    };
    int numLaberinto = 0;
    

    int FILAS;
    int COLUMNAS;    

    int fila; // Posición del "Personaje"
    int columna;

    GridPane gridPane; // Mapa
    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("Mapa");

        gridPane = generaGridInicial(laberintos[numLaberinto]);

        Label lblEstado = new Label("Usa AWSD para mover");
            
        VBox vbox = new VBox(gridPane, lblEstado);
        
        Scene scene = new Scene(vbox);

        scene.setOnKeyPressed(e -> mover(e.getCode().getChar().charAt(0)));

        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    private GridPane generaGridInicial(int[][] laberinto) {
        gridPane = new GridPane();
        FILAS = laberinto.length;
        COLUMNAS = laberinto[0].length;            
        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLUMNAS; j++) {
                Rectangle r = new Rectangle(CASILLA_SIZE, CASILLA_SIZE, Color.WHITE);
                r.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                if (i == fila && j == columna) {
                    r.setFill(Color.BLUE);
                }
                switch(laberinto[i][j]) {
                    case 0: r.setFill(Color.WHITE); break;
                    case 1: r.setFill(Color.BLACK); break;
                    case 2: 
                        r.setFill(Color.BLUE); 
                        fila = i; // Posición del "Personaje"
                        columna = j;                        
                    break;
                    case 3: r.setFill(Color.GREEN); break;

                }
                gridPane.add(r, j, i);
            }        
        return gridPane;
    }


    private void mover(char ch) {
        System.out.println(ch);
        switch (ch) {
            case 'W':
                if (fila > 0 && laberintos[numLaberinto][fila - 1][columna] != 1) {
                    Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rOld.setFill(Color.WHITE);
                    fila--;
                    Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rNew.setFill(Color.BLUE);
                }
                break;
            case 'S':
                if (fila < FILAS - 1 && laberintos[numLaberinto][fila + 1][columna] != 1) {
                    Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rOld.setFill(Color.WHITE);
                    fila++;
                    Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rNew.setFill(Color.BLUE);
                }
                break;
            case 'A':
                if (columna > 0  && laberintos[numLaberinto][fila][columna - 1] != 1) {
                    Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rOld.setFill(Color.WHITE);
                    columna--;
                    Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rNew.setFill(Color.BLUE);
                }
                break;
            case 'D':
                if (columna < COLUMNAS - 1 && laberintos[numLaberinto][fila][columna + 1] != 1) {
                    Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rOld.setFill(Color.WHITE);
                    columna++;
                    Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rNew.setFill(Color.BLUE);
                }
                break;
        }
        if (laberintos[numLaberinto][fila][columna] == 3){
            mostrarDialogoFin();
            if (numLaberinto < laberintos.length - 1){
                numLaberinto++;
                gridPane = generaGridInicial(laberintos[numLaberinto]);
            } else {
                stage.close();
            }
            
        }
    }

    /**
     * Muestra el cuadro de diálogo de fin de juego
     */
    private void mostrarDialogoFin(){
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Enhorabuena!!");
        dialog.setContentText("Has llegado a la casilla final del mapa!!");
        dialog.getDialogPane().getButtonTypes().add(new ButtonType("OK"));
        dialog.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }

}
