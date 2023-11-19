package logica;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libro", schema = "gestorbibliotecario")
public class ClaseLibro {
    @Id
    @Column(name = "idLibro", nullable = false, length = 3)
    private String idLibro;
    @Basic
    @Column(name = "titulo", nullable = true, length = 255)
    private String titulo;
    @Basic
    @Column(name = "autor", nullable = true, length = 255)
    private String autor;
    @Basic
    @Column(name = "genero", nullable = true, length = 255)
    private String genero;
    @Basic
    @Column(name = "disponibilidad", nullable = true)
    private Boolean disponibilidad;

    public ClaseLibro() {
    }

    public ClaseLibro(String idLibro, String titulo, String autor, String genero, Boolean disponibilidad) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponibilidad = disponibilidad;
    }

    private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public static List<ClaseLibro> verificarLibrosDisponibles(List<ClaseLibro> listaLibros) {
        List<ClaseLibro> librosValidos = new ArrayList<>();

        for (ClaseLibro libro : listaLibros) {
            if (libro.getDisponibilidad()) {
                librosValidos.add(libro);
            }
        }
        return librosValidos;
    }

    public static boolean cambiarDisponibilidadLibro(String idlibro){
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            ClaseLibro libro = getLibro(idlibro, session);

            // Cambiar la disponibilidad
            String updateQuery = "UPDATE ClaseLibro SET disponibilidad = :nuevaDisponibilidad WHERE idLibro = :idLibro";

            int actualizacion = session.createQuery(updateQuery).setParameter("nuevaDisponibilidad", !libro.getDisponibilidad()).setParameter("idLibro", idlibro).executeUpdate();

            transaction.commit();

            // Verificar si la actualización fue exitosa
            if (actualizacion > 0) {
                return true;
            } else {
                return false;
            }
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

    public static ClaseLibro getLibro(String idlibro, Session session) {
        Query<ClaseLibro> libroQuery = session.createQuery ("FROM ClaseLibro WHERE idLibro = :idLibro", ClaseLibro.class);
        libroQuery.setParameter("idLibro", idlibro);
        ClaseLibro libro = libroQuery.uniqueResult();
        return libro;
    }

}