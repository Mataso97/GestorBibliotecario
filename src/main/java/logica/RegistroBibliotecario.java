package logica;
import java.util.ArrayList;
import java.util.List;
import logica.ClaseLibro;

public class RegistroBibliotecario {

    public RegistroBibliotecario() {
    }

    public static List<ClaseLibro> validarLibros(List<ClaseLibro> listaLibros) {
        List<ClaseLibro> librosValidos = new ArrayList<>();

        for (ClaseLibro libro : listaLibros) {
            if (libro.getDisponibilidad() == true) {
                librosValidos.add(libro);
            }
        }
        return librosValidos;
    }

}

