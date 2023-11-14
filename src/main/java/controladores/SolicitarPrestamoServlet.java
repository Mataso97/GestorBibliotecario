package controladores;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import logica.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet(name = "SolicitarPrestamoServlet", urlPatterns = {"/solicitarPrestamo"})
public class SolicitarPrestamoServlet extends HttpServlet {
    private SessionFactory sessionFactory;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void init() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Session session = sessionFactory.openSession();

        List<ClaseEstudiante> listaEstudiante = session.createQuery("FROM ClaseEstudiante ", ClaseEstudiante.class).getResultList();
        List<ClaseLibro> listaLibros = session.createQuery("FROM ClaseLibro ", ClaseLibro.class).getResultList();
        List<ClasePrestamo> listaPrestamo = session.createQuery("FROM ClasePrestamo ", ClasePrestamo.class).getResultList();

        session.close();

        HttpSession sesion = req.getSession();
        sesion.setAttribute("listaEstudiantes", listaEstudiante);
        sesion.setAttribute("listaLibros", listaLibros);
        sesion.setAttribute("listaPrestamos", listaPrestamo);

        response.sendRedirect("solicitarPrestamo.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cedula = request.getParameter("cedula");
        String idLibro = request.getParameter("idLibro");
        Date fechaPrestamo = Date.valueOf(LocalDate.now());
        Date fechaDevolucion = Date.valueOf(LocalDate.now().plusDays(15));
        boolean multa = false;

        // Crear un nuevo objeto ClaseEstudiante
        ClasePrestamo prestamo = new ClasePrestamo();
        prestamo.setCedula(cedula);
        prestamo.setIdLibro(idLibro);
        prestamo.setFechaPrestamo(fechaPrestamo);
        prestamo.setFechaDevolucion(fechaDevolucion);
        prestamo.setMulta(multa);

        // Guardar el estudiante utilizando Hibernate
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(prestamo); // Guardar el estudiante en la base de datos
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar el error, por ejemplo, redirigir a una página de error
            response.sendRedirect("error.jsp");
            return;
        }
        doGet(request, response);
    }

    @Override
    public void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}