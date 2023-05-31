package app;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Usuario;

public class App extends Application{
    public static Usuario usuario; // Usuario logueado
    public static Stage stage; // Stage principal
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("App - Inicio");
        primaryStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("/view/Inicio.fxml"))));
        primaryStage.show();
        stage = primaryStage;
    }
    
    public static void main(String[] args) {      
        launch();
    }




}
