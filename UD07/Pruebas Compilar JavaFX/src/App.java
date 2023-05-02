import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("App de pruebas");

        TextField textField = new TextField("Escribe tu nombre...");
        Button button = new Button("Púlsame");
        Label label = new Label();

        button.setOnAction(e -> label.setText("Hola " + textField.getText()));

        Parent root = new VBox(5, textField, button, label);

        Scene scene = new Scene(root, 300, 100);

        stage.setScene(scene);

        stage.show();
    }
}
