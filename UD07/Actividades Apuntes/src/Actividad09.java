import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Actividad09 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tablero");
        
        ImageView img1 = new ImageView(new Image("img/1-2.jpeg"));
        img1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Has hecho click en la imagen 1-2"));

        ImageView img2 = new ImageView(new Image("img/3-4.jpeg"));
        img2.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Has hecho click en la imagen 3-4"));

        /*** Campo de texto que al presionar las teclas del teclado imprime 
        * un mensaje en consola con el ćodigo de tecla pulsada ***/
        TextField campoTexto = new TextField();
        campoTexto.setOnKeyPressed((KeyEvent evento) -> 
        System.out.println("Se ha pulsado la tecla " + evento.getCode()));

        //img1.setOnMouseClicked(e -> System.out.println("Has hecho click en la imagen 1-2"));
        VBox vBox = new VBox(campoTexto, img1, img2);
        vBox.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Has hecho click en la VBox"));

        Scene scene = new Scene(vBox);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Has hecho click en la escena"));


        /*** Filtro de evento que detiene la propagación de un evento de teclado 
         * cuando el caracter escrito no es un número ***/
        scene.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            if (!Character.isDigit(e.getCharacter().charAt(0))) {
                e.consume();
            }
        });

        primaryStage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, e -> {Stage s = new Stage(); s.show(); e.consume();});
        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Has hecho click en la Ventana"));
        primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {System.out.println("FILTRO - Has hecho click en la Ventana"); e.consume();});

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}