import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Actividad06 extends Application{
    Scene scene;
    VBox vbox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Concatena textos");

        TextField txt = new TextField("Escribe un texto para añadir a la lista");
        Button btnAdd = new Button("Añadir...");
        TextArea txtArea = new TextArea();


        btnAdd.setOnAction(e -> txtArea.setText(txtArea.getText() + txt.getText() + "\n"));

        vbox = new VBox(10, txt, btnAdd, txtArea);
        scene = new Scene(vbox, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
