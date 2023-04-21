package app;

import java.io.IOException;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Juego de Rol");
                
        Parent root = FXMLLoader.load(getClass().getResource("/view/Inicio.fxml"));

        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void cargarEscena(String fxml) {
        Parent root;
        try {
            root = FXMLLoader.load(App.class.getResource("/view/" + fxml + ".fxml"));
            scene.setRoot(root);
            scene.getWindow().sizeToScene();            
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }    
}
