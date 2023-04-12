package app;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class App extends Application{
    static Stage stage;


    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage; // Guarda la referencia a la ventana principal en una variable estática global.
        primaryStage.setTitle("Ventana inicial");
        Parent root = FXMLLoader.load(getClass().getResource("../view/inicio.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void cargarEscena(String titulo, Scene scene){
        stage.setTitle(titulo);
        stage.setScene(scene);
    }
}
