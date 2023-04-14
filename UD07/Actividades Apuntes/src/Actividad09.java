import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Actividad09 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tablero");
        
        ImageView img1 = new ImageView(new Image("img/1-2.jpeg"));
        img1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Has hecho click en la imagen 1-2"));

        ImageView img2 = new ImageView(new Image("img/3-4.jpeg"));
        img1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Has hecho click en la imagen 3-4"));

        //img1.setOnMouseClicked(e -> System.out.println("Has hecho click en la imagen 1-2"));
        VBox vBox = new VBox(img1, img2);
        vBox.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Has hecho click en la VBox"));

        Scene scene = new Scene(vBox);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> System.out.println("Has hecho click en la escena"));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}