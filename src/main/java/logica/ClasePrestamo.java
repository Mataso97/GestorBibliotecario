package logica;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "prestamo", schema = "gestorbibliotecario")
public class ClasePrestamo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idPrestamo", nullable = false)
    private int idPrestamo;
    @Basic
    @Column(name = "cedula", nullable = true, length = 255)
    private String cedula;
    @Basic
    @Column(name = "idLibro", nullable = true, length = 255)
    private String idLibro;
    @Basic
    @Column(name = "fechaPrestamo", nullable = true)
    private Date fechaPrestamo;
    @Basic
    @Column(name = "fechaDevolucion", nullable = true)
    private Date fechaDevolucion;
    @Basic
    @Column(name = "multa", nullable = true)
    private Boolean multa;

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Boolean getMulta() {
        return multa;
    }

    public void setMulta(Boolean multa) {
        this.multa = multa;
    }

    public static boolean solicitarPrestamo(String cedula, String idLibro){
        return Administrador.validarPrestamo(cedula, idLibro);
    }
}
