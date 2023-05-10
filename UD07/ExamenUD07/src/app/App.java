package app;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Usuario;

public class App extends Application{

    public static List<Usuario> usuarios = new ArrayList<>();
    public static Usuario usuario;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Usuarios");
        primaryStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("/view/Inicio.fxml"))));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }


    static public void guardarUsuarios() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Usuarios.dat"))) {
            out.writeObject(usuarios);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al escribir en Usuarios.dat");
        }
    }

    static public void cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Usuarios.dat"))) {
            usuarios = (ArrayList<Usuario>) in.readObject();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("El fichero Usuarios.dat no existe");
        }
    }


}
