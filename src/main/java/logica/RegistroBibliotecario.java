package logica;
import java.util.ArrayList;
import java.util.List;

public class RegistroBibliotecario {

    public RegistroBibliotecario() {
    }

    public static List<ClaseLibro> verificarLibrosDisponibles(List<ClaseLibro> listaLibros) {
        List<ClaseLibro> librosValidos = new ArrayList<>();

        for (ClaseLibro libro : listaLibros) {
            if (libro.getDisponibilidad() == true) {
                librosValidos.add(libro);
            }
        }
        return librosValidos;
    }

    public static ClaseEstudiante registrarEstudiante(ClaseEstudiante estudiante){
        return estudiante;
    }


}

