import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Actividad04 extends Application{
    Scene scene;
    VBox vbox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Cambia color");

        TextField txtColor = new TextField("Escribe el color (en inglés)");
        Button btnCambiarColor = new Button("Cambiar Color");
        btnCambiarColor.setOnAction(e -> cambiarColor(txtColor.getText()));

        vbox = new VBox(10, txtColor, btnCambiarColor);

        scene = new Scene(vbox, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void cambiarColor(String text) {
        //scene.setFill(Color.valueOf(text));
        //vbox.setStyle("-fx-background-color:" + text);
        vbox.setBackground(new Background(new BackgroundFill(Color.valueOf(text), null, null)));
        System.out.println(Color.valueOf(text));
    }

    public static void main(String[] args) {
        launch();
    }
}
