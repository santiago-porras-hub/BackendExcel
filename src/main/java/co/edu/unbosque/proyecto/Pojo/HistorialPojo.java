package co.edu.unbosque.proyecto.Pojo;

import java.util.Date;

public class HistorialPojo {

    private Integer id;
    private String descripcion;
    private String estado;
    private Date fecha;
    private Integer usuario_id;

    public HistorialPojo(){

    }

    public HistorialPojo(Integer id, String descripcion, String estado, Date fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }
}
