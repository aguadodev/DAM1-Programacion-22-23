package app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Eventos extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lanzando Eventos");

        Button boton = new Button("Haz clic aquí");
        boton.setOnMouseClicked(e -> System.out.println("Has hecho click!"));


        /*** Campo de texto que al presionar las teclas del teclado imprime 
         * un mensaje en consola con el ćodigo de tecla pulsada ***/

        TextField campoTexto = new TextField();
        campoTexto.setOnKeyPressed((KeyEvent evento) -> 
        System.out.println("Se ha pulsado la tecla " + evento.getCode()));

        Scene scene = new Scene(campoTexto, 400, 400);

        /*** Filtro de evento que detiene la propagación de un evento de teclado 
         * cuando el caracter escrito no es un número ***/
        scene.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            if (!Character.isDigit(e.getCharacter().charAt(0))) {
                e.consume();
            }
        });



        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED,  (event) -> {
            System.out.println("Key pressed: " + event.toString());
        
            switch(event.getCode().getCode()) {
                case 27 : { // 27 = ESC key
                    primaryStage.close();
                    break;
                }
                case 10 : { // 10 = Return
                    primaryStage.setWidth( primaryStage.getWidth() * 2);
                }
                default:  {
                    System.out.println("Unrecognized key");
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
}
