package logica;

import jakarta.persistence.*;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClaseLibro that = (ClaseLibro) o;

        if (idLibro != null ? !idLibro.equals(that.idLibro) : that.idLibro != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (autor != null ? !autor.equals(that.autor) : that.autor != null) return false;
        if (genero != null ? !genero.equals(that.genero) : that.genero != null) return false;
        if (disponibilidad != null ? !disponibilidad.equals(that.disponibilidad) : that.disponibilidad != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLibro != null ? idLibro.hashCode() : 0;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (genero != null ? genero.hashCode() : 0);
        result = 31 * result + (disponibilidad != null ? disponibilidad.hashCode() : 0);
        return result;
    }
}
