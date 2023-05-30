package dao;

    import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Usuario;

public class UsuarioDAO {

        private EntityManagerFactory emf;
        private EntityManager em;
    
        public UsuarioDAO() {
            emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia"); 
            em = emf.createEntityManager();
        }
    
        public void crearUsuario(Usuario usuario) {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        }
    
        public void actualizarUsuario(Usuario usuario) {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        }
    
        public void eliminarUsuario(String username) {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, username);
            if (usuario != null) {
                em.remove(usuario);
            }
            em.getTransaction().commit();
        }
    
        public Usuario obtenerUsuario(String username) {
            return em.find(Usuario.class, username);
        }
    
        public List<Usuario> obtenerTodosLosUsuarios() {
            Query query = em.createQuery("SELECT u FROM Usuario u");
            return query.getResultList();
        }
    
        public void cerrarConexion() {
            em.close();
            emf.close();
        }
    }