package app;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Empresas");
        primaryStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("/view/Empresa.fxml"))));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }

}
