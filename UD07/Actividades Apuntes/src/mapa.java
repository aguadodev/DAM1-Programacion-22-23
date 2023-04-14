import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class mapa extends Application {

    final int FILAS = 10;
    final int COLUMNAS = 20;
    final int CASILLA_SIZE = 50;

    int fila = 5; // Posición del "Personaje"
    int columna = 5;

    GridPane gridPane; // Mapa

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Mapa");

        gridPane = new GridPane();
        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLUMNAS; j++) {
                Rectangle r = new Rectangle(CASILLA_SIZE, CASILLA_SIZE, Color.WHITE);
                r.setStyle("-fx-stroke: black; -fx-stroke-width: 1;");
                if (i == fila && j == columna) {
                    r.setFill(Color.BLUE);
                }
                gridPane.add(r, j, i);
            }

        Scene scene = new Scene(gridPane);

        scene.setOnKeyPressed(e -> mover(e.getCode().getChar().charAt(0)));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mover(char ch) {
        System.out.println(ch);
        switch (ch) {
            case 'W':
                if (fila > 0) {
                    Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rOld.setFill(Color.WHITE);
                    fila--;
                    Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rNew.setFill(Color.BLUE);
                }
                break;
            case 'S':
                if (fila < FILAS - 1) {
                    Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rOld.setFill(Color.WHITE);
                    fila++;
                    Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rNew.setFill(Color.BLUE);
                }
                break;
            case 'A':
                if (columna > 0) {
                    Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rOld.setFill(Color.WHITE);
                    columna--;
                    Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rNew.setFill(Color.BLUE);
                }
                break;
            case 'D':
                if (columna < COLUMNAS - 1) {
                    Rectangle rOld = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rOld.setFill(Color.WHITE);
                    columna++;
                    Rectangle rNew = (Rectangle) (gridPane.getChildren().get(fila * COLUMNAS + columna));
                    rNew.setFill(Color.BLUE);
                }
                break;
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
