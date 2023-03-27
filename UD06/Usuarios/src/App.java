/**
 * App
 */
public class App {

    public static void main(String[] args) {
        GestorUsuarios gestor = new GestorUsuarios();

        Usuario usuario1 = new Usuario("pepito", "123456", true);
        Usuario usuario2 = new Usuario("juanito", "abcdef", false);

        gestor.agregarUsuario(usuario1);
        gestor.agregarUsuario(usuario2);

        gestor.listarUsuarios();

        /*usuario1.nombreUsuario = "pepita";

        gestor.listarUsuarios();*/
        
        Usuario usuarioEncontrado = gestor.buscarUsuario("pepito");

        System.out.println("El usuario encontrado es " + usuarioEncontrado.getNombreUsuario());

        gestor.cambiarContraseña("juanito", "nuevacontraseña");

        gestor.listarUsuarios();
        
        gestor.eliminarUsuario("juanito");

        gestor.listarUsuarios();

    }
}