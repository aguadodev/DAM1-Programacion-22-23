package app;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    static EntityManagerFactory emf;
    static EntityManager em;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Personas");
        primaryStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("/view/Persona.fxml"))));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        // Este código cargará la unidad de persistencia, conectará con la base de datos remota y
        // creará, si no existe, el esquema definido por las clases persistentes, es decir,
        // Creará la tabla Persona mapeada con la clase Persona.
        /*emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
        em = emf.createEntityManager();    */     
        launch();
    }




}
