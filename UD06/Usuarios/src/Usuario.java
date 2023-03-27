
public class Usuario implements Comparable<Usuario>{
    String nombreUsuario;
    String contraseña;
    Boolean esAdmin;

    public Usuario(String nombreUsuario, String contraseña, Boolean esAdmin) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.esAdmin = esAdmin;
    }

    @Override
    public String toString() {
        return "Usuario [nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña + ", esAdmin=" + esAdmin + "]";
    }

    @Override
    public int compareTo(Usuario o) {
        return nombreUsuario.compareTo(o.nombreUsuario);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }




}
