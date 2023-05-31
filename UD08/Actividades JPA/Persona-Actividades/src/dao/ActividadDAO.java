package dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Actividad;
import model.Usuario;

public class ActividadDAO {

        private EntityManagerFactory emf;
        private EntityManager em;
    
        public ActividadDAO() {
            emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia"); 
            em = emf.createEntityManager();
        }
    
        public void crearActividad(Actividad actividad) {
            em.getTransaction().begin();
            em.persist(actividad);
            em.getTransaction().commit();
        }
    
        public void actualizarActividad(Actividad actividad) {
            em.getTransaction().begin();
            em.merge(actividad);
            em.getTransaction().commit();
        }
    
        public void eliminarActividad(int id) {
            em.getTransaction().begin();
            Actividad actividad = em.find(Actividad.class, id);
            if (actividad != null) {
                em.remove(actividad);
            }
            em.getTransaction().commit();
        }
    
        public Actividad obtenerActividad(int id) {
            return em.find(Actividad.class, id);
        }
    
        public List<Actividad> obtenerTodasLasActividades() {
            Query query = em.createQuery("SELECT a FROM Actividad a");
            return query.getResultList();
        }
    
        public void cerrarConexion() {
            em.close();
            emf.close();
        }

        public static List<Actividad> getActividades(Usuario usuario) {
            ActividadDAO actividadDAO = new ActividadDAO();
            List<Actividad> actividades = actividadDAO.obtenerTodasLasActividades();
            List<Actividad> actividadesUsuario = new ArrayList<>();
            for (Actividad actividad : actividades) {
                if (actividad.getOrganizador().equals(usuario)) {
                    actividadesUsuario.add(actividad);
                }
            }
            actividadDAO.cerrarConexion();
            return actividadesUsuario;
        }
       
    }
