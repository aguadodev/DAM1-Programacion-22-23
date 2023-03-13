import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    Tablero t;
    boolean esperarClick = false;
    
    int turnoJugador = 1;           // Almacena el número del primer (y por ahora único) jugador
    static int[][] tableroJugador; // Marca las casillas emparejadas con el número del jugador

    private static Scene scene;     // Escena que contendrá la rejilla
    GridPane gridPane;              // Rejilla para visualizar el tablero de imágenes
    static ImageView[][] tablero;   // Matriz de "vistas" de imágenes que se mostrarán al jugador
    
    final int ALTO_CASILLA = 200;   // Dimensiones de alto y ancho en píxeles de las casillas
    final int ANCHO_CASILLA = 200;  

    static ImageView imageView1, imageView2; // "Vistas" e imágenes para recordar la pareja descubierta
    

    @Override
    public void start(Stage stage) throws IOException {
        // Crea e inicializa el tablero.
        t = new Tablero();

        // Crea e inicia el tablero de casillas conseguidas por cada jugador
        tableroJugador = new int[t.FILAS][t.COLS]; 

        tablero = new ImageView[t.FILAS][t.COLS];

        gridPane = new GridPane();

        for (int i = 0; i < t.FILAS; i++) {
            for (int j = 0; j < t.COLS; j++) {
                tablero[i][j] = new ImageView(t.getImgReverso());
                // setting the fit height and width of the image view
                tablero[i][j].setFitHeight(ALTO_CASILLA);
                tablero[i][j].setFitWidth(ANCHO_CASILLA);
                // Setting the preserve ratio of the image view
                tablero[i][j].setPreserveRatio(true);

                tablero[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

                gridPane.add(tablero[i][j], i, j, 1, 1);
            }
        }

        //FlowPane pane = new FlowPane();

        // Crea y configura la escena y muestra el escenario.
        scene = new Scene(gridPane, t.COLS * ANCHO_CASILLA, t.FILAS * ALTO_CASILLA);
        scene.setFill(Color.ROSYBROWN);
        stage.setScene(scene);
        stage.setTitle("Memory");
        stage.show();
    }


    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent arg0) {

            if (esperarClick) {
                esperarClick = false;
                imageView1.setImage(t.getImgReverso());
                imageView2.setImage(t.getImgReverso());
                imageView1 = null;
            }

            // Obtiene la ImageView del evento, y sus coordenadas
            ImageView imgV = (ImageView) arg0.getSource();
            Image img = imgV.getImage();
            if (img == t.getImgReverso()) {
                destapaCasilla(imgV);
                int f = GridPane.getRowIndex(imgV);
                int c = GridPane.getColumnIndex(imgV);

                if (imageView1 == null) {
                    // Si está destapando la primera casilla del turno la guarda
                    imageView1 = imgV;
                } else {
                    // Si está destapando la segundo compara con la primera
                    if (imgV.getImage() == imageView1.getImage()) {
                        // Pareja!!
                        //AnotarPareja();
                        System.out.println("Pareja!!");
                        tableroJugador[f][c] = turnoJugador;
                        f = GridPane.getRowIndex(imageView1);
                        c = GridPane.getColumnIndex(imageView1);
                        tableroJugador[f][c] = turnoJugador;    
                        imageView1 = null;

                        if (comprobarFin()){
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setTitle("Enhorabuena!!!!");
                            alert.setContentText("Enhorabuena has descubierto el tablero!!");
                            alert.showAndWait();
                            
                            // Termina el programa
                            Stage stage = (Stage) imgV.getScene().getWindow();
                            stage.close();
                        }
                        
                    } else {
                        // No Pareja!!
                        // esperar click y volver a tapar
                        imageView2 = imgV;
                        esperarClick = true;
                    }
                }

            }

        }

        private boolean comprobarFin() {
            boolean fin = true;
            for(int i = 0; i < tableroJugador.length; i++)
                for(int j = 0; j < tableroJugador[i].length; j++){
                    if (tableroJugador[i][j] == 0)
                        fin = false;
                }
            
                return fin;                            
        }

        private void destapaCasilla(ImageView imgV) {
            int r = GridPane.getRowIndex(imgV);
            int c = GridPane.getColumnIndex(imgV);
            
            // Destapa la casilla
            imgV.setImage(t.getTableroOculto()[r][c]);
        }
    };


    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
