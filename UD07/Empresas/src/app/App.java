package app;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Empresa;

public class App extends Application{

    static public List<Empresa> empresas = new ArrayList<>();

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
