import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
        private static Scene scene;
        static final int FILAS = 4;
        static final int COLS = 4;
    
                // Array de JLabel para pintar las casillas en el mapa
        static ImageView[][] mapa = new ImageView[FILAS][COLS];
        // Dimensiones de alto y ancho en píxeles de las casillas
        final int ALTO_CASILLA = 100;
        final int ANCHO_CASILLA = 100;       
    
        @Override
        public void start(Stage stage) throws IOException {

            /*  Proceso de la partida:
            1. Cargar imágenes
            2. Crear, barajar y desordenar matriz
                https://es.stackoverflow.com/questions/296944/como-desordenar-mezclar-barajar-un-array-en-java
            3. Iniciar contador de turnos, jugador inicial
            4. Mostrar tablero
            5. Bucle principal
                6. Aceptar eventos: levantar dos cartas tapadas y comprobar si son iguales.
                7. Comprobar si se han destapado todas las cartas.
            8. Terminar Juego (Repetir?)
            

            */





            //Creating an image 
            Image[] imagenes = {
                new Image(new FileInputStream("img/guerrero01.jpeg")),
                new Image(new FileInputStream("img/elfo01.jpeg")),
                new Image(new FileInputStream("img/enano01.jpeg")),
                new Image(new FileInputStream("img/hobbit01.jpeg")),
                new Image(new FileInputStream("img/orco01.jpeg")),
                new Image(new FileInputStream("img/aranha01.jpeg")),
                new Image(new FileInputStream("img/troll01.jpeg")),
                new Image(new FileInputStream("img/dragon01.jpeg")),
            };
            
            //Setting the image view 
            //ImageView imageView = new ImageView(image);

            GridPane gridPane = new GridPane();
            for (int i = 0; i < FILAS; i++) {
                for (int j = 0; j < COLS; j++) {
                    System.out.println((i + j) % imagenes.length);

                    mapa[i][j] = new ImageView(imagenes[(i + j + 1) % imagenes.length]);
                          //setting the fit height and width of the image view 
                          mapa[i][j].setFitHeight(ALTO_CASILLA); 
                          mapa[i][j].setFitWidth(ANCHO_CASILLA); 
                          
                          //Setting the preserve ratio of the image view 
                          mapa[i][j].setPreserveRatio(true);    

                          EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

                            @Override
                            public void handle(MouseEvent arg0) {
                                ImageView imgV = (ImageView) arg0.getSource();
                                System.out.println(arg0.getSource());
                                try {
                                    imgV.setImage(new Image(new FileInputStream("img/enano02.jpeg")));
                                } catch (FileNotFoundException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                
                            }

                          };
                          mapa[i][j].addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);                

                    gridPane.add(mapa[i][j], i, j, 1, 1);
                }
            }
    
            scene = new Scene(gridPane, 400, 400);
            scene.setFill(Color.ROSYBROWN);
            stage.setScene(scene);
            stage.setTitle("Memory");
            stage.show();        
    }



    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
