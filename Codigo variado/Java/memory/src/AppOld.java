import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AppOld extends Application {
    static final int FILAS = 4;
    static final int COLS = 4;

    static int[][] tableroOculto;
    static int[][] tableroJugador = new int[FILAS][COLS];  // Almacena las casillas que gana cada jugador. 0 si aún
                                                           // permanecen ocultas.
    // Matriz para tablero en la interfaz gráfica
    static ImageView[][] tablero = new ImageView[FILAS][COLS];
    // Dimensiones de alto y ancho en píxeles de las casillas
    final int ALTO_CASILLA = 200;
    final int ANCHO_CASILLA = 200;

    int turnoJugador = 1;

    Image[] imagenes;
    Image imgReverso;
    static ImageView imageView1, imageView2;
    GridPane gridPane;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Tablero tablero2 = new Tablero();

        /*String[] ficherosImagenes = {
            "img/tren_verde.png",
            "img/tren_de_vapor.png",
            "img/excavadora.png",
            "img/1.png",
            "img/2.png",
            "img/6.png",
            "img/7.png",
            "img/8.png"
        };

        tableroCartas.cargarImagenes(ficherosImagenes);*/

        

        tableroOculto = barajarTablero(8);

        // Carga las imágenes
        imagenes = new Image[8];
        for (int i = 0; i < imagenes.length; i++) {
            imagenes[i] = new Image(new FileInputStream("img/" + i + ".jpeg"));
        };
        imagenes[3] = new Image(new FileInputStream("img/tren_verde.png"));
        imagenes[4] = new Image(new FileInputStream("img/tren_de_vapor.png"));
        imagenes[5] = new Image(new FileInputStream("img/excavadora.png"));
        //

        imgReverso = new Image(new FileInputStream("img/cochesReverso.jpeg"));



        gridPane = new GridPane();

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLS; j++) {
                tablero[i][j] = new ImageView(imgReverso);
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
        scene = new Scene(gridPane, COLS * ANCHO_CASILLA, FILAS * ALTO_CASILLA);
        scene.setFill(Color.ROSYBROWN);
        stage.setScene(scene);
        stage.setTitle("Memory");
        stage.show();
    }

    private int[][] barajarTablero(int numImagenes) {
        int filas = (int) Math.sqrt(numImagenes * 2);
        int cols = (numImagenes * 2) / filas;
        int[][] t = new int[filas][cols];
        // Inicializar tablero
        int indImg = 0;
        for (int i = 0; i < t.length; i++)
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = indImg % numImagenes;
                indImg++;
            }

        // Barajar (recorrer la matriz e intercambiar cada elemento con otro escogido
        // aleatoriamente)
        for (int i = 0; i < t.length; i++)
            for (int j = 0; j < t[0].length; j++) {
                int f = (int) (Math.random() * t.length);
                int c = (int) (Math.random() * t.length);
                int aux = t[i][j];
                t[i][j] = t[f][c];
                t[f][c] = aux;
            }
        return t;
    }


    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent arg0) {
            ImageView imgV = (ImageView) arg0.getSource();
            Image img = imgV.getImage();
            imgV.setStyle("-fx-border: 2px solid; -fx-border-color: red;");
            
            // Si ha marcado la segunda casilla
            if (imageView1 != null && imageView2 != null) {
                int r1 = GridPane.getRowIndex(imageView1);
                int c1 = GridPane.getColumnIndex(imageView1);
                
                // Si no son pareja les da la vuelta de nuevo
                if (tableroJugador[r1][c1] == 0) {
                    imageView1.setImage(imgReverso);
                    imageView2.setImage(imgReverso);
                }
                imageView1 = null;
                imageView2 = null;  
            }

            // Si destapa una nueva casilla
            if (img == imgReverso) {
                destapaCasilla(imgV);


            }
            /*
             * else
             * imgV.setImage(imgReverso)
             */;
        }

        private void destapaCasilla(ImageView imgV) {
            int r = GridPane.getRowIndex(imgV);
            int c = GridPane.getColumnIndex(imgV);
            
            // Destapa la casilla
            imgV.setImage(imagenes[tableroOculto[r][c]]);
            if (imageView1 == null)
                imageView1 = imgV;
            else {
                if (imageView2 == null) {
                    imageView2 = imgV;
                    if (imageView2.getImage() == imageView1.getImage()) {
                        // Pareja!!
                        System.out.println("Pareja!!");
                        r = GridPane.getRowIndex(imageView1);
                        c = GridPane.getColumnIndex(imageView1);
                        tableroJugador[r][c] = turnoJugador;
                        r = GridPane.getRowIndex(imageView2);
                        c = GridPane.getColumnIndex(imageView2);
                        tableroJugador[r][c] = turnoJugador;

                    } else {
                        // No pareja => Volver a tapar
                        System.out.println("No pareja!!");
                        // Se tapan al siguiente click

                    }
                }
            }
        }
    };


    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
