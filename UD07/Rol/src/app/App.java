package app;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class App extends Application{

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Juego de Rol");

        scene = new Scene(new FXMLLoader(App.class.getResource("../view/Inicio.fxml")).load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void cargarFXML(String fxml) throws IOException {
        // Método 1: Instanciando un objeto FXMLLoader
        //FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("../view/" + fxml + ".fxml"));

        // Método 2: Usando el método estático load() de FXMLLoader
        scene.setRoot(FXMLLoader.load(App.class.getResource("/view/" + fxml + ".fxml")));
        scene.getWindow().sizeToScene();
    }   
    public static void main(String[] args) {
        launch();
    }

 
}
