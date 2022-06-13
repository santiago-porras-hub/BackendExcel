package co.edu.unbosque.proyecto.models;


import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prioridad database table.
 *
 */
@Entity
@NamedQuery(name="Prioridad.findAll", query="SELECT p FROM Prioridad p")
public class Prioridad implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_prioridad")
    private Integer idPrioridad;

    private String descripcion;

    private String estado;

    //bi-directional many-to-one association to Usuario
    @OneToMany(mappedBy = "prioridad")
    private List<Usuario> usuarios;

    public Prioridad() {
    }

    public Integer getIdPrioridad() {
        return this.idPrioridad;
    }

    public void setIdPrioridad(Integer idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario addUsuario(Usuario usuario) {
        getUsuarios().add(usuario);
        usuario.setPrioridad(this);

        return usuario;
    }

    public Usuario removeUsuario(Usuario usuario) {
        getUsuarios().remove(usuario);
        usuario.setPrioridad(null);
        return usuario;
    }

}
