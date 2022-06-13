package co.edu.unbosque.proyecto.Pojo;

public class PrioridadPojo {

    private Integer idPrioridad;

    private String descripcion;

    private String estado;

    public PrioridadPojo(Integer idPrioridad, String descripcion, String estado) {
        this.idPrioridad = idPrioridad;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Integer idPrioridad) {
        this.idPrioridad = idPrioridad;
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
}
