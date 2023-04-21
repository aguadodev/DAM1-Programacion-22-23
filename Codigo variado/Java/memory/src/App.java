import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    Tablero t;

    //private static Scene scene;     // Escena que contendrá la rejilla
    GridPane gridPane;              // Rejilla para visualizar el tablero de imágenes
    Label lblAyuda;    
    static ImageView[][] tablero;   // Matriz de "vistas" de imágenes que se mostrarán al jugador
    
    final int ALTO_CASILLA = 200;   // Dimensiones de alto y ancho en píxeles de las casillas
    final int ANCHO_CASILLA = 200;  

    static ImageView imageView1, imageView2; // "Vistas" e imágenes para recordar la pareja descubierta
    boolean esperarClick = false;
    
    int turnoJugador = 1;           // Almacena el número del primer (y por ahora único) jugador
    static int[][] tableroJugador; // Marca las casillas emparejadas con el número del jugador    

    @Override
    public void start(Stage stage) throws IOException {
        // Crea e inicializa el tablero de imágenes ocultas.
        t = new Tablero();

        // Crea e inicializa las "vistas" de imágenes
        gridPane = new GridPane();
        for (int i = 0; i < t.FILAS; i++) {
            for (int j = 0; j < t.COLS; j++) {
                // Crea la  "vista" de cada casilla y la inicializa a la imagen de reverso
                ImageView imageView = new ImageView(t.getImgReverso());
                imageView.setFitHeight(ALTO_CASILLA);
                imageView.setFitWidth(ANCHO_CASILLA);

                imageView.setOnMouseClicked(eventHandler);
//                imageView.setOnMouseClicked(e -> imgPulsada(imageView));

                gridPane.add(imageView, i, j);
            }
        }

        // Crea e inicia el tablero de casillas conseguidas por cada jugador
        tableroJugador = new int[t.FILAS][t.COLS]; 

        // Crea y configura la escena y muestra el escenario.
        lblAyuda = new Label("Haz click en una casilla para comenzar a Jugar");
        VBox vBox = new VBox(gridPane, lblAyuda);
        Scene scene = new Scene(vBox);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Memory");
        stage.show();
    }


    private void imgPulsada(ImageView imageView) {
        Image img = imageView.getImage();

        // Es la primera imagen de la pareja?

        // 1. Pulsa en una imagen tapada => La destapa y la muestra

        // 2. Pulsa en una imagen destapada => La descarta

        // 
    }


    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {

            if (esperarClick) {
                esperarClick = false;
                imageView1.setImage(t.getImgReverso());
                imageView2.setImage(t.getImgReverso());
                imageView1 = null;
            }

            // Obtiene la ImageView del evento, y sus coordenadas
            ImageView imgV = (ImageView) event.getSource();
            Image img = imgV.getImage();
            if (img == t.getImgReverso()) {
                destapaCasilla(imgV);
                int f = GridPane.getRowIndex(imgV);
                int c = GridPane.getColumnIndex(imgV);

                if (imageView1 == null) {
                    // Si está destapando la primera casilla del turno la guarda
                    imageView1 = imgV;
                    lblAyuda.setText("Busca la pareja haciendo click en otra casilla");
                } else {
                    // Si está destapando la segunda compara con la primera
                    if (imgV.getImage() == imageView1.getImage()) {
                        // Pareja!!
                        //AnotarPareja();
                        System.out.println("Pareja!!");
                        lblAyuda.setText("Pareja encontrada!! Enhorabuena!!");

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
                        lblAyuda.setText("No son pareja!! Haz click para destapar una nueva casilla.");
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
