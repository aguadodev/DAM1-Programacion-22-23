import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EjemplosEventos extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ejemplos de Eventos");

        Scene scene = new Scene(new Label("Hola"), 400, 400);


        scene.setOnContextMenuRequested(e -> System.out.println(e));
        scene.setOnKeyPressed(e -> System.out.println(e));
        scene.setOnKeyReleased(e -> System.out.println(e));
        scene.setOnKeyTyped(e -> System.out.println(e));

        scene.setOnMouseClicked(e -> System.out.println(e));
        scene.setOnMouseEntered(e -> System.out.println(e));
        scene.setOnMouseExited(e -> System.out.println(e));

        




        primaryStage.setScene(scene);
        primaryStage.setOnShowing(e -> System.out.println(e));
        primaryStage.setOnShown(e -> System.out.println(e));
        primaryStage.setOnCloseRequest(e -> System.out.println(e));
        primaryStage.setOnHiding(e -> System.out.println(e));
        primaryStage.setOnHidden(e -> System.out.println(e));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
    
}
