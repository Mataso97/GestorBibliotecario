package controladores;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import logica.ClaseEstudiante;
import logica.GestorCuenta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet(name = "RegistroEstudianteServlet", urlPatterns = {"/registroEstudiante"})
public class RegistroEstudianteServlet extends HttpServlet {
    private SessionFactory sessionFactory;

    @Override
    public void init() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String codigo = request.getParameter("codigo");
        String correo = request.getParameter("correo");

        // Crear un nuevo objeto ClaseEstudiante
        ClaseEstudiante estudiante = GestorCuenta.registrarEstudiante(cedula, nombre, direccion, telefono, codigo, correo);

        // Guardar el estudiante utilizando Hibernate
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(estudiante); // Guardar el estudiante en la base de datos
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar el error, por ejemplo, redirigir a una página de error
            response.sendRedirect("error.jsp");
            return;
        }
        // Redireccionar a una página de éxito después de guardar en la base de datos
        response.sendRedirect("index.jsp");
    }

    @Override
    public void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}