package logica;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestorCuenta {
    public GestorCuenta() {

    }

    //Recibe el nombre y que cosa es
    public static ClaseEstudiante nuevoRegistro(String cedula, String nombre, String direccion, String telefono, String codigo, String correo){
        ClaseEstudiante estudiante = new ClaseEstudiante();
        estudiante.setCedula(cedula);
        estudiante.setNombre(nombre);
        estudiante.setDireccion(direccion);
        estudiante.setTelefono(telefono);
        estudiante.setCodigoUnico(codigo);
        estudiante.setCorreoElectronico(correo);
        if (validarDatosRegistro(estudiante)){
            return RegistroBibliotecario.registrarEstudiante(estudiante);
        }
        return null;
    }

    public static boolean validarDatosRegistro(ClaseEstudiante estudiante){
        String cedula = estudiante.getCedula();
        String nombre = estudiante.getNombre();
        String telefono = estudiante.getTelefono();
        String codigo = estudiante.getCodigoUnico();
        
        if (cedula.length() != 10){
            return false;
        } else if (!nombre.equals("")) {
            String regex = "^[a-zA-Z]+$";
            // Compilar la expresión regular
            Pattern pattern = Pattern.compile(regex);
            // Crear un objeto Matcher
            Matcher matcher = pattern.matcher(nombre);
            if (matcher.matches() == false)
                return false;
        } else if (telefono.length() != 10) {
            return false;
        } else if (codigo.length() != 9) {
            return false;
        }
        return true;
    }


    public static boolean validarNombre(String input) {
        // La expresión regular permite solo letras mayúsculas y minúsculas
        String regex = "^[a-zA-Z]+$";

        // Compilar la expresión regular
        Pattern pattern = Pattern.compile(regex);

        // Crear un objeto Matcher
        Matcher matcher = pattern.matcher(input);

        // Verificar si la cadena coincide con la expresión regular
        return matcher.matches();
    }
}
