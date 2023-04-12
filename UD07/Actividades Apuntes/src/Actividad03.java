import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Actividad03 extends Application{

    TextField txtNum1;
    TextField txtNum2;
    Label lblResultado;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Suma de dos números");

        Label label1 = new Label("Número 1:");
        Label label2 = new Label("Número 2:");
        lblResultado = new Label();

        txtNum1 = new TextField("Escribe un número");
        txtNum2 = new TextField("Escribe un número");

        Button btnSumar = new Button("Sumar");
        btnSumar.setOnAction(event -> sumar());

        HBox hbox1 = new HBox(5, label1, txtNum1);
        HBox hbox2 = new HBox(5, label2, txtNum2);

        VBox vbox = new VBox(5, hbox1, hbox2, btnSumar, lblResultado);

        Scene scene = new Scene(vbox, 250, 120);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    
    private void sumar() {
        System.out.println(txtNum1.getText() + " + " + txtNum2.getText());
        try {
            int suma = Integer.parseInt(txtNum1.getText()) + Integer.parseInt(txtNum2.getText());
            lblResultado.setText("La suma es " + suma);
        } catch (NumberFormatException e) {
            lblResultado.setText("No puedo sumnar eso...");
        }
    }
    
    
}
