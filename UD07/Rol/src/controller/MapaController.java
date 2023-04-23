package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app2.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Mapa;
import model.Monstruo;
import model.Personaje;

public class MapaController implements Initializable{
    @FXML
    Label lblPersonaje, lblInfo;

    final int CASILLA_SIZE = 40;

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
    static Image imgOrco = new Image("img/orco01.jpeg"); // Imagen del monstruo
    static Image imgTroll = new Image("img/troll01.jpeg"); // Imagen del monstruo
    static Image imgAranha = new Image("img/aranha01.jpeg"); // Imagen del monstruo
    static Image imgDragon = new Image("img/dragon01.jpeg"); // Imagen del monstruo



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Muestra la información del Personaje
        lblPersonaje.setText(App.p.fichaPersonaje());
        lblInfo.setText(null);
        
        // Carga el mapa
        cargarMapa();
        // Genera y distribuye los monstruos en el mapa
        generarMonstruos();

        // Captura la pulsación de teclas en la escena
        App.scene.setOnKeyPressed(e -> manejarTeclaPulsada(e));
    }
    


    private void generarMonstruos() {
        App.mapaMonstruos = new Monstruo[FILAS][COLUMNAS];

        // Cuantos monstruos hay en cada mapa? 
        // Por ejemplo, 1 por cada diez casillas vacías
        int numMonstruos = Mapa.contarCasillasVacias(mapa) / 10;

        // Genera y distribuye los monstruos en el mapa
        for (int i = 0; i < numMonstruos; i++) {
            int fila, col;
            do { // Genera coordenadas aleatorias hasta encontrar una vacía
                fila = (int)(Math.random() * FILAS);
                col = (int)(Math.random() * COLUMNAS);
            } while (mapa[fila][col] != 0 || App.mapaMonstruos[fila][col] != null);

            App.mapaMonstruos[fila][col] = Monstruo.generaMonstruoAleatorio();      
        }
    }



    private void cargarMapa() {
        // Carga en la variable mapa el mapa que corresponde según el índice numMapa
        gridPane.getChildren().clear();
        mapa = Mapa.mapas[numMapa];
        FILAS = mapa.length;
        COLUMNAS = mapa[0].length;

        // Carga el mapa en un GridPane de rectángulos a partir de los datos de mapa
        for (int row = 0; row < FILAS; row++) {
            for (int col = 0; col < COLUMNAS; col++) {

                Rectangle rect = new Rectangle(CASILLA_SIZE, CASILLA_SIZE);

                switch (mapa[row][col]) {
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
        // Ajusta el ancho del gridPane al número de casillas
        gridPane.setMinWidth(COLUMNAS * CASILLA_SIZE);
        gridPane.setMaxWidth(COLUMNAS * CASILLA_SIZE);
        gridPane.setPrefWidth(COLUMNAS * CASILLA_SIZE);

        // Redimensiona la ventana para ajustarla al tamaño del nuevo mapa
        if (gridPane.getScene() != null) {
            gridPane.getScene().getWindow().sizeToScene();
        }
    }







    private void manejarTeclaPulsada(KeyEvent event)
    {
        System.out.println(event.getCode());
        /*lblInfo.setText(lblInfo.getText() + event.getCode().toString());
        lblInfo.getScene().getWindow().sizeToScene();*/


        // Si son AWSD...
        mover(event.getCode().toString());

        // Si se ha movido a la casilla de salida del mapa
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
                // Terminar Juego
                Stage stage = (Stage)gridPane.getScene().getWindow();
                stage.close();
            } else {
                // Si hay más mapas => Carga el siguiente Mapa
                alert.setContentText(
                        "Enhorabuena has escapado del laberinto!! Continúa en el siguiente mapa...");
                alert.showAndWait();

                cargarMapa();
            }
        }
    }


    /**
     * 
     * @param tecla
     */
    private void mover(String tecla) {
        // Obtiene las nuevas coordenadas del personaje
        int cNueva = c, fNueva = f;
        switch (tecla) {
            case "A", "LEFT":
                if (c > 0 && mapa[f][c - 1] != 1) {
                    cNueva--;
                }
                break;
            case "D", "RIGHT":
                if (c < COLUMNAS - 1 && mapa[f][c + 1] != 1) {
                    cNueva++;
                }
                break;
            case "W", "UP":
                if (f > 0 && mapa[f - 1][c] != 1) {
                    fNueva--;
                }
                break;
            case "S", "DOWN":
                if (f < FILAS - 1 && mapa[f + 1][c] != 1) {
                    fNueva++;
                }
                break;
        }

        // Si hay un monstruo en la nueva casilla...
        Monstruo monstruo = App.mapaMonstruos[fNueva][cNueva];
        if (monstruo != null) {
            // Pinta el monstruo en el mapa
            // TODO: Rediseñar usando polimorfismo
            switch (monstruo.getClass().getSimpleName()) {
                case "Orco": 
                    PintarCasilla(cNueva, fNueva, new ImagePattern(imgOrco)); break;
                case "Dragon": 
                    PintarCasilla(cNueva, fNueva, new ImagePattern(imgDragon)); break;
                case "Troll": 
                    PintarCasilla(cNueva, fNueva, new ImagePattern(imgTroll)); break;
                case "Aranha": 
                    PintarCasilla(cNueva, fNueva, new ImagePattern(imgAranha)); break;
            }
            
            // Muestra una ventana emergente con la información
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Monstruo!!!!");
            String txt = monstruo.fichaMonstruo();
            if (monstruo.getVelocidad() > App.p.getAgilidad()){
                int puntos = monstruo.atacar(App.p);
                if (puntos > 0) {
                    txt += "\n\nEl monstruo ha atacado y te ha quitado " + puntos + " de vida";
                    lblPersonaje.setText(App.p.fichaPersonaje());
                    if (!App.p.estaVivo())
                        txt += "\n\nTu personaje ha muerto";
                } else {
                    txt += "\n\nEl monstruo ha atacado pero consigues esquivar o parar el ataque";
                }
            }
            alert.setContentText(txt);

            alert.showAndWait();
        } else {
            moverPersonaje(cNueva, fNueva);
        }        

    }


    /**
     * Pinta al personaje en la nueva casilla. Pinta la casilla vieja de blanco
     * @param cNueva
     * @param fNueva
     */
    private void moverPersonaje(int cNueva, int fNueva) { 
        PintarCasilla(c, f, Color.WHITE);
        c = cNueva; f = fNueva; // Actualiza la posición del personaje
        PintarCasilla(c, f, new ImagePattern(imgPersonaje));          
    }

    /**
     * Pinta la casilla en la columna y la fila indicadas con el relleno (Color, Patrón de imagen, etc)
     * 
     * @param c
     * @param f
     * @param relleno
     */
    private void PintarCasilla(int c, int f, Paint relleno) {
        Rectangle r = (Rectangle) (gridPane.getChildren().get(f * COLUMNAS + c));
        r.setFill(relleno);
    }

}
