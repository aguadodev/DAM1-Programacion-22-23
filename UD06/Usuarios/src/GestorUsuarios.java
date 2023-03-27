import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestorUsuarios {
    List<Usuario> usuarios = new ArrayList<>();
    Set<String> nombresUsuario = new HashSet<>();
    Map<String, Usuario> mapaUsuarios = new HashMap<>();

    public boolean agregarUsuario(Usuario usuario1) {
        boolean nuevo = nombresUsuario.add(usuario1.nombreUsuario);
        if (nuevo) {
            usuarios.add(usuario1);
            mapaUsuarios.put(usuario1.nombreUsuario, usuario1);
        }
        return nuevo;
    }

    public void listarUsuarios() {
        System.out.println();
        System.out.println(usuarios);
        System.out.println(nombresUsuario);
        System.out.println(mapaUsuarios);
        System.out.println();
    }

    public Usuario buscarUsuario(String string) {
        return mapaUsuarios.get(string);
    }

    public boolean cambiarContraseña(String nombreUsuario, String password) {
        Usuario user = mapaUsuarios.get(nombreUsuario);
        if (user != null) {
            user.contraseña = password;
            return true;
        } else
            return false;
    }

    public boolean eliminarUsuario(String nombreUsuario) {
        Usuario user = mapaUsuarios.get(nombreUsuario);

        if (user != null) {
            nombresUsuario.remove(nombreUsuario);
            usuarios.remove(user);
            mapaUsuarios.remove(nombreUsuario);
            return true;
        } else
            return false;        
    }
}
