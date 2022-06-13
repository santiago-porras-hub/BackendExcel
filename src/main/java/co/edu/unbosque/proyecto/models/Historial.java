package co.edu.unbosque.proyecto.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the historial database table.
 *
 */
@Entity
@NamedQuery(name="Historial.findAll", query="SELECT h FROM Historial h")
public class Historial implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_auditoria")
    private Integer idAuditoria;

    private String descripcion;

    private String estado;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    //bi-directional many-to-one association to Usuario
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    public Historial() {
    }

    public Historial(Integer idAuditoria, String descripcion, String estado, Date fecha) {
        this.idAuditoria = idAuditoria;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Integer getIdAuditoria() {
        return this.idAuditoria;
    }

    public void setIdAuditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
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

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}