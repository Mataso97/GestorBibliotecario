package logica;

public class GestorCuenta {
    public GestorCuenta() {

    }

    //Recibe el nombre y que cosa es
    public static ClaseEstudiante registrarEstudiante(String cedula, String nombre, String direccion, String telefono, String codigo, String correo){
        ClaseEstudiante estudiante = new ClaseEstudiante();
        estudiante.setCedula(cedula);
        estudiante.setNombre(nombre);
        estudiante.setDireccion(direccion);
        estudiante.setTelefono(telefono);
        estudiante.setCodigoUnico(codigo);
        estudiante.setCorreoElectronico(correo);

        return estudiante;
    }
}
