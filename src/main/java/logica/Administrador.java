package logica;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Administrador {

    private String usuario;
    private String contraseña;
    private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    public Administrador() {
        this.usuario = "Miguel";
        this.contraseña = "123";
    }

    public Administrador(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public static boolean validarPrestamo(String cedula, String idlibro){

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // Verificar si el estudiante existe
            Query<ClaseEstudiante> estudianteQuery = session.createQuery("FROM ClaseEstudiante WHERE cedula = :cedula", ClaseEstudiante.class);
            estudianteQuery.setParameter("cedula", cedula);
            ClaseEstudiante estudiante = estudianteQuery.uniqueResult();

            if (estudiante == null) {
                // El estudiante no existe
                return false;
            }

            // Verificar si el libro existe
            Query<ClaseLibro> libroQuery = session.createQuery("FROM ClaseLibro WHERE idLibro = :idLibro", ClaseLibro.class);
            libroQuery.setParameter("idLibro", idlibro);
            ClaseLibro libro = libroQuery.uniqueResult();

            if (libro == null || libro.getDisponibilidad() == false) {
                // El libro no existe o no está disponible
                return false;
            }

            transaction.commit();

            // Ambos existen, el préstamo es válido
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
