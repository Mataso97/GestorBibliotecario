package logica;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante", schema = "gestorbibliotecario")
public class ClaseEstudiante {
    @Id
    @Column(name = "cedula", nullable = false, length = 10)
    private String cedula;
    @Basic
    @Column(name = "nombre", nullable = true, length = 255)
    private String nombre;
    @Basic
    @Column(name = "direccion", nullable = true, length = 255)
    private String direccion;
    @Basic
    @Column(name = "telefono", nullable = true, length = 10)
    private String telefono;
    @Basic
    @Column(name = "codigoUnico", nullable = true, length = 9)
    private String codigoUnico;
    @Basic
    @Column(name = "correoElectronico", nullable = true, length = 255)
    private String correoElectronico;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClaseEstudiante that = (ClaseEstudiante) o;

        if (cedula != null ? !cedula.equals(that.cedula) : that.cedula != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (codigoUnico != null ? !codigoUnico.equals(that.codigoUnico) : that.codigoUnico != null) return false;
        if (correoElectronico != null ? !correoElectronico.equals(that.correoElectronico) : that.correoElectronico != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cedula != null ? cedula.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (codigoUnico != null ? codigoUnico.hashCode() : 0);
        result = 31 * result + (correoElectronico != null ? correoElectronico.hashCode() : 0);
        return result;
    }
}
