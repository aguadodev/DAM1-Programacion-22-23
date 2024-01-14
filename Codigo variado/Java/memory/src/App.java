import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
    Tablero t;

    // private static Scene scene; // Escena que contendrá la rejilla
    GridPane gridPane; // Rejilla para visualizar el tablero de imágenes
    Label lblAyuda;
    static ImageView[][] tablero; // Matriz de "vistas" de imágenes que se mostrarán al jugador

    final int ALTO_CASILLA = 200; // Dimensiones de alto y ancho en píxeles de las casillas
    final int ANCHO_CASILLA = 200;

    static ImageView imageViewAnterior, imageViewActual;

    int turnoJugador = 1; // Almacena el número del primer (y por ahora único) jugador
    static int[][] tableroJugador; // Marca las casillas emparejadas con el número del jugador

    int numClicks = 0; // Cuenta el número de clicks que se han hecho en el juego

    @Override
    public void start(Stage stage) throws IOException {
        // Crea e inicializa el tablero de imágenes ocultas.
        t = new Tablero(eligeTablero(null));    

        stage.setScene(createScene());
        stage.setResizable(false);
        stage.setTitle("Memory");
        stage.show();
    }

    private Scene createScene() throws FileNotFoundException {
        // Inicializa las variables para el siguiente juego
        imageViewAnterior = null;
        imageViewActual = null;
        turnoJugador = 1; // Almacena el número del primer (y por ahora único) jugador
        numClicks = 0; // Cuenta el número de clicks que se han hecho en el juego

        // Crea e inicializa las "vistas" de imágenes
        gridPane = new GridPane();
        for (int i = 0; i < t.FILAS; i++) {
            for (int j = 0; j < t.COLS; j++) {
                // Crea la "vista" de cada casilla y la inicializa a la imagen de reverso
                ImageView imageView = new ImageView(t.getImgReverso());
                imageView.setFitHeight(ALTO_CASILLA);
                imageView.setFitWidth(ANCHO_CASILLA);

                imageView.setOnMouseClicked(eventHandler);
                gridPane.add(imageView, i, j);
            }
        }

        // Crea e inicia el tablero de casillas conseguidas por cada jugador
        tableroJugador = new int[t.FILAS][t.COLS];

        // Crea y configura la escena y muestra el escenario.
        lblAyuda = new Label("Haz click en una casilla para comenzar a Jugar");
        VBox vBox = new VBox(gridPane, lblAyuda);
        Scene scene = new Scene(vBox);
        return scene;
    }

    /**
     * TODO: Muestra un cuadro de diálogo para que el jugador elija el tablero
     * 
     * @return
     */
    private String eligeTablero(Stage stage) {
        // Ruta del directorio
        String rutaDirectorio = "./src/img";
        File[][] imgFiles = null;

        // Crear un objeto File con la ruta del directorio
        File directorio = new File(rutaDirectorio);

        // Verificar si el directorio existe
        if (directorio.exists() && directorio.isDirectory()) {
            // Obtener la lista de archivos en el directorio
            File[] archivos = directorio.listFiles();

            // Verificar si hay archivos en el directorio
            if (archivos != null) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.initModality(Modality.WINDOW_MODAL);
                alert.initOwner(stage);
                alert.setTitle("Imágenes disponibles");
                alert.setHeaderText("Elige el juego de imágenes con las que quieres jugar.");

                // Imprimir los nombres de los archivos en el directorio
                System.out.println("Contenido del directorio " + rutaDirectorio + ":");
                imgFiles = new File[archivos.length][];
                for (int i = 0; i < archivos.length; i++) {
                    System.out.print(archivos[i].getName());
                    if (archivos[i].isDirectory()) {

                        // Agrega botones al cuadro de diálogo
                        ButtonType boton = new ButtonType(archivos[i].getName());
                        alert.getButtonTypes().add(boton);

                        // Muestra el cuadro de diálogo y devuelve true si respondió que sí
                        imgFiles[i] = archivos[i].listFiles();
                    }
                }
                ButtonType boton = alert.showAndWait().get();
                if (boton != null) {
                    return boton.getText();
                }
                // .filter(response -> response == botonSi).isPresent();

            } else {
                System.out.println("El directorio está vacío.");
            }
        } else {
            System.out.println("El directorio no existe o no es un directorio válido.");
        }
        System.out.println();
        return null;

    }

    /**
     * Event handler para el evento de pulsación de una imagen
     */
    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            System.out.println("Click");
            if (imageViewActual != null && imageViewAnterior != null) {
                // Las dos cartas están destapadas
                System.out.println("Las dos cartas están destapadas");
                return; // Sale del método sin hacer nada, toca esperar
            }

            // Obtiene la ImageView del evento
            ImageView imageView = (ImageView) event.getSource();

            if (imageView.getImage() != t.getImgReverso()) {
                // Si la imagen ya está destapada no hace nada
                System.out.println("La imagen ya está destapada");
                return;
            }

            numClicks++; // Incrementa el número de clicks

            System.out.println("Destapa la casilla");
            // Obtiene las coordenadas de la imagen pulsada
            int f = GridPane.getRowIndex(imageView);
            int c = GridPane.getColumnIndex(imageView);

            // Destapa la casilla cambiando la imagen
            imageView.setImage(t.getTableroOculto()[f][c]);

            if (imageViewActual == null) {
                // Se destapa la primera carta del turno
                System.out.println("Primera carta del turno");
                imageViewActual = imageView;
                lblAyuda.setText("Busca la pareja haciendo click en otra casilla");

            } else if (imageViewAnterior == null) {
                // Se destapa la segunda carta del turno
                System.out.println("Segunda carta del turno");
                imageViewAnterior = imageViewActual;
                imageViewActual = imageView;

                if (imageViewActual.getImage() != imageViewAnterior.getImage()) {
                    // Si las imágenes no coinciden => No son Pareja!!
                    System.out.println("No son pareja!!");
                    lblAyuda.setText("No son pareja!! Haz click para destapar una nueva casilla.");

                    // Realiza una pausa de 2 segundos antes de tapar las casillas
                    PauseTransition pausa = new PauseTransition(Duration.millis(2000));
                    pausa.setOnFinished(e -> {
                        // Vuelve a tapar las casillas
                        System.out.println("Tapando las casillas");
                        imageViewAnterior.setImage(t.getImgReverso());
                        imageViewActual.setImage(t.getImgReverso());
                        // Reinicia las variables para el siguiente turno
                        imageViewAnterior = null;
                        imageViewActual = null;
                    });
                    pausa.play();

                } else {
                    // Si la imagen es igual a la destapada anteriormente => Pareja!!
                    System.out.println("Pareja!!");
                    lblAyuda.setText("Pareja encontrada!! Enhorabuena!!");

                    // Marca las casillas en tableroJugador como conseguidas por el jugador
                    tableroJugador[f][c] = turnoJugador;
                    f = GridPane.getRowIndex(imageViewAnterior);
                    c = GridPane.getColumnIndex(imageViewAnterior);
                    tableroJugador[f][c] = turnoJugador;

                    if (tableroResuelto()) {
                        System.out.println("Fin del Juego");
                        Stage stage = (Stage) imageViewActual.getScene().getWindow();
                        alertFinJuego(stage);

                        if (alertJugarOtraVez(stage)) {
                            // Crea e inicializa el tablero de imágenes ocultas.
                            t = new Tablero(eligeTablero(stage));                              
                            // Reiniciar Juego
                            t.barajarImagenes();
                            try {
                                stage.setScene(createScene());
                            } catch (FileNotFoundException e) {
                                System.out.println("Error al crear las imágenes.");
                            }
                        } else {
                            stage.close(); // Termina el programa
                        }
                    } else {
                        System.out.println("Tapando las casillas");
                        imageViewAnterior = null;
                        imageViewActual = null;
                    }
                }
            }
        }

        /**
         * Comprueba si se han destapado todas las casillas
         * 
         * @return
         */
        private boolean tableroResuelto() {
            boolean fin = true;
            for (int i = 0; i < tableroJugador.length; i++)
                for (int j = 0; j < tableroJugador[i].length; j++) {
                    if (tableroJugador[i][j] == 0)
                        fin = false;
                }

            return fin;
        }

        /**
         * Muestra un cuadro de diálogo de Fin del Juego con el número de clicks
         * realizados
         * 
         * @param stage
         */
        private void alertFinJuego(Stage stage) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initModality(Modality.WINDOW_MODAL);
            alert.initOwner(stage);
            alert.setHeaderText(null);
            alert.setTitle("Enhorabuena!!!!");
            alert.setContentText("Has descubierto el tablero en " + numClicks + " clicks!!");
            alert.showAndWait();
        }

        /**
         * Pregunta al jugador si quiere jugar otra vez
         * 
         * @param stage
         * 
         * @return boolean
         */
        private boolean alertJugarOtraVez(Stage stage) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initModality(Modality.WINDOW_MODAL);
            alert.initOwner(stage);
            alert.setTitle("Otra partida?");
            alert.setHeaderText("¿Quieres jugar otra vez?");

            // Agrega botones de Sí y No al cuadro de diálogo
            ButtonType botonSi = new ButtonType("Sí");
            ButtonType botonNo = new ButtonType("No");
            alert.getButtonTypes().setAll(botonSi, botonNo);

            // Muestra el cuadro de diálogo y devuelve true si respondió que sí
            return alert.showAndWait().filter(response -> response == botonSi).isPresent();
        }

    };

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
