package co.edu.unbosque.proyecto.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 *
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;

    private String contraseña;

    private String correo;

    private String direccion;

    private String estado;

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_cambio_contra")
    private Date fechaCambioContra;

    private Integer intentos;

    private String nombre;

    private String telefono;

    //bi-directional many-to-one association to Historial
    @OneToMany(mappedBy="usuario")
    private List<Historial> historials;

    //bi-directional many-to-one association to Prioridad
    @ManyToOne
    @JoinColumn(name="id_prioridad")
    private Prioridad prioridad;

    public Usuario() {
    }

    public Usuario(Integer id, String contraseña, String correo, String direccion, String estado, Date fechaCambioContra, Integer intentos, String nombre, String telefono, List<Historial> historials, Prioridad prioridad) {
        this.id = id;
        this.contraseña = contraseña;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
        this.fechaCambioContra = fechaCambioContra;
        this.intentos = intentos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.historials = historials;
        this.prioridad = prioridad;
    }

    public Usuario(String contraseña, String correo, String direccion, String estado, Date fechaCambioContra, Integer intentos, String nombre, String telefono, List<Historial> historials, Prioridad prioridad) {
        this.contraseña = contraseña;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
        this.fechaCambioContra = fechaCambioContra;
        this.intentos = intentos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.historials = historials;
        this.prioridad = prioridad;
    }

    public Usuario(Integer id, String contraseña, String correo, String direccion, String estado, Date fechaCambioContra, Integer intentos, String nombre, String telefono, Prioridad prioridad) {
        this.id = id;
        this.contraseña = contraseña;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
        this.fechaCambioContra = fechaCambioContra;
        this.intentos = intentos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.prioridad = prioridad;
    }

    public Usuario(Integer id, String nombre, String telefono, String direccion, String correo, String contraseña, Prioridad prioridad, String estado, Integer intentos) {

        this.id = id;
        this.contraseña = contraseña;
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
        this.intentos = intentos;
        this.nombre = nombre;
        this.telefono = telefono;
        this.prioridad = prioridad;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCambioContra() {
        return this.fechaCambioContra;
    }

    public void setFechaCambioContra(Date fechaCambioContra) {
        this.fechaCambioContra = fechaCambioContra;
    }

    public Integer getIntentos() {
        return this.intentos;
    }

    public void setIntentos(Integer intentos) {
        this.intentos = intentos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Historial> getHistorials() {
        return this.historials;
    }

    public void setHistorials(List<Historial> historials) {
        this.historials = historials;
    }

    public Historial addHistorial(Historial historial) {
        getHistorials().add(historial);
        historial.setUsuario(this);

        return historial;
    }

    public Historial removeHistorial(Historial historial) {
        getHistorials().remove(historial);
        historial.setUsuario(null);

        return historial;
    }

    public Prioridad getPrioridad() {
        return this.prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

}