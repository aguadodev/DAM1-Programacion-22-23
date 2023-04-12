import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Actividad05 extends Application{
    Scene scene;
    VBox vbox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Cambia color");

        ComboBox<Color> cmbColor = new ComboBox();
        cmbColor.getItems().addAll(
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.CHOCOLATE,	
            Color.CORNSILK,
            Color.DARKKHAKI,
            Color.DARKMAGENTA,
            Color.DARKOLIVEGREEN            
            );
        

        Button btnCambiarColor = new Button("Cambiar Color");
        btnCambiarColor.setOnAction(e -> cambiarColor(cmbColor.getValue()));

        vbox = new VBox(10, cmbColor, btnCambiarColor);

        scene = new Scene(vbox, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void cambiarColor(Color color) {
        vbox.setBackground(new Background(new BackgroundFill(color, null, null)));
        System.out.println(color);
    }

    public static void main(String[] args) {
        launch();
    }
}
