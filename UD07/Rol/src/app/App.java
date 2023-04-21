package app;
<<<<<<< HEAD

import java.io.IOException;
import java.net.MalformedURLException;
=======
import java.io.IOException;
>>>>>>> 1facfbc70ec1511d3f4e97a0300976f91dfbd04c

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
<<<<<<< HEAD

public class App extends Application{

    static Scene scene;
=======
import javafx.scene.Node;

public class App extends Application{

    private static Scene scene;
>>>>>>> 1facfbc70ec1511d3f4e97a0300976f91dfbd04c

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Juego de Rol");
<<<<<<< HEAD
                
        Parent root = FXMLLoader.load(getClass().getResource("/view/Inicio.fxml"));

        scene = new Scene(root);
=======

        scene = new Scene(new FXMLLoader(App.class.getResource("../view/Inicio.fxml")).load());
>>>>>>> 1facfbc70ec1511d3f4e97a0300976f91dfbd04c
        primaryStage.setScene(scene);
        primaryStage.show();
    }

<<<<<<< HEAD
=======
    public static void cargarFXML(String fxml) throws IOException {
        // Instanciando un objeto FXMLLoader
        //FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("../view/" + fxml + ".fxml"));

        // Usando el método estático load() de FXMLLoader
        scene.setRoot(FXMLLoader.load(App.class.getResource("/view/" + fxml + ".fxml")));
        scene.getWindow().sizeToScene();
    }   
>>>>>>> 1facfbc70ec1511d3f4e97a0300976f91dfbd04c
    public static void main(String[] args) {
        launch();
    }

<<<<<<< HEAD
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
=======
 
>>>>>>> 1facfbc70ec1511d3f4e97a0300976f91dfbd04c
}
